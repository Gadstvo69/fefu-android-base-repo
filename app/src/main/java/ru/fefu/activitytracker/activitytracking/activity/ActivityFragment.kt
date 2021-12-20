package ru.fefu.activitytracker.activitytracking.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentActivityBinding


class ActivityFragment : Fragment(R.layout.fragment_activity) {
    private var _binding: FragmentActivityBinding? = null
    private val binding: FragmentActivityBinding
        get() = _binding!!

    companion object {

        const val TAG = "activity_fragment"

        fun newInstance() : ActivityFragment {
            val bundle = Bundle()
            val fragment = ActivityFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let {FragmentActivityBinding.bind(it)}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction().apply {
                add(R.id.activity_info,
                    ActivityListFragment.newInstance(),
                    ActivityListFragment.TAG
                )
                commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
