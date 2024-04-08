package com.route.cleanarch_with_hilt.domain.entity

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)