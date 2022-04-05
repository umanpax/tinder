package com.tinder.components.photopager

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.github.chrisbanes.photoview.PhotoView
import com.insta.utils.PrefsManager
import com.tinder.R
import com.tinder.model.PhotoSummary

class PhotoPagerAdapter(context: Context,
                         mListPhotosSummary: ArrayList<PhotoPagerItemsAttrs>
) : PagerAdapter() {

    private var listPhotosSummary: ArrayList<PhotoPagerItemsAttrs> = ArrayList()
    private var prefsManager: PrefsManager? = null
    private var context: Context? = null

    init {
        prefsManager = PrefsManager(context)
        this.context = context
        this.listPhotosSummary = mListPhotosSummary
    }

    override fun getCount(): Int {
        return listPhotosSummary.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater =
            context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView: View = inflater.inflate(R.layout.item_photo_viewer, container, false)

        val photoSummary = listPhotosSummary[position]
        val imvPhoto: ImageView = itemView.findViewById(R.id.imv_photo_viewer) as PhotoView
        val tvInfo1 = itemView.findViewById<TextView>(R.id.tv_info1)
        val tvInfo2 = itemView.findViewById<TextView>(R.id.tv_info2)
        val tvInfo3 = itemView.findViewById<TextView>(R.id.tv_info3)
        val tvInfo4 = itemView.findViewById<TextView>(R.id.tv_info4)
        val tvInfo5 = itemView.findViewById<TextView>(R.id.tv_info5)
        val tvInfo6 = itemView.findViewById<TextView>(R.id.tv_info6)

        tvInfo1.text = photoSummary.photo.job
        tvInfo2.text = photoSummary.photo.astro
        tvInfo3.text = photoSummary.photo.studies
        tvInfo4.text = photoSummary.photo.description
        if(photoSummary.photo.smoke!!) tvInfo5.text = "Fume"
        else tvInfo5.text = "Ne fume pas"
        tvInfo6.text = photoSummary.photo.listHobbies!![0]

        if (photoSummary.photo.url != null) {

            Glide.with(context!!)
                .load(photoSummary.photo.url!!)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?,
                                              model: Any?,
                                              target: Target<Drawable>?,
                                              isFirstResource: Boolean
                    ): Boolean {

                        return false
                    }

                    override fun onResourceReady(resource: Drawable?,
                                                 model: Any?,
                                                 target: Target<Drawable>?,
                                                 dataSource: DataSource?,
                                                 isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                })
                .into(imvPhoto)
        }
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

}