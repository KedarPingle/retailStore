package com.mo.retailStore.controller;


import com.mo.retailStore.model.Product;
import com.mo.retailStore.service.ProductService;
import com.mo.retailStore.util.LocalizationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Get all products.
     *
     * @return Product List
     */
    @RequestMapping(value = "/product/all", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Get a particular based on id
     *
     * @param resourceId
     * @return Product
     */
    @RequestMapping(value = "/product/{resourceId}", method = RequestMethod.GET)
    public @ResponseBody
    Product getProduct(@PathVariable(value = "resourceId") String resourceId) {
        return productService.getProduct(resourceId);
    }

    /**
     * Add new product to database
     *
     * @param product
     * @return product
     */
    @RequestMapping(value = "/product/add", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}