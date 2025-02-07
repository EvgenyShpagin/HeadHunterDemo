package com.demo.hh.feature.main.domain.repository

import com.demo.hh.core.common.network.FetchError
import com.demo.hh.core.common.result.Result
import com.demo.hh.core.model.Offer
import kotlinx.coroutines.flow.Flow

interface OfferRepository {
    fun getAll(): Flow<Result<List<Offer>, FetchError>>
}