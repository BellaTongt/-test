package com.yunlu.micro.service.impl;

import com.yunlu.micro.entity.User;
import com.yunlu.micro.mapper.UserMapper;
import com.yunlu.micro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userMapper.findByUsername(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码不正确!");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
        // TODO 数据库查询角色
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("query-demo");
        grantedAuthorities.add(grantedAuthority);
        // TODO 数据库查询权限
        GrantedAuthority authority = new SimpleGrantedAuthority("1");
        grantedAuthorities.add(authority);
        org.springframework.security.core.userdetails.User userD = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return userD;
    }


    @Override
    public User loadDatianUserByUsername(String userName) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userMapper.findByUsername(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UsernameNotFoundException("用户名或密码不正确!");
        }
        return user;
    }


}
