package com.example.ccm2.chuckNorris.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.ccm2.chuckNorris.model.ChuckNorrisRoom
import com.example.ccm2.chuckNorris.model.ChuckNorrisUi
import com.example.ccm2.chuckNorris.repository.ChuckNorrisQuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChuckNorrisViewModel : ViewModel() {

    private val mChuckNorrisQuoteRepository: ChuckNorrisQuoteRepository by lazy { ChuckNorrisQuoteRepository() }
    var mChuckNorrisQuoteLiveData: LiveData<List<ChuckNorrisUi>> =
        mChuckNorrisQuoteRepository.selectAllChuckNorrisQuote().map {
            it.toUi()
        }


    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            mChuckNorrisQuoteRepository.fetchData()
        }
    }




    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            mChuckNorrisQuoteRepository.deleteAllChuckNorrisQuote()
        }
    }
}


    private fun List<ChuckNorrisRoom>.toUi(): List<ChuckNorrisUi> {
        return asSequence().map {
            ChuckNorrisUi(
                quote = it.quote,
                iconUrl = it.iconUrl
            )
        }.toList()
}