mvn spring-boot:run

docker build -t tegra-voos-app .
docker run -p 8080:8080 -it tegra-voos-app

http://localhost:8080/tegra-voos/voos-disponiveis





docker kill $(docker ps -q)
docker rm $(docker ps -a -q)
docker rmi $(docker images -q)



docker network create --subnet=172.18.0.0/16 tegra-voos

docker build -f Backend.Dockerfile -t tegra-voos-backend .
docker build -f Frontend.Dockerfile -t tegra-voos-frontend .

docker container run --network tegra-voos --name tegra-voos-backend --ip 172.18.0.22 -p 8080:8080 -d tegra-voos-backend

docker container run --network tegra-voos --name tegra-voos-frontend --ip 172.18.0.23 -p 8088:8088 -d tegra-voos-frontend --link=tegra-voos-backend --expose="8080"

docker container logs tegra-voos-backend
