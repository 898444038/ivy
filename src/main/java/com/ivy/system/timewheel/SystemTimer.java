package com.ivy.system.timewheel;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 定时器实现
 */
public class SystemTimer implements Timer {
    /**
     * 底层时间轮
     */
    private TimeWheel timeWheel;
    /**
     * 一个Timer只有一个延时队列
     */
    private DelayQueue<TimerTaskList> delayQueue = new DelayQueue<>();
    /**
     * 过期任务执行线程
     */
    private ExecutorService workerThreadPool;
    /**
     * 轮询delayQueue获取过期任务线程
     */
    private ExecutorService bossThreadPool;

    public SystemTimer() {
        this.timeWheel = new TimeWheel(0,1000, 60, System.currentTimeMillis(), delayQueue);
        this.workerThreadPool = Executors.newFixedThreadPool(100);
        this.bossThreadPool = Executors.newFixedThreadPool(1);
        //20ms推动一次时间轮运转
        this.bossThreadPool.submit(() -> {
            for (; ; ) {
                this.advanceClock(50);
            }
        });
    }


    public void addTimerTaskEntry(TimerTaskEntry entry) {
        if (!timeWheel.add(entry)) {
            //已经过期了
            TimerTask timerTask = entry.getTimerTask();
            System.out.println(TimeFormat.getNowTime()+" 执行任务: "+timerTask.getDesc());
            workerThreadPool.submit(timerTask);
        }
    }

    @Override
    public void add(TimerTask timerTask) {
        System.out.println(TimeFormat.getNowTime()+" 添加任务: "+ timerTask.getDesc());
        TimerTaskEntry entry = new TimerTaskEntry(timerTask, timerTask.getDelayMs() + System.currentTimeMillis());
        timerTask.setTimerTaskEntry(entry);
        addTimerTaskEntry(entry);
    }

    /**
     * 推动指针运转获取过期任务
     *
     * @param timeout 时间间隔
     * @return
     */
    @Override
    public synchronized void advanceClock(long timeout) {
        try {
            TimerTaskList bucket = delayQueue.poll(timeout, TimeUnit.MILLISECONDS);
            if (bucket != null) {
                System.out.println("推进时间");
                //推进时间
                timeWheel.advanceLock(bucket.getExpiration());
                //执行过期任务(包含降级)
                bucket.clear(this::addTimerTaskEntry);
            }
        } catch (InterruptedException e) {
            System.out.println("advanceClock error");
        }
    }

    @Override
    public int size() {
        //todo
        return 0;
    }

    @Override
    public void shutdown() {
        this.bossThreadPool.shutdown();
        this.workerThreadPool.shutdown();
        this.timeWheel = null;
    }
}
