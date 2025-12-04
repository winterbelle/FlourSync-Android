# 🌾 FlourSync Mobile — Bakery Ordering App

A streamlined mobile ordering experience built with Android, Kotlin, and Room.

## 📱 Overview

FlourSync Mobile is a modern mobile ordering system designed for bakery customers.
Users can browse products by category, add items to their cart, select a payment method, and place an order with a smooth and intuitive UI.

Originally designed as a POS system, the project evolved into a customer-facing mobile app similar to Uber Eats but simplified for bakery workflows.

This app was built using clean architecture, Room database, ViewBinding, and RecyclerView across multiple screens.

## ✨ Features
### 🔐 User Authentication

Sign up with full customer information

Username + email checks to prevent duplicates

Login with credential validation

Form resets after successful sign-up

### 🗂️ Category-Based Browsing

Categories are pulled directly from the Room database

Clean, scrollable Category screen

On click → loads only products in that category

### 🍞 Product Listing

Products displayed using:

RecyclerView

GridLayoutManager

Product images from drawable

Real product data seeded via DatabaseSeeder

Live product updates using ProductDao

### 🛒 Cart Management

CartManager singleton handles cart operations:

Add product

Remove product

Clear cart

Calculate total price

Cart preview opens from product screen

Uses CartFragment to display cart dynamically

### 💳 Checkout Flow

Displays final total

Payment method selection:

Pay with Card

Pay at Pickup

Button → navigates to confirmation screen

### 🎉 Order Confirmation

Displays:

Total amount

Payment choice

“Place New Order” button:

Clears the cart

Returns user to product browsing without leftover cart items

## 🧱 Architecture

### Tech Stack

Kotlin

Android SDK

Room Database

ViewBinding

RecyclerView + Adapters

Coroutines (Dispatchers.IO, lifecycleScope)

### Layered Packages

com.example.floursync
 ├── data
 │    ├── AppDatabase
 │    ├── User, UserDao
 │    ├── Product, ProductDao
 │    ├── DatabaseSeeder
 │    ├── CartManager
 │
 ├── ui
 │    ├── login
 │    ├── categories
 │    ├── menu (Products)
 │    ├── cart
 │    ├── checkout
 │    ├── confirmation

## 🗃️ Database Schema (Room)
### User Table
Column	Type
id (PK)	Int
fName	String
lName	String
email	String
username	String
password	String

### Product Table
Column	Type
id (PK)	Int (auto)
name	String
category	String
price	Double
imagePath	String
stockQty	Int

### Category Queries

SELECT DISTINCT category FROM product

### Seeder

Automatically populates initial product list only when database is empty.

## 🚀 How to Run

Clone the repository

Open in Android Studio

Build and run on emulator or device

Create an account to access the app

Browse → Add to Cart → Checkout → Confirm

## 🧪 Testing Notes

Cart clears on new order ✔️

Back navigation implemented via Material Toolbar ✔️

Product filtering works by category ✔️

Login and sign-up fully functional ✔️

Seeder resets only when DB version increments ✔️

## 🏁 Final Thoughts

This project demonstrates:

Mastery of Android fundamentals

Clean UI design with ViewBinding

Proper Room database integration

State management through fragments + managers

Multi-screen user flows

Git branching, merges, and conflict resolution

This is a portfolio-ready mobile app that shows real-world engineering skills.
