package com.yunlu.micro.mapper;

import com.yunlu.micro.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User findByUsername(String username);

}
