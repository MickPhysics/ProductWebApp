package com.s2e.app.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.s2e.app.constants.RecordOperation;
@RestController
public class RecordOperationController {

	@GetMapping("/recordOperations")
	public Collection<RecordOperation> getRecordOperation() {
		return RecordOperation.values();
	}
}
