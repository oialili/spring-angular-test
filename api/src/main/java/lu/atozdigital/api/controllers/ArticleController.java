package lu.atozdigital.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.atozdigital.api.dto.ArticleDTO;
import lu.atozdigital.api.services.ArticleService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@PostMapping(path = "")
    public ArticleDTO addArticle(@RequestBody ArticleDTO articleDTO) {
        return articleService.saveArticle(articleDTO);
    }
	
	@GetMapping(path = "")
    public List<ArticleDTO> getAllArticles() {
        return articleService.AllArticles();
    }
	
	@GetMapping(path ="/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable("id") Long id)  {
		ArticleDTO articleDTO = articleService.findArticleById(id);
        return new ResponseEntity<>(articleDTO, HttpStatus.OK);
    }
	

}
