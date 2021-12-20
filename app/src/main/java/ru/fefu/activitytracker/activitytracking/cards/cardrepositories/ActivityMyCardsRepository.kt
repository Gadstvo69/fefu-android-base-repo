package ru.fefu.activitytracker.activitytracking

class ActivityMyCardsRepository {

    private val cardsList = listOf(
        ActivityPeriod(
            "Вчера"
        ),
        ActivityMyCard(
               "14.32 км",
                  "2 часа 46 минут",
              "Серфинг",
                  "14 часов назад"
        ),
        ActivityPeriod(
            "Май 2022 года"
        ),
        ActivityMyCard(
            "1000 м",
            "60 минут",
            "Велосипед",
            "29.05.2022"
        )
    )

    fun getActivityMyCards(): List<Card> = cardsList
}