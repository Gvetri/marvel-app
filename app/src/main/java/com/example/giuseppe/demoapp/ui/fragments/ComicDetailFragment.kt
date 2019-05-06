package com.example.giuseppe.demoapp.ui.fragments


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.giuseppe.demoapp.R
import com.example.giuseppe.demoapp.data.network.response.ComicResponse
import com.example.giuseppe.demoapp.databinding.FragmentComicDetailBinding
import com.example.giuseppe.demoapp.di.Injectable
import com.example.giuseppe.demoapp.ui.base.BaseFragment
import com.example.giuseppe.demoapp.viewmodel.ComicDetailViewModel
import com.example.giuseppe.demoapp.viewmodel.ViewModelFactory
import javax.inject.Inject

class ComicDetailFragment : BaseFragment(), Injectable {

    @set:Inject
    var viewModelFactory: ViewModelFactory? = null

    private lateinit var viewModel: ComicDetailViewModel
    private lateinit var binding: FragmentComicDetailBinding

    private var selectedComicId: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comic_detail, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ComicDetailViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedComicId = arguments?.get("comicId") as Int
        viewModel.getComicDetail(selectedComicId).observe(this, Observer {
            it?.let { comic -> setSelectedComic(comic) }
        })
    }

    private fun setSelectedComic(comic: ComicResponse) {
        binding.tvTitle.text = comic.title
        binding.tvPages.text = comic.pageCount.plus(" Pages")
        setComicPrices(comic)
        setComicImages(comic)
        setCharacters(comic)
    }

    private fun setCharacters(comic: ComicResponse) {
        val stringBuilder = StringBuilder()
        comic.characters.items?.forEach {
            stringBuilder.append(it.name).appendln()
        }
        binding.tvCharacters.text = stringBuilder.toString()
    }

    private fun setComicImages(comic: ComicResponse) {
        if (!comic.images.isNullOrEmpty())
            Glide.with(this)
                .load(comic.images.first().path + "." + comic.images.first().extension)
                .into(binding.imageView)
    }

    private fun setComicPrices(comic: ComicResponse) {
        if (!comic.prices.isNullOrEmpty())
            binding.tvPrice.text = comic.prices.first().price.toString().plus("$")
    }


}
