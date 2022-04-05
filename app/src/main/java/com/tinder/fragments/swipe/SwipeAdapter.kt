package com.tinder.fragments.swipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.insta.utils.PrefsManager
import com.tinder.R
import com.tinder.components.photopager.PhotoPagerAttrs
import com.tinder.components.photopager.PhotoPagerComponent
import com.tinder.components.photopager.PhotoPagerItemsAttrs
import com.tinder.model.PhotoSummary
import com.tinder.model.ProfileSwipable


class SwipeAdapter(
    mListProfiles: ArrayList<ProfileSwipable>,
    view: AppCompatActivity,
    fragmentPresenter: SwipePresenter
) : RecyclerView.Adapter<SwipeAdapter.SwipeView>() {

    private var prefsManager: PrefsManager? = null
    private var view: AppCompatActivity? = null
    private var presenter: SwipePresenter? = null
    private var listProfiles: ArrayList<ProfileSwipable> = ArrayList()


    init {
        prefsManager = PrefsManager(view.applicationContext)
        this.presenter = fragmentPresenter
        this.view = view
        listProfiles = mListProfiles
    }

    class SwipeView(v: View) : RecyclerView.ViewHolder(v) {
        var photosPagerComponent: PhotoPagerComponent? = null
        var linearActionsProfile: LinearLayout? = null
        var imvPreviousProfile: ImageView? = null
        var imvRejectProfile: ImageView? = null
        var imvSuperLikeProfile: ImageView? = null
        var imvLikeProfile: ImageView? = null


        init {
            photosPagerComponent = v.findViewById(R.id.photo_pager_component)
            linearActionsProfile = v.findViewById(R.id.linear_actions_profile)
            imvPreviousProfile = v.findViewById(R.id.imv_previous_profile)
            imvRejectProfile = v.findViewById(R.id.imv_reject_profile)
            imvSuperLikeProfile = v.findViewById(R.id.imv_super_like_profile)
            imvLikeProfile = v.findViewById(R.id.imv_like_profile)
        }
    }


    override fun onBindViewHolder(holder: SwipeView, position: Int) {
        holder.setIsRecyclable(false)
        val profile = listProfiles[position]
        initPhotoAdapterComponent(holder.photosPagerComponent!!, profile.photos!!)
    }


    private fun initPhotoAdapterComponent(photoPagerComponent : PhotoPagerComponent, listPhotos : ArrayList<PhotoSummary>) {
        val photoAdapterAttrs = PhotoPagerAttrs()
        val listPhotoItemAttrs = ArrayList<PhotoPagerItemsAttrs>()
        for (i in listPhotos.indices) {
            val photosItemAttrs = PhotoPagerItemsAttrs()
            val currentSelectedPhoto = listPhotos[i]
            photosItemAttrs.apply {
                photo = currentSelectedPhoto
            }
            listPhotoItemAttrs.add(photosItemAttrs)
        }

        photoAdapterAttrs.mPhotoPagerItemsAttrs = listPhotoItemAttrs
        photoPagerComponent.photoPagerAttributes = photoAdapterAttrs
        photoPagerComponent.callingActivity = view!!
        photoPagerComponent.fillView()
        photoPagerComponent.initPager()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeView {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview, parent, false)
        return SwipeView(itemView)
    }

    override fun getItemCount(): Int {
        return listProfiles.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}