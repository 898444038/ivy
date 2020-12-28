package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "幻化",tablePrefix = "ppsg",parentPackage = "ppsg")
public class GeneralSkin {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("幻化名称")
    private String name;

    @Column
    @Comment("武将主键")
    private Long generalId;

    @Column
    @Comment("武将名称")
    private String generalName;

    @Column
    @Comment("武力")
    private Integer force;

    @Column
    @Comment("智力")
    private Integer intellect;

    @Column
    @Comment("兵力")
    private Integer troops;

    public GeneralSkin() {}

    public GeneralSkin(String name, Long generalId, String generalName, Integer force, Integer intellect, Integer troops) {
        this.name = name;
        this.generalId = generalId;
        this.generalName = generalName;
        this.force = force;
        this.intellect = intellect;
        this.troops = troops;
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
}
