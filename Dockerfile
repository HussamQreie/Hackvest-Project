FROM openjdk:17-slim
LABEL creator="HackFest 2025"
COPY target/university-hackfest-0.0.1-SNAPSHOT.jar /hackfest.jar
EXPOSE 9000 1337
ENTRYPOINT ["java", "-Dchaos.mode=true", "-jar", "/hackfest.jar"]