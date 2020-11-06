package projectdemo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productName")
public class Product {
	
	private int id;
	private String productImage;
	private String productName;
	private String categoryName;
	private String VendorName;
	private String costPrice;
	private String retailPrice;
	private String inventory;
	private Date productCreationDate;
	private Date productlastUpdatedDate;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name ="id", unique = true, nullable =false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getVendorName() {
		return VendorName;
	}
	public void setVendorName(String vendorName) {
		VendorName = vendorName;
	}
	public String getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}
	public String getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getInventory() {
		return inventory;
	}
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	public Date getProductCreationDate() {
		return productCreationDate;
	}
	public void setProductCreationDate(Date productCreationDate) {
		this.productCreationDate = productCreationDate;
	}
	public Date getProductlastUpdatedDate() {
		return productlastUpdatedDate;
	}
	public void setProductlastUpdatedDate(Date productlastUpdatedDate) {
		this.productlastUpdatedDate = productlastUpdatedDate;
	}
	
	
	
	
	

}
