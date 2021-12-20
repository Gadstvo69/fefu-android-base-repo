package ru.fefu.activitytracker.activitytracking.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.activitytracking.ActivityUsersCardListAdapter
import ru.fefu.activitytracker.activitytracking.ActivityUsersCardsRepository
import ru.fefu.activitytracker.databinding.FragmentActivityUsersBinding

class ActivityUsersFragment : Fragment(R.layout.fragment_activity_users) {

    private var _binding: FragmentActivityUsersBinding? = null
    private val binding: FragmentActivityUsersBinding
        get() = _binding!!

    private val activityUsersCardsRepository = ActivityUsersCardsRepository()

    private val activityUsersCardListAdapter = ActivityUsersCardListAdapter(activityUsersCardsRepository.getActivityUsersCards())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let { FragmentActivityUsersBinding.bind(it)}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.activityUsersCardsList) {
            adapter = activityUsersCardListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        activityUsersCardListAdapter.setItemClickListener {
            val fragmentManager = parentFragment?.parentFragmentManager

            val currentFragment = fragmentManager?.findFragmentByTag(ActivityListFragment.TAG)

            fragmentManager?.beginTransaction()?.apply {
                if (currentFragment != null) {
                    hide(currentFragment)
                }
                add(R.id.activity_info, ActivityUsersDetailsFragment.newInstance(),
                    ActivityUsersDetailsFragment.TAG
                )
                addToBackStack(ActivityUsersDetailsFragment.TAG)
                commit()
            }
        }
    }

    companion object {

        fun newInstance() : ActivityUsersFragment {
            val bundle = Bundle()
            val fragment = ActivityUsersFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}