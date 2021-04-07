package edu.mtc.egr283.project07;
/**
 * 
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/14/2021
 * @version 1.00 04.06.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class RecipeIngredient {
	private double quantity;
	private Ingredient ingredient;
	private Unit unit;

	/**
	 * Constructor.
	 * Initialize the variables.
	 * @param String <code>unit</code>
	 * @param Double <code>quantity</code>
	 * @param String <code>Ingredient</code>
	 */
	public RecipeIngredient(String ingredient, String unit, double quantity) {
		this.ingredient=new Ingredient(ingredient);
		this.unit=new Unit(unit);
		this.quantity=quantity;
	}// Ending bracket of the constructor

	
	/**
	 * Sets Quantity
	 * @param Double <code>quantity</code>
	 */
	public void setQuantity(double quantity) {
		this.quantity=quantity;
	}//ending bracket of addShoppingItem
	
	/**
	 * Gets Quantity
	 * @return Double quantity
	 */
	public double getQuantity() {
		return this.quantity;
	}//ending bracket of addShoppingItem

	/**
	 * Sets Ingredient
	 * @param String <code>Ingredient</code>
	 */
	public void setIngredient(String ingredient) {
		this.ingredient.setIngredient(ingredient);
	}//ending bracket of addShoppingItem
	
	/**
	 * Gets Ingredient
	 * @return Ingredient <code>Ingredient</code>
	 */
	public Ingredient getIngredient() {
		return this.ingredient;
	}//ending bracket of addShoppingItem

	/**
	 * Sets Unit
	 * @param String <code>name</code>
	 */
	public void setUnit(String name) {
		this.unit.setUnit(name);
	}//ending bracket of addShoppingItem
	
	/**
	 * Gets Unit
	 * @return Unit unit
	 */
	public Unit getUnit() {
		return this.unit;
	}//ending bracket of addShoppingItem

	/**
	 * Usual <code>toString</code> method.
	 * @return the <code>String</code> value of the file.
	 */
	public String toString() {
		return this.quantity+" "+this.unit.toString()+" "+this.ingredient.toString();
	}// Ending bracket of method toString

}//ending bracket of class