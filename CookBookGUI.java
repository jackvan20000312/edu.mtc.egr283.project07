package edu.mtc.egr283.project07;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
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
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.filechooser.FileFilter;
/**
 * @author Jacob Vaught
 * @professor William Sims
 * @DueDate 04/14/2021
 * @version 2.02 04.14.2021
 * v1.20 changed color of GUI
 * v2.01 Added file opener
 * v2.02 added clickable list to open recipes
 * TODO add comments
 * TODO add java docs
 * Copyright(c) 2021 Jacob C. Vaught. All rights reserved.
 */
public class CookBookGUI extends JFrame {

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
	DefaultListModel listModel = new DefaultListModel();
	JScrollPane scrollPane;
	private JList list_1;
	private JMenu MenuBar;
	private JMenuItem openRecipemenuItem;
	private JMenuItem saverecipemenuitem;
	private JLabel lblNewLabel_1;
	private JTabbedPane tabbedPane;
	private JDesktopPane viewRecipePane;
	private JDesktopPane Tabbed_Pane_New_Recipe;
	private JDesktopPane TabbedPane_Edit_recipe;
	private JScrollPane scrollPane_1_1;
	private JSeparator separator_ingredients_instrcutions_1_1;
	private JLabel lblNewLabel_6_1_1;
	private JLabel lblNewLabel_8_1;
	private JTextPane textPane_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnAddInstructionAt_Position;
	private JButton btnNewButton_Set_New_Name;
	private JButton btnNewButton_add_ingredient_at_position;
	private JSeparator separator_Preview_Recipe_name;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_instrcution_position;
	private JButton btnNewButton_remove_ingredient;
	private JButton btnNewButton_remove_instruction;
	private JButton btnAddInstructionAt_Top;
	private JLabel lblNewLabel_Instructions;
	private JLabel lblNewLabel_Recipe_name;
	private JLabel lblNewLabel_Ingredient_Position;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_Amount;
	private JLabel lblNewLabel_Unit;
	private JSeparator separator_ingredients_instrcutions_1;
	private JSeparator separator_ingredients_instrcutions;
	private JButton btnNewButton_Add_Ingredient_At_top;
	private JButton btnNewButton_Add_ingredient_at_bottom;
	private JLabel lblNewLabel_Ingredient_Name;
	private JButton btnAddInstructionAt_Bottom;
	private JSeparator separator_Instructions_Recipe_name;
	private JScrollPane scrollPane_1;
	private JTextPane textPane;
	private JLabel lblNewLabel_preview;
	private JButton btnAddInstructionAtBottom;
	private JButton btnNewButton_topositionrecipe;
	private JButton addnamebutton;
	private JScrollPane scrollPane_NewRecipePreview;
	private JLabel recipenamelabel;
	private JLabel ingredient_name_label;
	private JSeparator separator_name_preview;
	private JButton btnNewButton_ingredientaddbottom;
	private JLabel lblNewLabel_position;
	private JButton btnNewButton_ingredientaddatposition;
	private JButton btnAddInstructionAtPosition;
	private JLabel unit_label;
	private JSeparator separator_recipename_instrcutor;
	private JButton btnNewButton_tobottomrecipe;
	private JButton addingredientattop;
	private JLabel lblNewLabel_position_recipe;
	private JTextPane textPane_NewRecipePreview;
	private JLabel amount_label;
	private JLabel lblNewLabel_position_instruction;
	private JButton btnNewButton_addrecipeattop;
	private JSeparator speratesinstrcutionsandingredients;
	private JLabel instructionslabel;
	private JButton btnAddInstructionAtTop;
	private JDesktopPane mainPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		CookBookGUI frame = new CookBookGUI();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public CookBookGUI() {
		tempRecipe=new Recipe();
		cookbook = new CookBook();
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//windows- favorite!
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");//Motif Style Really Ugly
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");//Java
			UIManager.put("nimbusBase", Color.BLUE.darker().darker().darker());
			UIManager.put("nimbusBlueGrey", Color.BLACK);
			UIManager.put("textInactiveText", Color.WHITE);
			UIManager.put("control", Color.DARK_GRAY);
			UIManager.put("text", Color.ORANGE);
			UIManager.put("nimbusLightBackground", Color.DARK_GRAY.brighter());
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {if ("Nimbus".equals(info.getName())) {UIManager.setLookAndFeel(info.getClassName());}}//Nimbus Style
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 720);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		//list = new List();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		MenuBar = new JMenu("Open");
		MenuBar.setForeground(Color.ORANGE);
		menuBar.add(MenuBar);

