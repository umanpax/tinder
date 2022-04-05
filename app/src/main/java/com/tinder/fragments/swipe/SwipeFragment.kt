package com.tinder.fragments.swipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import com.insta.utils.PrefsManager
import com.tinder.R
import com.tinder.activities.base.BaseActivity
import com.tinder.model.ProfileSwipable
import com.tinder.utils.Application
import com.tinder.utils.Workflow
import com.yuyakaido.android.cardstackview.*

class SwipeFragment : Fragment(), CardStackListener, SwipeView {
    private lateinit var prefsManager: PrefsManager
    private lateinit var presenter: SwipePresenter
    private var workflow = Workflow()
    private lateinit var mView: View
    private lateinit var baseActivity: BaseActivity

    private lateinit var manager: CardStackLayoutManager
    var listProfiles: ArrayList<ProfileSwipable> = ArrayList()
    private lateinit var adapter: SwipeAdapter
    private lateinit var cardStackView: CardStackView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        baseActivity = activity as BaseActivity
        mView = inflater.inflate(R.layout.fragment_swipe, container, false)
        workflow = Application.getWorkflow()
        listProfiles = workflow.listProfiles
        presenter = SwipePresenter(this, workflow)
        initViews(mView)
        fillViews()
        initPrefs()
        initListeners()
        handleListProfiles(listProfiles)
        return mView
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        baseActivity = activity as BaseActivity
    }

    private fun initPrefs() {
        prefsManager = PrefsManager(requireContext())
    }

    private fun initListeners() {
    }

    private fun initViews(v : View) {
        cardStackView = v.findViewById(R.id.card_stack_view)
    }

    private fun fillViews() {
    }

    private fun initCardView() {
        if (listProfiles.isNotEmpty()) {
            cardStackView.visibility = View.VISIBLE
            cardStackView.bringToFront()
        } else {
            cardStackView.visibility = View.INVISIBLE
        }

        manager = CardStackLayoutManager(context, this)
        cardStackView.layoutManager = manager
        adapter = SwipeAdapter(listProfiles, baseActivity, presenter)
        manager.setStackFrom(StackFrom.Top)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())

        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
        cardStackView.itemAnimator = DefaultItemAnimator()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
        when(direction){
            Direction.Left ->{

            }
            Direction.Right ->{

            }
        }
    }

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

    override fun handleListProfiles(response: ArrayList<ProfileSwipable>) {
        listProfiles = ArrayList()
        listProfiles.addAll(response)
        initCardView()
    }
}