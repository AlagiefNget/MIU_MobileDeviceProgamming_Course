package com.anget.cvappandroid.ui.education

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.anget.cvappandroid.R
import com.anget.cvappandroid.common.EducationAdapter
import kotlinx.android.synthetic.main.fragment_education_training.*

class EducationTrainingFragment : Fragment() {

    companion object {
        fun newInstance() = EducationTrainingFragment()
    }

    private lateinit var viewModel: EducationTrainingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_education_training, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = EducationTrainingViewModel(requireContext())

        recycler_education.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = EducationAdapter(viewModel.educationList)
        }
    }
}