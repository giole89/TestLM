package org.gio.lmTest.utiity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.gio.lmTest.bean.Cart;
import org.gio.lmTest.bean.QuantityProduct;

public class Receipt {

	private Cart cart;

	public Receipt(Cart cart) {
		super();
		this.cart = cart;
	}

	public BigDecimal taxSell() {

		List<QuantityProduct> quantityList = cart.getQuantityList();
		Double totalTax = 0.0;
		for (QuantityProduct quantity : quantityList) {
			Double prezzo = quantity.getProduct().getPrice();
			Double taxedPrice = quantity.getProduct().taxedPrice();
			int quantityProduct = quantity.getQuantity();

			totalTax += taxedPrice * quantityProduct - prezzo * quantityProduct;
		}
		return new BigDecimal(totalTax).setScale(2, RoundingMode.HALF_EVEN);
	}

	public BigDecimal getTotalPrice() {
		List<QuantityProduct> quantityList = cart.getQuantityList();
		Double total = 0.0;
		for (QuantityProduct quantity : quantityList) {
			Double taxedPrice = quantity.getProduct().taxedPrice();
			int quantityProduct = quantity.getQuantity();

			total += taxedPrice * quantityProduct;
		}
		return new BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN);
	}
}
