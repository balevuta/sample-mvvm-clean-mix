# Events application example with Android Architecture components and Clean Architecture

Events app that shows how to architect an android app in a clean architecture with kotlin
coroutines. It simply shows a list of events that is fetched from an open API

## Technical

* [MVVM](https://developer.android.com/jetpack/guide)
* [Clean Architecture](https://github.com/android10/Android-CleanArchitecture)
* [Dependency Injection](https://en.wikipedia.org/wiki/Dependency_injection)

## Libraries

### Android Jetpack

* [ViewBinding](https://developer.android.com/topic/libraries/view-binding) A feature that allows
  you to more easily write code that interacts with views..

* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) Build data objects
  that notify views when the underlying database changes.

* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) Store UI-related
  data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal
  execution.


### HTTP

* [Retrofit2](https://github.com/square/retrofit) Type-safe HTTP client for Android and Java by
  Square, Inc.

* [OkHttp](https://github.com/square/okhttp) An HTTP+HTTP/2 client for Android and Java
  applications.

* [Moshi](https://github.com/square/moshi) Moshi is a modern JSON library for Android, Java and Kotlin. 
  It makes it easy to parse JSON into Java and Kotlin classes.

### Coroutines

* [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines) Coroutines is a rich library for
  coroutines developed by JetBrains. It contains a number of high-level coroutine-enabled primitives
  that this guide covers, including launch, async and others.

### DI

* [DaggerHilt](https://developer.android.com/training/dependency-injection/hilt-android) Hilt is a dependency injection library 
for Android that reduces the boilerplate of doing manual dependency injection in your project.

### Unit Test (template only)

* [Mockk](https://mockk.io/) MockK is a library for mocking written in Kotlin.As a native library,
  it helps our teams to write clean and concise code on testing Kotlin applications instead of using
  incommodious wrappers of Mockito or PowerMock

* [Junit](https://developer.android.com/training/testing/unit-testing/local-unit-tests) JUnit is a
  simple framework to write repeatable tests. It is an instance of the xUnit architecture for unit
  testing frameworks.

