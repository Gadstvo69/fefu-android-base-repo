package ru.fefu.activitytracker.activitytracking.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding!!

    companion object {

        const val TAG = "profile_fragment"

        fun newInstance() : ProfileFragment {
            val bundle = Bundle()
            val fragment = ProfileFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let { FragmentProfileBinding.bind(it)}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction().apply {
                add(R.id.profile_info, ProfileInfoFragment.newInstance(), ProfileInfoFragment.TAG)
                commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}