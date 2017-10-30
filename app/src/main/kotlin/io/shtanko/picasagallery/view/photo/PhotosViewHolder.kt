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

package io.shtanko.picasagallery.view.photo

import android.view.View
import io.shtanko.picasagallery.R
import io.shtanko.picasagallery.core.image.ImageHelper
import io.shtanko.picasagallery.core.image.ImageHelperImpl
import io.shtanko.picasagallery.data.entity.photo.PhotoType
import io.shtanko.picasagallery.view.base.BaseViewHolder
import io.shtanko.picasagallery.view.delegate.ViewType
import io.shtanko.picasagallery.view.util.Divided
import io.shtanko.picasagallery.view.widget.FourThreeImageView

class PhotosViewHolder(itemView: View?) : BaseViewHolder(itemView), Divided {

	val image = itemView?.findViewById<FourThreeImageView>(R.id.album)
	private val imageHelper: ImageHelper

	init {
		imageHelper = ImageHelperImpl()
	}

	override fun bind(item: ViewType) {
		if (item is PhotoType) {
			imageHelper.process(itemView.context, image,
					"https://cdn.dribbble.com/users/989466/screenshots/3785128/diamond-sword-dribbble-alex-pasquarella.png")
		}
	}

}