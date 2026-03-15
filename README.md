# 🛒 Ecommerce Backend API

A Spring Boot based Ecommerce Backend REST API that supports product management, stock management, and order processing.
This project demonstrates Spring Boot, Spring Data JPA, REST APIs, and database interaction in a simple but practical ecommerce scenario.

# 🚀 Features

Product Management (Add, View, Update, Delete products)

Stock Management (Update product inventory)

Place Orders with Multiple Products

Automatic Stock Deduction after Order

Order History Retrieval

Validation for Insufficient Stock

Unique Order ID generation

Transaction management using @Transactional

# 🛠️ Tech Stack
Technology	Purpose
Java 17+	Programming Language
Spring Boot	Backend Framework
Spring Data JPA	Database ORM
Hibernate	ORM Implementation
Postgres
Maven	Build Tool
Postman	API Testing
# 📂 Project Structure
ecommerce
│
├── controller
│   └── OrderController
│
├── service
│   └── OrderService
│
├── repository
│   ├── ProductRepository
│   └── OrderRepository
│
├── model
│   ├── Product
│   ├── Order
│   └── OrderItem
│
├── dto
│   ├── OrderRequest
│   ├── OrderResponse
│   ├── OrderItemRequest
│   └── OrderItemResponse
│
└── EcommerceApplication
# 📦 API Endpoints
Product APIs
Method	Endpoint	Description
GET	/products	Get all products
GET	/products/{id}	Get product by ID
POST	/products	Add a product
PUT	/products/{id}	Update product
DELETE	/products/{id}	Delete product
PUT	/products/{id}/stock	Update product stock
Order APIs
Method	Endpoint	Description
POST	/orders	Place an order
GET	/orders	Get all orders
# 📝 Example API Request
Place Order

POST

/orders
Request Body
{
  "customerName": "Vishnu",
  "email": "vishnu@example.com",
  "items": [
    {
      "productId": 1,
      "quantity": 2
    },
    {
      "productId": 3,
      "quantity": 1
    }
  ]
}
# Response
{
  "orderId": "ORD-A1B2C3D4",
  "customerName": "Vishnu",
  "email": "vishnu@example.com",
  "status": "PLACED",
  "orderDate": "2026-03-15",
  "items": [
    {
      "productName": "Laptop",
      "quantity": 2,
      "totalPrice": 150000
    },
    {
      "productName": "Mouse",
      "quantity": 1,
      "totalPrice": 500
    }
  ]
}
# ⚙️ Setup Instructions
1 Clone the Repository
git clone https://github.com/vishnu-netizen/Ecommercebackend.git
cd Ecommercebackend
2 Configure Database

# Edit

src/main/resources/application.properties

# Example:

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
# Run the Application
mvn spring-boot:run

Server will start at

http://localhost:8080
# 🧠 Business Logic
Order Placement Flow

Receive Order Request

Fetch Products from Database

Validate Stock Availability

Deduct Stock Quantity

Create Order and Order Items

Save Order in Database

Return Order Response

# 🔒 Transaction Management

The order service uses:

@Transactional

This ensures:

If one item fails → entire order rolls back

Database remains consistent
