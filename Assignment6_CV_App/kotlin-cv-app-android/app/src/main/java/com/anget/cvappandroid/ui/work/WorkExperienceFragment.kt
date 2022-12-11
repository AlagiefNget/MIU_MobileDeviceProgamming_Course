package com.anget.cvappandroid.ui.work

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.anget.cvappandroid.R
import com.anget.cvappandroid.common.WorkAdapter
import kotlinx.android.synthetic.main.fragment_work_experience.*

class WorkExperienceFragment : Fragment() {

    companion object {
        fun newInstance() = WorkExperienceFragment()
    }

    private lateinit var viewModel: WorkExperienceViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_work_experience, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = WorkExperienceViewModel(requireContext())

        recycler_career_history.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = WorkAdapter(viewModel.careerHistoryList)
        }
    }
}