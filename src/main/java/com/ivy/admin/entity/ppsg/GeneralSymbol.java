package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.database.Comment;

public class GeneralSymbol {

    @Comment("类型名称")
    private String typeName;

    @Comment("主属性名称")
    private String mainName;

    @Comment("副属性名称")
    private String secondName1;

    @Comment("副属性名称")
    private String secondName2;

    @Comment("副属性名称")
    private String secondName3;

    @Comment("副属性名称")
    private String secondName4;

    public GeneralSymbol() {}

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getSecondName1() {
        return secondName1;
    }

    public void setSecondName1(String secondName1) {
        this.secondName1 = secondName1;
    }

    public String getSecondName2() {
        return secondName2;
    }

    public void setSecondName2(String secondName2) {
        this.secondName2 = secondName2;
    }

    public String getSecondName3() {
        return secondName3;
    }

    public void setSecondName3(String secondName3) {
        this.secondName3 = secondName3;
    }

    public String getSecondName4() {
        return secondName4;
    }

    public void setSecondName4(String secondName4) {
        this.secondName4 = secondName4;
    }
}
