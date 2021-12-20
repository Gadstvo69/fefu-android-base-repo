package ru.fefu.activitytracker.activitytracking.train

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentActiveTrainBinding

class ActiveTrainFragment : Fragment(R.layout.fragment_active_train) {
    private var _binding: FragmentActiveTrainBinding? = null
    private val binding: FragmentActiveTrainBinding
        get() = _binding!!

    companion object {
        const val TAG = "active_train_fragment"

        fun newInstance(): ActiveTrainFragment {
            val bundle = Bundle()
            val fragment = ActiveTrainFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let { FragmentActiveTrainBinding.bind(it)}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.stopTrainButton.setOnClickListener{
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.train_info, NewTrainFragment.newInstance(), NewTrainFragment.TAG)
                commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}