package com.great.learning.stockersanalytics.driver;

import java.util.Scanner;

import com.great.learning.stockersanalytics.util.StockSearch;
import com.great.learning.stockersanalytics.util.StockSort;
import com.great.learning.stockersanalytics.util.StockAnalysis;

public class StockDriver {
	static boolean isAscSorted = false;
	static boolean isDescSorted = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of companies ");
		int noOfCompanies = sc.nextInt();
		if(noOfCompanies == 0) {
			System.out.println("Please enter valid no of companies! ");
			return;
		}
		StockSort stk = new StockSort();
		StockAnalysis stkanl = new StockAnalysis();
		StockSearch stksrch = new StockSearch();
		double[] stockPrice = new double[noOfCompanies];
		boolean[] status = new boolean[noOfCompanies];
		int operation = 0;
		for(int i = 0; i < noOfCompanies; i++) {
			System.out.println("Enter current stock price of the company "+ (i+1));
			stockPrice[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			status[i] = sc.nextBoolean();
		}
		double[] inpAsc = new double[noOfCompanies];
		double[] inpDesc = new double[noOfCompanies];
		for(int i = 0; i < noOfCompanies; i++)
			inpAsc[i] = stockPrice[i];
		for(int i = 0; i < noOfCompanies; i++)
			inpDesc[i] = stockPrice[i];
		do {
			System.out.println("-----------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. Press 0 to exit");
			System.out.println("-----------------------------------");
			operation = sc.nextInt();
			int flagSort = 0;
			int flagStatus = 0;
			switch(operation) {
			case 0:
				sc.close();
				System.out.println("Exited successfully");
				System.exit(1);
			case 1:
				flagSort = 1;
				isAscSorted = true;
				stk.sort(inpAsc, 0, noOfCompanies-1, flagSort);
				System.out.println("Stock prices in ascending order are : ");
				for(int i=0;i< noOfCompanies; i++)
					System.out.print(inpAsc[i] + " ");
				System.out.println();
				break;
			case 2:
				flagSort = 2;
				isDescSorted = true;
				stk.sort(inpDesc, 0, noOfCompanies-1, flagSort);
				System.out.println("Stock prices in descending order are : ");
				for(int i=0;i< noOfCompanies; i++)
					System.out.print(inpDesc[i]+" ");
				System.out.println();
				break;
			case 3:
				int stkRiseCnt = 0;
				flagStatus = 1;
				stkRiseCnt = stkanl.getStockCnt(noOfCompanies, status, flagStatus);
				System.out.println("Total no of companies whose stock price rose today : "+ stkRiseCnt);
				break;
			case 4:
				int stkDownCnt = 0;
				flagStatus = 2;
				stkDownCnt = stkanl.getStockCnt(noOfCompanies, status, flagStatus);
				System.out.println("Total no of companies whose stock price declined today : "+ stkDownCnt);
				break;
			case 5:
				System.out.println("Enter the key value");
				double key = sc.nextDouble();
				boolean isFound = false;
				String srtOrd = " ";
				if(isAscSorted) {
					srtOrd = "A";
					isFound = stksrch.binarySearch(inpAsc, 0, noOfCompanies-1, key, srtOrd);
				}
				else if(isDescSorted) {
					srtOrd = "D";
					isFound = stksrch.binarySearch(inpDesc, 0, noOfCompanies-1, key, srtOrd);
				}
				else {
					isFound = stksrch.linearSearch(stockPrice, noOfCompanies, key);
				}
				if(isFound) 
					System.out.println("Stock of value " + key + " is present");
				else
					System.out.println("Value not found");
				break;
			default:
				System.out.println("Please enter valid option");
			}
		}while(operation!=0);
	}
}