package com.tinder.components.photopager

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.tinder.R
import com.tinder.utils.CustomPhotoSwipeViewPager


class PhotoPagerComponent(context: Context?, attrs: AttributeSet?) :
    ConstraintLayout(context!!, attrs) {

    private lateinit var mContext: Context
    var photoPagerAttributes: PhotoPagerAttrs = PhotoPagerAttrs()
    private lateinit var typedArray: TypedArray

    private lateinit var componentAdapter: PhotoPagerAdapter
    private lateinit var constraintViewPager: ConstraintLayout
    private lateinit var viewPager: CustomPhotoSwipeViewPager
    private lateinit var constraintPhotoActions: ConstraintLayout
    private lateinit var imvPreviousPhoto: ImageView
    private lateinit var imvNextPhoto: ImageView
    lateinit var callingActivity: AppCompatActivity

    init {
        init(context!!, attrs!!)
    }

    @SuppressLint("CustomViewStyleable")
    private fun init(context: Context, attrs: AttributeSet) {
        inflate(context, R.layout.component_photo_pager, this)
        mContext = context

        typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.PhotoPagerComponent,
            0,
            0
        )

        typedArray.recycle()

        photoPagerAttributes.apply {
            mContext = context
        }
        initComponents()
        initListeners()
        fillView()
    }

    private fun initComponents() {
        viewPager = findViewById(R.id.viewpager_photo_viewer)
        constraintViewPager = findViewById(R.id.constraint_view_pager)
        constraintPhotoActions = findViewById(R.id.constraint_actions_photo)
        imvPreviousPhoto = findViewById(R.id.imv_previous_photo)
        imvNextPhoto = findViewById(R.id.imv_next_photo)
    }

    fun fillView() {
        constraintViewPager.visibility = View.VISIBLE
        if (photoPagerAttributes.mPhotoPagerItemsAttrs.size > 0) {
            constraintPhotoActions.visibility = View.VISIBLE
        } else {
            constraintPhotoActions.visibility = View.GONE
        }
    }

    private fun initListeners() {
        imvPreviousPhoto.setOnClickListener { if (viewPager.currentItem > 0) viewPager.currentItem-- }
        imvNextPhoto.setOnClickListener { if (viewPager.currentItem < photoPagerAttributes.mPhotoPagerItemsAttrs.count()) viewPager.currentItem++ }
    }

    fun initPager() {
        viewPager = findViewById(R.id.viewpager_photo_viewer)
        componentAdapter =
            PhotoPagerAdapter(callingActivity, photoPagerAttributes.mPhotoPagerItemsAttrs)
        viewPager.adapter = componentAdapter
        viewPager.currentItem = 0
    }
}