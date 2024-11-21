package com.example.myapplication

import android.app.Application
import com.example.myapplication.broadcastReceivers.BroadCastReceiverActivity
import com.example.myapplication.contentProviders.MyContentProvider
import com.example.myapplication.coroutines.view.CoroutineActivity
import com.example.myapplication.designpatterns.creational.factory.factory.VehicleFactory
import com.example.myapplication.flow.FlowActivity
import com.example.myapplication.fragments.ActivityMainFrag
import com.example.myapplication.fragments.FirstFragment
import com.example.myapplication.intent.ImplicitIntentActivity
import com.example.myapplication.intent.IntentActivity
import com.example.myapplication.java.Equals
import com.example.myapplication.java.FinalClass
import com.example.myapplication.java.PassByValue
import com.example.myapplication.kotlin.KotlinLearn
import com.example.myapplication.kotlin.MyResult
import com.example.myapplication.kotlin.ScopeFunctions
import com.example.myapplication.kotlin.SolidPrinciples
import com.example.myapplication.lazy.lazyClass
import com.example.myapplication.mvvm.view.MainActivity
import com.example.myapplication.mvvmlivedata.view.vm.CustomLiveData
import com.example.myapplication.mvvmlivedata.view.vm.SingleLiveEvent
import com.example.myapplication.threading.Exceutors
import com.example.myapplication.view.CustomView

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
     * 57. b. iOS compilation process
     * 58. Compose vs Viewbinding
     * 59. Compose state
     * 60. Why are we not shipping machine code in android like we do in iOS and what is the advantage of this?
     * 61. Why cant we write entire code in cpp in android. why java is introduced
     * 62. Compose lazy column vs Recycler view
     * 63. Android API list
     * 64. minSDK vs targetSDK vs compileSDK
     * 65. Android Performance
     * 66. Location Mechanisms
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
     * 11. volatile vs atomic vs Synchronization
     * 12. Executors
     * 13. equals vs ==
     * 14. SOLID Principles
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
     * 13. setValue vs postValue in liveData - https://stackoverflow.com/questions/51299641/difference-of-setvalue-postvalue-in-mutablelivedata
     * 14. Class vs object vs companion object vs data class
     *
     * Design Patterns
     * 1. What I know
     *
     * SQL Joins
     * Inner Join, Left Join, Right Join, Full Outer Join, Self Join
     */


    /**
     *
     * 1. inline functions / cross line / reified
     * 2. Room Database
     * 3. How to store keys securely in android
     * 4. Flow - state vs shared
     * Recycler view, object vs class, adyen formula - how they set to my work exp, example for each formula
     * Room Database
     *
     * Room Database
     * Dynamic Programming solution
     * Coroutines
     * Flows - Shared vs State
     * Projects - Zeotap SDK
     * Adyen file
     * This file
     * Kotlin Multiplatform
     */

    /**
     * 0. Context
     *
     *                                        Object
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
     * 8. Livedata -> SingleLiveEventData
     *
     */

    //goto
    val singleLiveEvent = SingleLiveEvent<Int>()

    /**
     * 9. Write Custom Live Data class
     *
     */

    //goto
    val customLiveData = CustomLiveData<Int>()

    /**
     * 10. Coroutines - Dispatchers, async and launch builders
     *
     */

    //goto
    val coroutines = CoroutineActivity()

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
     * 2. Create a New Thread - depending on the configuration and settings, the coroutine dispatcher may dynamically create a new thread to handle the new coroutine. Depending on max limit
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
     * 13. If all IO dispatchers are full/ busy in doing tasks, and new IO dispatcher coroutine is launched, what will happen
     * check above 12
     */

    /**
     * 14. Will threads in IO and Default exchange? If one set is full, will other threads be used for other operation?
     * No. check 12
     *
     */

    /**
     * 15. How to send data securely in API
     * check 37
     */

    /**
     * 16. Flows - Hot flow vs Cold flow.
     *
     */
    //goto
    val flow = FlowActivity()

    /**
     * 17. Practical applications of flow.
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
    //goto

    val customView = CustomView(Application().applicationContext)

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
     * 27. How to secure secrets in app
     * Android KeyStore
     *
     *
     * //  user data. API keys?
     * If attacker has root access, he can read anything in Android OS
     *
     * Keystore system -> prevents attacker to extract keys outside our device. they can still use within device
     * Solved by specific hardware -> TEE -> Trusted Execution Environment - Separate hardware part from Android OS
     * App requests, decrypt/encrypt using Android OS calling Keystore to save key
     *
     * TEE - hardware component - just generates and stores a key at our request.
     * This key is used for symmetric encryption.
     *
     * We request Keystore to provide this key and this key is used for symmetric encryption of our data
     * and stored in database at OS level. Even though attacker can see this data, he cant decrypt it.
     *
     * Static API keys may not be possible to secure using keystore as keystore key generation happens runtime
     *
     * Static API keys - to secure from remote repos -> local.properties file and gitignore
     * Obfuscate the code using proguard/R8 - hard to read
     * Use NDK - store in cpp and access them using JNI -> hard to decode
     *
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
     * 30. Images - Vectors - Bitmap - inflating images
     *
     */

    /**
     * 31. Working of image library
     *
     */

    /**
     * 32. View ViewGroup
     *
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
     *  34. WebSockets in android
     *
     */

    /**
     * 35. Design whatsapp
     *
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
     * 1. Send a public key from server to client - readable by anyone
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
     * 38. Store data securely in app.
     *
     */

    /**
     * 39. Broadcast receivers
     *
     * receiving
     * 1. Statically - declared in the manifest file and works even if the app is closed. Restricted. Only few like boot works
     * 2. Dynamically - receivers work only if the app is active or minimized.
     *
     */
    //goto
    val broadCastReceiverActivity = BroadCastReceiverActivity()

    /**
     * 40. Implicit vs Explicit intents
     *
     */

    /**
     * 41. How to avoid malicious broadcast receivers
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
     * 49. for loop 1000 events coming in sdk, how do you handle - scheduling events
     *
     */

    /**
     * 50. how are you reading the event count
     *
     */

    /**
     * 51. how to send events if app is closed and limit not reached
     * work manager
     */

    /**
     * 52. web view in android
     * WebView is a view that displays web pages inside the application. It is used to turn the application into a web application.
     */

    /**
     * 53. Intent flags
     */

    /**
     * 54. AIDL
     *  https://medium.com/@peternjuguna76/understanding-android-aidl-a-comprehensive-guide-b4d97253b169
     *  AIDL stands for Android Interface Definition Language. It is a language used by Android to define
     *  interfaces that can be used for inter-process communication (IPC). IPC is crucial for Android applications,
     *  especially when components such as services, activities, and content providers need to communicate with each other.
     */

    /**
     * 55. Internal working of viewModel
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
     *      Java source code                Kotlin source code      (.java/.kt)
     *              |                               |
     *       Java Compiler(javac)            Kotlin compiler
     *              |                               |
     *              |_______________________________|
     *                              |
     *                              |
     *                        Java ByteCode                         (.class)
     *                              |
     *                              |
     *                         DEX Compiler
     *                              |
     *                              |
     *                         Davlik Byte Code (APK)               (.dex) (apk contains .dex files, XML layouts, images)
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
     *
     * 57. b. iOS compilation process
     *
     *              Swift/obj-c
     *                  |
     *                  |
     *              Swiftc/clang (compiler)
     *                  |
     *                  |
     *                LLVMIR    (low level virtual machine intermediate representation)
     *                  |
     *                  |
     *                LLVM Compiler
     *                  |
     *                  |
     *               Machine code (ipa - iOS package appstore)
     *
     */

    /**
     * 58. Compose vs Viewbinding
     *
     * Compose advantages over traditional xml
     * 1. Less code - no separate xml
     * 2. Intuitive - that all you need to do is describe your UI. in Compose, state is explicit
     *                  and passed to the composable. That way there’s one single source of truth for the state, making it encapsulated and decoupled. Then, as app state changes, your UI automatically updates.
     * 3. Much easier to create custom components
     * 4. Maintains state -easy to update/single source of truth
     *
     */

    /**
     * 59. Compose state
     *
     */

    /**
     * 60. Why are we not shipping machine code in android like we do in iOS and what is the advantage of this?
     * Android runs on a wide variety of devices with different hardware architectures (ARM, ARM64, x86, x86_64, etc.). Shipping machine code would require providing multiple binaries for different architectures, increasing the complexity of app distribution.
     * By using DEX bytecode, developers can distribute a single APK that can run on any Android device, regardless of its hardware architecture. The ART or Dalvik runtime on the device handles the conversion of this bytecode into machine code specific to the device's architecture.
     * DEX bytecode is more compact than machine code, which helps in reducing the size of APK files. This is important for minimizing download times and storage usage on devices.
     */

    /**
     * 61. Why cant we write entire code in cpp in android. why java is introduced
     *
     * CPU architectures -
     * A CPU is like a translator between the software and the hardware of a device.
     * It can take high-level software instructions and translate them into native machine
     * language that a mobile phone can understand and use to perform specific operations.
     *
     * CPU architectures in Android
     *
     * 1. ARM - Advanced Risc machine
     *      a. ARMv7 - 32 bit
     *      b. ARMv8/AArch64- 64 bit
     *
     * 2. x86
     *
     * First Java is the language used in Android - hence all Apis/ SDKs are in Java
     *
     * Later cpp is introduced. Google later introduced the Android NDK to allow developers to
     * write parts of their applications in C or C++. The NDK provides tools and libraries to
     * integrate native code with the rest of the app.
     *
     * Advantages of using cpp
     * 1.The NDK was mainly intended for performance-critical applications, such as games or computationally
     * intensive tasks, where C or C++ could offer significant performance benefits over Java.
     *
     * 2. Cross-Platform Code: Apps that share code across multiple platforms (e.g., iOS, Android, Windows)
     * might use C++ for the shared codebase to avoid duplicating logic in different languages.
     *
     * Disadvantages (Why cant we write entire code in cpp in android?)
     * 1. Since Java first, major API/SDKs are in Java
     * 2. Development efficiency / ease of use of Java
     * 3. Automatic memory Management in Java, Manual in Cpp
     * 4. C++: C++ code is compiled directly into machine code specific to the target CPU architecture
     * (e.g., ARM, x86). This means that a binary compiled for one architecture (e.g., ARM) will not
     * run on another (e.g., x86) without recompilation.
     *
     *
     *
     *
     *
     *
     * why ios app size is bigger than android?
     *
     * iOS applications often include universal binaries, which contain executables for multiple CPU
     * architectures (e.g., ARM64, ARMv7). This ensures that the app can run on various devices, from
     * older iPhones to the latest models. The inclusion of multiple architectures increases the overall app size.
     *
     * Android applications can include multiple APKs (split APKs) for different architectures and
     * device configurations. Google Play automatically delivers the appropriate APK for the user's device,
     * reducing the size of the installed app.
     *
     *
     * iOS architecture
     *
     * macOS/simulator - x86(intel)/ARM64(m chip)
     * watchOS - ARM
     * tvOS - ARM
     */

    /**
     * 62. Compose lazy column vs Recycler view
     *
     */

    /**
     * 63. Android API list
     *
     * Android 15   35  (beta)
     * Android 14   34  (stable, deadline August 31, 2024 -> all apps must keep targetSDK as 34)
     * Android 13   33
     */

    /**
     * 64. minSDK vs targetSDK vs compileSDK
     * minSdkVersion <= targetSdkVersion <= compileSdkVersion
     *
     * The min sdk version is the minimum version of the Android operating system required to run your application.
     * The target sdk version is the version of Android that your app was created to run on.
     * The compile sdk version is the the version of Android that the build tools uses to compile and build the application in order to release, run, or debug.
     *
     *
     */

    /**
     * 65. Android Performance
     */

    /**
     * 66. Location Mechanisms
     *
     * ACCESS_FINE_LOCATION vs ACCESS_COARSE_LOCATION
     * FusedLocationProviderClient vs LocationManager api
     * Battery methods (doze mode, App Standby Buckets)
     *
     * Background location vs Foreground location (dont confuse with background service and foreground service)
     *
     * Background Location refers to an app's ability to access a user's location when the app is
     * not actively in use (when in recent apps). This capability can significantly impact user privacy,
     * which is why its use is heavily regulated.
     *
     * Foreground Location -> When the app is active
     *
     *
     * Before Android 10 (API level 29):
     * Apps could access location in the background relatively easily as long as they had the necessary
     * permissions (ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION).
     *
     * From Android 11 (API level 30):
     *
     * The process became stricter:
     * Apps must request foreground location permission (ACCESS_FINE_LOCATION or ACCESS_COARSE_LOCATION) first.
     * After that, they can request background location permission (ACCESS_BACKGROUND_LOCATION), but the
     * request must be clearly explained and justified to the user.
     * Apps need to follow a specific process to request background location access, often requiring the user
     * to navigate through system settings.
     *
     *
     * to get background location, use foreground service (can also use work manager) for transparency, battery efficiency
     *
     *
     * App in Foreground: Location can be accessed using the usual location APIs. (foreground location)
     * App in Background: Location can be accessed by using a foreground service with a visible notification. (background location)
     * App Killed: When the app is forcefully terminated by the user or the system, location access is not possible.
     * The foreground service will also be stopped.
     *
     *
     * Foreground location - No service required
     * Background location - use Foreground service/work manager. WorkManager is not suitable for real-time location tracking and is subject to execution delays and constraints.
     *
     *
     *
     *  ACCESS_FINE_LOCATION vs ACCESS_COARSE_LOCATION
     *
     *  ACCESS_COARSE_LOCATION - uses only Wi-Fi and cellular networks. - low accuracy - low battery consumption
     *  ACCESS_FINE_LOCATION - uses GPS, Wi-Fi, and cellular networks. - high accuracy - high battery consumption
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
     * 6. can we modify final array content
     * yes. content can be modified
     */

    /**
     * 7. volatile in java
     * see 11
     */

    /**
     * 8. extension functions in java/kotlin
     *
     */

    /**
     * 9. String pool
     *
     */

    /**
     * 10. Synchronization
     * see 11
     */

    /**
     * 11. volatile vs atomic vs Synchronization
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


    /**
     * 12. Executors
     */
    //goto
    val executors: Exceutors

    /**
     *  13. equals vs ==
     */
    //goto
    val equals = Equals()


    /**
     * 14. SOLID Principles
     */
    // goto
    val solidPrinciples = SolidPrinciples()

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
    //goto
    val scopeFunctions = ScopeFunctions()

    /**
     * 4. static in kotlin
     *
     */

    /**
     * 5. sealed class and enums
     * sealed class ->
     * defines a closed type hierarchy with a finite number of subclasses.
     * Sealed classes provide a powerful mechanism for creating exhaustive class hierarchies where all possible subclasses are known.
     */
    //goto
