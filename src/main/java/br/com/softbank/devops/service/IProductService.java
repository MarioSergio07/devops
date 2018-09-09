package br.com.softbank.devops.service;

import br.com.softbank.devops.model.Product;

public interface IProductService {
    public Iterable<Product> findAll();
}
