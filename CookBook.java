package edu.mtc.egr283.project07;

import edu.mtc.egr283.dll.DLL;

/**
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/14/2021
 * @version 1.02 05.06.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */

public class CookBook {
	private DLL<Recipe>recipe;

	/**
	 * Constructor
	 */
	public CookBook() {
		recipe=new DLL<>();
	}//End of constructor

	/**
	 * Adds A Recipe to The Recipe Box
	 * @param Recipe <code>newRecipe</code>
	 */
	public String addRecipeAtHead(Recipe newRecipe) {
		if(findRecipe(newRecipe.getName())==-1) {
			this.recipe.addAtHead(newRecipe);
			return "Succesful";
		}else { return null;
		}
	}//ending bracket of addRecipe

	/**
	 * Adds A Recipe to The Recipe Box
	 * @param Recipe <code>newRecipe</code>
	 */
	public String addRecipeAtTail(Recipe newRecipe) {
		if(findRecipe(newRecipe.getName())==-1) {
			this.recipe.addAtTail(newRecipe);
			return "Succesful";
		}else { return null;
		}
	}//ending bracket of addRecipe

	/**
	 * Adds A Recipe to The Recipe Box at position
	 * @param Recipe <code>newRecipe</code>
	 * @param int location
	 */
	public String addRecipeAtPosition(Recipe newRecipe, int location) {
		if(findRecipe(newRecipe.getName())==-1) {
			this.recipe.add(newRecipe,location-1);
			return "Succesful";
		}else { return null;
		}
	}//ending bracket of addRecipe


	/**
	 * Deletes A Recipe from The Recipe Box
	 * @param int <code>location</code>
	 */
	public void deleteRecipe(int location) {
		this.recipe.remove(location);
	}//ending bracket of deleteRecipe



	/**
	 * @return String of recipe names
	 */
	public String displayList() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<this.recipe.size(); i++) {
			sb.append(i+1+". ");
			sb.append(recipe.getDataAtPosition(i).getName()+"\n");
		}//Ending of for
		return sb.toString();
	}//emning bracket of method displayList

	/**
	 * @param searchString to search for recipe
	 * @return Recipe that was found
	 */
	public Recipe findRecipePublic(int i) {
		return recipe.getDataAtPosition(i);
	}//ending bracket of findRecipePublic

	/**
	 * @param searchString to search for recipe
	 * @return Recipe that was found
	 */
	public Recipe findRecipePublic(String searchString) {
		Recipe temp = null;
		for(int i=0; i<this.recipe.size(); i++) {
			if(this.recipe.getDataAtPosition(i).getName().equalsIgnoreCase(searchString)) {
				temp=recipe.getDataAtPosition(i);
				break;
			}//end of if
		}//end of for
		return temp;
	}//ending bracket of findRecipePublic

	/**
	 * This is a linear search.
	 * @param <code>searchString</code> the name of the Recipe to look up the record of
	 * @return int location of recipe
	 */
	public int findRecipe(String searchString) {
		int temp = -1;
		for(int i=0; i<this.recipe.size(); i++) {
			if(this.recipe.getDataAtPosition(i).getName().equalsIgnoreCase(searchString)) {
				temp=i;
				break;
			}//ending of if
		}//ending of for
		return temp;
	}// Ending bracket of method findGame

}
