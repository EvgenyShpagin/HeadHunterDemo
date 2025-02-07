package com.demo.hh.core.domain.repository

import com.demo.hh.core.common.network.ConnectionError
import com.demo.hh.core.common.network.FetchError
import com.demo.hh.core.common.result.Result
import com.demo.hh.core.model.Vacancy
import kotlinx.coroutines.flow.Flow


interface VacancyRepository {
    fun getRelevant(count: Int = Int.MAX_VALUE): Flow<Result<List<Vacancy>, FetchError>>
    fun getRelevantCount(): Flow<Result<Int, FetchError>>
    suspend fun setFavorite(id: String, favorite: Boolean): Result<Unit, ConnectionError>
}