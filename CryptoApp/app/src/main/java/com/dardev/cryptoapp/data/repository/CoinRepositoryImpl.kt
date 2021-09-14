package com.dardev.cryptoapp.data.repository

import com.dardev.cryptoapp.data.remote.CoinPaprikaApi
import com.dardev.cryptoapp.data.remote.dto.CoinDetailDto
import com.dardev.cryptoapp.data.remote.dto.CoinDto
import com.dardev.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
):CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}