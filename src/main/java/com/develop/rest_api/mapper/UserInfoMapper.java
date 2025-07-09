package com.develop.rest_api.mapper;

import com.develop.rest_api.dto.UserInfoDto;
import com.develop.rest_api.model.UserInfo;

public class UserInfoMapper {

    public static UserInfoDto toDto(UserInfo userInfo)
    {
        return new UserInfoDto(userInfo.getUserName(),userInfo.getPassword(),userInfo.getRoles());
    }

    public static UserInfo toEntity(UserInfoDto userInfoDto){
        return new UserInfo(userInfoDto.userName(),userInfoDto.password(),userInfoDto.roles());
    }
}
