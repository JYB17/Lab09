package edu.handong.csee.java.lab09;

import java.util.Scanner;

/**
 * This is a class named 'SalesReporter'!
 * This defines a constructor, methods to calculate average and highest sales, and print out the result!
 * @author JYB
 *
 */
public class SalesReporter {
	private double highestSales;								// declaring instance variable 'highestSales' 
	private double averageSales;								// declaring instance variable 'averageSales'
	private Salesman[] team;									// declaring instance variable 'team' from class named 'Salesman'
	private int numOfSalesman;									// declaring instance variable 'numOfSalesman'
	
	Scanner myScanner = new Scanner(System.in);					// create an object of 'Scanner' class, 'myScanner'
	
	/**
	 * This is a default constructor!
	 * This gets the number of sales associates from user!
	 */
	public SalesReporter() {		
		System.out.print("Enter number of sales associates: ");
		numOfSalesman = myScanner.nextInt();							// getting the input 'numOfSalesman'
	}
	
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
	 * This repeatedly gets the inputs and update 'team[i]'!
	 */
	public void getData() {
		
		team = new Salesman[numOfSalesman];										// setting the instance variable 'team' to 'Salesman' with array size of 'numOfSalesman'
		
		for(int i=0; i < numOfSalesman; i++) {									// repeat until i<numOfSalesman and i++
			System.out.println("Enter data for associate number " + (i+1));		// print out a message to get input and the number of associate 
			
			myScanner.nextLine();												// empty the buffer '\n'
			
			System.out.print("Enter name of sales associate:");
			String name = myScanner.nextLine();									// getting the input 'name'
			
			System.out.print("Enter associate's sales: $");
			double sales = myScanner.nextDouble();								// getting the input 'sales'
			
			Salesman mySalesman = new Salesman();								// setting the variable 'Salesman' to 'mySalesman'
			mySalesman.setName(name);											// calling the method 'setName' to 'mySalesman'
			mySalesman.setSales(sales);											// calling the method 'setSales' to 'mySalesman'
			
			team[i] = mySalesman;												// updating the variable 'team[i]
		}
	}
	
	/**
	 * This is a method named 'calculateAverageSales'!
	 * This calculates the average of all 'sales'!
	 */
	public void calculateAverageSales() {
		double sum = 0;													// declare a variable 'sum' and initiate to 0
			
		for(int i=0; i < team.length; i++) {						// repeat until i<tem.length and i++
			double sales = team[i].getSales();						// calling the method 'getSales' and putting into variable 'sales'
			sum = sum+sales;										// update the sum of all 'sales'
		}
		
		averageSales = sum/team.length;								// calculating the average of 'sales'
	}
	
	/**
	 * This is a method named 'calculateHighestSales'!
	 * This calculates the highest among all 'sales'!
	 */
	public void calculateHighestSales() {
		
		highestSales = team[0].getSales();								// setting the instance variable 'highestSales' to 'team[0].getSales()'
		for(int i=0; i < team.length-1; i++) {							// repeat until i<team.length-1 and i++
			if(highestSales < team[i+1].getSales()) {					
				highestSales = team[i+1].getSales();					// if highestSales<team[i+1].getSales(), update 'highestSales'
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
		
		for(int i=0; i < team.length; i++) {											// repeat until i<team.length and i++
			if(team[i].getSales() == highestSales) {
				System.out.println("Name: " + team[i].getName());
				System.out.println("Sales: $" + team[i].getSales());
				System.out.println("$" + (team[i].getSales() - averageSales) + " above the average.");
			}	// if team[i].getSales() equals to 'highestSales', print detail information of 'team[i]'
		}
	}
	

}
