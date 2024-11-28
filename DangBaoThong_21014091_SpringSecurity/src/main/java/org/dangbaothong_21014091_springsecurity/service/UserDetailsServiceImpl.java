/*
 * @ (#) UserDetailsServiceImpl.java    1.0    27/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.dangbaothong_21014091_springsecurity.service;/*
 * @description:
 * @author: Bao Thong
 * @date: 27/11/2024
 * @version: 1.0
 */

import org.dangbaothong_21014091_springsecurity.dao.AppRoleDAO;
import org.dangbaothong_21014091_springsecurity.dao.AppUserDAO;
import org.dangbaothong_21014091_springsecurity.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private AppRoleDAO appRoleDAO;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDAO.findUserAccount(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [USER, ADMIN,..]
        List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getUserId());
        System.out.println("Roles for user: " + roleNames);

        // Convert roles to Spring Security's GrantedAuthority format
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                grantList.add(authority);
            }
        }

        // Create UserDetails object
        return new User(appUser.getUserName(), appUser.getEncrytedPassword(), grantList);
    }
}
