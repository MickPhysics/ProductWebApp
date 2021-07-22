package com.s2e.app.constants;

import java.util.ArrayList;
import java.util.Arrays;


import com.fasterxml.jackson.annotation.JsonValue;

public class RecordOperation {
	

	private int number;
	private String text;
	
	RecordOperation() {

	}
	
	RecordOperation(int number, String text) {
		this.setText(text);
		this.setNumber(number);
	}
	
	@JsonValue
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@JsonValue
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public static final ArrayList<RecordOperation> values(){
		ArrayList<RecordOperation> r = new ArrayList<>();
		r.addAll(Arrays.asList(
				new RecordOperation(1, "Search"),
				new RecordOperation(2, "Sort"),
				new RecordOperation(3, "Filter")
				));
		return r;
		
	}
	
	public static final RecordOperation getOperationByText(String text) {
		ArrayList<RecordOperation> records = values();
		for(RecordOperation rec : records)
			if(rec.getText().equalsIgnoreCase(text))
				return rec;
		return new RecordOperation(0, null);
		
	}
	
	
	// Voglio un oggetto API da passare al client, creo delle costanti così da non dover dichiarare una entità di tipo API, non è sempre accettato farlo.

}
