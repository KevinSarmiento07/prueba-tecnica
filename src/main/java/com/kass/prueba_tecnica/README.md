# Proyecto: Prueba Técnica 


---

## 🚀 Requisitos
Antes de ejecutar el proyecto, asegúrate de tener instalado lo siguiente:

- **Java 17**
- **Maven**
- **MySQL**
---

## 🔧 Instalación y Ejecución

### 1️⃣ Clonar el repositorio
```sh
git clone https://github.com/KevinSarmiento07/prueba-tecnica.git
cd prueba-tecnica
```

### 2️⃣ Configurar la base de datos
Crea una base de datos en MySQL:
```sql
CREATE SCHEMA `prueba_tecnica` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci ;
```

### 3️⃣ Construir y ejecutar el proyecto
```sh
mvn spring-boot:run
```
El servidor se ejecutará en `http://localhost:8080`

---

## 📌 Arquitectura del Sistema
El sistema está basado en **Spring Boot** y sigue una arquitectura en capas:

- **Controladores (Controllers)**: Manejan las solicitudes HTTP.
- **Servicios (Services)**: Contienen la lógica de negocio.
- **Repositorios (Repositories)**: Manejan la persistencia de datos con JPA y MySQL.
- **Seguridad**: Implementación con Spring Security y JWT.


## 🔍 Decisiones Técnicas y Justificación

| Tecnología | Justificación |
|------------|--------------|
| **Spring Boot** | Facilita el desarrollo rápido de APIs REST. |
| **JPA + MySQL** | Proporciona persistencia eficiente y flexible. |
| **JWT** | Seguridad basada en tokens sin necesidad de sesiones. |

---



## Despliegue Manual

###  Compilar el proyecto:
```sh
mvn clean package
```
