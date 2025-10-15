package com.example.customer_accounts_oracle.api.dto.Customer;

public class CustomerResponse {

    private Long id;
    private String fullName;
    private String nationalId;
    private String email;
    private String kycStatus;

    public CustomerResponse() {}

    public CustomerResponse(Long id, String fullName, String nationalId, String email, String kycStatus) {
        this.id = id;
        this.fullName = fullName;
        this.nationalId = nationalId;
        this.email = email;
        this.kycStatus = kycStatus;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getNationalId() { return nationalId; }
    public void setNationalId(String nationalId) { this.nationalId = nationalId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getKycStatus() { return kycStatus; }
    public void setKycStatus(String kycStatus) { this.kycStatus = kycStatus; }

}
