package com.geoway.webstore.util;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * @Author: Lencho
 * @CreateTime: 2021/9/15 21:14
 * @Description:
 */
public class ConsumeTimeUtil {

    public static String calculateTimeDifference(Date startTime, Date endTime) {
        if (startTime == null || endTime == null) return "-";

        Instant startInst = startTime.toInstant();
        Instant endInst = endTime.toInstant();

        return Duration.between(startInst, endInst).toMinutes() + "m";
    }
}
