package com.mo.retailStore.service;

import com.mo.retailStore.model.CategoryEntity;
import com.mo.retailStore.model.CategoryNameEnum;
import com.mo.retailStore.model.Product;
import com.mo.retailStore.model.ProductEntity;
import com.mo.retailStore.repository.CategoryRepository;
import com.mo.retailStore.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    @Spy
    private ProductService productService;

    @Test
    public void testAddProduct_newProduct() throws IOException {
        Product mockProduct = new Product();
        mockProduct.setName("Apple");
        mockProduct.setCost(100l);
        mockProduct.setCategoryName(CategoryNameEnum.A);
        mockProduct.setId(1l);

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(CategoryNameEnum.A);
        categoryEntity.setTax(0.1);
        categoryEntity.setId(1l);


        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategoryEntity(categoryEntity);
        productEntity.setCost(100l);
        productEntity.setName("Apple");
        productEntity.setId(1l);


        // Mock methods
        Mockito.doReturn(productEntity).when(productRepository).findOne(mockProduct.getId());
        Mockito.doReturn(categoryEntity).when(categoryRepository).findByName(mockProduct.getCategoryName());
        Mockito.doReturn(productEntity).when(productRepository).save(any(ProductEntity.class));

        // Call the method under test passing...
        Product productReturned = productService.addProduct(mockProduct);

        // Test values of the ProductEntity...
        assertEquals(mockProduct.getId(), productReturned.getId());
        assertEquals(mockProduct.getName(), productReturned.getName());
        assertEquals(mockProduct.getCategoryName(), productReturned.getCategoryName());
    }
}
