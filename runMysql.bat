docker run ^
-d -p 3306:3306 ^
-v cs4230-db:/var/lib/mysql ^
-e MYSQL_ROOT_PASSWORD='password' ^
-e MYSQL_DATABASE='cs4230' ^
-e MYSQL_USER='cs4230-user' ^
-e MYSQL_PASSWORD='password' ^
mysql:8.0.20