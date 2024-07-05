package com.devteria.identity_service.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class UserCreationRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dob;
}
