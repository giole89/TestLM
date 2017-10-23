package org.gio.lmTest.bean;

import org.gio.lmTest.enumeration.Tax;

public class Product {

	private static final int AROUND_DECIMAL = 2;
	private String name;
	private Double price;
	private Tax tax;

	public Product(String name, Double price, Tax tax) {
		super();
		this.name = name;
		this.price = price;
		this.tax = tax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public Double taxedPrice() {
		double value = price + (price * tax.getValue());
		double pow = Math.pow(10, AROUND_DECIMAL);
		return Math.round(value * pow) / pow;
	}

}
