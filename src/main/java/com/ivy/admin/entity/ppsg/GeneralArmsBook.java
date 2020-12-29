package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "兵书",tablePrefix = "ppsg",parentPackage = "ppsg")
public class GeneralArmsBook {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("武将主键")
    private Long generalId;

    @Column
    @Comment("武将名称")
    private String generalName;

    @Column
    @Comment("位置编码1")
    private Integer positionCode1;

    @Column
    @Comment("位置名称1")
    private String positionName1;

    @Column
    @Comment("位置编码2")
    private Integer positionCode2;

    @Column
    @Comment("位置名称2")
    private String positionName2;

    @Column
    @Comment("位置编码3")
    private Integer positionCode3;

    @Column
    @Comment("位置名称3")
    private String positionName3;

    @Column
    @Comment("位置编码4")
    private Integer positionCode4;

    @Column
    @Comment("位置名称4")
    private String positionName4;

    @Column
    @Comment("位置编码5")
    private Integer positionCode5;

    @Column
    @Comment("位置名称5")
    private String positionName5;

    public GeneralArmsBook() {}

    public GeneralArmsBook(Long generalId, String generalName, Integer positionCode1, String positionName1, Integer positionCode2, String positionName2, Integer positionCode3, String positionName3, Integer positionCode4, String positionName4, Integer positionCode5, String positionName5) {
        this.generalId = generalId;
        this.generalName = generalName;
        this.positionCode1 = positionCode1;
        this.positionName1 = positionName1;
        this.positionCode2 = positionCode2;
        this.positionName2 = positionName2;
        this.positionCode3 = positionCode3;
        this.positionName3 = positionName3;
        this.positionCode4 = positionCode4;
        this.positionName4 = positionName4;
        this.positionCode5 = positionCode5;
        this.positionName5 = positionName5;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGeneralId() {
        return generalId;
    }

    public void setGeneralId(Long generalId) {
        this.generalId = generalId;
    }

    public String getGeneralName() {
        return generalName;
    }

    public void setGeneralName(String generalName) {
        this.generalName = generalName;
    }

    public Integer getPositionCode1() {
        return positionCode1;
    }

    public void setPositionCode1(Integer positionCode1) {
        this.positionCode1 = positionCode1;
    }

    public String getPositionName1() {
        return positionName1;
    }

    public void setPositionName1(String positionName1) {
        this.positionName1 = positionName1;
    }

    public Integer getPositionCode2() {
        return positionCode2;
    }

    public void setPositionCode2(Integer positionCode2) {
        this.positionCode2 = positionCode2;
    }

    public String getPositionName2() {
        return positionName2;
    }

    public void setPositionName2(String positionName2) {
        this.positionName2 = positionName2;
    }

    public Integer getPositionCode3() {
        return positionCode3;
    }

    public void setPositionCode3(Integer positionCode3) {
        this.positionCode3 = positionCode3;
    }

    public String getPositionName3() {
        return positionName3;
    }

    public void setPositionName3(String positionName3) {
        this.positionName3 = positionName3;
    }

    public Integer getPositionCode4() {
        return positionCode4;
    }

    public void setPositionCode4(Integer positionCode4) {
        this.positionCode4 = positionCode4;
    }

    public String getPositionName4() {
        return positionName4;
    }

    public void setPositionName4(String positionName4) {
        this.positionName4 = positionName4;
    }

    public Integer getPositionCode5() {
        return positionCode5;
    }

    public void setPositionCode5(Integer positionCode5) {
        this.positionCode5 = positionCode5;
    }

    public String getPositionName5() {
        return positionName5;
    }

    public void setPositionName5(String positionName5) {
        this.positionName5 = positionName5;
    }
}
