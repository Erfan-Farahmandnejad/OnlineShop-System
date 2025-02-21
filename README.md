# 🛒 Online Shop

## 📌 Overview
This project is a **JavaFX-based Online Shopping System** designed for both **administrators** and **clients**. It provides a user-friendly graphical interface for managing users, products, and transactions. The system is developed using the **MVC (Model-View-Controller) design pattern**, ensuring better organization, scalability, and maintainability.

The application includes:
- A robust **admin panel** for managing inventory, approving orders, and handling discounts.
- A **client interface** for browsing products, making purchases, and submitting feedback.
- Built-in **exception handling** for smooth error management.

## 🛠️ Features
### 🏢 Admin Panel:
- View, manage, and remove **clients**.
- Approve or reject **purchase requests**.
- Add, update, and delete **products**.
- Apply **discounts** and manage **user scores**.

### 🛍️ Client Features:
- **Browse** and search for available products.
- **Add items** to the shopping cart and proceed with checkout.
- **Apply discount codes** to orders.
- **Submit reviews** and rate products.
- **Track order history**.

### ⚠️ Error Handling:
- Custom exception handling for:
  - **Inventory shortages** (when an item is out of stock).
  - **Invalid discount codes**.
  - **Incorrect user input**.

## 🏗️ Project Structure
```
OnlineShop-System
│── src/main/java/com/example/
│   ├── controller/  # Handles business logic
│   ├── model/       # Data models and logic
│   ├── view/        # JavaFX UI components
│── target/          # Compiled Java classes
│── .idea/           # IntelliJ project files
│── pom.xml          # Maven dependencies
```

## 🚀 Installation & Setup
### Prerequisites
Ensure you have the following installed:
- **Java 11+**
- **Apache Maven**
- **JavaFX SDK** (if required)

### Steps to Run
1. **Clone the Repository**
   ```sh
   git clone https://github.com/Erfan-fn/OnlineShop-System.git)
   cd OnlineShop-System
   ```
2. **Build the Project**
   ```sh
   mvn clean install
   ```
3. **Run the Application**
   ```sh
   mvn javafx:run
   ```

## 📚 Dependencies
This project uses the following dependencies:
- **JavaFX** (Ensure JavaFX SDK is included in your system environment)
- **Maven** (for project management and dependencies)
- **JUnit** (for testing, if applicable)

## 📘 Usage Guide
### Running as Admin:
1. **Log in** using an admin account.
2. **Manage inventory**: Add, remove, or update product listings.
3. **Approve/reject orders** placed by clients.
4. **Apply discounts** and manage reviews.

### Running as Client:
1. **Register/Login** into the system.
2. **Browse products** and add desired items to the cart.
3. **Proceed to checkout** and apply discount codes if available.
4. **Complete the purchase** and provide feedback if needed.

