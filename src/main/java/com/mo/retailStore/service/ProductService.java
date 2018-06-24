package com.mo.retailStore.service;

import com.mo.retailStore.model.Product;
import com.mo.retailStore.model.ProductEntity;
import com.mo.retailStore.repository.CategoryRepository;
import com.mo.retailStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product addProduct(Product product) {
        ProductEntity productEntity = null;

        if(product.getId() != null) {
            productEntity = productRepository.findOne(product.getId());
        }

        if (productEntity == null) {
            productEntity = new ProductEntity();
            productEntity.setName(product.getName());
            productEntity.setCost(product.getCost());
            productEntity.setCategoryEntity(categoryRepository.findByName(product.getCategoryName()));
            productEntity = productRepository.save(productEntity);
        }
        return Product.getProduct(productEntity);
    }

    public Iterable<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        for (ProductEntity productEntity : productRepository.findAll()) {
            products.add(Product.getProduct(productEntity));
        }
        return products;
    }

    public Product getProduct(String resourceId) {
        ProductEntity productEntity = productRepository.findOne(Long.parseLong(resourceId));
        if (productEntity == null) {
            return null;
        }
        Product product = Product.getProduct(productEntity);
        return product;
    }
}
