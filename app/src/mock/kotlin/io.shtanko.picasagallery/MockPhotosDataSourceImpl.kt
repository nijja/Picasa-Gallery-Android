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

package io.shtanko.picasagallery

import io.reactivex.Flowable
import io.shtanko.picasagallery.data.entity.photo.PhotoType
import io.shtanko.picasagallery.data.photo.PhotosDataSource
import io.shtanko.picasagallery.extensions.PhotosList
import io.shtanko.picasagallery.ui.util.getPhotosData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockPhotosDataSourceImpl @Inject constructor() : PhotosDataSource {

  override fun getPhotos(): Flowable<PhotosList> {
    val mockList = ArrayList<PhotoType>()
    mockList.addAll(getPhotosData())
    return Flowable.just(mockList)
  }
}