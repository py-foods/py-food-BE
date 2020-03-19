package com.pyfood.repository;

import com.pyfood.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
