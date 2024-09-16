
# MongoDb

## Connect to mongodb container 
```bash
mongosh "mongodb://root:password@localhost:27017/product-service?authSource=admin"
```
## Commands
```bash
show dbs
show collections
db.product.find()
```

# TestContainers

## local environment
- Thanks to [main test class](src%2Ftest%2Fjava%2Fcom%2Fdemwob%2Ftraining%2Fmicroservices%2Fproduct%2FTestProductServiceApplication.java), the containers start when application start-up and shut down when the application is stopped.

- Add VM Option **-Dspring.profiles.active=tc** to activate testcontainers profile

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=tc -Dspring-boot.run.main-class=com.demwob.training.microservices.TestProductServiceApplication 
```