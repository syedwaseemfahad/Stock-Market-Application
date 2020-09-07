package com.mthree.models;

public class FeeLadder {

	public static int caluculateFeePercentage(int sharePrice,int noOfShares)
	{
		if(sharePrice*noOfShares<100000)
		{
			return 9;
		}
		if(sharePrice*noOfShares<500000)
		{
			return 8;
		}
		if(sharePrice*noOfShares<1000000)
		{
			return 7;
		}
		if(sharePrice*noOfShares<2000000)
		{
			return 6;
		}
		if(sharePrice*noOfShares<5000000)
		{
			return 5;
		}
		if(sharePrice*noOfShares<10000000)
		{
			return 4;
		}
		if(sharePrice*noOfShares<15000000)
		{
			return 3;
		}
		if(sharePrice*noOfShares<20000000)
		{
			return 2;
		}
		else
		{
			return 1;
		}
		
	}	
}
