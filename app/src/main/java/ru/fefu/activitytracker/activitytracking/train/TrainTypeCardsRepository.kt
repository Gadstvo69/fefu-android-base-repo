package ru.fefu.activitytracker.activitytracking.train

class TrainTypeCardsRepository {
    private val cardsList = listOf(
        TrainTypeCard(
            "Велосипед",
            true
        ),
        TrainTypeCard(
            "Бег",
            false
        ),
        TrainTypeCard(
            "Шаг",
            false
        )
    )

    fun getTrainTypeCards(): List<TrainTypeCard> = cardsList
}