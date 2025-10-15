package com.example.customer_accounts_oracle.domain;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @SequenceGenerator(name="customer_seq", sequenceName = "SEQ_CUSTOMER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long id;

    @Column(name="FULL_NAME", nullable=false, length=200)
    private String fullName;

    @Column(name="NATIONAL_ID", nullable=false, unique=true, length=40)
    private String nationalId;

    @Column(name="EMAIL", nullable=false, unique=true, length=200)
    private String email;

    @Column(name="KYC_STATUS", nullable=false, length=32)
    private String kycStatus = "PENDING";

    @Column(name="CREATED_AT", nullable=false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
