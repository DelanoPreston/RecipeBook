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
		
		
		FileOutputStream out;
		try {
			Properties applicationProps = new Properties();
			applicationProps.setProperty("RecipeName", "Chicken");
			applicationProps.setProperty("Recipe2Name", recipes.get(0).name);
			
//			FileWriter out = new FileWriter("chicken.prop");
			out = new FileOutputStream(new File("recipes2.prop"));
			applicationProps.store(out, "---No Comment---");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
		return true;
	}
	
	public List<Recipe> LoadRecipes(){
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		try{
			Properties defaultProps = new Properties();
			FileInputStream in = new FileInputStream("recipes.prop");
			
			
			
			defaultProps.load(in);
			in.close();
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
