
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml .

RUN apt-get update && apt-get install -y maven && apt-get clean

COPY src ./src

RUN mvn package -DskipTests

CMD ["java", "-jar", "target/groupforsix-0.0.1-SNAPSHOT.jar"]