package lu.atozdigital.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lu.atozdigital.api.dto.ArticleDTO;
import lu.atozdigital.api.entities.Article;

@Service
public interface ArticleService {
	public ArticleDTO saveArticle(ArticleDTO articleDTO);
	public Article convertDtoToArticle(ArticleDTO articleDTO);
    public ArticleDTO convertArticleToDto(Article article);
    public List<ArticleDTO> AllArticles();

}
