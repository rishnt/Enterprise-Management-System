# 🏢 Enterprise Management System

A robust, scalable, and modular enterprise management platform built with Java and Spring Boot. This system provides a foundation for managing organizational processes, streamlining operations, and enabling enterprise Level service delivery.

---

## 📌 Overview

The **Enterprise Management System** is designed to offer a backend foundation for enterprise resource planning and administration. It includes built-in support for Maven, Docker, and Git versioning, making it easy to build, deploy, and maintain in modern DevOps Environment

---

## ⚙️ Tech Stack

- **Java 11+**
- **Spring Boot**
- **Maven** (with Wrapper support)
- **Docker**
- **Git**
- **Hibernate**
- **Spring Securit**
  
📂 Project Structure


<img width="400" height="300" alt="image" src="https://github.com/user-attachments/assets/65dc44c4-eaff-479c-9346-c32eecab6529" />

---

### 🚀 Features

Student Management – Add, update, fetch, and delete student records.

Professor Management – Manage professor details.

Subject Management – CRUD operations for subjects.

Admissions – Handle student admissions with validations.

Custom Validation – School name & student address validation.

RESTful APIs – Exposed endpoints for all entities.

### 📌 API Endpoints
#### Students
 ##### GET /students – Fetch all students
 ##### POST /students – Add a student
 ##### PUT /students/{id} – Update student details
 ##### DELETE /students/{id} – Delete student

#### Professors

 ##### GET /professors
 ##### POST /professors
 ##### PUT /professors/{id}
 ##### DELETE /professors/{id}

#### Subjects
 ##### GET /subjects
 ##### POST /subjects
 ##### PUT /subjects/{id}
 ##### DELETE /subjects/{id}

#### Admissions
 ##### GET /admissions
 ##### POST /admissions

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


