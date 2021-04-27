package com.ivy.system.timewheel;

/**
 * 定时器接口
 */
public interface Timer {

    /**
     * 添加一个新任务
     */
    void add(TimerTask timerTask);


    /**
     * 推动指针
     */
    void advanceClock(long timeout);

    /**
     * 等待执行的任务
     */
    int size();

    /**
     * 关闭服务,剩下的无法被执行
     */
    void shutdown();
}