# Sistema Integral de Venta y Administración de Productos

Este sistema está diseñado específicamente para negocios dedicados a la venta de modelos a escala de coches clásicos. Utiliza la base de datos `classicmodels` y ofrece funcionalidades para gestionar clientes, productos y pedidos de venta. Los usuarios pueden registrar nuevos clientes, agregar productos al catálogo, realizar pedidos de venta y hacer un seguimiento detallado de todas las transacciones. Además, el sistema incluye roles de usuario diferenciados: empleados para operaciones de venta y gestión del inventario, y administradores con acceso completo para administrar usuarios, productos y configuraciones del sistema.

## Descripción

El sistema proporciona una plataforma integral para gestionar todos los aspectos de la venta de modelos a escala de coches clásicos. Las principales funcionalidades incluyen:

- **Gestión de Clientes:** Registro de nuevos clientes y gestión de información existente.
- **Gestión de Productos:** Agregar productos al catálogo y administrar el inventario.
- **Pedidos de Venta:** Realizar y gestionar pedidos de venta, con seguimiento detallado de las transacciones.
- **Roles de Usuario:** Diferentes niveles de acceso para empleados y administradores para asegurar una correcta gestión y seguridad.

## Tecnologías Utilizadas

- **Backend:**
  - [Java Spring Boot](https://spring.io/projects/spring-boot): Framework para el desarrollo de aplicaciones Java.
  - [Spring Data](https://spring.io/projects/spring-data): Proporciona integración con bases de datos y simplifica las operaciones de persistencia.

- **Frontend:**
  - [Thymeleaf](https://www.thymeleaf.org/): Motor de plantillas para renderizar vistas HTML.
  - [HTML](https://developer.mozilla.org/en-US/docs/Web/HTML): Lenguaje de marcado para estructurar las páginas web.
  - [CSS](https://developer.mozilla.org/en-US/docs/Web/CSS): Lenguaje para diseñar y presentar la página web.
  - [Bootstrap](https://getbootstrap.com/): Framework de CSS para el diseño de interfaces responsivas.

- **Base de Datos:**
  - [MySQL](https://www.mysql.com/): Sistema de gestión de bases de datos relacional utilizado para almacenar datos de clientes, productos y pedidos.

## Instalación y Configuración

1. **Clonar el Repositorio:**

   ```bash
   git clone https://github.com/natanael-lima/sales-management-web-applications.git
   cd sales-management-web-applications
2. **Configuración del Backend:**
   - Configura el archivo application.properties con los detalles de tu base de datos MySQL.
   - Ejecuta la aplicación Spring Boot:
   ```bash
   mvn spring-boot:run
   
3. **Configuración del Frontend:**
   - Navega al directorio frontend:
   ```bash
   cd frontend
   npm install
   ng serve
## Acceso a la Aplicación

Accede a la aplicación en tu navegador en [http://localhost:4200](http://localhost:4200).

## Vista Previa

Puedes ver una vista previa del proyecto desplegado en [https://tu-url-de-previsualizacion](https://i.postimg.cc/HjGmTZqm/project-gestioninventario.png).

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor realiza un fork del repositorio, crea una rama con tus cambios y envía un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Para más detalles, consulta el archivo LICENSE.

## Contacto

Si tienes alguna pregunta o sugerencia, no dudes en ponerte en contacto.

- **Autor:** Natanael Lima
- **Repositorio:** [GitHub](https://github.com/natanael-lima/sales-management-web-applications)

