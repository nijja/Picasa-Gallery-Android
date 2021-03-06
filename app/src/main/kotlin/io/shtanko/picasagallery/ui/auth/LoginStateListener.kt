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

package io.shtanko.picasagallery.ui.auth

interface LoginStateListener {
  /**
   * This is called when the user has requested to sign in. Implements showing the login UI.
   */
  abstract fun onSignInOrCreateAccount()

  /**
   * This is called when the user has selected another account. Implements any custom changes
   * required in the feature based on the selected account.
   */
  abstract fun onAccountChangeRequested()

  /**
   * This is called when the user has selected another account. Implements login in the user.
   */
  abstract fun onStartLoginProcessRequested()
}