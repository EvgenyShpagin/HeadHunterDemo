package com.demo.hh.feature.main.domain.repository

import com.demo.hh.core.model.Offer
import kotlinx.coroutines.flow.Flow

interface OfferRepository {
    fun getAll(): Flow<List<Offer>>
}