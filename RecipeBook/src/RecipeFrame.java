import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RecipeFrame extends JFrame{
	JTextArea inputBox;
	
	/**
	 * not sure, need it to suppress warnings
	 */
	private static final long serialVersionUID = 1L;
	
	public RecipeFrame(String frameName){
		this.setTitle(frameName);
		CreateLayout();
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
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.getAccessibleContext().setAccessibleDescription("The File Menu Item");
        menuBar.add(fileMenu);
        
        editMenu.setMnemonic(KeyEvent.VK_E);
        editMenu.getAccessibleContext().setAccessibleDescription("The Edit Menu Item");
        menuBar.add(editMenu);
        
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.getAccessibleContext().setAccessibleDescription("The Help Menu Item");
        menuBar.add(helpMenu);
        
        this.add(menuBar, BorderLayout.PAGE_START);
		
		/************************************************
		 * TextField creation
		 ************************************************/
		inputBox = new JTextArea();
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
		JButton pringButton = new JButton("Print");
		JButton editButton = new JButton("Edit");
		
		//create drop down
		String[] recipeTypeArray = {"Dessert", "CrockPot", "Main Dish", "Appetizer", "Breads", "Soups", "Salads"};
		JComboBox recipeTypeComboBox = new JComboBox(recipeTypeArray);
		recipeTypeComboBox.setSelectedIndex(0);
		
		//put text field and buttons on panel
		buttonPane.add(Box.createHorizontalGlue());
		buttonPane.add(addButton);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(pringButton);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(editButton);
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPane.add(recipeTypeComboBox);
		
		//add action listeners
		ButtonListener buttonListener = new ButtonListener();
		recipeTypeComboBox.addActionListener(buttonListener);
		addButton.addActionListener(buttonListener);
		pringButton.addActionListener(buttonListener);
		editButton.addActionListener(buttonListener);
		
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
				System.out.println("Add");
			}
			if(arg0.getActionCommand().equals("Print")){
				System.out.println("Print");
			}
			if(arg0.getActionCommand().equals("Edit")){
				System.out.println("Edit");
			}
//			String[] recipeTypeArray = {"Dessert", "CrockPot", "Main Dish", "Appetizer", "Breads", "Soups", "Salads"};
			if(arg0.getSource().toString().contains("Dessert")){
				String tempName = "poptartums";
				String[] tempIngerd = {"1C. water", "2lbs. pop", "3 tart", "4 umms"};
				String[] tempInstru = {"add the water and the pop", 
						"then add the tarts", 
						"then add the umms", 
						"cook for 20 minutes"};
				Recipe recipe = new Recipe(tempName, tempIngerd, tempInstru);
				
				inputBox.append(recipe.toString());
			}
		}
		
	}
}
