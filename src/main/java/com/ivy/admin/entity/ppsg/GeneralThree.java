package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;

import java.io.Serializable;

//@GenerateDataSource(dataSource = "dataSource1")
//@Generate(isEffective = true,isCover = false,desc = "武将",tablePrefix = "ppsg",parentPackage = "ppsg")
public class GeneralThree implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("general主键")
    private Long generalId;

    @Column
    @Comment("编码")
    private String code;

    @Column
    @Comment("名称")
    private String name;

    @Column
    @Comment("整数武力")
    private Integer force;

    @Column
    @Comment("整数智力")
    private Integer intellect;

    @Column
    @Comment("整数兵力")
    private Integer troops;

    @Column
    @Comment("整数战力")
    private Integer combat;

    @Column
    @Comment("精确武力")
    private Double force0;

    @Column
    @Comment("精确智力")
    private Double intellect0;

    @Column
    @Comment("精确兵力")
    private Double troops0;

    @Column
    @Comment("精确战力")
    private Double combat0;

    public GeneralThree() {
    }

    public GeneralThree(Long generalId, String code, String name, Integer force, Integer intellect, Integer troops, Integer combat, Double force0, Double intellect0, Double troops0, Double combat0) {
        this.generalId = generalId;
        this.code = code;
        this.name = name;
        this.force = force;
        this.intellect = intellect;
        this.troops = troops;
        this.combat = combat;
        this.force0 = force0;
        this.intellect0 = intellect0;
        this.troops0 = troops0;
        this.combat0 = combat0;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getForce() {
        return force;
    }

    public void setForce(Integer force) {
        this.force = force;
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

    public Integer getCombat() {
        return combat;
    }

    public void setCombat(Integer combat) {
        this.combat = combat;
    }

    public Double getForce0() {
        return force0;
    }

    public void setForce0(Double force0) {
        this.force0 = force0;
    }

    public Double getIntellect0() {
        return intellect0;
    }

    public void setIntellect0(Double intellect0) {
        this.intellect0 = intellect0;
    }

    public Double getTroops0() {
        return troops0;
    }

    public void setTroops0(Double troops0) {
        this.troops0 = troops0;
    }

    public Double getCombat0() {
        return combat0;
    }

    public void setCombat0(Double combat0) {
        this.combat0 = combat0;
    }
}