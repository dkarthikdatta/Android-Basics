package com.example.myapplication.architecture

class ArchitecturalPatterns {
    /**
     * MVC:
     *
     * Model - It is business logic and Data State. Getting and manipulating the data, communicates with the controller, interacts with the database, sometimes update the views.
     * View - What we see. User Interface consists of HTML/CSS/XML. It communicates with the controller and sometimes interacts with the model. It passed some dynamic views through the controller.
     * Controller - It is Activity/Fragment. It communicates with view and model. It takes the user input from view/REST services. Process request Get data from the model and passes to the view.
     *
     *
     *                                   Controller
     *                              (Activity/Fragment)
     *                       /   /                      \   \
     *                      /   /                        \   \
     *                     /   /                          \   \
     *                    /   /                            \   \
     *                   /   /                              \   \
     *                  /^  /                                \   \^
     *                 /   /                                  \   \
     *       Trigger  /   / update                             \   \notifies the
     *       request /   / the response                         \   \request
     *              /  v/                                        \v  \
     *              View <----------------------------------------Model
     *                          (Sometimes interact with view)
     *         (Rendering UI)
     *
     *
     * MVP:
     * It as Model-View-Presenter. For the phase of developing time or for the phase of developers it is vital to divide the architecture into layers. It breaks the dependency on what we have on view.
     *
     * Model - It is business logic and Data State. Getting and manipulating the data, communicates with the presenter, interacts with the database. It doesn't interact with the view.
     * View - Consists of UI, activity, and fragment. It interacts with the presenter.
     * Presenter - It presents the data from the model. Control all the behavior that want to display from the app. It drives the view. It tells view what to do. Any interaction between the model and the view is handled by the presenter. Saves the data back to the model.
     *
     *                                   Controller
     *                              (Activity/Fragment)
     *                       /^  /                      \   \^
     *                      /   /                        \   \
     *                     /   /                          \   \
     *                    /   /                            \   \
     *                   /   /                              \   \
     *                  /   /                                \   \
     *                 /   /                                  \   \
     *       Inform   /   / update                             \   \notifies the
     *   user action /   / ui                                   \   \ request
     *              /  v/                                        \v  \
     *              View                                           Model
     *
     *         (Rendering UI)
     *
     * Model - It has business logic, local and remote data source and repository.Repository: communicate with local or remote data sources according to the request from ViewModel.
     * View - Only user interaction i.e.XML, no business logic. Direct send user action to view model but does not directly get a response. To get a response view observes some data which ViewModel exposes.
     * ViewModel - Most of the user interface logic center it here. It is a bridge between a view and a
     * business logic. It does not have any clue which view has to use it. As it does not have a direct reference \
     * to the view. Thus, good in testing and has loose coupling. But still, it needs to update the UI this
     * interaction done by observables. When data changes observable notifies.
     *
     * View Observes ViewModel by observer pattern
     *
     */

}