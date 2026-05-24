# Crear Usuario
POST http://localhost:8089/api/v1/usuarios

json
{
  "nombre": "Pedro Suarez",
  "username": "pedro123",
  "password": "123456",
  "email": "pedro@gmail.com",
  "telefono": "987654321",
  "direccion": "Concepción"
}

# Desactivar usuario
http://localhost:8081/api/v1/usuarios/"IDUSUARIO"/desactivar

# aplication.properties

spring.application.name=usuario-microservicio

server.port=8081

# MySQL Connection Settings

spring.datasource.url=jdbc:mysql://localhost:3306/usuariosdb

spring.datasource.username=root

spring.datasource.password=

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate Settings

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
