package com.eapi.modules.system.service;

import com.eapi.modules.system.vo.AuthLoginReqVO;
import com.eapi.modules.system.vo.AuthLoginRespVO;

public interface IAuthService {
    AuthLoginRespVO login(AuthLoginReqVO reqVO);
}
