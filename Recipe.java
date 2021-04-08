package edu.mtc.egr283.project07;

/**
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/14/2021
 * @version 1.02 04.06.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
import edu.mtc.egr283.dll.DLL;

public class Recipe {
	private String name;
	private DLL<RecipeIngredient> ingredients;
	private DLL<Instruction> instructions;

	/**
	 * Constructor
	 */
	public Recipe() {
		name="";
		ingredients=new DLL<>();
		instructions=new DLL<>();
	}//end of constructor

	/**
	 * addRecipeIngredient
	 * @param String <code>ingredient</code>
	 * @param String unit
	 * @param int quantity
	 * @return String
	 */
	public String addRecipeIngredient(String ingredient, String unit, int quantity) {
		return addRecipeIngredientAtTail(new RecipeIngredient(ingredient, unit, quantity));
	}//ending bracket of addRecipeIngredient

	/**
	 * addRecipeIngredient
	 * @param RecipeIngredient sad
	 * @param int location
	 * @return String
	 */
	public String addRecipeIngredient(RecipeIngredient ri, int location) {
		return addRecipeIngredients(ri, location);
	}//ending bracket of addShoppingItem

	/**
	 * add Recipe Ingredient At Tail
	 * @param RecipeIngredient ri
	 * @return String
	 */
	public String addRecipeIngredientAtTail(RecipeIngredient ri) {
		return addRecipeIngredients(ri, this.ingredients.size());
	}//ending bracket of addRecipeIngredientAtHead

	/**
	 * add Recipe Ingredient At Head
	 * @param RecipeIngredient ri
	 * @return String
	 */
	public String addRecipeIngredientAtHead(RecipeIngredient ri) {
		return addRecipeIngredients(ri, 0);
	}//ending bracket of addRecipeIngredientAtHead
	
	/**
	 * addRecipeIngredient
	 * @param RecipeIngredient ri
	 * @param int location
	 * @return String
	 */
	private String addRecipeIngredients(RecipeIngredient ri, int location) {
		for(int i=0; i<this.ingredients.size(); i++) {
			if(this.ingredients.getDataAtPosition(i).equals(ri)) {
				return "Error, Tried adding duplicate ingredient";
			}//end of if
		}//end of for
		this.ingredients.add(ri, location);
		return "";
	}//ending bracket of addShoppingItem


	/**
	 * remove Recipe Ingredient
	 * @param String <code>name</code>
	 */
	public void removeRecipeIngredient(String name) {
		for(int i=0; i<this.ingredients.size(); i++) {
			if(this.ingredients.getDataAtPosition(i).getIngredientName().getIngredient().equalsIgnoreCase(name)) {
				this.ingredients.remove(i);
				break;
			}//end of if
		}//end of for
	}//ending bracket of removeRecipeIngredient

	/**
	 * remove Recipe Ingredient
	 * @param int <code>location</code>
	 */
	public void removeRecipeIngredient(int location) {
		this.ingredients.remove(location);
	}//ending bracket of removeRecipeIngredient

	/**
	 * adds instruction at tail
	 * @param String <code>name</code>
	 */
	public void addInstructionAtTail(Instruction name) {
		this.instructions.addAtTail(name);
	}//ending bracket of addInstructionAtTail

	/**
	 * adds instruction at position
	 * @param Instruction <code>name</code>
	 * @param int location
	 */
	public void addInstructionAtPosition(Instruction name, int location) {
		this.instructions.add(name,location);
	}//ending bracket of addInstructionAtPosition

	/**
	 * adds instruction at head
	 * @param Instruction <code>name</code>
	 */
	public void addInstructionAtHead(Instruction name) {
		this.instructions.addAtHead(name);
	}//ending bracket of addInstructionAtHead

	/**
	 * Removes Instruction
	 * @param int <code>loc</code>
	 */
	public void removeInstruction(int loc) {
		this.instructions.remove(loc-1);
	}//ending bracket of removeInstruction

	/**
	 * Sets Name
	 * @param String <code>name</code>
	 */
	public void setName(String name) {
		this.name=name;
	}//ending bracket of setName

	/**
	 * Gets Name
	 * @param String <code>name</code>
	 */
	public String getName() {
		return this.name;
	}//ending bracket of getName

	/**
	 * Displays all Instructions.
	 * @return String
	 */
	public String displayInstructions() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<this.instructions.size(); i++) {
			sb.append(i+1+". ");
			sb.append(this.instructions.getDataAtPosition(i)+"\n");
		}//end of for
		return sb.toString();
	}//end of displayInstructions

	/**
	 * Displays all Ingredients
	 * @return String
	 */
	public String displayIngredients() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<this.ingredients.size(); i++) {
			sb.append(i+1+".  ");
			sb.append(this.ingredients.getDataAtPosition(i).toString()+"\n");
		}//end of for
		return sb.toString();
	}//end of displayIngredients

	/**
	 * Displays recipe
	 * @return String
	 */
	public String displayRecipe() {
		StringBuffer sb = new StringBuffer();
		sb.append(getName()+"\n");
		sb.append("Ingredients: \n"+displayIngredients()+"\n");
		sb.append("Directions: \n"+displayInstructions()+"\n");
		return sb.toString();
	}//end of displayRecipe

}//end of class