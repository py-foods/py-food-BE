package com.pyfood.controller;

import com.pyfood.constant.UrlConfig;
import com.pyfood.entity.dto.UploadProductDTO;
import com.pyfood.exceptionHandler.BadRequestException;
import com.pyfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(UrlConfig.UPLOAD)
    public ResponseEntity uploadProduct(@ModelAttribute UploadProductDTO o){
        if (o == null) {
            throw new BadRequestException("Product not found");
        }
        productService.uploadProduct(o);
        return new ResponseEntity(HttpStatus.OK);
    }
}
