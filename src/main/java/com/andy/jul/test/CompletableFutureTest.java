package com.andy.jul.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * JAVA 等待并发任务结束的几种方式 : https://blog.csdn.net/u013429928/article/details/117907464
 */
@Slf4j
public class CompletableFutureTest {

    private static void test() {
        //// 用以记录异步并发任务
        List<CompletableFuture> futures = new ArrayList<>();

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        StopWatch stopWatch = StopWatch.createStarted();

        //// 开始执行异步并发任务
        IntStream.range(0, 10).forEach((i) -> {
            Runnable r = () -> {
                log.info("线程启动顺序 : {}", i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            CompletableFuture completableFuture = CompletableFuture.runAsync(r, forkJoinPool);
            futures.add(completableFuture);
        });

        //// 等待所有异步并发任务的结束
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();

        stopWatch.stop();

        log.info("并发任务执行耗时: {} ms", stopWatch.getTime(TimeUnit.MILLISECONDS));
    }

    public static void main(String[] args) {
        test();
    }
}
