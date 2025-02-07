package com.demo.hh.di

import com.demo.hh.feature.main.di.mainModule
import org.koin.dsl.module

val appModule = module {
    includes(mainModule)
}