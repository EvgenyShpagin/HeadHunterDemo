package com.demo.hh.core.domain.usecase

import com.demo.hh.core.domain.repository.VacancyRepository
import com.demo.hh.core.model.Vacancy
import kotlinx.coroutines.flow.Flow

class GetRelevantVacanciesUseCase(
    private val repository: VacancyRepository
) {
    operator fun invoke(count: Int = Int.MAX_VALUE): Flow<List<Vacancy>> {
        require(count > 0)
        return repository.getRelevant(count)
    }
}