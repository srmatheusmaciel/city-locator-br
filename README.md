# City Locator BR API

A RESTful API for querying geographic data of countries, states, and cities with support for distance calculations.

## 📋 Summary

- [Requirements](#requirements)
- [Database Configuration](#database-configuration)
- [Data Import](#data-import)
- [Geospatial Queries](#geospatial-queries)
- [Development](#development)
- [Deployment](#deployment)
- [Code Quality](#code-quality)

## 🛠️ Requirements

- Linux
- Git
- Java 21
- Docker
- IntelliJ Community
- Heroku CLI

## 🗄️ Database Configuration

### PostgreSQL

#### Starting PostgreSQL

**Using Docker directly:**

```shell
docker run --name cities-db -d -p 5433:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=cities postgres
```

**Or using Docker Compose:**

```yaml
version: '3.8'
services:
  postgres:
    image: postgres:15
    container_name: cities-db
    restart: always
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: cities
    ports:
      - "5433:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data
volumes:
  pgdata:
```

To start with Docker Compose:
```shell
docker-compose up -d
```

## 📥 Data Import

1. Clone the repository with the data:
   ```shell
   git clone https://github.com/chinnonsantos/sql-paises-estados-cidades.git
   ```

2. Import the data to PostgreSQL:
   ```shell
   cd ~/workspace/sql-paises-estados-cidades/PostgreSQL
   docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash
   
   psql -h localhost -U postgres -d cities -f /tmp/pais.sql
   psql -h localhost -U postgres -d cities -f /tmp/estado.sql
   psql -h localhost -U postgres -d cities -f /tmp/cidade.sql
   ```

3. Configure the necessary extensions for distance calculations:
   ```shell
   psql -h localhost -U postgres -d cities
   
   CREATE EXTENSION cube;
   CREATE EXTENSION earthdistance;
   ```

### Accessing PostgreSQL

```shell
docker exec -it cities-db /bin/bash
psql -U postgres cities
```

## 🌎 Geospatial Queries

### Distance calculation using Point

```sql
SELECT
  (lat_lon1::point <@> lat_lon2::point) AS distance
FROM (
  SELECT
    (SELECT lat_lon FROM cidade WHERE id = 3637) AS lat_lon1,
    (SELECT lat_lon FROM cidade WHERE id = 1598) AS lat_lon2
) AS sub;
```

### Distance calculation using Cube

```sql
SELECT earth_distance(
    ll_to_earth(-21.95840072631836, -47.98820114135742), 
    ll_to_earth(-22.01740074157715, -47.88600158691406)
) as distance;
```

## 🚀 Development

### Spring Boot Configuration

1. Generate the project at [Spring Initializr](https://start.spring.io/) with:
   - Java 21
   - Gradle Project
   - Jar
   - Dependencies:
     - Spring Web
     - Spring Data JPA
     - PostgreSQL Driver
     - Lombok

### Useful References

- [JPA Query Methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)
- [Spring Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
- [JDBC Connection URLs](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Custom Types in Hibernate

- [JsonTypes](https://github.com/vladmihalcea/hibernate-types)
- [UserType](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html)

## 🌐 Deployment

### Heroku

For information about deploying on Heroku with Gradle:
- [Getting Started with Gradle on Heroku](https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku)

## 🧪 Code Quality

### PMD
- [PMD Documentation](https://pmd.github.io/pmd-6.8.0/index.html)

### Checkstyle
- [Checkstyle Documentation](https://checkstyle.org/)
- [Google Style Guide](https://checkstyle.org/google_style.html)
- [Google Java Style Guide](http://google.github.io/styleguide/javaguide.html)

To download the Google Checkstyle configuration file:
```shell
wget https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
```

licença MIT
