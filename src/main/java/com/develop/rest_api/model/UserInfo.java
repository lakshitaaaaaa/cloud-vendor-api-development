package com.develop.rest_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="/user-info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo
{
    @Id
    private String userName;
    private String password;
    private String roles;

}
