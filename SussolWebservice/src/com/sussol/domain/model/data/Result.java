package com.sussol.domain.model.data;

import com.sussol.domain.utilities.Globals.SortKey;

public class Result implements Comparable<Result>
{
	private SolventData solventData;
	private int clusterNumber;
	private SortKey sortKey;	

	public Result(SolventData solventData, int clusterNumber)
	{
		this.solventData = solventData;
		this.clusterNumber = clusterNumber;
	}

	public SolventData getSolventData() 				{ return solventData; }
	public void setSolventData(SolventData solventData)	{ this.solventData = solventData; }
	public int getClusterNumber() 						{ return clusterNumber;	}
	public void setClusterNumber(int clusterNumber) 	{ this.clusterNumber = clusterNumber; }
	public SortKey getSortKey() 						{ return sortKey; }
	public void setSortKey(SortKey sortKey) 			{ this.sortKey = sortKey; }
	
	@Override
	public int compareTo(Result otherResult) 
	{
		switch (sortKey)
		{
			case CLUSTER:
				return Integer.compare(clusterNumber, otherResult.clusterNumber);
			case SOLVENT:
				return Integer.compare(solventData.getNumber(), otherResult.getSolventData().getNumber());
		}
		
		return 0;		
	}
		
}
