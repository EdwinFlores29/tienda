# tienda-demo-full-React-SpringBoot-SQL Server
 Full - Uso de React, spring boot para la conexion SQL Server

 # demo-tienda
 Uso de React, spring boot para la conexion SQL Server

![DEPENDENCIAS_SpringBoot](https://github.com/user-attachments/assets/2193d645-f211-40d8-a724-80e482710b74)


archivo base conexion SQL Server, version 2022.
=======================================================================================================================
spring.datasource.url=jdbc:sqlserver://;serverName=localhost;databaseName=rrhh_db;encrypt=true;trustServerCertificate=true;
spring.datasource.driverClassName=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.username=sa
spring.datasource.password=dariohakuna2#
spring.jpa.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
=======================================================================================================================

# Modelo-fisico-BD-demo-tienda
![image](https://github.com/user-attachments/assets/df067516-3b02-46bf-856e-103dc5670289)

# Como modelado son 5 tablas, para hacer la correlación, se crea cada modelo, con el respectivo nombre de tablas, empezando con el modelo Categoria -->igual al tabla Categoria, pero otro asunto es, que en el SQL Server 2022, se hace unos cambios a nivel de query, lo primero crea la base datos, creo la tabla, verán que el identificador IdCategoria, no esta, para que funcione cuando ejecuto el proyecto spring, hare cambios a la tabla, pero si lo hago de la otra forma, no podre hacer cambios al tabla, una vez creada, por eso dejo la documentación.

Paso # 1
![Crear-base de datos](https://github.com/user-attachments/assets/edaccace-4785-49cd-918e-cb6c347ac6df)

Paso # 2 - Crear-Tabla Categoria
![Crear-Tabla Categoria](https://github.com/user-attachments/assets/4f5e3607-3d5a-4d3a-80ed-54f1c5772804)

Paso # 3 Modo-Diseño
Es decir, revisamos que los columnas, no aceptan nulos, pero cuando ejecutamos el proyecto veran, que nos arrojan otros cambios
![Modo-Diseño](https://github.com/user-attachments/assets/58f09159-df3a-4d22-8bb1-309f466a6396)

Paso # 4
Escribir codigo java, para ver los cambios en la base de datos, a demas despues de escribir codigo, tenemos que hacer una Llave primaria, para esta tabla categoria.

Recuerda llamar a los metodos, necesarios por medio de implements.
![Implementar-metodos](https://github.com/user-attachments/assets/08db0b05-4c88-4f5f-bef9-68b264b50059)

Activar lombok
![Activar lombok](https://github.com/user-attachments/assets/d5df5774-2ab3-47a8-9b9e-e9273bf6f0aa)

Paso # 5
Ver los cambios al design en el SQL SERVER
![Modo-Diseño-2](https://github.com/user-attachments/assets/6aab32bb-7bb0-4b2d-82bf-0653184ff3ee)

Paso # 6
Crear llave primaria
![Llave Primaria](https://github.com/user-attachments/assets/44c5b362-3175-4d88-8c55-1e0190882173)

![Llave Primaria-2](https://github.com/user-attachments/assets/3b584e0e-cb8a-41a8-b819-35bd665c8831)

Paso # 7
Como tengo por default, la columna estado, A quiere decir activo, si ponemos I -- Inactivo
![Insert Into](https://github.com/user-attachments/assets/de3f6f96-8b7f-45a2-9b54-e41f042d403c)

Ademas estare subiendo la query de SQL Server
Vista, de datos
![Datos insertados](https://github.com/user-attachments/assets/7502d1e5-bbf1-45bb-949c-b021f92efd56)

Captura, del proyecto en --> http://localhost:8080/tienda-app/categorias
![Spring Boot](https://github.com/user-attachments/assets/e8942614-f553-401d-a8a3-44fba7525e27)

Ahora, se puede ir trabajando los otras tablas, o bien, comienzo a hacer el front end en React

para tener el frontend, vamos a dejar en la carpeta del repositorio, con el comando, npx create-react-app frontend.

# Requisitos para React
npm install axios
npm install react-router-dom
npm install react-number-format

Archivos -- necesarios para mostrar
Falta la estructura para modificar, guardar, y eliminar, solo esta haciendo el llamado desde SQL SERVER a front end
![Mostrar - Datos-1](https://github.com/user-attachments/assets/1f04759a-bf03-4015-8bd4-95f7a92eeab2)

Actualiando insert into, desde SQL Server
![Mostrar - Datos-2](https://github.com/user-attachments/assets/b4e5b53f-e33b-4d31-86b3-9b62da78416c)

Nueva vista
![Mostrar - Datos-3](https://github.com/user-attachments/assets/e6c69296-554a-454a-a56e-1967f1f89469)

Paso # 8
Llevamos dos tablas creadas, añadimos llaves primarias, luego la relaciones, relacionamos para manejar las consultas de manera mas ordenada y eficiente

Tambien estare añadiendo, el datos sobre ejecutar el query completo, cuando modelas desde el programa Data Modeler, de ORACLE
![Relacion-categoria-producto](https://github.com/user-attachments/assets/c7873638-7d40-4b85-9460-f54eda9d28c6)

![Relacion-categoria-producto-design](https://github.com/user-attachments/assets/66ead403-1abf-4466-931a-6363093b75e5)

Listo los registros para la tabla Productos
![Mostrar - Datos-4](https://github.com/user-attachments/assets/95f2f308-9296-4c69-ac75-2a849904e5fb)

Paso # 9
Anañadimos dos modelos más, para tener relacionado tabla cliente y ventas, luego nos faltaria la tabla que unan venta y producto.
![Relacion-categoria-producto-venta-cliente](https://github.com/user-attachments/assets/09f2e62e-1327-47b3-a34c-088a200d69e8)

Paso # 10
Tenemos lista las relaciones, segun el modelado fisico, dicho anteriormente.
![Relacion-categoria-producto-venta-cliente-detalleventa](https://github.com/user-attachments/assets/1af39776-f555-4965-8986-4dad52f20d84)
