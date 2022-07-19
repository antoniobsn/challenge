## Installation Instructions

**Requiriments**

* Install [Gradle](https://gradle.org/)

**Run Application**
* Go to the root of the application where build.gradle is available
* Startup:
```gradle bootRun```

* Run tests:
```gradle clean test```
    
**Database**
* Database H2 in memory
* The data structure is generated automatically at application start time
* When the application starts automatically it will load the data in the data.sql file

## Documentation
With the application started access: [Doc](http://localhost:8080/swagger-ui/)

## Technical debts
* Validation of input parameters in the API
* API error handling
* Creating the data structure via migrations
* create docker image
* Schedule weekly calculations
* Flow for data persistence
