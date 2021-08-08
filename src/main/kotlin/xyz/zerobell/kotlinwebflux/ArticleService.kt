package xyz.zerobell.kotlinwebflux

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class ArticleService(val articleRepository: ArticleRepository) {
    suspend fun createArticle(command: CreateArticleCommand) {
        articleRepository.save(Article(null, command.title, command.author, command.content))
    }

    suspend fun readArticles(): Flow<ArticleVO> {
        return articleRepository.findAll().map { ArticleVO(it.id!!, it.title, it.author, it.content) }
    }
}