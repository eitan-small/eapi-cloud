package com.eapi.modules.system.controller;

import com.eapi.common.core.domain.CommonResult;
import com.eapi.modules.system.service.IAuthService;
import com.eapi.modules.system.vo.AuthLoginReqVO;
import com.eapi.modules.system.vo.AuthLoginRespVO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.eapi.common.core.domain.CommonResult.success;

@Validated
@RestController
public class AuthController {
    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public CommonResult<AuthLoginRespVO> login(@RequestBody @Valid AuthLoginReqVO reqVO) {
        return success(authService.login(reqVO));
    }
}
