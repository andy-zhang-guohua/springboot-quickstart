package andy.docx4j.test;

import andy.docx4j.DocxReplacerUtils;
import andy.docx4j.utils.RandomChineseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DocxReplacerTest {
    public static void main(String[] args) {
        String templateDocxFilePath = "D:\\idea_wks\\springboot-quickstart\\src\\main\\resources\\模板-多样性测试.docx";
        String targetDocxFilePath = "D:\\测试授权书.docx";

        Map<String, String> data = mockData1();
        Map<Integer, List<Map<String, String>>> tables = mockTablesData1();

        DocxReplacerUtils.replaceData(templateDocxFilePath, targetDocxFilePath, data, tables);
    }


    private static Map<String, String> mockData1() {
        Map<String, String> data = new TreeMap<>();

        data.put("占位符1","占位符一的值");
        data.put("占位符2","占位符II的值");
        data.put("占位符3","占位符III的值");
        return data;
    }

    private static Map<Integer, List<Map<String, String>>> mockTablesData1() {
        Map<Integer, List<Map<String, String>>> tables = new TreeMap<>();

        List<Map<String, String>> table0Data = randomAuthSubCompanyRows(1000);
        tables.put(0, table0Data);

        return tables;
    }

    private static List<Map<String, String>> randomAuthSubCompanyRows(int total) {
        List<Map<String, String>> rows = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            Map<String, String> map = new TreeMap<>();

            map.put("order", "" + (i + 1));
            map.put("companyName", RandomChineseUtils.randomChineseString(15));
            rows.add(map);
        }

        return rows;
    }
}
