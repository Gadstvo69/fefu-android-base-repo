package ru.fefu.activitytracker.activitytracking

data class ActivityUsersCard (
    val distance : String,
    val time : String,
    val sport_type : String,
    val date : String,
    val user_name : String
) : Card