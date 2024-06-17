package com.financialServices.transactionprocessingservice.model;

import org.apache.hc.core5.http.HttpStatus;

public class CustomErrorResponse {
    private HttpStatus status;
    private String message;
    private String details;
    public CustomErrorResponse() {
    }
    public CustomErrorResponse(HttpStatus status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    
}
