package com.andy.rhino.utils;

import org.mozilla.javascript.*;

import java.util.Map;

/**
 * 基于 Rhino 的 javascript 脚本执行器
 */
public final class RhinoJavascriptEvaluateUtils {
    public static String evalToString(String javascript, Map<String, Object> beans) {
        Object result = eval(javascript, beans);
        String strResult = ScriptRuntime.toString(result);
        return strResult;
    }

    public static Object eval(String javascript, Map<String, Object> beans) {
        Context context = Context.enter();
        try {
            Scriptable scope = context.initStandardObjects();

            addCustomerBeansToScope(scope, beans);


            Script script = context.compileString(javascript, null, 1, null);
            Object result = script.exec(context, scope);


            if (result != null && result instanceof NativeJavaObject) {
                Object javaObject = ((NativeJavaObject) result).unwrap();
                return javaObject;
            }

            return result;
        } catch (Exception e) {
            throw new RuntimeException("执行Javascript脚本异常", e);
        } finally {
            Context.exit();
        }
    }

    /**
     * 添加定制的工作组件对象 beans 到可执行环境，在 javascript 中可以使用这些 对象
     * @param scope
     * @param beans
     */
    private static void addCustomerBeansToScope(Scriptable scope, Map<String, Object> beans) {
        if (beans == null) return;

        beans.keySet().forEach(key -> {
            String name = key;
            Object value = beans.get(key);
            ScriptableObject.putProperty(scope, key, value);
        });

    }
}
