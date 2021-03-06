
public class Recipe extends Object{
	String name = "";
	String[] ingredients;
	String[] instructions = null;
	int rating;
	RecipeType[] type;
	
	public Recipe(){
		
	}
	
	/**
	 * Constructor for Recipe Object
	 * @param inName - name
	 * @param inIngredients - ingredients
	 * @param inInstructions - instructions
	 * @param inType - type
	 */
	public Recipe(String inName, String[] inIngredients, String[] inInstructions, RecipeType[] inType){
		rating = 1;
		name = inName;
		ingredients = inIngredients;
		instructions = inInstructions;
		type = inType;
	}
	
	/**
	 * Constructor for Recipe Object
	 * @param inName - name
	 * @param inIngredients - ingredients
	 * @param inInstructions - instructions
	 * @param inType - type
	 * @param inRating - rating
	 */
	public Recipe(String inName, String[] inIngredients, String[] inInstructions, RecipeType[] inType, int inRating){
		rating = inRating;
		name = inName;
		ingredients = inIngredients;
		instructions = inInstructions;
		type = inType;
	}
	
	@Override
	public String toString(){
		String temp = "";
		String newLine = "\r\n";
		int rows;
		
		//set rows
		if((ingredients.length % 2) == 0)
			rows = ingredients.length / 2;
		else
			rows = (ingredients.length / 2) + 1;
		
		temp += name + newLine;
		temp += "Category=";
		for(int i = 0; i < type.length; i++){
			temp += " " + type[i].toString();
		}
		temp += newLine;
		temp += newLine + "Ingredients:" + newLine;
		for(int i = 0; i < rows; i++){
			String t1 = ingredients[i];
			if(i + rows < ingredients.length)
				t1 += "\t\t" + ingredients[rows + i];
			t1 += newLine;
			
			temp += t1;
		}
		temp += newLine + "Instructions:" + newLine;
		for(int i = 0; i < instructions.length; i++){
			temp += (i + 1) + ". " + instructions[i] + newLine;
		}
		
		return temp;
	}
}
