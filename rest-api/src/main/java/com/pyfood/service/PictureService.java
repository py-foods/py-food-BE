package com.pyfood.service;

import com.pyfood.entity.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author vmdat
 * @create 19/03/2020
 */
public interface PictureService {

    Picture UploadPic(MultipartFile file, String name);

    List<Picture> uploadMultiPic(List<MultipartFile> multipartFiles, String name);
}
