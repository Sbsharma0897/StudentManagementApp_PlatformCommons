# StudentManagementSystem

<!-- ============================================  TITLE ======================================================  -->

# RestFul Webservice created for Student Management System.
* This project is an assignment recieved from Platoform Commons for hiring purpose.
* It is an individual project created to manage a student database and exposing API for various CRUD operation.

<!-- ============================================  FEATURES ======================================================  -->

  
## Features

* Admin and Student authorization and authenticaiton into the applicaiton has been done using Spring Security. Validation has been considered over the input recieved from the client.<br>
* At the time of applicaiton start, a default admin is created by the application whose credentials are given below.<br>
    Admin_Name: "admin"<br>
    Password: "admin"<br>


* Admin Controls:
    * Login to the application is done user admin_name and password. Every admin must have a unique admin_name(user_name). 
    * Only an admin can add a new admin to the server.
    * Only admins with valid session token can add a new student to the database,add a new course, assign course to a student,get the students from the         tables based on names, and also get courses assigned to a particular student.
    * A student must contain 3 types of address-PERMANENT,CORRESPONDENCE,CURRENT. While adding a new student via swagger, the list of addresses must             contain 3 address object, and the operator must change the "AddressType" in each of them to the required type as mentioned above.
    * Admins can access various details of all the students and also can change their courses.
    * Admin can log out from the application.
* Student Controls:
    * Only an admin can add a student to the database.
    * A student can login using his unique student_Code and Date of Birth.
    * Once a student has logged in, he can update his personal information such as fathers name,mothers name,phone number, email and addresses.
    * A student can leave a course of his/her choice assgined to him/her by the admin.
    * Get all the courses and topics assigned to the him/her. Can search for a course/topics using course-name/topic-name.
    * A student can log out from the application.
  
<!-- ============================================  TECH STACK ======================================================  -->

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate
* MySQL

<!-- ============================================  MODULES ======================================================  -->

## Modules

* Address Module
* Admin Module
* Student Module
* Course Module


<!-- ============================================  INSTALLATION AND RUN ======================================================  -->

## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties] file.
* Update the port number, username and password as per your local database config.

```
    #changing the server port
    server.port=8080

    #db specific properties
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/studentManage
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=Emachines@7676
    
    #ORM s/w specific properties
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

```
* Swagger dependency has been added to the applicaiton, Hence API's can be accessed using PostMan or Swagger UI.
* URL for accessing Swagger UI : http://localhost:8060/swagger-ui/index.html 

<!-- ============================================  SWAGGER INTEGRATION ======================================================  -->

