package edu.mtc.egr283.project07;

import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;
import java.io.FileWriter;  
/**
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/14/2021
 * @version 1.00 04.12.2021
 * TODO add java docs
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class CookBookFile{  
	public static CookBook read(File file){  
		try{   
			CookBook cb = new CookBook();
			//File file = new File("XMLFile1.xml");  
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			//an instance of builder to parse the specified xml file  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(file);  
			doc.getDocumentElement().normalize();  
			NodeList nodeList = doc.getElementsByTagName("Recipe");  
			// nodeList is not iterable, so we are using for loop  
			for (int itr = 0; itr < nodeList.getLength(); itr++){  
				Node node = nodeList.item(itr);  
				if (node.getNodeType() == Node.ELEMENT_NODE){  
					Recipe rp = new Recipe();
					Element eElement = (Element) node;  
					rp.setName(eElement.getElementsByTagName("RecipeName").item(0).getTextContent()); 
					int loc=0;
					while(eElement.getElementsByTagName("Ingredient").item(loc)!=null){
						rp.addRecipeIngredientAtTail( new RecipeIngredient( eElement.getElementsByTagName("name").item(loc).getTextContent(),
								eElement.getElementsByTagName("unit").item(loc).getTextContent(), 
								Double.parseDouble(eElement.getElementsByTagName("amount").item(loc).getTextContent())));
						loc++;
					}//end of while loop for Ingredients

					loc=0;
					while(eElement.getElementsByTagName("Instruction").item(loc)!=null){
						rp.addInstructionAtTail(new Instruction(eElement.getElementsByTagName("Instruction").item(loc).getTextContent()));
						loc++;
					}//end of while loop for Instructions
					cb.addRecipeAtTail(rp);
				}//end of if statement for node
			}//end of for loop 
			return cb; 
		}catch (Exception e){   
			return null; 
		}//end of catch

	}// end of read class

	public static void write(File file, CookBook cb) {
		try{    
			FileWriter fw=new FileWriter(file);    
			fw.write(cb.toFile());    
			fw.close();    
		}catch(Exception e){System.out.println(e);}    
	}//end of catch

}  //end of write class