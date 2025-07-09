package com.develop.rest_api.repository;

import com.develop.rest_api.mapper.UserInfoMapper;
import com.develop.rest_api.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,String>
{
    Optional<UserInfo> findByUserName(String userName);


}
