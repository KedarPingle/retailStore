package com.mo.retailStore.model;



import java.io.IOException;
import java.util.List;

public class Purchase {

	private String customerName;
    private List<Product> products;

    /*
     * Public constructor
     */
    public Purchase() {}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}

