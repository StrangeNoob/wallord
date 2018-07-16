package com.firelord.wallord

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import com.firelord.wallord.fragments.AllPhotosFragment
import com.firelord.wallord.fragments.HomeFragment
import com.firelord.wallord.fragments.SupportFragment
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color


class MainActivity : AppCompatActivity() {

    private lateinit var navigationAdapter: AHBottomNavigationAdapter
    private var fragment:Fragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabColors = applicationContext.resources.getIntArray(R.array.tab_colors)
        navigationAdapter = AHBottomNavigationAdapter(this,R.menu.navigation)
        navigationAdapter.setupWithBottomNavigation(bottom_navigation, tabColors)

        // Change colors
        bottom_navigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        bottom_navigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottom_navigation.setInactiveColor(Color.parseColor("#747474"));

        // Force to tint the drawable (useful for font with icon for example)
        bottom_navigation.setForceTint(true);

        // Display color under navigation bar (API 21+)
        bottom_navigation.setTranslucentNavigationEnabled(true);

        // Use colored navigation with circle reveal effect
        bottom_navigation.setColored(true);

        bottom_navigation.setOnTabSelectedListener({ position, wasSelected ->
            when(position){
                0 -> fragment = HomeFragment()
                1 -> fragment = AllPhotosFragment()
                2 -> fragment = SupportFragment()
            }

            gotoFragment(fragment)
            true
        })

        if (savedInstanceState == null) {

            gotoFragment(fragment) // On activity creation load first tab
        }

    }

    private fun gotoFragment(fragment: Fragment){
        val ft = fragmentManager.beginTransaction()
        ft.replace(R.id.fragment_frame, fragment)
        ft.commit()
    }
}
