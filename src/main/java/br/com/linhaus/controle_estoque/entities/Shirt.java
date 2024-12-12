package br.com.linhaus.controle_estoque.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shirt extends Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String color;
	private String size;
	private Boolean printed;
	private String material;

	public Shirt() {
		super();
	}

	public Shirt(String description, String fullDescription, String brand, Double price, Integer quantity,
			String urlImage, Long id, String color, String size, Boolean printed, String material) {
		super(description, fullDescription, brand, price, quantity, urlImage);
		this.id = id;
		this.color = color;
		this.size = size;
		this.printed = printed;
		this.material = material;
	}

	public Long getId() {
		return id;
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

	public Boolean getPrinted() {
		return printed;
	}

	public void setPrinted(Boolean printed) {
		this.printed = printed;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shirt other = (Shirt) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Shirt [id=" + id + ", color=" + color + ", size=" + size + ", printed=" + printed + ", material="
				+ material + "]";
	}
}
