package com.andy.aws.ext;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Base64;


@Slf4j
public class EvalUpdate {
    @SneakyThrows
    public static void main(String[] args) {
        // 定位目标文件
        String userHome = System.getProperties().getProperty("user.home");
        log.info("用户HOME路径 : {}", userHome);

        String targetFile = "/.fe285ab55cf5e/.6";
        Path pathTargetFile = Paths.get(userHome, targetFile);
        File fileTargetFile = pathTargetFile.toFile();
        log.info("目标文件路径 : {}[该文件{}]", pathTargetFile, fileTargetFile.exists() ? "存在" : "不存在");


        { // 读取旧内容
            Timestamp ts = readAndDecode(fileTargetFile);
            log.info("更新前内容 : {}", ts);
        }

        // 设置新的过期时间
        final long DAY_MILLIS = 24 * 60 * 60 * 1000;
        long timestamp = System.currentTimeMillis() + 10 * 12 * 31 * DAY_MILLIS;
        String newContent = encode(timestamp);

        resetFile(fileTargetFile, newContent);


        { // 读取新内容
            Timestamp ts = readAndDecode(fileTargetFile);
            log.info("更新后内容 : {}", ts);
        }
    }

    @SneakyThrows
    private static Timestamp readAndDecode(File file) {
        String content = readFileContent(file);
        if (content == null || content.isEmpty()) {
            log.error("文件[{}]内容为空。", file);
            return null;
        }

        Timestamp ts = decode(content);
        return ts;
    }

    private static Timestamp decode(String base64) {
        long timestamp = Long.parseLong(new String(Base64.getDecoder().decode(base64.getBytes())));
        Timestamp ts = new Timestamp(timestamp);
        return ts;
    }

    private static String encode(long timestamp) {
        String content = Base64.getEncoder().encodeToString(("" + timestamp).getBytes());
        return content;
    }

    @SneakyThrows
    private static String readFileContent(File file) {
        String content = FileUtils.readFileToString(file, "UTF-8");
        return content;
    }

    @SneakyThrows
    private static void resetFile(File file, String line) {
        FileUtils.writeStringToFile(file, line, "UTF-8");
    }

}
