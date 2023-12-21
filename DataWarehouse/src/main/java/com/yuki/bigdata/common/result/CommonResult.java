package com.yuki.bigdata.common.result;

import lombok.Data;

@Data
public class CommonResult<T> {
    private long time;

    private T data;

    private CommonResult(long time,T data){
        this.time =time;
        this.data=data;
    }

    public static<T> CommonResult<T> success(long time,T data){
        return new CommonResult<>(time,data);
    }

    public static <T> CommonResult<T> success(long seconds){
        return CommonResult.success(seconds,null);
    }
}
