package edu.mtc.egr283.project07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUITest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_amount;
	private JTextField textField_unit_new;
	private JTextField textField_ingredient_name_new;
	private JTextField instructiontextfield;
	private JTextField recipenametextfiled;
	private JTextField textField_ingred_position;
	private JTextField textField_positioninstruction;
	private JTextField textField_recipe_position;
	private JTextField amount_TextField;
	private JTextField textField_unit;
	private JTextField textField_Ingredient_Name;
	private JTextField textField_Instructions;
	private JTextField textField_Recipe_name;
	private JTextField textField_Ingredient_Position;
	private JTextField textField_instruction_position;
	private JTextField textField_8;
private CookBook cookbook;
private Recipe tempRecipe;
private static int location;
private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITest frame = new GUITest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUITest() {
		tempRecipe=new Recipe();
		cookbook = new CookBook();
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//windows- favorite!
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");//Motif Style Really Ugly
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");//Java
			//for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {if ("Nimbus".equals(info.getName())) {UIManager.setLookAndFeel(info.getClassName());}}//Nimbus Style
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		
		
		JDesktopPane mainPane = new JDesktopPane();
		mainPane.setBackground(Color.WHITE);
		contentPane.add(mainPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 515, 629);
		mainPane.add(tabbedPane);

		JDesktopPane Tabbed_Pane_New_Recipe = new JDesktopPane();
		Tabbed_Pane_New_Recipe.setBackground(Color.WHITE);
		tabbedPane.addTab("New Recipe", null, Tabbed_Pane_New_Recipe, null);
		
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(535, 32, 280, 608);
		mainPane.add(scrollPane_2);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		scrollPane_2.setViewportView(textPane_1);


		JScrollPane scrollPane_NewRecipePreview = new JScrollPane();
		scrollPane_NewRecipePreview.setBounds(10, 281, 490, 251);
		Tabbed_Pane_New_Recipe.add(scrollPane_NewRecipePreview);
		
		JTextPane textPane_NewRecipePreview = new JTextPane();
		textPane_NewRecipePreview.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane_NewRecipePreview.setEditable(false);
		scrollPane_NewRecipePreview.setViewportView(textPane_NewRecipePreview);
		
		textField_amount = new JTextField();
		textField_amount.setBounds(10, 36, 86, 20);
		Tabbed_Pane_New_Recipe.add(textField_amount);
		textField_amount.setColumns(10);

		textField_unit_new = new JTextField();
		textField_unit_new.setBounds(106, 36, 86, 20);
		Tabbed_Pane_New_Recipe.add(textField_unit_new);
		textField_unit_new.setColumns(10);

		textField_ingredient_name_new = new JTextField();
		textField_ingredient_name_new.setBounds(202, 36, 150, 20);
		Tabbed_Pane_New_Recipe.add(textField_ingredient_name_new);
		textField_ingredient_name_new.setColumns(10);

		JLabel amount_label = new JLabel("Amount");
		amount_label.setHorizontalAlignment(SwingConstants.CENTER);
		amount_label.setBounds(10, 11, 86, 14);
		Tabbed_Pane_New_Recipe.add(amount_label);
		amount_label.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel unit_label = new JLabel("Unit");
		unit_label.setHorizontalAlignment(SwingConstants.CENTER);
		unit_label.setBounds(106, 11, 86, 14);
		Tabbed_Pane_New_Recipe.add(unit_label);
		unit_label.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel ingredient_name_label = new JLabel("Ingredient Name");
		ingredient_name_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ingredient_name_label.setHorizontalAlignment(SwingConstants.CENTER);
		ingredient_name_label.setBounds(202, 12, 150, 14);
		Tabbed_Pane_New_Recipe.add(ingredient_name_label);

		JButton addingredientattop = new JButton("Add Ingredient At Top");
		addingredientattop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.addRecipeIngredientAtHead(new RecipeIngredient(textField_ingredient_name_new.getText(),textField_unit_new.getText(), Double.parseDouble(textField_amount.getText())));
				textPane_NewRecipePreview.setText(tempRecipe.displayRecipe());
				textField_amount.setText("");
				textField_unit_new.setText("");
				textField_ingredient_name_new.setText("");
				repaint();
			}
		});
		addingredientattop.setBounds(10, 67, 139, 23);
		Tabbed_Pane_New_Recipe.add(addingredientattop);

		JSeparator speratesinstrcutionsandingredients = new JSeparator();
		speratesinstrcutionsandingredients.setBounds(10, 101, 490, 2);
		Tabbed_Pane_New_Recipe.add(speratesinstrcutionsandingredients);
		speratesinstrcutionsandingredients.setForeground(Color.BLACK);
		speratesinstrcutionsandingredients.setBackground(Color.BLACK);

		JLabel instructionslabel = new JLabel("Instructions");
		instructionslabel.setHorizontalAlignment(SwingConstants.CENTER);
		instructionslabel.setBounds(10, 114, 342, 14);
		Tabbed_Pane_New_Recipe.add(instructionslabel);
		instructionslabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		instructiontextfield = new JTextField();
		instructiontextfield.setBounds(10, 139, 342, 20);
		Tabbed_Pane_New_Recipe.add(instructiontextfield);
		instructiontextfield.setColumns(10);

		JLabel recipenamelabel = new JLabel("Recipe Name");
		recipenamelabel.setHorizontalAlignment(SwingConstants.CENTER);
		recipenamelabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		recipenamelabel.setBounds(10, 217, 86, 20);
		Tabbed_Pane_New_Recipe.add(recipenamelabel);

		recipenametextfiled = new JTextField();
		recipenametextfiled.setBounds(106, 218, 269, 20);
		Tabbed_Pane_New_Recipe.add(recipenametextfiled);
		recipenametextfiled.setColumns(10);

		JButton addnamebutton = new JButton("Add Name");
		addnamebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.setName(recipenametextfiled.getText());
				textPane_NewRecipePreview.setText(tempRecipe.displayRecipe());
				recipenametextfiled.setText("");
				repaint();
			}
		});
		addnamebutton.setBounds(385, 217, 115, 23);
		Tabbed_Pane_New_Recipe.add(addnamebutton);

		JSeparator separator_recipename_instrcutor = new JSeparator();
		separator_recipename_instrcutor.setForeground(Color.BLACK);
		separator_recipename_instrcutor.setBackground(Color.BLACK);
		separator_recipename_instrcutor.setBounds(10, 204, 490, 2);
		Tabbed_Pane_New_Recipe.add(separator_recipename_instrcutor);

		textField_ingred_position = new JTextField();
		textField_ingred_position.setBounds(362, 36, 138, 20);
		Tabbed_Pane_New_Recipe.add(textField_ingred_position);
		textField_ingred_position.setColumns(10);

		JLabel lblNewLabel_position = new JLabel("Position(optional)");
		lblNewLabel_position.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_position.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_position.setBounds(362, 11, 138, 14);
		Tabbed_Pane_New_Recipe.add(lblNewLabel_position);

		JButton btnNewButton_ingredientaddbottom = new JButton("Add Ingredient At Bottom");
		btnNewButton_ingredientaddbottom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.addRecipeIngredientAtTail(new RecipeIngredient(textField_ingredient_name_new.getText(),textField_unit_new.getText(), Double.parseDouble(textField_amount.getText())));
				textPane_NewRecipePreview.setText(tempRecipe.displayRecipe());
				textField_amount.setText("");
				textField_unit_new.setText("");
				textField_ingredient_name_new.setText("");
				repaint();
			}
		});
		btnNewButton_ingredientaddbottom.setBounds(159, 67, 159, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_ingredientaddbottom);

		JButton btnNewButton_ingredientaddatposition = new JButton("Add Ingredient At Position");
		btnNewButton_ingredientaddatposition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.addRecipeIngredient(new RecipeIngredient(textField_ingredient_name_new.getText(),textField_unit_new.getText(), Double.parseDouble(textField_amount.getText())), Integer.parseInt(textField_ingred_position.getText())-1);
				textPane_NewRecipePreview.setText(tempRecipe.displayRecipe());
				textField_amount.setText("");
				textField_unit_new.setText("");
				textField_ingredient_name_new.setText("");
				textField_ingred_position.setText("");
				repaint();
			}
		});
		btnNewButton_ingredientaddatposition.setBounds(328, 67, 172, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_ingredientaddatposition);

		textField_positioninstruction = new JTextField();
		textField_positioninstruction.setColumns(10);
		textField_positioninstruction.setBounds(362, 139, 138, 20);
		Tabbed_Pane_New_Recipe.add(textField_positioninstruction);

		JLabel lblNewLabel_position_instruction = new JLabel("Position(optional)");
		lblNewLabel_position_instruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_position_instruction.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_position_instruction.setBounds(362, 115, 138, 14);
		Tabbed_Pane_New_Recipe.add(lblNewLabel_position_instruction);

		JButton btnAddInstructionAtTop = new JButton("Add Instruction At Top");
		btnAddInstructionAtTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.addInstructionAtHead(new Instruction(instructiontextfield.getText()));
				textPane_NewRecipePreview.setText(tempRecipe.displayRecipe());
				instructiontextfield.setText("");
				repaint();
			}
		});
		btnAddInstructionAtTop.setBounds(10, 170, 150, 23);
		Tabbed_Pane_New_Recipe.add(btnAddInstructionAtTop);

		JButton btnAddInstructionAtBottom = new JButton("Add Instruction At Bottom");
		btnAddInstructionAtBottom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.addInstructionAtTail(new Instruction(instructiontextfield.getText()));
				textPane_NewRecipePreview.setText(tempRecipe.displayRecipe());
				instructiontextfield.setText("");
				repaint();
			}
		});
		btnAddInstructionAtBottom.setBounds(170, 170, 159, 23);
		Tabbed_Pane_New_Recipe.add(btnAddInstructionAtBottom);

		JButton btnAddInstructionAtPosition = new JButton("Add Instruction At Position");
		btnAddInstructionAtPosition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.addInstructionAtPosition(new Instruction(instructiontextfield.getText()), Integer.parseInt(textField_ingred_position.getText()));
				textPane_NewRecipePreview.setText(tempRecipe.displayRecipe());
				instructiontextfield.setText("");
				textField_positioninstruction.setText("");
				repaint();
			}
		});
		btnAddInstructionAtPosition.setBounds(338, 170, 162, 23);
		Tabbed_Pane_New_Recipe.add(btnAddInstructionAtPosition);

		JSeparator separator_name_preview = new JSeparator();
		separator_name_preview.setForeground(Color.BLACK);
		separator_name_preview.setBackground(Color.BLACK);
		separator_name_preview.setBounds(10, 248, 490, 2);
		Tabbed_Pane_New_Recipe.add(separator_name_preview);

		JLabel lblNewLabel_preview = new JLabel("Recipe Preview");
		lblNewLabel_preview.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_preview.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_preview.setBounds(10, 250, 490, 20);
		Tabbed_Pane_New_Recipe.add(lblNewLabel_preview);


		JButton btnNewButton_addrecipeattop = new JButton("Add Recipe At Top");
		btnNewButton_addrecipeattop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cookbook.addRecipeAtHead(tempRecipe);
				tempRecipe=new Recipe();
				instructiontextfield.setText("");
				textField_positioninstruction.setText("");
				textField_amount.setText("");
				textField_unit_new.setText("");
				textField_ingredient_name_new.setText("");
				textField_ingred_position.setText("");
				textPane_NewRecipePreview.setText("");
				textPane_1.setText(cookbook.displayList());
				repaint();
			}
		});
		btnNewButton_addrecipeattop.setBounds(10, 543, 139, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_addrecipeattop);

		JButton btnNewButton_tobottomrecipe = new JButton("Add Recipe at Bottom");
		btnNewButton_tobottomrecipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cookbook.addRecipeAtTail(tempRecipe);
				tempRecipe=new Recipe();
				instructiontextfield.setText("");
				textField_positioninstruction.setText("");
				textField_amount.setText("");
				textField_unit_new.setText("");
				textField_ingredient_name_new.setText("");
				textField_ingred_position.setText("");
				textPane_NewRecipePreview.setText("");
				textPane_1.setText(cookbook.displayList());
				repaint();
			}
		});
		btnNewButton_tobottomrecipe.setBounds(179, 543, 150, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_tobottomrecipe);

		JButton btnNewButton_topositionrecipe = new JButton("Add Recipe at Position");
		btnNewButton_topositionrecipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cookbook.addRecipeAtPosition(tempRecipe, Integer.parseInt(textField_recipe_position.getText()));
				tempRecipe=new Recipe();
				instructiontextfield.setText("");
				textField_positioninstruction.setText("");
				textField_amount.setText("");
				textField_unit_new.setText("");
				textField_ingredient_name_new.setText("");
				textField_ingred_position.setText("");
				textField_recipe_position.setText("");
				textPane_NewRecipePreview.setText("");
				textPane_1.setText(cookbook.displayList());
				repaint();
			}
		});
		btnNewButton_topositionrecipe.setBounds(361, 543, 139, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_topositionrecipe);

		textField_recipe_position = new JTextField();
		textField_recipe_position.setBounds(450, 570, 50, 20);
		Tabbed_Pane_New_Recipe.add(textField_recipe_position);
		textField_recipe_position.setColumns(10);

		JLabel lblNewLabel_position_recipe = new JLabel("Position");
		lblNewLabel_position_recipe.setBounds(404, 573, 46, 14);
		Tabbed_Pane_New_Recipe.add(lblNewLabel_position_recipe);

		JDesktopPane TabbedPane_Edit_recipe = new JDesktopPane();
		TabbedPane_Edit_recipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe=new Recipe();
				instructiontextfield.setText("");
				textField_positioninstruction.setText("");
				textField_amount.setText("");
				textField_unit_new.setText("");
				textField_ingredient_name_new.setText("");
				textField_ingred_position.setText("");
				textField_recipe_position.setText("");
				textPane_NewRecipePreview.setText("");
				textPane_1.setText(cookbook.displayList());
				repaint();
				
			}
		});
		TabbedPane_Edit_recipe.setBackground(Color.WHITE);
		tabbedPane.addTab("Edit Recipe", null, TabbedPane_Edit_recipe, null);

		Tabbed_Pane_New_Recipe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe=null;
				instructiontextfield.setText("");
				textField_positioninstruction.setText("");
				textField_amount.setText("");
				textField_unit_new.setText("");
				textField_ingredient_name_new.setText("");
				textField_ingred_position.setText("");
				textField_recipe_position.setText("");
				textPane_NewRecipePreview.setText("");
				textPane_1.setText(cookbook.displayList());
				repaint();
				
			}
		});
		
		amount_TextField = new JTextField();
		amount_TextField.setColumns(10);
		amount_TextField.setBounds(10, 65, 86, 20);
		TabbedPane_Edit_recipe.add(amount_TextField);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 378, 490, 212);
		TabbedPane_Edit_recipe.add(scrollPane_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane_1.setViewportView(textPane);
		
		textField_unit = new JTextField();
		textField_unit.setColumns(10);
		textField_unit.setBounds(106, 65, 86, 20);
		TabbedPane_Edit_recipe.add(textField_unit);

		textField_Ingredient_Name = new JTextField();
		textField_Ingredient_Name.setColumns(10);
		textField_Ingredient_Name.setBounds(202, 65, 150, 20);
		TabbedPane_Edit_recipe.add(textField_Ingredient_Name);

		JLabel lblNewLabel_Amount = new JLabel("Amount");
		lblNewLabel_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Amount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Amount.setBounds(10, 40, 86, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Amount);

		JLabel lblNewLabel_Unit = new JLabel("Unit");
		lblNewLabel_Unit.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Unit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Unit.setBounds(106, 40, 86, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Unit);

		JLabel lblNewLabel_Ingredient_Name = new JLabel("Ingredient Name");
		lblNewLabel_Ingredient_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Ingredient_Name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Ingredient_Name.setBounds(202, 40, 150, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Ingredient_Name);

		JButton btnNewButton_Add_Ingredient_At_top = new JButton("Add Ingredient At Top");
		btnNewButton_Add_Ingredient_At_top.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tempRecipe!=null) {
					tempRecipe.addRecipeIngredientAtHead(new RecipeIngredient(textField_Ingredient_Name.getText(),textField_unit.getText(), Double.parseDouble(amount_TextField.getText())));
					//, Integer.parseInt(textField_ingred_position.getText())-1
					amount_TextField.setText("");
					textField_unit.setText("");
					textField_Ingredient_Name.setText("");
					textField_Ingredient_Position.setText("");
					textPane.setText(tempRecipe.displayRecipe());
				}else {
					textPane.setText("Error No recipe found?");
				}
			}
		});
		btnNewButton_Add_Ingredient_At_top.setBounds(10, 96, 139, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_Add_Ingredient_At_top);

		JLabel lblNewLabel_Instructions = new JLabel("Instructions");
		lblNewLabel_Instructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Instructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Instructions.setBounds(10, 175, 342, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Instructions);

		textField_Instructions = new JTextField();
		textField_Instructions.setColumns(10);
		textField_Instructions.setBounds(10, 200, 342, 20);
		TabbedPane_Edit_recipe.add(textField_Instructions);

		JLabel lblNewLabel_Recipe_name = new JLabel("Recipe Name");
		lblNewLabel_Recipe_name.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Recipe_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Recipe_name.setBounds(10, 316, 86, 20);
		TabbedPane_Edit_recipe.add(lblNewLabel_Recipe_name);

		textField_Recipe_name = new JTextField();
		textField_Recipe_name.setColumns(10);
		textField_Recipe_name.setBounds(106, 317, 269, 20);
		TabbedPane_Edit_recipe.add(textField_Recipe_name);

		JButton btnNewButton_Set_New_Name = new JButton("Set New Name");
		btnNewButton_Set_New_Name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tempRecipe!=null) {
					tempRecipe.setName(textField_Recipe_name.getText());
					textField_Recipe_name.setText("");
					textPane.setText(tempRecipe.displayRecipe());
				}else {
					textPane.setText("Error No recipe found?");
				}
				
			}
		});
		btnNewButton_Set_New_Name.setBounds(385, 316, 115, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_Set_New_Name);

		JSeparator separator_Instructions_Recipe_name = new JSeparator();
		separator_Instructions_Recipe_name.setForeground(Color.BLACK);
		separator_Instructions_Recipe_name.setBackground(Color.BLACK);
		separator_Instructions_Recipe_name.setBounds(10, 299, 490, 2);
		TabbedPane_Edit_recipe.add(separator_Instructions_Recipe_name);

		textField_Ingredient_Position = new JTextField();
		textField_Ingredient_Position.setColumns(10);
		textField_Ingredient_Position.setBounds(362, 65, 138, 20);
		TabbedPane_Edit_recipe.add(textField_Ingredient_Position);

		JLabel lblNewLabel_Ingredient_Position = new JLabel("Position(optional)");
		lblNewLabel_Ingredient_Position.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Ingredient_Position.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Ingredient_Position.setBounds(362, 40, 138, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Ingredient_Position);

		JButton btnNewButton_Add_ingredient_at_bottom = new JButton("Add Ingredient At Bottom");
		btnNewButton_Add_ingredient_at_bottom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tempRecipe!=null) {
					tempRecipe.addRecipeIngredientAtTail(new RecipeIngredient(textField_Ingredient_Name.getText(),textField_unit.getText(), Double.parseDouble(amount_TextField.getText())));
					//, Integer.parseInt(textField_ingred_position.getText())-1
					amount_TextField.setText("");
					textField_unit.setText("");
					textField_Ingredient_Name.setText("");
					textField_Ingredient_Position.setText("");
					textPane.setText(tempRecipe.displayRecipe());
				}else {
					textPane.setText("Error No recipe found?");
				}
			}
		});
		btnNewButton_Add_ingredient_at_bottom.setBounds(159, 96, 159, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_Add_ingredient_at_bottom);

		JButton btnNewButton_add_ingredient_at_position = new JButton("Add Ingredient At Position");
		btnNewButton_add_ingredient_at_position.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tempRecipe!=null) {
					tempRecipe.addRecipeIngredient(new RecipeIngredient(textField_Ingredient_Name.getText(),textField_unit.getText(), Double.parseDouble(amount_TextField.getText())), Integer.parseInt(textField_Ingredient_Position.getText())-1);
					amount_TextField.setText("");
					textField_unit.setText("");
					textField_Ingredient_Name.setText("");
					textField_Ingredient_Position.setText("");
					textPane.setText(tempRecipe.displayRecipe());
				}else {
					textPane.setText("Error No recipe found?");
				}
			}
		});
		btnNewButton_add_ingredient_at_position.setBounds(328, 96, 172, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_add_ingredient_at_position);

		textField_instruction_position = new JTextField();
		textField_instruction_position.setColumns(10);
		textField_instruction_position.setBounds(362, 200, 138, 20);
		TabbedPane_Edit_recipe.add(textField_instruction_position);

		JLabel lblNewLabel_instrcution_position = new JLabel("Position(optional)");
		lblNewLabel_instrcution_position.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_instrcution_position.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_instrcution_position.setBounds(362, 175, 138, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_instrcution_position);

		JButton btnAddInstructionAt_Top = new JButton("Add Instruction At Top");
		btnAddInstructionAt_Top.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					tempRecipe.addInstructionAtHead(new Instruction(textField_Instructions.getText()));
					textField_Instructions.setText("");
					textField_instruction_position.setText("");
					textPane.setText(tempRecipe.displayRecipe());
			}
		});
		btnAddInstructionAt_Top.setBounds(10, 231, 150, 23);
		TabbedPane_Edit_recipe.add(btnAddInstructionAt_Top);

		JButton btnAddInstructionAt_Bottom = new JButton("Add Instruction At Bottom");
		btnAddInstructionAt_Bottom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tempRecipe!=null) {
					tempRecipe.addInstructionAtTail(new Instruction(textField_Instructions.getText()));
					textField_Instructions.setText("");
					textField_instruction_position.setText("");
					textPane.setText(tempRecipe.displayRecipe());
				}else {
					textPane.setText("Error No recipe found?");
				}
			}
		});
		btnAddInstructionAt_Bottom.setBounds(170, 231, 159, 23);
		TabbedPane_Edit_recipe.add(btnAddInstructionAt_Bottom);

		JButton btnAddInstructionAt_Position = new JButton("Add Instruction At Position");
		btnAddInstructionAt_Position.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tempRecipe!=null) {
					tempRecipe.addInstructionAtPosition(new Instruction(textField_Instructions.getText()), Integer.parseInt(textField_instruction_position.getText())-1);
					textField_Instructions.setText("");
					textField_instruction_position.setText("");
					textPane.setText(tempRecipe.displayRecipe());
				}else {
					textPane.setText("Error No recipe found?");
				}
			}
		});
		btnAddInstructionAt_Position.setBounds(338, 231, 162, 23);
		TabbedPane_Edit_recipe.add(btnAddInstructionAt_Position);

		JSeparator separator_ingredients_instrcutions = new JSeparator();
		separator_ingredients_instrcutions.setForeground(Color.BLACK);
		separator_ingredients_instrcutions.setBackground(Color.BLACK);
		separator_ingredients_instrcutions.setBounds(10, 164, 490, 2);
		TabbedPane_Edit_recipe.add(separator_ingredients_instrcutions);

		JButton btnNewButton_remove_ingredient = new JButton("Remove Ingredient At Position");
		btnNewButton_remove_ingredient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tempRecipe!=null) {
					tempRecipe.removeRecipeIngredient(Integer.parseInt(textField_Ingredient_Position.getText())-1);
					textField_Ingredient_Position.setText("");
					textPane.setText(tempRecipe.displayRecipe());
				}else {
					textPane.setText("Error No recipe found?");
				}
			}
		});
		btnNewButton_remove_ingredient.setBounds(301, 130, 199, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_remove_ingredient);

		JButton btnNewButton_remove_instruction = new JButton("Remove Instruction At Position");
		btnNewButton_remove_instruction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tempRecipe!=null) {
					tempRecipe.removeInstruction(Integer.parseInt(textField_instruction_position.getText()));
					textField_instruction_position.setText("");
					textPane.setText(tempRecipe.displayRecipe());
				}else {
					textPane.setText("Error No recipe found?");
				}
			}
		});
		btnNewButton_remove_instruction.setBounds(301, 265, 199, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_remove_instruction);

		JSeparator separator_Preview_Recipe_name = new JSeparator();
		separator_Preview_Recipe_name.setForeground(Color.BLACK);
		separator_Preview_Recipe_name.setBackground(Color.BLACK);
		separator_Preview_Recipe_name.setBounds(10, 347, 490, 2);
		TabbedPane_Edit_recipe.add(separator_Preview_Recipe_name);

		JSeparator separator_ingredients_instrcutions_1 = new JSeparator();
		separator_ingredients_instrcutions_1.setForeground(Color.BLACK);
		separator_ingredients_instrcutions_1.setBackground(Color.BLACK);
		separator_ingredients_instrcutions_1.setBounds(10, 38, 490, 2);
		TabbedPane_Edit_recipe.add(separator_ingredients_instrcutions_1);

		
		JButton btnNewButton_7 = new JButton("Select Recipe");
		
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				location =Integer.parseInt(textField_8.getText())-1;
				tempRecipe=cookbook.findRecipePublic(location);
				textPane.setText(tempRecipe.displayRecipe());
			}
		});
		btnNewButton_7.setBounds(385, 6, 115, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_7);

		textField_8 = new JTextField();
		textField_8.setBounds(289, 7, 86, 20);
		TabbedPane_Edit_recipe.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Recipe Position in recipe Box");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(103, 9, 176, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_8);

		JLabel lblNewLabel_6_1 = new JLabel("Recipe Preview");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1.setBounds(105, 350, 296, 20);
		TabbedPane_Edit_recipe.add(lblNewLabel_6_1);

		

		JButton btnNewButton_8 = new JButton("Finish");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cookbook.deleteRecipe(location);
				cookbook.addRecipeAtPosition(tempRecipe, location);
				textField_8.setText("");
			}
		});
		btnNewButton_8.setBounds(411, 350, 89, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_8);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		tabbedPane.addTab("View Recipe", null, desktopPane, null);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 73, 490, 517);
		desktopPane.add(scrollPane_1_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane_1_1.setViewportView(textPane_2);
		
		JButton btnNewButton_7_1 = new JButton("Select Recipe");
		btnNewButton_7_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane_2.setText(cookbook.findRecipePublic(Integer.parseInt(textField.getText())-1).displayRecipe());
			}
		});
		btnNewButton_7_1.setBounds(385, 11, 115, 23);
		desktopPane.add(btnNewButton_7_1);
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(289, 12, 86, 20);
		desktopPane.add(textField);
		
		JLabel lblNewLabel_8_1 = new JLabel("Recipe Position in recipe Box");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8_1.setBounds(10, 11, 269, 20);
		desktopPane.add(lblNewLabel_8_1);
		
		
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Recipe Preview");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1_1.setBounds(105, 45, 296, 20);
		desktopPane.add(lblNewLabel_6_1_1);
		
		JSeparator separator_ingredients_instrcutions_1_1 = new JSeparator();
		separator_ingredients_instrcutions_1_1.setForeground(Color.BLACK);
		separator_ingredients_instrcutions_1_1.setBackground(Color.BLACK);
		separator_ingredients_instrcutions_1_1.setBounds(10, 45, 490, 2);
		desktopPane.add(separator_ingredients_instrcutions_1_1);

		JLabel lblNewLabel_9 = new JLabel("Recipe Box");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(535, 11, 280, 21);
		mainPane.add(lblNewLabel_9);
	}

}
