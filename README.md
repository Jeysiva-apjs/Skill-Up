# SkillUp - Online Course Selling Platform API

This is a REST API for an online course-selling platform developed using Java and Spring Boot. It allows users to browse, purchase, and manage courses, while providing admins and instructors with tools to manage users and course content efficiently. Role-based authentication and authorization have been implemented using Spring Security to ensure that only authorized users can access specific endpoints, with separate permissions for admins, instructors, and students.


## Features

- **Admin Dashboard**
  - Manage user accounts (convert students to instructors, delete users)
  - Handle course creation, updates, and deletions

- **Instructor Functionality**
  - Create, update, and delete courses
  - View all available courses

- **Student Functionality**
  - Browse all available courses
  - Purchase courses
  - View purchased courses

- **Authentication**
  - Register as a Student, Instructor, or Admin
  - Login and Logout
  - Fetch current logged-in user details
  - Role-based access control enforced by Spring Security

- **Reliability**
  - Custom exception handling
  - Comprehensive unit testing


## API Endpoints

### Instructor API
| Method | Endpoint | Description |
|--------|---------|-------------|
| PUT    | `/instructor/courses/update/{courseId}` | Update Existing Course |
| POST   | `/instructor/courses/create` | Create a New Course |
| GET    | `/instructor/courses/all` | Get All Courses |
| DELETE | `/instructor/courses/delete/{courseId}` | Delete Existing Course |

### Student API
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST   | `/student/purchaseCourses/{courseId}` | Purchase a Course |
| GET    | `/student/purchasedCourses` | Get All Purchased Courses |
| GET    | `/student/courses/all` | View All Available Courses |

### Admin API
| Method | Endpoint | Description |
|--------|---------|-------------|
| PUT    | `/admin/{userId}` | Convert Student to Instructor |
| DELETE | `/admin/{userId}` | Delete Student/Instructor |
| GET    | `/admin/users` | Get All Users |

### Authentication API
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST   | `/auth/register/student` | Register as New Student |
| POST   | `/auth/register/instructor` | Register as New Instructor |
| POST   | `/auth/register/admin` | Register as New Admin |
| POST   | `/auth/login` | Login with Email and Password |
| POST   | `/auth/logout` | Logout Current Logged-in User |
| GET    | `/auth/session-user` | Get Current Logged-in User |


## Technology Stack

- Java 21
- Spring Boot
- Spring Security
- JPA/Hibernate
- MySQL



