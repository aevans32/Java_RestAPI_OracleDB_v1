package com.example.customer_accounts_oracle.api.dto.Customer;

import jakarta.validation.constraints.*;

public class CreateCustomerRequest {

    @NotBlank
    @Size(max = 200)
    private String fullName;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\-\\.]{6,40}$")
    private String nationalId;

    @NotBlank
    @Email
    @Size(max = 200)
    private String email;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalId() {
        return nationalId;
    }
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
