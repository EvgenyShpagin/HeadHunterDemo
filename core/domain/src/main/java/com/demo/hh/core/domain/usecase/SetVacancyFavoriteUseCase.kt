package com.demo.hh.core.domain.usecase

import com.demo.hh.core.common.network.ConnectionError
import com.demo.hh.core.common.result.Result
import com.demo.hh.core.domain.repository.VacancyRepository

class SetVacancyFavoriteUseCase(
    private val repository: VacancyRepository
) {
    suspend operator fun invoke(
        vacancyId: String,
        favorite: Boolean
    ): Result<Unit, ConnectionError> {
        return repository.setFavorite(vacancyId, favorite)
    }
}
