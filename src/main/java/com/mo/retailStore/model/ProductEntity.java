package com.mo.retailStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.Serializable;


@Entity
@Table(name = "product")
public class ProductEntity implements Serializable {

	@Id
	@GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

	@Column(name = "cost")
	private Long cost;

	@OneToOne
	private CategoryEntity categoryEntity;


	@Version
    @Column(name = "version")
    private long version;


    public ProductEntity() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}