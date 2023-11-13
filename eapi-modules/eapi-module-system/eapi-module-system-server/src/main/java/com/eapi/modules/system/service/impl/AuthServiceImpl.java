package com.eapi.modules.system.service.impl;

import com.eapi.common.core.constant.SecurityConstants;
import com.eapi.common.core.exception.ServiceException;
import com.eapi.common.core.util.JwtUtils;
import com.eapi.modules.system.entity.SystemUser;
import com.eapi.modules.system.service.AuthService;
import com.eapi.modules.system.service.SystemUserService;
import com.eapi.modules.system.vo.AuthLoginReqVO;
import com.eapi.modules.system.vo.AuthLoginRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    private SystemUserService systemUserService;

    @Autowired
    public AuthServiceImpl(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }


    @Override
    public AuthLoginRespVO login(AuthLoginReqVO authLoginReqVO) {
        String username = authLoginReqVO.getUsername();
        // 密码使用 md5 加密
        String password = DigestUtils.md5DigestAsHex(authLoginReqVO.getPassword().getBytes());

        // 根据用户名查询出用户数据
        SystemUser systemUser = systemUserService.getUserByUsername(username);

        if (Objects.isNull(systemUser) || !password.equals(systemUser.getPassword())) {
            throw new ServiceException("用户名不存在/密码不正确");
        }

        // Jwt存储信息
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put(SecurityConstants.DETAILS_USER_ID, systemUser.getId());
        claimsMap.put(SecurityConstants.DETAILS_USERNAME, systemUser.getUsername());


        // 返回 authLoginRespVO
        AuthLoginRespVO authLoginRespVO = new AuthLoginRespVO();
        authLoginRespVO.setToken(JwtUtils.createToken(claimsMap));

        return authLoginRespVO;
    }
}
