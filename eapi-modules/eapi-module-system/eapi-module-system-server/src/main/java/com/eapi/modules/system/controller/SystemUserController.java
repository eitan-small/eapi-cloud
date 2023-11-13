package com.eapi.modules.system.controller;

import com.eapi.common.core.domain.CommonResult;
import com.eapi.modules.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author eitan
 * @since 2023-11-01
 */
@Validated
@RestController
@RequestMapping("/api/user")
public class SystemUserController {

    private SystemUserService systemUserService;

    @Autowired
    public SystemUserController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @PostMapping("/info")
    public CommonResult info() {
        return CommonResult.success();
    }
}
