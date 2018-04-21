package edu.handong.csee.java.lab09;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is a class named 'SalesReporter'!
 * This defines a constructor, methods to calculate average and highest sales, and print out the result!
 * @author JYB
 *
 */
public class SalesReporter {
	private double highestSales;									// declaring instance variable 'highestSales' 
	private double averageSales;									// declaring instance variable 'averageSales'
	private ArrayList<Salesman> team = new ArrayList<Salesman>();		// declaring instance variable 'team' from class named 'Salesman'
	
	Scanner myScanner = new Scanner(System.in);						// create an object of 'Scanner' class, 'myScanner'
		
	/**
	 * This is the main method!
	 * @param args
	 */
	public static void main(String[] args) {		
		SalesReporter myReporter = new SalesReporter();					// instantiating the class 'SalesReporter' to 'myReporter'
		myReporter.getData();											// calling the method 'getData' to 'myReporter'
		myReporter.calculateAverageSales();								// calling the method 'calculateAverageSales' to 'myReporter'
		myReporter.calculateHighestSales();								// calling the method 'calculateHighestSales' to 'myReporter'
		myReporter.printOutResults();									// calling the method 'printOutResults' to 'myReporter'
	}
	
	/**
	 * This is a method named 'getData'!
	 * This repeatedly gets the input!
	 */
	public void getData() {	
		int count=1;
		while(true) {															// repeat without any condition
			System.out.println("Enter data for associate number "+ count);		// print out a message to get input and the number of associate 
						
			System.out.print("Enter name of sales associate:");
			String name = myScanner.nextLine();									// getting the input 'name'
			
			System.out.print("Enter associate's sales: $");
			double sales = myScanner.nextDouble();								// getting the input 'sales'
			
			Salesman mySalesman = new Salesman();								// setting the variable 'Salesman' to 'mySalesman'
			mySalesman.setName(name);											// calling the method 'setName' to 'mySalesman'
			mySalesman.setSales(sales);											// calling the method 'setSales' to 'mySalesman'
			
			team.add(mySalesman);
			
			myScanner.nextLine();												// empty the buffer '\n'
			
			System.out.print("More data for the list? ");						
			String ans = myScanner.nextLine();									// ask to get more data for the list
			count++;															// increase count
			
			if(ans.equals("no"))									
				break;															// if 'ans' is "no", break the loop
			
		}
	}
	
	/**
	 * This is a method named 'calculateAverageSales'!
	 * This calculates the average of all 'sales'!
	 */
	public void calculateAverageSales() {
		double sum = 0;												// declare a variable 'sum' and initiate to 0
			
		for(Salesman mySalesman: team) {							// repeat for the length of team
			double sales = mySalesman.getSales();					// calling the method 'getSales' and putting into variable 'sales'
			sum = sum+sales;										// update the sum of all 'sales'
		}
		
		averageSales = sum/team.size();								// calculating the average of 'sales'
	}
	
	/**
	 * This is a method named 'calculateHighestSales'!
	 * This calculates the highest among all 'sales'!
	 */
	public void calculateHighestSales() {
		
		highestSales = team.get(0).getSales();							// setting the instance variable 'highestSales' to 'team.get(0).getSales()'
		
		for(Salesman mySalesman: team) {								// repeat for the length of team
			if(highestSales < mySalesman.getSales()) {					
				highestSales = mySalesman.getSales();					// if highestSales<mySalesman.getSales(), update 'highestSales'
			}
		}
	}
	
	/**
	 * This is a method named 'printOutResults'!
	 * This prints out the result!
	 */
	public void printOutResults() {
		System.out.println("Average sales per associate is $ " + averageSales);			// print the average of all 'sales'
		
		System.out.println("The highest sales figure is $ " + highestSales);			// print the highest among all 'sales'
		
		System.out.println("The following had the highest sales: ");					// print detail information of highest sales
		
		for(Salesman mySalesman: team) {											
			if(mySalesman.getSales() == highestSales) {
				System.out.println("Name: " + mySalesman.getName());
				System.out.println("Sales: $" +mySalesman.getSales());
				System.out.println("$" + (mySalesman.getSales() - averageSales) + " above the average.");
			}	// if mySalesman.getSales() equals to 'highestSales', print detail information of 'mySalesman'
		}
	}
	

}
