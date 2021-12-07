package com.andy.rhino.test;


import com.andy.rhino.utils.NashornJavascriptEvaluateUtils;
import com.andy.rhino.utils.RhinoJavascriptEvaluateUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class JavascriptEvaluateUtilsTest {

    /**
     * 测试点 :
     * 1. javascript 中创建 java 对象保存为 javascript 变量;
     * 2. 调用 java 类静态方法操作 javascript 变量中保存的对象;
     */
    private static void testNashornJavascriptEvaluateUtils() {

        String javascript = "var d = java.time.LocalDateTime.now();\n" + // 使用Java类
                "com.andy.rhino.utils.DateTimeUtils.toStringDate(d);\n"; // 输出对象属性; 注意这里包头是 com, 如果是 andy 不会被加载

        String result = NashornJavascriptEvaluateUtils.evalToString(javascript, null);

        log.info("执行结果 : {}", result);
    }

    /**
     * 测试点 :
     * 1. java 中的对象命名后放入到 javascript 的运行上下文中供 javascript 代码使用;
     */
    private static void testRhinoJavascriptEvaluateUtils() {
        Map<String, Object> beans = new TreeMap<>();
        beans.put("now", LocalDateTime.now());
        beans.put("name", "张三丰");

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
