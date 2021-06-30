package me.mason.springbatch.example.console.config;

import me.mason.springbatch.example.console.listener.ConsoleJobEndListener;
import me.mason.springbatch.example.console.step.MyItemProcessor;
import me.mason.springbatch.example.console.step.MyItemReader;
import me.mason.springbatch.example.console.step.MyItemWriter;
import me.mason.springbatch.listener.CommonStepListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * console batch任务配置
 *
 * @author mason
 * @since 2019/6/1
 **/
@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job consoleJob(Step step, JobExecutionListener listener) {
        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return jobBuilderFactory.get(funcName)
                .listener(listener)
                .flow(step)
                .end().build();
    }


    @Bean
    public Step consoleStep(ItemReader reader, ItemProcessor processor, ItemWriter writer, CommonStepListener stepListener) {
        String funcName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return stepBuilderFactory.get(funcName)
                .listener(stepListener)
                .<String, String>chunk(3)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public ItemReader myItemReader() {
        return new MyItemReader();
    }

    @Bean
    public ItemWriter myItemWriter() {
        return new MyItemWriter();
    }

    @Bean
    public ItemProcessor myItemProcessor() {
        return new MyItemProcessor();
    }

    @Bean
    public JobExecutionListener myJobExecutionListener() {
        return new ConsoleJobEndListener();
    }

}
