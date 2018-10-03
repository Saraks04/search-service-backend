FROM java:8-jre

COPY ./target/search-service-0.0.1-SNAPSHOT.jar /usr/src/search-service-0.0.1-SNAPSHOT

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "search-service-0.0.1-SNAPSHOT"]
