package com.demo.hh.core.domain.usecase

import com.demo.hh.core.domain.repository.VacancyRepository

class SetVacancyFavoriteUseCase(
    private val repository: VacancyRepository
) {
    suspend operator fun invoke(vacancyId: String, favorite: Boolean) {
        return repository.setFavorite(vacancyId, favorite)
    }
}