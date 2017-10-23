package org.gio.lmTest.utiity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.gio.lmTest.bean.Cart;
import org.gio.lmTest.bean.Product;
import org.gio.lmTest.bean.QuantityProduct;
import org.gio.lmTest.enumeration.Tax;

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

	public static void main(String[] args) {
		Product product = new Product("Libro", 14.99, Tax.TAX_5);
		Product productDUE = new Product("CD", 100.00, Tax.TAX_10);

		QuantityProduct quantity = new QuantityProduct(1, product);
		QuantityProduct quantityDue = new QuantityProduct(1, productDUE);
		List<QuantityProduct> quantityList = new ArrayList<QuantityProduct>();
		quantityList.add(quantity);
		quantityList.add(quantityDue);
		Cart cart = new Cart(quantityList);
		Receipt receipt = new Receipt(cart);

		for (QuantityProduct quantityProduct : quantityList) {
			System.out.println(quantityProduct.getQuantity() + " " + quantityProduct.getProduct().getName() + " "
					+ quantityProduct.getProduct().taxedPrice());
		}
		System.out.println("Sales Taxes: " + receipt.taxSell());
		System.out.println("TOTAL: " + receipt.getTotalPrice());
	}
}
