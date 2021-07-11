package com.seeyoumeet.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;


/**
 * 数据格式化工具类
 *
 * @author Administrator
 */
public class DataFormatUtil {

    /**
     * 把double类型的数据去掉精度转换为int类型
     *
     * @param d
     * @return
     */
    public static int doubleToInt(Double d) {
        String dStr = d.toString();
        if (dStr.indexOf(".") > 0) {
            return Integer.parseInt(dStr.substring(0, dStr.indexOf(".")));
        } else {
            return Integer.parseInt(dStr);
        }
    }

    /**
     * 把String类型的数据转换为int类型
     *
     * @param s
     * @return
     */
    public static int StringToInt(String s) {
        if (s != null && !"".equals(s.trim())) {
            if (s.indexOf(".") > 0) {
                return Integer.parseInt(s.substring(0, s.indexOf(".")));
            } else {
                return Integer.parseInt(s);
            }
        } else {
            return 0;
        }
    }

    /**
     * 把String 类型的数据转换为Long类型
     *
     * @param s
     * @return s 是空则返回null
     */
    public static Long strToLong(String s) {
        if (isBlank(s)) {
            return null;
        } else {
            if (s.indexOf(".") > 0) {
                return Long.parseLong(s.substring(0, s.indexOf(".")));
            } else {
                return Long.parseLong(s);
            }
        }
    }

    /**
     * string 转 Double
     *
     * @param s
     * @return
     */
    public static Double strToDouble(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    /**
     * string到Double 的转换
     *
     * @param s
     * @return string 为空返回 null
     */
    public static Double stringToDouble(String s) {
        if (s == null || s.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            return 0d;
        }
    }

    /**
     * string 转 double
     *
     * @param s
     * @return
     * @throws NumberFormatException
     */
    public static double strTodouble(String s) throws NumberFormatException {
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    /**
     * string到Double 的转换
     *
     * @param s
     * @return string 为空返回 0
     */
    public static double stringTodouble(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0d;
        }
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            return 0d;
        }
    }

    /**
     * double转百分数
     *
     * @param d
     * @return
     */
    public static String doubleTobfStr(double d) {
        NumberFormat num = NumberFormat.getPercentInstance();
        num.setMinimumFractionDigits(0);    //setMaximumIntegerDigits(int)  设置数值的整数部分允许的最小位数。
        num.setMinimumIntegerDigits(1);  //setMinimumFractionDigits(int) 设置数值的小数部分允许的最小位数
        num.setMaximumIntegerDigits(3);  //setMaximumFractionDigits(int) 设置数值的小数部分允许的最大位数。
        num.setMaximumFractionDigits(0);  //setMaximumIntegerDigits(int)  设置数值的整数部分允许的最大位数。
        return num.format(d);
    }

    /**
     * 判断值是否为空
     *
     * @param val
     * @return 空返回 true，非空返回 false
     */
    public static boolean isBlank(String val) {
        if (val == null) {
            return true;
        } else if (val.length() == 0) {
            return true;
        } else if ("".equals(val.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 保留小数位数
     *
     * @param d        double 值
     * @param capacity 保留小数位数
     * @return
     */
    public static double decimal(double d, int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }
        StringBuffer sb = new StringBuffer();
        while (capacity > 0) {
            sb.append("0");
            capacity--;
        }
        String pattern = "0." + sb.toString();
        DecimalFormat df = new DecimalFormat(pattern);
        return stringTodouble(df.format(d));
    }

    /**
     * 进行正则匹配
     *
     * @param str   待匹配字符串
     * @param regex 正则
     * @return
     */
    public static boolean regex(String str, String regex) {
        if (isBlank(str)) {
            return false;
        }
        return str.matches(regex);
    }


}