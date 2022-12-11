package com.anget.cvappandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anget.cvappandroid.R
import com.anget.cvappandroid.common.LinksAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = HomeViewModel(requireContext())
        txv_address.text = String.format(
            "%s - %s, %s",
            viewModel.user.address?.street,
            viewModel.user.address?.city,
            viewModel.user.address?.country
        )

        txv_phone.text = viewModel.user.phone
        txv_stamp.text = viewModel.user.permission
        txv_email.text = viewModel.user.email
        txv_profile_text.text = viewModel.user.profile

        recycler_links.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = LinksAdapter(viewModel.user.links)
        }
    }
}