//    val result = MyResult()

    /**
     * 6. extension functions
     *
     */


    /**
     * 7. higher order functions
     *
     * A higher-order function is a function that takes functions as parameters, or returns a function.
     */

    /**
     * 8. list vs arraylist
     * list is like read-only arraylist in kotlin
     * mutableList is like arraylist which can do adding, modification
     */

    /**
     * 9. array in kotlin
     *
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
     * System design
     *
     * 1. Purpose - Business requirements
     *
     * 2. Input -
     *      1. get idea of feature
     *      2. sketches/screens if possible
     *      3. extra requirements and limitations
     *
     *      4.Maintainability — are we designing MVP or PoC or full scale system? How big is the team which will implement my design?
     *      5. Testability - how are we testing
     *      6. Scalability -  ability to reuse their code in different platforms - KMM?
     *      7. Performance - in house sdk/ third party
     *      8. Security - PII? Keystore
     *      9. Availability - Which OS, able to work offline, which languages
     *
     *
     * 3. API design
     *      1. /get
     *      2. /POST
     *      3. /PUT
     *      4. /DELETE
     *
     *
     *
     *
     */

    /**
     * Design Patterns
     *
     *
     * Creational design patterns provide various object creation mechanisms, which increase flexibility
     * and reuse of existing code.
     *
     * Structural design patterns explain how to assemble objects and classes into larger structures,
     * while keeping these structures flexible and efficient.
     *
     * Behavioral design patterns are concerned with algorithms and the assignment of responsibilities between objects.
     * how they interact
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
     * SQL Joins
     */

    /**
     * Customers Table                          Orders Table
     * id   cust_name   designation |           or_id   amount  cust_id
     * 1    abc         A           |           601     1000    1
     * 2    pqr         B           |           602     2000    4
     * 3    mno         C           |           603     2500    2
     *
     */

    /**
     * Inner Join
     * The common part between two tables
     *
     * SELECT Orders.or_id, Customers.cust_name
     * FROM ORDERS INNER JOIN CUSTOMERS ON Orders.cust_id == Customers.cust_name
     *
     * 1st circle -> ORDERS
     * 2nd circle -> CUSTOMERS
     *
     * Output
     * or_id    cust_name
     * 601      abc
     * 603      pqr
     */

    /**
     * Left Join
     *
     * When two tables are joined, the common Part and the remaining left table rows
     *
     *
     * SELECT Orders.or_id, Customers.cust_name
     * FROM ORDERS LEFT JOIN CUSTOMERS ON Orders.cust_id == Customers.cust_name
     *
     * Left circle -> ORDERS (1st mentioned)
     * Right circle -> CUSTOMERS
     *
     * Output
     * or_id    cust_name
     * 601      abc
     * 602      null
     * 603      pqr
     *
     */

    /**
     * Right Join
     *
     * When two tables are joined, the common Part and the remaining right table rows
     *
     *
     * SELECT Orders.or_id, Customers.cust_name
     * FROM ORDERS RIGHT JOIN CUSTOMERS ON Orders.cust_id == Customers.cust_name
     *
     * Left circle -> ORDERS (1st mentioned)
     * Right circle -> CUSTOMERS
     *
     * Output
     * or_id    cust_name
     * 601      abc
     * 603      pqr
     * null      mno
     *
     */

    /**
     * Full Outer Join
     *
     * When two tables are joined, Rows from both the table
     *
     * SELECT Orders.or_id, Customers.cust_name
     * FROM ORDERS FULL OUTER JOIN CUSTOMERS ON Orders.cust_id == Customers.cust_name
     *
     * Left circle -> ORDERS (1st mentioned)
     * Right circle -> CUSTOMERS
     *
     * Output
     * or_id    cust_name
     * 601      abc
     * 602      null
     * 603      pqr
     * null     mno
     */

    /**
     * SELF JOIN
     *
     * 1 table joining itself (Considered as 2)
     *
     * Example to find the employees who are managers
     * since managers are also employees, their ids are also in emp_id column
     *
     * Table
     * emp_id   name    manager_id      doj
     * 121      abc     321
     * 321      pqr     986
     * 421      mnp`    876
     *
     * SELECT DISTINCT E.name
     * FROM EMPLOYEE E INNER JOIN EMPLOYEE M ON E.emp_id == M.manager_id
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


    /**
     *
     * 1. It was kinda like low level system design, I was ask to create a list that wrap around, like if you scroll past last item you should see first item again, vice versa
     * 2. They asked me how would I design the stopwatch app, I struggled in two parts, the circle animation and showing the counter in the notification
     * 3. Few years back, they asked me what happens internally when you click an icon on the launcher. I was also asked to create a threading system. And then of course a bunch of their infamous algorithm riddle questions.
     * 4. They asked me to write an app that creates a simple timer that counts down and has the ability to pause and be reset. Easy in principle, but it becomes more difficult when you have to think about what to include and what to omit given that you only have a short time to do this in a Google doc with no tools or autocomplete. I only included an XML file and an Activity to get the job done but the ask was very open ended so it's possible that the interviewer would have wanted me to include more about what the project should look like and how the code should be structured
     * 5. I had two design questions. One was basically design Google analytics. The other was design the YouTube search API. Then there were two coding questions. One was substring matching. The expected answer was to use a trie. The other was write an android service that checks the user's connectivity every 15 minutes. And there was the usual behavioral interview: talk about a time you made a big difference on a team, talk about a time you screwed up, etc.
     * 6. They asked me to design keyboard word suggestion function. With swipe to type function
     * 7. Design google sheet(spreadsheet) app for mobile - half an hour. 15 minutes were given to Android basics. This round went good, I was able to answer most of questions and Interviewer was happy for design question also.
     *
     */

    /**
     * Recycler view
     *
     */


    /**
     * how much you value working as a team, and how well do you communicate
     *
     * Basic Project questions

     * Tell me about a time you faced ambiguity in the requirements of a project.
     * - Search widget - today/tomorrow or dates. scroll the calendar to check-in date or check-out date
     * - Conflict answer - cache in homepage - unsure about cache interval
     *
     * Tell me about a time where you had to get people on the same page about a decision.
     * - Regrading a task of collecting user phone numbers in sdk- e164 format - unsure about what exact formats to be collected
     * - need to collect hashed value from the client itself - hence cant process at backend
     * - web team suggested to roll out the feature with whatever requirements we have as of now (even though there is no end clarity from PM/legal team regarding format)
     * - since we need to maintain parity among all sources - web, mobile sdks (documentation) - I said we cant do this
     * - Explained how easy it is for web to roll out an update and getting adopted by clients
     * - But how difficult in mobile ecosystem to roll out update and reach end users
     * - made then understand and we deferred task until we got clear requirements from PM and legal team.
     *
     *
     * How would you deal with people who don't agree with the majority decision on a non-work related matter?
     *
     * Tell me about a time you had to deal with last minute changes in a project.
     * Design 2.0 answer - last minute changes of deadline and AB handling - extra resources - planned - lead the project
     *
     * How will you prioritize tasks when facing multiple critical deadline items?
     *
     *
     * How did your behavior positively impact team?
     *
     * A hypothetical question about large scale thinking.
     *
     * How would you deal with difficult co worker?
     * backend from customer service team - project ratings and review - missing deadlines
     * - development effect - delivery effect
     * - Made a plan with deadlines - submitted with both EMs
     * - Now accountable
     * - Delivered the feature
     *
     * 2 more customer centric questions
     *
     */

    /**
     * Oyo Projects
     * 1. Design 2.0
     * 2. Tech Stack Migration project - China
     * 3. UI related - Search Widget - Animation - difficult - not proud
     * 4. Regular features
     * 5. Engineering excellence tasks - increasing code coverage
     * 6. SDK integrations. 3ds2.0, Moengage,
     * 7. Rating and review - difficult coworker
     */

    /**
     * Zeotap Projects
     * 1. Created Architecture of SDK by collaborating with team members, seniors
     * 1. A. Used only native libraries
     * 2. Documentation by working with technical writers - for clients integration
     * 2. A. Written many tech docs as the product is new
     * 3. Worked with QA team by creating sample application and helping them out with the flow, test cases
     * 4. SDKs uploaded in GCP, Cocoapods, React Native
     * 5. SDK - Singleton, Builder, Facade
     * 6. Team work - Web, Mobile, GTM, Abode analytics tasks -
     *  exploring other stack like web js, GTM
     *  would be shared between two persons in optimized way to produce faster results and learning things
     */

    /**
     * Explain any one project -
     *
     * 1. Design 2.0 - initially normal project - big project - whole app - theme
     *                 change and new widgets/flows/ bottom sheets.
     *                 Deadline - IPO, Resource constrain - only 2 resources, Maintain both old and new design - AB flow
     *                 Escalated - Effort calculations - got new resources - QA , Integration testing
     *                 Completed in time
     *
     * 2. Migration project - China tech stack to global - due to cost constrains
     *                        Google sdks are not supported in Chinese app stores.
     *                        Detect all google related sdks, find alternatives for them which are supported in Chine
     *                        Make a new product flavor and write separate logic for this
     *                        24/7 support during launch and initial few weeks and rolled out app in major 8-10 app stores
     *
     */

    /**
     * Most challenging - say Design 2.0, Creating search widget,
     *
     *                    Engineering excellence tasks - effort estimation -
     *                    meetings with page/product owners (devs) understanding the flow.
     *                    assigned few tasks to them if they have more idea/recently worked
     *                    refactored multiple classes to increase code coverage
     *
     *                    Creating architecture of Zeotap SDK
     */

    /**
     * Bad feature - Search widget on home page - important as its in homepage
     *               Needed accurate Animation - calendar part is also included - had only <1 year of exp
     *               Pinged seniors quite a few times, crossed a dead line. but project is delivered.
     *               Learned how to give realistic ETAs. Learned more about animations. Bond between seniors increased
     */

    /**
     * Conflict with team member - Fortunately no major conflict - but one instance
     *                           - I wanted to keep cache interval for home page minimal as its P0 page and user need to see all updated widgets all time
     *                           - Wanted to keep cache interval max for other pages (unimportant)
     *                           - Manager said home page should have considerably max cache - as api load will be max and hence we can save a lot
     *                           - I raised updating homepage after post-booking if its done quickly - no update
     *                           - Had identifier if the flow of home page coming from post booking - override cache
     *                           - learnt about api loading, cost associated with that, rate limiters
     */

    /**
     * What are your positives?
     * Have positive opinion/ positive attitude. Eager to learn things. Collaborative towards team/team player.
     *
     * What are your negative?
     * Introvert person. Kind of sensitive. Public speaking
     */

    /**
     * Positivity - Problem - opportunity to learn
     *
     *
     * Interesting Path unique story - Civil to coding/software
     * helped interns to setup things - work flow - made them full time
     * fun part - had games like scribble, movie discussion north / south Indian - cultural exchange , knowledge
     */

    /**
     * Tell me an area where you think you can improve.
     *
     *
     * Tell me about a time when you received critical feedback from someone.
     *
     *
     * Walk us through a time when you helped a customer through a difficult process and what that looked like.
     *
     *
     * Give me an example of when you took a risk and it failed.
     *
     *
     * Tell me a time when you created an innovative product.
     *
     *
     * Tell me about a time when you observed two business opportunities to improve ROI, and how did you determine that they were connected.
     *
     *
     * How do you find the time to stay inspired, acquire new knowledge, innovate in your work?
     *
     *
     * Tell me about a time when you had to deal with a poor performer on your team.
     *
     *
     * Tell me about a time when you could have stopped working but persisted.
     *
     *
     * Tell me about a time when you proposed a new business.
     *
     *
     * Describe how you would handle a busy situation where three people are waiting for help from you.
     *
     *
     * Tell me about a time where you thought of a clever new way to save money for the company.
     *
     *
     * Tell me a time when you earned trust of a group.
     *
     *
     * Tell me about a time when you had to dive deep into the data and the results you achieved.
     *
     *
     * Tell me about the most difficult interaction you had at work.
     *
     *
     * Tell me about a time where you overcame an obstacle and delivered results.
     *
     *
     */

    /**
     * 1. How you work individually and on a team - Team people who helped my success
     * 2. How you help others - Helping interns, new joinees understanding them flow, giving KTs
     * 3. How you navigate ambiguity -
     * 4. How you push yourself to grow outside of your comfort zone
     * - Doing tasks in other tech stacks. Collaborating with team members to understand their work and contribute in them
     */

    /**
     * 1. Are there any sub goals for UC? i noticed native is another feature, anything like that more? like Zomato food ordering, grocery ordering, dining etc, any other sub goals/verticals
     * 2. Hierarchy level
     */


    /**
     * 1. Trees -> B-Tree
     * 2. Design Garbage Collector
     * 3. https://www.javatpoint.com/producer-consumer-problem-in-os
     * 4. Design a Filesystem File/Folder terminal design
     * 5. Aggressive cows DSA
     * 6. Binary search
     * 7. Snake and ladder lld
     *
     * 8. Topological Sort using DFS.
     * 9. https://leetcode.com/problems/course-schedule-ii/
     * 10. https://leetcode.com/problems/meeting-rooms-ii/ -> done
     * 11. https://leetcode.com/problems/insert-delete-getrandom-o1/description/
     * 12. https://leetcode.com/problems/longest-substring-without-repeating-characters/description/ -> done
     * 13. https://leetcode.com/problems/lru-cache/ -> done
     *
     *
     * 14. Prefix sum - https://leetcode.com/problems/subarray-sum-equals-k/solutions/102106/java-solution-presum-hashmap/
     *
     */
}