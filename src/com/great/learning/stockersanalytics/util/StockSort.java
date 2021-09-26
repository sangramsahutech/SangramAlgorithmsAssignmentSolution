package com.great.learning.stockersanalytics.util;

public class StockSort {
	
	public void merge(double[] stockPrice, int left, int mid, int right, int flagSort) {
		int lsize = mid - left+1;
		int rsize = right - mid;
		double[] leftArr = new double[lsize];
		double[] rightArr = new double[rsize];
		for(int i=0;i<lsize;i++) 
			leftArr[i] = stockPrice[left+i];
		for(int j=0;j<rsize;j++) 
			rightArr[j] = stockPrice[mid+1+j];
		int i=0,j=0,k=left;
		while(i < lsize && j < rsize) {
			if (flagSort == 1){
				if(leftArr[i] <= rightArr[j]) {
					stockPrice[k] = leftArr[i];
					i++;
				}
				else {
					stockPrice[k] = rightArr[j];
					j++;
				}
				k++;
			}
			else if(flagSort == 2){
				if(leftArr[i] >= rightArr[j]) {
					stockPrice[k] = leftArr[i];
					i++;
				}
				else {
					stockPrice[k] = rightArr[j];
					j++;
				}
				k++;
			}
		}	
		while(i < lsize) {
			stockPrice[k] = leftArr[i];
			i++;
			k++;
		}
		while(j < rsize) {
			stockPrice[k] = rightArr[j];
			j++;
			k++;
		}
	}
	public void sort(double[] stockPrice, int left, int right, int flagSort) {
		// TODO Auto-generated method stub
		if(left < right) {
			int mid = (left + right)/ 2;
			sort(stockPrice, left, mid, flagSort);
			sort(stockPrice, mid+1, right, flagSort);
			merge(stockPrice, left, mid, right, flagSort);
		}
	}
}