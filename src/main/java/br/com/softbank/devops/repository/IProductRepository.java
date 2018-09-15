package br.com.softbank.devops.repository;

import br.com.softbank.devops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productRepository")
public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingOrderByName(String name);
    List<Product> findByDescriptionContainingOrderByName(String description);
    List<Product> findByCategoryContainingOrderByName(String category);

    List<Product> findByNameContainingOrderByCategory(String name);
    List<Product> findByDescriptionContainingOrderByCategory(String description);
    List<Product> findByCategoryContainingOrderByCategory(String category);

    List<Product> findByNameContainingOrderByValue(String name);
    List<Product> findByDescriptionContainingOrderByValue(String description);
    List<Product> findByCategoryContainingOrderByValue(String category);


    List<Product> findByNameContainingOrderByValueDesc(String name);
    List<Product> findByDescriptionContainingOrderByValueDesc(String description);
    List<Product> findByCategoryContainingOrderByValueDesc(String category);


}
