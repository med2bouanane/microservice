
# TestContainers

## local environment
- Thanks to [main test class](src%2Ftest%2Fjava%2Fcom%2Fdemwob%2Ftraining%2Forder%2FTestOrderServiceApplication.java), the containers start when application start-up and shut down when the application is stopped.

- Add VM Option **-Dspring.profiles.active=tc** to activate testcontainers profile

### PostgreSQL testcontainers 
- PostgreSQL testcontainers connection configuration [TestcontainersConfiguration.java](src%2Ftest%2Fjava%2Fcom%2Fdemwob%2Ftraining%2Forder%2FTestcontainersConfiguration.java)
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
\d t_orders; # describe table
\d flyway_schema_history;
```
- Verify Flyway data for initial scripts (t_orders table)
  - [V1__init.sql](src%2Fmain%2Fresources%2Fdb%2Fmigration%2Fstructure%2FV1__init.sql)
  - [V1.1__insert_orders.sql](src%2Fmain%2Fresources%2Fdb%2Fmigration%2Fdata%2FV1.1__insert_orders.sql)
```bash
select * from t_orders;

select * from flyway_schema_history;
```
