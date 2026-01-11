# 🚦 JavaFX Traffic Light Simulator

A robust traffic control simulation built with **Java** and **JavaFX**.
This project demonstrates the implementation of a multi-threaded environment where business logic operates independently from the UI thread, ensuring a responsive and smooth graphical interface.

## 🚀 Features
* **Multi-threaded Architecture:** Separates the simulation timing logic from the JavaFX Application Thread.
* **Thread Safety:** Utilizes `Platform.runLater` to safely update GUI elements from background threads.
* **Dynamic Configuration:** Traffic timings (Red/Green duration) are configurable via command-line arguments.
* **State Machine Logic:** Manages complex traffic states including car flow, pedestrian crossing, and blinking warning phases.
* **MVC Design Pattern:** Clear separation between the View (FXML), Controller, and Model (Logic).

## 🛠️ Tech Stack
* **Language:** Java
* **UI Framework:** JavaFX / FXML
* **Concepts:** Concurrency, Event Handling, Object-Oriented Programming.

## ⚙️ How It Works
The system is built on a "Producer-Consumer" style relationship:
1.  **TrafficLogic (Background Thread):** Handles the timing loops and state transitions. It calculates when to switch lights and when to initiate the blinking sequences.
2.  **TrafficController (UI Thread):** Listens to the logic layer and updates the visual elements (Circle colors, effects) on the screen.

This prevents the common "frozen UI" issue often found in beginner JavaFX applications using `Thread.sleep()`.

## 📦 How to Run

### Prerequisites
* Java Development Kit (JDK) 8 or higher.
* JavaFX SDK (if using JDK 11+).

### Running via Command Line
The application accepts two integer arguments:
1.  Red Light Duration (ms)
2.  Green Light Duration (ms)

You can use the included batch file:
```bash
run.bat 
