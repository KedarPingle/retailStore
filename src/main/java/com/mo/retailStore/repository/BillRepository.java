package com.mo.retailStore.repository;


import com.mo.retailStore.model.BillEntity;
import org.springframework.data.repository.CrudRepository;


public interface BillRepository extends CrudRepository<BillEntity, Long> {

}