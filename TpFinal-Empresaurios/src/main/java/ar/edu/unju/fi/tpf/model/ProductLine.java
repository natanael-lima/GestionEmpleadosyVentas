package ar.edu.unju.fi.tpf.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table(name="PRODUCTLINES")
@Entity
public class ProductLine {
	@Id
	@Column(name="prodL_productlineId")
	private Long productLineId;
	
	@Column(name="prodL_textdescription")
	private String textDescription;
	
	@Column(name="prodL_htmldescription")
	private String htmlDescription;
	
	@Column(name="prodL_image")
	private byte[] image; //?
	
	//Relacion producto a linea de producto - uno a muchos
	@OneToMany(mappedBy = "productLine")
	private List<Product> product;
	
	
	
	public ProductLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getProductLineId() {
		return productLineId;
	}

	public void setProductLine(Long productLineId) {
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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setProductLineId(Long productLineId) {
		this.productLineId = productLineId;
	}

	@Override
	public String toString() {
		return "ProductLine [productLineId=" + productLineId + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + ", image=" + Arrays.toString(image) + ", product=" + product
				+ "]";
	}
	
	
	
}
