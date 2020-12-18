package com.ivy.admin.aspect.statistics;

import com.ivy.admin.entity.ivy.Statistics;
import com.ivy.admin.entity.ivy.StatisticsItem;
import com.ivy.admin.service.ivy.StatisticsItemService;
import com.ivy.admin.service.ivy.StatisticsService;
import com.ivy.admin.vo.ivy.StatisticsItemVo;
import com.ivy.admin.vo.ivy.StatisticsVo;
import com.ivy.system.thread.ThreadPool;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Order(-1)//保证切面在@Transactional前执行
public class VisitStatisticsAspect {
    @Resource
    private StatisticsService statisticsService;
    @Resource
    private StatisticsItemService statisticsItemService;

    private static ThreadLocal<DateFormat> localDate = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    @Pointcut(value = "@annotation(com.ivy.admin.aspect.statistics.VisitStatistics)")
    public void point(){}

    @Before("point()")
    public void before(){}

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        VisitStatistics visitStatistics = method.getAnnotation(VisitStatistics.class);
        ThreadPool.execute(()-> {
            Date d = new Date();

            StatisticsVo statisticsVo = new StatisticsVo();
            statisticsVo.setType(visitStatistics.type());
            Statistics statistics = statisticsService.selectOne(statisticsVo);
            if(statistics == null){
                statistics = new Statistics();
                statistics.setType(visitStatistics.type());
                statistics.setRemark(visitStatistics.desc());
                statistics.setTotalCount(1);
                statisticsService.insert(statistics);
            }else{
                statistics.setTotalCount(statistics.getTotalCount()+1);
                statisticsService.update(statistics);
            }

            StatisticsItemVo statisticsItemVo = new StatisticsItemVo();
            statisticsItemVo.setStatisticsId(statistics.getId());
            statisticsItemVo.setDate(localDate.get().format(d));
            StatisticsItem statisticsItem = statisticsItemService.selectOne(statisticsItemVo);
            if(statisticsItem == null){
                statisticsItem = new StatisticsItem();
                statisticsItem.setStatisticsId(statisticsItemVo.getStatisticsId());
                statisticsItem.setDate(statisticsItemVo.getDate());
                statisticsItem.setCount(1);
                statisticsItemService.insert(statisticsItem);
            }else{
                statisticsItem.setCount(statisticsItem.getCount()+1);
                statisticsItemService.update(statisticsItem);
            }
        });
        System.out.println("接口访问统计："+visitStatistics.type()+"|"+visitStatistics.desc()+"|"+(endTime-startTime)+"ms");
        return obj;
    }

    @After("point()")
    public void after(){}
}
