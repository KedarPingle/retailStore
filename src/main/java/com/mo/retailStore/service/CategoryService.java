package com.mo.retailStore.service;

import com.mo.retailStore.model.CategoryEntity;
import com.mo.retailStore.model.CategoryNameEnum;
import com.mo.retailStore.model.Product;
import com.mo.retailStore.model.ProductEntity;
import com.mo.retailStore.repository.CategoryRepository;
import com.mo.retailStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(CategoryNameEnum name, double tax) {
        CategoryEntity categoryEntity = null;
        categoryEntity = categoryRepository.findByName(name);

        if (categoryEntity == null) {
            categoryEntity = new CategoryEntity();
            categoryEntity.setName(name);
        }
        categoryEntity.setTax(tax);

        categoryEntity = categoryRepository.save(categoryEntity);
    }
}
