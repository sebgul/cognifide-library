# Building and Running

Run the following command to build and start the application using Spring Boot Maven plugin (for Linux):

`./mvnw spring-boot:run -Dspring-boot.run.arguments=/data/books.json`

For Windows run:

`mvnw.cmd spring-boot:run -Dspring-boot.run.arguments=/data/books.json`

Application doesn't require Maven installation, it uses Maven wrapper.
<br>
Other JSON file may be specified as the command's argument.

Tu run the application type:

`localhost:8080`

in selected browser.
