# Notes REST API

A complete REST API for managing notes built with Spring Boot, PostgreSQL, and Docker.

## 🚀 Features

* Create, Read, Update, Delete (CRUD) operations for notes
* Search notes by title
* PostgreSQL database integration
* Docker containerization
* Input validation
* Global exception handling
* RESTful API design

## 📋 Prerequisites

* Docker and Docker Compose
* Java 17 (if running without Docker)
* Maven (if running without Docker)
* Postman (for testing)

## 🛠️ Installation & Setup

### Using Docker (Recommended)

1. Clone the repository
```bash
git clone https://github.com/yourusername/notes-api.git
cd notes-api
```

2. Build and run with Docker Compose
```bash
docker-compose up --build
```

The API will be available at `http://localhost:8080`

### Without Docker

1. Configure PostgreSQL database in `application.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/notesdb
spring.datasource.username=your_username
spring.datasource.password=your_password
```

2. Build and run the application
```bash
./mvnw clean install
./mvnw spring-boot:run
```

## 📚 API Endpoints

### Base URL
```
http://localhost:8080/api/notes
```

### Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/notes` | Get all notes |
| GET | `/api/notes/{id}` | Get note by ID |
| GET | `/api/notes/search?title={title}` | Search notes by title |
| POST | `/api/notes` | Create a new note |
| PUT | `/api/notes/{id}` | Update an existing note |
| DELETE | `/api/notes/{id}` | Delete a note |

## 📝 Request/Response Examples

### Create Note
```http
POST /api/notes
Content-Type: application/json

{
  "title": "My First Note",
  "content": "This is the content of my note"
}
```

**Response:**
```json
{
  "id": 1,
  "title": "My First Note",
  "content": "This is the content of my note",
  "createdAt": "2024-01-22T10:30:00",
  "updatedAt": "2024-01-22T10:30:00"
}
```

### Get All Notes
```http
GET /api/notes
```

**Response:**
```json
[
  {
    "id": 1,
    "title": "My First Note",
    "content": "This is the content of my note",
    "createdAt": "2024-01-22T10:30:00",
    "updatedAt": "2024-01-22T10:30:00"
  }
]
```

### Update Note
```http
PUT /api/notes/1
Content-Type: application/json

{
  "title": "Updated Note Title",
  "content": "Updated content"
}
```

### Delete Note
```http
DELETE /api/notes/1
```

**Response:** `204 No Content`

## 🏗️ Project Structure
```
notes-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/notesapi/
│   │   │       ├── controller/
│   │   │       │   └── NoteController.java
│   │   │       ├── model/
│   │   │       │   └── Note.java
│   │   │       ├── repository/
│   │   │       │   └── NoteRepository.java
│   │   │       ├── service/
│   │   │       │   └── NoteService.java
│   │   │       ├── exception/
│   │   │       │   ├── ResourceNotFoundException.java
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       └── NotesApiApplication.java
│   │   └── resources/
│   │       └── application.properties
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md
```

## 🧪 Testing with Postman

1. Import the API endpoints into Postman
2. Set the base URL to `http://localhost:8080`
3. Test each endpoint with the examples provided above

## 🐳 Docker Configuration

### docker-compose.yml
```yaml
version: '3.8'
services:
  postgres:
    image: postgres:15
    environment:
      POSTGRES_DB: notesdb
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - postgres
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/notesdb
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres

volumes:
  postgres_data:
```

## 🔧 Technologies Used

* **Spring Boot** - Backend framework
* **Spring Data JPA** - Data persistence
* **PostgreSQL** - Database
* **Docker** - Containerization
* **Maven** - Build tool
* **Hibernate Validator** - Input validation

## 📄 License

This project is licensed under the MIT License.

## 👤 Author

Your Name - [GitHub Profile](https://github.com/yourusername)

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request