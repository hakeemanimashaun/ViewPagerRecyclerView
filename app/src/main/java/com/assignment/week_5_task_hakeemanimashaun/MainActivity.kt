package com.assignment.week_5_task_hakeemanimashaun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import fragments.CamFragment
import fragments.HomeFragment
import fragments.ProfileFragment

class MainActivity : AppCompatActivity(), Communicator {
    private val home = HomeFragment()
    private val profile = ProfileFragment()
    private val cam = CamFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurrentFragment(home)

        //each bottom navigation is set to its preferred fragment.
        val homeBottomNavView = findViewById<BottomNavigationItemView>(R.id.home)
        homeBottomNavView.setOnClickListener{
            setCurrentFragment(home)
        }
        val peopleBottomNavView = findViewById<BottomNavigationItemView>(R.id.profile)
        peopleBottomNavView.setOnClickListener{
            setCurrentFragment(profile)
        }
        val camBottomNavView = findViewById<BottomNavigationItemView>(R.id.camera)
        camBottomNavView.setOnClickListener{
            setCurrentFragment(cam)
        }


    }
    // this function replaces the frame layout with selected fragment
    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_fragment, fragment)
            commit()
        }

    override fun passDataCom(name: String, email: String, username: String,
                             mobile: String, sex: String, password: String) {
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("email", email)
        bundle.putString("username", username)
        bundle.putString("mobile", mobile)
        bundle.putString("sex", sex)
        bundle.putString("password", password)

        val transaction = this.supportFragmentManager.beginTransaction()
        profile.arguments = bundle
        transaction.replace(R.id.container_fragment,profile)
        transaction.commit()
    }
}