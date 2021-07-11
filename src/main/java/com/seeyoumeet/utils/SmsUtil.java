package com.seeyoumeet.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Random;

/**
 * 短信发送工具
 */
public class SmsUtil {

    /**
     * 发送
     */
    public static void sendYd(String phone, String code) {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FkTbm1o4VALEZKkBt7h",
                "nGtwzNoG3sGuYtd4GJ8JJPVEuzJPwm");
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);
            request.setPhoneNumbers(phone);
            request.setSignName("人脸识别考勤系统");
            request.setTemplateCode("SMS_184820082");
            request.setTemplateParam("{\"code\":\"" + code + "\"}");
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {

            } else {
                System.out.println(sendSmsResponse.getMessage());
                throw new MyException("短信发送失败");
            }

        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

    public static void sendFp(String phone, String code) {
        //尊敬的VIP车主，欢迎光临停车场。为您推荐的车位为${code}号车位。
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIk0KKY1qVk1AH",
                "uz4jQHbtW6P2xJpRjZFNeaBHrzwEFE");
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);
            request.setPhoneNumbers(phone);
            request.setSignName("智能停车场");
            request.setTemplateCode("SMS_134326916");
            request.setTemplateParam("{\"code\":\"" + code + "\"}");
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {

            } else {
                System.out.println(sendSmsResponse.getMessage());
                throw new MyException("短信发送失败");
            }

        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

    public static String getCheckCode() {
        String ZiMu = "1234567890";
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(ZiMu.length());
            char c = ZiMu.charAt(index);
            result += c;
        }
        return result;
    }
}
