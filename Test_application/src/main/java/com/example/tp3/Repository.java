package com.example.tp3;


import java.util.ArrayList;
import java.util.List;




public class Repository {

	private String ID;
	private List<Product> products;
	
	public Repository() {
		super();
		this.products = new ArrayList<>();
	}

	public Repository(String iD, List<Product> products) {
		super();
		ID = iD;
		this.products = products;
	}

	public String getID() {
		//read
		return ID;
	}

	public void setID(String iD) {
		//write
		ID = iD;
	}

	public List<Product> getProducts() {
		//read
		return products;
	}

	public void setProducts(List<Product> products) {
		//write
		this.products = products;
	}

	public Product fetchProduct(String ID) throws ProductNotFoundException {
		//read
		for (Product product : products) {
			if (product.getID().equals(ID)) {
				return product;
			}
		}
		throw new ProductNotFoundException("No product with the provided ID exists.");
	}

	public Product addProduct(Product product) throws ProductAlreadyExistException {
		//write
		try {
			this.fetchProduct(product.getID());
			throw new ProductAlreadyExistException("A product with the same ID already exists.");
		} catch (ProductNotFoundException e) {
			products.add(product);
			return product;
		}
	}

	public Product deleteProduct(String ID) throws ProductNotFoundException {
		//write
		Product p = this.fetchProduct(ID);
		products.remove(p);
		return p;
	}

	public Product updateProduct(Product product) throws ProductNotFoundException, ProductAlreadyExistException {
		//write
		this.deleteProduct(product.getID());
		this.addProduct(product);
		return product;
	}

	public void diplayProducts() {
		//read
		
		StringBuilder sb = new StringBuilder();
		sb.append("Printing products database :");
		sb.append('\n');
		for (Product product : products) {
			sb.append(product);
			sb.append('\n');
		}
		sb.append("End of printing.");
		System.out.println(sb.toString());
	}
}

