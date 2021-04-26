package com.ivy.system.timewheel;

public class TimeWheelTest {

    public static void main(String[] args) {
        SystemTimer systemTimer = new SystemTimer();
        systemTimer.add(addTask("1秒任务",1000));
        systemTimer.add(addTask("10秒任务",10*1000));
        systemTimer.add(addTask("30秒任务",30*1000));
        systemTimer.add(addTask("1分任务",60*1000));
        systemTimer.add(addTask("3分任务",3*60*1000));
        systemTimer.add(addTask("5分任务",5*60*1000));
        systemTimer.add(addTask("10分任务",10*60*1000));
        systemTimer.add(addTask("1时任务",60*60*1000));
        systemTimer.add(addTask("1天任务",24*60*60*1000));
        systemTimer.add(addTask("1周任务",7*24*60*60*1000));
        systemTimer.add(addTask("1月任务",30*7*24*60*60*1000));
    }


    public static TimerTask addTask(String desc, long delayMs){
        TimerTask task = new TimerTask(desc,delayMs);
        return task;
    }
}
