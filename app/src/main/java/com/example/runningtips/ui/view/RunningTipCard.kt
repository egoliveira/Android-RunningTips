package com.example.runningtips.ui.view

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.runningtips.R
import com.example.runningtips.model.RunningTip
import com.example.runningtips.model.RunningTipsRepository
import com.example.runningtips.ui.theme.AppTheme

@Composable
fun RunningTipCard(
    runningTip: RunningTip,
    expanded: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Text(
                text = stringResource(id = R.string.day_template, runningTip.day),
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(id = runningTip.tipTitleResId),
                style = MaterialTheme.typography.titleLarge
            )

            Image(
                painter = painterResource(id = runningTip.tipPhotoResId),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier.clickable {
                    onCardClick()
                }
            )

            if (expanded) {
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = stringResource(id = runningTip.tipDescriptionResId),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
fun RunningTipCardPreview() {
    AppTheme {
        RunningTipCard(runningTip = RunningTipsRepository.runningTips[0],
            expanded = true,
            onCardClick = {})
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun RunningTipCardDarkPreview() {
    AppTheme {
        RunningTipCard(runningTip = RunningTipsRepository.runningTips[1],
            expanded = false,
            onCardClick = {})
    }
}