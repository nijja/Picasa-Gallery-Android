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

package io.shtanko.picasagallery.ui.widget

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.View.MeasureSpec.EXACTLY
import android.view.View.MeasureSpec.makeMeasureSpec

class FourThreeImageView : AppCompatImageView {

  // region default constructors
  constructor(context: Context) : super(context)

  constructor(
    context: Context,
    attrs: AttributeSet
  ) : super(context, attrs)

  constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int
  ) : super(
      context, attrs,
      defStyleAttr
  )
  // endregion

  override fun onMeasure(
    widthMeasureSpec: Int,
    heightMeasureSpec: Int
  ) {
    val fourThreeHeight = makeMeasureSpec(
        MeasureSpec.getSize(widthMeasureSpec) * 3 / 4,
        EXACTLY
    )
    super.onMeasure(widthMeasureSpec, fourThreeHeight)
  }
}