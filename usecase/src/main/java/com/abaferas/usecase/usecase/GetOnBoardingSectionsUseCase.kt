package com.abaferas.usecase.usecase

import javax.inject.Inject

class GetOnBoardingSectionsUseCase @Inject constructor() {
    operator fun invoke() = listOf(
        "arts",
        "automobiles",
        "books",
        "review",
        "business",
        "fashion",
        "food",
        "health",
        "home",
        "insider",
        "magazine",
        "movies",
        "nyregion",
        "obituaries",
        "opinion",
        "politics",
        "realestate",
        "science",
        "sports",
        "sundayreview",
        "technology",
        "theater",
        "t-magazine",
        "travel",
        "upshot",
        "us",
        "world"
    )
}