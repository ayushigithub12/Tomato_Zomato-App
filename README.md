# 🍅 Tomato – Zomato Clone (LLD Based)

## 📌 Overview
**Tomato** is a **Low-Level Design (LLD)** implementation of a food delivery application inspired by **Zomato**.  
The project demonstrates **object-oriented design principles** and the use of **design patterns** to model the core functionalities of a food delivery platform.

This project focuses on **system design concepts** (not a full backend or database), making it useful for:
- Practicing **LLD interview questions**
- Understanding **OOP principles in Java**
- Demonstrating **design skills** for system design rounds

---

## ⚙️ Tech Stack
- **Language:** Java  
- **Concepts:** OOPs, Low-Level Design, SOLID Principles  
- **Design Patterns Used:**
  - **Singleton** → Global configuration (e.g., OrderManager, Logger)  
  - **Factory** → Restaurant/Menu creation  
  - **Observer** → Order status notifications  
  - **Strategy** → Payment methods (UPI, Card, Wallet)  

---

## 🏗️ System Design Highlights
- Modeled **Users, Restaurants, Orders, Payments, Delivery Agents** as entities  
- Applied **Factory Pattern** for dynamically creating restaurants & menus  
- Used **Observer Pattern** for notifying customers when order status changes  
- Implemented **Strategy Pattern** for handling multiple payment methods  
- **Singleton Pattern** for managing global instances like configuration/logging  
