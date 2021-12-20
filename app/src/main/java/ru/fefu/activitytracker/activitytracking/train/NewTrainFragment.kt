package ru.fefu.activitytracker.activitytracking.train

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.FragmentNewTrainBinding


class NewTrainFragment : Fragment(R.layout.fragment_new_train) {
    private var _binding: FragmentNewTrainBinding? = null
    private val binding: FragmentNewTrainBinding
        get() = _binding!!

    private val trainTypeCardsRepository = TrainTypeCardsRepository()

    private val newTrainFragmentAdapter = NewTrainFragmentAdapter(trainTypeCardsRepository.getTrainTypeCards())

    companion object {
        const val TAG = "change_train_fragment"

        fun newInstance(): NewTrainFragment {
            val bundle = Bundle()
            val fragment = NewTrainFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        _binding = view?.let { FragmentNewTrainBinding.bind(it)}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.trainTypesList) {
            adapter = newTrainFragmentAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.startTrainButton.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.train_info, ActiveTrainFragment.newInstance(), ActiveTrainFragment.TAG)
                commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}