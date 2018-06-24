package com.mo.retailStore.service;

import com.mo.retailStore.model.Bill;
import com.mo.retailStore.model.BillEntity;
import com.mo.retailStore.model.BillProduct;
import com.mo.retailStore.model.BillProductEntity;
import com.mo.retailStore.model.BillProductId;
import com.mo.retailStore.model.Invoice;
import com.mo.retailStore.model.ProductEntity;
import com.mo.retailStore.model.Purchase;
import com.mo.retailStore.repository.BillProductRepository;
import com.mo.retailStore.repository.BillRepository;
import com.mo.retailStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BillService extends BaseService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillProductRepository billProductRepository;

    public String generateNewBill(Bill bill) throws Exception {

        BillEntity billEntity = null;
        billEntity = billRepository.findByCustomerName(bill.getCustomerName());
        if (billEntity != null) {
            throw new Exception("Bill already exists");
        }
        billEntity = new BillEntity();
        billEntity.setCustomerName(bill.getCustomerName());
        billEntity = billRepository.save(billEntity);

        return Long.toString(billEntity.getId());
    }

    public String addScannedProduct(Purchase purchase) throws Exception {

        BillEntity billEntity = billRepository.findOne(Long.parseLong(purchase.getBillId()));
        if (billEntity == null) {
            throw new Exception("Bill not found. Kindly add a new bill before purchase");
        }

        ProductEntity productEntity = productRepository.findOne(Long.parseLong(purchase.getProductId()));
        if (productEntity == null) {
            throw new Exception("No product found");
        }

        double totalCost = (double) (productEntity.getCost() * Long.parseLong(purchase.getQuantity()));
        double tax = totalCost * productEntity.getCategoryEntity().getTax();

        BillProductEntity billProductEntity = new BillProductEntity();
        billProductEntity.setQuantity(purchase.getQuantity());

        BillProductId billProductId = new BillProductId(billEntity, productEntity);
        billProductEntity.setBillProductId(billProductId);

        billProductEntity.setTotalCost(totalCost);
        billProductEntity.setTotalTax(tax);

        billProductRepository.save(billProductEntity);

        return purchase.getBillId();
    }

    public String removeScannedProduct(Purchase purchase) throws Exception {

        BillEntity billEntity = billRepository.findOne(Long.parseLong(purchase.getBillId()));
        if (billEntity == null) {
            throw new Exception("Bill not found. Kindly add a new bill before purchase");
        }

        ProductEntity productEntity = productRepository.findOne(Long.parseLong(purchase.getProductId()));
        if (productEntity == null) {
            throw new Exception("No product found");
        }

       BillProductId billProductId = new BillProductId(billEntity, productEntity);
       billProductRepository.delete(billProductId);

       return "Success";
    }

    public Invoice getInvoice(String billId) {
        Invoice invoice = new Invoice();
        List<BillProduct> billProducts = new ArrayList<>();
        invoice.setPurchaseItems(billProducts);

        BillEntity billEntity = billRepository.findOne(Long.parseLong(billId));
        if (billEntity == null) {
            return null;
        }
        invoice.setBillId(billEntity.getId());
        invoice.setCustomerName(billEntity.getCustomerName());

        List<BillProductEntity> purchaseItems = billProductRepository.findByBillProductIdBillEntity(billEntity);

        for (BillProductEntity purchaseItem : purchaseItems) {
            BillProduct billProduct = BillProduct.getBillProduct(purchaseItem);
            billProducts.add(billProduct);
        }

        invoice.calculateFinalBill();
        invoice.setWelcomeMessage(localizationUtil.getLocalizedMessage("welcome.message"));

        return invoice;
    }
}
