package com.demo.hh.core.domain.usecase

import com.demo.hh.core.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow

class GetRelevantVacancyCountUseCase(
    private val repository: VacancyRepository
) {
    operator fun invoke(): Flow<Int> {
        return repository.getRelevantCount()
    }
}