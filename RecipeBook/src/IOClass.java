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
			recipeProps.setProperty("RecipeType" , CreateArrayString(recipes.get(i).type));
			recipeProps.setProperty("Ingredients" , CreateArrayString(recipes.get(i).ingredients));
			recipeProps.setProperty("Instruction" , CreateArrayString(recipes.get(i).instructions));
			
			try {
				out = new FileOutputStream(new File("Recipes/" + recipes.get(i).name + ".prop"));
				recipeProps.store(out, "---No Comment---");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	public static List<Recipe> LoadRecipes(List<String> recipesToLoad){
		List<Recipe> recipes = new ArrayList<Recipe>();
		Properties recipeProps = new Properties();
		FileInputStream in;
		
		try{
			for(int i = 0; i < recipesToLoad.size(); i++){
				in = new FileInputStream("Recipes/" + recipesToLoad.get(i) + ".prop");
				recipeProps.load(in);
				
				String[] temp1 = recipeProps.getProperty("RecipeType").split("|");
				String[] tempIngr = recipeProps.getProperty("Ingredients").split("|");
				String[] tempInst = recipeProps.getProperty("Instruction").split("|");
				
				RecipeType[] tempType = new RecipeType[temp1.length];
				for(int j = 0; j < temp1.length; j++){
					tempType[j] = RecipeType.valueOf(temp1[j]);
				}
				
				Recipe temp = new Recipe(recipesToLoad.get(i), tempInst, tempIngr, tempType);
				recipes.add(temp);
				
				in.close();
			}
			
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		return recipes;
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
	
//	/**private method called by ReadFile(String)
//	 * 
//	 * @param fileName
//	 * @return
//	 * @throws IOException
//	 */
//	private String OpenFile(String fileName) throws IOException{
//		String path = System.getProperty("user.dir") + "/" + fileName;
//		
//		Scanner tempInput = new Scanner(new File(path));
//		String fileStrings = tempInput.useDelimiter("\\Z").next();
//		tempInput.close();
//		
//		return fileStrings;
//	}
}
