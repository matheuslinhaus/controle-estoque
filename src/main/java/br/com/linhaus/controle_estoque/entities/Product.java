package br.com.linhaus.controle_estoque.entities;

import java.util.Objects;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public class Product {

	@NotEmpty(message = "The description is required and cannot be empty.")
	@Size(min = 4, max = 100, message = "The description must be between 4 and 100 characters long.")
	private String description;
	private String fullDescription;
	@Min(value = 1, message = "The price must be greater than zero.")
	private Double price;
	@Min(value = 1, message = "The quantity must be greater than zero.")
	private Integer quantity;
	private String urlImage;

	public Product() {

	}

	public Product(String description, String fullDescription, Double price, Integer quantity, String urlImage) {
		this.description = description;
		this.fullDescription = fullDescription;
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
		return Objects.hash(description, fullDescription, price, quantity, urlImage);
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
		return Objects.equals(description, other.description) && Objects.equals(fullDescription, other.fullDescription)
				&& Objects.equals(price, other.price) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(urlImage, other.urlImage);
	}

	@Override
	public String toString() {
		return "Product [description=" + description + ", fullDescription=" + fullDescription + ", price=" + price
				+ ", quantity=" + quantity + ", urlImage=" + urlImage + "]";
	}
}