package com.ivy.admin.enums.monitor;

public enum MysqlStatus {

    Aborted_clients("Aborted_clients","Global","由于客户端没有正确关闭连接导致客户端终止而中断的连接数"),

    ;

    private String code;//状态名
    private String scope;//作用域
    private String name;//详细解释

    MysqlStatus(String code, String scope, String name) {
        this.code = code;
        this.scope = scope;
        this.name = name;
    }
}
