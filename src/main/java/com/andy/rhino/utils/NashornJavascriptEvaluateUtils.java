package com.andy.rhino.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Map;

/**
 * 基于 Nashorn 的 javascript 脚本执行器
 */
public final class NashornJavascriptEvaluateUtils {
    /**
     * 单例模式的工作实例
     */
    private static ScriptEngine defaultDefaultScriptEngine = null;

    private static ScriptEngine getDefaultScriptEngine() {
        if (defaultDefaultScriptEngine != null) return defaultDefaultScriptEngine;

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript"); // 这里指定javascript,nashorn 都是使用 nashorn

        defaultDefaultScriptEngine = scriptEngine;

        return defaultDefaultScriptEngine;
    }

    public static String evalToString(String javascript, Map<String, Object> beans) {
        Object result = eval(javascript, beans);
        String strResult = result.toString();
        return strResult;
    }

    public static Object eval(String javascript, Map<String, Object> beans) {
        ScriptEngine scriptEngine = getDefaultScriptEngine();
        try {
            addCustomerBeansToScope(scriptEngine, beans);
            Object result = scriptEngine.eval(javascript);

            return result;
        } catch (Exception e) {
            throw new RuntimeException("执行Javascript脚本异常", e);
        }
    }

    /**
     * 添加定制的工作组件对象 beans 到可执行环境，在 javascript 中可以使用这些 对象
     *
     * @param scriptEngine
     * @param beans
     */
    private static void addCustomerBeansToScope(ScriptEngine scriptEngine, Map<String, Object> beans) {
        if (beans == null) return;

        beans.keySet().forEach(key -> {
            String name = key;
            Object value = beans.get(key);
            scriptEngine.put(key, value);
        });

    }
}
