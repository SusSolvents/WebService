package com.sussol.domain.model.data;

import com.sussol.domain.utilities.Globals.AttributeType;

// This class contains attribute - type - value tuples.
// It is exclusively used for classifying a new solvent.

public class SolventAttribute
{
	private String attributeName;
	
	private double attributeValue;

	private AttributeType attributeType;
	
	public SolventAttribute(String attributeName, AttributeType attributeType) 
	{
		this.attributeName = attributeName;
		this.attributeType = attributeType;
	}

	
	public String getAttributeName() 							{ return attributeName; }
	public void setAttributeName(String attributeName)			{ this.attributeName = attributeName; }
	public AttributeType getAttributeType() 					{ return attributeType; }
	public void setAttributeType(AttributeType attributeType)	{ this.attributeType = attributeType; }
	public double getAttributeValue() 							{ return attributeValue; }
	public void setAttributeValue(double attributeValue) 		{ this.attributeValue = attributeValue; }
}
