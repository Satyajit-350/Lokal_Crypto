# CryptoCompose
A simple Application built with Jetpack Compose to display the Crypto Currency Exchange Rates. This app follows a clean architecture design, making it robust and maintainable. It seamlessly integrates modern technologies like Paging3 and Room DB to efficiently handle data, while adhering to the MVVM (Model-View-ViewModel) pattern for structured and scalable code. The data is refreshed in every 3 minutes.
Api used from CoinLayer. 
- The crypto item shows a graph📈📉(build with canvas and compose) which is randomly generated with dummy data as the api does not provides any data for it.
## Techs Used 💻
- 100% [Kotlin](https://kotlinlang.org/) based
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - modern toolkit for building native Android UI.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Flow](https://developer.android.com/kotlin/flow)
- [Dagger-Hilt](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency injection into an Android application.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that is lifecycle aware (didn't destroyed on UI changes).
- [Android Architecture Components](https://developer.android.com/topic/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - MVVM Architecture (Declarative View - ViewModel - Model)
  - Repository pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
- [Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - load and display pages of data from a larger dataset from local storage or over a network
  
 ## Application Install
You can Install and test the app from below 👇

[![CryptoCompose](https://img.shields.io/badge/CryptoCompose-APK-silver.svg?style=for-the-badge&logo=android)](https://github.com/Satyajit-350/Lokal_Crypto/releases/tag/1.0.0)

## Build and Run Instructions

1. Clone the repository to your local machine using the following command:
```XML

git clone git@github.com:Satyajit-350/Lokal_Crypto.git

```
2. Open the project in Android Studio.

3. Add the API KEY in project local.properties file
```XML

API KEY = YOUR API KEY

```
4. Build the project 

5. Run the app on an Android emulator or a physical device by selecting the target device and clicking on the **Run**

## Screenshots
<h2 align="center">Light Mode</h2>

| ![](https://github.com/Satyajit-350/Lokal_Crypto/blob/master/screenshots/l1.png) | ![](https://github.com/Satyajit-350/Lokal_Crypto/blob/master/screenshots/l3.png) | ![](https://github.com/Satyajit-350/Lokal_Crypto/blob/master/screenshots/l2.png) |
|-------------------------------------------------------|-------------------------------------------------------|-------------------------------------------------------|

<h2 align="center">Dark Mode</h2>

| ![](https://github.com/Satyajit-350/Lokal_Crypto/blob/master/screenshots/d1.png) | ![](https://github.com/Satyajit-350/Lokal_Crypto/blob/master/screenshots/d3.png) | ![](https://github.com/Satyajit-350/Lokal_Crypto/blob/master/screenshots/d2.png) |
|-------------------------------------------------------|-------------------------------------------------------|-------------------------------------------------------| 
