package xyz.zerobell.kotlinwebflux

import org.springframework.data.annotation.Id

data class Article(
    @Id val id: Long?,
    val title: String,
    val author: String,
    val content: String
) {
}