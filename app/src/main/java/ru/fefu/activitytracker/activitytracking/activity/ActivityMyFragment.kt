package ru.fefu.activitytracker.activitytracking.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.activitytracking.ActivityMyCardListAdapter
import ru.fefu.activitytracker.activitytracking.ActivityMyCardsRepository
import ru.fefu.activitytracker.databinding.FragmentActivityMyBinding

class ActivityMyFragment : Fragment (R.layout.fragment_activity_my) {

    private var _binding: FragmentActivityMyBinding? = null
    private val binding: FragmentActivityMyBinding
        get() = _binding!!

    private val activityMyCardsRepository = ActivityMyCardsRepository()

    private val activityMyCardListAdapter = ActivityMyCardListAdapter(activityMyCardsRepository.getActivityMyCards())


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let { FragmentActivityMyBinding.bind(it)}

        return view
    }

    companion object {

        fun newInstance() : ActivityMyFragment {
            val bundle = Bundle()
            val fragment = ActivityMyFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.activityMyCardsList) {
            adapter = activityMyCardListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        activityMyCardListAdapter.setItemClickListener {

            val fragmentManager = parentFragment?.parentFragmentManager

            val currentFragment = fragmentManager?.findFragmentByTag(ActivityListFragment.TAG)

            fragmentManager?.beginTransaction()?.apply {
                if (currentFragment != null) {
                    hide(currentFragment)
                }
                add(R.id.activity_info,
                    ActivityMyDetailsFragment.newInstance(),
                    ActivityMyDetailsFragment.TAG
                )
                addToBackStack(ActivityMyDetailsFragment.TAG)
                commit()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}