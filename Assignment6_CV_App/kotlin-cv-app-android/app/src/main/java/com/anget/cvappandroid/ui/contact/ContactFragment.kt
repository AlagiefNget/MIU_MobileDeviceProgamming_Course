package com.anget.cvappandroid.ui.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.anget.cvappandroid.R
import com.anget.cvappandroid.common.ContactAdapter
import com.anget.cvappandroid.common.EducationAdapter
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment() {

    companion object {
        fun newInstance() = ContactFragment()
    }

    private lateinit var viewModel: ContactFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ContactFragmentViewModel(requireContext())

        recycler_contact.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ContactAdapter(viewModel.contactList)
        }
    }
}