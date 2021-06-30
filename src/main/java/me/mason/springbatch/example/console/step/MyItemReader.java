package me.mason.springbatch.example.console.step;

import lombok.extern.slf4j.Slf4j;
import me.mason.springbatch.common.LogConstants;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * 读取器，字符串读取器
 * 一个字符串数组，每个元素字符串表示一个 Item，每次读取一个元素字符串 Item 并返回给
 * @author  mason
 * @since  2019/6/1
 **/
@Slf4j
public class MyItemReader implements ItemReader<String> {
    private String[] messages = {"第一个字符串aa1","第二个字符串bb2","第三个字符串cc1","第四个字符串ddd4","第五个字符串eee5"};
    private int count = 0;
    @Override
    public String read() throws UnexpectedInputException, ParseException, NonTransientResourceException {
        if(count < messages.length){
            String message = messages[count++];
            log.info(LogConstants.LOG_TAG + " 读入数据 : {} ",message);
            return message;
        }else{
            log.info(LogConstants.LOG_TAG + " 读入数据结束.");
            count = 0;
        }
        return null;
    }
}
