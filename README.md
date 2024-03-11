# merchandise
An e-commerce application allowing the customers to buy/lease products and even sell their own products.
This is an attempt to apply all the important features of Spring Boot framework and React and go a step further and integrate microservice for 
authentication.

We have used PostgreSQL as the database, and flyway to create migration scripts for the changes we make to our entities going ahead.

Steps for setting up the project and get started.
Backend:
1. Install PostgreSQl
2. Create a new role and replace the existing role in application.properties under resources
3. Create a PostgreSQL database on port 5432 and make the new role owner of this database
4. Replace the DATABASE_PASSWORD variable with your own password.
5. Make sure you have Java 21 installed on your system or simply use IntelliJ's integrated JDK 21.
6. If you are using IntelliJ's integrated JDK, simply select the runner on the navbar and select your main class by editing the configuration.
7. After doing that, simply click on the Run button and it will be up and running.
   
8. If you are doing normal installation, then follow along.
9. Install maven from the official website and follow the specific instructions depending on your OS.
10. Install JAVA 21
11. Run: mvn clean install
12. mvn spring-boot:run

This will get it up and running.

Steps for setting the front end of this application.
