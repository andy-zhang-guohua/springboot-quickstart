package me.mason.springbatch.controller;

import io.swagger.annotations.ApiOperation;
import me.mason.springbatch.common.SyncConstants;
import me.mason.springbatch.dto.ResponseResult;
import me.mason.springbatch.service.batch.JobLauncherService;
import me.mason.springbatch.util.JobUtil;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * console控制器
 *
 * @author mason
 * @date 2019/6/1
 */
@RestController
@RequestMapping("/console")
public class ConsoleController {

    @Autowired
    JobLauncherService jobLauncherService;

    @Autowired
    Job consoleJob;


    @ApiOperation(value = "运行任务", tags = "console", notes = "使用spring batch运行任务")
    @GetMapping("/run_job")
    public ResponseResult<String> runJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParameters jobParameters = JobUtil.makeJobParameters();
        Map<String, Object> stringObjectMap = jobLauncherService.startJob(consoleJob, jobParameters);
        Object resultStr = stringObjectMap.get(SyncConstants.STR_RETURN_RESULT);
        return ResponseResult.ok(resultStr);
    }
}
