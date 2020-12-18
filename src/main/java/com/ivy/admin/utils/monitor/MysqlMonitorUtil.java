package com.ivy.admin.utils.monitor;

/**
 * https://blog.csdn.net/zhaowenbo168/article/details/53219860
 * https://blog.csdn.net/zhaowenbo168/article/details/53199585
 *
 * QPS (Query per second) （每秒查询量）
 * Questions = SHOW GLOBAL STATUS LIKE 'Questions';
 * Uptime = SHOW GLOBAL STATUS LIKE 'Uptime';
 * QPS=Questions/Uptime
 *
 * TPS(Transaction per second) （每秒事务量，如果是InnoDB会显示，没有InnoDB就不会显示）
 * Com_commit = SHOW GLOBAL STATUS LIKE 'Com_commit';
 * Com_rollback = SHOW GLOBAL STATUS LIKE 'Com_rollback';
 * Uptime = SHOW GLOBAL STATUS LIKE 'Uptime';
 * TPS=(Com_commit + Com_rollback)/Uptime
 */
public class MysqlMonitorUtil {


    //连接数
    public static void connections(){

    }


}
