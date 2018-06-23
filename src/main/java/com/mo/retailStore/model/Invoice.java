package com.mo.retailStore.model;



import java.util.List;

public class Invoice {

	private String welcomeMessage;
	private long billId;
	private String customerName;
    private List<BillProduct> purchaseItems;
    private Double totalTax;
    private Double totalPayableAmount;

    /*
     * Public constructor
     */
    public Invoice() {}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public List<BillProduct> getPurchaseItems() {
		return purchaseItems;
	}

	public void setPurchaseItems(List<BillProduct> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}

	public Double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
	}

	public Double getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(Double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	public void calculateFinalBill() {
		this.totalTax = 0.0;
		this.totalPayableAmount = 0.0;
		for (BillProduct purchaseItem : this.purchaseItems) {
			this.totalTax = this.totalTax +  purchaseItem.getTaxAmount();
			this.totalPayableAmount = this.totalPayableAmount + purchaseItem.getTaxAmount() + purchaseItem.getItemTotalCost();
		}
	}
}

