package com.seeyoumeet.controller;

import com.seeyoumeet.entity.SMSRecordEntity;
import com.seeyoumeet.entity.SysUserEntity;
import com.seeyoumeet.service.SMSRecordService;
import com.seeyoumeet.service.SysUserService;
import com.seeyoumeet.utils.R;
import com.seeyoumeet.utils.ShiroUtils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.seeyoumeet.utils.SmsUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 登录相关
 * 10#1:15:31
 */
@Controller
public class SysLoginController {
    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SMSRecordService SMSRecordService;

    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public R login(String username, String password, String captcha) throws IOException {
// 
// 
        try {
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            password = new Sha256Hash(password).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error(e.getMessage());
        } catch (LockedAccountException e) {
            return R.error(e.getMessage());
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }

        return R.ok();
    }

    /**
     * 获取验证码
     */
    @ResponseBody
    @RequestMapping(value = "/sys/getSmsCode", method = RequestMethod.GET)
    public R getSmsCode(String phone) throws IOException {
        Date now = new Date();
        long time = 5 * 60 * 1000;//5分钟
        Date beforeDate = new Date(now.getTime() - time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<SMSRecordEntity> SMSRecordEntities = SMSRecordService.selectByPhoneAndCreateTime(phone, sdf.format(beforeDate));
        if (null == SMSRecordEntities || SMSRecordEntities.size() == 0) {
            String checkCode = SmsUtil.getCheckCode();
            try {
                SmsUtil.sendYd(phone, checkCode);
            }catch (Exception e){

            }
            SMSRecordEntity SMSRecordEntity = new SMSRecordEntity();
            SMSRecordEntity.setPhone(phone);
            SMSRecordEntity.setCode(checkCode);
            SMSRecordEntity.setTime(now);
            SMSRecordService.save(SMSRecordEntity);
            return R.ok(checkCode);
        } else {
            return R.ok(SMSRecordEntities.get(0).getCode());
        }
    }

    /**
     * 验证码登录
     *
     * @param phone
     * @param code
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/sys/codeLogin", method = RequestMethod.POST)
    public R codeLogin(String phone, String code) throws IOException {
        try {
            SysUserEntity sysUserEntity = sysUserService.queryByPhone(phone);
            if (null == sysUserEntity) {
                return R.error("账号不存在");
            }
            Date now = new Date();
            long time = 5 * 60 * 1000;//5分钟
            Date beforeDate = new Date(now.getTime() - time);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<SMSRecordEntity> SMSRecordEntities = SMSRecordService.selectByPhoneAndCreateTime(phone, sdf.format(beforeDate));
            if (null == SMSRecordEntities || SMSRecordEntities.size() == 0) {
                return R.error("无效验证码");
            } else {
                boolean hsa = false;
                for (SMSRecordEntity item : SMSRecordEntities) {
                    if (item.getCode().equals(code)) {
                        hsa = true;
                    }
                }
                if (hsa) {
                    Subject subject = ShiroUtils.getSubject();
                    UsernamePasswordToken token = new UsernamePasswordToken(sysUserEntity.getUsername(), sysUserEntity.getPassword());
                    subject.login(token);
                } else {
                    return R.error("无效验证码");
                }
            }
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error(e.getMessage());
        } catch (LockedAccountException e) {
            return R.error(e.getMessage());
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }
        return R.ok();
    }


    /**
     *
     */
    @ResponseBody
    @RequestMapping(value = "/sys/reg", method = RequestMethod.POST)
    public R reg(String username, String password, String captcha) throws IOException {


        //sha256加密
        SysUserEntity user = new SysUserEntity();
        user.setUsername(username);
        user.setPassword(password);
        user.setStatus(1);
        user.setType("1");

        List<Long> roles = new ArrayList<>();
        roles.add(1L);

        user.setRoleIdList(roles);

        this.sysUserService.save(user);

        return R.ok();
    }

    /**
     * 退出
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "redirect:login.html";
    }

}
