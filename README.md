# User Repository Example

Este proyecto es un ejemplo de implementación del patrón Repository en Java. Incluye una clase `UserRepository` para manejar operaciones CRUD (Create, Read, Update, Delete) en una base de datos PostgreSQL, utilizando JDBC para la conexión y ejecución de consultas.

## Características

- **Patrón Repository:** Implementación del patrón para separar la lógica de acceso a datos de la lógica del negocio.
- **Soporte para Inserciones y Actualizaciones:** Uso de la funcionalidad `ON CONFLICT` de PostgreSQL para combinar inserciones y actualizaciones en un solo método.
- **Operaciones CRUD:**
    - Obtener todos los usuarios (`findAll`)
    - Obtener un usuario por ID (`getById`)
    - Guardar (insertar/actualizar) un usuario (`save`)
    - Eliminar un usuario (`delete`)

---

## Requisitos

Antes de ejecutar el proyecto, asegúrate de tener lo siguiente:

- **Java 11 o superior**
- **PostgreSQL** (configurado con una base de datos y tabla para `users`)
- **Maven** (para gestionar las dependencias)

---

## Configuración

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/deymerht/java-repository-crud.git

## Autor

- **Deymer Hernández**
    - [LinkedIn](https://www.linkedin.com/in/deymerh/)
    - Correo: [deymerh@hotmail.com](mailto:deymerh@hotmail.com)