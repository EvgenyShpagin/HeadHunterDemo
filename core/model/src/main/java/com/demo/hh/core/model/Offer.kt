package com.demo.hh.core.model

data class Offer(
    val id: String,
    val title: String,
    val link: String,
    val action: String? = null
)