package com.javatpoint.repository;

import com.javatpoint.model.ProductDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductDetails, String> {
    List<ProductDetails> findProductDetailsByInsuredIdOrderByRequestIdAsc(String insuredId);

}