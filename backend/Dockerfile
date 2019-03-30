# First build the app
FROM maven:3-jdk-8-alpine AS build

WORKDIR /workdir

COPY src ./src
COPY pom.xml .
RUN mvn package

# Then we copy the war file into a Wildfly container
FROM jboss/wildfly:15.0.0.Final

COPY --from=build /workdir/target/backend-latest.war /opt/jboss/wildfly/standalone/deployments/
