package com.ivy.admin.entity.ivy;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "菜单表",tablePrefix = "ivy",parentPackage = "ivy")
public class Menu implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("名称")
    private String name;


    @Column
    @Comment("是否启用[0:未启用,1:启用]")
    private Boolean isEnable;

    public Menu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