		mainPane = new JDesktopPane();
		mainPane.setBackground(Color.WHITE);
		contentPane.add(mainPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 560, 629);
		mainPane.add(tabbedPane);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(582, 35, 280, 608);
		mainPane.add(scrollPane);


		openRecipemenuItem = new JMenuItem("Open Recipe Box/CookBook");
		openRecipemenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser  fileDialog = new JFileChooser();
				fileDialog.setFileFilter(new FileFilter() {
					@Override
					public boolean accept(File f) {
						if (f.isDirectory()) {
							return true;
						}
						final String name = f.getName();
						return name.endsWith(".xml") || name.endsWith(".txt");
					}

					@Override
					public String getDescription() {
						return "*.xml,*.txt";
					}
				});
				if (fileDialog.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
					File openFile = fileDialog.getSelectedFile();
					cookbook=CookBookFile.read(openFile);
					setList();
				}
				repaint();
			}
		});

		MenuBar.add(openRecipemenuItem);

		saverecipemenuitem = new JMenuItem("Save Current Recipe Box");
		saverecipemenuitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser  fileDialog = new JFileChooser();
				fileDialog.setFileFilter(new FileFilter() {
					@Override
					public boolean accept(File f) {
						if (f.isDirectory()) {
							return true;
						}
						final String name = f.getName();
						return name.endsWith(".xml") || name.endsWith(".txt");
					}

					@Override
					public String getDescription() {
						return "*.xml,*.txt";
					}
				});
				if (fileDialog.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
					File saveFile = fileDialog.getSelectedFile();
					CookBookFile.write(saveFile, cookbook);
				}
			}
		});
		MenuBar.add(saverecipemenuitem);

		Tabbed_Pane_New_Recipe = new JDesktopPane();
		Tabbed_Pane_New_Recipe.setBackground(Color.WHITE);
		tabbedPane.addTab("New Recipe", null, Tabbed_Pane_New_Recipe, null);

		scrollPane_NewRecipePreview = new JScrollPane();
		scrollPane_NewRecipePreview.setBounds(10, 281, 538, 251);
		Tabbed_Pane_New_Recipe.add(scrollPane_NewRecipePreview);

		textPane_NewRecipePreview = new JTextPane();
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
		textField_ingredient_name_new.setBounds(202, 36, 158, 20);
		Tabbed_Pane_New_Recipe.add(textField_ingredient_name_new);
		textField_ingredient_name_new.setColumns(10);

		amount_label = new JLabel("Amount");
		amount_label.setHorizontalAlignment(SwingConstants.CENTER);
		amount_label.setBounds(10, 11, 86, 14);
		Tabbed_Pane_New_Recipe.add(amount_label);
		amount_label.setFont(new Font("Tahoma", Font.PLAIN, 12));

		unit_label = new JLabel("Unit");
		unit_label.setHorizontalAlignment(SwingConstants.CENTER);
		unit_label.setBounds(106, 11, 86, 14);
		Tabbed_Pane_New_Recipe.add(unit_label);
		unit_label.setFont(new Font("Tahoma", Font.PLAIN, 12));

		ingredient_name_label = new JLabel("Ingredient Name");
		ingredient_name_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ingredient_name_label.setHorizontalAlignment(SwingConstants.CENTER);
		ingredient_name_label.setBounds(202, 12, 150, 14);
		Tabbed_Pane_New_Recipe.add(ingredient_name_label);

		addingredientattop = new JButton("Add Ingredient At Top");
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
		addingredientattop.setBounds(10, 67, 150, 23);
		Tabbed_Pane_New_Recipe.add(addingredientattop);

		speratesinstrcutionsandingredients = new JSeparator();
		speratesinstrcutionsandingredients.setBounds(10, 101, 490, 2);
		Tabbed_Pane_New_Recipe.add(speratesinstrcutionsandingredients);
		speratesinstrcutionsandingredients.setForeground(Color.BLACK);
		speratesinstrcutionsandingredients.setBackground(Color.BLACK);

		instructionslabel = new JLabel("Instructions");
		instructionslabel.setHorizontalAlignment(SwingConstants.CENTER);
		instructionslabel.setBounds(10, 114, 342, 14);
		Tabbed_Pane_New_Recipe.add(instructionslabel);
		instructionslabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		instructiontextfield = new JTextField();
		instructiontextfield.setBounds(10, 139, 350, 20);
		Tabbed_Pane_New_Recipe.add(instructiontextfield);
		instructiontextfield.setColumns(10);

		recipenamelabel = new JLabel("Recipe Name");
		recipenamelabel.setHorizontalAlignment(SwingConstants.CENTER);
		recipenamelabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		recipenamelabel.setBounds(10, 217, 86, 20);
		Tabbed_Pane_New_Recipe.add(recipenamelabel);

		recipenametextfiled = new JTextField();
		recipenametextfiled.setBounds(106, 218, 269, 20);
		Tabbed_Pane_New_Recipe.add(recipenametextfiled);
		recipenametextfiled.setColumns(10);

		addnamebutton = new JButton("Add Name");
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

		separator_recipename_instrcutor = new JSeparator();
		separator_recipename_instrcutor.setForeground(Color.BLACK);
		separator_recipename_instrcutor.setBackground(Color.BLACK);
		separator_recipename_instrcutor.setBounds(10, 204, 490, 2);
		Tabbed_Pane_New_Recipe.add(separator_recipename_instrcutor);

		textField_ingred_position = new JTextField();
		textField_ingred_position.setBounds(372, 36, 176, 20);
		Tabbed_Pane_New_Recipe.add(textField_ingred_position);
		textField_ingred_position.setColumns(10);

		lblNewLabel_position = new JLabel("Position # (optional)");
		lblNewLabel_position.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_position.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_position.setBounds(362, 11, 138, 14);
		Tabbed_Pane_New_Recipe.add(lblNewLabel_position);

		btnNewButton_ingredientaddbottom = new JButton("Add Ingredient At Bottom");
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
		btnNewButton_ingredientaddbottom.setBounds(182, 68, 170, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_ingredientaddbottom);

		btnNewButton_ingredientaddatposition = new JButton("Add Ingredient At Position");
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
		btnNewButton_ingredientaddatposition.setBounds(376, 67, 172, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_ingredientaddatposition);

		textField_positioninstruction = new JTextField();
		textField_positioninstruction.setColumns(10);
		textField_positioninstruction.setBounds(372, 139, 176, 20);
		Tabbed_Pane_New_Recipe.add(textField_positioninstruction);

		lblNewLabel_position_instruction = new JLabel("Position(optional)");
		lblNewLabel_position_instruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_position_instruction.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_position_instruction.setBounds(362, 115, 138, 14);
		Tabbed_Pane_New_Recipe.add(lblNewLabel_position_instruction);

		btnAddInstructionAtTop = new JButton("Add Instruction At Top");
		btnAddInstructionAtTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.addInstructionAtHead(new Instruction(instructiontextfield.getText()));
				textPane_NewRecipePreview.setText(tempRecipe.displayRecipe());
				instructiontextfield.setText("");
				repaint();
			}
		});
		btnAddInstructionAtTop.setBounds(10, 170, 168, 23);
		Tabbed_Pane_New_Recipe.add(btnAddInstructionAtTop);

		btnAddInstructionAtBottom = new JButton("Add Instruction At Bottom");
		btnAddInstructionAtBottom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.addInstructionAtTail(new Instruction(instructiontextfield.getText()));
				textPane_NewRecipePreview.setText(tempRecipe.displayRecipe());
				instructiontextfield.setText("");
				repaint();
			}
		});
		btnAddInstructionAtBottom.setBounds(190, 171, 170, 23);
		Tabbed_Pane_New_Recipe.add(btnAddInstructionAtBottom);

		btnAddInstructionAtPosition = new JButton("Add Instruction At Position");
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
		btnAddInstructionAtPosition.setBounds(372, 171, 176, 23);
		Tabbed_Pane_New_Recipe.add(btnAddInstructionAtPosition);

		separator_name_preview = new JSeparator();
		separator_name_preview.setForeground(Color.BLACK);
		separator_name_preview.setBackground(Color.BLACK);
		separator_name_preview.setBounds(10, 248, 490, 2);
		Tabbed_Pane_New_Recipe.add(separator_name_preview);

		lblNewLabel_preview = new JLabel("Recipe Preview");
		lblNewLabel_preview.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_preview.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_preview.setBounds(10, 250, 490, 20);
		Tabbed_Pane_New_Recipe.add(lblNewLabel_preview);


		btnNewButton_addrecipeattop = new JButton("Add Recipe At Top");
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
				setList();
				repaint();
			}
		});
		btnNewButton_addrecipeattop.setBounds(10, 543, 158, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_addrecipeattop);

		btnNewButton_tobottomrecipe = new JButton("Add Recipe at Bottom");
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
				setList();
				repaint();
			}
		});
		btnNewButton_tobottomrecipe.setBounds(179, 543, 173, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_tobottomrecipe);

		btnNewButton_topositionrecipe = new JButton("Add Recipe at Position");
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
				setList();
				repaint();
			}
		});
		btnNewButton_topositionrecipe.setBounds(361, 543, 187, 23);
		Tabbed_Pane_New_Recipe.add(btnNewButton_topositionrecipe);

		textField_recipe_position = new JTextField();
		textField_recipe_position.setBounds(498, 570, 50, 20);
		Tabbed_Pane_New_Recipe.add(textField_recipe_position);
		textField_recipe_position.setColumns(10);

		lblNewLabel_position_recipe = new JLabel("Position");
		lblNewLabel_position_recipe.setBounds(454, 573, 46, 14);
		Tabbed_Pane_New_Recipe.add(lblNewLabel_position_recipe);

		TabbedPane_Edit_recipe = new JDesktopPane();

		TabbedPane_Edit_recipe.setBackground(Color.WHITE);
		tabbedPane.addTab("Edit Recipe", null, TabbedPane_Edit_recipe, null);

		amount_TextField = new JTextField();
		amount_TextField.setColumns(10);
		amount_TextField.setBounds(10, 65, 86, 20);
		TabbedPane_Edit_recipe.add(amount_TextField);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 378, 544, 212);
		TabbedPane_Edit_recipe.add(scrollPane_1);

		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane_1.setViewportView(textPane);

		textField_unit = new JTextField();
		textField_unit.setColumns(10);
		textField_unit.setBounds(106, 65, 86, 20);
		TabbedPane_Edit_recipe.add(textField_unit);

		textField_Ingredient_Name = new JTextField();
		textField_Ingredient_Name.setColumns(10);
		textField_Ingredient_Name.setBounds(202, 65, 168, 20);
		TabbedPane_Edit_recipe.add(textField_Ingredient_Name);

		lblNewLabel_Amount = new JLabel("Amount");
		lblNewLabel_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Amount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Amount.setBounds(10, 40, 86, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Amount);

		lblNewLabel_Unit = new JLabel("Unit");
		lblNewLabel_Unit.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Unit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Unit.setBounds(106, 40, 86, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Unit);

		lblNewLabel_Ingredient_Name = new JLabel("Ingredient Name");
		lblNewLabel_Ingredient_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Ingredient_Name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Ingredient_Name.setBounds(202, 40, 168, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Ingredient_Name);

		btnNewButton_Add_Ingredient_At_top = new JButton("Add Ingredient At Top");
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
				repaint();
			}
		});
		btnNewButton_Add_Ingredient_At_top.setBounds(10, 96, 172, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_Add_Ingredient_At_top);

		lblNewLabel_Instructions = new JLabel("Instructions");
		lblNewLabel_Instructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Instructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Instructions.setBounds(10, 175, 360, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Instructions);

		textField_Instructions = new JTextField();
		textField_Instructions.setColumns(10);
		textField_Instructions.setBounds(10, 200, 360, 20);
		TabbedPane_Edit_recipe.add(textField_Instructions);

		lblNewLabel_Recipe_name = new JLabel("Recipe Name");
		lblNewLabel_Recipe_name.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Recipe_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Recipe_name.setBounds(10, 316, 86, 20);
		TabbedPane_Edit_recipe.add(lblNewLabel_Recipe_name);

		textField_Recipe_name = new JTextField();
		textField_Recipe_name.setColumns(10);
		textField_Recipe_name.setBounds(95, 316, 332, 20);
		TabbedPane_Edit_recipe.add(textField_Recipe_name);

		btnNewButton_Set_New_Name = new JButton("Set New Name");
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
				repaint();
			}
		});
		btnNewButton_Set_New_Name.setBounds(439, 315, 115, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_Set_New_Name);

		separator_Instructions_Recipe_name = new JSeparator();
		separator_Instructions_Recipe_name.setForeground(Color.BLACK);
		separator_Instructions_Recipe_name.setBackground(Color.BLACK);
		separator_Instructions_Recipe_name.setBounds(10, 299, 544, 2);
		TabbedPane_Edit_recipe.add(separator_Instructions_Recipe_name);

		textField_Ingredient_Position = new JTextField();
		textField_Ingredient_Position.setColumns(10);
		textField_Ingredient_Position.setBounds(382, 65, 172, 20);
		TabbedPane_Edit_recipe.add(textField_Ingredient_Position);

		lblNewLabel_Ingredient_Position = new JLabel("Position(optional)");
		lblNewLabel_Ingredient_Position.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Ingredient_Position.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_Ingredient_Position.setBounds(382, 40, 172, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_Ingredient_Position);

		btnNewButton_Add_ingredient_at_bottom = new JButton("Add Ingredient At Bottom");
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
				repaint();
			}
		});
		btnNewButton_Add_ingredient_at_bottom.setBounds(198, 96, 172, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_Add_ingredient_at_bottom);

		btnNewButton_add_ingredient_at_position = new JButton("Add Ingredient At Position");
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
				repaint();
			}
		});
		btnNewButton_add_ingredient_at_position.setBounds(382, 96, 172, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_add_ingredient_at_position);

		textField_instruction_position = new JTextField();
		textField_instruction_position.setColumns(10);
		textField_instruction_position.setBounds(382, 200, 172, 20);
		TabbedPane_Edit_recipe.add(textField_instruction_position);

		lblNewLabel_instrcution_position = new JLabel("Position(optional)");
		lblNewLabel_instrcution_position.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_instrcution_position.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_instrcution_position.setBounds(382, 175, 172, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_instrcution_position);

		btnAddInstructionAt_Top = new JButton("Add Instruction At Top");
		btnAddInstructionAt_Top.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tempRecipe.addInstructionAtHead(new Instruction(textField_Instructions.getText()));
				textField_Instructions.setText("");
				textField_instruction_position.setText("");
				textPane.setText(tempRecipe.displayRecipe());
				repaint();
			}
		});
		btnAddInstructionAt_Top.setBounds(10, 231, 158, 23);
		TabbedPane_Edit_recipe.add(btnAddInstructionAt_Top);

		btnAddInstructionAt_Bottom = new JButton("Add Instruction At Bottom");
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
				repaint();
			}
		});
		btnAddInstructionAt_Bottom.setBounds(180, 231, 190, 23);
		TabbedPane_Edit_recipe.add(btnAddInstructionAt_Bottom);

		btnAddInstructionAt_Position = new JButton("Add Instruction At Position");
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
				repaint();
			}
		});
		btnAddInstructionAt_Position.setBounds(378, 232, 176, 23);
		TabbedPane_Edit_recipe.add(btnAddInstructionAt_Position);

		separator_ingredients_instrcutions = new JSeparator();
		separator_ingredients_instrcutions.setForeground(Color.BLACK);
		separator_ingredients_instrcutions.setBackground(Color.BLACK);
		separator_ingredients_instrcutions.setBounds(10, 164, 544, 2);
		TabbedPane_Edit_recipe.add(separator_ingredients_instrcutions);

		btnNewButton_remove_ingredient = new JButton("Remove Ingredient At Position");
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
				repaint();
			}
		});
		btnNewButton_remove_ingredient.setBounds(355, 131, 199, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_remove_ingredient);

		btnNewButton_remove_instruction = new JButton("Remove Instruction At Position");
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
				repaint();
			}
		});
		btnNewButton_remove_instruction.setBounds(355, 266, 199, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_remove_instruction);

		separator_Preview_Recipe_name = new JSeparator();
		separator_Preview_Recipe_name.setForeground(Color.BLACK);
		separator_Preview_Recipe_name.setBackground(Color.BLACK);
		separator_Preview_Recipe_name.setBounds(10, 348, 544, 1);
		TabbedPane_Edit_recipe.add(separator_Preview_Recipe_name);

		separator_ingredients_instrcutions_1 = new JSeparator();
		separator_ingredients_instrcutions_1.setForeground(Color.BLACK);
		separator_ingredients_instrcutions_1.setBackground(Color.BLACK);
		separator_ingredients_instrcutions_1.setBounds(10, 40, 544, 0);
		TabbedPane_Edit_recipe.add(separator_ingredients_instrcutions_1);


		btnNewButton = new JButton("Select Recipe");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				location =Integer.parseInt(textField_8.getText())-1;
				tempRecipe=cookbook.getRecipe(location);
				textPane.setText(tempRecipe.displayRecipe());
				repaint();
			}
		});
		btnNewButton.setBounds(439, 5, 115, 23);
		TabbedPane_Edit_recipe.add(btnNewButton);

		textField_8 = new JTextField();
		textField_8.setBounds(346, 6, 86, 20);
		TabbedPane_Edit_recipe.add(textField_8);
		textField_8.setColumns(10);

		lblNewLabel_2 = new JLabel("Recipe Position in recipe Box");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(170, 9, 176, 14);
		TabbedPane_Edit_recipe.add(lblNewLabel_2);

		lblNewLabel_6 = new JLabel("Recipe Preview");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(136, 351, 296, 20);
		TabbedPane_Edit_recipe.add(lblNewLabel_6);



		btnNewButton_1 = new JButton("Finish");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cookbook.updateRecipe(tempRecipe, location);
				textField_8.setText("");
				textPane.setText("");
				setList();
				repaint();

			}
		});
		btnNewButton_1.setBounds(465, 351, 89, 23);
		TabbedPane_Edit_recipe.add(btnNewButton_1);

		viewRecipePane = new JDesktopPane();
		viewRecipePane.setBackground(Color.WHITE);
		tabbedPane.addTab("View Recipe", null, viewRecipePane, null);

		scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 73, 544, 517);
		viewRecipePane.add(scrollPane_1_1);

		textPane_2 = new JTextPane();
		textPane_2.setEditable(false);
		textPane_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane_1_1.setViewportView(textPane_2);


		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(468, 10, 86, 22);
		viewRecipePane.add(textField);

		lblNewLabel_8_1 = new JLabel("Recipe Position in recipe Box");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8_1.setBounds(255, 11, 201, 20);
		viewRecipePane.add(lblNewLabel_8_1);

		lblNewLabel_6_1_1 = new JLabel("Recipe Preview");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1_1.setBounds(10, 46, 544, 20);
		viewRecipePane.add(lblNewLabel_6_1_1);

		separator_ingredients_instrcutions_1_1 = new JSeparator();
		separator_ingredients_instrcutions_1_1.setForeground(Color.BLACK);
		separator_ingredients_instrcutions_1_1.setBackground(Color.BLACK);
		separator_ingredients_instrcutions_1_1.setBounds(10, 45, 544, 2);
		viewRecipePane.add(separator_ingredients_instrcutions_1_1);

		lblNewLabel_1 = new JLabel("Recipe Box");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(582, 13, 280, 21);
		mainPane.add(lblNewLabel_1);

		list_1 = new JList(listModel);
		scrollPane.setViewportView(list_1);
	}

	public void setList() {
		DefaultListModel listModel = new DefaultListModel();
		if (cookbook.size()>0){
			for(int i=0; i<cookbook.size(); i++){
				listModel.addElement((i+1)+". "+cookbook.getRecipe(i).getName());
			}//end of for loop
			list_1 = new JList(listModel);
			MouseListener mouseListener = new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int index = list_1.locationToIndex(e.getPoint());
					try{
						tabbedPane.setSelectedIndex(2);
						textPane_2.setText(cookbook.getRecipe(index).displayRecipe());
						textField.setText(String.valueOf(index+1));
					}catch(Exception ae) {
					}//end of catch
				}//edn of mouseclicked
			};//end of mouselistener
			list_1.addMouseListener(mouseListener);
			scrollPane.setViewportView(list_1);
			repaint();
		}
	}
}//end of class