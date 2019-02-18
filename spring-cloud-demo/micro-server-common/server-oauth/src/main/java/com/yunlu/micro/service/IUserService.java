package com.yunlu.micro.service;

import com.yunlu.micro.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService extends UserDetailsService {

    User loadDatianUserByUsername(String userName) throws UsernameNotFoundException;

}
