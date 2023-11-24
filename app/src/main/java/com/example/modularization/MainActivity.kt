package com.example.modularization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.example.common.NavArguments
import com.example.common.NavRoutes
import com.example.loginUi.LoginFragment
import com.example.userUi.UserFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment).navController
//        val navControllerAnotherWay = findNavController(this, R.id.nav_host)

        navController.graph = navController.createGraph(
            startDestination = NavRoutes.loginUi
        ) {

            fragment<LoginFragment>(NavRoutes.loginUi) {
                label = "login fragment"
            }

            fragment<UserFragment>("${NavRoutes.userUi}/{${NavArguments.userArgs}}") {
                label = "user fragment"
                argument(NavArguments.userArgs) {
                    type = NavType.StringType
                    defaultValue = "fuckkkkkkkkkk"
                    nullable = true
                }
            }
        }
    }

}