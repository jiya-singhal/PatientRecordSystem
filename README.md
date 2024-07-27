
# Patient Record System

The Patient Record System is a Spring Boot application that provides a comprehensive solution for managing patient records, medical histories, and appointments. This project aims to streamline the process of creating, updating, retrieving, and deleting patient information.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later
- MySQL Server

### Installation

1. Clone the repository: `git clone https://github.com/your-username/patient-record-system.git`
2. Navigate to the project directory: `cd patient-record-system`
3. Configure the MySQL database connection in the `application.properties` file
4. Build the project: `./mvnw clean install`
5. Run the application: `./mvnw spring-boot:run`

## Features

 - **Patient Profile Management**
  - Create, retrieve, and delete patient details (name, email, contact number, date of birth)
  - Patients cannot update their medical history details directly.

- **Medical History Management**
  - Add, retrieve, and delete medical history entries for patients.
  - List all medical records for a specific patient.
  - Medical history includes details such as history ID, patient ID, disease name, treatment details, and date of diagnosis.

- **Appointment Management**
  - Retrieve all appointments
  - List all appointments for a specific patient
  - Update and delete appointments
- **Authentication and Authorization**
  - JSON Web Token (JWT) based authentication
  - Generate and validate JWT tokens for authorized access
  - Secure API endpoints with token-based authentication

- **Exception Handling**
  - Global exception handling mechanism
  - Custom exceptions for specific scenarios (e.g., PatientNotFound, AppointmentNotFound, MedicalHistoryInvalid)
  - Consistent error responses with detailed messages and resolutions.

  ## API-Endpoints
  

### Patient

- `GET /patients` - Get all patients
- `GET /patients/{id}` - Get a patient by ID
- `POST /patients` - Add a new patient
- `DELETE /patients/{id}` - Delete a patient by ID

### Medical History

- `GET /history` - Get all medical histories
- `GET /history/{patientId}` - Get all medical histories for a specific patient
- `PUT /history` - Add a new medical history entry
- `DELETE /history/{id}` - Delete a medical history entry by ID

### Appointment

- `GET /appointments` - Get all appointments
- `GET /appointments/{patientId}` - Get all appointments for a specific patient
- `PUT /appointments` - Update an appointment
- `DELETE /appointments/{id}` - Delete an appointment by ID
## Contributing

Contributions are welcome! Please follow the [contribution guidelines](CONTRIBUTING.md) for more information.

## License

This project is licensed under the [MIT License](LICENSE).
