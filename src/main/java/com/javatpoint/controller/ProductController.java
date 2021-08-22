package com.javatpoint.controller;

import com.javatpoint.model.ProductDetails;
import com.javatpoint.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    ProductService productService;
    @GetMapping("/product/{insuredId}")
    private List<ProductDetails> getAllProduct(@PathVariable("insuredId") String insuredId)
    {
        return productService.getAllProductsInsuredId(insuredId);
    }

    @PostMapping("/product")
    private int saveProduct(@RequestBody List<ProductDetails> productDetails)
    {
        productService.saveOrUpdate(productDetails);
        return productDetails.size();
    }
}