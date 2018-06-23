package com.mo.retailStore.repository;


import com.mo.retailStore.model.BillEntity;
import com.mo.retailStore.model.BillProductEntity;
import com.mo.retailStore.model.BillProductId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BillProductRepository extends CrudRepository<BillProductEntity, BillProductId> {

    List<BillProductEntity> findByBillProductIdBillEntity(BillEntity billEntity);

}