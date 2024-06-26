package com.example.myapplication

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.example.myapplication.contentProviders.MyContentProvider
import com.example.myapplication.designpatterns.creational.factory.factory.VehicleFactory
import com.example.myapplication.fragments.ActivityMainFrag
import com.example.myapplication.fragments.FirstFragment
import com.example.myapplication.intent.ImplicitIntentActivity
import com.example.myapplication.intent.IntentActivity
import com.example.myapplication.java.FinalClass
import com.example.myapplication.java.PassByValue
import com.example.myapplication.kotlin.KotlinLearn
import com.example.myapplication.lazy.lazyClass
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
     * //https://medium.com/@huseyinozkoc/android-services-tutorial-with-example-fa329e6a5b4b
     * G. Services
     * 21. Services in Android
     * 22. Foreground vs Background Services
     * 22.B Bound Services
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
     * 36. kts vs groovy in gradle
     *
     * H. Security
     * 37. Send data securely in api call - ssl pinning
     * 38. Store data securely in app.
     *
     * 39. Broadcast receivers
     * 40. Implicit vs Explicit intents
     *
     * 41. How to avoid malicious broadcast receivers
     * 42. Can we start activity of other app? (knows package name and activity name of other app)
     * 43. Intent filters
     *
     * 44. Intent Service
     * 45. Save state of activity
     * 46. onCreate() vs onRestoreInstanceState()
     * 47. Multiple process of single app
     * 48. Can you start activity from service
     * 49. for loop 1000 events coming in sdk, how do you handle - scheduling events
     * 50. how are you reading the event count
     * 51. how to send events if app is closed and limit not reached
     * 52. web view in android
     * 53. Intent flags
     *
     * https://medium.com/@peternjuguna76/understanding-android-aidl-a-comprehensive-guide-b4d97253b169
     * 54. AIDL
     * 55. Internal working of viewModel
     * 56. Activity launch modes
     * 57. Android APK compilation process
     * 58. Compose vs Viewbinding
     * 59. Compose state
     * 60. Why are we not shipping machine code in android like we do in iOS and what is the advantage of this?
     * 61. Why cant we write entire code in cpp in android. why java is introduced
     * 62. Compose lazy list vs Recycler view
     *
     * Java
     * 1. Shallow copy vs Deep Copy
     * 2. Implement Hashmap
     * 3. Pass by value vs Pass by reference
     * 4. Memory management in java
     * 5. final keyword in java
     * 6. can we modify final array content
     * 7. volatile in java
     * 8. extension functions in java/kotlin
     * 9. String pool
     * 10. Synchronization
     * 11.volatile vs atomic vs Synchronization
     *
     * Kotlin
     * 1. val vs const
     * 2. mutable vs immutable
     * 3. scope functions
     * 4. static in kotlin
     * 5. sealed class and enums
     * 6. extension functions
     * 7. higher order functions
     * 8. list vs arraylist
     * 9. array in kotlin
     * 10. lazy vs lateinit
     * 11. lazy threadSafe
     * 12. inline function
     *
     * Design Patterns
     * 1. What I know
     */


    /**
     * 0. Context
     *
     *                                      Object
     *                                          |
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
     * hence the memory leak is created.activity is not gc as context is still referenced in viewModel
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
     *                         OnStart()<-----------------------------------------------------------onRestart()
     *      onRestoreInstanceState  |                                                                       |
     *                         OnResume()<-------------------------------------------                       |
     *                              |                                               ^                       |
     *                              |   Activity Running                            |   User returns        | User navigates
     *                              |                                               |   to Activity         | back to activity
     *                              |   Another Activity comes to Foreground        |                       |
     *                         OnPause()-------------------------------------------->                       |
     *    onSaveInstanceState()     |   The activity is no longer visible / navigate to other activity      |
     *                         OnStop()--------------------------------------------------------------------->
     *                              |   The Activity is finishing or
     *                              |   being destroyed by the system
     *                         OnDestroy()
     *                              |
     *                         Activity Shut Down
     *
     *
     *  OnStart() -> when the activity becomes "visible" to the user, but the user cant "interact"
     *  onResume() -> user is able to interact
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
     * onRestoreInstanceState();
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
    //goto
    val activityMainFrag: ActivityMainFrag

    /**
     *  4.A. How do you start fragment from activity
     *   static factory method
     *   Create a companion object of Fragment to accept data by constructors. Create a bundle of args,
     *   set args to fragment and return fragment
     *   Retrieve the args in onCreate of Fragment
     *
     *   Go to FirstFragment
     */
    //goto
    val firstFragment: FirstFragment

    /**
     * 4.B. How do you pass data to fragment? Why only as argument bundle and retrieving in onCreate, why not as Constructor params?
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

    //goto
    val activityMainFrag1: ActivityMainFrag
    /**
     * 5. Fragment pop, commit, commitNow, commitStateLoss
     *
     */

    /**
     * 6. ViewModel -> ViewModel Factory
     *
     * ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
     *
     * ViewModelFactory is used when we want to initialize viewModel with some parameters
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
     * .get(MyViewModel::class.java) -> check if viewModel instance in the viewModel store first.If the viewModel
     * instance is there in the viewModelStore then it simply returns that instance .If viewModel instance is not there then it uses the factory to create the new instance and saves that instance in viewmodel store and then it return the viewmodel instance.
     *
     * It is ViewModelStore which stores the viewModel and is retained when the rotation occurs and which returns the same viewModel instance in the new activity instance.
     *
     * How does viewModelStore is retained in activity when it's destroyed in rotation process?
     *
     * ComponentActivity implements ViewModelStoreOwner. here  we can see that in the new activity object when viewModel store is null then it first checks with the NonConfigurationInstance which returns the previous activity’s viewmodel store.
     *
     * So It is NonConfigurationInstance object which is passed from old destroyed activity to newly created activity when rotations happens.It contains all the non-configuration related information including viewmodel store which contains the viewmodel of old activity object.
     *
     */

    /**
     * 11. Job vs Supervisor job
     * https://medium.com/@android-world/kotlin-coroutine-job-and-supervisorjob-1b284a44d202
     * https://medium.com/@android-world/kotlin-coroutine-job-and-supervisorjob-d235eaaefd4e
     *
     * normal job
     * if any one child coroutine cancels -> all siblings get cancelled
     * if parent job cancels -> all children get cancelled
     *
     * Supervisor job
     * if any one child coroutine cancels -> all other siblings does not get cancelled
     * if parent Supervisor job cancels -> all children get cancelled
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
     *
     * Threads managed by Dispatchers.Default are intended for CPU-bound tasks and are not optimized
     * for I/O operations. Attempting to use Default threads for IO dispatch would likely lead to inefficient
     * I/O handling and could potentially cause blocking and performance issues.
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
     *
     *
     *
     *                      onAttachToWindow()
     *                              |<-------------------
     *                           measure()              |
     *                              |                   |
     *                         onMeasure()              |
     *                              |                   |
     *                          layout()                |
     *                              |                   |
     *                          onLayout()          requestLayout()
     *       ^--------------------->|                   ^
     *       |                  dispatchToDraw()        |
     *       |                      |                   |
     *  invalidate()             draw()                 |
     *       |                      |                   |
     *       |                   onDraw()               |
     *       <----------------------|------------------->
     *                         visible to user
     *
     *
     *
     * onAttachToWindow()
     * onRestoreInstanceState()
     * measure()
     * onMeasure() --------- how big a view should be - setMeasuredDimension() to set width and height explicitly.
     * layout()
     * onLayout() ---------- where to position them on the screen
     * dispatchToDraw()
     * draw()
     * onDraw() ------------ Sizes and positions are calculated in previous steps, so the view can draw itself based on them. In onDraw(Canvas canvas) Canvas object generated (or updates) has a list of OpenGL-ES commands (displayList) to send to the GPU.
     * onSaveInstanceState()
     *
     * broadly, we can categorize into
     * Measure -> Layout-> Draw
     *
     *
     * inValidate() -------- if there is change in view appearance (text, color etc), force reDrawing of a particular view that we wish to show changes. The view will be redrawn but the size will not change.
     * requestLayout() ------ size change of the view - If something about your view changes that will affect the size, then you should call requestLayout(). This will trigger onMeasure and onLayout not only for this view but all the way up the line for the parent views.
     *
     */

    /**
     * 21. Services in Android
     *
     * https://medium.com/@Codeible/understanding-and-using-services-in-android-background-foreground-services-8130f6bbf2a5
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
     *
     * can start and stop service from any activity
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
     * 22. B Bound Services
     *
     * https://proandroiddev.com/bound-and-foreground-services-in-android-a-step-by-step-guide-5f8362f4ae20
     *
     * Use Case: A music player where a music is playing inside a service and an activity is requesting progress and handling controls by binding to the service.
     *
     * When we need some result from a service to a activity we bind the service.
     * This service serves as client-server architecture as this service can pass/emit the results to any number of clients
     *
     *
     * 1. When all the clients unbind from the service. The service will be stopped automatically. - background service case
     * 2. If a foreground service is started using ‘startService’ method. then it will run indefinitely in
     * the background until we call ‘stopService’ method even if all clients unbind from the service.
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
     * //check
     * Foreground services: When the user manually kills the app, foreground services are NOT killed as they
     * are displayed using notification, they stay alive indefinitely. Hence, we need to take care of
     * repeated launching of foreground service on opening the app again]
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

    /**
     * 33. Local vs Push Notifications
     *
     * Local notifications-
     *
     * Use WorkManager to schedule a notification
     * >= Android 13, ask permission for local notification
     * <13, android automatically asks permission
     *
     * Build a notification object from NotificationCompat.Builder() by setting
     * icon, content, text, priority, style etc;
     * setContentIntent - use pendingIntent to respond to a tap, to open an activity
     * in your app that corresponds to the notification.
     *
     * >= Android 8, notification channels are necessary
     * create notification channel using NotificationChannel() and Register the
     * channel with the system.
     * using NotificationManager
     *
     *
     * After building notification and notification channel, display notification in doWork in NotificationWorker class which extend Worker class
     *
     * schedule work in any activity by WorkManager.getInstance(this).enqueue(workRequest). create work request by setting time and any data that ca be used in displaying notification
     *
     *
     * Push Notifications-
     *
     * Android keeps one active connection to Google’s servers, but it does’nt use much power or data,
     * because no traffic is sent along it until something sends a Google Cloud Messaging (GCM) message
     * to an app on your phone. There’s only one connection on the phone, used by all apps: installing
     * a new app that uses GCM does’nt add any extra load.
     *
     * 1. The first step in GCM is that a third-party server (such as an email server) sends a request to Google’s GCM server.
     * 2. This GCM server then sends the message to your device, through that open connection.
     * 3. The Android system looks at the message to determine which app it’s for, and starts that app.
     * 4. The app must have registered with Android to use GCM, and it must have the relevant permission
     *
     * Firebase Cloud Messaging: (update to GCM - new version of GCM)
     * An operating system push notification service (OSPNS) is required to forward the push notification
     * from the server application to the client application. Firebase Cloud Messaging (FCM) is the OSPNS
     * for Android push notifications.
     *
     * When users opt-in for push notifications from your Android application, a device token is generated.
     * This is used to identify users in the application. When you want to push a new notification, you have
     * to pass the content and device token to FCM. FCM connects the right client application and push out the
     * notification
     *
     *
     * //todo: implement push notification service
     */

    /**
     * 36. dsl - Domain specific language
     *
     * earlier - groovy
     * now - kotlin dsl
     *
     * groovy dsl -
     * Groovy is dynamically typed, meaning that types are determined at runtime.
     * This can provide more flexibility
     *
     * Due to groovy is a dynamic language, that may lead to runtime errors that are
     * not caught until the build process.
     *
     * kotlin sdl
     *
     * Kotlin Domain Specific Language(DSL) is a special-purpose programming language embedded in Kotlin used to solve a particular problem domain.
     *
     * Kotlin is a statically-typed language, offering type safety at compile-time. This can help catch errors early in the development process and provides better tooling support in IDEs.
     *
     * Groovy
     * java {
     *     sourceCompatibility JavaVersion.VERSION_17
     *     targetCompatibility JavaVersion.VERSION_17
     * }
     *
     * Kotlin
     * java {
     *     sourceCompatibility = JavaVersion.VERSION_17
     *     targetCompatibility = JavaVersion.VERSION_17
     * }
     *
     */

    /**
     * 37. Send data securely in api call
     * http - hypertext transfer protocol
     * https - secure hypertext transfer protocol
     * ssl - Secure socket layer
     * tls - Transport Layer Security
     * tcp - Transmission Control Protocol
     *
     * SSL is an older technology that contains some security flaws.
     * Transport Layer Security (TLS) is the upgraded version of SSL that fixes existing SSL vulnerabilities.
     *
     * http - sends data in just plain text (actually converts to binary code and transfers in the form of signal)
     *
     * _____|----|_____
     *
     * this transferring data in the form of radio waves is easily detected by some instruments - readable by anyone
     *
     *
     * https - secure - by encrypting data
     *
     * symmetric encrypting:
     * a key is used in some encryption algorithm - that key is used to encrypt - same key is used to decrypt - symmetric encrypting
     *
     * just encrypting by some key at browser end sending that key to server is security breach as this key is also needs to be send to server else that data is useless to server as it cant decrypt
     *
     * Asymmetric encryption
     * 2 keys - public key and private key
     *
     * encryption can be done using public key
     * decryption can be done only using private key (may be private key contains information about public key, hence it is decrypting)
     *
     * one key for encryption and other for decryption (either public and private - vice versa)
     *
     * simple analysis - simple security -
     * 1. Send a public key from browser to client - readable by anyone
     * 2. Encrypt the data at client end using this public key
     * 3. While transferring data even though its read by attacker - they cant decrypt as private key is mandatory to decrypt which is not available to anyone except server
     * 4. On receiving this data at server, server can easily decrypt as it has private key
     *
     * Whats the issue in this simple Asymmetric encryption?
     *
     * 1. While sending public key from server to client, attacker overrides this public key with his own public key.
     * 2. since now the client has attackers public key, encryption is done using thus attacker public jey, on transferring encrypted data, its read by attacker and easily decode  using his private key
     * -------security breach--------
     *
     *
     * What is the ACTUAL SOLUTION - SSL Pinning
     * - We need to be sure that public key is coming from server only. - using certificate authority
     *
     * Trusted certificate authorities - limited - ony 12 companies in world
     *
     * CA - Trusted certificate authority company
     *
     * Now,
     *
     * CA - Private and Public key
     * Server - Private and Public key
     *
     * 1. client make connection to server (say hello)
     * 2. server calls CA to create a CA certificate
     *
     *      CA certificate - 3 parts
     *      1. Issued to server.com, where is server located, Issued from CA company - details
     *      2. server public key
     *      3. Encrypted server public key (formed by  server public key + CA private key) - called Signature
     *
     * 3. This certificate created is sent back to client from server
     * 4. Client validates this certificate at client end
     *
     *       Certification validation at client end
     *       1. call the CA company
     *       2. Remember, the Encrypted server public key(signature, 3rd part) can be decrypted only by CA public key (as its encrypted by CA private key)
     *       3. client call CA company with Encrypted server public key, uses CA public key to get decrypted server public key
     *       4. this decrypted server public key has to match server public key (2nd part of CA cert), then the CA certificate/ server public key is safe and valid one.
     * 5. After validation, if validates, data is encrypted using server public key and decrypted at server end using server private key,
     *
     * Question - What if attacker overrides CA certificate itself with his own server public and private keys?
     * I guess client know what domain to trust - stored in client code
     * since the domain name in attacker CA certificate doesn't matches with trusted domain names - it invalidates
     * CA will provide domain name only to legitimate owner - attacker cant get a certificate with any domain name - only his own domain name
     *
     */

    /**
     * 39. Broadcast receivers
     *
     * receiving
     * 1. Statically - declared in the manifest file and works even if the app is closed. Restricted. Only few like boot works
     * 2. Dynamically - receivers work only if the app is active or minimized.
     *
     *
     */


    /**
     * 42. Can we start activity of other app? (knows package name and activity name of other app)
     *
     * yes, we can start this by explicit intent as we know the target
     *
     */
    //goto
    val intentActivity: IntentActivity

    /**
     * 43. Intent filters
     *
     * An intent filter is an expression in an app's manifest file that specifies the type of intents that the
     * component would like to receive. ->  action, category, mimetype -> Main/Default/Send, Launcher, text/plain
     */

    /**
     * 44. Intent Service
     *
     * https://developer.android.com/reference/android/app/IntentService
     *
     * IntentService is subject to all the background execution limits imposed with Android 8.0 (API level 26).
     * Consider using WorkManager instead.
     */

    /**
     * 45. Save state of activity
     *
     *  save state, using  onSaveInstanceState method
     */

    /**
     * 46. onCreate() vs onRestoreInstanceState()
     *
     * Activity Lifecycle ->
     * onCreate, onStart, onRestoreInstanceState(), onResume(), onPause, onSaveInstanceState(), onStop(), onDestroy()
     *
     * Activity rotation lifecycle ->
     * onPause, onSaveInstanceState, onStop, onDestroy, onCreate, onStart, onRestoreInstanceState, onResume
     *
     * the save state bundle can be retrieved either on onCreate() or onRestoreInstanceState()
     *
     * onRestoreInstanceState() -> bw onStart and onResume
     * onSaveInstanceState() -> bw onPause and onStop
     *
     * onRestoreInstanceState guarantees you receive a non-null Bundle object also in the lifecycle of activity
     * it's called after onStart But onCreate: you should always check if the Bundle object is null or not to determine
     * the configuration change and as you know it's called before onStart So It's all up to you and depends on your needs.
     *
     */

    /**
     * 47.
     * https://stackoverflow.com/questions/31913968/how-to-start-two-processes-in-one-application
     * https://stackoverflow.com/questions/6567768/how-can-an-android-application-have-more-than-one-process/6567878#6567878
     * android:process=":remote"
     */

    /**
     * 48. Optimize recycler view
     * https://medium.com/@balsikandar/mastering-recyclerview-optimizations-in-android-f937919d4dd7
     *
     * 1. Recycler pool
     * RecyclerView Pool is a mechanism that helps manage the memory and performance of the views within
     * the RecyclerView. It’s essentially a cache that holds views that are currently not visible on the
     * screen but might be needed again in the near future.
     *
     *
     */


    /**
     * 56. Activity launch modes
     *
     * 1. standard
     * 2. single top
     * 3. single task
     * 4. single instance
     *
     * 1. standard
     * ABCD
     * launch D, -> ABCDD
     *
     * 2. Single Top
     *
     * C is single top
     *
     * ABCD
     * launch C -> ABCDC (new instance of C as it is not on top. onCreate())
     *
     * ABC
     * launch C -> ABC (new instance of C is NOT created as C is already on top. callback to onNewIntent() method)
     *
     *
     * 3. Single Task
     *
     * At a time only one instance of activity will exist.
     *
     * C is Single task
     *
     * ABCD
     * launch C -> ABC (new instance of C is NOT created as C is already on top. callback to onNewIntent() method)
     *                  (D is popped)
     *
     *
     * 4. Single Instance
     * It is similar to singleTask except that no other activities will be created in the same task.
     *
     * D is single instance
     *
     * ABC
     * launch D,
     *
     * Task 1 -> ABC
     * Task 2-> D
     *
     * launch E, F
     *
     * Task 1 -> ABCEF (since D is single instance)
     * Task 2-> D
     *
     * launch D (new instance of D is NOT created as D is already on top. callback to onNewIntent() method)
     *
     */

    /**
     * 57. Android APK compilation process
     *
     *      Java source code                Kotlin source code
     *              |                               |
     *       Java Compiler                    Kotlin compiler
     *              |                               |
     *              |_______________________________|
     *                              |
     *                              |
     *                        Java ByteCode
     *                              |
     *                              |
     *                         DEX Compiler
     *                              |
     *                              |
     *                         Davlik Byte Code (APK)
     *                              |
     *                              |   runs on
     *                           DVM/ART (our mobile)
     *                              |
     *                              |   compiles to (using JIT/AOT compiler)
     *                         Machine code (our mobile)
     *
     * DVM - Davlik Virtual Machine - uses Just In Time compiler to compile into machine code - compile everytime app opens
     * ART - Android Runtime - uses Ahead of Time compiler to compile into machine code - no need to compile everytime app opens
     *
     */

    /**
     * Java
     */

    /**
     * 1. Shallow copy vs Deep Copy
     *
     * https://www.geeksforgeeks.org/difference-between-shallow-and-deep-copy-of-a-class/
     */

    /**
     * 2. Implement Hashmap
     * https://www.youtube.com/watch?v=CojCE-ojdGY
     */
    /**
     * 3. Pass by value vs Pass by reference
     *
     * https://stackoverflow.com/a/7034719/14484903
     *
     * Java is always pass by value.
     * objects - In methods, the value of address of the object is passed, hence the original object changes
     * primitives - In methods
     */
    // Goto
    val passByValue: PassByValue = PassByValue()

    /**
     * 4. Memory management in java
     *
     * https://www.youtube.com/watch?v=4yKxJjYXZ0A
     *
     * all objects (class level variables) - heap
     * methods, local variables - stack
     * static variables and static methods - class loader memory
     *
     */


    /**
     * 5. final keyword in java
     *
     * Final variables:
     * When a variable is declared as final, its value cannot be changed once it has been initialized.
     * This is useful for declaring constants or other values that should not be modified.
     *
     * Final methods:
     * When a method is declared as final, it cannot be overridden by a subclass.
     * This is useful for methods that are part of a class’s public API and should not be modified by subclasses.
     *
     * Final classes: When a class is declared as final, it cannot be extended by a subclass.
     * This is useful for classes that are intended to be used as is and should not be modified or extended.
     *
     */
    //goto
    val finalClass: FinalClass

    /**
     * 11.volatile vs atomic vs Synchronization
     *
     * It's important to understand that there are two aspects to thread safety.
     * 1. execution control, and
     * 2. memory visibility
     *
     * synchronized can solve 1, 2
     * volatile can solve  only 2
     *
     * https://www.youtube.com/watch?v=WH5UvQJizH0
     * https://www.youtube.com/watch?v=71dgtPrbToE
     *
     * volatile -> only for fields (variable)
     * Synchronization -> only for methods, blocks
     *
     *
     * threads creates local copies of variables from the main memory and update them. hence diff threads diff value,
     * volatile restricts the copy -> hence access/read only from main. (useful when only one thread is updating the value)
     *
     * but write operation (execution control) cant be safe for volatile variables as even though same
     * value is read by diff threads, after performing operations simultaneously, value is different in different threads
     *
     * Synchronization - locking the method. only one thread execution at one point
     *
     */

    KotlinLearn()
    /**
     * Kotlin
     */

    /**
     * 1. val vs const
     *
     * https://stackoverflow.com/questions/37595936/what-is-the-difference-between-const-and-val
     *
     * const are compile time constants. Meaning that their value has to be assigned during compile time,
     * unlike val, where it can be done at runtime.
     *
     *
     * const val foo = complexFunctionCall()   //Not okay
     * val fooVal = complexFunctionCall()      //Okay
     *
     * const val bar = "Hello world"           //Also okay
     */

    /**
     * 2. mutable vs immutable
     * val - immutable
     * var - mutable
     *
     * https://stackoverflow.com/a/55058218/14484903
     *
     * val list:List<Int> = listOf(1,2,3,4) //[1,2,3,4] - immutable list. can't insert/delete/alter any element
     * val mutableList:MutableList = mutableListOf(1,2,3,4) - mutable list. can insert/delete/alter any element
     *
     * val list or var list is only validated for complete reassignment. like listOf(5,6,7,8)
     */

    /**
     * 3. scope functions
     *
     * https://umang91.medium.com/scope-functions-in-kotlin-f3c9f7c65749
     */
    /**
     * 7. higher order functions
     *
     * A higher-order function is a function that takes functions as parameters, or returns a function.
     */


    /**
     * 10. lazy vs lateinit
     *
     * https://medium.com/huawei-developers/kotlin-lateinit-vs-by-lazy-initialization-example-tutorial-c19d84216480
     *
     * lazy -> loads only when the object is getting used. to avoid creation of object if not using
     */

    /**
     * 11. lazy threadSafe
     */
    //goto
    val lazy = lazyClass()

    /**
     * Design Patterns
     */
    //goto
    val vehicleFactory: VehicleFactory
    /**
     * 1. What I know
     *
     * 1. Creational
     *
     * 1. Singleton
     * 2. Factory
     * 3. Abstract Factory
     * 4. Builder
     *
     * 2. Structural
     *
     * 1. Adapter
     * 2. Flyweight
     * 3. Facade
     *
     * 3. Behavioural
     *
     * 1. Observer
     * 2. Strategy
     *
     */


    /**
     * PNG -> Portable Network Graphics
     * Jpeg/Jpg -> Joint Photographic Experts Group
     * PDF -> Portable Document Format
     * GIF -> Graphics Interchange Format
     * SVG - Scalable Vector Graphic
     *
     * Jpeg -> high compression and less size
     * PNG -> less compression and more size
     *
     *
     * dpi - dots per inch - pixels per inch
     * dot = pixel - one physical dot
     *
     * base line density in android - 160 dpi (mdpi)
     *
     *          dpi         Scale factors
     * mdpi     160 dpi     1x
     * hdpi     240 dpi     1.5x
     * xhdpi    320 dpi     2x
     * xxhdpi   480 dpi     3x
     * xxxhdpi  640 dpi     4x
     *
     * px = dp * (dpi/160)
     *
     * high density mobile - more no of dots/pixel
     *
     * BitMap -> map of pixels - any image of format jpg or png
     *
     *  ex: png to bitmap conversion and inflating bitmap in imageview
     *   val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.car)
     *   binding.imageView.setImageBitmap(bitmap1)
     *
     * Image asset vs Vector asset(svg)
     *
     *  Image assets are raster images that are designed using a bitmap format
     * such as JPEG, PNG, and GIF. These are pixel-based graphics that are made
     * up of a grid of pixels. Image assets are great for displaying realistic
     * images or photographs in your app. However, when it comes to resizing, they
     * can lose quality and become pixelated.
     *
     * Vector assets are graphics that are created using mathematical equations to define
     * lines, curves, and shapes. Vector assets are resolution-independent and can be scaled
     * to any size without losing quality. They are great for displaying icons, logos, and
     * other graphics that need to be displayed in multiple sizes and resolutions.
     *
     */
}