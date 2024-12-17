package br.com.linhaus.controle_estoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.linhaus.controle_estoque.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{
	
	@Query(value = "SELECT * FROM BRAND WHERE PRODUCT_TYPE = :productType", nativeQuery = true)
	List<Brand> findByProductType(@Param("productType") int productType);
	
}