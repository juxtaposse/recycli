package com.detmir.shapes.square

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.annotations.RecyclerState

class SquareItem {
    interface View {
        fun bindState(state: State)
    }

    @RecyclerState
    data class State(
        val id: String,
        val text: String
    ) : RecyclerItem {
        override fun provideId() = id
    }
}