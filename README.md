# 🚀 Nexus Wallet - Microservices FinTech System

**Nexus Wallet** is a comprehensive electronic payment and financial management system built on a **Microservices Architecture** using **Java 21** and **Spring Boot 3**. The system is designed for high scalability, efficient transaction handling, and seamless service integration.

---

## 🏗️ System Architecture

The system is decoupled into several independent services that collaborate through a centralized ecosystem:
* **Discovery Server (Netflix Eureka):** The central registry where all services register themselves for service discovery.
* **API Gateway (Spring Cloud Gateway):** The unified entry point for the system, responsible for request routing, load balancing, and security.
* **User Service:** Manages user profiles, registration, and core identity data.
* **Wallet Service:** The financial engine of the system, managing digital wallets, balances, and transaction logic.

---

## 🛠️ Tech Stack

* **Backend:** Java 21, Spring Boot 3.2.x
* **Microservices:** Spring Cloud (Gateway, Netflix Eureka, OpenFeign)
* **Data Access:** Spring Data JPA (Hibernate/PostgreSQL)
* **Utilities:** Project Lombok, MapStruct (Mapping), SLF4J (Logging)
* **Build Tool:** Maven

---

## 🚦 Getting Started

To ensure proper service registration, please run the components in the following order:

1.  **Discovery Server:** Start the project on port `8761`.
2.  **API Gateway:** Start the project on port `8080`.
3.  **Core Services:** Start `user-service` and `wallet-service` (they will automatically register with Eureka).

---

## 🔌 API Gateway Endpoints

All services are accessible through the Gateway (Port 8080) using the following routes:

| Service | Method | Endpoint | Description |
| :--- | :--- | :--- | :--- |
| **User** | `POST` | `/user-service/api/users` | Register a new user |
| **User** | `GET` | `/user-service/api/users` | Retrieve all users |
| **Wallet** | `GET` | `/wallet-service/api/wallets` | View wallet details |

---

## 🔧 Project Roadmap

- [x] Established core Microservices Architecture.
- [x] Configured Service Discovery and API Gateway Routing.
- [ ] Implement Spring Security with JWT Authentication.
- [ ] Integrate Transaction Validation & Saga Pattern for data consistency.
- [ ] Containerize the entire stack using Docker & Docker Compose.

---

*This project is part of a dedicated journey into advanced software engineering and FinTech systems.*
