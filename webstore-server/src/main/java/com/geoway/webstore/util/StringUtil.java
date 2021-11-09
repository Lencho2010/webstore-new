package com.geoway.webstore.util;

import org.mozilla.universalchardet.UniversalDetector;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Lencho
 * @CreateTime: 2021/11/4 19:52
 * @Description:
 */
public class StringUtil {
    private final static String PHONE_REGEX = "^((13[0-9])|(14[5,7,9])|(15[^4])|(198)|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
    private final static String EMAIL_REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    private final static String IP_REGEX = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";

    public static boolean isMobile(String mobile) {
        /*
         * 判断字符串是否符合手机号码格式
         * 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
         * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
         * 电信号段: 133,149,153,170,173,177,180,181,189
         * 新增号段: 198
         * @param str
         * @return 待检测的字符串
         *"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
         */
        if (isEmpty(mobile)) {
            return false;
        } else {
            return mobile.matches(PHONE_REGEX);
        }
    }

    public static boolean isEmail(String email) {
        if (isEmpty(email)) {
            return false;
        } else {
            return email.matches(EMAIL_REGEX);
        }
    }

    public static boolean isIp(String ip) {
        if (isEmpty(ip)) {
            return false;
        } else {
            return ip.matches(IP_REGEX);
        }
    }

    public static boolean containsIp(String string) {
        return Pattern.compile(IP_REGEX).matcher(string).find();
    }


    public static String getIp(String string) {
        Matcher m = Pattern.compile(IP_REGEX).matcher(string);
        Assert.state(m.find(), "ip解析错误");
        return m.group();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isEmptyOrWhiteSpace(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean areNotEmpty(String str, String str1) {
        return isNotEmpty(str) && isNotEmpty(str1);
    }

    public static String parseBytes(byte[] bytes) {
        return new String(bytes, Charset.forName(getEncoding(bytes)));
    }

    public static String parseBytes(byte[] bytes, Charset charset) {
        if (charset != null) {
            return new String(bytes, charset);
        } else {
            return new String(bytes, Charset.forName(getEncoding(bytes)));
        }
    }

    public static String getEncoding(byte[] bytes) {
        String defaultEncoding = "UTF-8";
        UniversalDetector detector = new UniversalDetector(null);
        detector.handleData(bytes, 0, bytes.length);
        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        detector.reset();
        if (encoding == null) {
            encoding = defaultEncoding;
        }
        return encoding;
    }

    public static String dateString(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    public static String getTimeIntervalStr(Date startTime, Date endTime) {
        String elapsedTimeMsg = "";

        long hourResult = 0;
        long minuteResult = 0;
        long secondResult = 0;

        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        long milliSecond = 0;

        long costMillSeconds = endTime.getTime() - startTime.getTime();

        hours = costMillSeconds / 3600000;
        hourResult = costMillSeconds % 3600000;

        minutes = hourResult / 60000;
        minuteResult = hourResult % 60000;

        seconds = minuteResult / 1000;
        secondResult = minuteResult % 1000;

        milliSecond = secondResult;

        String strCostTime;
        if (hours > 0) {
            strCostTime = hours + "小时" + minutes + "分" + seconds + "秒";
        } else if (minutes > 0) {
            strCostTime = minutes + "分" + seconds + "秒";
        } else {
            double dTemp = new BigDecimal((double) milliSecond / 1000).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (seconds + dTemp < 0.1) {
                strCostTime = "0.1秒";
            } else {
                strCostTime = (seconds + dTemp) + "秒";
            }
        }

        return strCostTime;
    }
}
