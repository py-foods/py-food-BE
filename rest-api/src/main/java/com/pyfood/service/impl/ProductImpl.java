package com.pyfood.service.impl;

import com.pyfood.entity.Picture;
import com.pyfood.entity.Product;
import com.pyfood.entity.dto.UploadProductDTO;
import com.pyfood.repository.ProductRepository;
import com.pyfood.service.PictureService;
import com.pyfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PictureService pictureService;

    @Override
    public void uploadProduct(UploadProductDTO uploadProductDTO) {

        Product product = new Product();
        product.setName(uploadProductDTO.getName());
        product.setDescription(uploadProductDTO.getDescription());
        List<MultipartFile> images = uploadProductDTO.getImages();
        List<Picture> pictures = pictureService.uploadMultiPic(images, uploadProductDTO.getName());
        product.setPictures(pictures);

        pictures.forEach(x -> x.setProduct(product));
        productRepository.save(product);
    }
}
