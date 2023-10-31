package com.eapi.modules.system.service.impl;

import com.eapi.modules.system.service.IAuthService;
import com.eapi.modules.system.vo.AuthLoginReqVO;
import com.eapi.modules.system.vo.AuthLoginRespVO;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    @Override
    public AuthLoginRespVO login(AuthLoginReqVO reqVO) {
        return null;
    }
}
