package com.example.runningtips.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.runningtips.model.RunningTip
import com.example.runningtips.model.RunningTipsRepository

@Composable
fun RunningTipsList(
    modifier: Modifier = Modifier,
    tipsList: List<RunningTip>
) {
    val cardExpanded = remember { mutableStateMapOf<Int, Boolean>() }

    Column(modifier = modifier.padding(horizontal = 8.dp)) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            itemsIndexed(tipsList) { index, runningTip ->
                RunningTipCard(runningTip = runningTip,
                    expanded = cardExpanded.getOrDefault(index, false),
                    onCardClick = {
                        val expanded = cardExpanded.getOrDefault(index, false)

                        cardExpanded[index] = !expanded
                    })
            }
        }
    }

}

@Composable
@Preview
fun RunningTipsListPreview() {
    RunningTipsList(tipsList = RunningTipsRepository.runningTips)
}