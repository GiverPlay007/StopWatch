package me.giverplay.stopwatch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopWatchUI(
  formattedTime: String,
  onStartClick: () -> Unit,
  onPauseClick: () -> Unit,
  onResetClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = formattedTime,
      fontWeight = FontWeight.Bold,
      fontSize = 30.sp,
      color = Color.Black,
      fontFamily = FontFamily.Monospace
    )
    Spacer(Modifier.height(16.dp))
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
      modifier = Modifier.fillMaxWidth()
    ) {
      Button(onStartClick) { Text("Start") }
      Spacer(Modifier.width(16.dp))

      Button(onPauseClick) { Text("Pause") }
      Spacer(Modifier.width(16.dp))

      Button(onResetClick) { Text("Reset") }
    }
  }
}