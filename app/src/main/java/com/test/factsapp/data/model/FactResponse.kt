package com.test.factsapp.data.model

class FactResponse : ArrayList<FactResponseItem>()

data class FactResponseItem(
    val fact: String
)