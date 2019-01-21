package com.teamfive.search_elastic.controller;

import com.teamfive.search_elastic.dto.ProductDto;
import com.teamfive.search_elastic.entity.Product;
import com.teamfive.search_elastic.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductSearch {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/search/{category}/{query}")
    public List<Product> search(@PathVariable String query, @PathVariable String category)
    {
        Page<Product> searchResult=productService.searchProduct(query,category,new PageRequest(0,10));
        List<Product> outputList=new ArrayList<Product>();
        searchResult.forEach((product -> {
            outputList.add(product);
        }));
        return outputList;
    }

    @GetMapping(value = "/search/all/{query}")
    public List<Product> search(@PathVariable String query)
    {
        return search(query,null);
    }


    @GetMapping(value = "/echo")
    public String echo()
    {
        return "working!!!";
    }

    @PostMapping(value = "/add/product")
    public ProductDto add(@RequestBody ProductDto productDto)
    {
        Product product=new Product();
        BeanUtils.copyProperties(productDto,product);
        Product insertedProduct=productService.addProduct(product);
        ProductDto insertedProductDto=new ProductDto();
        BeanUtils.copyProperties(insertedProduct,insertedProductDto);
        return insertedProductDto;
    }
}
