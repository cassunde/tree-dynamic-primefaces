package br.com.cassunde.bean.model;

import java.math.BigDecimal;

public class ItemOrcamento {
	
	private String client;
	private String address;
	private BigDecimal amount;
	
	public ItemOrcamento(String client, String address, BigDecimal amount) {
		super();
		this.client = client;
		this.address = address;
		this.amount = amount;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
