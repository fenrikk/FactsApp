package com.test.factsapp.data.model

data class FactResponse(val data: List<FactData>)

data class FactData(
    val fact: String
)