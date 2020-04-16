package com.learn.learnmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.learn.learnmvvm.network.HttpClient
import com.learn.learnmvvm.network.dataSource.WeatherNetworkDataSourceImpl
import com.learn.learnmvvm.network.interceptor.ConnectivityInterceptorImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

        bottom_nav.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this,navController)

        val request = HttpClient(ConnectivityInterceptorImpl(this))
        val weatherNetworkDataSourceImpl = WeatherNetworkDataSourceImpl(request)

        weatherNetworkDataSourceImpl.downloadCurrentWeather.observe(this, Observer {
            datacuaca.text = it.toString()
        })

        GlobalScope.launch(Dispatchers.Main){
            weatherNetworkDataSourceImpl.fetchCurrentWeather("dander")
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }
}
