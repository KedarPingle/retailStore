package com.mo.retailStore;

import com.mo.retailStore.model.Bill;
import com.mo.retailStore.model.CategoryNameEnum;
import com.mo.retailStore.model.Product;
import com.mo.retailStore.model.Purchase;
import com.mo.retailStore.service.BillService;
import com.mo.retailStore.service.CategoryService;
import com.mo.retailStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SampleDataConfiguration {

	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    private ProductService productService;

    @Autowired
    private BillService billService;

    @Autowired
    private CategoryService categoryService;


    @Bean
    public CommandLineRunner loadSampleData() {
        return (args) -> {
            this.addCategories();
            this.addProducts();
            this.addBills();
            this.addProductsToBill();
        };
    }

    private void addCategories(){
        categoryService.addCategory(CategoryNameEnum.A, 0.1);
        categoryService.addCategory(CategoryNameEnum.B, 0.2);
        categoryService.addCategory(CategoryNameEnum.C, 0.0);
    }

    private void addProducts(){
        Product product = new Product();
        product.setName("Apple Small");
        product.setCost(10l);
        product.setCategoryName(CategoryNameEnum.A);
        productService.addProduct(product);

        product = new Product();
        product.setName("Shirt Small");
        product.setCost(50l);
        product.setCategoryName(CategoryNameEnum.B);
        productService.addProduct(product);

        product = new Product();
        product.setName("Trouser Small");
        product.setCost(50l);
        product.setCategoryName(CategoryNameEnum.C);
        productService.addProduct(product);
    }

    private void addBills() throws Exception {
        Bill bill = new Bill();
        bill.setCustomerName("AUser1");
        billService.generateNewBill(bill);

        bill = new Bill();
        bill.setCustomerName("AUser2");
        billService.generateNewBill(bill);
    }

    private void addProductsToBill() throws Exception {

       billService.addScannedProduct(new Purchase("1", "1", "5"));
       billService.addScannedProduct(new Purchase("1", "2", "2"));
       billService.addScannedProduct(new Purchase("1", "3", "2"));
    }

}
