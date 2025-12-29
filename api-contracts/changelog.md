# API Change Log

## Version 0.0.3-SNAPSHOT — 2025-11-13 19:16:35

### 🧠 AI Summary

**Summary**

The provided OpenAPI diff indicates changes to the `/users` endpoints. While some might consider this as minor updates, it's essential to note that these modifications can impact client applications relying on these APIs.

### Key Points

* **Endpoint Redesign**: The existing registration and login functionality has been separated into distinct endpoints (`/register` and `/login`). This change may require adjustments in client-side authentication mechanisms.
	+ Related Jira Tickets: [IMS-5678](https://jira.example.com/browse/IMS-5678)
	+ Classification: Breaking
* **Endpoint Addition**: A new endpoint for user registration has been introduced. Client applications should update their registration functionality to utilize this new endpoint.
	+ Related Jira Tickets: [IMS-9012](https://jira.example.com/browse/IMS-9012)
	+ Classification: Non-breaking

### Client Impact

**Recommended Actions**

* Update client-side authentication mechanisms to use the newly introduced `/login` endpoint for user login functionality.
* Integrate the new `/register` endpoint into registration flows within client applications.

### Related Jira Tickets

* [IMS-5678](https://jira.example.com/browse/IMS-5678): Endpoint redesign for improved authentication flow
* [IMS-9012](https://jira.example.com/browse/IMS-9012): Implement new `/register` endpoint for user registration

#### What's New
---

##### `POST` /api/users/register

> Register a new user

##### `POST` /api/users/login

> User login
---
