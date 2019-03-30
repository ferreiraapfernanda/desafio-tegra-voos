FROM java:8

ADD tegra-voos/target/tegra-voos.jar tegra-voos-backend.jar
ADD tegra-voos-app/target/tegra-voos-app.jar tegra-voos-app.jar
ADD start.sh .

CMD ["sh", "start.sh"]