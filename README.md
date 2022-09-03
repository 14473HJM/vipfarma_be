# Farma VIP - Backend
Repositorio para el proyecto de Back End


# Como correr el proyecto localmente
>! Para ejecutar este proyecto es necesario tener Docker instalado. Puede descargar la ultima versión de Docker [aquí](https://docs.docker.com/get-docker/).

1. Asegurarse que Docker esta corriendo
2. Construir la imagen del proyecto
```
docker build -t farmavip/farmavip-be . 
```
3. Ejecutar la imagen generada en Docker
```
docker run --name farmavip-be -p 8080:8080 farmavip/farmavip-be
```
