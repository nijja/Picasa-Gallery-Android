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

package io.shtanko.picasagallery.ui.base

import android.support.v4.app.Fragment
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import io.shtanko.picasagallery.util.ActivityUtils

abstract class BaseActivity : DaggerAppCompatActivity() {

  fun <T : Fragment> addFragment(
    fragmentId: Int,
    provider: Lazy<T>
  ) {
    var mainFragment = supportFragmentManager.findFragmentById(
        fragmentId
    )
    if (mainFragment == null) {
      mainFragment = provider.get()
      ActivityUtils.addFragmentToActivity(supportFragmentManager, mainFragment, fragmentId)
    }
  }
}