package com.detmir.kkppt3.views

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.detmir.kkppt3.R
import com.detmir.recycli.annotations.RecyclerStateBinder
import com.detmir.recycli.annotations.RecyclerStateView
import toPx

@RecyclerStateView
class UserView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val firstName: TextView
    private val toOnlineButton: TextView
    private val toOfflineButton: TextView
    private val status: FrameLayout

    private var user: User? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.user_view, this)
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        clipToPadding = false
        firstName = findViewById(R.id.user_view_first_name)
        status = findViewById(R.id.user_view_status)
        toOnlineButton = findViewById(R.id.user_view_to_online)
        toOfflineButton = findViewById(R.id.user_view_to_offline)

        toOnlineButton.setOnClickListener {
            this.user?.onMoveToOnline?.invoke()
        }

        toOfflineButton.setOnClickListener {
            this.user?.onMoveToOffline?.invoke()
        }

        setOnClickListener {
            this.user?.onCardClick?.invoke()
        }
    }

    @RecyclerStateBinder
    fun bindState(user: User) {
        this.user = user
        firstName.text = user.firstName
        @ColorRes val color = if (user.online) R.color.recycliGreen else R.color.recycliRed
        status.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, color))

        toOfflineButton.isVisible = user.onMoveToOffline != null && user.online
        toOnlineButton.isVisible = user.onMoveToOnline != null && !user.online
    }
}