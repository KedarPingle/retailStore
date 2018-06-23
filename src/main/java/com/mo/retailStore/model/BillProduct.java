package com.mo.retailStore.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillProduct {

	private String productName;
    private Long productQuantity;
    private Double itemCost;
    private String tax;
    private Double taxAmount;
	private Double itemTotalCost;

	/**
     * Get a segment based a segment entity
     *
     * @param billProductEntity
     * @return
     * @throws IOException
     */
    public static BillProduct getBillProduct(BillProductEntity billProductEntity) {
    	BillProduct billProduct = new BillProduct();
		billProduct.setProductName(billProductEntity.getBillProductId().getProductEntity().getName());
		billProduct.setProductQuantity(billProductEntity.getQuantity());
		billProduct.setItemTotalCost(billProductEntity.getTotalCost());
		billProduct.setTaxAmount(billProductEntity.getTotalTax());
		billProduct.setItemCost(Double.valueOf(billProductEntity.getBillProductId().getProductEntity().getCost()));
		billProduct.setTax((billProductEntity.getBillProductId().getProductEntity().getCategoryEntity().getTax() * 100) + "%");
    	return billProduct;
    }

    /*
     * Public constructor
     */
    public BillProduct() {}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Double getItemTotalCost() {
		return itemTotalCost;
	}

	public void setItemTotalCost(Double itemTotalCost) {
		this.itemTotalCost = itemTotalCost;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getItemCost() {
		return itemCost;
	}

	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}
}

