# Microservicio de Clientes

Este microservicio se encarga de gestionar la información de los clientes, separando los datos de nombre, apellido paterno, apellido materno, fecha de nacimiento, sexo, correo y teléfono en una base de datos, y exponiendo una API REST para insertar y consultar esta información.

## Tecnologías utilizadas

- Java 17
- Spring Boot 2.6.6
- Maven 3.8.8
- PostgreSQL

## Características de la aplicación

- Patrón de diseño MVC
- Logging
- JSON para mapear las peticiones del microservicio

## Requerimientos del desarrollo

- Crear un microservicio que permita dar de alta y consultar clientes
- Realizar script de base de datos
- Se garantiza que no puede haber dos personas con el mismo nombre
- El alta de datos devuelve un identificador del cliente

## Documentación de la API

La documentación de la API se encuentra en un contrato de interfaz YAML con el estándar OpenAPI 2.0.
* Puedes encontrarlo en el archivo `openapi.yaml`.
* Puedes visualizar el de clientes en http://localhost:9090/swagger-ui/index.html#.
* Puedes visualizar el de libreria en http://localhost:9070/swagger-ui/index.html#.

## Configuración

Se puede encontrar la configurar adecuada como las propiedades de la base de datos en `application.properties` para que el microservicio pueda conectarse correctamente.

## Ejecución

* Los scripts para la BD se encuentran en la carpeta `sql`, el archivo `import.sql`. Con el script para la creacion de tablas y el script para la insercion de datos de prueba.
* El microservicio client estará disponible en `http://localhost:9090` por defecto.
* El microservicio library estará disponible en `http://localhost:9070` por defecto.


