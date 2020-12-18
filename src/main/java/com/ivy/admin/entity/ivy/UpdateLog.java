package com.ivy.admin.entity.ivy;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.database.Text;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "更新日志",tablePrefix = "sys",parentPackage = "ivy")
public class UpdateLog implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("更新标题")
    private String title;

    @Text
    @Column
    @Comment("更新内容")
    private String remark;

    @Column
    @Comment("更新时间")
    private String updateTime;

    @Column
    @Comment("颜色")
    private String color;

    @Column
    @Comment("图标")
    private String icon;

    public UpdateLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
