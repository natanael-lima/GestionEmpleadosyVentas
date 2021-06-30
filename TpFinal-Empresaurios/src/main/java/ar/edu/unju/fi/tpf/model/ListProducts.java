package ar.edu.unju.fi.tpf.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListProducts {

	private ArrayList<Product> products;
	
	

	public ListProducts(ArrayList<Product> products) {
		super();
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
}
