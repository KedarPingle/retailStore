package com.mo.retailStore.model;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bill_product")
public class BillProductEntity {

	@EmbeddedId
	private BillProductId billProductId;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "total_cost")
	private Double totalCost;

	@Column(name = "total_tax")
	private Double totalTax;

	public BillProductEntity() {}

	public BillProductId getBillProductId() {
		return billProductId;
	}

	public void setBillProductId(BillProductId billProductId) {
		this.billProductId = billProductId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
	}
}