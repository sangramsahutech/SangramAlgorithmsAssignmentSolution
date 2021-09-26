package com.great.learning.stockersanalytics.util;

public class StockAnalysis {
	public int getStockCnt(int noOfCompanies, boolean[] status, int flagStatus) {
		// TODO Auto-generated method stub
		int stkCount = 0;
		if(flagStatus == 1) {
			for(int i=0; i < noOfCompanies; i++) {
				if(status[i] == true)
					stkCount++;
			}
		} 
		else if(flagStatus == 2) {
			for(int i=0; i < noOfCompanies; i++) {
				if(status[i] == false)
					stkCount++;
			}
		}
		return stkCount;
	}
}
