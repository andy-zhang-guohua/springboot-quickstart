package com.andy.rhino.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 基于 Nashorn 的 javascript 脚本执行器
 */
public final class NashornJavascriptEvaluateUtils {
    public static String evalToString(String javascript) {
        Object result = eval(javascript);
        String strResult = result.toString();
        return strResult;
    }

    public static Object eval(String javascript) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript"); // 这里指定javascript,nashorn 都是使用 nashorn
        try {
            Object result = scriptEngine.eval(javascript);

            return result;
        } catch (Exception e) {
            throw new RuntimeException("执行Javascript脚本异常", e);
        }
    }
}
