package me.darthwithap.android.simpletweets.ui.category

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryItem(category: String) {
  Box(
    modifier = Modifier
      .padding(8.dp)
      .size(160.dp)
      .clip(RoundedCornerShape(8.dp))
      .border(1.dp, Color(0xFFEEEEEE)),
    contentAlignment = Alignment.BottomCenter
  ) {
    Text(
      modifier = Modifier.padding(0.dp, 12.dp),
      text = category,
      style = MaterialTheme.typography.body2,
      fontSize = 16.sp
    )
  }
}