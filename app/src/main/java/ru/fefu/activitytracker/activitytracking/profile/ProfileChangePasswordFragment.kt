package ru.fefu.activitytracker.activitytracking.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentProfileChangePasswordBinding


class ProfileChangePasswordFragment : Fragment(R.layout.fragment_profile_change_password) {
    private var _binding: FragmentProfileChangePasswordBinding? = null
    private val binding: FragmentProfileChangePasswordBinding
        get() = _binding!!

    companion object {
        const val TAG = "profile_change_password_fragment"

        fun newInstance(): ProfileChangePasswordFragment {
            val bundle = Bundle()
            val fragment = ProfileChangePasswordFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let { FragmentProfileChangePasswordBinding.bind(it)}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = binding.profileChangePasswordToolbar

        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}