package com.pyfood.repository;

import com.pyfood.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vmdat
 * @create 19/03/2020
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
