package org.gio.lmTest.enumeration;

public enum Tax {
	TAX_0(0.0), TAX_5(0.05), TAX_10(0.1), TAX_15(0.15);

	private Double value;

	private Tax(Double value) {
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
