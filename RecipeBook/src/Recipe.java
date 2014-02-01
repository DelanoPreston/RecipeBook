
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
		int rows;
		
		//set rows
		if((ingredients.length % 2) == 0)
			rows = ingredients.length / 2;
		else
			rows = (ingredients.length / 2) + 1;
		
		temp += name + "\r\n";
		temp += "\r\n" + "Ingredients:" + "\r\n";
		for(int i = 0; i < rows; i++){
			String t1 = ingredients[i];
			if(i + rows < ingredients.length)
				t1 += "\t\t" + ingredients[rows + i];
			t1 += "\r\n";
			
			temp += t1;
		}
		temp += "\r\n" + "Instructions:" + "\r\n";
		for(int i = 0; i < instructions.length; i++){
			temp += (i + 1) + ". " + instructions[i] + "\r\n";
		}
		
		return temp;
	}
}
