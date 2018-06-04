# Cognifide Library

Cognifide Library is an app prepared for recruitment process in Cognifide.

## About

Cognifide Library offers several API endpoints for obtaining information about book collection and user interface for selecting books based on category (additional part of the task).

## API Manual

Available API endpoints:
- selecting all available books (returns 404 when no books are available)<br>
`localhost:8080/api/book`
- selecting a book by its ISBN number (returns 404 when there's no book with specified ISBN number)<br>
`localhost:8080/api/book/{isbn}`
- selecting books by category (returns 404 when there's no book for selected category)<br>
`localhost:8080/api/book/{categoryName}/books`
- ratings for all the authors (returns 404 when there's no author data in any book)<br>
`localhost:8080/api/rating`

## Frontend manual

Type into selected browser's address bar:

`localhost:8080`

You can select books by available categories.

## Technical details

Cognifide Library was developed in Spring Boot and Angular.
The main project (Spring Boot) contains subproject **cognifide-library-ui** for user interface (Angular).<br>
Both projects were developed separately but they are part of one repository. The backend consists of an API which is queried by the frontend part, which is served by Tomcat as static content (the build of Angular app).

## Running the app

Code for the application is available on GitHub:<br>
https://github.com/sebgul/cognifide-library<br>
Application requires Java Development Kit 8 installation in the OS and a web browser (or a tool for sending HTTP request, like httpie or Postman). Environment variable *JAVA_HOME* must be present in the OS. Maven installation is not required (project contains Maven wrapper - **mvnw**).
To run the app we execute the command (on root project level):<br>
`mvnw.cmd spring-boot:run -Dspring-boot.run.arguments=/data/books.json`<br>
for Windows or<br>
`./mvnw spring-boot:run -Dspring-boot.run.arguments=/data/books.json`<br>
for *nix systems.<br>
Other JSON file with books data can be specified.
The app will be available at *localhost:8080* which we can open in a web browser.

## Running with vagrant

It's possible to run the app independently of the host's operating system and its installations.
<br>
The installation of VirtualBox and Vangrant is required.
<br>
In the folder where *Vagrantfile* is present we run the command:<br>
`vagrant up`
<br>
It downloads the Ubuntu Server virtual machine, installs Java SDK and git, and runs the project (downloading all its dependencies). The port 8080 is forwarded to host's 8080 port.<br>
We run the app in selected browser by typing:<br>
`localhost:8080`
<br>
in address bar.
