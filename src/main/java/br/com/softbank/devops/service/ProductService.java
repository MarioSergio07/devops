package br.com.softbank.devops.service;

import br.com.softbank.devops.model.Filter;
import br.com.softbank.devops.model.Product;
import br.com.softbank.devops.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service("productService")
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Iterable<Product> orderByName(String name) {
        return productRepository.findByDescriptionContainingOrderByValue(name);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Iterable<Product> filter(Filter filter) {
        Iterable<Product> listProducts = new ArrayList<Product>();

        switch (filter.getCategory()) {
            case "name":
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByNameContainingOrderByName(filter.getName()));
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByDescriptionContainingOrderByName(filter.getName()));
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByCategoryContainingOrderByName(filter.getName()));
                break;
            case "categoria":
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByNameContainingOrderByCategory(filter.getName()));
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByDescriptionContainingOrderByCategory(filter.getName()));
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByCategoryContainingOrderByCategory(filter.getName()));
                break;
            case "maiorPreco":
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByNameContainingOrderByValueDesc(filter.getName()));
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByDescriptionContainingOrderByValueDesc(filter.getName()));
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByCategoryContainingOrderByValueDesc(filter.getName()));
                break;
            case "menorPreco":
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByNameContainingOrderByValue(filter.getName()));
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByDescriptionContainingOrderByValue(filter.getName()));
                ((ArrayList<Product>) listProducts).addAll(productRepository.findByCategoryContainingOrderByValue(filter.getName()));
                break;
        }
        if(((ArrayList<Product>) listProducts).isEmpty()) {
            return null;
        } else {
            return ((ArrayList<Product>) listProducts).stream().distinct().collect(Collectors.toList());
        }
    }
}
