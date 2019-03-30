FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY tegra-voos-app/target/tegra-voos-app.jar tegra-voos-app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/tegra-voos-app.jar"]