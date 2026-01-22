# 📝 Notes REST API

A complete REST API for managing notes built with Spring Boot, PostgreSQL, and Docker.

## 🚀 Features

- **Create, Read, Update, Delete (CRUD)** operations for notes
- **Search notes by title**
- **PostgreSQL database** integration
- **Docker containerization**
- **Input validation**
- **Global exception handling**
- **RESTful API design**

## 📋 Prerequisites

- **Docker** and **Docker Compose**
- **Java 17** (if running without Docker)
- **Maven** (if running without Docker)
- **Postman** (for testing)

## 🛠️ Project Structure
notes-api/
├── src/
│ └── main/
│ ├── java/com/example/notes/
│ │ ├── controller/
│ │ │ └── NoteController.java
│ │ ├── dto/
│ │ │ ├── NoteDTO.java
│ │ │ └── NoteRequest.java
│ │ ├── entity/
│ │ │ └── Note.java
│ │ ├── exception/
│ │ │ ├── ErrorResponse.java
│ │ │ ├── GlobalExceptionHandler.java
│ │ │ └── ResourceNotFoundException.java
│ │ ├── repository/
│ │ │ └── NoteRepository.java
│ │ ├── service/
│ │ │ └── NoteService.java
│ │ └── NotesApplication.java
│ └── resources/
│ └── application.properties
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md

## 🚀 Getting Started

###  Run with Docker 

```bash
# Clone the repository
git clone <repository-url>

# Navigate to the project directory
cd notes-api

# Run the application
docker-compose up --build

# 📡 API Endpoints
Method	Endpoint	Description
GET	/api/notes	Get all notes
GET	/api/notes/{id}	Get note by ID
GET	/api/notes/search?title={title}	Search notes by title
POST	/api/notes	Create a new note
PUT	/api/notes/{id}	Update a note
DELETE	/api/notes/{id}	Delete a note

# 📝 Request/Response Examples
## Create Note
## Request:
POST /api/notes
Content-Type: application/json

{
  "title": "My First Note",
  "content": "This is the content of my first note"
}
## Response:
{
  "id": 1,
  "title": "My First Note",
  "content": "This is the content of my first note",
  "createdAt": "2025-01-22T10:30:00",
  "updatedAt": "2025-01-22T10:30:00"
}
## Get All Notes
## Request:
GET /api/notes
## Response:
[
  {
    "id": 1,
    "title": "My First Note",
    "content": "This is the content of my first note",
    "createdAt": "2025-01-22T10:30:00",
    "updatedAt": "2025-01-22T10:30:00"
  }
]
📦 Database Schema
notes table:

id (BIGINT, Primary Key, Auto-increment)

title (VARCHAR, NOT NULL)

content (TEXT)

created_at (TIMESTAMP, Auto-generated)

updated_at (TIMESTAMP, Auto-updated)

🎯 Technologies Used
Spring Boot 3.2.0 - Application framework

Spring Data JPA - Data access layer

PostgreSQL 16 - Database

Docker - Containerization

Lombok - Boilerplate code reduction

Bean Validation - Input validation

Maven - Build tool