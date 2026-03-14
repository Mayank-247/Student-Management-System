# 🎓 Student Management System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Database_Connectivity-6DB33F?style=for-the-badge)

![Repo Size](https://img.shields.io/github/repo-size/Mayank-247/Student-Management-System?style=for-the-badge)
![Stars](https://img.shields.io/github/stars/Mayank-247/Student-Management-System?style=for-the-badge)
![Last Commit](https://img.shields.io/github/last-commit/Mayank-247/Student-Management-System?style=for-the-badge)

A **console-based Student Management System** built using **Java, JDBC, and MySQL**.
The system allows users to manage student records stored in a MySQL database through a simple command-line interface.

---

## ✨ Features

* ➕ Add a new student
* 📋 View all students
* 🔍 Search student by ID
* ✏️ Update student details
* ❌ Delete student record
* 📊 Display total number of students

---

## 🛠 Technologies Used

* **Java**
* **JDBC (Java Database Connectivity)**
* **MySQL**
* **IntelliJ IDEA**
* **Git & GitHub**

---

## 🧠 Key Concepts Implemented

* Object-Oriented Programming (OOP)
* DAO (Data Access Object) Design Pattern
* JDBC Database Connectivity
* CRUD Operations
* Input Validation
* Modular Project Structure

---

## 📂 Project Structure

```
Student-Management-System
│
├── src
│   ├── app
│   │     └── Main.java
│   │
│   ├── dao
│   │     └── StudentDAO.java
│   │
│   ├── db
│   │     └── DBConnection.java
│   │
│   └── model
│         └── Student.java
│
├── db.properties.example
├── README.md
└── .gitignore
```

---

## 🗄 Database Setup

Create a database in MySQL:

```sql
CREATE DATABASE studentdb;
USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    branch VARCHAR(50),
    age INT,
    cgpa FLOAT
);
```

---

## ▶️ How to Run the Project

### 1️⃣ Clone the repository

```
git clone <https://github.com/Mayank-247/Student-Management-System.git>
```

### 2️⃣ Open the project

Open the project in **IntelliJ IDEA**.

### 3️⃣ Configure database credentials

Copy the example file:

```
db.properties.example
```

Rename it to:

```
db.properties
```

Then add your MySQL credentials inside the file:

```
db.url=jdbc:mysql://localhost:3306/studentdb
db.user=root
db.password=your_password_here
```

### 4️⃣ Run the program

Run:

```
Main.java
```

---

## 🖥 Program Preview

![Program Output](assets/program-output.png)

---

## 📌 Learning Outcomes

This project demonstrates:

* Java **Object-Oriented Programming**
* **JDBC database connectivity**
* **DAO design pattern**
* Implementation of **CRUD operations**
* Building a **modular Java application**

---

## 🚀 Future Improvements

Possible enhancements:

* GUI interface using **Java Swing**
* Search student by **name**
* Export student data to **CSV / Excel**
* **User authentication system**
* Web version using **Spring Boot**

---

## 👤 Author

**Mayank Singh**
