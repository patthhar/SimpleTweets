package me.darthwithap.android.simpletweets.ui.tweets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TweetItem(text: String) {
  Box(
    modifier = Modifier
      .padding(8.dp)
      .fillMaxWidth()
      .clip(RoundedCornerShape(4.dp))
      .border(1.dp, Color.Black)
      .padding(8.dp)
  ) {
    Text(
      modifier = Modifier.align(Alignment.Center),
      text = text,
      style = MaterialTheme.typography.body2.copy(color = Color.White)
    )
  }
}