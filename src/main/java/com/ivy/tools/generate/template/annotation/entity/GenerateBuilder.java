package com.ivy.tools.generate.template.annotation.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2020/3/16 0016.
 */
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface GenerateBuilder {
}
