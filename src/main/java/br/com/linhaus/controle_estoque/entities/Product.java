package br.com.linhaus.controle_estoque.entities;

import java.util.Objects;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Product {

	private String description;
	private String fullDescription;
	private String brand;
	private Double price;
	private Integer quantity;
	private String urlImage;

	public Product() {

	}

	public Product(String description, String fullDescription, String brand, Double price, Integer quantity,
			String urlImage) {
		this.description = description;
		this.fullDescription = fullDescription;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
		this.urlImage = urlImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(description, other.description);
	}

	@Override
	public String toString() {
		return "Product [description=" + description + ", fullDescription=" + fullDescription + ", brand=" + brand
				+ ", price=" + price + ", quantity=" + quantity + ", urlImage=" + urlImage + "]";
	}
}