# SmartStock

## Inventory & Order Management System (Java OOP)

---

## 📌 Project Overview

**SmartStock** is a **console-based Java application** designed for small retail businesses.
It manages **products, inventory, users, and customer orders** using **Object-Oriented Programming (OOP)** principles.

This project focuses on **clean architecture**, **real-world business logic**, and **scalable design**, making it suitable for learning and portfolio use.

---

## 🎯 Project Objectives

* Practice core Java OOP concepts in a realistic system
* Design a clean and maintainable package structure
* Apply business rules and validations
* Build a portfolio-ready backend system

---

## 📂 Project Structure

```
smartstock/
│
├── product/
│   ├── Product.java
│   ├── PerishableProduct.java
│   ├── NonPerishableProduct.java
│
├── inventory/
│   └── Inventory.java
│
├── user/
│   ├── User.java
│   ├── Admin.java
│   ├── Customer.java
│
├── order/
│   ├── Order.java
│   ├── OrderItem.java
│
└── Main.java
```

---

## 📦 Package Details & Classes

---

## 🔹 product Package

Handles **product data and behavior**.

### 1️⃣ Product (Base Class)

**Purpose:**
Stores common product information and manages stock.

**Fields**

* `id` (String) — Unique product identifier
* `name` (String) — Product name
* `price` (double) — Unit price
* `quantity` (int) — Available stock

**Methods**

* `increaseStock(int amount)` — Increase stock
* `decreaseStock(int amount)` — Decrease stock (cannot go below zero)
* `getProductDetails()` — Returns formatted product info

**OOP Concepts**

* Encapsulation
* Inheritance
* Polymorphism

---

### 2️⃣ PerishableProduct

**Purpose:**
Represents products with an expiration date.

**Additional Field**

* `expirationDate` (LocalDate)

**Methods**

* Override `getProductDetails()`
* `isExpired()` — Checks if product is expired

**OOP Concepts**

* Inheritance
* Method overriding
* Encapsulation

---

### 3️⃣ NonPerishableProduct

**Purpose:**
Represents long-lasting products with warranty support.

**Additional Field**

* `warrantyMonths` (int)

**Methods**

* Override `getProductDetails()`

**OOP Concepts**

* Inheritance
* Polymorphism

---

## 🔹 inventory Package

Manages the **centralized system inventory**.

### 1️⃣ Inventory

**Purpose:**
Acts as the **single source of truth** for all products.

Admins modify inventory; customers only view it.

**Fields**

* `products` (List<Product>) — All available products

**Methods**

* `addProduct(Product product)`
* `removeProduct(String productId)`
* `getProductById(String productId)`
* `getAllProducts()`
* `updateStock(String productId, int amount)`

**OOP Concepts**

* Encapsulation
* Abstraction
* Composition
* Single Responsibility

**Access Rules**

* Admin: full inventory control
* Customer: read-only access

---

## 🔹 user Package

Manages **system users and permissions**.

### 1️⃣ User (Abstract Base Class)

**Purpose:**
Defines shared user behavior.

**Fields**

* `id` (String)
* `name` (String)
* `email` (String)

**Methods**

* `login()`
* `viewProducts()`
* `performRoleAction()` (abstract)

**OOP Concepts**

* Abstraction
* Encapsulation
* Inheritance

---

### 2️⃣ Admin

**Purpose:**
Manages inventory and monitors orders.

**Methods**

* `addProduct(Product product)`
* `updateStock(String productId, int amount)`
* `viewAllOrders()`

**OOP Concepts**

* Inheritance
* Polymorphism

---

### 3️⃣ Customer

**Purpose:**
Places orders and views order history.

**Methods**

* `placeOrder(Order order)`
* `viewOrderDetails()`

**OOP Concepts**

* Inheritance
* Polymorphism

---

## 🔹 order Package

Handles **order creation and processing**.

### 1️⃣ Order

**Purpose:**
Represents a customer transaction.

**Fields**

* `orderId` (String)
* `customer` (Customer)
* `items` (List<OrderItem>)
* `totalAmount` (double)
* `orderStatus` (OrderStatus)

**Methods**

* `addItem(Product product, int quantity)`
* `calculateTotal()`
* `changeOrderStatus(OrderStatus newStatus)`

**OOP Concepts**

* Composition
* Encapsulation
* Enums

---

### 2️⃣ OrderItem

**Purpose:**
Represents one product entry inside an order.

**Fields**

* `product` (Product)
* `quantity` (int)
* `subTotal` (double)

**Methods**

* `calculateSubTotal()`
* `getItemDetails()`

**OOP Concepts**

* Single Responsibility
* Composition
* Encapsulation

---

## ⚙️ Functional Requirements

### Admin

* Add products
* Update stock
* View all orders

### Customer

* View available products
* Place orders
* View order details

### System Rules

* Stock must never be negative
* Order quantities must be validated
* Order totals are calculated automatically

---

## 🧠 OOP Principles Applied

| Principle             | Usage                                       |
| --------------------- | ------------------------------------------- |
| Encapsulation         | Private fields with controlled access       |
| Inheritance           | Product and User hierarchies                |
| Polymorphism          | Role-specific and product-specific behavior |
| Abstraction           | Shared base classes                         |
| Composition           | Orders contain OrderItems                   |
| Single Responsibility | Each class has one clear purpose            |

---

## ⏳ Project Scope

* Console-based application
* In-memory storage only
* No database or frameworks

---

## 🚀 Future Enhancements

* Database integration
* Payment processing
* GUI or web interface
* Sales reporting and analytics

---

## 👤 Author

**Myrson Beros**
Java Beginner Developer
Focused on mastering Object-Oriented Programming

---

## 📄 License

For learning and portfolio purposes only.

---


