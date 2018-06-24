package com.mo.retailStore.controller;


import com.mo.retailStore.model.Bill;
import com.mo.retailStore.model.Invoice;
import com.mo.retailStore.model.Purchase;
import com.mo.retailStore.service.BillService;
import com.mo.retailStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PurchaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BillService billService;

    /**
     * Generate invoice with total amount for bill Id
     *
     * @param billId
     * @return Invoice
     */
    @RequestMapping(value = "/purchase/invoice/{billId}", method = RequestMethod.GET)
    public @ResponseBody
    Invoice generateInvoice(@PathVariable(value = "billId") String billId) {
        return billService.getInvoice(billId);
    }

    /**
     * Generate a new bill to add new products
     *
     * @param bill
     * @return billId
     * @throws Exception
     */
    @RequestMapping(value = "/purchase/generate_new_bill", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    String generateNewBill(@RequestBody Bill bill) throws Exception {
        return billService.generateNewBill(bill);
    }

    /**
     * Add a product to bill
     *
     * @param purchase
     * @return billId
     * @throws Exception
     */
    @RequestMapping(value = "/purchase/add_scanned_product", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    String addScannedProduct(@RequestBody Purchase purchase) throws Exception {
        return billService.addScannedProduct(purchase);
    }

    /**
     * Remove a product from bill
     *
     * @param purchase
     * @return billId
     * @throws Exception
     */
    @RequestMapping(value = "/purchase/remove_scanned_product", consumes = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    String removeScannedProduct(@RequestBody Purchase purchase) throws Exception {
        return billService.removeScannedProduct(purchase);
    }
}