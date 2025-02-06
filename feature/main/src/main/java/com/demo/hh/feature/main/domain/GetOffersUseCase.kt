package com.demo.hh.feature.main.domain

import com.demo.hh.core.model.Offer
import com.demo.hh.feature.main.domain.repository.OfferRepository
import kotlinx.coroutines.flow.Flow

class GetOffersUseCase(private val offerRepository: OfferRepository) {
    operator fun invoke(): Flow<List<Offer>> {
        return offerRepository.getAll()
    }
}
