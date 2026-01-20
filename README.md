# SmartStock  
## Inventory & Order Management System (Java OOP)

---

## 📌 Project Overview
SmartStock is a **console-based Java application** built for small retail businesses.
It manages **products, users, and customer orders** using **Object-Oriented Programming (OOP)** concepts.

This project is designed to demonstrate **clean architecture**, **real-world system design**, and **scalable OOP practices**.

---

## 🎯 Project Objectives
- Apply core Java OOP principles in a real-world scenario
- Design a clean and readable package structure
- Practice business logic and validation rules
- Build a portfolio-ready Java system

---

## 📂 Project Structure

~~~
smartstock/
│
├── product/
│   ├── Product.java
│   ├── PerishableProduct.java
│   ├── NonPerishableProduct.java
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
~~~

---

## 📦 Package Details & Classes

### 🔹 product Package
Handles all **product-related information and behavior**.

#### 1️⃣ Product (Base Class)
**Responsibilities:** Store basic product information and manage stock.  

**Fields:**
- `id` (String) → Unique product ID  
- `name` (String) → Product name  
- `price` (double) → Price per unit  
- `quantity` (int) → Available stock  

**Methods:**
- `increaseStock(int amount)` → Add stock  
- `decreaseStock(int amount)` → Reduce stock (cannot go below 0)  
- `getProductDetails()` → Display product information  

**OOP Concepts Used:**
- **Encapsulation** → Private fields with getters/setters  
- **Inheritance** → Base class for product types  
- **Polymorphism** → Overridable methods for custom behavior in subclasses  

---

#### 2️⃣ PerishableProduct
**Responsibilities:** Represent products that expire.  

**Additional Fields:**
- `expirationDate` (LocalDate) → Expiration date  

**Methods:**
- Override `getProductDetails()` → Include expiration date  
- `isExpired()` → Returns true if past expiration  

**OOP Concepts Used:**
- **Inheritance** → Extends `Product`  
- **Method Overriding** → Custom product display  
- **Encapsulation** → Private expiration field  

---

#### 3️⃣ NonPerishableProduct
**Responsibilities:** Represent durable products with optional warranty.  

**Additional Fields:**
- `warrantyMonths` (int) → Warranty period in months  

**Methods:**
- Override `getProductDetails()` → Include warranty information  

**OOP Concepts Used:**
- **Inheritance** → Extends `Product`  
- **Polymorphism** → Overridden display method  

---

### 🔹 user Package
Manages **system users and their roles**.

#### 1️⃣ User (Base Class)
**Responsibilities:** Shared behavior for all users.  

**Fields:**
- `id` (String) → Unique user ID  
- `name` (String) → User name  
- `email` (String) → Contact email  

**Methods:**
- `login()` → Authenticate user  
- `viewProducts()` → View all available products  
- `performRoleAction()` → Abstract method for role-specific actions  

**OOP Concepts Used:**
- **Encapsulation** → Private fields with getters/setters  
- **Abstraction** → Shared functionality with abstract method for roles  
- **Inheritance** → Base class for `Admin` and `Customer`  

---

#### 2️⃣ Admin
**Responsibilities:** Manage products and view all orders.  

**Additional Methods:**
- `addProduct(Product product)`  
- `updateStock(String productId, int amount)`  
- `viewAllOrders()`  

**OOP Concepts Used:**
- **Inheritance** → Extends `User`  
- **Polymorphism** → Implements `performRoleAction()`  
- **Encapsulation** → Admin actions controlled by methods  

---

#### 3️⃣ Customer
**Responsibilities:** Place orders and view order history.  

**Additional Methods:**
- `placeOrder(Order order)`  
- `viewOrderDetails()`  

**OOP Concepts Used:**
- **Inheritance** → Extends `User`  
- **Polymorphism** → Implements `performRoleAction()`  
- **Encapsulation** → Customer actions restricted to methods  

---

### 🔹 order Package
Handles **ordering and transaction logic**.

#### 1️⃣ Order
**Responsibilities:** Represent a single customer order and manage items.  

**Fields:**
- `orderId` (String) → Unique order ID  
- `customer` (Customer) → Who placed the order  
- `items` (List<OrderItem>) → Order details  
- `totalAmount` (double) → Total price of the order  
- `orderStatus` (OrderStatus enum) → Current order state  

**Methods:**
- `addItem(Product product, int quantity)` → Adds product to order  
- `calculateTotal()` → Updates `totalAmount`  
- `changeOrderStatus(OrderStatus newStatus)` → Update order state  

**OOP Concepts Used:**
- **Composition** → Order has multiple OrderItems  
- **Encapsulation** → Private fields with controlled access  
- **Enums** → OrderStatus: PENDING, PAID, CANCELLED  

---

#### 2️⃣ OrderItem
**Responsibilities:** Represent a single line item in an order.  

**Fields:**
- `product` (Product) → Product ordered  
- `quantity` (int) → Number of units  
- `subTotal` (double) → Price × quantity  

**Methods:**
- `calculateSubTotal()` → Compute subtotal for this item  
- `getItemDetails()` → Display item info  

**OOP Concepts Used:**
- **Encapsulation** → Private fields  
- **Composition** → Belongs to Order  
- **Single Responsibility** → Handles only one product line  

---

## ⚙️ Functional Requirements

### Admin
- Add new products  
- Update product stock  
- View all orders  

### Customer
- View available products  
- Place orders  
- View order details  

### System Rules
- Product stock must not go below zero  
- Order quantity must be validated  
- Order total must be calculated automatically  

---

## 🧠 OOP Principles Applied

| Principle        | Implementation                          |
|-----------------|------------------------------------------|
| Encapsulation    | Private fields and controlled access     |
| Inheritance      | User and Product hierarchies             |
| Polymorphism     | Overridden behavior per subclass         |
| Abstraction      | Base classes for shared functionality    |
| Composition      | Order contains OrderItems                |
| Single Responsibility | OrderItem handles one product line |

---

## ⏳ Project Scope
- Console-based only  
- In-memory data storage  
- No database or external libraries  

---

## 🗓️ Timeline
- Designed to be completed in **1 week**  
- Focused on clean design and OOP mastery  

---

## 🚀 Future Enhancements
- Payment system integration  
- File or database storage  
- Graphical user interface (GUI)  
- Web-based version  
- Sales reports and analytics  

---

## 👤 Author
**Myrson Beros**  
Java Beginner Developer  
Focused on mastering Object-Oriented Programming  

---

## 📄 License
This project is for learning and portfolio purposes only.
