package com.develop.rest_api.contoller;

import com.develop.rest_api.dto.UserInfoDto;
import com.develop.rest_api.serviceLayer.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-info")
public class UserInfoController
{
    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/register")
    public ResponseEntity<String> createUserInfo(@RequestBody UserInfoDto userInfoDto)
    {
         UserInfoDto userInfoDto1 = userInfoService.createUser(userInfoDto);
         return new ResponseEntity<>("user "+userInfoDto1.userName()+" has been successfully created.",HttpStatus.OK);
    }
}
