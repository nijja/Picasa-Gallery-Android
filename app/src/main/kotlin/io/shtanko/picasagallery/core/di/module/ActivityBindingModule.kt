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

package io.shtanko.picasagallery.core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.shtanko.picasagallery.util.ActivityScoped
import io.shtanko.picasagallery.ui.album.InternalAlbumsActivity
import io.shtanko.picasagallery.ui.album.InternalAlbumsModule
import io.shtanko.picasagallery.ui.auth.SignInActivity
import io.shtanko.picasagallery.ui.auth.SignInModule
import io.shtanko.picasagallery.ui.launch.LaunchActivity
import io.shtanko.picasagallery.ui.launch.LaunchModule
import io.shtanko.picasagallery.ui.main.MainActivity
import io.shtanko.picasagallery.ui.main.MainModule
import io.shtanko.picasagallery.ui.photo.PhotosActivity
import io.shtanko.picasagallery.ui.photo.PhotosModule
import io.shtanko.picasagallery.ui.profile.ProfileActivity
import io.shtanko.picasagallery.ui.profile.ProfileModule

@Module
abstract class ActivityBindingModule {

  @ActivityScoped
  @ContributesAndroidInjector(modules = [MainModule::class])
  abstract fun mainActivity(): MainActivity

  @ActivityScoped
  @ContributesAndroidInjector(modules = [SignInModule::class])
  abstract fun signInActivity(): SignInActivity

  @ActivityScoped
  @ContributesAndroidInjector(modules = [ProfileModule::class])
  abstract fun profileActivity(): ProfileActivity

  @ActivityScoped
  @ContributesAndroidInjector(modules = [LaunchModule::class])
  abstract fun launchActivity(): LaunchActivity

  @ActivityScoped
  @ContributesAndroidInjector(modules = [PhotosModule::class])
  abstract fun photosActivity(): PhotosActivity

  @ActivityScoped
  @ContributesAndroidInjector(modules = [InternalAlbumsModule::class])
  abstract fun internalAlbumsActivity(): InternalAlbumsActivity
}