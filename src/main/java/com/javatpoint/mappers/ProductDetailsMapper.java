package com.javatpoint.mappers;

import com.javatpoint.model.ProductDetails;
import pojoclasses.Event;
import pojoclasses.Product;
import pojoclasses.Request;

import java.util.ArrayList;

public class ProductDetailsMapper {

    public  ArrayList<ProductDetails> mapFromRequest(Request request) {

        ArrayList<ProductDetails> productDetailsList = new ArrayList<>();

        for (
                Event event : request.getEvent()) {
            for (Product product : event.getProduct()) {
                ProductDetails productDetails = new ProductDetails();
                productDetails.setRequestId(request.getRequestDetails().getId());
                productDetails.setSourceCompany(request.getRequestDetails().getSourceCompany());
                productDetails.setInsuredId(event.getInsuredId());
                productDetails.setPrice(product.getPrice());
                productDetails.setType(product.getType());
                productDetails.setStartDate(product.getStartDate());
                productDetails.setEndDate(product.getEndDate());
                productDetailsList.add(productDetails);
            }
        }

        return  productDetailsList;
    }
}
