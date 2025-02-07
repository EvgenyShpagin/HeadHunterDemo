package com.demo.hh.feature.main.data.repository

import com.demo.hh.core.model.Offer
import com.demo.hh.feature.main.domain.repository.OfferRepository
import com.demo.hh.feature.main.ui.main.PreviewOfferList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OfferRepositoryImpl : OfferRepository {
    override fun getAll(): Flow<List<Offer>> {
        return flow {
            emit(PreviewOfferList)
        }
    }
}