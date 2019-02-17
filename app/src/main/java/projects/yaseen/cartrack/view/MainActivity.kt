package projects.yaseen.cartrack.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import projects.yaseen.cartrack.R
import projects.yaseen.cartrack.model.MainActivityViewModel
import projects.yaseen.cartrack.room.model.RestUserModel


class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        if (isNetworkConnected(this)) {
            mainActivityViewModel.getCountriesFromAPIAndStore()

        } else {
            Toast.makeText(this, "No internet found. Showing cached list in the view", Toast.LENGTH_LONG).show()
        }

        mainActivityViewModel.getAllCountryList().observe(this, Observer<List<RestUserModel>> { countryList ->
            Log.e(MainActivity::class.java.simpleName, countryList.toString())
            setUpCountryRecyclerView(countryList!!)
        })
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    fun setUpCountryRecyclerView(users: List<RestUserModel>) {
        val userRecyclerViewAdapter = UsersRecyclerViewAdapter(this, users)
        recyclerView.adapter = userRecyclerViewAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.setHasFixedSize(true)
    }


}
