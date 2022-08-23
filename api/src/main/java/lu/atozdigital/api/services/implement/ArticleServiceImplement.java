package lu.atozdigital.api.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.atozdigital.api.dto.ArticleDTO;
import lu.atozdigital.api.entities.Article;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.services.ArticleService;

@Service
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

	@Override
    public List<ArticleDTO> AllArticles(){
        List<Article> articles = articleRepository.findAll();
        List<ArticleDTO> articleDTO = new ArrayList<>();
        articles.forEach(article -> {
            articleDTO.add(convertArticleToDto(article));
        });
        return articleDTO;
    }
	
	@Override
    public ArticleDTO findArticleById(Long id) {
		Optional<Article> optional = articleRepository.findById(id);
		if(optional.isPresent()) {
			return convertArticleToDto(optional.get());
		}
		return null;	
    }
}
