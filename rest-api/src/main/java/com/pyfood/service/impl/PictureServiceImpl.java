package com.pyfood.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.pyfood.entity.Picture;
import com.pyfood.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@Service
public class PictureServiceImpl implements PictureService {
    private static Cloudinary cloudinary;

    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.api_key}")
    private String apiKey;

    @Value("${cloudinary.api_secret}")
    private String apiSecret;
    @PostConstruct
    public void init(){
        PictureServiceImpl.cloudinary = new Cloudinary( ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
        cloudinary.api();
    }

    @Override
    public Picture UploadPic(MultipartFile file, String productName) {

        String name = productName + "-" + new Date().getTime();
        Map params = ObjectUtils.asMap("public_id", name);
        Picture picture = new Picture();
        try {
            Map result = cloudinary.uploader().upload(file.getBytes(), params);
            picture.setImgUrl((String) result.get("url"));
            picture.setName((String) result.get("public_id"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picture;
    }

    @Override
    public List<Picture> uploadMultiPic(List<MultipartFile> multipartFiles, String name) {
        return multipartFiles.stream().map(file -> UploadPic(file, name)).collect(Collectors.toList());
    }
}
