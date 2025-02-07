package com.demo.hh.feature.main.data.repository

import com.demo.hh.core.common.network.FetchError
import com.demo.hh.core.common.result.Result
import com.demo.hh.core.model.Offer
import com.demo.hh.feature.main.domain.repository.OfferRepository
import com.demo.hh.feature.main.ui.main.PreviewOfferList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OfferRepositoryImpl : OfferRepository {
    override fun getAll(): Flow<Result<List<Offer>, FetchError>> {
        return flow {
            emit(Result.Success(PreviewOfferList))
        }
    }
}