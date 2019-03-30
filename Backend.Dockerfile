FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY tegra-voos/target/tegra-voos.jar tegra-voos-backend.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/tegra-voos-backend.jar"]