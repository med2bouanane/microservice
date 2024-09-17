
# TestContainers

## local environment
- Thanks to [TestInventoryServiceApplication.java](test%2Fjava%2Fcom%2Fdemwob%2Ftraining%2Finventory_service%2FTestInventoryServiceApplication.java), the containers start when application start-up and shut down when the application is stopped.

- Add VM Option **-Dspring.profiles.active=tc** to activate testcontainers profile

### PostgreSQL testcontainers 
- PostgreSQL testcontainers connection configuration [TestcontainersConfiguration.java](test%2Fjava%2Fcom%2Fdemwob%2Ftraining%2Finventory_service%2FTestcontainersConfiguration.java)
  - **flyway default-schema:** dev
  - **db:** test
  - **user:** postgres
  - **pass:** postgres
- psql connection command
```bash
psql -U postgres -d test
\dn; # show schema
SET schema 'dev'; # use dev schema
\dt # list tables
```
- psql util commands
```bash
select version(); # show postgreSQL version
\l # List databases
\c my_database # switch database
\d t_inventories; # describe table
\d flyway_schema_history;
```
- Verify Flyway data for initial scripts (t_inventories table)
  - [V1__init.sql](main%2Fresources%2Fdb%2Fmigration%2Fstructure%2FV1__init.sql)
  - [V1.1__insert_inventories.sql](main%2Fresources%2Fdb%2Fmigration%2Fstructure%2Fdata%2FV1.1__insert_inventories.sql)
```bash
select * from t_inventories;

select * from flyway_schema_history;
```
