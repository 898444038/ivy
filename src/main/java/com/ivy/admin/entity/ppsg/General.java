package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;

//@GenerateDataSource(dataSource = "dataSource1")
//@Generate(isEffective = true,isCover = false,desc = "武将",tablePrefix = "ppsg",parentPackage = "ppsg")
public class General implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("武将名称")
    private String name;

    @Column
    @Comment("等级")
    private Integer level;

    @Column
    @Comment("性别编码")
    private Integer genderCode;

    @Column
    @Comment("性别名称")
    private String genderName;

    @Column
    @Comment("国家编码")
    private Integer countryCode;

    @Column
    @Comment("国家名称")
    private String countryName;

    @Column
    @Comment("星级编码")
    private Integer starCode;

    @Column
    @Comment("星级名称")
    private String starName;

    @Column
    @Comment("兵种编码")
    private Integer armsCode;

    @Column
    @Comment("兵种名称")
    private String armsName;

    @Column
    @Comment("武将类型编码")
    private Integer typeCode;

    @Column
    @Comment("武将类型名称")
    private String typeName;

    @Column
    @Comment("启用标识【0：未启用，1：启用】")
    private Boolean enableFlag;

    @Column
    @Comment("删除标识【0：删除，1：未删除】")
    private Boolean delFlag;


    public General() {
    }

    public Integer getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(Integer genderCode) {
        this.genderCode = genderCode;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getArmsCode() {
        return armsCode;
    }

    public void setArmsCode(Integer armsCode) {
        this.armsCode = armsCode;
    }

    public String getArmsName() {
        return armsName;
    }

    public void setArmsName(String armsName) {
        this.armsName = armsName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStarCode() {
        return starCode;
    }

    public void setStarCode(Integer starCode) {
        this.starCode = starCode;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public Boolean getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Boolean enableFlag) {
        this.enableFlag = enableFlag;
    }

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

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
