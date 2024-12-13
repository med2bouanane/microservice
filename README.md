# Install jdk in linux

## Add Corretto repository

```bash
wget -O - https://apt.corretto.aws/corretto.key | sudo gpg --dearmor -o /usr/share/keyrings/corretto-keyring.gpg
echo "deb [signed-by=/usr/share/keyrings/corretto-keyring.gpg] https://apt.corretto.aws stable main" | sudo tee /etc/apt/sources.list.d/corretto.list

```
```bash
sudo apt-get update
sudo apt-get install -y java-21-amazon-corretto-jdk
java -version

```

## Run
### Docker Compose
```bash
docker compose up -d
```

### Applications
```bash
./mvnw -pl product-service spring-boot:run -Dspring-boot.run.main-class=com.demwob.training.microservice.product.ProductServiceApplication
./mvnw -pl inventory-service spring-boot:run -Dspring-boot.run.main-class=com.demwob.training.microservice.inventory.InventoryServiceApplication
./mvnw -pl order-service spring-boot:run -Dspring-boot.run.main-class=com.demwob.training.microservice.order.OrderServiceApplication

```

### Keycloak
- http://localhost:8180
- USER/PASS: admin/admin
#### Credentials:
In Keycloak, all the clients, users, and roles related to a particular application (or) a group of applications reside inside something known as a realm. Realms are independent of each other, so if you create one client/user in one realm, you cannot use it from another realm.