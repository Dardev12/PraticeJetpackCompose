package com.dardev.cryptoapp.domain.repository

import com.dardev.cryptoapp.data.remote.dto.CoinDetailDto
import com.dardev.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId:String):CoinDetailDto
}