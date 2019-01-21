package com.teamfive.search_elastic.service;

import com.teamfive.search_elastic.entity.Product;
import com.teamfive.search_elastic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> searchProduct(String keyword, String category, PageRequest pageRequest) {

        if(category==null) return productRepository.findProductByQuery(keyword,pageRequest);
        return productRepository.findProductByQuery(keyword,category,pageRequest);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

}
