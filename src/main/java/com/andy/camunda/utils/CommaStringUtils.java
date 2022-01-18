package com.andy.camunda.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 逗号分割的字符串处理工具
 * <p>
 */
@Slf4j
public class CommaStringUtils {

    /**
     * 获取逗号分割的非空元素
     * 例子 : "S20210900372,S20210900371" ==> ["S20210900372","S20210900371"]
     * 1. 会自动去除为空的元素
     *
     * @param commaSeparatedString 使用逗号作为分隔符的一个字符串
     * @return
     */
    public static List<String> split(String commaSeparatedString) {
        String trimmed = StringUtils.defaultString(commaSeparatedString).trim();

        if (StringUtils.isBlank(trimmed)) return Collections.EMPTY_LIST;

        String[] tokens = StringUtils.split(trimmed, ",");
        List<String> result = new ArrayList<>();

        Arrays.stream(tokens).forEach(token -> {
            String v = StringUtils.trim(token);

            if (StringUtils.isBlank(v)) return; // 跳过为空的元素

            result.add(v);
        });

        return result;
    }


    /**
     * 获取逗号分割的非空元素并去重
     *
     * @param commaSeparatedString
     * @return
     */
    public static List<String> splitThenDistinct(String commaSeparatedString) {
        List<String> list = split(commaSeparatedString);
        // 这里执行去重
        List<String> distinctList = list.stream().distinct().collect(Collectors.toList());
        return distinctList;
    }

    /**
     * 获取逗号分割的非空元素并去重,然后排序
     *
     * @param commaSeparatedString
     * @return
     */
    public static List<String> splitDistinctThenSort(String commaSeparatedString) {
        List<String> list = split(commaSeparatedString);
        // 这里执行去重
        List<String> distinctList = list.stream().distinct().sorted().collect(Collectors.toList());
        return distinctList;
    }
}
