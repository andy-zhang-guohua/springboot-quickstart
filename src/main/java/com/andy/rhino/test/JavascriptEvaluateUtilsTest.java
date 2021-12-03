package com.andy.rhino.test;


import com.andy.rhino.utils.NashornJavascriptEvaluateUtils;
import com.andy.rhino.utils.RandomChineseUtils;
import com.andy.rhino.utils.RhinoJavascriptEvaluateUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class JavascriptEvaluateUtilsTest {

    private static void testNashornJavascriptEvaluateUtils() {

        String javascript = "var d = java.time.LocalDateTime.now();\n" + // 使用Java类
                "com.andy.rhino.utils.DateTimeUtils.toStringDate(d);\n"; // 输出对象属性; 注意这里包头是 com, 如果是 andy 不会被加载

        String result = NashornJavascriptEvaluateUtils.evalToString(javascript);

        log.info("执行结果 : {}", result);
    }

    private static void testRhinoJavascriptEvaluateUtils() {
        Map<String, Object> beans = new TreeMap<>();
        beans.put("now", LocalDateTime.now());
        beans.put("name", RandomChineseUtils.randomChineseChar());

        String javascript = "var d = java.time.LocalDateTime.now();\n" + // 使用Java类
                "var strDateTime=com.andy.rhino.utils.DateTimeUtils.toStringDate(d);\n" +// 输出对象属性; 注意这里包头是 com, 如果是 andy 不会被加载
                "var message = now + \" \" + strDateTime + ' ' + name ;\n" +
                "message";

        String result = RhinoJavascriptEvaluateUtils.evalToString(javascript, beans);

        log.info("执行结果 : {}", result);
    }

    public static void main(String[] args) {
        testNashornJavascriptEvaluateUtils();
        testRhinoJavascriptEvaluateUtils();
    }
}
