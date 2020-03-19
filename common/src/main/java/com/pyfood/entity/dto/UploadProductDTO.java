package com.pyfood.entity.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author vmdat
 * @create 19/03/2020
 */
public class UploadProductDTO {

    private String name;
    private String description;
    private List<MultipartFile> images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
