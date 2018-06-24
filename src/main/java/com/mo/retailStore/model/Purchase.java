package com.mo.retailStore.model;


public class Purchase {

	private String billId;
    private String productId;
    private String quantity;

    /*
     * Public constructor
     */
    public Purchase() {}

	public Purchase(String billId, String productId, String quantity) {
    	this.setBillId(billId);
    	this.setQuantity(quantity);
    	this.setProductId(productId);
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}

