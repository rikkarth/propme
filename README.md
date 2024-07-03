# Introduction

**PropMe** is a small application which will automatically generate a `.java` file and map it with all the fields from your `.properties` configuration file.

This application was born from a real world requirement, where during the implementation of a large configuration, it was required to map all the fields of a configuration file to a constants java class for further validation.

## Source

```properties
#.properties configuration file
db.url=jdbc:mysql://localhost:3306/mydatabase
db.username=root
db.password=password
db.connection.pool.size=10

# Server configuration
server.port=8080
server.host=localhost
server.contextPath=/myapp
```

## Result

```java
public class MyConfigConstants {
    static final String DB_URL = "db.url";
    static final String DB_USERNAME = "db.username";
    static final String DB_PASSWORD = "db.password";
    static final String DB_CONNECTION_POOL_SIZE = "db.connection.pool.size";
    static final String SERVER_PORT = "server.port";
    static final String SERVER_HOST = "server.host";
    static final String SERVER_CONTEXTPATH = "server.contextPath";
}

```
# Installation
To run **PropMe** you just need to have minimum Java 8 installed, download `propme.jar` and run it as instructed bellow.

# How to run

```bash
java -jar propme-0.0.1.jar path/to/source/config.properties path/to/target/folder/
```

# Additional Information

Currently the name of the output file is `MyConfigConstants.java`.

This will change in the future and it will be configurable.

More features will be introduced.
