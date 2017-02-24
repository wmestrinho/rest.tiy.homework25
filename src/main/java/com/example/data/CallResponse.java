package com.example.data;

/**
 * Created by WagnerMestrinho on 2/23/17.
 */
public class CallResponse {
        private boolean success;
        private int number;

    public CallResponse(){}

    public CallResponse(boolean success, int number) {
        this.success = success;
        this.number = number;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
