package edu.mtc.egr283.project07;

/**
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/14/2021
 * @version 1.00 04.06.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class Ingredient {
    private String name;
    /**
	 * Constructor.
	 * Initialize the variables.
	 * @param String <code>name</code>
	 */
	public Ingredient(String name) {
		this.setIngredient(name);
	}// Ending bracket of the constructor

	/**
	 * Sets Ingredient
	 * @param String <code>name</code>
	 */
	public void setIngredient(String name) {
		this.name=name;
	}//ending bracket of setIngredient
	
	/**
	 * gets ingredient
	 * @return String <code>ingredient</code>
	 */
	public String getIngredient() {
		return this.name;
	}//ending bracket of getIngredient

	/**
	 * Usual <code>toString</code> method.
	 * @return the <code>String</code> value of the file.
	 */
	public String toString() {
		return this.name;
	}// Ending bracket of method toString
}//ending bracket of class
