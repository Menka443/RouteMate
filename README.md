# 🚗 RouteMate

RouteMate is a smart Android application that connects office commuters traveling on similar daily routes. Instead of focusing on ride booking, RouteMate helps professionals discover and connect with people who commute between similar home and office locations.

> **Current Status:** Authentication Module Completed ✅

---

# ✨ Features

## 🔐 Authentication

- Email & Password Sign Up
- Secure Login using Firebase Authentication
- Password Validation
- Firestore User Profile Storage
- Automatic User Session Management
- Input Validation
- Error Handling
- Modern Jetpack Compose UI

---

# 📱 Screens

## Login Screen

Users can securely log in using their registered email and password.

### Features
- Email Authentication
- Password Visibility Toggle
- Input Validation
- Firebase Authentication
- Forgot Password (UI)
- Navigate to Sign Up

---

## Sign Up Screen

Allows new users to create a RouteMate account.

### User Information
- Full Name
- Email Address
- Phone Number
- Company Name
- Home Location
- Office Location
- Password
- Confirm Password

### Features
- Firebase Authentication
- Firestore User Profile Creation
- Password Confirmation
- Terms & Conditions
- Form Validation
- Automatic Navigation after Registration

---

# 🔥 Firebase Integration

## Firebase Authentication
- Secure Email & Password Login
- User Registration
- Session Management

## Cloud Firestore

Each registered user is stored in the **users** collection.

Example Document

```text
users
 └── uid
      ├── uid
      ├── name
      ├── email
      ├── phone
      ├── company
      ├── home
      └── office
```

---

# 📂 Project Structure

```text
app
│
├── login
│   ├── LoginScreen
│   ├── LoginViewModel
│   ├── LoginState
│
├── signUp
│   ├── SignUpScreen
│   ├── SignupViewModel
│   ├── SignupState
│   ├── User
│
├── repository
│   ├── AuthRepository
│   ├── UserRepository
│
├── home
│   ├── HomeViewModel
│   ├── HomeState
│
└── navigation
```

---

# 🏗 Architecture

The project follows the **MVVM (Model-View-ViewModel)** architecture.

```
UI (Jetpack Compose)
        │
        ▼
ViewModel
        │
        ▼
Repository
        │
        ▼
Firebase Authentication
Cloud Firestore
```

---

# 🚀 Upcoming Features

- Dynamic Home Screen
- Find People Going Your Way
- Smart Commuter Matching
- Connection Requests
- Real-Time Chat
- Google Maps Integration
- Live Location Sharing
- Google Sign-In
- Phone Authentication
- Push Notifications

---

# 📸 Screenshots

### Login Screen

> Add login screenshot here.

```
assets/login_screen.png
```

### Sign Up Screen

> Add signup screenshot here.

```
assets/signup_screen.png
```

---

# 👩‍💻 Developer

**Menka Shah**

Android Developer | Kotlin | Jetpack Compose | Firebase

---

⭐ If you like this project, consider giving it a star!
