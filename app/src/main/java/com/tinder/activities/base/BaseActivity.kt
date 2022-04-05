package com.tinder.activities.base

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.tinder.R
import com.tinder.fragments.swipe.SwipeFragment
import com.tinder.utils.Application
import com.tinder.utils.Workflow


open class BaseActivity : AppCompatActivity() {

    private lateinit var presenter: BasePresenter
    protected var workflow = Workflow()
    lateinit var tabLayout: TabLayout
    private lateinit var swipeFragment: SwipeFragment
    private var listFragments = ArrayList<Fragment>()
    private lateinit var tvUsername : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        Application.changeStatusBarColor(this, R.color.colorWhite)
        workflow = Application.getWorkflow()
        presenter = BasePresenter(this, workflow)
        initViews()
        fillViews()
        initFragments()
        initBaseTabs()
        initBaseListeners()
    }

    private fun initFragments() {
        swipeFragment = SwipeFragment()
        listFragments.add(swipeFragment)
    }

    private fun initViews() {
        tabLayout = findViewById(R.id.tab_layout)
    }

    private fun fillViews(){
    }

    private fun initBaseListeners() {
    }

    private fun initBaseTabs() {
        tabLayout.apply {
            addTab(tabLayout.newTab())
            getTabAt(0)?.setCustomView(R.layout.tab_view_swipe)
            tabGravity = TabLayout.GRAVITY_FILL
        }

        val viewPager = findViewById<View>(R.id.view_pager_base) as ViewPager
        viewPager.offscreenPageLimit = 1
        val tabsAdapter = BaseTabsAdapter(supportFragmentManager, tabLayout.tabCount,
            listFragments)
        viewPager.adapter = tabsAdapter
        viewPager.currentItem = 0
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }
}


