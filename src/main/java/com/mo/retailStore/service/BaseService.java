package com.mo.retailStore.service;


import com.mo.retailStore.model.Product;
import com.mo.retailStore.service.ProductService;
import com.mo.retailStore.util.LocalizationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

public class BaseService {

    @Autowired
    LocalizationUtil localizationUtil;
}