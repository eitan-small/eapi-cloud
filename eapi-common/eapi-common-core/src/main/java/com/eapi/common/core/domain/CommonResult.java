package com.eapi.common.core.domain;

import com.eapi.common.core.constant.Constants;
import com.eapi.common.core.constant.HttpStatus;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = HttpStatus.SUCCESS;

    /**
     * 失败
     */
    public static final int ERROR = HttpStatus.ERROR;

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 数据对象
     */
    private T data;

    public static <T> CommonResult<T> success() {
        return restResult(null, SUCCESS, Constants.EMPTY_STRING);
    }

    public static <T> CommonResult<T> success(T data) {
        return restResult(data, SUCCESS, Constants.EMPTY_STRING);
    }

    public static <T> CommonResult<T> success(T data, String msg) {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> CommonResult<T> error() {
        return restResult(null, ERROR, Constants.EMPTY_STRING);
    }

    public static <T> CommonResult<T> error(String msg) {
        return restResult(null, ERROR, msg);
    }

    public static <T> CommonResult<T> error(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> CommonResult<T> restResult(T data, int code, String msg) {
        CommonResult<T> apiResult = new CommonResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
