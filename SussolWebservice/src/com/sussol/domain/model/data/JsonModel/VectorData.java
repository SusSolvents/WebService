package com.sussol.domain.model.data.JsonModel;

import java.io.Serializable;

public class VectorData implements Serializable {
	private Double value;
	private String name;
	public double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public VectorData(double value, String name) {
		super();
		this.value = value;
		this.name = name;
	}
	public VectorData(Double value) {
		super();
		this.value = value;
	}
	
	
}
