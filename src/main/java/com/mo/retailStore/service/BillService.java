package com.mo.retailStore.service;

import com.mo.retailStore.model.Bill;
import com.mo.retailStore.model.BillEntity;
import com.mo.retailStore.model.BillProduct;
import com.mo.retailStore.model.BillProductEntity;
import com.mo.retailStore.model.BillProductId;
import com.mo.retailStore.model.Invoice;
import com.mo.retailStore.model.Product;
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
public class BillService extends BaseService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillProductRepository billProductRepository;

    public Bill addBill(Bill bill) throws Exception {

        BillEntity billEntity = null;
        billEntity = billRepository.findOne(bill.getId());

        if(billEntity != null) {
            throw new Exception("Bill exists");
        }

        billEntity = new BillEntity();
        billEntity.setCustomerName(bill.getCustomerName());
        billEntity = billRepository.save(billEntity);
        return Bill.getBill(billEntity);
    }

    public void addProductToBill(long billId, long productId, long quantity) throws Exception {

        BillEntity billEntity = billRepository.findOne(billId);
        if (billEntity == null) {
            throw new Exception("No bill found");
        }

        ProductEntity productEntity = productRepository.findOne(productId);
        if (productEntity == null) {
            throw new Exception("No product found");
        }

        double totalCost = (double) (productEntity.getCost() * quantity);
        double tax = totalCost * productEntity.getCategoryEntity().getTax();

        BillProductEntity billProductEntity = new BillProductEntity();
        billProductEntity.setQuantity(quantity);

        BillProductId billProductId = new BillProductId(billEntity, productEntity);
        billProductEntity.setBillProductId(billProductId);

        billProductEntity.setTotalCost(totalCost);
        billProductEntity.setTotalTax(tax);

        billProductRepository.save(billProductEntity);
    }

    public String newPurchase(Purchase purchase) throws Exception {
        Bill bill = new Bill(purchase.getCustomerName());
        bill = this.addBill(bill);
        for (Product product : purchase.getProducts()) {
            this.addProductToBill(bill.getId(), product.getId(), 1);
        }
        return "success";
    }

    public Invoice getInvoice(String billId) {
        Invoice invoice = new Invoice();
        List<BillProduct> billProducts = new ArrayList<>();
        invoice.setPurchaseItems(billProducts);

        BillEntity billEntity = billRepository.findOne(Long.parseLong(billId));
        if(billEntity == null) {
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
