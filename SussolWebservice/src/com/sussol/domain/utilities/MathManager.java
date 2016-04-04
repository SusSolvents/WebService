package com.sussol.domain.utilities;

import java.util.ArrayList;

public class MathManager 
{
	public static double getEuclideanDistance(double[] vector1, double[] vector2)
	{
		double sum = 0.0;
		
		for (int i=0; i < vector1.length; i++)
		{
			sum += (vector1[i] - vector2[i]) * (vector1[i] - vector2[i]);
		}
		
		return Math.sqrt(sum);
	}
	
	public static double getEuclideanDistance(ArrayList<Double> vector1, ArrayList<Double> vector2)
	{
		double sum = 0.0;
		
		for (int i=0; i < vector1.size(); i++)
		{
			sum += (vector1.get(i).doubleValue() - vector2.get(i).doubleValue()) * (vector1.get(i).doubleValue() - vector2.get(i).doubleValue());
		}
		
		return Math.sqrt(sum);
	}
}
