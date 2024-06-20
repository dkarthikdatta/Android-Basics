package com.example.myapplication


/**
 * package com.example.procore.model
 *
 * import android.os.Parcelable
 * import kotlinx.parcelize.Parcelize
 *
 * @Parcelize
 * data class User(
 *     val body: String,
 *     val id: Int,
 *     val title: String,
 *     val userId: Int
 * ): Parcelable
 */

/**
 * package com.example.procore.model
 *
 * class UserResponse : ArrayList<User>()
 */


/**
 * package com.example.procore.repository
 *
 * class MainRepository(private val retrofitService: RetrofitService) {
 *     suspend fun getHomePage() = retrofitService.getHomePage()
 * }
 */

/**
 * package com.example.procore.repository
 *
 * import com.example.procore.model.UserResponse
 * import retrofit2.Response
 * import retrofit2.Retrofit
 * import retrofit2.converter.gson.GsonConverterFactory
 * import retrofit2.create
 * import retrofit2.http.GET
 *
 * interface RetrofitService {
 *
 *     @GET("posts")
 *     suspend fun getHomePage(): Response<UserResponse>
 *
 *     companion object {
 *         private var retrofitService: RetrofitService? = null
 *
 *         fun getRetrofitService(): RetrofitService {
 *             if (retrofitService == null) {
 *                 val retrofit = Retrofit.Builder()
 *                     .baseUrl("https://jsonplaceholder.typicode.com/")
 *                     .addConverterFactory(GsonConverterFactory.create())
 *                     .build()
 *                 retrofitService = retrofit.create(RetrofitService::class.java)
 *             }
 *             return retrofitService!!
 *         }
 *     }
 *
 * }
 *
 */


/**
 * package com.example.procore.view
 *
 * import android.view.LayoutInflater
 * import android.view.View
 * import android.view.ViewGroup
 * import android.widget.TextView
 * import androidx.recyclerview.widget.DiffUtil
 * import androidx.recyclerview.widget.ListAdapter
 * import androidx.recyclerview.widget.RecyclerView.ViewHolder
 * import com.example.procore.R
 * import com.example.procore.model.User
 *
 *
 * class HomeAdapter(private val userItemClickLister: UserItemClickLister) :
 *     ListAdapter<User, HomeViewHolder>(HomeDiffUtil()) {
 *     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
 *         val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
 *         return HomeViewHolder(view)
 *     }
 *
 *     override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
 *         holder.onBind(getItem(position))
 *         holder.itemView.setOnClickListener {
 *             userItemClickLister.onUserClicked(getItem(position))
 *         }
 *     }
 * }
 *
 * class HomeViewHolder(view: View) : ViewHolder(view) {
 *     val title = view.findViewById<TextView>(R.id.title)
 *     val body = view.findViewById<TextView>(R.id.body)
 *     fun onBind(user: User) {
 *         title.text = user.title
 *         body.text = user.body
 *     }
 * }
 *
 * class HomeDiffUtil : DiffUtil.ItemCallback<User>() {
 *     override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
 *         return oldItem.id == newItem.id
 *     }
 *
 *     override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
 *         return oldItem == newItem
 *     }
 *
 * }
 *
 */

