import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class IOClass {
	
	public Boolean SaveRecipes(List<Recipe> recipes){
		
		
		return true;
	}
	
	public List<Recipe> LoadRecipes(){
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		String mapFileData = null;
		try{
			mapFileData = OpenFile("recipes.txt");
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		
		String[] recipeInfo = mapFileData.split("\r\n__M__\r\n");
		//does recipe stuff
		
		
		
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
