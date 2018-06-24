package com.mo.retailStore.repository;

import com.mo.retailStore.model.BillEntity;
import com.mo.retailStore.model.BillProductEntity;
import com.mo.retailStore.model.BillProductId;
import com.mo.retailStore.model.CategoryEntity;
import com.mo.retailStore.model.CategoryNameEnum;
import com.mo.retailStore.model.ProductEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BillProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BillProductRepository billProductRepository;

    @Test
    public void findByBillProductIdBillEntity_query(){
        BillEntity billEntity = new BillEntity();
        billEntity.setCustomerName("TestCustomer");

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(CategoryNameEnum.A);

        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategoryEntity(categoryEntity);

        ProductEntity productEntity2 = new ProductEntity();
        productEntity2.setCategoryEntity(categoryEntity);

        BillProductId billProductId = new BillProductId();
        billProductId.setBillEntity(billEntity);
        billProductId.setProductEntity(productEntity);
        BillProductEntity billProductEntity = new BillProductEntity();
        billProductEntity.setBillProductId(billProductId);
        billProductEntity.setQuantity("5");

        BillProductId billProductId2 = new BillProductId();
        billProductId2.setBillEntity(billEntity);
        billProductId2.setProductEntity(productEntity2);
        BillProductEntity billProductEntity2 = new BillProductEntity();
        billProductEntity2.setBillProductId(billProductId2);
        billProductEntity2.setQuantity("5");



        billEntity = entityManager.persist(billEntity);
        categoryEntity = entityManager.persist(categoryEntity);
        productEntity = entityManager.persist(productEntity);
        productEntity2 = entityManager.persist(productEntity2);
        entityManager.persist(billProductEntity);
        entityManager.persist(billProductEntity2);
        entityManager.flush();

        List<BillProductEntity> byBillProductIdBillEntity = billProductRepository.findByBillProductIdBillEntity(billEntity);
        assertTrue(byBillProductIdBillEntity.size() == 2);
        assertEquals("TestCustomer", byBillProductIdBillEntity.get(0).getBillProductId().getBillEntity().getCustomerName());


    }

}
