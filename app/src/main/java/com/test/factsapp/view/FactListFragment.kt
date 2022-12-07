package com.test.factsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.factsapp.R
import com.test.factsapp.databinding.FragmentFactListBinding
import com.test.factsapp.viewmodel.FactListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FactListFragment : Fragment() {

    private lateinit var binding: FragmentFactListBinding
    private val model by viewModel<FactListViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        model.fetchFacts()
        super.onViewCreated(view, savedInstanceState)
    }
}