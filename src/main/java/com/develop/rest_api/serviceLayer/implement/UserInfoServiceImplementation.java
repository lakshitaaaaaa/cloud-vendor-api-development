package com.develop.rest_api.serviceLayer.implement;

import com.develop.rest_api.dto.UserInfoDto;
import com.develop.rest_api.mapper.UserInfoMapper;
import com.develop.rest_api.model.UserInfo;
import com.develop.rest_api.repository.UserInfoRepository;
import com.develop.rest_api.serviceLayer.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImplementation implements UserInfoService
{
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public UserInfoDto createUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = UserInfoMapper.toEntity(userInfoDto);
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return UserInfoMapper.toDto(userInfo);
    }
}
