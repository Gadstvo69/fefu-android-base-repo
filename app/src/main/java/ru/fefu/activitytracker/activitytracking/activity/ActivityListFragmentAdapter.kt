package ru.fefu.activitytracker.activitytracking.activity

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ActivityListFragmentAdapter(fragment: ActivityListFragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        if (position == 0) ActivityMyFragment.newInstance()
        else ActivityUsersFragment.newInstance()
}