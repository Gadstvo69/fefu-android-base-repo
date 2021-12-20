package ru.fefu.activitytracker.activitytracking.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentMyDetailsBinding

class ActivityMyDetailsFragment : Fragment(R.layout.fragment_my_details) {

    private var _binding: FragmentMyDetailsBinding? = null
    private val binding: FragmentMyDetailsBinding
        get() = _binding!!

    companion object {

        const val TAG = "activity_my_details_fragment"

        fun newInstance() : ActivityMyDetailsFragment {
            val bundle = Bundle()
            val fragment = ActivityMyDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let { FragmentMyDetailsBinding.bind(it)}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = binding.activityMyDetailsToolbar

        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}