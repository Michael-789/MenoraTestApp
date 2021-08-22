package com.javatpoint.service;

import com.javatpoint.model.ProductDetails;
import com.javatpoint.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRepository productRepository;
    public List<ProductDetails> getAllProductsInsuredId(String insuredId) {
        List<ProductDetails> productDetailsList = new ArrayList<>();
        productRepository.findProductDetailsByInsuredIdOrderByRequestIdAsc(insuredId).forEach(productDetails -> productDetailsList.add(productDetails));
        return productDetailsList;
    }

    public void saveOrUpdate(List<ProductDetails> productDetails) {
        productRepository.saveAll(productDetails);
    }

}
