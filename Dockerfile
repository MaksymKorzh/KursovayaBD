# FROM openjdk:8-jdk-alpine
# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring
# ARG DEPENDENCY=target/dependency
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app
# ENTRYPOINT ["java","-cp","app:app/lib/*","com.kursa4.RestServiceApplication"]

FROM java:8
COPY /build/libs/BDKursovaya-0.0.1-SNAPSHOT.jar BDKursovaya-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","BDKursovaya-0.0.1-SNAPSHOT.jar"]