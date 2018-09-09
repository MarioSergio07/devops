package br.com.softbank.devops.repository;

import br.com.softbank.devops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface IProductRepository extends JpaRepository<Product, Long> {
}
