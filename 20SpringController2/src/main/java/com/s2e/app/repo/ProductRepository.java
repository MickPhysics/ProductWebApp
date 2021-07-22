package com.s2e.app.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;


import com.s2e.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Collection<Product> findByName(String name);

	Collection<Product> findAllByOrderByNameAsc();

	Collection<Product> findAllByAvailable();

}
