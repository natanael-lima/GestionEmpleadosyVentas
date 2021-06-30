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
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	@NotEmpty(message = "Campo Obligatorio")
	private String productName;
	
	//Relacion producto a linea de producto - muchos a uno
	@Valid
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "prodL_productLine")
	private ProductLine productLine;
	
	@Column(name="prod_scale")
	@NotNull(message = "Campo Obligatorio")
	@Min(value=1, message="Numero no valido")
	private double productScale;
	
	@Column(name="prod_vendor")
	@NotEmpty(message = "Campo Obligatorio")
	private String productVendor;
	
	@Column(name="prod_description")
	@NotEmpty(message = "Campo Obligatorio")
	private String productDescription;
	
	@Column(name="prod_stock")
	@NotNull(message = "Campo Obligatorio")
	@Min(value=1, message="Numero no valido")
	private int quantityInStock;
	
	@Column(name="prod_price")
	@NotNull(message = "Campo Obligatorio")
	@Min(value=35, message="Numero no valido")
	private double buyPrice;
	

	
	public Product() {
		super();
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


	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + "]";
	}

	
	
	
}
