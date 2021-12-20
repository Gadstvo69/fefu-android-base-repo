package ru.fefu.activitytracker.activitytracking.train

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityTrainBinding

class TrainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_train)

        binding = ActivityTrainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.train_info, NewTrainFragment.newInstance(), NewTrainFragment.TAG)
                commit()
            }
        }

        val toolbar = binding.activityMyDetailsToolbar

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}