package br.com.linhaus.controle_estoque.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Vape extends Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Min(value = 1, message = "The price must be greater than zero.")
	private Integer puffs;
	@NotEmpty(message = "The flavor is required and cannot be empty.")
	private String flavor;

	public Vape() {
		super();
	}

	public Vape(String description, String fullDescription, String brand, Double price, Integer quantity,
			String urlImage, Long id, Integer puffs, String flavor) {
		super(description, fullDescription, brand, price, quantity, urlImage);
		this.id = id;
		this.puffs = puffs;
		this.flavor = flavor;
	}

	public Long getId() {
		return id;
	}

	public Integer getPuffs() {
		return puffs;
	}

	public void setPuffs(Integer puffs) {
		this.puffs = puffs;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
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
		Vape other = (Vape) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Vape [id=" + id + ", puffs=" + puffs + ", flavor=" + flavor + "]";
	}

}
