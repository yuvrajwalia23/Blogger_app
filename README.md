# 📝 Blogger Platform

A simple blogging platform built using **Spring Boot** for the backend and designed for easy integration with a frontend. This project allows users to register, log in, and manage their blog posts.

## 🚀 Features

- 🔐 User Registration & Login
- ✍️ Create, Read, Update, Delete (CRUD) blog posts
- 📦 RESTful API architecture
- 🛡️ Secure password handling (BCrypt or other encoders)
- 🌐 CORS enabled for frontend integration
- 📁 Organized project structure (Model-View-Service-Controller)

## 🛠️ Tech Stack

- **Backend**: Java, Spring Boot
- **Database**: MySQL (or any other SQL-compatible DB)
- **Build Tool**: Maven
- **Security**: JWT (optional), BCrypt password hashing
- **Frontend (planned/integrated)**: HTML, CSS, JavaScript, or React

## 📁 Folder Structure

```
src
├── main
│   ├── java
│   │   └── com.example.blogger
│   │       ├── controller
│   │       ├── model
│   │       ├── repository
│   │       ├── service
│   │       └── BloggerApplication.java
│   └── resources
│       ├── application.properties
```

## 🔧 Configuration

In `application.properties`, set up your database:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blogger
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 📬 API Endpoints

### 🔐 Authentication

| Method | Endpoint              | Description                   |
|--------|-----------------------|-------------------------------|
| POST   | `/api/users/register` | Register new user             |
| POST   | `/api/users/login`    | Login with email and password |

### 📝 Posts (assumed routes if implemented)

| Method | Endpoint           | Description          |
|--------|--------------------|----------------------|
| GET    | `/api/posts`       | Get all posts        |
| POST   | `/api/posts`       | Create a post        |
| PUT    | `/api/posts/{id}`  | Update a post        |
| DELETE | `/api/posts/{id}`  | Delete a post        |

## ⚙️ How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/blogger.git
   ```

2. Import the project into your favorite IDE (IntelliJ / Eclipse)

3. Set up your database credentials in `application.properties`

4. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

## 🙋‍♂️ Author

- **Yuvraj Singh Walia**
- [GitHub](https://github.com/yuvrajwalia23)
- [LinkedIn](https://www.linkedin.com/in/yuvraj-walia-2023xyz/)

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.