package ru.fefu.activitytracker.activitytracking.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.activitytracking.profile.ProfileFragment
import ru.fefu.activitytracker.databinding.ActivityTrackingBinding

class ActivityTrackingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.activity_tracker, ActivityFragment.newInstance(), ActivityFragment.TAG)
                commit()
            }
        }

        binding.activityNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_profile -> {
                    val current_fragment = supportFragmentManager.findFragmentByTag(ActivityFragment.TAG)
                    val switched_fragment = supportFragmentManager.findFragmentByTag(ProfileFragment.TAG)
                    setFragment(current_fragment, switched_fragment)
                    true
                }
                R.id.navigation_activity -> {
                    val current_fragment = supportFragmentManager.findFragmentByTag(ProfileFragment.TAG)
                    val switched_fragment = supportFragmentManager.findFragmentByTag(
                        ActivityFragment.TAG
                    )
                    setFragment(current_fragment, switched_fragment)
                    true
                }

                else -> false
            }
        }

    }

    fun setFragment(current_fragment: Fragment?, switched_fragment: Fragment?) {
        if (current_fragment != null) {
            supportFragmentManager.beginTransaction().apply {
                hide(current_fragment)
                commit()
            }
        }
        if (switched_fragment != null) {
            supportFragmentManager.beginTransaction().apply {
                show(switched_fragment)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.activity_tracker, ProfileFragment.newInstance(), ProfileFragment.TAG)
                commit()
            }
        }
    }
}