package com.abaferas.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abaferas.ui.R
import com.abaferas.ui.navigation.IKnowDestination
import com.abaferas.ui.theme.info600
import com.abaferas.viewmodels.base.IBaseInteractionListener

@Composable
fun BottomBottom(screen: String, listener: IBaseInteractionListener) {
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
            modifier = Modifier.clickable {
                listener.onClickHome()
            }
        )
        Icon(painter = if (screen == IKnowDestination.Search.route
        ) painterResource(id = R.drawable.search_normal_1)
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