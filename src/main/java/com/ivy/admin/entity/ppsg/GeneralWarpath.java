package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "战意",tablePrefix = "ppsg",parentPackage = "ppsg")
public class GeneralWarpath {

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
    @Comment("战意编码")
    private Integer warpathCode;

    @Column
    @Comment("战意名称")
    private String warpathName;

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

    public GeneralWarpath() {}

    public GeneralWarpath(Long generalId, String generalName, Integer warpathCode, String warpathName) {
        this.generalId = generalId;
        this.generalName = generalName;
        this.warpathCode = warpathCode;
        this.warpathName = warpathName;
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

}
