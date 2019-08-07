FROM openjdk
COPY target/SpringBoot-RELEASE.jar SpringBoot-RELEASE.jar
ENTRYPOINT ["java", "-jar", "/SpringBoot-RELEASE.jar"]
EXPOSE 8080