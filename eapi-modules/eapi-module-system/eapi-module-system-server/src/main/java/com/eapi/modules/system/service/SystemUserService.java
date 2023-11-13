package com.eapi.modules.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.eapi.modules.system.entity.SystemUser;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author eitan
 * @since 2023-11-01
 */
public interface SystemUserService extends IService<SystemUser> {

    SystemUser getUserByUsername(String username);
}
