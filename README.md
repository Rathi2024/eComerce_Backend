# 🛒 E-Commerce Backend API

A production-ready RESTful **E-Commerce Backend** built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **PostgreSQL (Supabase)**, and **Docker**.

The application is deployed on **Render** and provides secure APIs for user authentication and product management using Role-Based Access Control (RBAC).

---

# 🚀 Live Demo

### 🌐 Live Backend

https://ecomerce-backend-ic7z.onrender.com

### 📖 Swagger API Documentation

https://ecomerce-backend-ic7z.onrender.com/swagger-ui/index.html

> **Note:** Most endpoints are protected using JWT Authentication. Register/Login first to generate a JWT token before accessing secured APIs.

---

# ✨ Features

- 🔐 JWT Authentication
- 👤 User Registration & Login
- 🛡️ Spring Security Role-Based Authorization
- 📦 Product CRUD Operations
- 🗄️ PostgreSQL Database (Supabase)
- 🐳 Docker Support
- ☁️ Render Deployment
- 📑 Swagger/OpenAPI Documentation
- ✅ Input Validation
- ⚡ RESTful API Architecture

---

# 🛠️ Tech Stack

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 3.x |
| Spring Security | Latest |
| JWT | jjwt |
| PostgreSQL | Supabase |
| Maven | Latest |
| Docker | Latest |
| Render | Cloud Deployment |
| Swagger | OpenAPI 3 |

---

# 📂 Project Structure

```text
src
├── config
├── controller
├── dto
├── entity
├── repository
├── security
├── service
├── exception
└── util
```

---

# 🌐 Public Endpoint

Anyone can verify that the application is running.

### Request

```http
GET /
```

### Response

```text
🚀 E-Commerce Backend API is running successfully!
```

---

# 🔑 Authentication

## Register

```http
POST /auth/register
```

Example Request

```json
{
  "username": "john",
  "password": "password123",
  "role": "USER"
}
```

---

## Login

```http
POST /auth/login
```

Example Request

```json
{
  "username": "john",
  "password": "password123"
}
```

Example Response

```json
{
  "token": "YOUR_JWT_TOKEN"
}
```

Use this token in every secured request.

```text
Authorization: Bearer YOUR_JWT_TOKEN
```

---

# 👥 User Roles

### USER

- View all products
- View product by ID

### ADMIN

- Add Product
- Update Product
- Delete Product

---

# 📦 Product APIs

| Method | Endpoint | Access |
|--------|----------|--------|
| GET | `/api/products` | USER / ADMIN |
| GET | `/api/product/{id}` | USER / ADMIN |
| POST | `/api/product` | ADMIN |
| PUT | `/api/product/{id}` | ADMIN |
| DELETE | `/api/product/{id}` | ADMIN |

---

# 🏗️ System Architecture

```text
                Client (React / Postman)
                          │
                          ▼
                Spring Boot REST API
                          │
          Spring Security + JWT Authentication
                          │
                          ▼
                PostgreSQL (Supabase)
```

---

# ⚙️ Running Locally

## Clone Repository

```bash
git clone https://github.com/Rathi2024/eComerce_Backend.git
```

---

## Navigate to Project

```bash
cd eComerce_Backend
```

---

## Configure Environment Variables

Update your `application.properties`

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

jwt.secret=YOUR_SECRET_KEY
```

---

## Run the Application

```bash
./mvnw spring-boot:run
```

---

# 🐳 Docker

## Build Docker Image

```bash
docker build -t ecommerce-backend .
```

## Run Docker Container

```bash
docker run -p 8080:8080 ecommerce-backend
```

---

# ☁️ Deployment

### Backend Hosting

- Render

### Database

- Supabase PostgreSQL

---

# 📖 API Documentation

Swagger UI is available after deployment.

```
https://ecomerce-backend-ic7z.onrender.com/swagger-ui/index.html
```

---

# 📸 Screenshots

> Add screenshots here in the future.

Example:

- Swagger UI
- Register API
- Login API
- Product APIs
- Render Deployment

---

# 👨‍💻 Author

## Prajjwal Rathi

Java Full Stack Developer

### Skills

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- PostgreSQL
- Docker
- REST APIs
- React

### GitHub

https://github.com/Rathi2024

### LinkedIn

(Add your LinkedIn Profile)

---

# ⭐ Support

If you found this project helpful, please consider giving it a ⭐ on GitHub.

It helps others discover the project and motivates further development.

---

# 📄 License

This project is licensed under the MIT License.
