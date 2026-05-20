# Omayo Blogspot Automation Testing Project

This project automates testing of the Omayo Blogspot practice website using Selenium WebDriver, Java, TestNG, Maven and the Page Object Model (POM) design pattern.

This validates different web elements and interactions available on the Omayo practice site including forms, buttons, alerts, iframes and navigation components.

---

## Project Features

### UI Automation

- Page navigation testing
- Button and link interaction testing
- Form input validation
- Alert handling
- Iframe handling
- Web element verification
- Page Object Model (POM) implementation

---

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

---

## Project Structure

```text
OmayoBlogspot
│
├── src
│   ├── main
│   │   └── java
│   │       ├── HomePage.java
│   │       ├── BodyPage.java
│   │       └── TopbarPage.java
│   │
│   └── test
│       └── java
│           ├── BaseTest.java
│           ├── BodyTest.java
│           └── TopbarTest.java
│
├── pom.xml
└── .gitignore
```

---

## Test Scenarios

### Home Page Testing

- Navigate to Omayo website
- Verify page loading
- Validate page elements

### Top Bar Testing

- Verify navigation links
- Validate top menu functionality
- Test clickable elements

### Body Section Testing

- Verify buttons and text fields
- Handle alerts
- Test iframe interactions
- Validate page components

---

## Dependencies

The project uses the following Maven dependencies:

- Selenium Java
- Selenium Support
- TestNG
- WebDriver Manager

---

## How to Run the Project

### Clone repository

```bash
git clone <repository-url>
```

### Open project

Open the project using IntelliJ IDEA or any Java IDE.

### Install dependencies

Maven automatically downloads all required dependencies from:

```bash
pom.xml
```

### Run tests

Run TestNG classes:

- BodyTest
- TopbarTest

Or run all tests using Maven:

```bash
mvn test
```

---

