package ru.fefu.activitytracker.activitytracking

class ActivityUsersCardsRepository {

    private val cardsList = listOf(
        ActivityPeriod(
            "Вчера"
        ),
        ActivityUsersCard(
            "14.32 км",
            "2 часа 46 минут",
            "Серфинг",
            "14 часов назад",
            "@van_darkholme"
        ),
        ActivityUsersCard(
            "228 м",
            "14 часов 48 минут",
            "Качели",
            "14 часов назад",
            "@techniquepasha"
        ),
        ActivityUsersCard(
            "10 км",
            "1 час 10 минут",
            "Езда на кадилак",
            "14 часов назад",
            "@morgen_shtern"
        )
    )

    fun getActivityUsersCards(): List<Card> = cardsList
}