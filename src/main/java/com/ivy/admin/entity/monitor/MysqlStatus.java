package com.ivy.admin.entity.monitor;

import com.ivy.tools.generate.template.annotation.Generate;
import com.ivy.tools.generate.template.annotation.database.Column;
import com.ivy.tools.generate.template.annotation.database.Comment;
import com.ivy.tools.generate.template.annotation.database.PrimaryKey;
import com.ivy.tools.generate.template.annotation.orm.GenerateDataSource;

import java.io.Serializable;
import java.util.Date;

@GenerateDataSource(dataSource = "dataSource1")
@Generate(isEffective = true,isCover = false,desc = "MySQL状态配置表",tablePrefix = "ivy",parentPackage = "monitor")
public class MysqlStatus implements Serializable {

    @Column
    @PrimaryKey
    private Long id;

    @Column
    @Comment("状态名")
    private String code;

    @Column
    @Comment("作用域")
    private String scope;

    @Column
    @Comment("详细解释")
    private String explicate;

    @Column
    @Comment("创建时间")
    private Date createTime;

    @Column
    @Comment("是否启用[0:未启用,1:已启用]")
    private Boolean enableFlag;

    @Column
    @Comment("是否删除[0:未删除,1:已删除]")
    private Boolean delFlag;

    public MysqlStatus() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getExplicate() {
        return explicate;
    }

    public void setExplicate(String explicate) {
        this.explicate = explicate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Boolean enableFlag) {
        this.enableFlag = enableFlag;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
