package com.s2e.app.constants;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductOperationApi {
	
	private HashMap<String, ArrayList<ProductApi>> productOperation = new HashMap<>();
	
	public  ProductOperationApi() {
		ArrayList<RecordOperation> operations = RecordOperation.values();
		ArrayList<ProductApi> productApis = ProductApi.getProductApi();
		
		for(ProductApi api:productApis) {
			if (productOperation.get(api.getOperationType().getText()) == null) {
				productOperation.put(api.getOperationType().getText(), new ArrayList<ProductApi>());
				productOperation.get(api.getOperationType().getText()).add(api);
			}else {
				
			}
			
				
		}
	}

	public HashMap<String, ArrayList<ProductApi>> getProductOperation() {
		return productOperation;
	}

	public void setProductOperation(HashMap<String, ArrayList<ProductApi>> productOperation) {
		this.productOperation = productOperation;
	}

}
