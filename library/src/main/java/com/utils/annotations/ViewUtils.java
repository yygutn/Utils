package com.utils.annotations;

import android.content.Context;

import com.utils.annotations.framework.ContentView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Jumy on 16/1/7.
 * @Description UI注解,IOC框架
 */
public class ViewUtils {
    private static final String METHOD_SET_CONTENT_VIEW = "setContentView";
    public static void init(Context context){
        //1.通过IOC框架动态加载布局
        //1.1 首先定义布局注解
        //1.2 给布局注解类声明作用范围
        injectLayout(context);
    }

    public static void injectLayout(Context context){
        Class<? extends Context> clazz = context.getClass();
        ContentView contentView = clazz.getAnnotation(ContentView.class);
        //拿到布局ID
        int layoutId = contentView.value();
        //初始化布局
        Method setContentViewMethod = null;
        try {
            setContentViewMethod = clazz.getMethod(METHOD_SET_CONTENT_VIEW,int.class);
            setContentViewMethod.invoke(context,layoutId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
