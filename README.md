# API-franquicias

## Estructura
Esta aplicación está hecha con las siguientes tecnologías:
- Java 17
- Springboot con Webflux
- Mongodb reactivo

## Uso de la api
La aplicación ya se encuentra desplegada en la plataforma Render, por lo que se puede hacer uso de esta con la siguiente url base *https://api-franquicias.onrender.com*. En este repositorio se encontrará adjunto la colección de postman para facilitar el consumo de los endpoints.

## Uso en local
Si se desea hacer uso de la aplicación en local solo se debe tener encuenta tener instalado **Java 17** y construir la aplicación con **./gradlew build** o si usa algun IDE estos normalmente proporcionan una opción para construir y configurar el proyecto, como por ejemplo **IntelliJ**. Para conectar a mongo, debido a confidencialidad es necesario crear un cluster en Atlas Mongo, crear una base de datos llamada api-franquicias con los siguientes documentos:
- franquicias.
- sucursales.

### **Recuerde agregar la variable de entorno de la url de mongo para que el proyecto funcione correctamente**
