import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class RecipeFrame extends JFrame{
	JTextArea inputBox;
	List<Recipe> recipes = new ArrayList<Recipe>();
	
	/**
	 * not sure, need it to suppress warnings
	 */
	private static final long serialVersionUID = 1L;
	
	public RecipeFrame(String frameName){
		this.setTitle(frameName);
		CreateLayout();
		new IOClass(System.getProperty("user.home") + "\\My Documents\\Recipes");
	}
	
	/**
	 * this method creates the GUI
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void CreateLayout(){
		this.setLayout(new BorderLayout());
		
		/************************************************
		 * Menu creation
		 ************************************************/
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");
		JMenuItem tempMI;
		MenuListener menuListener = new MenuListener();
		
		/****************
		 * File Menu Item Creation
		 ****************/
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.getAccessibleContext().setAccessibleDescription("The File Menu Item");
        menuBar.add(fileMenu);
        
        tempMI = new JMenuItem("Save Recipe");
        tempMI.getAccessibleContext().setAccessibleDescription("The Save File Menu Item");
        tempMI.addActionListener(menuListener);
        fileMenu.add(tempMI);
        
        tempMI = new JMenuItem("Load Recipe");
        tempMI.getAccessibleContext().setAccessibleDescription("The Load File Menu Item");
        tempMI.addActionListener(menuListener);
        fileMenu.add(tempMI);
        
        tempMI = new JMenuItem("Refresh Recipes");
        tempMI.getAccessibleContext().setAccessibleDescription("The Refresh File Menu Item");
        tempMI.addActionListener(menuListener);
        fileMenu.add(tempMI);
        
        tempMI = new JMenuItem("Exit");
        tempMI.getAccessibleContext().setAccessibleDescription("The Exit File Menu Item");
        tempMI.addActionListener(menuListener);
        fileMenu.add(tempMI);
        
        /****************
		 * Edit Menu Item Creation
		 ****************/
        editMenu.setMnemonic(KeyEvent.VK_E);
        editMenu.getAccessibleContext().setAccessibleDescription("The Edit Menu Item");
        menuBar.add(editMenu);
        
        tempMI = new JMenuItem("Change Directory");
        tempMI.getAccessibleContext().setAccessibleDescription("The Change Directory Edit Menu Item");
        tempMI.addActionListener(menuListener);
        editMenu.add(tempMI);
        
        /****************
		 * Help Menu Item Creation
		 ****************/
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.getAccessibleContext().setAccessibleDescription("The Help Menu Item");
        menuBar.add(helpMenu);
        
        this.add(menuBar, BorderLayout.PAGE_START);
		
		/************************************************
		 * TextField creation
		 ************************************************/
		inputBox = new JTextArea();
		inputBox.setLineWrap(true);
		inputBox.setWrapStyleWord(true);
		inputBox.setEditable(false);
		this.add(inputBox, BorderLayout.CENTER);
		
		/************************************************
		 * list box creation
		 ************************************************/
		JScrollPane recipeList = new JScrollPane();
		recipeList.setPreferredSize(new Dimension(200, 80));
		
		this.add(recipeList, BorderLayout.AFTER_LINE_ENDS);
		
		/************************************************
		 * Button Panel creation
		 ************************************************/
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		//create buttons
		JButton addButton = new JButton("Add");
		JButton printButton = new JButton("Print");
		JButton editButton = new JButton("Edit");
		
		//create drop down
		String[] recipeTypeArray = {"Dessert", "CrockPot", "Main Dish", "Appetizer", "Breads", "Soups", "Salads"};
		JComboBox recipeTypeComboBox = new JComboBox(recipeTypeArray);
		recipeTypeComboBox.setSelectedIndex(0);
		
		//put text field and buttons on panel
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(addButton);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(printButton);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(editButton);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(recipeTypeComboBox);
		
		//add action listeners
		ButtonListener buttonListener = new ButtonListener();
		recipeTypeComboBox.addActionListener(buttonListener);
		addButton.addActionListener(buttonListener);
		printButton.addActionListener(buttonListener);
		editButton.addActionListener(buttonListener);
		
//////////////////////////////////////////////////////////////
JButton temp = new JButton("temp");
buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
buttonPane.add(temp);
temp.addActionListener(buttonListener);
//////////////////////////////////////////////////////////////

		this.add(buttonPane, BorderLayout.PAGE_END);
		
//		
//		JPanel textButtonArea = new JPanel();
//		textButtonArea.setLayout(new BorderLayout());
////		textButtonArea.add(commandBox, BorderLayout.CENTER);
//		textButtonArea.add(buttonPane, BorderLayout.PAGE_END);
//		
//		Container contentPane = getContentPane();
//		contentPane.setLayout(new BorderLayout());
////		contentPane.add(map, BorderLayout.CENTER);
//		contentPane.add(textButtonArea, BorderLayout.PAGE_END);
	}
	
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getActionCommand().equals("Add")){
				System.out.println(System.getProperty("user.home") + "\\My Documents");
			}
			if(arg0.getActionCommand().equals("Print")){
				inputBox.setText(recipes.get(0).toString());
			}
			if(arg0.getActionCommand().equals("Edit")){
				
			}
			if(arg0.getSource().toString().contains("Dessert")){
				
			}
			if(arg0.getActionCommand().equals("temp")){
				String name = "Chicken";
				RecipeType[] type = new RecipeType[2];
				String[] ingr = new String[3];
				String[] inst = new String[3];
				
				type[0] = RecipeType.CrockPot;
				type[1] = RecipeType.MainDish;
				ingr[0] = "Chicken";
				ingr[1] = "Broth";
				ingr[2] = "Awesomeness";
				inst[0] = "heat up chicken in broth";
				inst[1] = "wait for 4 hours";
				inst[2] = "add awesomeness";
				
				Recipe recipe = new Recipe(name, ingr, inst, type);
				recipes.add(recipe);
				
				Recipe recipe2 = new Recipe("wonderBread", ingr, inst, type);
				recipes.add(recipe2);
			}
		}
	}
	
	private class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JMenuItem source = (JMenuItem)(arg0.getSource());
			if(source.getText().equalsIgnoreCase("Save Recipe")){
				if(recipes.size() > 0)
					IOClass.SaveRecipes(recipes);
			}else if(source.getText().equalsIgnoreCase("Load Recipe")){
				List<String> recipesToLoad = new ArrayList<String>();
				recipesToLoad.add("Chicken");
				recipesToLoad.add("wonderBread");
				recipes = IOClass.LoadRecipes(recipesToLoad);
			}else if(source.getText().equalsIgnoreCase("Refresh Recipes")){
				inputBox.setText("");
			}else if(source.getText().equalsIgnoreCase("Exit")){
				System.exit(0);
			}else if(source.getText().equalsIgnoreCase("Change Directory")){
				System.out.println("load a path extension changer");
			}
			
		}
		
	}
}
