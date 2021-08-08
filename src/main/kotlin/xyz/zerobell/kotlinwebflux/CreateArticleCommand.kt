package xyz.zerobell.kotlinwebflux

data class CreateArticleCommand(val title: String, val author: String, val content: String) {
}