package edu.handong.csee.java.lab09;

/**
 * This a class named 'Salesman'!
 * This defines getters and setters for 'name' and 'sales'!
 * @author JYB
 *
 */
public class Salesman {
	private String name;						// declaring instance variable 'name'
	private double sales;						// declaring instance variable 'sales'
	
	/**
	 * This is a setter named 'setName'!
	 * This sets instance variable 'name' to constructor's parameters! 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;						// update instance variable 'name' to parameter 'name'
	}
	
	/**
	 * This is a setter named 'setSales'!
	 * This sets instance variable 'sales' to constructor's parameters! 
	 * @param sales
	 */
	public void setSales(double sales) {
		this.sales = sales;							// update instance variable 'name' to parameter 'name'
	}
	
	/**
	 * This is getter named 'getName'!
	 * This gets 'name' and returns its value!
	 * @return
	 */
	public String getName() {
		return this.name;								// return the value of instance variable 'year'
	}
	
	/**
	 * This is getter named 'getSales'!
	 * This gets 'sales' and returns its value!
	 * @return
	 */
	public double getSales() {
		return this.sales;								// return the value of instance variable 'year'
	}
}
