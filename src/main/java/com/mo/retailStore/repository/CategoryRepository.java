package com.mo.retailStore.repository;


import com.mo.retailStore.model.BillEntity;
import com.mo.retailStore.model.CategoryEntity;
import com.mo.retailStore.model.CategoryNameEnum;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    CategoryEntity findByName(CategoryNameEnum name);

}