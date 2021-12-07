package com.andy.rhino.test;


import com.andy.rhino.utils.NashornJavascriptEvaluateUtils;
import com.andy.rhino.utils.RhinoJavascriptEvaluateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

@Slf4j
public class JavascriptEvaluateUtilsPerformanceTest {

    /**
     * 测试点 :
     * 1. javascript 中创建 java 对象保存为 javascript 变量;
     * 2. 调用 java 类静态方法操作 javascript 变量中保存的对象;
     * 3. 使用 Nashorn 引擎
     */
    private static void testNashornJavascriptEvaluateUtils() {

        String javascript = "var d = java.time.LocalDateTime.now();\n" + // 使用Java类
                "com.andy.rhino.utils.DateTimeUtils.toStringDate(d);\n"; // 输出对象属性; 注意这里包头是 com, 如果是 andy 不会被加载

        String result = NashornJavascriptEvaluateUtils.evalToString(javascript, null);

        log.info("执行结果 : {}", result);
    }

    /**
     * 测试点 :
     * 1. javascript 中创建 java 对象保存为 javascript 变量;
     * 2. 调用 java 类静态方法操作 javascript 变量中保存的对象;
     * 3. 使用 Nashorn 引擎
     */
    private static void testRhinoJavascriptEvaluateUtils() {

        String javascript = "var d = java.time.LocalDateTime.now();\n" + // 使用Java类
                "com.andy.rhino.utils.DateTimeUtils.toStringDate(d);\n"; // 输出对象属性; 注意这里包头是 com, 如果是 andy 不会被加载

        String result = RhinoJavascriptEvaluateUtils.evalToString(javascript, null);

        log.info("执行结果 : {}", result);
    }

    /**
     * Nashorn 1000次耗时 : 3637毫秒
     */
    private static void run1000TimesNashorn() {
        StopWatch stopWatch = StopWatch.createStarted();

        final int count = 1000;
        for (int i = 0; i < count; i++) {
            testNashornJavascriptEvaluateUtils();
        }
        stopWatch.stop();

        log.info("Nashorn {}次耗时 : {}毫秒", count, stopWatch.getTime(TimeUnit.MILLISECONDS));
    }

    /**
     * Rhino 1000次耗时 : 1471毫秒
     */
    private static void run1000TimesRhino() {
        StopWatch stopWatch = StopWatch.createStarted();

        final int count = 1000;
        for (int i = 0; i < count; i++) {
            testRhinoJavascriptEvaluateUtils();
        }
        stopWatch.stop();

        log.info("Rhino {}次耗时 : {}毫秒", count, stopWatch.getTime(TimeUnit.MILLISECONDS));
    }

    public static void main(String[] args) {
        // run1000TimesNashorn();
        run1000TimesRhino();
    }
}
