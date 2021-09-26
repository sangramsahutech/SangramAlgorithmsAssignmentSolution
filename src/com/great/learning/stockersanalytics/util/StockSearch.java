package com.great.learning.stockersanalytics.util;

public class StockSearch {

	public boolean binarySearch(double[] inpArr,int left, int right, double key, String srtOrd) {
		// TODO Auto-generated method stub
		if(right>=left) {
			int mid = (left + right)/ 2;
			if(inpArr[mid] == key)
				return true;
			if(srtOrd == "A") {
				if(inpArr[mid] > key) 
					return binarySearch(inpArr, left, mid-1, key, srtOrd);
				return binarySearch(inpArr, mid, right, key, srtOrd);
			}
			else if(srtOrd == "D") {
				if(inpArr[mid] < key) 
					return binarySearch(inpArr, left, mid-1, key, srtOrd);
				return binarySearch(inpArr, mid, right, key, srtOrd);
			}
		}
		return false;
	}

	public boolean linearSearch(double[] stockPrice, int noOfCompanies, double key) {
		// TODO Auto-generated method stub
		for(int i = 0; i < noOfCompanies; i++) {
			if(stockPrice[i] == key)
				return true;
		}
		return false;
	}
}