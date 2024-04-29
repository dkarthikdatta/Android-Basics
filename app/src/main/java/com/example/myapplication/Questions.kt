package com.example.myapplication

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.example.myapplication.contentProviders.MyContentProvider
import com.example.myapplication.intent.ImplicitIntentActivity
import com.example.myapplication.mvvm.view.MainActivity
import javax.annotation.Nullable

fun main() {


    /**
     *
     * 0. Context
     *
     * A. Life Cycles
     * 1. What are activity life cycles
     * 2. What is activity life cycle for screen rotation
     * 3. What are fragment life cycles
     * 4. What are fragment life cycles when second fragment is add/replace/
     *
     * B. Fragments
     * 4.A. How do you start fragment from activity
     * 4.B. How do you pass data to fragment? Why only as argument bundle and retrieving in onCreate, why not as Constructor params?
     * 5. Fragment pop, commit, commitNow, commitStateLoss
     *
     * C. ViewModel
     * 6. ViewModel -> ViewModel Factory
     * 6.A. What is viewModel LifeCycle
     * 7. ViewModel lifecycle aware -> how does Same viewModel is retained after activity is rotated
     *
     * D. Live Data
     * 8. Livedata -> SingleLiveEventData
     * 9. Write Custom Live Data class
     *
     * E. Coroutines
     * 10. Coroutines - Dispatchers, async and launch builders
     * 11. Job vs Supervisor job
     * 12. How many threads in each Main, IO and Default dispatcher
     * 13. If all IO dispatchers are full/ busy in doing tasks,
     *     and new IO dispatcher coroutine is launched, what will happen
     * 14. Will threads in IO and Default exchange? If one set is full, will other threads be used for other operation?
     * 15. How to send data securely in API
     * 16. Flows - Hot flow vs Cold flow.
     * 17. Practical applications of flow.
     *
     * F. Content Providers
     * 18. Content providers in Android.
     * 19. Content Providers vs Implicit Intent (both are completely different)
     *
     * 20. View Lifecycle
     *
     * G. Services
     * 21. Services in Android
     * 22. Foreground vs Background Services
     * 23. Service vs task run in background thread
     * 24. Does service remain active if app is killed manually by user
     * 25. WorkManager / alarm manager vs Services
     * 26. C++ in Java
     * 27. How to secure secrets in app
     * 28. Parcelable vs Serializable -> why this is used. diff bw data passed bw activities and api
     * 29. Data class in kotlin
     * 30. Images - Vectors - Bitmap - inflating images
     * 31. Working of image library
     * 32. View Viewgroup
     *
     * https://medium.com/@munbonecci/how-to-launch-a-local-notification-in-android-afaa47eb1d1c
     * https://medium.com/@KaushalVasava/push-notification-in-android-how-its-work-2679d0bc0720
     * 33. Local vs Push Notifications
     *
     * https://medium.com/walmartglobaltech/exploring-websocket-and-its-brief-implementation-for-android-cc461597e1dc
     * 34. WebSockets in android
     *
     * 35. Design whatsapp
     *
     * Java
     * 1. Shallow copy vs Deep Copy
     * 2. Implement Hashmap
     */


    /**
     * 0. Context
     *
     *                                    Object
     *                                        |
     *           ----------------------------------------------------------------
     *           |                              |                               |
     *           |                              |                               |
     *           |                              V                               |
     *  Content Providers                   Context                         BroadCastReceivers
     *                                          |
     *                                          V
     *                                   ContextWrapper
     *                                          |
     *                                          V
     *          -----------------------------------------------------------------
     *          |                               |                               |
     *          V                               V                               V
     *  ContextThemeWrapper                 Service                         Application
     *          |
     *          V
     *       Activity
     *
     * Context -> acts like bridge bw my app and rest of the Android operating system
     * Resources, Databases, Preferences need context because they are android system components
     *
     * Just a middleman b/w our app and other apps/android components
     *
     * Activity and Application are subclasses of context
     *
     * ApplicationContext and ActivityContext -> lifecycle of app and activity respectively
     *
     * If we pass activity context to viewModel directly, if activity is destroyed, viewModel still lives (viewModelStore)
     * hence the memory leak is created.activity is not gc as context is still referenced in viewmodel
     *
     * applicationContext cant cause memory leaks as it lives on whole app
     *
     * Why not use applicationContext always?
     * activityContext is required to pass in permissions so that native android system can show permission dialog
     * here, activity context is requires cause it need to show on activity
     *
     */

    /**
     * 1. What are activity life cycles
     *
     *                      Activity Launched
     *                              |
     *                         OnCreate()
     *                              |
     *                         OnStart()<--------------------------------------------------------------------
     *                              |                                                                       |
     *                         OnResume()<-------------------------------------------                       |
     *                              |                                               ^                       |
     *                              |   Activity Running                            |   User returns        | User navigates
     *                              |                                               |   to Activity         | back to activity
     *                              |   Another Activity comes to Foreground        |                       |
     *                         OnPause()-------------------------------------------->                       |
     *                              |   The activity is no longer visible / navigate to other activity      |
     *                         OnStop()--------------------------------------------------------------------->
     *                              |   The Activity is finishing or
     *                              |   being destroyed by the system
     *                         OnDestroy()
     *                              |
     *                         Activity Shut Down
     */

    /**
     * 2. What is activity life cycle for screen rotation
     * onPause();
     * onSaveInstanceState();
     * onStop();
     * onDestroy();
     *
     * onCreate();
     * onStart();
     * onResume();
     */

    /**
     * 3. What are fragment life cycles
     *  onCreate(),
     *  onCreateView(),
     *  onViewCreated(),
     *  onViewStateRestored(),
     *  onStart(),
     *  onResume(),
     *  onPause(),
     *  onStop(),
     *  onSavedInstance(),
     *  onDestroyView(),
     *  onDestroy().
     */

    /**
     *  4. What are fragment life cycles when second fragment is add/replace/
     *  Go to ActivityMainFrag
     */

    /**
     *  4.A. How do you start fragment from activity
     *   static factory method
     *   Create a companion object of Fragment to accept data by constructors. Create a bundle of args,
     *   set args to fragment and return fragment
     *   Retrieve the args in onCreate of Fragment
     *
     *   Go to FirstFragment
     */

    /**
     * 4.B. How do you pass data to fragment? Why only as argument bundle and retreiving in onCreate, why not as Constructor params?
     *
     * Using constructor parameters to pass data to a Fragment is generally not recommended because
     * Android expects Fragments to have a default empty constructor. This is because the Android
     * system needs to be able to re-instantiate Fragments during configuration changes, such
     * as screen rotations, and it relies on the empty constructor to do so.
     *
     * During this recreation process, Android needs to re-instantiate fragments that were previously
     * added to the activity. To do this, Android relies on the default empty constructor of fragments.
     * This constructor is required because Android uses reflection to instantiate fragments, and it
     * expects a constructor without arguments.
     *
     * If your fragment has a constructor with parameters, Android won't be able to instantiate it
     * correctly during the recreation process, leading to runtime errors or crashes.
     */

    /**
     * 5. Fragment pop, commit, commitNow, commitStateLoss
     *
     */

    /**
     * 6. Viewmodel -> Viewmodel Factory
     * ViewModelFactory is used when we want to initalize viewModel with some parameters
     *
     * myViewModel = ViewModelProvider(this, MyViewModelFactory(applicationContext)).get(MyViewModel::class.java)
     */

    //goto
    val mainActivity = MainActivity()

    /** 6.A What is viewModel LifeCycle
     * ViewModel remains in memory until its ViewModelStoreOwner goes away permanently.
     */

    /**
     * 7 How does viewModel survives screen rotation/ config changes
     *
     * https://write.agrevolution.in/view-model-and-how-it-works-internally-88295e8598ee
     *
     * public ViewModelProvider(owner: ViewModelStoreOwner, factory: Factory) : this(
     *         owner.viewModelStore,
     *         factory)
     *
     * myViewModel = ViewModelProvider(this, MyViewModelFactory(applicationContext)).get(MyViewModel::class.java)
     *
     * ViewModelStoreOwner : it is an interface.It has just one method which returns the ViewModelStore.
     * generally ViewModelStoreOwner is Activity/Fragment (passing this)
     *
     * Activity and Fragment - parent classes in Android SDK implement the ViewModelStoreOwner interface. (ComponentActivity.java and Fragment.java )
     *
     * .get(MyViewModel::class.java) -> check if viewmodel instance in the viewmodel store first.If the viewmodel instance is there in the viewmodelstore then it simply returns that instance .If viewmodel instance is not there then it uses the factory to create the new instance and saves that instance in viewmodel store and then it return the viewmodel instance.
     *
     * It is ViewModelStore which stores the viewmodel and is retained when the rotation occurs and which returns the same viewmodel instance in the new activity instance.
     *
     * How does viewModelStore is retained in activity when it's destroyed in rotation process?
     *
     * ComponentActivity implements ViewModelStoreOwner. here  we can see that in the new activity object when viewmodel store is null then it first checks with the NonConfigurationInstance which returns the previous activity’s viewmodel store.
     *
     * So It is NonConfigurationInstance object which is passed from old destroyed activity to newly created activity when rotations happens.It contains all the non-configuration related information including viewmodel store which contains the viewmodel of old activity object.
     *
     */

    /**
     * 11. Job vs Supervisor job
     * https://medium.com/@android-world/kotlin-coroutine-job-and-supervisorjob-1b284a44d202
     * https://medium.com/@android-world/kotlin-coroutine-job-and-supervisorjob-d235eaaefd4e
     */

    /**
     * 12. How many threads in each Main, IO and Default dispatcher
     *
     *  Core - CPU core refers to a physical processing unit capable of executing instructions.
     *          Each core can handle its own set of instructions and tasks simultaneously.
     *
     *  Thread - Multiple threads can run on a single core. Thread is an independent sequence of
     *          execution within a process. Threads share the same memory space and resources within
     *          a process. Multiple threads can run concurrently on a single core through techniques
     *          like time-sharing or multithreading, where the CPU switches between threads rapidly to
     *          give the appearance of simultaneous execution.
     *
     *  Default vs IO Dispatcher - Work based
     *
     *  Default -> It is designed for CPU-bound tasks, such as computations or algorithms that do not involve I/O operations.
     *  IO -> It is optimized for I/O-bound tasks, such as network or disk I/O operations. It is suitable for
     *          operations that spend most of their time waiting for external systems to respond.
     *
     * Number of threads in Default and IO Dispatcher
     *
     * Default -> Number of threads = Number of cores (by default). But cant say each core will have each Default thread
     * IO -> Number of threads = More threads than the number of CPU cores. The exact number of threads available for Dispatchers.IO can vary based on the JVM implementation and runtime configuration.
     *
     * The way these threads are distributed across CPU cores can vary and is managed by the operating system's thread scheduler.
     *
     * --------------------------------------
     * Below is doubtful though
     * --------------------------------------
     *
     * lets say we have 64 threads for io and 4 threads for default in quad core environment.
     * I have dispatched so many io coroutines such that all 64 io threads are in working and busy in tasks.
     * If dispatch one more io coroutine, what will happen?
     *
     * either of 3 will happen
     * 1. Queue the Coroutine - queue the newly dispatched coroutine until a thread becomes available to execute it
     * 2. Create a New Thread - epending on the configuration and settings, the coroutine dispatcher may dynamically create a new thread to handle the new coroutine. Depending on max limit
     * 3. Reject the Coroutine - In some cases, if the dispatcher's configuration does not allow for dynamically creating new threads or if a maximum limit on the number of threads has been reached, the dispatcher may reject the new coroutine dispatch request
     *
     *
     * But the threads of Default cant be utilized by IO even though all IO are busy and Default are free
     *
     * the threads managed by Dispatchers.Default cannot be directly utilized for IO dispatch.
     * Each dispatcher in Kotlin coroutines manages its own thread pool, and coroutines dispatched to a particular dispatcher will be executed by threads from that dispatcher's pool.
     * Threads managed by Dispatchers.Default are intended for CPU-bound tasks and are not optimized for I/O operations. Attempting to use Default threads for IO dispatch would likely lead to inefficient I/O handling and could potentially cause blocking and performance issues.
     *
     *
     */


    /**
     * 18. Content providers in Android
     *
     * A content provider manages access to a central repository of data. A provider is part of an
     * Android application, which often provides its own UI for working with the data. However,
     * content providers are primarily used by other applications, which access the provider using a provider
     * client object.
     *
     *
     * Accessing an Existing Content Provider in Another Application: In this scenario, you want to
     * retrieve data from a Content Provider that is implemented by another application.
     * For example, you might want to access the contacts, calendar events, or media files stored by another
     * application on the device. To do this, you need to understand the structure of the Content Provider's
     * data and implement code in your own application to query, insert, update, or delete data through
     * that Content Provider.
     *
     * Creating a New Content Provider in Your Application: In this scenario, you want to expose data
     * stored within your application to other applications on the device. You create a new Content Provider
     * within your application and define the structure and access rules for the data it manages. Other
     * applications can then interact with your Content Provider to access or modify the data you've chosen
     * to share. This approach allows you to securely share data with other applications while maintaining
     * control over how it's accessed and manipulated.
     *
     * So, whether you're accessing data from an existing Content Provider in another application or
     * creating a new Content Provider in your own application, Content Providers serve as a standardized
     * mechanism for sharing and managing structured data across different applications in the Android ecosystem.
     *
     * Creating My own Content Provider:
     *
     */

    //goto
    val myContentProvider = MyContentProvider()

    /**
     * 19. Content Providers vs Implicit Intent (both are completely different)
     *
     * Both are DIFFERENT.
     * Content providers are used as shown above. Permission, access data from other app securely, query over that
     * If you are providing content, register <provider> in AndroidManifest.xml file.
     *
     * To share data on share button click, use Implicit Intent and Action_Send.
     * If you want to accept data from other applications, register Intent-File with what action you are supporting
     * and what media/mime type
     *
     */

    //goto
    val implicitIntentActivity = ImplicitIntentActivity()

    /**
     * 20. View Lifecycle
     * https://proandroiddev.com/the-life-cycle-of-a-view-in-android-6a2c4665b95e
     * https://medium.com/@sahoosunilkumar/understanding-view-lifecycle-in-android-e42890aab16
     *
     */

    /**
     * 21. Services in Android
     *
     * What is service?
     * An application component that can perform long-running operations in the background.
     *
     * Service runs on main thread of its hosting process by default.
     * The service does not create its own thread and does not run in a separate process unless
     * you specify otherwise.
     *
     * Service is not bound to the lifecycle of an activity. It is bound by application lifecycle.
     *
     * 1. Foreground Service
     * 2. Background Service
     * 3. Bound Service
     */

    /**
     * 22. Foreground service vs Background Service
     *
     * 1. Foreground service
     *
     * A foreground service performs some operation that is noticeable to the user.
     * For example, an audio app would use a foreground service to play an audio track.
     * Foreground services must display a Notification. Foreground services continue running even
     * when the user isn't interacting with the app. (app in bg)
     *
     * When you use a foreground service, you must display a notification so that users are actively
     * aware that the service is running. This notification cannot be dismissed unless the service is
     * either stopped or removed from the foreground.
     *
     * A foreground service is a service that should have the same priority as an active activity
     * and therefore should not be killed by the Android system, even if the system is low on memory.
     *
     * Background Service
     * A background service performs an operation that isn't directly noticed by the user.
     * For example, if an app used a service to compact its storage, that would usually be a
     * background service.
     *
     */

    /**
     * 23. Service vs task run in background thread normally
     *
     * Service
     * If we want to perform a task even when user is not interacting with App - Service
     * By default this runs in application main thread
     *
     * task run in background thread normally
     * To perform while the user is interacting with your application,
     * you should instead create a new thread in the context of another application component.
     *
     */

    /**
     * 24. Does service remain active if app is killed
     *
     * A. When the user is using the app:
     *
     * Background services: These services can run concurrently with the app's main UI thread.
     * They are typically used for tasks that are not directly related to the user interaction but
     * still need to be performed while the app is active. For example, a background service might
     * fetch data from the internet in response to a user action in the app.
     *
     * Foreground services: These services can also run while the user is actively using the app.
     * They are designed to perform tasks that are visible to the user or that the user expects to
     * continue running even when the app is not in the foreground. For example, a music player
     * app might use a foreground service to continue playing music while the user interacts with
     * other parts of the app.
     *
     * B. When the app is in recent apps (not actively used by the user):
     *
     * Background services: These services can continue running while the app is in the recent apps
     * list, but they may be subject to more aggressive resource constraints by the system compared
     * to when the app is in the foreground. The system may limit their resource usage to prioritize
     * active tasks.
     *
     * Foreground services: Foreground services can also continue running while the app is in the recent
     * apps list. They are given higher priority by the system and are less likely to be terminated due to
     * resource constraints.
     *
     *
     * C. When the app is killed by the system due to resource constraints:
     *
     * Background services: These services are more likely to be terminated by the system when the app
     * is killed due to resource constraints. The system prioritizes active components and may stop
     * background services to free up resources for foreground tasks.
     *
     * Foreground services: Foreground services are less likely to be terminated by the system compared to
     * background services. They are given higher priority and are considered important for the user
     * experience, so the system tries to keep them running as long as possible.
     *
     * D. When the app is killed by the user manually:
     * Background services: When the user manually kills the app, all components of the app, including
     * background services, are stopped. The system terminates the app process to reclaim resources and
     * ensure efficient operation.
     *
     * Foreground services: Similarly, when the user manually kills the app, foreground services associated
     * with that app are also stopped. Foreground services are bound to the lifecycle of their parent app,
     * so when the app process is terminated, foreground services are terminated as well.
     *
     *
     */

    /**
     * 25. WorkManager / alarm manager vs Services
     *
     * WorkManager
     * WorkManager is one of the Android Architecture Components and part of Android Jetpack,
     * a new and opinionated take on how to build modern Android applications.
     *
     * WorkManager is an Android library that runs deferrable background work when the work’s
     * constraints are satisfied.
     *
     * WorkManager runs task regardless of whether the application process is alive or not. Independent
     * of app lifecycle. Task is scheduled in system job scheduler.
     *
     *                  WorkManager
     *                      |
     *         yes          |API 23+    No
     *       --------------------------------
     *      |                               |
     *      |                               |
     *   Job Scheduler                  Alarm manager
     *
     * WorkManager vs Services
     * WorkManager is a modern, flexible, and reliable solution for executing background tasks in
     * Android apps, especially for tasks that need to survive across device reboots and app process restarts.
     * Services, on the other hand, are more low-level components that run within the app's process and are
     * suitable for long-running operations within the app's lifecycle.
     *
     */

    /**
     * 26. C++ in Java
     */


    /**
     * 28. Parcelable vs Serializable
     *
     * Serialization is the process of converting data used by an application to a format that can be
     * transferred over a network or stored in a database or a file
     * Converts state of an object into a byte stream. The byte stream is a platform independent,
     * so it's going to work on the JVM and other platforms.
     *
     * Serialization is marker interface - just implements Serializable is enough in to make class serialize
     * reflection is used and it is a slow process. This method creates a lot of temporary objects and causes quite a bit of garbage collection.
     *
     * Parcelable is an Android specific interface where you implement the serialization yourself  instead of using reflection to infer it.
     * Parcelable interface takes more time to implement - writing custom methods.
     */

    /**
     * 29. Data class in kotlin
     *
     * We often create classes to hold some data in it. In such classes, some standard functions are
     * often derivable from the data. In Kotlin, this type of class is known as data class and is marked as data.
     *
     * The compiler automatically derives the following functions :
     *
     * equals()
     * hashCode()
     * toString()
     * copy()
     *
     * com/example/myapplication/repo/MyMain.kt
     */


}
