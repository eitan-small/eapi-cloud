package com.eapi.common.core.domain;

import com.eapi.common.core.domain.CommonResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseController {
    /**
     * 返回成功
     */
    public CommonResult success() {
        return CommonResult.success();
    }

    /**
     * 返回成功消息
     */
    public CommonResult success(String message) {
        return CommonResult.success(message);
    }

    /**
     * 返回成功消息
     */
    public CommonResult success(Object data) {
        return CommonResult.success(data);
    }

    /**
     * 返回失败消息
     */
    public CommonResult error() {
        return CommonResult.error();
    }

    /**
     * 返回失败消息
     */
    public CommonResult error(String message) {
        return CommonResult.error(message);
    }

    /**
     * 返回警告消息
     */
    public CommonResult warn(String message) {
        return CommonResult.warn(message);
    }
}
