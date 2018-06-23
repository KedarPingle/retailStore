package com.mo.retailStore.repository;


import com.mo.retailStore.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}