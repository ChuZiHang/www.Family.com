package com.family.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Q_先森 on 2017/11/24.
 */
public class MyUserDetailsService implements UserDetailsService {
    private MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysAuthorityRepository sysAuthorityRepository;

    @Autowired
    private SysUserAuthorityRepository sysUserAuthorityRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.findByUserNameAndStatus(username, 1);
        if(sysUser == null) {
            throw new UsernameNotFoundException(
                    this.messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} not found"));
        }
        String password = sysUser.getPassword();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(sysUser.getIsManager() == 1) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));// 超级管理员
        }
        List<SysUserAuthority> sysUserAuthorities = sysUserAuthorityRepository.findByUserId(sysUser.getId());
        if(!CollectionUtils.isEmpty(sysUserAuthorities)) {
            Set<Long> authorityIds = new HashSet<>();
            sysUserAuthorities.forEach(sysUserAuthority -> {
                authorityIds.add(sysUserAuthority.getAuthorityId());
            });
            List<SysAuthority> sysAuthorities = sysAuthorityRepository.findByIdIn(authorityIds);
            sysAuthorities.forEach(sysAuthority -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(sysAuthority.getExpression()));
            });
        }

        return new User(username, password, grantedAuthorities);
    }
}
