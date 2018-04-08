package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales;
	private double averageSales;
	private Salesman[] team;
	private int numOfSalesman;
	
	public SalesReporter() {
		System.out.println("Enter number of sales associates: ");
		
		Scanner myScanner = new Scanner(System.in);
		numOfSalesman = myScanner.nextInt();
	}
	
	public static void main(String[] args) {		
		SalesReporter myReporter = new SalesReporter();
		myReporter.getData();
		myReporter.calculateAverageSales();
		myReporter.calculateHighestSales();
		myReporter.printOutResults();
	}
	
	public void getData() {
		
		team = new Salesman[numOfSalesman];
		
		for(int i=0; i < numOfSalesman; i++) {
			Scanner myScanner = new Scanner(System.in);
			
			System.out.println("Enter data for associate number " + (i+1));
			
			System.out.println("Enter name of sales associate: ");
			String name = myScanner.nextLine();
			
			System.out.println("Enter associate's sales: ");
			double sales = myScanner.nextDouble();
			
			Salesman mySalesman = new Salesman();
			mySalesman.setName(name);
			mySalesman.setSales(sales);
			
			team[i] = mySalesman;
		}
	}
	
	public void calculateAverageSales() {
		double sum = 0;
		
		for(int i=0; i < team.length; i++) {
			double sales = team[i].getSales();
			sum = sum+sales;
		}
		
		averageSales = sum/team.length;
	}
	
	public void calculateHighestSales() {
		
		highestSales = team[0].getSales();
		for(int i=0; i < team.length-1; i++) {
			if(highestSales < team[i+1].getSales()) {
				highestSales = team[i+1].getSales();
			}
		}
	}
	
	public void printOutResults() {
		System.out.println("Average sales per associate is $ " + averageSales);
		
		System.out.println("The highest sales figure is $ " + highestSales);
		
		System.out.println("The following had the highest sales: ");
		
		for(int i=0; i < team.length; i++) {
			if(team[i].getSales() == highestSales) {
				System.out.println("Name: " + team[i].getName());
				System.out.println("Sales: $" + team[i].getSales());
				System.out.println("$" + (team[i].getSales() - averageSales) + " above the average.");
			}
		}
	}
	

}
