package com.marwa.caroperations.helpers;

import org.springframework.http.HttpStatus;

public class Constants {
    public static final Integer OK = HttpStatus.OK.value();
    public static final Integer BAD_REQUEST = HttpStatus.BAD_REQUEST.value();
    public static final Integer SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public static final String OK_STR = "Success";
    public static final String BAD_REQUEST_STR = "Bad Request";
    public static final String SERVER_ERROR_STR = "Server Error";

}
