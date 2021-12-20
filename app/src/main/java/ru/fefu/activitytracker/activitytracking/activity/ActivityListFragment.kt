package ru.fefu.activitytracker.activitytracking.activity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.activitytracking.train.TrainActivity
import ru.fefu.activitytracker.databinding.FragmentActivityListBinding

class ActivityListFragment : Fragment(R.layout.fragment_activity_list) {

    private var _binding: FragmentActivityListBinding? = null
    private val binding: FragmentActivityListBinding
        get() = _binding!!

    companion object {

        const val TAG = "activity_list_fragment"

        fun newInstance() : ActivityListFragment {
            val bundle = Bundle()
            val fragment = ActivityListFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let { FragmentActivityListBinding.bind(it)}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ActivityListFragmentAdapter(this)
        binding.viewPagerActivity.adapter = adapter
        TabLayoutMediator(
            binding.tabsActivity,
            binding.viewPagerActivity
        ) { tab, position ->
            tab.text = if (position==0) "Моя" else "Пользователей"
        }.attach()

        binding.newTrainButton.setOnClickListener{
            val intent = Intent(context, TrainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}