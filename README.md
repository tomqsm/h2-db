# h2-db
dabbling with H2 (jdbc, hibernate, liquibase)

## Setup Maven security
Project uses `<server>` username and password from `.m2/settings.xm` for data base credentials. Please refer to:  [Maven Password encryption](https://maven.apache.org/guides/mini/guide-encryption.html) to find out how to set it up.

## Run Liquibase
`mvn liquibase:update`

`mvn liquibase:rollback -Dliquibase.rollbackCount=1`

`mvn liquibase:dropAll liquibase:update` when problem with checksum and you can afford dropping all tables
