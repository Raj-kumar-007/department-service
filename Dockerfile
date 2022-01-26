## Multi stage build
FROM maven:3 as build

WORKDIR  /department-service

COPY . /department-service

RUN ["mvn","package","-DskipTests"]

FROM openjdk:11-jdk

WORKDIR /app

COPY --from=build /department-service/target/department-service-1.0.jar /department-service/department-service.jar

EXPOSE 8080

## DB Connection properties AS enviornment variables
## Below values are DEFAULTS, Must be Overidden in deployment artifacts
##ENV DBURL=orderdb DBUSER=mahendra DBPASS=pass@1234 DBNAME=orderdb

CMD [ "java","-jar","/app/api-app.jar" ]