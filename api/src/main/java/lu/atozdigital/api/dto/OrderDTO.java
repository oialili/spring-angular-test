package lu.atozdigital.api.dto;

import java.sql.Date;
import java.util.List;

import lu.atozdigital.api.entities.Article;


public class OrderDTO {
	
	private Long id;
    private String reference;
    private Date date;
    private List<Article> articles;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Article> getArticles() {
		return articles;
	}
	
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public OrderDTO(Long id, String reference, Date date, List<Article> articles) {
		super();
		this.id = id;
		this.reference = reference;
		this.date = date;
		this.articles = articles;
	}
	
	public OrderDTO() {
		
	}

    
}
