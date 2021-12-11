package com.marwa.caroperations.responseDtos;


public class BaseResponse {
    private Integer responseCode;
    private String responseMessage;
    private String responseStatus;

    public void setBaseResponse(Integer code, String message, String status){
        this.responseCode = code;
        this.responseMessage = message;
        this.responseStatus = status;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = Integer.valueOf(responseCode);
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }
}
