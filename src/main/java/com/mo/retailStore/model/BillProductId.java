package com.mo.retailStore.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class BillProductId implements Serializable {

	@OneToOne
	private BillEntity billEntity;

	@ManyToOne
	private ProductEntity productEntity;

	public BillProductId(BillEntity billEntity, ProductEntity productEntity) {
		this.billEntity = billEntity;
		this.productEntity = productEntity;
	}

	public BillProductId() {}

	public BillEntity getBillEntity() {
		return billEntity;
	}

	public void setBillEntity(BillEntity billEntity) {
		this.billEntity = billEntity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
}