package com.sussol.domain.model.data.JsonModel;

import java.io.Serializable;

public class Feature implements Serializable {
 private String name;
 private double value;

 
 
 public Feature(String name, double value) {
	super();
	this.name = name;
	this.value = value;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
 
 
}
