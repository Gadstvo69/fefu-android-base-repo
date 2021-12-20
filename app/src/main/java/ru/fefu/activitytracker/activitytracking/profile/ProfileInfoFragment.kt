package ru.fefu.activitytracker.activitytracking.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentProfileInfoBinding

class ProfileInfoFragment : Fragment(R.layout.fragment_profile_info) {
    private var _binding: FragmentProfileInfoBinding? = null
    private val binding: FragmentProfileInfoBinding
        get() = _binding!!

    companion object {
        const val TAG = "profile_info_fragment"

        fun newInstance() : ProfileInfoFragment {
            val bundle = Bundle()
            val fragment = ProfileInfoFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let { FragmentProfileInfoBinding.bind(it)}

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentFragment = parentFragmentManager.findFragmentByTag(TAG)

        binding.changePasswordButton.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                if (currentFragment != null) {
                    hide(currentFragment)
                }
                add(
                    R.id.profile_info,
                    ProfileChangePasswordFragment.newInstance(),
                    ProfileChangePasswordFragment.TAG
                )
                addToBackStack(ProfileChangePasswordFragment.TAG)
                commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}