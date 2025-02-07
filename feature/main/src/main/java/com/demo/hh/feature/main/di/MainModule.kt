package com.demo.hh.feature.main.di

import com.demo.hh.core.data.repository.VacancyRepositoryImpl
import com.demo.hh.core.domain.repository.VacancyRepository
import com.demo.hh.core.domain.usecase.GetRelevantVacanciesUseCase
import com.demo.hh.core.domain.usecase.GetRelevantVacancyCountUseCase
import com.demo.hh.core.domain.usecase.SetVacancyFavoriteUseCase
import com.demo.hh.core.ui.util.VacancyCardUiStateMapper
import com.demo.hh.core.ui.util.VacancyCardUiStateMapperImpl
import com.demo.hh.feature.main.data.repository.OfferRepositoryImpl
import com.demo.hh.feature.main.domain.GetOffersUseCase
import com.demo.hh.feature.main.domain.repository.OfferRepository
import com.demo.hh.feature.main.ui.main.MainViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val mainModule = module {
    includes(dataModule, domainModule)
    single<VacancyCardUiStateMapper> { VacancyCardUiStateMapperImpl(get()) }
    viewModelOf(::MainViewModel)
}

private val domainModule = module {
    factoryOf(::GetOffersUseCase)
    factoryOf(::GetRelevantVacanciesUseCase)
    factoryOf(::GetRelevantVacancyCountUseCase)
    factoryOf(::SetVacancyFavoriteUseCase)
}

private val dataModule = module {
    single<VacancyRepository> { VacancyRepositoryImpl() }
    single<OfferRepository> { OfferRepositoryImpl() }
}