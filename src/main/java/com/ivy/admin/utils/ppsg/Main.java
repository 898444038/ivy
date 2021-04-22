package com.ivy.admin.utils.ppsg;

import com.ivy.admin.entity.ppsg.General;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<General> list = MainService.getExcelData();
        System.out.println("");
    }

}
