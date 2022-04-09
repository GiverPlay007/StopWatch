package me.giverplay.stopwatch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

class StopWatch() {
  var formattedTime by mutableStateOf("00:00:00")

  private var coroutineScope = CoroutineScope(Dispatchers.Main)
  private var isRunning = false

  private var time = 0L
  private var lastTime = 0L

  fun start() {
    if(isRunning) return

    coroutineScope.launch {
      lastTime = System.currentTimeMillis()
      isRunning = true

      while(isRunning) {
        delay(10L)
        time += System.currentTimeMillis() - lastTime
        lastTime = System.currentTimeMillis()
        formattedTime = formatTime(time)
      }
    }
  }

  fun pause() {
    isRunning = false
  }

  fun reset() {
    isRunning = false
    coroutineScope.cancel()
    coroutineScope = CoroutineScope(Dispatchers.Main)
    time = 0L
    lastTime = 0L
    formattedTime = "00:00:00"
  }

  private fun formatTime(time: Long): String {
    val dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault())
    val formatter = DateTimeFormatter.ofPattern("mm:ss:SS", Locale.getDefault())

    return dateTime.format(formatter)
  }
}