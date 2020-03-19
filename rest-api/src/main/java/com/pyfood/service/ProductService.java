package com.pyfood.service;

import com.pyfood.entity.dto.UploadProductDTO;

/**
 * @author vmdat
 * @create 19/03/2020
 */
public interface ProductService {

    void uploadProduct(UploadProductDTO product);
}
