package com.s2e.app.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.app.constants.ProductApi;
import com.s2e.app.constants.ProductOperationApi;

@RestController
public class ProductApiController {
	
	@GetMapping("/productApis")
	public ProductOperationApi getProductApis() {
		return new ProductOperationApi();
	}

}
