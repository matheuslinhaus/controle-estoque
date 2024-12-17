package br.com.linhaus.controle_estoque.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Shoes extends Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "brand_id") // Isso mapeia a chave estrangeira
	@NotNull(message = "The brand is required and cannot be empty.")
	private Brand brand;
	@NotEmpty(message = "The color is required and cannot be empty.")
	private String color;
	@NotEmpty(message = "The size is required and cannot be empty.")
	private String size;

	public Shoes() {
		super();
	}

	public Shoes(String description, String fullDescription, Double price, Integer quantity, String urlImage, Long id,
			Brand brand, String color, String size) {
		super(description, fullDescription, price, quantity, urlImage);
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoes other = (Shoes) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Shoes [id=" + id + ", brand=" + brand + ", color=" + color + ", size=" + size + "]";
	}
}
