FROM jboss/wildfly
EXPOSE 8080
COPY tegra-voos/target/tegra-voos-0.0.1-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/tegra-voos-backend.war