# Login Page — Employee Management System

A full-stack web application with user authentication and employee CRUD operations.

## Tech Stack

| Layer | Technology |
|---|---|
| Frontend | Angular 14, Angular Material, Bootstrap 5 |
| Backend | Spring Boot 2.7 (Java 18) |
| Database | MySQL |

## Project Structure

```
LoginPage/
├── FrontEnd/login-page/   # Angular app
└── BackEnd/               # Spring Boot REST API
```

## Features

- User login and registration
- Employee listing, add, edit, delete
- Dropdown data for locations, roles, and product teams

## Running Locally

### Prerequisites
- Node.js 18+
- Java 18
- MySQL

### Backend

1. Create a MySQL database named `loginPage`
2. Update credentials in `BackEnd/src/main/resources/application.properties` if needed
3. Run:
```bash
cd BackEnd
./mvnw spring-boot:run
```
Backend runs on `http://localhost:8080`

### Frontend

```bash
cd FrontEnd/login-page
npm install
npm start
```
Frontend runs on `http://localhost:4200`

## Deployment

| Service | Platform |
|---|---|
| Backend | [Render](https://render.com) |
| Frontend | [Vercel](https://vercel.com) |

### Deploy Backend (Render)
- Root Directory: `BackEnd`
- Build Command: `./mvnw clean package -DskipTests`
- Start Command: `java -jar target/BackEnd-0.0.1-SNAPSHOT.jar`

### Deploy Frontend (Vercel)
1. Update `FrontEnd/login-page/src/environments/environment.prod.ts` with your Render backend URL
2. Root Directory: `FrontEnd/login-page`
3. Build Command: `npm run build`
4. Output Directory: `dist/login-page`
