package com.eapi.modules.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eapi.modules.system.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author eitan
 * @since 2023-11-01
 */
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {

}
