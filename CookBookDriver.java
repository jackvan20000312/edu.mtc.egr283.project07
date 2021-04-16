package edu.mtc.egr283.project07;

import java.io.File;

import javax.swing.JOptionPane;

/**
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/14/2021
 * @version 1.21 04.14.2021
 * changed from using name to find recipe to using int location
 * TODO add comments
 * TODO add java doc
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class CookBookDriver {
	CookBook cookbook;
	private static final String MENU = "*********** Recipe Box ***********\r\n"
			+ "\r\n"
			+ "Select any option (1 to 9)\r\n"
			+ "1. Add a recipe at the head of the list\r\n"
			+ "2. Add a recipe at a specific location\r\n"
			+ "3. Add a recipe at the end of the list\r\n"
			+ "4. Delete a recipe\r\n"
			+ "5. Edit a recipe\r\n"
			+ "6. Display Recipe List\r\n"
			+ "7. Display the Ingredients List of a recipe\r\n"
			+ "8. Display the Instructions List of a recipe\r\n"
			+ "9. Exit \r\n";
	private static final String SUBMENU="Select any submenu option (1 to 13)\r\n"
			+ "1. Add an ingredient at the head of the list\r\n"
			+ "2. Add an ingredient at a specific location\r\n"
			+ "3. Add an ingredient at the end of the list\r\n"
			+ "4. Delete an ingredient\r\n"
			+ "5. Display the Ingredients List of a recipe\r\n"
			+ "6. Add an instruction at the head of the list\r\n"
			+ "7. Add an instruction at a specific location\r\n"
			+ "8. Add an instruction at the end of the list\r\n"
			+ "9. Delete an instruction\r\n"
			+ "10. Display the Instructions List of a recipe\r\n"
			+ "11. Go back to the main menu\r\n";
	
	public static void main(String[] args) {
		CookBookDriver cBD = new CookBookDriver();
		cBD.starter();
	}
	
	public void starter() {
		cookbook = new CookBook();
		File fil = new File("XMLFile.xml");
		cookbook = CookBookFile.read(fil);
		int option;
		do {
			option = this.promptUserInput();
			switch(option){
			case 1:
			case 2:
			case 3:
				this.add(option);
				break;
			case 4:
				this.remove();
				break;
			case 5:
				this.editRecipe();
				break;
			case 6:
				this.displayRecipeList();
				break;
			case 7:
				this.displayIngredients();
				break;
			case 8:
				this.displayInstructions();
				break;
			}// Ending bracket of switch
		}while(option != 9); 
		JOptionPane.showMessageDialog(null,"Thank you for using the Recipe Box Application","Good Bye", JOptionPane.WARNING_MESSAGE);
		File saveFile = new File("XMLFileOutput.xml");//USE for checking purposes only
		CookBookFile.write(saveFile, cookbook);
		System.exit(0);
	}// Ending bracket of method main
	
	private Recipe newRecipePrompt() {
		String tempString;
		Recipe newRecipe =new Recipe();
		boolean booleanforWhile=false;
		String sorryStringMessge="";
		//start with ingredients
		tempString = JOptionPane.showInputDialog("What is the name of the recipe?");
		newRecipe.setName(tempString);

		do {
			RecipeIngredient recipeIngredient=this.ingredientInput(sorryStringMessge);

			int jOptionPaneInt=JOptionPane.showConfirmDialog(null, "Is this correct: \n" +recipeIngredient.toString());  
			if(jOptionPaneInt==JOptionPane.YES_OPTION){  

				newRecipe.addRecipeIngredientAtTail(recipeIngredient);
				jOptionPaneInt=JOptionPane.showConfirmDialog(null, "Do You need to add another Ingredient?");
				sorryStringMessge="";
				if(jOptionPaneInt==JOptionPane.YES_OPTION){
					booleanforWhile=true;

				}else if(jOptionPaneInt==JOptionPane.NO_OPTION){
					booleanforWhile=false;
				}

			}else if(jOptionPaneInt==JOptionPane.NO_OPTION){
				booleanforWhile=true;
				sorryStringMessge="That is alright, let's try again!\n";
			}
		}while(booleanforWhile);


		do {
			Instruction instruction =this.instructionInput(sorryStringMessge);

			int jOptionPaneInt=JOptionPane.showConfirmDialog(null, "Is this correct: \n" +instruction.toString());  
			if(jOptionPaneInt==JOptionPane.YES_OPTION){  
				newRecipe.addInstructionAtTail(instruction);
				jOptionPaneInt=JOptionPane.showConfirmDialog(null, "Do You need to add another Instruction?");
				sorryStringMessge="";
				if(jOptionPaneInt==JOptionPane.YES_OPTION){
					booleanforWhile=true;

				}else if(jOptionPaneInt==JOptionPane.NO_OPTION){
					booleanforWhile=false;
				}
			}else if(jOptionPaneInt==JOptionPane.NO_OPTION){
				booleanforWhile=true;
				sorryStringMessge="That is alright, let's try again!\n";
			}
		}while(booleanforWhile);

		JOptionPane.showMessageDialog(null, newRecipe.displayRecipe());
		return newRecipe;
	}// Ending bracket of method add

	private void editRecipe() {
		int location = Integer.parseInt(JOptionPane.showInputDialog("What is the location of the recipe?"));
		promptUserInputSubMenu(location);
	}//end of editRecipe method
	
	private void displayRecipeList() {
		JOptionPane.showMessageDialog(null, this.cookbook.displayList());
	}

	private void displayIngredients() {
		int location = Integer.parseInt(JOptionPane.showInputDialog("What is the location of the recipe?"));
		JOptionPane.showMessageDialog(null, cookbook.getRecipe(location-1).displayIngredients());
	}

	private void displayInstructions() {
		int location = Integer.parseInt(JOptionPane.showInputDialog("What is the location of the recipe?"));
		JOptionPane.showMessageDialog(null, cookbook.getRecipe(location-1).displayInstructions());
	}

	private RecipeIngredient ingredientInput(String message) {
		String units = JOptionPane.showInputDialog(message+"What type of units are you using? (Tsp, Tbsp, etc.) ");
		Double quantity = Double.parseDouble(JOptionPane.showInputDialog("How many "+ units +" are you using?\n(enter as decimal if less than 1) "));
		String tempString =JOptionPane.showInputDialog("What is the Ingredient's Name?");
		return new RecipeIngredient(tempString,units,quantity);
	}

	private Instruction instructionInput(String message) {
		String tempString =JOptionPane.showInputDialog(message+"Type the instruction, then press Enter.");
		return new Instruction(tempString);
	}

	private void promptUserInputSubMenu(int location){
		int tempInt;
		Recipe tempRecipe = this.cookbook.getRecipe(location-1);
		do {
			do{
				tempInt = Integer.parseInt(JOptionPane.showInputDialog(SUBMENU));
			}while(tempInt > 11 || tempInt < 1);
			
			switch(tempInt){
			case 1:
				tempRecipe.addRecipeIngredientAtHead(this.ingredientInput(""));
				break;
			case 2:
				tempInt = Integer.parseInt(JOptionPane.showInputDialog("Position of new Ingredient"));
				tempRecipe.addRecipeIngredient(this.ingredientInput(""),tempInt-1);
				break;
			case 3:
				tempRecipe.addRecipeIngredientAtTail(this.ingredientInput(""));
				break;
			case 4:
				tempInt = Integer.parseInt(JOptionPane.showInputDialog("Position of Ingredient to Delete"));
				tempRecipe.removeRecipeIngredient(tempInt-1);
				break;
			case 5:
				JOptionPane.showMessageDialog(null, tempRecipe.displayIngredients());
				break;
			case 6:
				tempRecipe.addInstructionAtHead(this.instructionInput(""));
				break;
			case 7:
				tempInt = Integer.parseInt(JOptionPane.showInputDialog("Position of new Instruction"));
				tempRecipe.addInstructionAtPosition(this.instructionInput(""),tempInt-1);
				break;
			case 8:
				tempRecipe.addInstructionAtTail(this.instructionInput(""));
				break;
			case 9:
				tempInt = Integer.parseInt(JOptionPane.showInputDialog("Position of Instruction to be Deleted"));
				tempRecipe.removeInstruction(tempInt-1);
				break;
			case 10:
				JOptionPane.showMessageDialog(null, tempRecipe.displayInstructions());
				break;
			case 11:
				break;
			}//end of switch
			this.cookbook.updateRecipe(tempRecipe, location-1);
		}while(tempInt!=11);
	}

	private int promptUserInput() {
		int selection;
		do {
			selection = Integer.parseInt(JOptionPane.showInputDialog(MENU));
		}while(selection > 9 || selection < 1); //simple validation
		return selection;	
	}// Ending bracket of method promptUserInput

	private void remove() {
		int tempInt =Integer.parseInt(JOptionPane.showInputDialog("Type the Location of the recipe to remove"));
		this.cookbook.deleteRecipe(tempInt-1);
	}// Ending bracket of method remove

	private void add(int option) {
		if(option == 1) {
			if(this.cookbook.addRecipeAtHead(this.newRecipePrompt())==null) {
				JOptionPane.showMessageDialog(null, "Recipe is already in the recipe list", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(option == 2) {
			int location = Integer.parseInt(JOptionPane.showInputDialog("Where do you want this recipe to be located?"));
			if(this.cookbook.addRecipeAtPosition(this.newRecipePrompt(), location)==null) {
				JOptionPane.showMessageDialog(null, "Recipe is already in the recipe list", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}// Ending bracket of if

		if(option == 3) {
			if(this.cookbook.addRecipeAtTail(this.newRecipePrompt())==null) {
				JOptionPane.showMessageDialog(null, "Recipe is already in the recipe list", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}// Ending bracket of method add

}