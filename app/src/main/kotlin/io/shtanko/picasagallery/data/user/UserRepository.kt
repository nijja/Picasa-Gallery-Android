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

package io.shtanko.picasagallery.data.user

import io.shtanko.picasagallery.core.prefs.PreferenceHelper
import io.shtanko.picasagallery.data.entity.user.User
import javax.inject.Inject
import javax.inject.Singleton

interface UserDataSource {
  fun getUser(): User
  fun getToken(): String
  fun saveUser(user: User)
  fun saveToken(token: String)
  fun markUserRefusedSignIn(refused: Boolean)
}

@Singleton
class UserDataSourceImpl @Inject constructor(
  private val preferencesHelper: PreferenceHelper
) : UserDataSource {
  override fun getToken(): String =
    preferencesHelper.getToken()

  override fun markUserRefusedSignIn(refused: Boolean) {
    preferencesHelper.markUserRefusedSignIn(refused)
  }

  override fun getUser() = preferencesHelper.getUser()

  override fun saveToken(token: String) {
    preferencesHelper.saveToken(token)
  }

  override fun saveUser(user: User) {
    preferencesHelper.saveUserData(user)
  }
}

@Singleton
class UserRepositoryImpl @Inject constructor(
  private val dataSourceImpl: UserDataSourceImpl
) : UserDataSource {
  override fun getToken(): String = dataSourceImpl.getToken()

  override fun markUserRefusedSignIn(refused: Boolean) {
    dataSourceImpl.markUserRefusedSignIn(refused)
  }

  override fun getUser() = dataSourceImpl.getUser()

  override fun saveToken(token: String) {
    dataSourceImpl.saveToken(token)
  }

  override fun saveUser(user: User) {
    dataSourceImpl.saveUser(user)
  }
}