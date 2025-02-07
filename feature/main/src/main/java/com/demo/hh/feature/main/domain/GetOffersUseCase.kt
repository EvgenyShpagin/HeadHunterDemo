package com.demo.hh.feature.main.domain

import com.demo.hh.core.common.network.FetchError
import com.demo.hh.core.common.result.Result
import com.demo.hh.core.model.Offer
import com.demo.hh.feature.main.domain.repository.OfferRepository
import kotlinx.coroutines.flow.Flow

class GetOffersUseCase(private val offerRepository: OfferRepository) {
    operator fun invoke(): Flow<Result<List<Offer>, FetchError>> {
        return offerRepository.getAll()
    }
}
