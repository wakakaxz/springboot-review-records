package com.xz.mapper;

import com.xz.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xz
 */

@Mapper
public interface UserMapper {

    /**
     * @param id id
     * @return 根据 id 获取User
     */
    public User getUserById(Long id);
}
