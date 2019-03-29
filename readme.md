mvn spring-boot:run

docker build -t tegra-voos-app .
docker run -p 8080:8080 -it tegra-voos-app

http://localhost:8080/tegra-voos/voos-disponiveis

