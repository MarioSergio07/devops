package br.com.softbank.devops.service;

import br.com.softbank.devops.model.Filter;
import br.com.softbank.devops.model.Product;

public interface IProductService {

    public Iterable<Product> findAll();
    public Iterable<Product> orderByName(String name);
    public Product findById(Long id);

    public Iterable<Product> filter(Filter filter);
}
