package com.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jumy on 15/12/8 下午2:44.
 * deadline is the first productivity
 */
public class StringUtil {

    public static boolean isNilOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static int dp2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    public static int px2dp(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }

    /**
     * 将秒转换为详细的时间
     * @param seconds 时间戳
     * @return 详细时间
     */
    public static String getSecondTotime(int seconds){
        Date date = new Date((long)seconds * 1000);
        Date nowDate = new Date();
        if(date.getYear() < nowDate.getYear()) return StringUtil.formatDate(seconds, "yyyy-MM-dd");
        else if(date.getMonth() < nowDate.getMonth() || date.getDate() < nowDate.getDate() - 1) return (StringUtil.formatDate(seconds, "MM-dd"));
        else if(date.getDate() == nowDate.getDate() - 1) return (StringUtil.formatDate(seconds, "昨天: HH:mm"));
        else return (StringUtil.formatDate(seconds, "今天: HH:mm"));
    }

    /**
     * 将秒转换为详细的天
     * @param seconds 时间戳
     * @return answer
     */
    public static String getSecondToday(int seconds){
        Date date = new Date((long)seconds * 1000);
        Date nowDate = new Date();
        if(date.getYear() < nowDate.getYear()) return StringUtil.formatDate(seconds, "yyyy-MM-dd");
        else if(date.getMonth() < nowDate.getMonth() || date.getDate() < nowDate.getDate() - 1) return (StringUtil.formatDate(seconds, "MM-dd"));
        else if(date.getDate() == nowDate.getDate() - 1) return ("昨天");
        else return ("今天");
    }

    /**
     * 时间转换
     * @param date date格式时间
     * @param format 格式
     * @return 时间串
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        return dateformat.format(date);
    }

    /**
     * 时间转换
     * @param second 时间戳
     * @param format 格式
     * @return 时间字符串
     */
    public static String formatDate(int second, String format) {
        return formatDate(new Date(((long) second) * 1000), format);
    }

    /**
     * 判断密码时候合法(长度6-20位)
     * @param password 要检查的密码
     * @return 是否合法(true, false)
     */
    public static boolean isPassValid(String password){
        return !(isEmpty(password) || password.length() < 6 || password.length() > 20);
    }

    public static boolean isEmpty(String s){
        return s == null || s.length() == 0;
    }

    //字体缓存
    public static Map<String, Typeface> fontCache;

    public static Typeface getFontFace(AssetManager assetManager, String name){
        try{
            if(fontCache == null){
                fontCache = new HashMap<String,Typeface>();
            }
            if(fontCache.containsKey(name)){
                return fontCache.get(name);
            }
            else {
                Typeface typeface = Typeface.createFromAsset(assetManager, name);
                fontCache.put(name, typeface);
                return typeface;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检测邮箱地址是否合法
     * @param email 需要判断的邮箱
     * @return true合法 false不合法
     */
    public static boolean isEmail(String email){
        if (null==email || "".equals(email)) return false;
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 检查手机号码是否合法
     * @param mobiles 要检查的手机号码
     * @return 是否合法(true or false)
     */
    public static boolean isMobileValid(String mobiles){
        Pattern p = Pattern.compile("^(1[3,4,5,7,8][0-9])\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
