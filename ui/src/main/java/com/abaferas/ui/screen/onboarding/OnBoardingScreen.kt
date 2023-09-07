package com.abaferas.ui.screen.onboarding

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abaferas.ui.R
import com.abaferas.ui.navigation.NavigationHandler
import com.abaferas.ui.screen.home.navigateToHome
import com.abaferas.ui.theme.Typography
import com.abaferas.ui.theme.White
import com.abaferas.ui.theme.color
import com.abaferas.ui.theme.info400
import com.abaferas.ui.theme.info700
import com.abaferas.ui.theme.neutral600
import com.abaferas.viewmodels.screen.onboarding.OnBoardingInteraction
import com.abaferas.viewmodels.screen.onboarding.OnBoardingUi
import com.abaferas.viewmodels.screen.onboarding.OnBoardingUiEffect
import com.abaferas.viewmodels.screen.onboarding.OnBoardingViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(onBoardingViewModel: OnBoardingViewModel = hiltViewModel()) {
    StatusBarColors()
    val state = onBoardingViewModel.state.collectAsState().value
    val selected = onBoardingViewModel.selected.collectAsState().value
    NavigationHandler(effects = onBoardingViewModel.effect) { effect, nav ->
        when (effect) {
            is OnBoardingUiEffect.NavigateUP -> {
                nav.popBackStack()
            }

            is OnBoardingUiEffect.SubmitSelected -> {
                nav.navigateToHome(effect.selected)
            }
        }
    }
    OnBoardingScreenContent(state, selected, onBoardingViewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnBoardingScreenContent(
    state: OnBoardingUi,
    selected: MutableList<String>,
    listener: OnBoardingInteraction
) {
    var count by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = state.title) })
        },
        bottomBar = {
            PrimaryButton("Submit", enabled = count > 0) {
                listener.onClickSubmit()
            }
        }
    ) { _ ->
        Column(
            verticalArrangement = Arrangement.Bottom, modifier = Modifier
                .padding(top = 70.dp)
        ) {
            Row {
                Text(
                    text = state.note, textAlign = TextAlign.Center,
                    style = Typography.displaySmall,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                )
            }
            Row(modifier = Modifier.padding(bottom = 70.dp)) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.list) { item ->
                        var isSelected by remember { mutableStateOf(selected.contains(item.name)) }
                        val scale = remember { Animatable(initialValue = 1f) }
                        LaunchedEffect(key1 = isSelected) {
                            if (isSelected) {
                                launch {
                                    scale.animateTo(
                                        targetValue = 0.9f,
                                        animationSpec = tween(
                                            durationMillis = 50
                                        )
                                    )
                                    scale.animateTo(
                                        targetValue = 1f,
                                        animationSpec = spring(
                                            dampingRatio = Spring.DampingRatioLowBouncy,
                                            stiffness = Spring.StiffnessLow
                                        )
                                    )
                                }
                            }
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .scale(scale.value)
                                .height(48.dp)
                                .clickable {
                                    listener.toggleItem(item)
                                    isSelected = !isSelected
                                    if (isSelected) count++ else count--
                                }
                                .clip(RoundedCornerShape(CornerSize(8.dp))),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isSelected) info400 else White
                            ),
                            border = if (isSelected) null else BorderStroke(1.dp, neutral600),
                            shape = RoundedCornerShape(CornerSize(8.dp))
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(CornerSize(8.dp)))
                                    .padding(horizontal = 24.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                Alignment.CenterVertically
                            ) {
                                Text(
                                    text = item.name,
                                    color = if (isSelected) info700 else neutral600,
                                    style = Typography.displayLarge
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.star),
                                    contentDescription = "",
                                    tint = if (isSelected) info700 else Color.LightGray,
                                    modifier = Modifier.scale(scale.value)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PrimaryButton(title: String, enabled: Boolean, onClick: () -> Unit) {
    Button(
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(56.dp),
        shape = RoundedCornerShape(CornerSize(8.dp)),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) info700 else neutral600
        )
    ) {
        Text(
            text = title, style = Typography.headlineMedium,
            color = if (enabled) info400 else Color.Gray
        )
    }
}

@Composable
fun StatusBarColors() {
    rememberSystemUiController()
        .setSystemBarsColor(
            MaterialTheme.color.white,
            darkIcons = true
        )
}