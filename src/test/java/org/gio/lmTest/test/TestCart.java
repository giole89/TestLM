package org.gio.lmTest.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.gio.lmTest.bean.Cart;
import org.gio.lmTest.bean.Product;
import org.gio.lmTest.bean.QuantityProduct;
import org.gio.lmTest.enumeration.Tax;
import org.gio.lmTest.utiity.Receipt;
import org.junit.jupiter.api.Test;

class TestCart {

	@Test
	void testInOne() {
		Product productBook = new Product("Book", 12.49, Tax.TAX_0);
		Product productCd = new Product("Music CD", 14.99, Tax.TAX_10);
		Product productChocolate = new Product("Chocolate", 0.85, Tax.TAX_0);

		QuantityProduct quantityBook = new QuantityProduct(1, productBook);
		QuantityProduct quantityCd = new QuantityProduct(1, productCd);
		QuantityProduct quantityChocolate = new QuantityProduct(1, productChocolate);
		List<QuantityProduct> quantityList = new ArrayList<QuantityProduct>();
		quantityList.add(quantityBook);
		quantityList.add(quantityCd);
		quantityList.add(quantityChocolate);
		Cart cart = new Cart(quantityList);
		Receipt receipt = new Receipt(cart);

		for (QuantityProduct quantityProduct : quantityList) {
			System.out.println(quantityProduct.getQuantity() + " " + quantityProduct.getProduct().getName() + " "
					+ quantityProduct.getProduct().taxedPrice());
		}
		System.out.println("Sales Taxes: " + receipt.taxSell());
		System.out.println("TOTAL: " + receipt.getTotalPrice());

		assertEquals("TEST IN1", new BigDecimal(29.83).setScale(2, RoundingMode.HALF_EVEN), receipt.getTotalPrice());
	}

	@Test
	void testInTwo() {
		Product productChocolate = new Product("imported box of chocolates", 10.00, Tax.TAX_5);
		Product productPerfume = new Product("imported bottle of perfume", 47.50, Tax.TAX_15);

		QuantityProduct quantityChocolate = new QuantityProduct(1, productChocolate);
		QuantityProduct quantityPerfume = new QuantityProduct(1, productPerfume);
		List<QuantityProduct> quantityList = new ArrayList<QuantityProduct>();
		quantityList.add(quantityChocolate);
		quantityList.add(quantityPerfume);
		Cart cart = new Cart(quantityList);
		Receipt receipt = new Receipt(cart);

		for (QuantityProduct quantityProduct : quantityList) {
			System.out.println(quantityProduct.getQuantity() + " " + quantityProduct.getProduct().getName() + " "
					+ quantityProduct.getProduct().taxedPrice());
		}
		System.out.println("Sales Taxes: " + receipt.taxSell());
		System.out.println("TOTAL: " + receipt.getTotalPrice());

		assertEquals("TEST IN2", new BigDecimal(65.13).setScale(2, RoundingMode.HALF_EVEN), receipt.getTotalPrice());
	}

	@Test
	void testInThree() {

		Product productPerfumeImport = new Product("imported bottle of perfume", 27.99, Tax.TAX_15);
		Product productPerfume = new Product("bottle of perfume", 18.99, Tax.TAX_10);
		Product productPills = new Product("packet of headache pills", 9.75, Tax.TAX_0);
		Product productChocolate = new Product("box of imported chocolates ", 11.25, Tax.TAX_5);

		QuantityProduct quantityPerfumeImport = new QuantityProduct(1, productPerfumeImport);
		QuantityProduct quantityPerfume = new QuantityProduct(1, productPerfume);
		QuantityProduct quantityPills = new QuantityProduct(1, productPills);
		QuantityProduct quantityChocolate = new QuantityProduct(1, productChocolate);
		List<QuantityProduct> quantityList = new ArrayList<QuantityProduct>();
		quantityList.add(quantityPerfumeImport);
		quantityList.add(quantityPerfume);
		quantityList.add(quantityPills);
		quantityList.add(quantityChocolate);

		Cart cart = new Cart(quantityList);
		Receipt receipt = new Receipt(cart);

		for (QuantityProduct quantityProduct : quantityList) {
			System.out.println(quantityProduct.getQuantity() + " " + quantityProduct.getProduct().getName() + " "
					+ quantityProduct.getProduct().taxedPrice());
		}
		System.out.println("Sales Taxes: " + receipt.taxSell());
		System.out.println("TOTAL: " + receipt.getTotalPrice());

		assertEquals("TEST IN3", new BigDecimal(74.64).setScale(2, RoundingMode.HALF_EVEN), receipt.getTotalPrice());
	}

}