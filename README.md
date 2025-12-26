

# 🛒 Inventory & Order Management System (Microservices)

## 📌 Overview

This project simulates a **real-world e-commerce scenario** where products are stored across warehouses with **batch-level inventory and expiry dates**.
It demonstrates how an **Order Service** and an **Inventory Service** can interact in a **microservices architecture** using **Spring Boot**, **REST APIs**, and **H2** databases.

The system is designed to be **modular, extensible, and easy to understand**, following best practices such as layered architecture and the **Factory Design Pattern**.

---

## 🏗️ Architecture

```
inventory-order-system
│
├── inventory-service   (Manages inventory & batches)
├── order-service       (Places orders & reserves inventory)
└── README.md
```

### Key Points

* Two **independent Spring Boot microservices**
* Communication via **REST (RestTemplate)**
* Each service has its **own database**
* Inventory Service is the **source of truth**

---

## 🔧 Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* H2 In-Memory Database
* RestTemplate (inter-service communication)
* Maven
* Lombok

---

## 📦 Microservices Details

### 1️⃣ Inventory Service

**Responsibilities**

* Maintain product inventory
* Handle multiple batches per product with expiry dates
* Reserve inventory when an order is placed
* Allow future extensibility using **Factory Pattern**

**Port**

```
8081
```

**Key Endpoints**

| Method | Endpoint                 | Description                              |
| ------ | ------------------------ | ---------------------------------------- |
| GET    | `/inventory/{productId}` | Fetch inventory batches sorted by expiry |
| POST   | `/inventory/update`      | Reserve/update inventory after order     |

---

### 2️⃣ Order Service

**Responsibilities**

* Accept customer orders
* Validate product availability
* Call Inventory Service to reserve stock
* Persist order details

**Port**

```
8082
```

**Key Endpoints**

| Method | Endpoint | Description       |
| ------ | -------- | ----------------- |
| POST   | `/order` | Place a new order |

---

## 🔄 Order Flow

```
Client
  ↓
Order Service
  → GET /inventory/{productId}
  → Validate stock
  → POST /inventory/update
  → Save order
  ↓
Order Response
```

---

## 📄 Sample API Requests & Responses

### 🔹 Place Order

**Request**

```json
POST /order
{
  "productId": 1002,
  "quantity": 3
}
```

**Response**

```json
{
  "orderId": 5012,
  "productId": 1002,
  "productName": "Smartphone",
  "quantity": 3,
  "status": "PLACED",
  "reservedFromBatchIds": [9],
  "message": "Order placed. Inventory reserved."
}
```

---

### 🔹 Get Inventory

**Request**

```http
GET /inventory/1001
```

**Response**

```json
{
  "productId": 1001,
  "productName": "Laptop",
  "batches": [
    {
      "batchId": 1,
      "quantity": 50,
      "expiryDate": "2026-06-25"
    },
    {
      "batchId": 10,
      "quantity": 18,
      "expiryDate": "2026-11-15"
    }
  ]
}
```

---

## 🗃️ Database & Liquibase

* Each service uses an **H2 in-memory database**
* Schema and data are created automatically at startup
* CSV data is loaded using **Liquibase `<loadData>`**

### H2 Console

* Inventory Service: `http://localhost:8081/h2-console`
* Order Service: `http://localhost:8082/h2-console`

---

## 🧪 Testing

### Unit Tests

* Service layer tested using **JUnit 5 & Mockito**

### Integration Tests

* REST endpoints tested using `@SpringBootTest`
* Uses H2 database

---

## ▶️ How to Run the Project

### Prerequisites

* Java 17
* Maven

### Steps

```bash
git clone <repository-url>
cd inventory-order-system
```

#### Start Inventory Service

```bash
cd inventory-service
mvn spring-boot:run
```

#### Start Order Service

```bash
cd order-service
mvn spring-boot:run
```

## 👤 Author

**Ambar Gupta**
Java | Spring Boot | Microservices

---
