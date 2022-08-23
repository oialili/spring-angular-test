package lu.atozdigital.api.dto;

public class ArticleDTO {
	
	private Long id;
    private String name;
    private Double price;
    private String picture;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public ArticleDTO(Long id, String name, Double price, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.picture = picture;
	}
	
	public ArticleDTO() {
	}

}
