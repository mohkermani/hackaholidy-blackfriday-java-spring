#Useful Commands:

Development mode run :
 ./mvnw clean spring-boot:run

build jar:
./mvnw clean install package spring-boot:repackage

docker build:
docker buildx build ./ -t "blackfriday"