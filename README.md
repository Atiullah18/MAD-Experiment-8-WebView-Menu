# MAD Experiment 8 – WebView and Menu

## Experiment
**Experiment No.:** 8  
**Title:** Implementing Menus and WebView in an Android Application

## Aim
To develop an Android application demonstrating Options Menu and WebView using Kotlin.

## Requirements
- Android Studio
- Kotlin
- Android SDK
- Emulator/Android Device
- Internet Connection

## Scenario
A university application provides quick access to the JAIN University website and Google using WebView and an Options Menu.

## Concepts Used
- WebView
- WebViewClient
- Options Menu
- Toolbar
- Toast
- XML Layout
- Kotlin

## Procedure
1. Create an Android project using Empty Views Activity.
2. Design the layout using XML with Toolbar and WebView.
3. Add Internet permission.
4. Create `main_menu.xml` with menu options.
5. Initialize WebView in `MainActivity.kt`.
6. Load the JAIN University website.
7. Implement menu options for JAIN Website, Google, About and Exit.
8. Run and test the application.

## Project Structure

```text
WebViewMenuApp/
├── app/
│   └── src/main/
│       ├── java/com/example/webviewmenuapp/
│       │   └── MainActivity.kt
│       ├── res/
│       │   ├── layout/
│       │   │   └── activity_main.xml
│       │   ├── menu/
│       │   │   └── main_menu.xml
│       │   ├── drawable/
│       │   ├── mipmap/
│       │   ├── values/
│       │   └── xml/
│       └── AndroidManifest.xml
├── Screenshots/
│   ├── 01_Android_Studio_MainActivity.png
│   ├── 02_JAIN_University_WebView.png
│   ├── 03_Options_Menu.png
│   └── 04_Google_WebView.png
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
└── README.md
