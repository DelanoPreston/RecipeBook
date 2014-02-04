import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;


public class IOClass {
	
	public static Boolean SaveRecipes(List<Recipe> recipes){
		Properties recipeProps = new Properties();
		FileOutputStream out;
		
		for(int i = 0; i < recipes.size(); i++){
			String tString = "";
			for(int j = 0; j < recipes.get(i).type.length; j++){
				recipeProps.setProperty("RecipeType|" + j, recipes.get(i).type[j].toString());
			}
			recipeProps.setProperty("RecipeType" , CreateArrayString(recipes.get(i).type));
			
			recipeProps.setProperty("Ingredients" , CreateArrayString(recipes.get(i).ingredients));
			
			recipeProps.setProperty("Instruction" , CreateArrayString(recipes.get(i).instructions));
			
			try {
				out = new FileOutputStream(new File("Recipes/" + recipes.get(i).name + "2.prop"));
				recipeProps.store(out, "---No Comment---");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	private static String CreateArrayString(String[] inArray){
		String temp = "";
		for(int i = 0; i < inArray.length; i++){
			temp += inArray[i];
			if(i != inArray.length - 1)
				temp += "|";
		}
		return temp;
	}
	
	private static String CreateArrayString(RecipeType[] inArray){
		String temp = "";
		for(int i = 0; i < inArray.length; i++){
			temp += inArray[i].toString();
			if(i != inArray.length - 1)
				temp += "|";
		}
		return temp;
	}
	
	//many files, lots of keys
//	public static Boolean SaveRecipes(List<Recipe> recipes){
//		Properties recipeProps = new Properties();
//		FileOutputStream out;
//		
//		for(int i = 0; i < recipes.size(); i++){
//			for(int j = 0; j < recipes.get(i).type.length; j++){
//				recipeProps.setProperty("RecipeType|" + j, recipes.get(i).type[j].toString());
//			}
//			for(int k = 0; k < recipes.get(i).ingredients.length; k++){
//				recipeProps.setProperty("Ingredient|" + k, recipes.get(i).ingredients[k]);
//			}
//			for(int l = 0; l < recipes.get(i).instructions.length; l++){
//				recipeProps.setProperty("Instruction|" + l, recipes.get(i).instructions[l]);
//			}
//			
//			try {
//				out = new FileOutputStream(new File("Recipes/" + recipes.get(i).name + ".prop"));
//				recipeProps.store(out, "---No Comment---");
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//				return false;
//			}
//		}
//		return true;
//	}
	
	public static List<Recipe> LoadRecipes(List<String> recipesToLoad){
		List<Recipe> recipes = new ArrayList<Recipe>();
		Properties recipeProps = new Properties();
		FileInputStream in;
		
		List<RecipeType> tempType = new ArrayList<RecipeType>();
		List<String> tempIngr = new ArrayList<String>();
		List<String> tempInst = new ArrayList<String>();
		
		try{
			for(int i = 0; i < recipesToLoad.size(); i++){
				in = new FileInputStream("Recipes/" + recipesToLoad.get(i) + ".prop");
				recipeProps.load(in);
				
				for(int j = 0; j < recipeProps.stringPropertyNames().size(); j++){
					if(recipeProps.containsKey("RecipeType|" + j)){
						tempType.add(RecipeType.valueOf(recipeProps.getProperty("RecipeType|" + j)));
//						String t = recipeProps.getProperty("RecipeType|" + j);
					}
					else
						break;
				}
				for(int j = 0; j < recipeProps.stringPropertyNames().size(); j++){
					if(recipeProps.containsKey("Ingredient|" + j))
						tempIngr.add(recipeProps.getProperty("Ingredient|" + j));
					else
						break;
				}
				for(int j = 0; j < recipeProps.stringPropertyNames().size(); j++){
					if(recipeProps.containsKey("Instruction|" + j))
						tempInst.add(recipeProps.getProperty("Instruction|" + j));
					else
						break;
				}
				
				String[] temp1 = tempIngr.toArray(new String[0]);
				String[] temp2 = tempInst.toArray(new String[0]);
				RecipeType[] temp3 = tempType.toArray(new RecipeType[0]);
				
				Recipe temp = new Recipe(recipesToLoad.get(i), temp1, temp2, temp3);
				recipes.add(temp);
				
				in.close();
			}
			
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		return recipes;
	}
	
	/**private method called by ReadFile(String)
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private String OpenFile(String fileName) throws IOException{
		String path = System.getProperty("user.dir") + "/" + fileName;
		
		Scanner tempInput = new Scanner(new File(path));
		String fileStrings = tempInput.useDelimiter("\\Z").next();
		tempInput.close();
		
		return fileStrings;
	}
}
