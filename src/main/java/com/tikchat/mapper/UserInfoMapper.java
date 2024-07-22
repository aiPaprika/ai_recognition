package com.tikchat.mapper;

import com.tikchat.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author Paprika
 * @since 2024-06-22
 */
@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
