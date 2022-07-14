# MovieDbApp

An Android app built with Kotlin that uses [TMDB API](https://developers.themoviedb.org/3/). It has been built following Clean Architecture Principle, Repository Pattern, MVVM Architecture.
I'm using this app to learn Jetpack Compose and basically every new technology that might pop up.


## Prerequisite.

Android Studio Minimum version: 2021.2.1

# Tech Stack.
This project uses some of the popular libraries, plugins and tools of the android ecosystem.


## Libraries.

- [Hilt](https://dagger.dev/hilt/) - Dependency Injection library.
- [Jetpack](https://developer.android.com/jetpack)
  
  -   [Jetpack Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
    
    - [Compose Navigation](https://developer.android.com/jetpack/compose/navigation) -Component that allows easier implementation of navigation from composables.


- [Retrofit](https://square.github.io/retrofit/) - Type-safe http client 
and supports coroutines out of the box.  

- [OkHttp-Logging-Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - Logs HTTP request and response data.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines.
- [Flow](https://developer.android.com/kotlin/flow) - Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously.
- [Square/Logcat](https://github.com/square/logcat) -Library for easier logging.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines,provides runBlocking coroutine builder used in tests.


