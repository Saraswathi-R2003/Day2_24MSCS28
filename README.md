📘 Day2-24MSCS28 - Maven Project

This project is part of the Day 2 internship task, focusing on setting up and working with a **Maven project** using core Java concepts such as **inheritance** and **exception handling**, with the integration of commonly used libraries via Maven dependencies.

✅ Project Overview

The project titled `Day2-24MSCS28` includes the following:

a) Maven Configuration

The project uses Maven for build automation and dependency management. The following dependencies are added in the `pom.xml`:

* **Apache Log4j SLF4J Binding**
  Used for logging purposes with SLF4J as the facade and Log4j as the underlying logging implementation.

* **Apache Commons CLI**
  Provides a simple API for parsing command-line options passed to the program.

* **MongoDB Java Driver (Sync)**
  Enables Java applications to connect and perform operations on MongoDB using the synchronous driver.

#### Example Snippet from `pom.xml`:

```xml
<dependencies>
    <!-- SLF4J + Log4j -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>1.7.36</version>
    </dependency>

    <!-- Apache Commons CLI -->
    <dependency>
        <groupId>commons-cli</groupId>
        <artifactId>commons-cli</artifactId>
        <version>1.5.0</version>
    </dependency>

    <!-- MongoDB Driver Sync -->
    <dependency>
        <groupId>org.mongodb</groupId>
        <artifactId>mongodb-driver-sync</artifactId>
        <version>5.5.1</version>
    </dependency>
</dependencies>
```

b) Library Management System (Using Inheritance)

This module demonstrates **Object-Oriented Programming** using inheritance:

* **Base Class**: `Book`

  * Fields: `title`, `author`, `isbn`
  * Methods: `displayDetails()`

* **Subclasses**:

  * `FictionBook`: Adds a `genre` field
  * `NonFictionBook`: Adds a `subject` field

Each subclass inherits from the base `Book` class and overrides the `displayDetails()` method accordingly.

c) Basic Banking System (Exception Handling)

This part simulates a simple banking application with the following features:

* **Create Account**
* **Deposit Money**
* **Withdraw Money**
* **Check Balance**

Exception Handling Implemented:

* **OverdraftException**: Thrown when attempting to withdraw more than the balance.
* **InvalidTransactionException**: Thrown for negative deposits or withdrawals.
* **AccountNotFoundException**: Thrown when performing operations on a non-existent account.

Certainly! Here's the updated and finalized **“How to Build and Run”** section for your `README.md`, with the **actual main classes** for `LibraryManagement` and `BankingSystem` specified:

---

⚙️ How to Build and Run This Project

Follow these steps to **clone**, **build**, and **run** this Maven-based Java project.
---
### 🧩 Prerequisites

Ensure the following are installed on your machine:
* Java Development Kit (JDK 8 or later)
* Apache Maven
* Git
---

### 📥 1. Clone the Repository
Open your terminal (e.g., Git Bash or CMD) and run:

```bash
git clone https://github.com/Saraswathi-R2003/Day2_24MSCS28.git
cd Day2_24MSCS28
```
---

### 🛠️ 2. Build the Project

Once inside the project folder, build the Maven project to download dependencies and compile code:
```bash
mvn clean install
```

> This command cleans the previous build (if any), resolves dependencies (like MongoDB driver, Log4j, Commons CLI), compiles the code, and packages the application.

---

### 🚀 3. Run the Project

Use the following commands to run the main classes:

#### ▶️ Run the Library Management System

```bash
mvn exec:java -Dexec.mainClass="com.day2.library.LibraryManagement"
```

#### ▶️ Run the Banking System

```bash
mvn exec:java -Dexec.mainClass="com.day2.banking.BankingSystem"
```

> Ensure these classes contain the `public static void main(String[] args)` method.

---

### 🔄 4. Push Changes to GitHub

If you’ve made changes and want to push them to GitHub, use:

```bash
git add .
git commit -m "Your message here"
git pull --rebase origin main
git push origin main
```

> This ensures your local commits are in sync with remote changes before pushing.

---
## 🎥 References

* **Article**: [Maven Introduction - Baeldung](https://www.baeldung.com/maven)
* **Video Tutorial**: [YouTube - Maven Project Setup](https://www.youtube.com/watch?v=793-O43F-ng)

---

## 👨‍💻 Author

**Name**: Saraswathi R
**Registration Number**: 24MSCS28
