package com.dardev.cryptoapp.domain.use_case.get_coins

import com.dardev.cryptoapp.common.Resource
import com.dardev.cryptoapp.data.remote.dto.toCoin
import com.dardev.cryptoapp.domain.model.Coin
import com.dardev.cryptoapp.domain.model.CoinDetail
import com.dardev.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin()}
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e:HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e:IOException){
            emit(Resource.Error<List<Coin>>("N'arrive pas à communiquer avec le serveur. Vérifier votre connexion"))
        }
    }

}