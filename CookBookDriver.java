package edu.mtc.egr283.project07;

import javax.swing.JOptionPane;

/**
 * @author Doran and Remy
 *
 */
public class CookBookDriver {
	CookBook cookbook = new CookBook();
	
	public static void main(String[] args) {
		CookBookDriver cBD = new CookBookDriver();
		cBD.main();
	}
	
	
	public void main() {
		cookbook = new CookBook();
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
		System.exit(0);
	}// Ending bracket of method main

	private int promptUserInput() {
		int selection;
		do {
			//the menu
			String menu = "*********** Recipe Box ***********\r\n"
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
			selection = Integer.parseInt(JOptionPane.showInputDialog(menu));

		}while(selection > 9 || selection < 1); //simple validation

		return selection;	
	}// Ending bracket of method promptUserInput

	private void remove() {
		int tempInt =Integer.parseInt(JOptionPane.showInputDialog("Type the name of the recipe to remove"));
		this.cookbook.deleteRecipe(tempInt);
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

	public Recipe newRecipePrompt() {
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
			}else if(tempString.charAt(0)==('n')){
				booleanforWhile=true;
				sorryStringMessge="That is alright, let's try again!\n";
			}
		}while(booleanforWhile);

		JOptionPane.showMessageDialog(null, newRecipe.displayRecipe());
		return newRecipe;
	}// Ending bracket of method add

	public void editRecipe() {
		String tempString = JOptionPane.showInputDialog("What is the name of the recipe?");
		Recipe tempRecipe = this.cookbook.findRecipePublic(tempString);
		if(tempRecipe==null) {
			System.out.println("Recipe is not in the recipe list");
		}else {
			String subMenu="Select any submenu option (1 to 13)\r\n"
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
			int tempInt = Integer.parseInt(JOptionPane.showInputDialog(subMenu));
			switch(tempInt){
			case 1:
				tempRecipe.addRecipeIngredientAtHead(this.ingredientInput(""));
				break;
			case 2:
				tempInt = Integer.parseInt(JOptionPane.showInputDialog("Position of new Ingredient"));
				tempRecipe.addRecipeIngredient(this.ingredientInput(""),tempInt);
				break;
			case 3:
				tempRecipe.addRecipeIngredientAtTail(this.ingredientInput(""));
				break;
			case 4:
				tempInt = Integer.parseInt(JOptionPane.showInputDialog("Position of Ingredient to Delete"));
				tempRecipe.removeRecipeIngredient(tempInt);
				break;
			case 5:
				JOptionPane.showMessageDialog(null, tempRecipe.displayIngredients());
				break;
			case 6:
				tempRecipe.addInstructionAtHead(this.instructionInput(""));
				break;
			case 7:
				tempInt = Integer.parseInt(JOptionPane.showInputDialog("Position of new Instruction"));
				tempRecipe.addInstructionAtPosition(this.instructionInput(""),tempInt);
				break;
			case 8:
				tempRecipe.addInstructionAtTail(this.instructionInput(""));
				break;
			case 9:
				tempInt = Integer.parseInt(JOptionPane.showInputDialog("Position of Instruction to be Deleted"));
				tempRecipe.removeInstruction(tempInt);
				break;
			case 10:
				JOptionPane.showMessageDialog(null, tempRecipe.displayInstructions());
				break;
			case 11:
				break;
			}//end of switch
			int locate=this.cookbook.findRecipe(tempString);
			this.cookbook.deleteRecipe(locate);
			this.cookbook.addRecipeAtPosition(tempRecipe, locate);
			
		}//end of else statement
	}//end of editRecipe method

	public void displayRecipeList() {
		JOptionPane.showMessageDialog(null, this.cookbook.displayList());

	}

	public void displayIngredients() {
		String units = JOptionPane.showInputDialog("Name of Recipe to view");
		JOptionPane.showMessageDialog(null, cookbook.findRecipePublic(units).displayIngredients());
	}

	public void displayInstructions() {
		String units = JOptionPane.showInputDialog("Name of Recipe to view");
		JOptionPane.showMessageDialog(null, cookbook.findRecipePublic(units).displayInstructions());
	}

	public RecipeIngredient ingredientInput(String message) {
		String units = JOptionPane.showInputDialog(message+"What type of units are you using? (Tsp, Tbsp, etc.) ");
		Double quantity = Double.parseDouble(JOptionPane.showInputDialog("How many "+ units +" are you using?\n(enter as decimal if less than 1) "));
		String tempString =JOptionPane.showInputDialog("What is the Ingredient's Name?");

		return new RecipeIngredient(tempString,units,quantity);
	}

	public Instruction instructionInput(String message) {
		String tempString =JOptionPane.showInputDialog(message+"Type the instruction, then press Enter.");
		return new Instruction(tempString);
	}




}

