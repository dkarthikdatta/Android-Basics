package com.example.myapplication.threading.handler;

public class Theory {

    /**
     * handler, looper, messaging queue vs SingleThreadExecutor
     *
     * handler, looper, messaging queue -> fundamentals to managing and processing messages and runnable tasks on a thread
     */

    /**
     * Handler, Looper, and MessageQueue
     *
     * Use Case: Primarily used in Android for managing tasks on the main thread or other UI-related threads,
     * but can be used on any thread to handle tasks sequentially.
     *
     * Handler: Posts tasks (Runnables) and messages (Messages) to the associated thread's message queue.
     * Looper: Runs a message loop for a thread. It retrieves messages and tasks from the message queue and
     * dispatches them.
     * MessageQueue: Holds the list of messages and tasks to be processed by the Looper.
     *
     * Typical Scenario:
     * UI Thread: The main thread in Android has a Looper by default. Handlers are used to post tasks to be executed on the main thread, like updating the UI.
     * Background Threads: Can create custom threads with their own Looper and MessageQueue to process tasks in the background without blocking the main thread.
     *
     *
     * SingleThreadExecutor
     * Use Case: Part of Java's concurrency framework, used for managing tasks in a single-threaded environment,
     * ensuring that tasks are executed sequentially.
     *
     * ExecutorService: Interface that provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks.
     * SingleThreadExecutor: A factory method in Executors that returns an executor service with a single worker thread.
     * Typical Scenario:
     *
     * Used for tasks that need to be executed sequentially in a background thread, such as I/O operations, network requests, or any other background processing tasks.
     */


}
