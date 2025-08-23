# 🏢 Enterprise Management System

A robust, scalable, and modular enterprise management platform built with Java and Spring Boot. This system provides a foundation for managing organizational processes, streamlining operations, and enabling enterprise-level service delivery.

---

## 📌 Overview

The **Enterprise Management System** is designed to offer a backend foundation for enterprise resource planning and administration. It includes built-in support for Maven, Docker, and Git versioning, making it easy to build, deploy, and maintain in modern DevOps environments.

---

## ⚙️ Tech Stack

- **Java 11+**
- **Spring Boot**
- **Maven** (with Wrapper support)
- **Docker**
- **Git**
- **Hibernate**
  
📂 Project Structure
Enterprise-Management-System/
│── src/main/java/com/rishant/Enterprise/Management/System/
│   ├── Configuration/        # App configurations
│   ├── Controller/           # REST Controllers (Student, Professor, Subject, Admission)
│   ├── DataValidation/       # Custom validators
│   ├── DTO/                  # Data Transfer Objects
│   ├── Entity/               # JPA Entities
│   ├── Repository/           # Spring Data Repositories
│   ├── Service/              # Business logic layer
│   └── EnterpriseManagementSystemApplication.java  # Main Spring Boot app
│
│── src/main/resources/
│   ├── application.properties  # Application configs
│   ├── admissions_500.csv      # Sample dataset
│
│── src/test/java/...           # Unit & Integration tests
│── pom.xml                     # Maven dependencies

---

## 🚀 Getting Started

### ✅ Prerequisites

Before you begin, ensure you have the following installed:

- Java 11 or later
- Maven 3.x
- Docker (optional but recommended for containerization)
## ▶️ Run the Application
      
### Using Spring Boot
     ./mvnw spring-boot:run

### Using Docker 
```
docker build -t enterprise-management-system .
docker run -p 8080:8080 enterprise-management-system
```

### 📦 Build the Project

Use the Maven wrapper to build the application:
```
./mvnw clean install


