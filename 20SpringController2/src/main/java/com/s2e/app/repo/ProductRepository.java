package com.s2e.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.s2e.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
