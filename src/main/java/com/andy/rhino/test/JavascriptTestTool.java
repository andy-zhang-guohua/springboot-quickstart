package com.andy.rhino.test;


import com.andy.rhino.utils.JsonUtils;

import java.util.List;

public class JavascriptTestTool {
    public static String run1(List<String> list) {
        return "This is a list : " + JsonUtils.toString(list);
    }

    public static String run2(String[] array) {
        return "This is an array : " + JsonUtils.toString(array);
    }

    public static String run3(String... parameters) {
        return "This is ... parameters : " + JsonUtils.toString(parameters);
    }
}
