package com.detmir.kkppt3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.detmir.kkppt3.views.ProjectItem
import com.detmir.recycli.adapters.RecyclerAdapter

class Case0300SealedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case_0300)
        val recyclerView = findViewById<RecyclerView>(R.id.activity_case_0300_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val recyclerAdapter = RecyclerAdapter(setOf(RecyclerBinderImpl()))
        recyclerView.adapter = recyclerAdapter

        recyclerAdapter.bindState(
            listOf(
                ProjectItem.Failed(
                    id = "FAILED",
                    title = "Failed project",
                    why = ""
                ),
                ProjectItem.New(
                    id = "NEW",
                    title = "New project"
                ),
                ProjectItem.Done.BeforeDeadline(
                    id = "BEFORE_DEAD_LINE",
                    title = "Done before deadline project"
                ),
                ProjectItem.Done.AfterDeadline(
                    id = "AFTER_DEAD_LINE",
                    title = "Done after deadline project",
                    why = ""
                )
            )
        )
    }
}