package ar.com.premec.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import ar.com.premec.BuildConfig
import ar.com.premec.R
import ar.com.premec.databinding.ActivityMainBinding
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        setupAppCenter()
    }

    private fun setupAppCenter() {
        AppCenter.start(
            application, BuildConfig.APP_CENTER_KEY,
            Analytics::class.java, Crashes::class.java
        )
    }

    private fun setupNavigation() {
        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.splashFragment,
                R.id.loginFragment,
                R.id.formsListFragment
            )
            .build()
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}