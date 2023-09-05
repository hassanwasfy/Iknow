package com.abaferas.ui.navigation

import com.abaferas.ui.R

sealed class IKnowDestination(
    val route: String,
    val isSelected: Int? = null,
    val isUnSelected: Int? = null
) {
    data object Splash : IKnowDestination("splash")
    data object OnBoarding : IKnowDestination("onBoarding")
    data object ActorDetails : IKnowDestination("actorDetails")
    data object ActorKnownFor : IKnowDestination("actorKnownFor")
    data object Login : IKnowDestination("login")
    data object SignUp : IKnowDestination("signup")
    data object SeeAllIKnow : IKnowDestination("seeAllMovie")
    data object SeeAllUpcoming : IKnowDestination("seeAllUpcoming")
    data object SeeAllSeasons : IKnowDestination("seeAllSeasons")
    data object Room : IKnowDestination("room")
    data object SeeAllTvShow : IKnowDestination("seeAllTvShow")
    data object ForgotPassword : IKnowDestination("forgotPassword")
    data object SeeAllEpisodes : IKnowDestination("seeAllEpisodes")
    data object SeeAllTopCast : IKnowDestination("seeAllTopCast")
    data object SeeAllIKnowImages : IKnowDestination("seeAllMovieImages")
    data object SeeAllIKnowReviews : IKnowDestination("seeAllMovieReviews")
    data object IKnowDetails : IKnowDestination("movieDetails")
    data object Questions : IKnowDestination("questions")
    data object GameDetails : IKnowDestination("gameDetails")
    data object TvShowDetails : IKnowDestination("tvShowDetails")
    data object Upcoming : IKnowDestination("upcoming")
    data object IKnowPlayer : IKnowDestination("moviePlayer")
    data object YoutubePlayer : IKnowDestination("youtubePlayer")
    data object SeeAllCategories : IKnowDestination("seeAllCategories")
    data object EpisodeDetails : IKnowDestination("episode_details")


    data object Home : IKnowDestination(
        "home",
        R.drawable.home_2,
        R.drawable.home_2_1
    )

    data object Search : IKnowDestination(
        "search",
        R.drawable.search_normal_1,
        R.drawable.search_normal_1_1
    )

    data object Category : IKnowDestination(
        "saved",
        R.drawable.save_2,
        R.drawable.save_2_1
    )

    data object Library : IKnowDestination(
        "books",
        R.drawable.book_saved,
        R.drawable.book_saved_1
    )
}