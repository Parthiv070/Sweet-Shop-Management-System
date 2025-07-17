# Sweet Shop Management System

A full-stack **Sweet Shop Management System** built using **Spring Boot** and **MongoDB** to manage sweets inventory, sales, and restocking. This project also includes unit testing with **JUnit** and **Mockito**, and is version-controlled using Git.

---

## ✨ Features

* Add, update, and delete sweets
* Purchase sweets (decrease quantity with stock check)
* Restock sweets (increase quantity)
* Search sweets by:

  * Name
  * Category
  * Price range
* Auto-generated sequential IDs starting from `1001`
* Full CRUD operations via RESTful APIs
* Cross-Origin (CORS) support for front-end integration
* Basic Spring Security (disabled CSRF for API calls)

---

## 📂 Technologies Used

* **Backend**: Java, Spring Boot (v3.4.7), Spring Web, Spring Security, Spring Data MongoDB
* **Database**: MongoDB
* **Build Tool**: Maven
* **Testing**: JUnit 5, Mockito

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Parthiv070/Sweet-Shop-Management-System.git
cd Sweet-Shop-Management-System
```

### 2. MongoDB Setup

Ensure you have MongoDB running on:

```
localhost:27017
```

Create a database called:

```
sweetshopdb
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

Application will run on:

```
http://localhost:8080
```

---

## ✅ API Endpoints

| Method | Endpoint                    | Description                          |
| ------ | --------------------------- | ------------------------------------ |
| POST   | `/api/sweets`               | Add a new sweet                      |
| GET    | `/api/sweets`               | Get all sweets                       |
| PUT    | `/api/sweets/{id}`          | Update sweet quantity                |
| DELETE | `/api/sweets/{id}`          | Delete a sweet                       |
| PUT    | `/api/sweets/{id}/purchase` | Purchase sweet                       |
| PUT    | `/api/sweets/{id}/restock`  | Restock sweet                        |
| GET    | `/api/sweets/search`        | Search sweets by name/category/price |

---

## 💼 Test Report

Unit tests written using JUnit and Mockito for the SweetService class.

### Sample Test Output

```
SweetServiceTest:
✔ testAddSweet PASSED
✔ testPurchaseSweet PASSED
✔ testRestockSweet PASSED
```



---

## 📷 Screenshots (Frontend Optional)

> Replace with your screenshots (UI if built or Hoppscotch test screenshots)

* ![Add Sweet API](screenshots/add-sweet.png)
* ![Purchase Sweet](screenshots/purchase-sweet.png)
* ![Search by Category](screenshots/search-category.png)

---

## ✍ Author

**Parthiv Chudasama**
GitHub: [@Parthiv070](https://github.com/Parthiv070)

---

## 🔗 Git Commit History

```bash
1. git init
2. echo "# Sweet Shop Management System" > README.md
   git add README.md
   git commit -m "Initial commit with README"

3. Added test case
   git add .
   git commit -m "Add test for adding sweets"

4. Implemented add sweet feature
   git add .
   git commit -m "Implement add sweet feature"

5. Implemented purchase/restock
   git add .
   git commit -m "Add purchase and restock features"

6. Finalize controller and security config
   git add .
   git commit -m "Final API and security configuration"
```

---

## 🚫 Known Issues

* Frontend UI not included (optional)
* No authentication layer (beyond basic config)

---

## ✨ Future Enhancements

* Add user login (JWT based)
* Front-end dashboard
* Export reports (CSV or PDF)
