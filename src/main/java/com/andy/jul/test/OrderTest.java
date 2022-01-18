package com.andy.jul.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * * - java线程池(二)：聊聊newFixedThreadPool(1)和newSingleThreadExecutor()的区别
 * * -- https://www.jianshu.com/p/c94234ece339
 * * -- 比较 Executors.newFixedThreadPool(1) 和 Executors.newSingleThreadExecutor() 在任务处理顺序上的异同
 * * -- 结论 : 相同
 */
@Slf4j
public class OrderTest {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();

        log.info("基于 Executors.newFixedThreadPool(1)");
        testOrder(executorService1);

        TimeUnit.SECONDS.sleep(1);

        log.info("基于 Executors.newSingleThreadExecutor()");
        testOrder(executorService2);

        executorService1.shutdown();
        executorService2.shutdown();
    }

    private static void testOrder(ExecutorService executorService) throws InterruptedException {
        List<Integer> submit = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        IntStream.range(0, 10).forEach((i) -> {
            submit.add(i);
            executorService.submit(() -> result.add(i));
        });
        TimeUnit.SECONDS.sleep(1);
        log.info("等待处理任务顺序 : {}", submit);
        log.info("实际任务处理顺序 : {}", result);
    }
}
