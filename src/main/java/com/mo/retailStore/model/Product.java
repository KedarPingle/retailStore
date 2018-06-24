package com.mo.retailStore.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	private Long id;
	private String name;
	private Long cost;
	private CategoryNameEnum categoryName;
	private long version;
    /**
     * Get a Product
     *
     * @param productEntity
     * @return
     * @throws IOException
     */
    public static Product getProduct(ProductEntity productEntity) {
    	Product product = new Product();
    	product.setId(productEntity.getId());
    	product.setCost(productEntity.getCost());
    	product.setName(productEntity.getName());
    	product.setVersion(productEntity.getVersion());
    	product.setCategoryName(productEntity.getCategoryEntity().getName());
    	return product;
    }

    /*
     * Public constructor
     */
    public Product() {}

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

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	public CategoryNameEnum getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(CategoryNameEnum categoryName) {
		this.categoryName = categoryName;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}

