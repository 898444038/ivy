package com.ivy.tools.generate.template.test;

import com.ivy.tools.generate.template.core.GenerateTemplate;

/**
 * Created by Administrator on 2020/4/13 0013.
 */
public class TestGenerate {
    public static void main(String[] args) {
        try {
            GenerateTemplate.getInstance().create(new String[]{"com.ivy.tools.generate.template"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
