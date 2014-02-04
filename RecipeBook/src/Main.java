import javax.swing.JFrame;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ContentBank.ContentLoader();
		RecipeFrame recipeFrame = new RecipeFrame("Recipe Book");
		recipeFrame.setSize(650, 450);
		recipeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recipeFrame.setResizable(false);
		recipeFrame.setVisible(true);
//		recipeFrame.add(gamePanel);
		recipeFrame.setVisible(true);
	}
}