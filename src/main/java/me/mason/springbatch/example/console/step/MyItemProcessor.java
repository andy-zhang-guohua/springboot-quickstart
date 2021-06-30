package me.mason.springbatch.example.console.step;

import lombok.extern.slf4j.Slf4j;
import me.mason.springbatch.common.LogConstants;
import me.mason.springbatch.service.ConsoleService;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 处理：字符转换
 *
 * @author mason
 * @since 2019/6/1
 **/
@Slf4j
public class MyItemProcessor implements ItemProcessor<String, String> {
    @Autowired
    private ConsoleService consoleService;

    @Override
    public String process(String data) {
        String dataProcessed = consoleService.convert2UpperCase(data);
        log.info(LogConstants.LOG_TAG + " 处理数据 : {} --> {}", data, dataProcessed);
        return dataProcessed;
    }
}
