package com.geoway.webstore.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/12 12:40
 * @Description:
 */
//@Component
public class QuartzJobInit implements ApplicationRunner {
    private static final String ID = "Fit";
    @Resource
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class)
                .withIdentity(ID + " 02")
                .storeDurably()
                .build();
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5) //每一秒执行一次
                .repeatForever(); //永久重复，一直执行下去
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(ID + " 02Trigger")
                .withSchedule(scheduleBuilder)
                .startNow()
                .build();
        Set<Trigger> set = new HashSet<>();
        set.add(trigger);
        // boolean replace 表示启动时对数据库中的quartz的任务进行覆盖。
        scheduler.scheduleJob(jobDetail, set, true);

        /*JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class)
                .withIdentity(ID + " 02")
                .storeDurably()
                .build();
        CronScheduleBuilder scheduleBuilder =
                CronScheduleBuilder.cronSchedule("0 0 3 * * ? *");
        // 创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(ID + " 02Trigger")
                .withSchedule(scheduleBuilder)
                .startNow() //立即執行一次任務
                .build();
        Set<Trigger> set = new HashSet<>();
        set.add(trigger);
        // boolean replace 表示启动时对数据库中的quartz的任务进行覆盖。
        scheduler.scheduleJob(jobDetail, set, true);*/
    }
}
