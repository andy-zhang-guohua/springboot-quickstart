package com.andy.rhino.utils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public final class JacobPdfUtils {

    /**
     * 使用 WPS 将 word 文档转换为 pdf 格式
     *
     * @param sourceWordFile
     * @param targetPdfFile
     */
    public static void convertWordToPdfUsingWPS(String sourceWordFile, String targetPdfFile) {
        convertWordToPdfUsingWPS(sourceWordFile, targetPdfFile, "KWPS");
    }

    /**
     * 使用 微软 WORD 将 word 文档转换为 pdf 格式
     *
     * @param sourceWordFile
     * @param targetPdfFile
     */
    public static void convertWordToPdfUsingMSWord(String sourceWordFile, String targetPdfFile) {
        convertWordToPdfUsingWPS(sourceWordFile, targetPdfFile, "WORD");
    }

    /**
     * 使用指定工具 tool 将 word 转换为 pdf 格式
     *
     * @param sourceWordFile
     * @param targetPdfFile
     * @param tool           KWPS , WORD
     */
    private static void convertWordToPdfUsingWPS(String sourceWordFile, String targetPdfFile, String tool) {
        ActiveXComponent app = null;

        // 开始时间
        long start = System.currentTimeMillis();
        try {
            // 打开word
            app = new ActiveXComponent(tool + ".Application");
            // 设置word不可见,很多博客下面这里都写了这一句话，其实是没有必要的，因为默认就是不可见的，如果设置可见就是会打开一个word文档，对于转化为pdf明显是没有必要的
            //app.setProperty("Visible", false);
            // 获得word中所有打开的文档
            Dispatch documents = app.getProperty("Documents").toDispatch();

            // 打开文档
            Dispatch document = Dispatch.call(documents, "Open", sourceWordFile, false, true).toDispatch();
            // 如果文件存在的话，不会覆盖，会直接报错，所以我们需要判断文件是否存在
            File target = new File(targetPdfFile);
            if (target.exists()) {
                target.delete();
            }

            // 另存为，将文档报错为pdf，其中word保存为pdf的格式宏的值是17
            Dispatch.call(document, "SaveAs", targetPdfFile, 17);
            // 关闭文档
            Dispatch.call(document, "Close", false);
            // 结束时间
            long end = System.currentTimeMillis();
            log.info("Word转换PDF转换成功[{}={}],耗时：{} ms", sourceWordFile, targetPdfFile, end - start);
        } catch (Exception e) {
            e.getMessage();
            log.error("Word转换PDF转换成功[{}={}]", sourceWordFile, targetPdfFile, e);
        } finally {
            // 关闭office
            app.invoke("Quit", 0);
        }
    }
}
