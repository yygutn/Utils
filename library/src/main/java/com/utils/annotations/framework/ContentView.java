package com.utils.annotations.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Jumy on 16/1/7.
 * @Description 布局文件注解
 * @Target 作用域    TYPE--作用范围在当前这个类上面
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentView {
    int value();
}
