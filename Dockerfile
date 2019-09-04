FROM openjdk:11
ADD ./target/text-cleansing-0.0.1-SNAPSHOT.jar /usr/src/text-cleansing-0.0.1-SNAPSHOT.jar
EXPOSE 8081
WORKDIR usr/src
ENTRYPOINT ["java","-jar","text-cleansing-0.0.1-SNAPSHOT.jar"]
