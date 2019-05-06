package com.example.giuseppe.demoapp.ui.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.giuseppe.demoapp.R
import com.example.giuseppe.demoapp.domain.model.ComicDataEntity
import com.example.giuseppe.demoapp.databinding.FragmentMainBinding
import com.example.giuseppe.demoapp.di.Injectable
import com.example.giuseppe.demoapp.ui.adapters.ComicListAdapter
import com.example.giuseppe.demoapp.viewmodel.MainViewModel
import com.example.giuseppe.demoapp.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {

    @set:Inject
    var viewModelFactory: ViewModelFactory? = null

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: FragmentMainBinding
    lateinit var recyclerView: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(context)
        binding.setOnButtonClicked { mainViewModel.loadMoreData() }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = ComicListAdapter(setAdapterClickListener())
        recyclerView.adapter = adapter
        observeComicData(adapter)
    }

    private fun observeComicData(adapter: ComicListAdapter) {
        mainViewModel.comicData.observe(this,
            Observer {
                if (it.isNullOrEmpty()) {
                    Toast.makeText(context,"Ha ocurrido un error cargando los comics :(",Toast.LENGTH_SHORT).show()
                } else {
                    adapter.setComics(it)
                }
            })
    }

    private fun setAdapterClickListener(): ComicListAdapter.OnClickListener {
        return object : ComicListAdapter.OnClickListener {
            override fun onClickItemListener(comic: ComicDataEntity) {
                val bundle = Bundle()
                comic.id?.let { bundle.putInt("comicId", it) }
                findNavController().navigate(R.id.secondFragment, bundle)
            }

        }
    }


}