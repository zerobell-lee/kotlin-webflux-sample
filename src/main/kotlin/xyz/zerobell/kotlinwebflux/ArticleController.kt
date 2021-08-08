package xyz.zerobell.kotlinwebflux

import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ArticleController(val articleService: ArticleService) {

    @GetMapping("articles")
    suspend fun getAllArticles(): Flow<ArticleVO> {
        return articleService.readArticles()
    }

    @PostMapping("article")
    suspend fun addArticle(@RequestBody command: CreateArticleCommand) {
        articleService.createArticle(command)
    }
}