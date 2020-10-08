package com.pisi.marketplace.business.service;

import com.pisi.marketplace.data.entity.Product;
import com.pisi.marketplace.resource.model.ProductResource;

import org.springframework.stereotype.Component;

@Component
public class ProductConversor {
    public Product conversor(ProductResource productResource) throws Exception {
        try {
            Product product = new Product();
            product.setDescription(productResource.getDescription());
            product.setImageSource(productResource.getImageSource());
            product.setPrice(productResource.getPrice());
            product.setProductName(productResource.getProductName());
            product.setProductType(productResource.getProductType());
            product.setStock(productResource.getStock());
            return product;
        } catch (Exception e) {
            throw new Exception("erro: " + productResource);
        }
    }
}
