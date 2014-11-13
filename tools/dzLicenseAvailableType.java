//dzLicenseAvailableType.java

//Define package
package tools;

//Import class(es) that need but java does not provide
import tools.exceptionHandle;

//Import needed class(es) that java provided
import java.util.ArrayList;

public class dzLicenseAvailableType{
	//Variable(s)
	private static ArrayList available = new ArrayList();
	private static String[] availableType = {"Movie", "Cartoon"};

	//Check if the array list contains the requested type
	public static boolean check(String type){
		try{
			//No way to allow since type is a must
			if (type == null || type.equals("")) return false;

			//Initialize a arraylist that contain ALL available type
			initialAvailableType();

			//Return the arraylist contains the requested type or not
			return available.contains(type);
		}catch(Exception ex){
			exceptionHandle.exception(ex);
			return false;
		}
	}

	//Initialize a arraylist that contain ALL available type
	private static void initialAvailableType(){
		try{
			//Add elements from availableType to available
			for (int i = 0; i < availableType.length; i++){
				available.add(availableType[i]);
			}
		}catch(Exception ex){
			exceptionHandle.exception(ex);
			return;
		}
	}
}