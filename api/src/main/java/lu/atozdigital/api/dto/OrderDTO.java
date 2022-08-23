package lu.atozdigital.api.dto;

import java.sql.Date;


public class OrderDTO {
	
	private Long id;
    private String reference;
    private Date date;
    private String article;
    
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
	
	public String getArticle() {
		return article;
	}
	
	public void setArticle(String article) {
		this.article = article;
	}
	
	public OrderDTO(Long id, String reference, Date date, String article) {
		super();
		this.id = id;
		this.reference = reference;
		this.date = date;
		this.article = article;
	}
	
	public OrderDTO() {
		
	}

    
}
