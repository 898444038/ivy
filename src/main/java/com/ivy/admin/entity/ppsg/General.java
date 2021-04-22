package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;
import java.util.List;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "武将",tablePrefix = "ppsg",parentPackage = "ppsg")
public class General implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("父级ID")
    private String parentIds;

    @Column
    @Comment("父级名称")
    private String parentNames;

    @Column
    @Comment("武将名称")
    private String name;

    @Column
    @Comment("武力")
    private Integer force;

    @Column
    @Comment("智力")
    private Integer intellect;

    @Column
    @Comment("兵力")
    private Integer troops;

    @Column
    @Comment("异化武力")
    private Integer forcex;

    @Column
    @Comment("异化智力")
    private Integer intellectx;

    @Column
    @Comment("异化兵力")
    private Integer troopsx;

    @Column
    @Comment("卡片编码")
    private Integer cardCode;//异化、非异化
    @Column
    @Comment("卡片名称")
    private String cardName;

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
    @Comment("随从编码")
    private Integer entourageCode;

    @Column
    @Comment("随从名称")
    private String entourageName;

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
    @Comment("是否共鸣")
    private Boolean resonance;

    @Column
    @Comment("武将类型编码")
    private Integer typeCode;

    @Column
    @Comment("武将类型名称")
    private String typeName;

    @Column
    @Comment("分类编码")
    private Integer categoryCode;

    @Column
    @Comment("分类名称")
    private String categoryName;

    @Column
    @Comment("命格编码")
    private Integer destinyCode;

    @Column
    @Comment("命格名称")
    private String destinyName;

    @Column
    @Comment("启用标识【0：未启用，1：启用】")
    private Boolean enableFlag;

    @Column
    @Comment("删除标识【0：删除，1：未删除】")
    private Boolean delFlag;

    @Comment("联协")
    private List<GeneralAssociation> associationList;

    @Comment("战器")
    private List<GeneralWeapon> weaponList;

    @Comment("主动技能")
    private List<GeneralSkillActive> skillActiveList;

    @Comment("被动技能")
    private List<GeneralSkillPassive> skillPassiveList;

    @Comment("兵书")
    private GeneralArmsBook armsBook;

    @Comment("幻化")
    private GeneralSkin generalSkin;

    @Comment("三维属性")
    private List<GeneralThree> threeList;

//    @Comment("基础三维|基础异化三维")
//    private GeneralThree baseThree;

    public General() {
    }

    public Boolean getResonance() {
        return resonance;
    }

    public void setResonance(Boolean resonance) {
        this.resonance = resonance;
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

    public Integer getForcex() {
        return forcex;
    }

    public void setForcex(Integer forcex) {
        this.forcex = forcex;
    }

    public Integer getIntellectx() {
        return intellectx;
    }

    public void setIntellectx(Integer intellectx) {
        this.intellectx = intellectx;
    }

    public Integer getTroopsx() {
        return troopsx;
    }

    public void setTroopsx(Integer troopsx) {
        this.troopsx = troopsx;
    }

    public String getEntourageName() {
        return entourageName;
    }

    public void setEntourageName(String entourageName) {
        this.entourageName = entourageName;
    }

    public Integer getEntourageCode() {
        return entourageCode;
    }

    public void setEntourageCode(Integer entourageCode) {
        this.entourageCode = entourageCode;
    }

    public Integer getCardCode() {
        return cardCode;
    }

    public void setCardCode(Integer cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getParentNames() {
        return parentNames;
    }

    public void setParentNames(String parentNames) {
        this.parentNames = parentNames;
    }

    public List<GeneralAssociation> getAssociationList() {
        return associationList;
    }

    public void setAssociationList(List<GeneralAssociation> associationList) {
        this.associationList = associationList;
    }

    public List<GeneralWeapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<GeneralWeapon> weaponList) {
        this.weaponList = weaponList;
    }

    public List<GeneralSkillActive> getSkillActiveList() {
        return skillActiveList;
    }

    public void setSkillActiveList(List<GeneralSkillActive> skillActiveList) {
        this.skillActiveList = skillActiveList;
    }

    public List<GeneralSkillPassive> getSkillPassiveList() {
        return skillPassiveList;
    }

    public void setSkillPassiveList(List<GeneralSkillPassive> skillPassiveList) {
        this.skillPassiveList = skillPassiveList;
    }

    public GeneralArmsBook getArmsBook() {
        return armsBook;
    }

    public void setArmsBook(GeneralArmsBook armsBook) {
        this.armsBook = armsBook;
    }

    public GeneralSkin getGeneralSkin() {
        return generalSkin;
    }

    public void setGeneralSkin(GeneralSkin generalSkin) {
        this.generalSkin = generalSkin;
    }

    public List<GeneralThree> getThreeList() {
        return threeList;
    }

    public void setThreeList(List<GeneralThree> threeList) {
        this.threeList = threeList;
    }

    public Integer getDestinyCode() {
        return destinyCode;
    }

    public void setDestinyCode(Integer destinyCode) {
        this.destinyCode = destinyCode;
    }

    public String getDestinyName() {
        return destinyName;
    }

    public void setDestinyName(String destinyName) {
        this.destinyName = destinyName;
    }

    public Integer getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Integer categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
