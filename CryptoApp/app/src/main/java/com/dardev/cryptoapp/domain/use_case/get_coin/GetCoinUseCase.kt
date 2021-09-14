package com.dardev.cryptoapp.domain.use_case.get_coin

import com.dardev.cryptoapp.common.Resource
import com.dardev.cryptoapp.data.remote.dto.toCoin
import com.dardev.cryptoapp.data.remote.dto.toCoinDetail
import com.dardev.cryptoapp.domain.model.Coin
import com.dardev.cryptoapp.domain.model.CoinDetail
import com.dardev.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e:HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e:IOException){
            emit(Resource.Error<CoinDetail>("N'arrive pas à communiquer avec le serveur. Vérifier votre connexion"))
        }
    }

}