package br.com.linhaus.controle_estoque.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shoes extends Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String color;
	private String size;

	public Shoes() {
		super();
	}

	public Shoes(String description, String fullDescription, String brand, Double price, Integer quantity,
			String urlImage, Long id, String color, String size) {
		super(description, fullDescription, brand, price, quantity, urlImage);
		this.id = id;
		this.color = color;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Shoes [id=" + id + ", color=" + color + ", size=" + size + "]";
	}
}
