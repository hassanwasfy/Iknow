package com.abaferas.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.abaferas.ui.R
import com.abaferas.ui.compose.BuildScaffold
import com.abaferas.ui.compose.NormalTopAppBar
import com.abaferas.ui.navigation.NavigationHandler
import com.abaferas.ui.screen.onboarding.StatusBarColors
import com.abaferas.ui.screen.search.navigateToSearch
import com.abaferas.ui.theme.Black
import com.abaferas.ui.theme.Montserrat
import com.abaferas.ui.theme.White
import com.abaferas.ui.theme.info600
import com.abaferas.ui.theme.neutral500
import com.abaferas.viewmodels.screen.home.HomeUiEffect
import com.abaferas.viewmodels.screen.home.HomeUiState
import com.abaferas.viewmodels.screen.home.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    StatusBarColors()
    val state = homeViewModel.state.collectAsState().value
    HomeScreenContent(state)
    NavigationHandler(effects = homeViewModel.effect) { effect, nav ->
        when (effect) {
            is HomeUiEffect.NavigateToArticle -> {}
            is HomeUiEffect.NavigateToBooks -> {}
            is HomeUiEffect.NavigateToSaves -> {}
            is HomeUiEffect.NavigateToSearch -> {
                nav.navigateToSearch()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun HomeScreenContent(state: HomeUiState) {
    BuildScaffold(
        topAppBar = { NormalTopAppBar(title = "Home") },
        isLoading = state.isLoading,
        error = state.error,
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 68.dp)
        ) {
            val currentData = state.data?.results
            if (currentData != null) {
                items(currentData) {
                    Card(
                        modifier = Modifier.height(140.dp), colors = CardDefaults.cardColors(
                            containerColor = White
                        ), border = BorderStroke(2.dp, neutral500)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(
                                    model = it.url,
                                    placeholder = painterResource(id = R.drawable.placeholder_image_1)
                                ),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(0.4f)
                            )
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxSize()
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    CustomChip(it.section)
                                }
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Text(
                                        text = it.title,
                                        modifier = Modifier,
                                        textAlign = TextAlign.Start,
                                        fontFamily = Montserrat,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp,
                                        color = Black
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomChip(section: String) {
    Text(
        text = section,
        modifier = Modifier
            .border(
                1.dp, info600, RoundedCornerShape(CornerSize(16.dp))
            )
            .width(64.dp)
            .height(24.dp)
            .padding(top = 4.dp),
        textAlign = TextAlign.Center,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = info600
    )
}
