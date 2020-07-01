package com.example.bottomnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.bottomnavigationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //bind the activity_main.xml to variable
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //instantiate the navController from NavHostFragment
        navController = this.findNavController(R.id.myNavHostFragment)

        //enable the back button in top actionbar
        NavigationUI.setupActionBarWithNavController(this, navController)

        //enable navigation component with bottom navigation view
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
    }

    //handle what to do when up is pressed (for example the back arrow in the action bar)
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}