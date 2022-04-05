package com.tinder.activities.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by pierre-alexandrevezinet on 24/03/2022.
 *
 */


class BaseTabsAdapter(
    fm: FragmentManager?,
    var mNumOfTabs: Int,
    var listFragment: ArrayList<Fragment>
) : FragmentPagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var mPos = 0


    override fun getItem(position: Int): Fragment {
        mPos = position
        if (mPos > 0) mPos -= 1
        else mPos = position
        return when (position) {
            0 -> listFragment[0]
            else -> listFragment[0]
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listFragment[position].tag
    }
}