/**
 * package com.example.procore.view
 *
 * import android.content.Intent
 * import android.os.Bundle
 * import android.widget.Toast
 * import androidx.appcompat.app.AppCompatActivity
 * import androidx.lifecycle.Observer
 * import androidx.lifecycle.ViewModelProvider
 * import androidx.recyclerview.widget.LinearLayoutManager
 * import com.example.procore.databinding.ActivityMainBinding
 * import com.example.procore.model.User
 * import com.example.procore.repository.MainRepository
 * import com.example.procore.repository.RetrofitService
 * import com.example.procore.vm.HomeViewModel
 * import com.example.procore.vm.HomeViewModelFactory
 *
 * class MainActivity : AppCompatActivity() {
 *     private lateinit var binding: ActivityMainBinding
 *     private lateinit var viewModel: HomeViewModel
 *     private lateinit var mainRepository: MainRepository
 *
 *     override fun onCreate(savedInstanceState: Bundle?) {
 *         super.onCreate(savedInstanceState)
 *         binding = ActivityMainBinding.inflate(layoutInflater)
 *         setContentView(binding.root)
 *
 *         val userItemClickLister = object : UserItemClickLister {
 *             override fun onUserClicked(user: User) {
 *                 val intent = Intent(this@MainActivity, UserActivity::class.java)
 *                 intent.putExtra("user", user)
 *                 startActivity(intent)
 * //                Toast.makeText(this@MainActivity, user.title, Toast.LENGTH_LONG).show()
 *             }
 *         }
 *
 *         val adapter = HomeAdapter(userItemClickLister)
 *         binding.recyclerView.layoutManager = LinearLayoutManager(this)
 *         binding.recyclerView.adapter = adapter
 *
 *
 *         mainRepository = MainRepository(RetrofitService.getRetrofitService())
 *
 *         viewModel = ViewModelProvider(
 *             this,
 *             HomeViewModelFactory(mainRepository)
 *         ).get(HomeViewModel::class.java)
 *
 *         viewModel.responseData.observe(this, Observer {
 *             adapter.submitList(it)
 *         })
 *
 *         viewModel.errorData.observe(this, Observer {
 *             Toast.makeText(this, it, Toast.LENGTH_LONG).show()
 *         })
 *     }
 * }
 */


/**
 * package com.example.procore.view
 *
 * import androidx.appcompat.app.AppCompatActivity
 * import android.os.Bundle
 * import com.example.procore.R
 * import com.example.procore.databinding.ActivityUserBinding
 * import com.example.procore.databinding.UserItemBinding
 * import com.example.procore.model.User
 *
 * class UserActivity : AppCompatActivity() {
 *     private lateinit var binding: ActivityUserBinding
 *     override fun onCreate(savedInstanceState: Bundle?) {
 *         super.onCreate(savedInstanceState)
 *         binding = ActivityUserBinding.inflate(layoutInflater)
 *         setContentView(binding.root)
 *
 *         val extras: Bundle? = intent.extras
 *         val userData: User? = extras?.getParcelable("user")
 *
 *         userData?.let {
 *             binding.title.text = userData.title
 *             binding.body.text = userData.body
 *             binding.identifier.text = userData.id.toString()
 *             binding.userId.text = userData.userId.toString()
 *         }
 *     }
 * }
 */

/**
 * package com.example.procore.view
 *
 * import com.example.procore.model.User
 *
 * interface UserItemClickLister {
 *     fun onUserClicked(user: User)
 * }
 */


/**
 * package com.example.procore.vm
 *
 * import android.util.Log
 * import androidx.lifecycle.LiveData
 * import androidx.lifecycle.MutableLiveData
 * import androidx.lifecycle.ViewModel
 * import androidx.lifecycle.viewModelScope
 * import com.example.procore.model.User
 * import com.example.procore.model.UserResponse
 * import com.example.procore.repository.MainRepository
 * import kotlinx.coroutines.Dispatchers
 * import kotlinx.coroutines.launch
 * import kotlinx.coroutines.withContext
 *
 * class HomeViewModel(private val mainRepository: MainRepository) : ViewModel() {
 *
 *     private val response = MutableLiveData<UserResponse>()
 *     private val errorMessage = MutableLiveData<String>()
 *
 *     val responseData: LiveData<UserResponse>
 *         get() = response
 *
 *     val  errorData: LiveData<String>
 *         get() = errorMessage
 *
 *     init {
 *         viewModelScope.launch {
 *             val apiResponse = mainRepository.getHomePage()
 *             if (apiResponse.isSuccessful) {
 *                 withContext(Dispatchers.Main) {
 *                     response.postValue(apiResponse.body())
 *                 }
 *             } else {
 *                 withContext(Dispatchers.Main){
 *                     errorMessage.postValue(apiResponse.errorBody().toString())
 *                 }
 *             }
 *             Log.d("API_RESPONSE", apiResponse.message())
 *             Log.d("API_RESPONSE", apiResponse.body().toString())
 *             Log.d("API_RESPONSE", apiResponse.errorBody().toString())
 *             Log.d("API_RESPONSE", apiResponse.code().toString())
 *
 *         }
 *     }
 * }
 */

