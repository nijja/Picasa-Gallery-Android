/*
 * Copyright 2017 Alexey Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.shtanko.picasagallery.core

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper.loop
import android.os.Looper.prepare
import android.os.Message
import java.util.concurrent.CountDownLatch

class DispatchQueue constructor(threadName: String) : Thread() {
  @Volatile private var handler: Handler? = null
  private val syncLatch = CountDownLatch(1)

  init {
    name = threadName
    start()
  }

  fun sendMessage(
    msg: Message,
    delay: Int
  ) {
    try {
      syncLatch.await()
      if (delay <= 0) handler?.sendMessage(msg) else handler?.sendMessageDelayed(
          msg,
          delay.toLong()
      )
    } catch (e: Exception) {
    }
  }

  fun cancelRunnable(runnable: Runnable) {
    try {
      syncLatch.await()
      handler?.removeCallbacks(runnable)
    } catch (e: Exception) {
    }
  }

  fun postRunnable(runnable: Runnable) {
    postRunnable(runnable, 0)
  }

  private fun postRunnable(
    runnable: Runnable,
    delay: Long
  ) {
    try {
      syncLatch.await()
      if (delay <= 0) handler?.post(runnable) else handler?.postDelayed(runnable, delay)
    } catch (e: Exception) {
    }
  }

  fun cleanupQueue() {
    try {
      syncLatch.await()
      handler?.removeCallbacksAndMessages(null)
    } catch (e: Exception) {
    }
  }

  fun handleMessage(inputMessage: Message) {

  }

  override fun run() {
    super.run()
    prepare()
    handler = @SuppressLint("HandlerLeak")
    object : Handler() {
      override fun handleMessage(msg: Message) = this@DispatchQueue.handleMessage(msg)
    }
    syncLatch.countDown()
    loop()
  }
}