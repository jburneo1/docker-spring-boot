# docker-spring-boot

$ mvn install

$ mvn clean package

// construimos el jar
$ docker build -t demo .

// Bajamos la imagen sql
$ docker pull mysql:5.7

// desplegamos el servidor de mysql
$ docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=sa -e MYSQL_DATABASE=cafeto -e MYSQL_USER=sa -e MYSQL_PASSWORD=sa -d mysql:5.7

// verificamos los registros de inicio de mysql
docker container logs mysql-standalone

// para conectarnos con el servidor mysql 
$ docker exec -it mysql-standalone bash -l

// iniciamos sesion en mysql
$ mysql -usa -psa

// verificamos la creacion de la base de datos
$ show databases;

// ejecutamos nuestra aplicacion spring-boot
docker run -d -p 8089:8089 --name demo --link mysql-standalone:mysql demo

// verificamos el log
docker container logs demo

// probamos nuestra app
