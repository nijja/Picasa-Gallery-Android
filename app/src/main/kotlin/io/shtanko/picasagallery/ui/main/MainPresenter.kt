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

package io.shtanko.picasagallery.ui.main

import io.shtanko.picasagallery.data.album.AlbumRepository
import io.shtanko.picasagallery.util.ActivityScoped
import io.shtanko.picasagallery.util.Logger
import io.shtanko.picasagallery.ui.delegate.ViewType
import io.shtanko.picasagallery.ui.main.MainContract.Presenter
import io.shtanko.picasagallery.ui.main.MainContract.View
import javax.annotation.Nullable
import javax.inject.Inject

@ActivityScoped
class MainPresenter @Inject constructor(
  private val repository: AlbumRepository
) : Presenter {

  @Nullable
  private var view: View? = null

  override fun takeView(view: View) {
    this.view = view
  }

  override fun dropView() {
    this.view = null
  }

  override fun getAlbums() {
    view?.let { view ->
      view.setLoadingIndicator(true)
      repository.albums()
          .subscribe(
              { data ->
                view.setLoadingIndicator(false)
                view.onShowAlbums(data)
              },
              { error ->
                view.setLoadingIndicator(false)
                view.showError(error.localizedMessage)
                Logger.error(error)
              })
    }
  }

  override fun onAlbumClick(model: ViewType) {
    view?.viewAlbum(model)
  }
}