package com.s2e.app.constants;

import java.util.ArrayList;
import java.util.Arrays;

import com.s2e.app.model.Product;

public class ProductApi {
	
	private String method;
	private String url;
	private Class consumes;
	private Class produces;
	private String description;
	private RecordOperation operationType;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Class getConsumes() {
		return consumes;
	}
	public void setConsumes(Class consumes) {
		this.consumes = consumes;
	}
	public Class getProduces() {
		return produces;
	}
	public void setProduces(Class produces) {
		this.produces = produces;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public RecordOperation getOperationType() {
		return operationType;
	}
	public ProductApi(String method, String url, Class consumes, Class produces, String description) {
		super();
		this.method = method;
		this.url = url;
		this.consumes = consumes;
		this.produces = produces;
		this.description = description;
	}
	
	public void setOperationType(RecordOperation operationType) {
		this.operationType = operationType;
	}
	
	public ProductApi(String method, String url, Class consumes, Class produces, String description,
			RecordOperation operationType) {
		super();
		this.method = method;
		this.url = url;
		this.consumes = consumes;
		this.produces = produces;
		this.description = description;
		this.operationType = operationType;
	}

	
	public final static ArrayList<ProductApi> getProductApi(){
		ArrayList<ProductApi> apis = new ArrayList<ProductApi>();
		apis.addAll(Arrays.asList(
				new ProductApi("GET", "/product/search/name/{name}", null, new ArrayList<Product>().getClass(), "Search products by name", RecordOperation.getOperationByText("Search")),
				new ProductApi("GET", "/product/name/asc", null, new ArrayList<Product>().getClass(), "Get products order asc",RecordOperation.getOperationByText("Sort")),
				new ProductApi("GET", "/product/name/desc", null, new ArrayList<Product>().getClass(), "Get products order desc",RecordOperation.getOperationByText("Sort")),
				new ProductApi("GET", "/product/available", null, Boolean.class, "Get products filtered", RecordOperation.getOperationByText("Filter"))
				));
		return apis;
	}


	
	
}
