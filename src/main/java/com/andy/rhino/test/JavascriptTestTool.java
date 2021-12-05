package com.andy.rhino.test;


import com.andy.rhino.utils.JsonUtils;

import java.util.List;


public class JavascriptTestTool {
    /**
     * 参数是一个 字符串列表
     *
     * @param list
     * @return
     */
    public static String run1(List<String> list) {
        return "This is a list : " + JsonUtils.toString(list);
    }

    /**
     * 参数是一个字符串数组
     *
     * @param array
     * @return
     */
    public static String run2(String[] array) {
        return "This is an array : " + JsonUtils.toString(array);
    }

    /**
     * 参数为可变参数，类型都是字符串
     *
     * @param parameters
     * @return
     */
    public static String run3(String... parameters) {
        return "This is ... parameters : " + JsonUtils.toString(parameters);
    }
}
