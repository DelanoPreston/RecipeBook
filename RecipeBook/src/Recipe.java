
public class Recipe extends Object{
	String name = "";
	String[] ingredients;
	String[] instructions = null;
	
	
	public Recipe(String inName, String[] inIngredients, String[] inInstructions){
		name = inName;
		ingredients = inIngredients;
		instructions = inInstructions;
	}
	
	@Override
	public String toString(){
		String temp = "";
		
		temp += name + "\r\n";
		temp += "\r\n" + "Ingredients:" + "\r\n";
		for(int i = 0; i < ingredients.length; i++){
			temp += ingredients[i] + "\r\n";
		}
		temp += "\r\n" + "Instructions:" + "\r\n";
		for(int i = 0; i < instructions.length; i++){
			temp += (i + 1) + ". " + instructions[i] + "\r\n";
		}
		
		return temp;
	}
}
