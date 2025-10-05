# 🛒 Simple Shopping Cart

A simple fullstack shopping cart web application built with **React (Frontend)** and **Spring Boot (Backend)**.  
It allows users to browse products, add them to the cart, adjust quantities, and checkout — with all cart data being sent to the backend.

---

## 📁 Project Structure

### 🖥️ Frontend — `shop_frontend/`

```
frontend/
│  package.json               # Frontend dependencies
│  vite.config.js             # Vite configuration
│
└─ src/
   ├─ index.jsx               # React entry point
   ├─ App.jsx                 # Root app structure & routing
   │
   ├─ service/
   │   └─ api.js              # Contains functions to call backend APIs (fetchProducts, checkout, etc.)
   │
   ├─ components/
   │   ├─ ProductCard/        # Displays individual product info
   │   │   ├─ ProductCard.jsx
   │   │   └─ ProductCard.css
   │   │
   │   ├─ ProductModal/       # Shows detailed product view
   │   │   ├─ ProductModal.jsx
   │   │   └─ ProductModal.css
   │   │
   │   └─ cart/               # Handles cart UI and logic
   │       ├─ CartContext.jsx # Manages global cart state (Context API)
   │       ├─ Cart.jsx        # Cart view component
   │       └─ Cart.css
   │
   ├─ App.css                 # Global styling
   ├─ index.css               # Base styles
   ├─ reportWebVitals.js      # Performance metrics
   ├─ setupTests.js           # Frontend test config
   └─ App.test.js             # Sample React test

```
---

### ⚙️ Backend — `shop_backend/`

```
backend/
│  pom.xml                    # Maven dependencies
│  mvnw, mvnw.cmd             # Maven wrapper scripts
│
└─ src/
   └─ main/
      ├─ java/com/example/shop/
      │   ├─ ShopApplication.java  # Spring Boot entry point
      │   │
      │   ├─ dto/                 # Data Transfer Objects
      │   │   ├─ ProductDTO.java  # Product data sent to frontend
      │   │   └─ CartDTO.java     # Cart data sent/received
      │   │
      │   ├─ model/               # Application data models
      │   │   └─ ProductEntity.java  # Represents a product
      │   │
      │   ├─ service/             # Business logic layer
      │   │   ├─ ProductService.java # Provides product list
      │   │   └─ CartService.java    # Handles cart operations
      │   │
      │   └─ restcontroller/       # REST endpoints
      │       └─ ProductController.java # Exposes product & cart APIs
      │
      └─ resources/
          └─ application.properties # Server configuration

```


---

## ⚙️ Setup Instructions

### 🧩 1. Frontend Setup (React)

1. Navigate to the frontend folder:
   ```bash
   cd shop_frontend

2. folder contains all the packages in case anything is missing
   ```bash
   npm i
3. Start the frontend development server:
   ```bash
   npm start
4. The app runs by default on:
   ```bash
   http://localhost:3000
5. If port 3000 is busy, you can run it on another port:
   ```bash
   npm start -- --port=4000
   
### 🧩 2. Backend Setup (Spring Boot)

1. Navigate to the backend folder:
   ```bash
   cd shop_backend
2. Run the backend server (Linux/macOS):
   ```bash
   ./mvnw spring-boot:run
   ```
   or on Windows:
   ```bash
   mvnw.cmd spring-boot:run
3. The backend runs on:
       http://localhost:8080
4. If port 8080 is busy, open the file:
   ```
   src/main/resources/application.properties
   * and add this line
   server.port=9090

5. in case if you change the port got to shop_frontend/services/api.js and change the port in the url.

### 🎥 Project Walkthrough Video


https://github.com/user-attachments/assets/77b5fc18-b59f-430a-9dd9-e88bbbc1f94e



```
## 📡 API Endpoints Overview

Below is a quick overview of the key backend API endpoints used in this project:

| Endpoint              | Method | Description                  |
|-----------------------|--------|------------------------------|
| `/api/products`       | GET    | Fetch all available products |
| `/api/checkout`       | POST   | Send cart data for checkout  |

Example request and response:
![API Endpoint Example](./shop_backend/src/main/resources/static/api-endpoints.png)
*(Above: Postman example of the `/api/checkout` request)*

```

<img width="1920" height="1080" alt="Screenshot from 2025-10-05 20-05-46" src="https://github.com/user-attachments/assets/131aa7f8-8ea5-4eee-a0e4-7c8b9436ccb0" />






