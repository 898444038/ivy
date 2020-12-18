package com.ivy.admin.utils.monitor;

import java.io.IOException;

public class FireWallMonitorUtil {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        // -p 指定协议，可以是udp或者tcp之类的
        // -j 接受或者拒绝，即ACCEPT或者DROP

        //开放关闭端口
        Process p = Runtime.getRuntime().exec("iptables -A INPUT -p udp --dport " + port + " -j ACCEPT");
    }


}
