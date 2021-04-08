package com.sdargol.dto;

public class MoneyRequest {
    private Integer amount;

    public MoneyRequest() {
    }

    public MoneyRequest(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
