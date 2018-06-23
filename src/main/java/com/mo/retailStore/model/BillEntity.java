package com.mo.retailStore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.Serializable;


@Entity
@Table(name = "bill")
public class BillEntity implements Serializable {

	@Id
	@GeneratedValue
    @Column(name = "id")
    private long id;

	@Column(name = "customer_name")
	private String customerName;

    @Column(name = "total_cost")
    private long totalCost;

    @Version
    @Column(name = "version")
    private long version;


    public BillEntity() {}

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}