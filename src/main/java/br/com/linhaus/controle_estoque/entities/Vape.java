package br.com.linhaus.controle_estoque.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Vape extends Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "brand_id") // Isso mapeia a chave estrangeira
	@NotNull(message = "The brand is required and cannot be empty.")
	private Brand brand;
	@Min(value = 1, message = "The price must be greater than zero.")
	private Integer puffs;
	@NotEmpty(message = "The flavor is required and cannot be empty.")
	private String flavor;

	public Vape() {
		super();
	}

	public Vape(String description, String fullDescription, Double price, Integer quantity, String urlImage, Long id,
			Brand brand, Integer puffs, String flavor) {
		super(description, fullDescription, price, quantity, urlImage);
		this.id = id;
		this.brand = brand;
		this.puffs = puffs;
		this.flavor = flavor;
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
		return "Vape [id=" + id + ", brand=" + brand + ", puffs=" + puffs + ", flavor=" + flavor + "]";
	}

}
