package com.mo.retailStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.Serializable;


@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {

	@Id
	@GeneratedValue
    @Column(name = "id")
    private long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "name")
	private CategoryNameEnum name;

    @Column(name = "sales_tax")
    private double tax;

    @Version
    @Column(name = "version")
    private long version;


    public CategoryEntity() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public CategoryNameEnum getName() {
		return name;
	}

	public void setName(CategoryNameEnum name) {
		this.name = name;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}