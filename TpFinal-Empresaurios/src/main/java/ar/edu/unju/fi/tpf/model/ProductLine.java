package ar.edu.unju.fi.tpf.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Table(name="PRODUCTLINES")
@Entity
public class ProductLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prodL_productlineId")
	private long productLineId;
	
	@Column(name="prodL_textdescription")
	private String textDescription;
	
	@Column(name="prodL_htmldescription")
	private String htmlDescription;
	
	@Column(name="prodL_image")
	private String image; 
	
	//Relacion producto a linea de producto - uno a muchos
	@Autowired
	@OneToMany(mappedBy = "productLine")
	private List<Product> product;
	
	
	
	public ProductLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getProductLineId() {
		return productLineId;
	}

	public void setProductLineId(long productLineId) {
		this.productLineId = productLineId;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductLine [productLineId=" + productLineId + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + ", image=" + image + ", product=" + product + "]";
	}

	
	
	
}
