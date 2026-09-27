# MyWebApp (springbootprojects2026)

## Overview

This project is a simple Java Servlet application built to understand basic servlet execution and HTTP cookie handling: how a servlet writes cookies to a response, and how a later request reads cookies sent back by the browser.

Despite the repository name, this is a plain Servlet/Tomcat project, not a Spring Boot application.

## Technology Stack

- Java 17
- Java Servlet API 4.0.1 (`javax.servlet`, provided scope)
- Maven, packaged as a WAR file
- JUnit 4.13.1 (test scope only; no tests are currently implemented)
- PostgreSQL JDBC Driver 42.7.8 is declared as a dependency but is not used anywhere in the current code

As with the `servletJDBC` repository, the `javax.servlet` namespace means this project must be deployed to Apache Tomcat 9.x rather than Tomcat 10 or later.

## Project Structure

```
springbootprojects2026
├── pom.xml
└── src/main
    ├── java/com/example
    │   ├── HelloServlet.java           Static response, ignores request parameters
    │   ├── SendCookiesDemo.java        Adds two cookies to the response
    │   └── RequestCookiesDemo.java     Reads and prints all cookies from the request
    └── webapp
        ├── WEB-INF/web.xml             Servlet and URL-mapping declarations
        └── index.html                  Form posting to HelloServlet
```

## Prerequisites

- JDK 17 or later
- Apache Maven
- Apache Tomcat 9.x installed separately
- No database is required to run this project, even though a PostgreSQL driver is listed as a dependency

## Cloning and Running

```
git clone https://github.com/senthilmuruganb/springbootprojects2026.git
cd springbootprojects2026
mvn clean package
```

This produces `target/MyWebApp.war`. Deploy it to Tomcat 9 in one of the following ways:

- Copy `target/MyWebApp.war` into the Tomcat `webapps` directory and start Tomcat, or
- In Eclipse/STS, add a Tomcat 9 server runtime, right-click the project, and choose Run As > Run on Server.

Once deployed, the application is available at:

```
http://localhost:8080/MyWebApp/index.html
```

(Adjust the port and context path if Tomcat or the WAR name are configured differently.)

## Application Walkthrough

To see the cookie demonstration work correctly, the two cookie servlets must be visited in a specific order, in the same browser session:

1. Visit `/SendCookiesDemo` first. This adds two cookies to the response: `username=MCAvit2026` and `userID=TestGmail`.
2. Visit `/RequestCookiesDemo` next, in the same browser. This reads `request.getCookies()` and prints the name and value of every cookie sent by the browser, which will now include the two cookies set in step 1.

`HelloServlet` is a separate, minimal example reached from `index.html`: the form collects a name but the servlet does not read it and always returns the same static message.

## Notes

- `RequestCookiesDemo` does not check whether `request.getCookies()` returns null before iterating over it. If this servlet is visited directly, without first visiting `SendCookiesDemo` in the same browser session (or if the browser sends no cookies for any other reason), the servlet will throw a `NullPointerException` rather than displaying a message such as "no cookies found."
