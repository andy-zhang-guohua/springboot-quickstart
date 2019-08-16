package andy.tut.springboot.zero.controller;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author ZhangGuohua
 * @date 2019-08-16
 */
@Data
public class ApiResult {
    LocalDateTime requestTime;
    LocalDateTime responseTime;
    Object requestData;

    ApiResult(Object data, LocalDateTime requestTime) {
        this.requestData = data;
        this.requestTime = requestTime;
    }
}
