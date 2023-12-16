# Piotr messaging micro-service
The messaging micro service for the Piotr project.

## Running the Application
To run the application, execute the following command:
`./mvnw spring-boot:run`    

To specify particular profile:      
`./mvnw spring-boot:run -Dspring-boot.run.profiles={profile}`

The application will start and you can access it at http://localhost:8080.

### Useful Commands
Here are some useful commands that you can use with `mvnw` or `mvn`:

`mvnw clean`: cleans the target directory    
`mvnw compile`: compiles the application      
`mvnw package`: packages the application as a JAR file  
`mvn clean package`: cleans the build directory        
`mvnw test`: runs the unit tests        
`mvnw dependency:resolve`: resolves all dependencies required by the project and downloads them to your local repository        
`./mvnw dependency:tree`: Displays the dependency tree of the project         
`./mvnw spring-boot:run`: Runs the Spring Boot application     
Note that if you're using mvn instead of mvnw, replace ./mvnw with mvn in the above commands      