/**
 * package com.example.procore.vm
 *
 * import android.view.View
 * import androidx.lifecycle.ViewModel
 * import androidx.lifecycle.ViewModelProvider
 * import com.example.procore.repository.MainRepository
 *
 * class HomeViewModelFactory(private val mainRepository: MainRepository) : ViewModelProvider.Factory {
 *     override fun <T : ViewModel> create(modelClass: Class<T>): T {
 *         return HomeViewModel(mainRepository) as T
 *     }
 * }
 */

/**
 * <?xml version="1.0" encoding="utf-8"?>
 * <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *     xmlns:app="http://schemas.android.com/apk/res-auto"
 *     xmlns:tools="http://schemas.android.com/tools"
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent"
 *     tools:context=".view.MainActivity">
 *
 *     <androidx.recyclerview.widget.RecyclerView
 *         android:id="@+id/recycler_view"
 *         android:layout_width="match_parent"
 *         android:layout_height="0dp"
 *         app:layout_constraintBottom_toBottomOf="parent"
 *         app:layout_constraintEnd_toEndOf="parent"
 *         app:layout_constraintStart_toStartOf="parent"
 *         app:layout_constraintTop_toTopOf="parent" />
 *
 * </androidx.constraintlayout.widget.ConstraintLayout>
 */

/**
 * <?xml version="1.0" encoding="utf-8"?>
 * <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *     xmlns:app="http://schemas.android.com/apk/res-auto"
 *     xmlns:tools="http://schemas.android.com/tools"
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent"
 *     android:orientation="vertical"
 *     tools:context=".view.UserActivity">
 *
 *     <TextView
 *         android:id="@+id/identifier"
 *         android:layout_width="wrap_content"
 *         android:layout_height="wrap_content"
 *         android:layout_marginVertical="8dp"
 *         android:textSize="16sp" />
 *
 *     <TextView
 *         android:id="@+id/user_id"
 *         android:layout_width="wrap_content"
 *         android:layout_height="wrap_content"
 *         android:layout_marginVertical="8dp"
 *         android:textSize="16sp" />
 *
 *     <TextView
 *         android:id="@+id/title"
 *         android:textColor="#A52A2A"
 *         android:layout_width="wrap_content"
 *         android:layout_height="wrap_content"
 *         android:layout_marginVertical="8dp"
 *         android:textSize="28sp" />
 *
 *     <TextView
 *         android:id="@+id/body"
 *         android:layout_width="wrap_content"
 *         android:layout_height="wrap_content"
 *         android:layout_marginVertical="8dp"
 *         android:textSize="16sp" />
 *
 * </LinearLayout>
 */

/**
 * <?xml version="1.0" encoding="utf-8"?>
 * <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 *     android:layout_width="match_parent"
 *     android:layout_height="wrap_content"
 *     android:layout_marginVertical="16dp"
 *     android:orientation="vertical">
 *
 *     <TextView
 *         android:id="@+id/title"
 *         android:layout_width="wrap_content"
 *         android:layout_height="wrap_content"
 *         android:textColor="#0000FF"
 *         android:textSize="24sp" />
 *
 *     <TextView
 *         android:id="@+id/body"
 *         android:layout_width="wrap_content"
 *         android:layout_height="wrap_content"
 *         android:layout_marginTop="8dp"
 *         android:textColor="@color/black"
 *         android:textSize="16sp" />
 *
 *
 * </LinearLayout>
 */