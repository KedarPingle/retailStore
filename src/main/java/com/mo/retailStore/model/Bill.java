package com.mo.retailStore.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bill {

	private long id;
	private String customerName;
    private long totalCost;
    private long version;


    /**
     * Get a segment based a segment entity
     *
     * @param billEntity
     * @return
     * @throws IOException
     */
    public static Bill getBill(BillEntity billEntity) {
    	Bill bill = new Bill();
    	bill.setId(billEntity.getId());
    	bill.setCustomerName(billEntity.getCustomerName());
    	bill.setTotalCost(billEntity.getTotalCost());
    	bill.setVersion(billEntity.getVersion());
    	return bill;
    }

	/**
	 * Get a segment based a segment entity
	 *
	 * @param bill
	 * @return
	 * @throws IOException
	 */
	public static BillEntity getBillEntity(Bill bill) {
		BillEntity billEntity = new BillEntity();
		billEntity.setId(bill.getId());
		billEntity.setTotalCost(bill.getTotalCost());
		billEntity.setVersion(billEntity.getVersion());
		return billEntity;
	}


    /*
     * Public constructor
     */
    public Bill() {}

    public Bill(String customerName) {
    	this.customerName = customerName;
    	this.setTotalCost(0);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	public long getVersion() {
		return version;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}

