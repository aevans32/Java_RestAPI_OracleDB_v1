package com.example.customer_accounts_oracle.api.dto.Account;

public class AccountResponse {
    private Long id;
    private Long customerId;
    private String type;
    private String currency;
    private String status;

    public AccountResponse() {}

    public AccountResponse(Long id, Long customerId, String type, String currency, String status) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.currency = currency;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
