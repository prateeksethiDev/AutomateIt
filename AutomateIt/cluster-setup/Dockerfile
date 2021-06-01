FROM maven:3.5-jdk-8-alpine
LABEL author="Prateek Sethi"
LABEL email="prateksethiDv@gamil.com"
RUN mkdir /app
WORKDIR /app
COPY ../src /app/src
COPY ../pom.xml /app/pom.xml
COPY ../testng.xml /app/testng.xml
RUN mvn -f /app/pom.xml clean test -DskipTests=true