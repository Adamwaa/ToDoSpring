# ToDo List Application

## About
This is a simple ToDo List application built using Spring Boot for the backend and a basic JavaScript frontend. It allows users to create, toggle, and delete tasks.

## Features
- Create new tasks
- Toggle tasks between completed and not completed
- List all tasks
- Delete tasks

## Technologies
- Spring Boot
- Spring Data JPA
- Spring Web MVC
- H2 Database
- Lombok
- Maven
- JavaScript
- HTML/CSS

## Setup and Installation
To get this project up and running on your local machine, follow these steps:

### Prerequisites
- JDK 11 or later
- Maven
- Git

### Running the Application

1. Clone the repository:
```bash
git clone https://github.com/Adamwaa/ToDoSpring.git
cd todolist
````

2. Build the application using Maven:
```bash
mvn clean install
````

3. Run the application
```bash
mvn spring-boot:run
````

The application should now be running on http://localhost:8080.

### Usage

Open your web browser and navigate to http://localhost:8080 to start using the ToDo application.
API Endpoints

    GET /api/todos - Retrieve all tasks
    POST /api/todos - Create a new task
    PUT /api/todos/{id} - Toggle the status of a task
    DELETE /api/todos/{id} - Delete a task
 
