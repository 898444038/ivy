package com.ivy.system.timewheel;

public class TimeWheelTest {

    public static void main(String[] args) {
        SystemTimer systemTimer = new SystemTimer();
        systemTimer.add(addTask("每秒任务",1000));
        systemTimer.add(addTask("每分任务",60*1000));
        systemTimer.add(addTask("每时任务",60*60*1000));
        systemTimer.add(addTask("每天任务",24*60*60*1000));
        systemTimer.add(addTask("每周任务",7*24*60*60*1000));
        systemTimer.add(addTask("每月任务",30*7*24*60*60*1000));
    }


    public static TimerTask addTask(String desc, long delayMs){
        TimerTask task = new TimerTask(desc,delayMs);
        return task;
    }
}
