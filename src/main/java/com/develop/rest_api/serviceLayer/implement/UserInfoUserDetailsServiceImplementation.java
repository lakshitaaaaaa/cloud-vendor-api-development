package com.develop.rest_api.serviceLayer.implement;

import com.develop.rest_api.mapper.UserInfoUserDetailMapper;
import com.develop.rest_api.model.UserInfo;
import com.develop.rest_api.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(username);

        return userInfo.map(UserInfoUserDetailMapper::new)
                .orElseThrow(()->new UsernameNotFoundException("User "+username+" not found."));
    }
}
