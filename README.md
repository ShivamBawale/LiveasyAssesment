# Liveasy Project

This project is a Spring Boot application for managing loads, allowing users to create, read, update, and delete load details associated with shippers.

## Table of Contents

- [Technologies](#technologies)
- [API Endpoints](#api-endpoints)
- [Setup Instructions](#setup-instructions)
- [How to Test the APIs](#how-to-test-the-apis)
- [Example Requests](#example-requests)

## Technologies

- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Java Version**: 17 (or specify the version you're using)

## API Endpoints

### 1. Create Load

- **Endpoint**: [`POST /load`](http://localhost:8080/load)
- **Description**: Add a new load.
- **Request Body**:
    ```json
    {
        "loadingPoint": "delhi",
        "unloadingPoint": "jaipur",
        "productType": "chemicals",
        "truckType": "canter",
        "noOfTrucks": "1",
        "weight": "100",
        "comment": "OK",
        "shipperId": "463e5214-e89b-34d3-a456-426614174000", //shipperId will be in this format
        "date": "12-05-2024"
    }
    ```
- **Response**: `Load details added successfully`

### 2. Get Loads by Shipper ID

- **Endpoint**: `GET /load/463e5214-e89b-34d3-a456-426614174000
- **Description**: Retrieve a list of loads associated with a specific shipper.
- **Response**:
    - `200 OK`: Returns a list of loads.
    - `204 No Content`: No loads found.

### 3. Get Load by ID

- **Endpoint**: `[GET]http://localhost:8080 /load/{loadId}`
- **Description**: Retrieve a load by its ID.
- **Response**:
    - `200 OK`: Returns the load details.
    - `404 Not Found`: Load not found.

### 4. Update Load

- **Endpoint**: `PUT /load/{loadId}`
- **Description**: Update an existing load.
- **Request Body**:
    ```json
    {
        "loadingPoint": "alwar",
        "unloadingPoint": "jaipur",
        "productType": "chemicals",
        "truckType": "canter",
        "noOfTrucks": "1",
        "weight": "100",
        "comment": "",
        "date": "dd-mm-yyyy"
    }
    ```
- **Response**:
    - `200 OK`: Load updated successfully.
    - `404 Not Found`: Load not found.

### 5. Delete Load

- **Endpoint**: `DELETE /load/{loadId}`
- **Description**: Delete a load by its ID.
- **Response**:
    - `200 OK`: Load deleted successfully.
    - `404 Not Found`: Load not found.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/shivamwaleba/LiveasyAssesment.git
   cd LiveasyAssesment
