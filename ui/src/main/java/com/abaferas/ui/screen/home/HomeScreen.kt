package com.abaferas.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.abaferas.ui.compose.ReportError
import com.abaferas.ui.compose.ReportLoading
import com.abaferas.ui.navigation.IKnowDestination
import com.abaferas.ui.navigation.NavigationHandler
import com.abaferas.ui.screen.onboarding.StatusBarColors
import com.abaferas.ui.screen.search.navigateToSearch
import com.abaferas.ui.theme.Black
import com.abaferas.ui.theme.Montserrat
import com.abaferas.ui.theme.White
import com.abaferas.ui.theme.info600
import com.abaferas.ui.theme.neutral500
import com.abaferas.viewmodels.screen.home.HomeInteractionListener
import com.abaferas.viewmodels.screen.home.HomeUiEffect
import com.abaferas.viewmodels.screen.home.HomeUiState
import com.abaferas.viewmodels.screen.home.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    StatusBarColors()
    val state = homeViewModel.state.collectAsState().value
    HomeScreenContent(state, homeViewModel)
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreenContent(state: HomeUiState, listener: HomeInteractionListener) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Home") }, actions = {
            Image(
                painter = painterResource(id = R.drawable.topapp_logo),
                contentDescription = "",
                modifier = Modifier.padding(end = 16.dp)
            )
        })
    }, bottomBar = {
        BottomBottom(screen = IKnowDestination.Home.route, listener)
    }) { _ ->
        AnimatedVisibility(
            visible = state.isLoading
        ) {
            ReportLoading()
        }
        AnimatedVisibility(
            visible = state.error != null
        ) {
            ReportError(errorMsg = state.error!!.message) {
                /*TODO*/
            }
        }
        AnimatedVisibility(
            visible = !state.isLoading && state.error == null
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 16.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 68.dp, bottom = 56.dp)
            ) {
                items(state.data!!.results) {
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

@Composable
fun BottomBottom(screen: String, listener: HomeInteractionListener) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            painter = if (screen == IKnowDestination.Home.route) painterResource(id = R.drawable.home_2)
            else painterResource(id = R.drawable.home_2_1),
            contentDescription = "",
            tint = info600,
            modifier = Modifier
        )
        Icon(painter = if (screen == IKnowDestination.Search.route) painterResource(id = R.drawable.search_normal_1)
        else painterResource(id = R.drawable.search_normal_1_1),
            contentDescription = "",
            tint = info600,
            modifier = Modifier.clickable {
                listener.onClickSearch()
            })
        Icon(painter = if (screen == IKnowDestination.Books.route) painterResource(id = R.drawable.book_saved)
        else painterResource(id = R.drawable.book_saved_1),
            contentDescription = "",
            tint = info600,
            modifier = Modifier.clickable {
                listener.onClickBooks()
            })
        Icon(painter = if (screen == IKnowDestination.Saves.route) painterResource(id = R.drawable.save_2)
        else painterResource(id = R.drawable.save_2_1),
            contentDescription = "",
            tint = info600,
            modifier = Modifier.clickable {
                listener.onClickSaves()
            })
    }
}
