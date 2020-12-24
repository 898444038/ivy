package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "关卡表",tablePrefix = "ppsg",parentPackage = "ppsg")
public class Checkpoint implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("名称")
    private String name;

    @Column
    @Comment("武力")
    private Integer forces;

    @Column
    @Comment("智力")
    private Integer intellect;

    @Column
    @Comment("兵力")
    private Integer troops;

    @Column private Integer c30_1;
    @Column private Integer c30_2;
    @Column private Integer c30_3;
    @Column private Integer c30_4;
    @Column private Integer c30_5;
    @Column private Integer c30_6;
    @Column private Integer c30_7;
    @Column private Integer c30_8;
    @Column private Integer c30_9;
    @Column private Integer c30_10;
    @Column private Integer c30_11;
    @Column private Integer c30_12;

    @Column private Integer c29_1;
    @Column private Integer c29_2;
    @Column private Integer c29_3;
    @Column private Integer c29_4;
    @Column private Integer c29_5;
    @Column private Integer c29_6;
    @Column private Integer c29_7;
    @Column private Integer c29_8;
    @Column private Integer c29_9;
    @Column private Integer c29_10;
    @Column private Integer c29_11;
    @Column private Integer c29_12;

    @Column private Integer c28_1;
    @Column private Integer c28_2;
    @Column private Integer c28_3;
    @Column private Integer c28_4;
    @Column private Integer c28_5;
    @Column private Integer c28_6;
    @Column private Integer c28_7;
    @Column private Integer c28_8;
    @Column private Integer c28_9;
    @Column private Integer c28_10;
    @Column private Integer c28_11;
    @Column private Integer c28_12;

    @Column private Integer c27_1;
    @Column private Integer c27_2;
    @Column private Integer c27_3;
    @Column private Integer c27_4;
    @Column private Integer c27_5;
    @Column private Integer c27_6;
    @Column private Integer c27_7;
    @Column private Integer c27_8;
    @Column private Integer c27_9;
    @Column private Integer c27_10;
    @Column private Integer c27_11;
    @Column private Integer c27_12;

    @Column private Integer c26_1;
    @Column private Integer c26_2;
    @Column private Integer c26_3;
    @Column private Integer c26_4;
    @Column private Integer c26_5;
    @Column private Integer c26_6;
    @Column private Integer c26_7;
    @Column private Integer c26_8;
    @Column private Integer c26_9;
    @Column private Integer c26_10;
    @Column private Integer c26_11;
    @Column private Integer c26_12;

    @Column private Integer c25_1;
    @Column private Integer c25_2;
    @Column private Integer c25_3;
    @Column private Integer c25_4;
    @Column private Integer c25_5;
    @Column private Integer c25_6;
    @Column private Integer c25_7;
    @Column private Integer c25_8;
    @Column private Integer c25_9;
    @Column private Integer c25_10;
    @Column private Integer c25_11;
    @Column private Integer c25_12;

    @Column private Integer c24_1;
    @Column private Integer c24_2;
    @Column private Integer c24_3;
    @Column private Integer c24_4;
    @Column private Integer c24_5;
    @Column private Integer c24_6;
    @Column private Integer c24_7;
    @Column private Integer c24_8;
    @Column private Integer c24_9;
    @Column private Integer c24_10;
    @Column private Integer c24_11;
    @Column private Integer c24_12;

    @Column private Integer c23_1;
    @Column private Integer c23_2;
    @Column private Integer c23_3;
    @Column private Integer c23_4;
    @Column private Integer c23_5;
    @Column private Integer c23_6;
    @Column private Integer c23_7;
    @Column private Integer c23_8;
    @Column private Integer c23_9;
    @Column private Integer c23_10;
    @Column private Integer c23_11;
    @Column private Integer c23_12;

    @Column private Integer c22_1;
    @Column private Integer c22_2;
    @Column private Integer c22_3;
    @Column private Integer c22_4;
    @Column private Integer c22_5;
    @Column private Integer c22_6;
    @Column private Integer c22_7;
    @Column private Integer c22_8;
    @Column private Integer c22_9;
    @Column private Integer c22_10;
    @Column private Integer c22_11;
    @Column private Integer c22_12;

    @Column private Integer c21_1;
    @Column private Integer c21_2;
    @Column private Integer c21_3;
    @Column private Integer c21_4;
    @Column private Integer c21_5;
    @Column private Integer c21_6;
    @Column private Integer c21_7;
    @Column private Integer c21_8;
    @Column private Integer c21_9;
    @Column private Integer c21_10;
    @Column private Integer c21_11;
    @Column private Integer c21_12;

    @Column private Integer c20_1;
    @Column private Integer c20_2;
    @Column private Integer c20_3;
    @Column private Integer c20_4;
    @Column private Integer c20_5;
    @Column private Integer c20_6;
    @Column private Integer c20_7;
    @Column private Integer c20_8;
    @Column private Integer c20_9;
    @Column private Integer c20_10;
    @Column private Integer c20_11;
    @Column private Integer c20_12;

    @Column private Integer c19_1;
    @Column private Integer c19_2;
    @Column private Integer c19_3;
    @Column private Integer c19_4;
    @Column private Integer c19_5;
    @Column private Integer c19_6;
    @Column private Integer c19_7;
    @Column private Integer c19_8;
    @Column private Integer c19_9;
    @Column private Integer c19_10;
    @Column private Integer c19_11;
    @Column private Integer c19_12;

    @Column private Integer c18_1;
    @Column private Integer c18_2;
    @Column private Integer c18_3;
    @Column private Integer c18_4;
    @Column private Integer c18_5;
    @Column private Integer c18_6;
    @Column private Integer c18_7;
    @Column private Integer c18_8;
    @Column private Integer c18_9;
    @Column private Integer c18_10;
    @Column private Integer c18_11;
    @Column private Integer c18_12;

    @Column private Integer c17_1;
    @Column private Integer c17_2;
    @Column private Integer c17_3;
    @Column private Integer c17_4;
    @Column private Integer c17_5;
    @Column private Integer c17_6;
    @Column private Integer c17_7;
    @Column private Integer c17_8;
    @Column private Integer c17_9;
    @Column private Integer c17_10;
    @Column private Integer c17_11;
    @Column private Integer c17_12;

    @Column private Integer c16_1;
    @Column private Integer c16_2;
    @Column private Integer c16_3;
    @Column private Integer c16_4;
    @Column private Integer c16_5;
    @Column private Integer c16_6;
    @Column private Integer c16_7;
    @Column private Integer c16_8;
    @Column private Integer c16_9;
    @Column private Integer c16_10;
    @Column private Integer c16_11;
    @Column private Integer c16_12;

    @Column private Integer c15_1;
    @Column private Integer c15_2;
    @Column private Integer c15_3;
    @Column private Integer c15_4;
    @Column private Integer c15_5;
    @Column private Integer c15_6;
    @Column private Integer c15_7;
    @Column private Integer c15_8;
    @Column private Integer c15_9;
    @Column private Integer c15_10;
    @Column private Integer c15_11;
    @Column private Integer c15_12;

    @Column private Integer c14_1;
    @Column private Integer c14_2;
    @Column private Integer c14_3;
    @Column private Integer c14_4;
    @Column private Integer c14_5;
    @Column private Integer c14_6;
    @Column private Integer c14_7;
    @Column private Integer c14_8;
    @Column private Integer c14_9;
    @Column private Integer c14_10;
    @Column private Integer c14_11;
    @Column private Integer c14_12;

    @Column private Integer c13_1;
    @Column private Integer c13_2;
    @Column private Integer c13_3;
    @Column private Integer c13_4;
    @Column private Integer c13_5;
    @Column private Integer c13_6;
    @Column private Integer c13_7;
    @Column private Integer c13_8;
    @Column private Integer c13_9;
    @Column private Integer c13_10;
    @Column private Integer c13_11;
    @Column private Integer c13_12;

    @Column private Integer c12_1;
    @Column private Integer c12_2;
    @Column private Integer c12_3;
    @Column private Integer c12_4;
    @Column private Integer c12_5;
    @Column private Integer c12_6;
    @Column private Integer c12_7;
    @Column private Integer c12_8;
    @Column private Integer c12_9;
    @Column private Integer c12_10;
    @Column private Integer c12_11;
    @Column private Integer c12_12;

    @Column private Integer c11_1;
    @Column private Integer c11_2;
    @Column private Integer c11_3;
    @Column private Integer c11_4;
    @Column private Integer c11_5;
    @Column private Integer c11_6;
    @Column private Integer c11_7;
    @Column private Integer c11_8;
    @Column private Integer c11_9;
    @Column private Integer c11_10;
    @Column private Integer c11_11;
    @Column private Integer c11_12;

    @Column private Integer c10_1;
    @Column private Integer c10_2;
    @Column private Integer c10_3;
    @Column private Integer c10_4;
    @Column private Integer c10_5;
    @Column private Integer c10_6;
    @Column private Integer c10_7;
    @Column private Integer c10_8;
    @Column private Integer c10_9;
    @Column private Integer c10_10;
    @Column private Integer c10_11;
    @Column private Integer c10_12;

    @Column private Integer c9_1;
    @Column private Integer c9_2;
    @Column private Integer c9_3;
    @Column private Integer c9_4;
    @Column private Integer c9_5;
    @Column private Integer c9_6;
    @Column private Integer c9_7;
    @Column private Integer c9_8;
    @Column private Integer c9_9;
    @Column private Integer c9_10;
    @Column private Integer c9_11;
    @Column private Integer c9_12;

    @Column private Integer c8_1;
    @Column private Integer c8_2;
    @Column private Integer c8_3;
    @Column private Integer c8_4;
    @Column private Integer c8_5;
    @Column private Integer c8_6;
    @Column private Integer c8_7;
    @Column private Integer c8_8;
    @Column private Integer c8_9;
    @Column private Integer c8_10;
    @Column private Integer c8_11;
    @Column private Integer c8_12;

    @Column private Integer c7_1;
    @Column private Integer c7_2;
    @Column private Integer c7_3;
    @Column private Integer c7_4;
    @Column private Integer c7_5;
    @Column private Integer c7_6;
    @Column private Integer c7_7;
    @Column private Integer c7_8;
    @Column private Integer c7_9;
    @Column private Integer c7_10;
    @Column private Integer c7_11;
    @Column private Integer c7_12;

    @Column private Integer c6_1;
    @Column private Integer c6_2;
    @Column private Integer c6_3;
    @Column private Integer c6_4;
    @Column private Integer c6_5;
    @Column private Integer c6_6;
    @Column private Integer c6_7;
    @Column private Integer c6_8;
    @Column private Integer c6_9;
    @Column private Integer c6_10;
    @Column private Integer c6_11;
    @Column private Integer c6_12;

    @Column private Integer c5_1;
    @Column private Integer c5_2;
    @Column private Integer c5_3;
    @Column private Integer c5_4;
    @Column private Integer c5_5;
    @Column private Integer c5_6;
    @Column private Integer c5_7;
    @Column private Integer c5_8;
    @Column private Integer c5_9;
    @Column private Integer c5_10;
    @Column private Integer c5_11;
    @Column private Integer c5_12;

    @Column private Integer c4_1;
    @Column private Integer c4_2;
    @Column private Integer c4_3;
    @Column private Integer c4_4;
    @Column private Integer c4_5;
    @Column private Integer c4_6;
    @Column private Integer c4_7;
    @Column private Integer c4_8;
    @Column private Integer c4_9;
    @Column private Integer c4_10;
    @Column private Integer c4_11;
    @Column private Integer c4_12;

    @Column private Integer c3_1;
    @Column private Integer c3_2;
    @Column private Integer c3_3;
    @Column private Integer c3_4;
    @Column private Integer c3_5;
    @Column private Integer c3_6;
    @Column private Integer c3_7;
    @Column private Integer c3_8;
    @Column private Integer c3_9;
    @Column private Integer c3_10;
    @Column private Integer c3_11;
    @Column private Integer c3_12;

    @Column private Integer c2_1;
    @Column private Integer c2_2;
    @Column private Integer c2_3;
    @Column private Integer c2_4;
    @Column private Integer c2_5;
    @Column private Integer c2_6;
    @Column private Integer c2_7;
    @Column private Integer c2_8;
    @Column private Integer c2_9;
    @Column private Integer c2_10;
    @Column private Integer c2_11;
    @Column private Integer c2_12;

    @Column private Integer c1_1;
    @Column private Integer c1_2;
    @Column private Integer c1_3;
    @Column private Integer c1_4;
    @Column private Integer c1_5;
    @Column private Integer c1_6;
    @Column private Integer c1_7;
    @Column private Integer c1_8;
    @Column private Integer c1_9;
    @Column private Integer c1_10;
    @Column private Integer c1_11;
    @Column private Integer c1_12;

    public Checkpoint() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getForces() {
        return forces;
    }

    public void setForces(Integer forces) {
        this.forces = forces;
    }

    public Integer getIntellect() {
        return intellect;
    }

    public void setIntellect(Integer intellect) {
        this.intellect = intellect;
    }

    public Integer getTroops() {
        return troops;
    }

    public void setTroops(Integer troops) {
        this.troops = troops;
    }

    public Integer getC30_1() {
        return c30_1;
    }

    public void setC30_1(Integer c30_1) {
        this.c30_1 = c30_1;
    }

    public Integer getC30_2() {
        return c30_2;
    }

    public void setC30_2(Integer c30_2) {
        this.c30_2 = c30_2;
    }

    public Integer getC30_3() {
        return c30_3;
    }

    public void setC30_3(Integer c30_3) {
        this.c30_3 = c30_3;
    }

    public Integer getC30_4() {
        return c30_4;
    }

    public void setC30_4(Integer c30_4) {
        this.c30_4 = c30_4;
    }

    public Integer getC30_5() {
        return c30_5;
    }

    public void setC30_5(Integer c30_5) {
        this.c30_5 = c30_5;
    }

    public Integer getC30_6() {
        return c30_6;
    }

    public void setC30_6(Integer c30_6) {
        this.c30_6 = c30_6;
    }

    public Integer getC30_7() {
        return c30_7;
    }

    public void setC30_7(Integer c30_7) {
        this.c30_7 = c30_7;
    }

    public Integer getC30_8() {
        return c30_8;
    }

    public void setC30_8(Integer c30_8) {
        this.c30_8 = c30_8;
    }

    public Integer getC30_9() {
        return c30_9;
    }

    public void setC30_9(Integer c30_9) {
        this.c30_9 = c30_9;
    }

    public Integer getC30_10() {
        return c30_10;
    }

    public void setC30_10(Integer c30_10) {
        this.c30_10 = c30_10;
    }

    public Integer getC30_11() {
        return c30_11;
    }

    public void setC30_11(Integer c30_11) {
        this.c30_11 = c30_11;
    }

    public Integer getC30_12() {
        return c30_12;
    }

    public void setC30_12(Integer c30_12) {
        this.c30_12 = c30_12;
    }

    public Integer getC29_1() {
        return c29_1;
    }

    public void setC29_1(Integer c29_1) {
        this.c29_1 = c29_1;
    }

    public Integer getC29_2() {
        return c29_2;
    }

    public void setC29_2(Integer c29_2) {
        this.c29_2 = c29_2;
    }

    public Integer getC29_3() {
        return c29_3;
    }

    public void setC29_3(Integer c29_3) {
        this.c29_3 = c29_3;
    }

    public Integer getC29_4() {
        return c29_4;
    }

    public void setC29_4(Integer c29_4) {
        this.c29_4 = c29_4;
    }

    public Integer getC29_5() {
        return c29_5;
    }

    public void setC29_5(Integer c29_5) {
        this.c29_5 = c29_5;
    }

    public Integer getC29_6() {
        return c29_6;
    }

    public void setC29_6(Integer c29_6) {
        this.c29_6 = c29_6;
    }

    public Integer getC29_7() {
        return c29_7;
    }

    public void setC29_7(Integer c29_7) {
        this.c29_7 = c29_7;
    }

    public Integer getC29_8() {
        return c29_8;
    }

    public void setC29_8(Integer c29_8) {
        this.c29_8 = c29_8;
    }

    public Integer getC29_9() {
        return c29_9;
    }

    public void setC29_9(Integer c29_9) {
        this.c29_9 = c29_9;
    }

    public Integer getC29_10() {
        return c29_10;
    }

    public void setC29_10(Integer c29_10) {
        this.c29_10 = c29_10;
    }

    public Integer getC29_11() {
        return c29_11;
    }

    public void setC29_11(Integer c29_11) {
        this.c29_11 = c29_11;
    }

    public Integer getC29_12() {
        return c29_12;
    }

    public void setC29_12(Integer c29_12) {
        this.c29_12 = c29_12;
    }

    public Integer getC28_1() {
        return c28_1;
    }

    public void setC28_1(Integer c28_1) {
        this.c28_1 = c28_1;
    }

    public Integer getC28_2() {
        return c28_2;
    }

    public void setC28_2(Integer c28_2) {
        this.c28_2 = c28_2;
    }

    public Integer getC28_3() {
        return c28_3;
    }

    public void setC28_3(Integer c28_3) {
        this.c28_3 = c28_3;
    }

    public Integer getC28_4() {
        return c28_4;
    }

    public void setC28_4(Integer c28_4) {
        this.c28_4 = c28_4;
    }

    public Integer getC28_5() {
        return c28_5;
    }

    public void setC28_5(Integer c28_5) {
        this.c28_5 = c28_5;
    }

    public Integer getC28_6() {
        return c28_6;
    }

    public void setC28_6(Integer c28_6) {
        this.c28_6 = c28_6;
    }

    public Integer getC28_7() {
        return c28_7;
    }

    public void setC28_7(Integer c28_7) {
        this.c28_7 = c28_7;
    }

    public Integer getC28_8() {
        return c28_8;
    }

    public void setC28_8(Integer c28_8) {
        this.c28_8 = c28_8;
    }

    public Integer getC28_9() {
        return c28_9;
    }

    public void setC28_9(Integer c28_9) {
        this.c28_9 = c28_9;
    }

    public Integer getC28_10() {
        return c28_10;
    }

    public void setC28_10(Integer c28_10) {
        this.c28_10 = c28_10;
    }

    public Integer getC28_11() {
        return c28_11;
    }

    public void setC28_11(Integer c28_11) {
        this.c28_11 = c28_11;
    }

    public Integer getC28_12() {
        return c28_12;
    }

    public void setC28_12(Integer c28_12) {
        this.c28_12 = c28_12;
    }

    public Integer getC27_1() {
        return c27_1;
    }

    public void setC27_1(Integer c27_1) {
        this.c27_1 = c27_1;
    }

    public Integer getC27_2() {
        return c27_2;
    }

    public void setC27_2(Integer c27_2) {
        this.c27_2 = c27_2;
    }

    public Integer getC27_3() {
        return c27_3;
    }

    public void setC27_3(Integer c27_3) {
        this.c27_3 = c27_3;
    }

    public Integer getC27_4() {
        return c27_4;
    }

    public void setC27_4(Integer c27_4) {
        this.c27_4 = c27_4;
    }

    public Integer getC27_5() {
        return c27_5;
    }

    public void setC27_5(Integer c27_5) {
        this.c27_5 = c27_5;
    }

    public Integer getC27_6() {
        return c27_6;
    }

    public void setC27_6(Integer c27_6) {
        this.c27_6 = c27_6;
    }

    public Integer getC27_7() {
        return c27_7;
    }

    public void setC27_7(Integer c27_7) {
        this.c27_7 = c27_7;
    }

    public Integer getC27_8() {
        return c27_8;
    }

    public void setC27_8(Integer c27_8) {
        this.c27_8 = c27_8;
    }

    public Integer getC27_9() {
        return c27_9;
    }

    public void setC27_9(Integer c27_9) {
        this.c27_9 = c27_9;
    }

    public Integer getC27_10() {
        return c27_10;
    }

    public void setC27_10(Integer c27_10) {
        this.c27_10 = c27_10;
    }

    public Integer getC27_11() {
        return c27_11;
    }

    public void setC27_11(Integer c27_11) {
        this.c27_11 = c27_11;
    }

    public Integer getC27_12() {
        return c27_12;
    }

    public void setC27_12(Integer c27_12) {
        this.c27_12 = c27_12;
    }

    public Integer getC26_1() {
        return c26_1;
    }

    public void setC26_1(Integer c26_1) {
        this.c26_1 = c26_1;
    }

    public Integer getC26_2() {
        return c26_2;
    }

    public void setC26_2(Integer c26_2) {
        this.c26_2 = c26_2;
    }

    public Integer getC26_3() {
        return c26_3;
    }

    public void setC26_3(Integer c26_3) {
        this.c26_3 = c26_3;
    }

    public Integer getC26_4() {
        return c26_4;
    }

    public void setC26_4(Integer c26_4) {
        this.c26_4 = c26_4;
    }

    public Integer getC26_5() {
        return c26_5;
    }

    public void setC26_5(Integer c26_5) {
        this.c26_5 = c26_5;
    }

    public Integer getC26_6() {
        return c26_6;
    }

    public void setC26_6(Integer c26_6) {
        this.c26_6 = c26_6;
    }

    public Integer getC26_7() {
        return c26_7;
    }

    public void setC26_7(Integer c26_7) {
        this.c26_7 = c26_7;
    }

    public Integer getC26_8() {
        return c26_8;
    }

    public void setC26_8(Integer c26_8) {
        this.c26_8 = c26_8;
    }

    public Integer getC26_9() {
        return c26_9;
    }

    public void setC26_9(Integer c26_9) {
        this.c26_9 = c26_9;
    }

    public Integer getC26_10() {
        return c26_10;
    }

    public void setC26_10(Integer c26_10) {
        this.c26_10 = c26_10;
    }

    public Integer getC26_11() {
        return c26_11;
    }

    public void setC26_11(Integer c26_11) {
        this.c26_11 = c26_11;
    }

    public Integer getC26_12() {
        return c26_12;
    }

    public void setC26_12(Integer c26_12) {
        this.c26_12 = c26_12;
    }

    public Integer getC25_1() {
        return c25_1;
    }

    public void setC25_1(Integer c25_1) {
        this.c25_1 = c25_1;
    }

    public Integer getC25_2() {
        return c25_2;
    }

    public void setC25_2(Integer c25_2) {
        this.c25_2 = c25_2;
    }

    public Integer getC25_3() {
        return c25_3;
    }

    public void setC25_3(Integer c25_3) {
        this.c25_3 = c25_3;
    }

    public Integer getC25_4() {
        return c25_4;
    }

    public void setC25_4(Integer c25_4) {
        this.c25_4 = c25_4;
    }

    public Integer getC25_5() {
        return c25_5;
    }

    public void setC25_5(Integer c25_5) {
        this.c25_5 = c25_5;
    }

    public Integer getC25_6() {
        return c25_6;
    }

    public void setC25_6(Integer c25_6) {
        this.c25_6 = c25_6;
    }

    public Integer getC25_7() {
        return c25_7;
    }

    public void setC25_7(Integer c25_7) {
        this.c25_7 = c25_7;
    }

    public Integer getC25_8() {
        return c25_8;
    }

    public void setC25_8(Integer c25_8) {
        this.c25_8 = c25_8;
    }

    public Integer getC25_9() {
        return c25_9;
    }

    public void setC25_9(Integer c25_9) {
        this.c25_9 = c25_9;
    }

    public Integer getC25_10() {
        return c25_10;
    }

    public void setC25_10(Integer c25_10) {
        this.c25_10 = c25_10;
    }

    public Integer getC25_11() {
        return c25_11;
    }

    public void setC25_11(Integer c25_11) {
        this.c25_11 = c25_11;
    }

    public Integer getC25_12() {
        return c25_12;
    }

    public void setC25_12(Integer c25_12) {
        this.c25_12 = c25_12;
    }

    public Integer getC24_1() {
        return c24_1;
    }

    public void setC24_1(Integer c24_1) {
        this.c24_1 = c24_1;
    }

    public Integer getC24_2() {
        return c24_2;
    }

    public void setC24_2(Integer c24_2) {
        this.c24_2 = c24_2;
    }

    public Integer getC24_3() {
        return c24_3;
    }

    public void setC24_3(Integer c24_3) {
        this.c24_3 = c24_3;
    }

    public Integer getC24_4() {
        return c24_4;
    }

    public void setC24_4(Integer c24_4) {
        this.c24_4 = c24_4;
    }

    public Integer getC24_5() {
        return c24_5;
    }

    public void setC24_5(Integer c24_5) {
        this.c24_5 = c24_5;
    }

    public Integer getC24_6() {
        return c24_6;
    }

    public void setC24_6(Integer c24_6) {
        this.c24_6 = c24_6;
    }

    public Integer getC24_7() {
        return c24_7;
    }

    public void setC24_7(Integer c24_7) {
        this.c24_7 = c24_7;
    }

    public Integer getC24_8() {
        return c24_8;
    }

    public void setC24_8(Integer c24_8) {
        this.c24_8 = c24_8;
    }

    public Integer getC24_9() {
        return c24_9;
    }

    public void setC24_9(Integer c24_9) {
        this.c24_9 = c24_9;
    }

    public Integer getC24_10() {
        return c24_10;
    }

    public void setC24_10(Integer c24_10) {
        this.c24_10 = c24_10;
    }

    public Integer getC24_11() {
        return c24_11;
    }

    public void setC24_11(Integer c24_11) {
        this.c24_11 = c24_11;
    }

    public Integer getC24_12() {
        return c24_12;
    }

    public void setC24_12(Integer c24_12) {
        this.c24_12 = c24_12;
    }

    public Integer getC23_1() {
        return c23_1;
    }

    public void setC23_1(Integer c23_1) {
        this.c23_1 = c23_1;
    }

    public Integer getC23_2() {
        return c23_2;
    }

    public void setC23_2(Integer c23_2) {
        this.c23_2 = c23_2;
    }

    public Integer getC23_3() {
        return c23_3;
    }

    public void setC23_3(Integer c23_3) {
        this.c23_3 = c23_3;
    }

    public Integer getC23_4() {
        return c23_4;
    }

    public void setC23_4(Integer c23_4) {
        this.c23_4 = c23_4;
    }

    public Integer getC23_5() {
        return c23_5;
    }

    public void setC23_5(Integer c23_5) {
        this.c23_5 = c23_5;
    }

    public Integer getC23_6() {
        return c23_6;
    }

    public void setC23_6(Integer c23_6) {
        this.c23_6 = c23_6;
    }

    public Integer getC23_7() {
        return c23_7;
    }

    public void setC23_7(Integer c23_7) {
        this.c23_7 = c23_7;
    }

    public Integer getC23_8() {
        return c23_8;
    }

    public void setC23_8(Integer c23_8) {
        this.c23_8 = c23_8;
    }

    public Integer getC23_9() {
        return c23_9;
    }

    public void setC23_9(Integer c23_9) {
        this.c23_9 = c23_9;
    }

    public Integer getC23_10() {
        return c23_10;
    }

    public void setC23_10(Integer c23_10) {
        this.c23_10 = c23_10;
    }

    public Integer getC23_11() {
        return c23_11;
    }

    public void setC23_11(Integer c23_11) {
        this.c23_11 = c23_11;
    }

    public Integer getC23_12() {
        return c23_12;
    }

    public void setC23_12(Integer c23_12) {
        this.c23_12 = c23_12;
    }

    public Integer getC22_1() {
        return c22_1;
    }

    public void setC22_1(Integer c22_1) {
        this.c22_1 = c22_1;
    }

    public Integer getC22_2() {
        return c22_2;
    }

    public void setC22_2(Integer c22_2) {
        this.c22_2 = c22_2;
    }

    public Integer getC22_3() {
        return c22_3;
    }

    public void setC22_3(Integer c22_3) {
        this.c22_3 = c22_3;
    }

    public Integer getC22_4() {
        return c22_4;
    }

    public void setC22_4(Integer c22_4) {
        this.c22_4 = c22_4;
    }

    public Integer getC22_5() {
        return c22_5;
    }

    public void setC22_5(Integer c22_5) {
        this.c22_5 = c22_5;
    }

    public Integer getC22_6() {
        return c22_6;
    }

    public void setC22_6(Integer c22_6) {
        this.c22_6 = c22_6;
    }

    public Integer getC22_7() {
        return c22_7;
    }

    public void setC22_7(Integer c22_7) {
        this.c22_7 = c22_7;
    }

    public Integer getC22_8() {
        return c22_8;
    }

    public void setC22_8(Integer c22_8) {
        this.c22_8 = c22_8;
    }

    public Integer getC22_9() {
        return c22_9;
    }

    public void setC22_9(Integer c22_9) {
        this.c22_9 = c22_9;
    }

    public Integer getC22_10() {
        return c22_10;
    }

    public void setC22_10(Integer c22_10) {
        this.c22_10 = c22_10;
    }

    public Integer getC22_11() {
        return c22_11;
    }

    public void setC22_11(Integer c22_11) {
        this.c22_11 = c22_11;
    }

    public Integer getC22_12() {
        return c22_12;
    }

    public void setC22_12(Integer c22_12) {
        this.c22_12 = c22_12;
    }

    public Integer getC21_1() {
        return c21_1;
    }

    public void setC21_1(Integer c21_1) {
        this.c21_1 = c21_1;
    }

    public Integer getC21_2() {
        return c21_2;
    }

    public void setC21_2(Integer c21_2) {
        this.c21_2 = c21_2;
    }

    public Integer getC21_3() {
        return c21_3;
    }

    public void setC21_3(Integer c21_3) {
        this.c21_3 = c21_3;
    }

    public Integer getC21_4() {
        return c21_4;
    }

    public void setC21_4(Integer c21_4) {
        this.c21_4 = c21_4;
    }

    public Integer getC21_5() {
        return c21_5;
    }

    public void setC21_5(Integer c21_5) {
        this.c21_5 = c21_5;
    }

    public Integer getC21_6() {
        return c21_6;
    }

    public void setC21_6(Integer c21_6) {
        this.c21_6 = c21_6;
    }

    public Integer getC21_7() {
        return c21_7;
    }

    public void setC21_7(Integer c21_7) {
        this.c21_7 = c21_7;
    }

    public Integer getC21_8() {
        return c21_8;
    }

    public void setC21_8(Integer c21_8) {
        this.c21_8 = c21_8;
    }

    public Integer getC21_9() {
        return c21_9;
    }

    public void setC21_9(Integer c21_9) {
        this.c21_9 = c21_9;
    }

    public Integer getC21_10() {
        return c21_10;
    }

    public void setC21_10(Integer c21_10) {
        this.c21_10 = c21_10;
    }

    public Integer getC21_11() {
        return c21_11;
    }

    public void setC21_11(Integer c21_11) {
        this.c21_11 = c21_11;
    }

    public Integer getC21_12() {
        return c21_12;
    }

    public void setC21_12(Integer c21_12) {
        this.c21_12 = c21_12;
    }

    public Integer getC20_1() {
        return c20_1;
    }

    public void setC20_1(Integer c20_1) {
        this.c20_1 = c20_1;
    }

    public Integer getC20_2() {
        return c20_2;
    }

    public void setC20_2(Integer c20_2) {
        this.c20_2 = c20_2;
    }

    public Integer getC20_3() {
        return c20_3;
    }

    public void setC20_3(Integer c20_3) {
        this.c20_3 = c20_3;
    }

    public Integer getC20_4() {
        return c20_4;
    }

    public void setC20_4(Integer c20_4) {
        this.c20_4 = c20_4;
    }

    public Integer getC20_5() {
        return c20_5;
    }

    public void setC20_5(Integer c20_5) {
        this.c20_5 = c20_5;
    }

    public Integer getC20_6() {
        return c20_6;
    }

    public void setC20_6(Integer c20_6) {
        this.c20_6 = c20_6;
    }

    public Integer getC20_7() {
        return c20_7;
    }

    public void setC20_7(Integer c20_7) {
        this.c20_7 = c20_7;
    }

    public Integer getC20_8() {
        return c20_8;
    }

    public void setC20_8(Integer c20_8) {
        this.c20_8 = c20_8;
    }

    public Integer getC20_9() {
        return c20_9;
    }

    public void setC20_9(Integer c20_9) {
        this.c20_9 = c20_9;
    }

    public Integer getC20_10() {
        return c20_10;
    }

    public void setC20_10(Integer c20_10) {
        this.c20_10 = c20_10;
    }

    public Integer getC20_11() {
        return c20_11;
    }

    public void setC20_11(Integer c20_11) {
        this.c20_11 = c20_11;
    }

    public Integer getC20_12() {
        return c20_12;
    }

    public void setC20_12(Integer c20_12) {
        this.c20_12 = c20_12;
    }

    public Integer getC19_1() {
        return c19_1;
    }

    public void setC19_1(Integer c19_1) {
        this.c19_1 = c19_1;
    }

    public Integer getC19_2() {
        return c19_2;
    }

    public void setC19_2(Integer c19_2) {
        this.c19_2 = c19_2;
    }

    public Integer getC19_3() {
        return c19_3;
    }

    public void setC19_3(Integer c19_3) {
        this.c19_3 = c19_3;
    }

    public Integer getC19_4() {
        return c19_4;
    }

    public void setC19_4(Integer c19_4) {
        this.c19_4 = c19_4;
    }

    public Integer getC19_5() {
        return c19_5;
    }

    public void setC19_5(Integer c19_5) {
        this.c19_5 = c19_5;
    }

    public Integer getC19_6() {
        return c19_6;
    }

    public void setC19_6(Integer c19_6) {
        this.c19_6 = c19_6;
    }

    public Integer getC19_7() {
        return c19_7;
    }

    public void setC19_7(Integer c19_7) {
        this.c19_7 = c19_7;
    }

    public Integer getC19_8() {
        return c19_8;
    }

    public void setC19_8(Integer c19_8) {
        this.c19_8 = c19_8;
    }

    public Integer getC19_9() {
        return c19_9;
    }

    public void setC19_9(Integer c19_9) {
        this.c19_9 = c19_9;
    }

    public Integer getC19_10() {
        return c19_10;
    }

    public void setC19_10(Integer c19_10) {
        this.c19_10 = c19_10;
    }

    public Integer getC19_11() {
        return c19_11;
    }

    public void setC19_11(Integer c19_11) {
        this.c19_11 = c19_11;
    }

    public Integer getC19_12() {
        return c19_12;
    }

    public void setC19_12(Integer c19_12) {
        this.c19_12 = c19_12;
    }

    public Integer getC18_1() {
        return c18_1;
    }

    public void setC18_1(Integer c18_1) {
        this.c18_1 = c18_1;
    }

    public Integer getC18_2() {
        return c18_2;
    }

    public void setC18_2(Integer c18_2) {
        this.c18_2 = c18_2;
    }

    public Integer getC18_3() {
        return c18_3;
    }

    public void setC18_3(Integer c18_3) {
        this.c18_3 = c18_3;
    }

    public Integer getC18_4() {
        return c18_4;
    }

    public void setC18_4(Integer c18_4) {
        this.c18_4 = c18_4;
    }

    public Integer getC18_5() {
        return c18_5;
    }

    public void setC18_5(Integer c18_5) {
        this.c18_5 = c18_5;
    }

    public Integer getC18_6() {
        return c18_6;
    }

    public void setC18_6(Integer c18_6) {
        this.c18_6 = c18_6;
    }

    public Integer getC18_7() {
        return c18_7;
    }

    public void setC18_7(Integer c18_7) {
        this.c18_7 = c18_7;
    }

    public Integer getC18_8() {
        return c18_8;
    }

    public void setC18_8(Integer c18_8) {
        this.c18_8 = c18_8;
    }

    public Integer getC18_9() {
        return c18_9;
    }

    public void setC18_9(Integer c18_9) {
        this.c18_9 = c18_9;
    }

    public Integer getC18_10() {
        return c18_10;
    }

    public void setC18_10(Integer c18_10) {
        this.c18_10 = c18_10;
    }

    public Integer getC18_11() {
        return c18_11;
    }

    public void setC18_11(Integer c18_11) {
        this.c18_11 = c18_11;
    }

    public Integer getC18_12() {
        return c18_12;
    }

    public void setC18_12(Integer c18_12) {
        this.c18_12 = c18_12;
    }

    public Integer getC17_1() {
        return c17_1;
    }

    public void setC17_1(Integer c17_1) {
        this.c17_1 = c17_1;
    }

    public Integer getC17_2() {
        return c17_2;
    }

    public void setC17_2(Integer c17_2) {
        this.c17_2 = c17_2;
    }

    public Integer getC17_3() {
        return c17_3;
    }

    public void setC17_3(Integer c17_3) {
        this.c17_3 = c17_3;
    }

    public Integer getC17_4() {
        return c17_4;
    }

    public void setC17_4(Integer c17_4) {
        this.c17_4 = c17_4;
    }

    public Integer getC17_5() {
        return c17_5;
    }

    public void setC17_5(Integer c17_5) {
        this.c17_5 = c17_5;
    }

    public Integer getC17_6() {
        return c17_6;
    }

    public void setC17_6(Integer c17_6) {
        this.c17_6 = c17_6;
    }

    public Integer getC17_7() {
        return c17_7;
    }

    public void setC17_7(Integer c17_7) {
        this.c17_7 = c17_7;
    }

    public Integer getC17_8() {
        return c17_8;
    }

    public void setC17_8(Integer c17_8) {
        this.c17_8 = c17_8;
    }

    public Integer getC17_9() {
        return c17_9;
    }

    public void setC17_9(Integer c17_9) {
        this.c17_9 = c17_9;
    }

    public Integer getC17_10() {
        return c17_10;
    }

    public void setC17_10(Integer c17_10) {
        this.c17_10 = c17_10;
    }

    public Integer getC17_11() {
        return c17_11;
    }

    public void setC17_11(Integer c17_11) {
        this.c17_11 = c17_11;
    }

    public Integer getC17_12() {
        return c17_12;
    }

    public void setC17_12(Integer c17_12) {
        this.c17_12 = c17_12;
    }

    public Integer getC16_1() {
        return c16_1;
    }

    public void setC16_1(Integer c16_1) {
        this.c16_1 = c16_1;
    }

    public Integer getC16_2() {
        return c16_2;
    }

    public void setC16_2(Integer c16_2) {
        this.c16_2 = c16_2;
    }

    public Integer getC16_3() {
        return c16_3;
    }

    public void setC16_3(Integer c16_3) {
        this.c16_3 = c16_3;
    }

    public Integer getC16_4() {
        return c16_4;
    }

    public void setC16_4(Integer c16_4) {
        this.c16_4 = c16_4;
    }

    public Integer getC16_5() {
        return c16_5;
    }

    public void setC16_5(Integer c16_5) {
        this.c16_5 = c16_5;
    }

    public Integer getC16_6() {
        return c16_6;
    }

    public void setC16_6(Integer c16_6) {
        this.c16_6 = c16_6;
    }

    public Integer getC16_7() {
        return c16_7;
    }

    public void setC16_7(Integer c16_7) {
        this.c16_7 = c16_7;
    }

    public Integer getC16_8() {
        return c16_8;
    }

    public void setC16_8(Integer c16_8) {
        this.c16_8 = c16_8;
    }

    public Integer getC16_9() {
        return c16_9;
    }

    public void setC16_9(Integer c16_9) {
        this.c16_9 = c16_9;
    }

    public Integer getC16_10() {
        return c16_10;
    }

    public void setC16_10(Integer c16_10) {
        this.c16_10 = c16_10;
    }

    public Integer getC16_11() {
        return c16_11;
    }

    public void setC16_11(Integer c16_11) {
        this.c16_11 = c16_11;
    }

    public Integer getC16_12() {
        return c16_12;
    }

    public void setC16_12(Integer c16_12) {
        this.c16_12 = c16_12;
    }

    public Integer getC15_1() {
        return c15_1;
    }

    public void setC15_1(Integer c15_1) {
        this.c15_1 = c15_1;
    }

    public Integer getC15_2() {
        return c15_2;
    }

    public void setC15_2(Integer c15_2) {
        this.c15_2 = c15_2;
    }

    public Integer getC15_3() {
        return c15_3;
    }

    public void setC15_3(Integer c15_3) {
        this.c15_3 = c15_3;
    }

    public Integer getC15_4() {
        return c15_4;
    }

    public void setC15_4(Integer c15_4) {
        this.c15_4 = c15_4;
    }

    public Integer getC15_5() {
        return c15_5;
    }

    public void setC15_5(Integer c15_5) {
        this.c15_5 = c15_5;
    }

    public Integer getC15_6() {
        return c15_6;
    }

    public void setC15_6(Integer c15_6) {
        this.c15_6 = c15_6;
    }

    public Integer getC15_7() {
        return c15_7;
    }

    public void setC15_7(Integer c15_7) {
        this.c15_7 = c15_7;
    }

    public Integer getC15_8() {
        return c15_8;
    }

    public void setC15_8(Integer c15_8) {
        this.c15_8 = c15_8;
    }

    public Integer getC15_9() {
        return c15_9;
    }

    public void setC15_9(Integer c15_9) {
        this.c15_9 = c15_9;
    }

    public Integer getC15_10() {
        return c15_10;
    }

    public void setC15_10(Integer c15_10) {
        this.c15_10 = c15_10;
    }

    public Integer getC15_11() {
        return c15_11;
    }

    public void setC15_11(Integer c15_11) {
        this.c15_11 = c15_11;
    }

    public Integer getC15_12() {
        return c15_12;
    }

    public void setC15_12(Integer c15_12) {
        this.c15_12 = c15_12;
    }

    public Integer getC14_1() {
        return c14_1;
    }

    public void setC14_1(Integer c14_1) {
        this.c14_1 = c14_1;
    }

    public Integer getC14_2() {
        return c14_2;
    }

    public void setC14_2(Integer c14_2) {
        this.c14_2 = c14_2;
    }

    public Integer getC14_3() {
        return c14_3;
    }

    public void setC14_3(Integer c14_3) {
        this.c14_3 = c14_3;
    }

    public Integer getC14_4() {
        return c14_4;
    }

    public void setC14_4(Integer c14_4) {
        this.c14_4 = c14_4;
    }

    public Integer getC14_5() {
        return c14_5;
    }

    public void setC14_5(Integer c14_5) {
        this.c14_5 = c14_5;
    }

    public Integer getC14_6() {
        return c14_6;
    }

    public void setC14_6(Integer c14_6) {
        this.c14_6 = c14_6;
    }

    public Integer getC14_7() {
        return c14_7;
    }

    public void setC14_7(Integer c14_7) {
        this.c14_7 = c14_7;
    }

    public Integer getC14_8() {
        return c14_8;
    }

    public void setC14_8(Integer c14_8) {
        this.c14_8 = c14_8;
    }

    public Integer getC14_9() {
        return c14_9;
    }

    public void setC14_9(Integer c14_9) {
        this.c14_9 = c14_9;
    }

    public Integer getC14_10() {
        return c14_10;
    }

    public void setC14_10(Integer c14_10) {
        this.c14_10 = c14_10;
    }

    public Integer getC14_11() {
        return c14_11;
    }

    public void setC14_11(Integer c14_11) {
        this.c14_11 = c14_11;
    }

    public Integer getC14_12() {
        return c14_12;
    }

    public void setC14_12(Integer c14_12) {
        this.c14_12 = c14_12;
    }

    public Integer getC13_1() {
        return c13_1;
    }

    public void setC13_1(Integer c13_1) {
        this.c13_1 = c13_1;
    }

    public Integer getC13_2() {
        return c13_2;
    }

    public void setC13_2(Integer c13_2) {
        this.c13_2 = c13_2;
    }

    public Integer getC13_3() {
        return c13_3;
    }

    public void setC13_3(Integer c13_3) {
        this.c13_3 = c13_3;
    }

    public Integer getC13_4() {
        return c13_4;
    }

    public void setC13_4(Integer c13_4) {
        this.c13_4 = c13_4;
    }

    public Integer getC13_5() {
        return c13_5;
    }

    public void setC13_5(Integer c13_5) {
        this.c13_5 = c13_5;
    }

    public Integer getC13_6() {
        return c13_6;
    }

    public void setC13_6(Integer c13_6) {
        this.c13_6 = c13_6;
    }

    public Integer getC13_7() {
        return c13_7;
    }

    public void setC13_7(Integer c13_7) {
        this.c13_7 = c13_7;
    }

    public Integer getC13_8() {
        return c13_8;
    }

    public void setC13_8(Integer c13_8) {
        this.c13_8 = c13_8;
    }

    public Integer getC13_9() {
        return c13_9;
    }

    public void setC13_9(Integer c13_9) {
        this.c13_9 = c13_9;
    }

    public Integer getC13_10() {
        return c13_10;
    }

    public void setC13_10(Integer c13_10) {
        this.c13_10 = c13_10;
    }

    public Integer getC13_11() {
        return c13_11;
    }

    public void setC13_11(Integer c13_11) {
        this.c13_11 = c13_11;
    }

    public Integer getC13_12() {
        return c13_12;
    }

    public void setC13_12(Integer c13_12) {
        this.c13_12 = c13_12;
    }

    public Integer getC12_1() {
        return c12_1;
    }

    public void setC12_1(Integer c12_1) {
        this.c12_1 = c12_1;
    }

    public Integer getC12_2() {
        return c12_2;
    }

    public void setC12_2(Integer c12_2) {
        this.c12_2 = c12_2;
    }

    public Integer getC12_3() {
        return c12_3;
    }

    public void setC12_3(Integer c12_3) {
        this.c12_3 = c12_3;
    }

    public Integer getC12_4() {
        return c12_4;
    }

    public void setC12_4(Integer c12_4) {
        this.c12_4 = c12_4;
    }

    public Integer getC12_5() {
        return c12_5;
    }

    public void setC12_5(Integer c12_5) {
        this.c12_5 = c12_5;
    }

    public Integer getC12_6() {
        return c12_6;
    }

    public void setC12_6(Integer c12_6) {
        this.c12_6 = c12_6;
    }

    public Integer getC12_7() {
        return c12_7;
    }

    public void setC12_7(Integer c12_7) {
        this.c12_7 = c12_7;
    }

    public Integer getC12_8() {
        return c12_8;
    }

    public void setC12_8(Integer c12_8) {
        this.c12_8 = c12_8;
    }

    public Integer getC12_9() {
        return c12_9;
    }

    public void setC12_9(Integer c12_9) {
        this.c12_9 = c12_9;
    }

    public Integer getC12_10() {
        return c12_10;
    }

    public void setC12_10(Integer c12_10) {
        this.c12_10 = c12_10;
    }

    public Integer getC12_11() {
        return c12_11;
    }

    public void setC12_11(Integer c12_11) {
        this.c12_11 = c12_11;
    }

    public Integer getC12_12() {
        return c12_12;
    }

    public void setC12_12(Integer c12_12) {
        this.c12_12 = c12_12;
    }

    public Integer getC11_1() {
        return c11_1;
    }

    public void setC11_1(Integer c11_1) {
        this.c11_1 = c11_1;
    }

    public Integer getC11_2() {
        return c11_2;
    }

    public void setC11_2(Integer c11_2) {
        this.c11_2 = c11_2;
    }

    public Integer getC11_3() {
        return c11_3;
    }

    public void setC11_3(Integer c11_3) {
        this.c11_3 = c11_3;
    }

    public Integer getC11_4() {
        return c11_4;
    }

    public void setC11_4(Integer c11_4) {
        this.c11_4 = c11_4;
    }

    public Integer getC11_5() {
        return c11_5;
    }

    public void setC11_5(Integer c11_5) {
        this.c11_5 = c11_5;
    }

    public Integer getC11_6() {
        return c11_6;
    }

    public void setC11_6(Integer c11_6) {
        this.c11_6 = c11_6;
    }

    public Integer getC11_7() {
        return c11_7;
    }

    public void setC11_7(Integer c11_7) {
        this.c11_7 = c11_7;
    }

    public Integer getC11_8() {
        return c11_8;
    }

    public void setC11_8(Integer c11_8) {
        this.c11_8 = c11_8;
    }

    public Integer getC11_9() {
        return c11_9;
    }

    public void setC11_9(Integer c11_9) {
        this.c11_9 = c11_9;
    }

    public Integer getC11_10() {
        return c11_10;
    }

    public void setC11_10(Integer c11_10) {
        this.c11_10 = c11_10;
    }

    public Integer getC11_11() {
        return c11_11;
    }

    public void setC11_11(Integer c11_11) {
        this.c11_11 = c11_11;
    }

    public Integer getC11_12() {
        return c11_12;
    }

    public void setC11_12(Integer c11_12) {
        this.c11_12 = c11_12;
    }

    public Integer getC10_1() {
        return c10_1;
    }

    public void setC10_1(Integer c10_1) {
        this.c10_1 = c10_1;
    }

    public Integer getC10_2() {
        return c10_2;
    }

    public void setC10_2(Integer c10_2) {
        this.c10_2 = c10_2;
    }

    public Integer getC10_3() {
        return c10_3;
    }

    public void setC10_3(Integer c10_3) {
        this.c10_3 = c10_3;
    }

    public Integer getC10_4() {
        return c10_4;
    }

    public void setC10_4(Integer c10_4) {
        this.c10_4 = c10_4;
    }

    public Integer getC10_5() {
        return c10_5;
    }

    public void setC10_5(Integer c10_5) {
        this.c10_5 = c10_5;
    }

    public Integer getC10_6() {
        return c10_6;
    }

    public void setC10_6(Integer c10_6) {
        this.c10_6 = c10_6;
    }

    public Integer getC10_7() {
        return c10_7;
    }

    public void setC10_7(Integer c10_7) {
        this.c10_7 = c10_7;
    }

    public Integer getC10_8() {
        return c10_8;
    }

    public void setC10_8(Integer c10_8) {
        this.c10_8 = c10_8;
    }

    public Integer getC10_9() {
        return c10_9;
    }

    public void setC10_9(Integer c10_9) {
        this.c10_9 = c10_9;
    }

    public Integer getC10_10() {
        return c10_10;
    }

    public void setC10_10(Integer c10_10) {
        this.c10_10 = c10_10;
    }

    public Integer getC10_11() {
        return c10_11;
    }

    public void setC10_11(Integer c10_11) {
        this.c10_11 = c10_11;
    }

    public Integer getC10_12() {
        return c10_12;
    }

    public void setC10_12(Integer c10_12) {
        this.c10_12 = c10_12;
    }

    public Integer getC9_1() {
        return c9_1;
    }

    public void setC9_1(Integer c9_1) {
        this.c9_1 = c9_1;
    }

    public Integer getC9_2() {
        return c9_2;
    }

    public void setC9_2(Integer c9_2) {
        this.c9_2 = c9_2;
    }

    public Integer getC9_3() {
        return c9_3;
    }

    public void setC9_3(Integer c9_3) {
        this.c9_3 = c9_3;
    }

    public Integer getC9_4() {
        return c9_4;
    }

    public void setC9_4(Integer c9_4) {
        this.c9_4 = c9_4;
    }

    public Integer getC9_5() {
        return c9_5;
    }

    public void setC9_5(Integer c9_5) {
        this.c9_5 = c9_5;
    }

    public Integer getC9_6() {
        return c9_6;
    }

    public void setC9_6(Integer c9_6) {
        this.c9_6 = c9_6;
    }

    public Integer getC9_7() {
        return c9_7;
    }

    public void setC9_7(Integer c9_7) {
        this.c9_7 = c9_7;
    }

    public Integer getC9_8() {
        return c9_8;
    }

    public void setC9_8(Integer c9_8) {
        this.c9_8 = c9_8;
    }

    public Integer getC9_9() {
        return c9_9;
    }

    public void setC9_9(Integer c9_9) {
        this.c9_9 = c9_9;
    }

    public Integer getC9_10() {
        return c9_10;
    }

    public void setC9_10(Integer c9_10) {
        this.c9_10 = c9_10;
    }

    public Integer getC9_11() {
        return c9_11;
    }

    public void setC9_11(Integer c9_11) {
        this.c9_11 = c9_11;
    }

    public Integer getC9_12() {
        return c9_12;
    }

    public void setC9_12(Integer c9_12) {
        this.c9_12 = c9_12;
    }

    public Integer getC8_1() {
        return c8_1;
    }

    public void setC8_1(Integer c8_1) {
        this.c8_1 = c8_1;
    }

    public Integer getC8_2() {
        return c8_2;
    }

    public void setC8_2(Integer c8_2) {
        this.c8_2 = c8_2;
    }

    public Integer getC8_3() {
        return c8_3;
    }

    public void setC8_3(Integer c8_3) {
        this.c8_3 = c8_3;
    }

    public Integer getC8_4() {
        return c8_4;
    }

    public void setC8_4(Integer c8_4) {
        this.c8_4 = c8_4;
    }

    public Integer getC8_5() {
        return c8_5;
    }

    public void setC8_5(Integer c8_5) {
        this.c8_5 = c8_5;
    }

    public Integer getC8_6() {
        return c8_6;
    }

    public void setC8_6(Integer c8_6) {
        this.c8_6 = c8_6;
    }

    public Integer getC8_7() {
        return c8_7;
    }

    public void setC8_7(Integer c8_7) {
        this.c8_7 = c8_7;
    }

    public Integer getC8_8() {
        return c8_8;
    }

    public void setC8_8(Integer c8_8) {
        this.c8_8 = c8_8;
    }

    public Integer getC8_9() {
        return c8_9;
    }

    public void setC8_9(Integer c8_9) {
        this.c8_9 = c8_9;
    }

    public Integer getC8_10() {
        return c8_10;
    }

    public void setC8_10(Integer c8_10) {
        this.c8_10 = c8_10;
    }

    public Integer getC8_11() {
        return c8_11;
    }

    public void setC8_11(Integer c8_11) {
        this.c8_11 = c8_11;
    }

    public Integer getC8_12() {
        return c8_12;
    }

    public void setC8_12(Integer c8_12) {
        this.c8_12 = c8_12;
    }

    public Integer getC7_1() {
        return c7_1;
    }

    public void setC7_1(Integer c7_1) {
        this.c7_1 = c7_1;
    }

    public Integer getC7_2() {
        return c7_2;
    }

    public void setC7_2(Integer c7_2) {
        this.c7_2 = c7_2;
    }

    public Integer getC7_3() {
        return c7_3;
    }

    public void setC7_3(Integer c7_3) {
        this.c7_3 = c7_3;
    }

    public Integer getC7_4() {
        return c7_4;
    }

    public void setC7_4(Integer c7_4) {
        this.c7_4 = c7_4;
    }

    public Integer getC7_5() {
        return c7_5;
    }

    public void setC7_5(Integer c7_5) {
        this.c7_5 = c7_5;
    }

    public Integer getC7_6() {
        return c7_6;
    }

    public void setC7_6(Integer c7_6) {
        this.c7_6 = c7_6;
    }

    public Integer getC7_7() {
        return c7_7;
    }

    public void setC7_7(Integer c7_7) {
        this.c7_7 = c7_7;
    }

    public Integer getC7_8() {
        return c7_8;
    }

    public void setC7_8(Integer c7_8) {
        this.c7_8 = c7_8;
    }

    public Integer getC7_9() {
        return c7_9;
    }

    public void setC7_9(Integer c7_9) {
        this.c7_9 = c7_9;
    }

    public Integer getC7_10() {
        return c7_10;
    }

    public void setC7_10(Integer c7_10) {
        this.c7_10 = c7_10;
    }

    public Integer getC7_11() {
        return c7_11;
    }

    public void setC7_11(Integer c7_11) {
        this.c7_11 = c7_11;
    }

    public Integer getC7_12() {
        return c7_12;
    }

    public void setC7_12(Integer c7_12) {
        this.c7_12 = c7_12;
    }

    public Integer getC6_1() {
        return c6_1;
    }

    public void setC6_1(Integer c6_1) {
        this.c6_1 = c6_1;
    }

    public Integer getC6_2() {
        return c6_2;
    }

    public void setC6_2(Integer c6_2) {
        this.c6_2 = c6_2;
    }

    public Integer getC6_3() {
        return c6_3;
    }

    public void setC6_3(Integer c6_3) {
        this.c6_3 = c6_3;
    }

    public Integer getC6_4() {
        return c6_4;
    }

    public void setC6_4(Integer c6_4) {
        this.c6_4 = c6_4;
    }

    public Integer getC6_5() {
        return c6_5;
    }

    public void setC6_5(Integer c6_5) {
        this.c6_5 = c6_5;
    }

    public Integer getC6_6() {
        return c6_6;
    }

    public void setC6_6(Integer c6_6) {
        this.c6_6 = c6_6;
    }

    public Integer getC6_7() {
        return c6_7;
    }

    public void setC6_7(Integer c6_7) {
        this.c6_7 = c6_7;
    }

    public Integer getC6_8() {
        return c6_8;
    }

    public void setC6_8(Integer c6_8) {
        this.c6_8 = c6_8;
    }

    public Integer getC6_9() {
        return c6_9;
    }

    public void setC6_9(Integer c6_9) {
        this.c6_9 = c6_9;
    }

    public Integer getC6_10() {
        return c6_10;
    }

    public void setC6_10(Integer c6_10) {
        this.c6_10 = c6_10;
    }

    public Integer getC6_11() {
        return c6_11;
    }

    public void setC6_11(Integer c6_11) {
        this.c6_11 = c6_11;
    }

    public Integer getC6_12() {
        return c6_12;
    }

    public void setC6_12(Integer c6_12) {
        this.c6_12 = c6_12;
    }

    public Integer getC5_1() {
        return c5_1;
    }

    public void setC5_1(Integer c5_1) {
        this.c5_1 = c5_1;
    }

    public Integer getC5_2() {
        return c5_2;
    }

    public void setC5_2(Integer c5_2) {
        this.c5_2 = c5_2;
    }

    public Integer getC5_3() {
        return c5_3;
    }

    public void setC5_3(Integer c5_3) {
        this.c5_3 = c5_3;
    }

    public Integer getC5_4() {
        return c5_4;
    }

    public void setC5_4(Integer c5_4) {
        this.c5_4 = c5_4;
    }

    public Integer getC5_5() {
        return c5_5;
    }

    public void setC5_5(Integer c5_5) {
        this.c5_5 = c5_5;
    }

    public Integer getC5_6() {
        return c5_6;
    }

    public void setC5_6(Integer c5_6) {
        this.c5_6 = c5_6;
    }

    public Integer getC5_7() {
        return c5_7;
    }

    public void setC5_7(Integer c5_7) {
        this.c5_7 = c5_7;
    }

    public Integer getC5_8() {
        return c5_8;
    }

    public void setC5_8(Integer c5_8) {
        this.c5_8 = c5_8;
    }

    public Integer getC5_9() {
        return c5_9;
    }

    public void setC5_9(Integer c5_9) {
        this.c5_9 = c5_9;
    }

    public Integer getC5_10() {
        return c5_10;
    }

    public void setC5_10(Integer c5_10) {
        this.c5_10 = c5_10;
    }

    public Integer getC5_11() {
        return c5_11;
    }

    public void setC5_11(Integer c5_11) {
        this.c5_11 = c5_11;
    }

    public Integer getC5_12() {
        return c5_12;
    }

    public void setC5_12(Integer c5_12) {
        this.c5_12 = c5_12;
    }

    public Integer getC4_1() {
        return c4_1;
    }

    public void setC4_1(Integer c4_1) {
        this.c4_1 = c4_1;
    }

    public Integer getC4_2() {
        return c4_2;
    }

    public void setC4_2(Integer c4_2) {
        this.c4_2 = c4_2;
    }

    public Integer getC4_3() {
        return c4_3;
    }

    public void setC4_3(Integer c4_3) {
        this.c4_3 = c4_3;
    }

    public Integer getC4_4() {
        return c4_4;
    }

    public void setC4_4(Integer c4_4) {
        this.c4_4 = c4_4;
    }

    public Integer getC4_5() {
        return c4_5;
    }

    public void setC4_5(Integer c4_5) {
        this.c4_5 = c4_5;
    }

    public Integer getC4_6() {
        return c4_6;
    }

    public void setC4_6(Integer c4_6) {
        this.c4_6 = c4_6;
    }

    public Integer getC4_7() {
        return c4_7;
    }

    public void setC4_7(Integer c4_7) {
        this.c4_7 = c4_7;
    }

    public Integer getC4_8() {
        return c4_8;
    }

    public void setC4_8(Integer c4_8) {
        this.c4_8 = c4_8;
    }

    public Integer getC4_9() {
        return c4_9;
    }

    public void setC4_9(Integer c4_9) {
        this.c4_9 = c4_9;
    }

    public Integer getC4_10() {
        return c4_10;
    }

    public void setC4_10(Integer c4_10) {
        this.c4_10 = c4_10;
    }

    public Integer getC4_11() {
        return c4_11;
    }

    public void setC4_11(Integer c4_11) {
        this.c4_11 = c4_11;
    }

    public Integer getC4_12() {
        return c4_12;
    }

    public void setC4_12(Integer c4_12) {
        this.c4_12 = c4_12;
    }

    public Integer getC3_1() {
        return c3_1;
    }

    public void setC3_1(Integer c3_1) {
        this.c3_1 = c3_1;
    }

    public Integer getC3_2() {
        return c3_2;
    }

    public void setC3_2(Integer c3_2) {
        this.c3_2 = c3_2;
    }

    public Integer getC3_3() {
        return c3_3;
    }

    public void setC3_3(Integer c3_3) {
        this.c3_3 = c3_3;
    }

    public Integer getC3_4() {
        return c3_4;
    }

    public void setC3_4(Integer c3_4) {
        this.c3_4 = c3_4;
    }

    public Integer getC3_5() {
        return c3_5;
    }

    public void setC3_5(Integer c3_5) {
        this.c3_5 = c3_5;
    }

    public Integer getC3_6() {
        return c3_6;
    }

    public void setC3_6(Integer c3_6) {
        this.c3_6 = c3_6;
    }

    public Integer getC3_7() {
        return c3_7;
    }

    public void setC3_7(Integer c3_7) {
        this.c3_7 = c3_7;
    }

    public Integer getC3_8() {
        return c3_8;
    }

    public void setC3_8(Integer c3_8) {
        this.c3_8 = c3_8;
    }

    public Integer getC3_9() {
        return c3_9;
    }

    public void setC3_9(Integer c3_9) {
        this.c3_9 = c3_9;
    }

    public Integer getC3_10() {
        return c3_10;
    }

    public void setC3_10(Integer c3_10) {
        this.c3_10 = c3_10;
    }

    public Integer getC3_11() {
        return c3_11;
    }

    public void setC3_11(Integer c3_11) {
        this.c3_11 = c3_11;
    }

    public Integer getC3_12() {
        return c3_12;
    }

    public void setC3_12(Integer c3_12) {
        this.c3_12 = c3_12;
    }

    public Integer getC2_1() {
        return c2_1;
    }

    public void setC2_1(Integer c2_1) {
        this.c2_1 = c2_1;
    }

    public Integer getC2_2() {
        return c2_2;
    }

    public void setC2_2(Integer c2_2) {
        this.c2_2 = c2_2;
    }

    public Integer getC2_3() {
        return c2_3;
    }

    public void setC2_3(Integer c2_3) {
        this.c2_3 = c2_3;
    }

    public Integer getC2_4() {
        return c2_4;
    }

    public void setC2_4(Integer c2_4) {
        this.c2_4 = c2_4;
    }

    public Integer getC2_5() {
        return c2_5;
    }

    public void setC2_5(Integer c2_5) {
        this.c2_5 = c2_5;
    }

    public Integer getC2_6() {
        return c2_6;
    }

    public void setC2_6(Integer c2_6) {
        this.c2_6 = c2_6;
    }

    public Integer getC2_7() {
        return c2_7;
    }

    public void setC2_7(Integer c2_7) {
        this.c2_7 = c2_7;
    }

    public Integer getC2_8() {
        return c2_8;
    }

    public void setC2_8(Integer c2_8) {
        this.c2_8 = c2_8;
    }

    public Integer getC2_9() {
        return c2_9;
    }

    public void setC2_9(Integer c2_9) {
        this.c2_9 = c2_9;
    }

    public Integer getC2_10() {
        return c2_10;
    }

    public void setC2_10(Integer c2_10) {
        this.c2_10 = c2_10;
    }

    public Integer getC2_11() {
        return c2_11;
    }

    public void setC2_11(Integer c2_11) {
        this.c2_11 = c2_11;
    }

    public Integer getC2_12() {
        return c2_12;
    }

    public void setC2_12(Integer c2_12) {
        this.c2_12 = c2_12;
    }

    public Integer getC1_1() {
        return c1_1;
    }

    public void setC1_1(Integer c1_1) {
        this.c1_1 = c1_1;
    }

    public Integer getC1_2() {
        return c1_2;
    }

    public void setC1_2(Integer c1_2) {
        this.c1_2 = c1_2;
    }

    public Integer getC1_3() {
        return c1_3;
    }

    public void setC1_3(Integer c1_3) {
        this.c1_3 = c1_3;
    }

    public Integer getC1_4() {
        return c1_4;
    }

    public void setC1_4(Integer c1_4) {
        this.c1_4 = c1_4;
    }

    public Integer getC1_5() {
        return c1_5;
    }

    public void setC1_5(Integer c1_5) {
        this.c1_5 = c1_5;
    }

    public Integer getC1_6() {
        return c1_6;
    }

    public void setC1_6(Integer c1_6) {
        this.c1_6 = c1_6;
    }

    public Integer getC1_7() {
        return c1_7;
    }

    public void setC1_7(Integer c1_7) {
        this.c1_7 = c1_7;
    }

    public Integer getC1_8() {
        return c1_8;
    }

    public void setC1_8(Integer c1_8) {
        this.c1_8 = c1_8;
    }

    public Integer getC1_9() {
        return c1_9;
    }

    public void setC1_9(Integer c1_9) {
        this.c1_9 = c1_9;
    }

    public Integer getC1_10() {
        return c1_10;
    }

    public void setC1_10(Integer c1_10) {
        this.c1_10 = c1_10;
    }

    public Integer getC1_11() {
        return c1_11;
    }

    public void setC1_11(Integer c1_11) {
        this.c1_11 = c1_11;
    }

    public Integer getC1_12() {
        return c1_12;
    }

    public void setC1_12(Integer c1_12) {
        this.c1_12 = c1_12;
    }
}
