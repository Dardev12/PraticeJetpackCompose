package com.dardev.cryptoapp.presentation.coin_detail

import com.dardev.cryptoapp.domain.model.Coin
import com.dardev.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin: CoinDetail? = null,
    val error:String=""
)
