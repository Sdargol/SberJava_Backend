package com.sdargol.DTO;

public final class ValidExceptionResponse {
    private String error;

    public ValidExceptionResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
