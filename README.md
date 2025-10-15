# 🧩 Customer & Accounts REST API — Spring Boot + OracleDB

A simple **banking-style CRUD API** built with **Spring Boot 3.5**, **Java 21**, and **Oracle XE 21c**.  
This project was created as a **practice run** for Java backend interviews and demonstrates how to build a clean, layered REST service using a real relational database.

---

## 🚀 Overview

This API simulates a very small slice of a **core banking system** — customer onboarding and basic account management.

**Tech Stack**

| Layer | Technology |
|-------|-------------|
| Language | Java 21 |
| Framework | Spring Boot 3.5.x |
| Database | Oracle XE 21c |
| ORM | Spring Data JPA (Hibernate) |
| Migrations | Flyway (with `flyway-database-oracle`) |
| Validation | Jakarta Bean Validation |
| API Docs | Springdoc OpenAPI 2.7.0 (Swagger UI) |
| Build Tool | Maven |

---

## 📦 Features

- CRUD operations for **Customers** and **Accounts**
- Oracle-backed persistence using **Flyway SQL migrations**
- Validation & exception handling
- OpenAPI documentation at `/swagger-ui.html`
- Idempotent logic and clean service layering
- Ready to run locally with Oracle XE

---

## 🧱 Domain Model

### `CUSTOMER`
| Field | Type | Notes |
|-------|------|-------|
| id | NUMBER | Primary key (sequence) |
| full_name | VARCHAR2(200) | Required |
| national_id | VARCHAR2(40) | Unique |
| email | VARCHAR2(200) | Unique |
| kyc_status | VARCHAR2(32) | Defaults to `PENDING` |
| created_at | TIMESTAMP | Default `SYSTIMESTAMP` |

### `ACCOUNT`
| Field | Type | Notes |
|-------|------|-------|
| id | NUMBER | Primary key (sequence) |
| customer_id | NUMBER | FK → CUSTOMER.id |
| type | VARCHAR2(32) | `SAVINGS` or `CHECKING` |
| currency | VARCHAR2(3) | e.g. `PEN`, `USD` |
| opened_at | TIMESTAMP | Default `SYSTIMESTAMP` |
| status | VARCHAR2(32) | Defaults to `ACTIVE` |

---

## ⚙️ Project Setup

### 1️⃣ Prerequisites
- **Java 21+**
- **Maven 3.9+**
- **Oracle XE 21c** (running locally)

### 2️⃣ Create Oracle Schema
Connect as `SYSTEM` in `SQL Developer` or `SQL*Plus`:

```sql
ALTER SESSION SET CONTAINER = XEPDB1;
CREATE USER app_user IDENTIFIED BY "Omelasuda32#@";
GRANT CONNECT, RESOURCE TO app_user;
ALTER USER app_user QUOTA UNLIMITED ON USERS;
