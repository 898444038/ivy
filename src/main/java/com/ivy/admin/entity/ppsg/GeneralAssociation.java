package com.ivy.admin.entity.ppsg;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "联协",tablePrefix = "ppsg",parentPackage = "ppsg")
public class GeneralAssociation {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("联协名称")
    private String name;

    @Column
    @Comment("武将主键")
    private Long generalId;

    @Column
    @Comment("武将名称")
    private String generalName;

    @Column
    @Comment("加成")
    private Double rate;

    public GeneralAssociation() {}

    public GeneralAssociation(String name, Long generalId, String generalName, Double rate) {
        this.name = name;
        this.generalId = generalId;
        this.generalName = generalName;
        this.rate = rate;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
