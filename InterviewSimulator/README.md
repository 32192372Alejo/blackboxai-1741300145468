# Interview Simulator App

A mobile application built with Kotlin and Jetpack Compose that helps users practice and improve their interview skills through simulated interviews.

## Features

- Interactive interview simulations
- Multiple interview types (Technical, Sales, Product Management, etc.)
- Video and text-based responses
- Real-time feedback and performance tracking
- Customizable difficulty levels
- Progress tracking and statistics
- User profile management
- Settings customization

## Tech Stack

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Architecture:** MVVM
- **Dependency Injection:** Hilt
- **Navigation:** Jetpack Navigation Compose
- **Database:** Room (for local storage)
- **Concurrency:** Kotlin Coroutines & Flow

## Project Structure

```
app/
├── build.gradle
├── src/
│   └── main/
│       ├── java/com/example/interviewsimulator/
│       │   ├── ui/
│       │   │   ├── theme/
│       │   │   └── screens/
│       │   ├── MainActivity.kt
│       │   └── InterviewSimulatorApp.kt
│       └── res/
│           └── values/
│               └── strings.xml
```

## Setup

1. Clone the repository
2. Open the project in Android Studio
3. Sync project with Gradle files
4. Run the app on an emulator or physical device

## Requirements

- Android Studio Arctic Fox or newer
- Android SDK 24 or higher
- Kotlin 1.8.10 or higher

## Building and Running

1. Open the project in Android Studio
2. Wait for the Gradle sync to complete
3. Select a device/emulator
4. Click the "Run" button or press Shift + F10

## License

This project is licensed under the MIT License - see the LICENSE file for details.
