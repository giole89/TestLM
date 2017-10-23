package org.gio.lmTest.bean;

import java.util.List;

public class Cart {

	private List<QuantityProduct> quantityList;

	public Cart(List<QuantityProduct> quantityList) {
		super();
		this.quantityList = quantityList;
	}

	public List<QuantityProduct> getQuantityList() {
		return quantityList;
	}

	public void setQuantityList(List<QuantityProduct> quantityList) {
		this.quantityList = quantityList;
	}

}
