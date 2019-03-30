# First build the app
FROM maven:3-jdk-8-alpine AS build

WORKDIR /workdir

COPY . .

RUN mvn package

# Then we copy the war file into a Wildfly container
FROM jboss/wildfly:15.0.0.Final

WORKDIR /opt/jboss/wildfly

COPY --from=build /workdir/target/backend-latest.war ./standalone/deployments/

RUN sed -i 's@<datasources>@<datasources>\
              <datasource jndi-name="java:jboss/datasources/MessageDS" pool-name="MessageDS" enabled="true" use-java-context="true">\
                  <connection-url>jdbc:h2:tcp://database:1521/MessageDS;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>\
                  <driver>h2</driver>\
                  <security>\
                      <user-name>sa</user-name>\
                      <password></password>\
                  </security>\
              </datasource>@g' standalone/configuration/standalone.xml
