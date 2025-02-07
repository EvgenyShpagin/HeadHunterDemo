package com.demo.hh.core.domain.usecase

import com.demo.hh.core.common.network.FetchError
import com.demo.hh.core.common.result.Result
import com.demo.hh.core.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow

class GetRelevantVacancyCountUseCase(
    private val repository: VacancyRepository
) {
    operator fun invoke(): Flow<Result<Int, FetchError>> {
        return repository.getRelevantCount()
    }
}