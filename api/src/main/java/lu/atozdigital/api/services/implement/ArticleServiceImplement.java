package lu.atozdigital.api.services.implement;

import org.springframework.beans.factory.annotation.Autowired;

import lu.atozdigital.api.dto.ArticleDTO;
import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.services.ArticleService;

public class ArticleServiceImplement implements ArticleService {
	
	@Autowired
	ArticleRepository articleRepository;

	
	@Override
    public Article convertDtoToArticle(ArticleDTO articleDTO) {
        Article article = new Article();
        if(articleDTO.getId()!= null) article.setId(articleDTO.getId());
        article.setName(articleDTO.getName());
        article.setPrice(articleDTO.getPrice());
        article.setPicture(articleDTO.getPicture());
        return article;
    }
	
	@Override
    public ArticleDTO convertArticleToDto(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setName(article.getName());
        articleDTO.setPrice(article.getPrice());
        articleDTO.setPicture(article.getPicture());    
        return articleDTO;
    }
	
	@Override
    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        Article article  = convertDtoToArticle(articleDTO);
        return convertArticleToDto(articleRepository.save(article));
    }

}
