# Online Store Management System

## Overview
This Online Store Management System is a console-based application implemented in Java. It allows users to sign up, sign in, view and manage products, place orders, and update their account settings. The system is designed with a modular approach, adhering to the principles of Object-Oriented Programming (OOP).

## Project Structure
The project is organized into several packages, each containing classes responsible for specific functionalities:

### Packages and Classes

**Entities (`org.Masri.SimpleRest.Enteties`)**

- **User:** Represents a user in the system.
- **Order:** Represents an order placed by a user.
- **Product:** Represents a product available in the store.
- **Cart:** Represents a shopping cart for the current session.

**Entities Implementation (`org.Masri.SimpleRest.Enteties.impl`)**

- **DefaultUser:** Default implementation of the User interface.
- **DefaultOrder:** Default implementation of the Order interface.
- **DefaultProduct:** Default implementation of the Product interface.

**Services (`org.Masri.SimpleRest.Services`)**

- **OrderManagementService:** Interface for managing orders.
- **ProductManagementService:** Interface for managing products.
- **UserManagementService:** Interface for managing users.

**Services Implementation (`org.Masri.SimpleRest.Services.Impl`)**

- **DefaultOrderManagementService:** Default implementation of the OrderManagementService.
- **DefaultProductManagementService:** Default implementation of the ProductManagementService.
- **DefaultUserManagementService:** Default implementation of the UserManagementService.

**Config (`org.Masri.SimpleRest.Config`)**

- **ApplicationContext:** Singleton class managing application-wide context.

**Menu (`org.Masri.SimpleRest.Menu`)**

- **Menu:** Interface for menu operations.
- **MainMenu, SignUpMenu, SignInMenu, SignOutMenu, ProductMenu, OrderMenu, SettingsMenu, ChangePasswordMenu, ChangeEmailMenu, CheckOutMenu, CustomerListMenu:** Implementations of the Menu interface for various functionalities.

## How to Run
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/yourusername/OnlineStoreManagementSystem.git
