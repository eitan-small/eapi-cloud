package com.eapi.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.eapi.modules.system.entity.SystemUser;
import com.eapi.modules.system.mapper.SystemUserMapper;
import com.eapi.modules.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author eitan
 * @since 2023-11-01
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements SystemUserService {

    private SystemUserMapper systemUserMapper;

    @Autowired
    public SystemUserServiceImpl(SystemUserMapper systemUserMapper) {
        this.systemUserMapper = systemUserMapper;
    }

    @Override
    public SystemUser getUserByUsername(String username) {
        return new LambdaQueryChainWrapper<>(systemUserMapper)
                .eq(SystemUser::getUsername, username)
                .last("LIMIT 1")
                .one();
    }
}
