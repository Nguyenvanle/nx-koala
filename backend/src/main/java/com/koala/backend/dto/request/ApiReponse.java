package com.devteria.identity_service.dto.request;

import lombok.Data;

@Data
public class ApiReponse <T>{
    private int code;
    private String message;
    private T result;
}
