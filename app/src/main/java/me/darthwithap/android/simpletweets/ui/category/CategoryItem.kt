package me.darthwithap.android.simpletweets.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import me.darthwithap.android.simpletweets.R

@Composable
fun CategoryItem(category: String, onClick: (category: String) -> Unit) {
  Box(modifier = Modifier.padding(horizontal = 7.5.dp, vertical = 7.5.dp)) {
    Box(
      modifier = Modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color(R.color.categoryGridBlue))
        .size(180.dp, 100.dp)
        .clickable { onClick(category) },
      contentAlignment = Alignment.CenterStart
    ) {
      Text(
        modifier = Modifier
          .padding(10.dp, 10.dp)
          .align(Alignment.BottomCenter),
        text = category,
        style = MaterialTheme.typography.body1.copy(color = Color.White),
        fontSize = 16.sp
      )
    }
  }
}