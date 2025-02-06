package com.demo.hh.core.domain.repository

import com.demo.hh.core.model.Vacancy
import kotlinx.coroutines.flow.Flow


interface VacancyRepository {
    fun getRelevant(count: Int = Int.MAX_VALUE): Flow<List<Vacancy>>
    fun getRelevantCount(): Flow<Int>
    suspend fun setFavorite(id: String, favorite: Boolean)
}