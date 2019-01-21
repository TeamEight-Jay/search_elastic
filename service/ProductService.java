package com.teamfive.search_elastic.service;

import com.teamfive.search_elastic.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProductService {
    public Page<Product> searchProduct(String keyword, String category, PageRequest pageRequest);

    public Product addProduct(Product product);
}
