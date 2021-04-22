package com.detmir.kkppt3.views

import com.detmir.recycli.adapters.RecyclerItem
import com.detmir.recycli.adapters.RecyclerStateRegular
import com.detmir.recycli.adapters.ScrollKeeper
import com.detmir.recycli.annotations.RecyclerItemState

@RecyclerItemState
data class RecyclerContainer(
    val id: String,
    val scrollKeeper: ScrollKeeper = ScrollKeeper(),
    val recyclerState: RecyclerStateRegular
): RecyclerItem {
    override fun provideId(): String {
        return id
    }
}