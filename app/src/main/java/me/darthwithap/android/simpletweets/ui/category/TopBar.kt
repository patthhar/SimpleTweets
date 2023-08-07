package me.darthwithap.android.simpletweets.ui.category

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.darthwithap.android.simpletweets.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TopBar() {
  Row(
    modifier = Modifier
      .fillMaxWidth(1f)
      .background(Color(R.color.appWhite))
      .height(56.dp)
      .padding(4.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(imageVector = Icons.Default.Home, contentDescription = null)
    Spacer(modifier = Modifier.width(24.dp))
    Text(text = parseDate(LocalDate.now()), style = MaterialTheme.typography.h3)
    Spacer(modifier = Modifier.width(24.dp))
    Icon(imageVector = Icons.Default.Search, contentDescription = null)
  }

}

@RequiresApi(Build.VERSION_CODES.O)
fun parseDate(now: LocalDate): String {
  return DateTimeFormatter.ofPattern("dd LLLL").format(now)
}