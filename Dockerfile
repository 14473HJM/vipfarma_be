FROM openjdk:11
RUN addgroup --system farmavip && adduser farmavip --ingroup farmavip
USER farmavip:farmavip
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]