package ar.edu.unju.fi.tpf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table(name="PRODUCTS")
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_code")
	private long productCode;
	
	@Column(name="prod_name")
	private String productName;
	
	//Relacion producto a linea de producto - muchos a uno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "prodL_productLine")
	private ProductLine productLine;
	
	@Column(name="prod_scale")
	private double productScale;
	
	@Column(name="prod_vendor")
	private String productVendor;
	
	@Column(name="prod_description")
	private String productDescription;
	
	@Column(name="prod_stock")
	private int quantityInStock;
	
	@Column(name="prod_price")
	private double buyPrice;

	
	
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	public double getProductScale() {
		return productScale;
	}

	public void setProductScale(double productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	
}
