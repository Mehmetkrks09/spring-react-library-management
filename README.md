# Library Management System
A full-stack web application for managing library books with secure JWT authentication, built with modern technologies and containerized for easy deployment.
Show Image
Show Image
Show Image
Show Image
Show Image
Show Image

🚀 Features
Backend

✅ JWT Authentication - Secure user registration and login
✅ RESTful API - CRUD operations for book management
✅ Spring Security - Role-based access control
✅ PostgreSQL - Relational database with JPA/Hibernate
✅ Docker Support - Containerized application
✅ Unit Tests - JUnit & Mockito test coverage
✅ Global Exception Handling - Consistent error responses

Frontend

✅ React + TypeScript - Type-safe component development
✅ Vite - Fast build tool with HMR
✅ JWT Token Management - Secure API communication
✅ Responsive Design - Modern UI/UX

🛠️ Tech Stack
Backend

Framework: Spring Boot 3.3.4
Language: Java 17
Security: Spring Security + JWT (jjwt 0.12.3)
Database: PostgreSQL 15
ORM: Hibernate/JPA
Build Tool: Maven
Testing: JUnit 5, Mockito

Frontend

Framework: React 18
Language: TypeScript 5
Build Tool: Vite
HTTP Client: Fetch API

DevOps

Containerization: Docker & Docker Compose
Database: PostgreSQL (containerized)

📋 Prerequisites

Docker Desktop installed
Git

🚀 Quick Start
1. Clone the repository
bashgit clone https://github.com/yourusername/spring-react-library-management.git
cd spring-react-library-management
2. Start with Docker Compose
bashdocker-compose up -d
This will start:

Backend API on http://localhost:8080
PostgreSQL database on localhost:5432

3. Run Frontend (Development)
bashcd library-frontend
npm install
npm run dev
Frontend will be available at http://localhost:5173
📡 API Endpoints
Authentication
POST /api/auth/register - Register new user
POST /api/auth/login    - Login and get JWT token
Books (Protected - Requires JWT)
GET    /api/kitaplar              - Get all books
GET    /api/kitaplar/{id}         - Get book by ID
GET    /api/kitaplar/kategori/{id} - Get books by category
POST   /api/kitaplar/addBook      - Add new book
PUT    /api/kitaplar/update/{id}  - Update book
DELETE /api/kitaplar/delete/{id}  - Delete book
Example: Login Request
bashcurl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123"
  }'
Example: Protected Request
bashcurl -X GET http://localhost:8080/api/kitaplar \
  -H "Authorization: Bearer YOUR_JWT_TOKEN"
🏗️ Project Structure
.
├── backend/
│   ├── src/main/java/com/ders/kutuphane/
│   │   ├── controller/     # REST controllers
│   │   ├── service/        # Business logic
│   │   ├── repository/     # Data access layer
│   │   ├── entity/         # JPA entities
│   │   ├── dto/            # Data transfer objects
│   │   ├── security/       # JWT & Security config
│   │   └── exception/      # Exception handlers
│   ├── src/test/           # Unit tests
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── components/     # React components
│   │   ├── App.tsx         # Main component
│   │   └── main.tsx        # Entry point
│   └── package.json
├── docker-compose.yml
└── Dockerfile
🔒 Security

Passwords are hashed using BCrypt
JWT tokens expire after 24 hours
CORS configured for frontend origin
All book endpoints require authentication
Role-based access control (USER, ADMIN)

🧪 Running Tests
bashmvn test
🛑 Stopping the Application
bashdocker-compose down
📝 Environment Variables
The application uses the following environment variables (configured in docker-compose.yml):
yamlSPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/kutuphane_db
SPRING_DATASOURCE_USERNAME: postgres
SPRING_DATASOURCE_PASSWORD: 4464
🔄 Development Workflow
Backend Development

Make code changes
Rebuild Docker image:

bashdocker-compose up --build
Frontend Development

Vite HMR (Hot Module Replacement) automatically reloads changes
No need to restart the dev server

📚 Learning Resources
This project demonstrates:

RESTful API design
JWT authentication flow
Spring Security configuration
Docker containerization
React + TypeScript integration
Full-stack application architecture

🤝 Contributing
This is a portfolio project, but suggestions are welcome!
📄 License
This project is open source and available under the MIT License.
👤 Author
Mehmet Karakaş

Location: Aydın/Didim, Turkey
Email: mehmetkarakas415@gmail.com
