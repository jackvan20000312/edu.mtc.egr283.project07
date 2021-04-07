package edu.mtc.egr283.project07;

/**
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/14/2021
 * @version 1.02 04.06.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class Unit {
    private String name;

	/**
	 * Constructor.
	 * Initialize the variables.
	 * @param String <code>name</code>
	 */
	public Unit(String name) {
		this.setUnit(name);
	}// Ending bracket of the constructor

	/**
	 * Sets Unit
	 * @param String <code>name</code>
	 */
	public void setUnit(String name) {
		this.name=name;
	}//ending bracket of addShoppingItem

	/**
	 * Usual <code>toString</code> method.
	 * @return the <code>String</code> value of the file.
	 */
	public String toString() {
		return this.name;
	}// Ending bracket of method toString
	
}//ending bracket of class
