package com.example.tp3;

public class Product {

	private String ID;
	private String name;
	private String price;
	private String expirationDate;

	public Product(String iD, String name, String price, String expirationString) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.expirationDate = expirationString;
	}

	public Product() {
		super();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getExpirationString() {
		return expirationDate;
	}

	public void setExpirationString(String expirationString) {
		this.expirationDate = expirationString;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", price=" + price + ", expirationString=" + expirationDate
				+ "]";
	}

}

