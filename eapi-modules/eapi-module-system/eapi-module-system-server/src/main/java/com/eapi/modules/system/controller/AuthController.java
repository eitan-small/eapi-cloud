package com.eapi.modules.system.controller;

import com.eapi.common.core.domain.CommonResult;
import com.eapi.modules.system.service.AuthService;
import com.eapi.modules.system.vo.AuthLoginReqVO;
import com.eapi.modules.system.vo.AuthLoginRespVO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public CommonResult<AuthLoginRespVO> login(@RequestBody @Valid AuthLoginReqVO reqVO) {
        AuthLoginRespVO authLoginRespVO = authService.login(reqVO);
        return CommonResult.success(authLoginRespVO);
    }
}
