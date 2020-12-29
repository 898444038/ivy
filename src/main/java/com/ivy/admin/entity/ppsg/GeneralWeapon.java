package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "战器",tablePrefix = "ppsg",parentPackage = "ppsg")
public class GeneralWeapon {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("战器名称")
    private String name;

    @Column
    @Comment("战器类型编码")
    private Integer weaponCode;

    @Column
    @Comment("战器类型名称")
    private String weaponName;

    @Column
    @Comment("武将主键")
    private Long generalId;

    @Column
    @Comment("武将名称")
    private String generalName;

    public GeneralWeapon() {}

    public GeneralWeapon(String name, Integer weaponCode, String weaponName, Long generalId, String generalName) {
        this.name = name;
        this.weaponCode = weaponCode;
        this.weaponName = weaponName;
        this.generalId = generalId;
        this.generalName = generalName;
    }

    public Integer getWeaponCode() {
        return weaponCode;
    }

    public void setWeaponCode(Integer weaponCode) {
        this.weaponCode = weaponCode;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
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

}
