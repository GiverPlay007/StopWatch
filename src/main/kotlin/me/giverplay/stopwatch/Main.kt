package me.giverplay.stopwatch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
  MaterialTheme {
    Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier.fillMaxSize()
    ) {
      val stopWatch = remember { StopWatch() }

      StopWatchUI(
        formattedTime = stopWatch.formattedTime,
        onStartClick = stopWatch::start,
        onPauseClick = stopWatch::pause,
        onResetClick = stopWatch::reset
      )
    }
  }
}

fun main() = application {
  Window(onCloseRequest = ::exitApplication) {
    App()
  }
}
