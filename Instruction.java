package edu.mtc.egr283.project07;
/**
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/14/2021
 * @version 1.02 04.06.2021
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class Instruction {
    private String instruction;
    /**
	 * Constructor.
	 * Initialize the variables.
	 * @param String <code>Instruction</code>
	 */
	public Instruction(String instruction) {
		this.instruction="";
		this.setInstruction(instruction);
	}// Ending bracket of the constructor

	/**
	 * Sets Instruction
	 * @param String <code>Instruction</code>
	 */
	public void setInstruction(String instruction) {
		this.instruction=instruction;
	}//ending bracket of addShoppingItem

	/**
	 * Gets Instruction 
	 * @return String <code>Instruction</code>
	 */
	public String getInstruction() {
		return this.instruction;
	}//ending bracket of addShoppingItem
	
	/**
	 * Usual <code>toString</code> method.
	 * @return the <code>String</code> value of the file.
	 */
	public String toString() {
		return this.instruction;
	}// Ending bracket of method toString
}//ending bracket of class
