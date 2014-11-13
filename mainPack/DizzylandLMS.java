//DizzylandLMS.java

//Define package
package mainPack;

//Import class(es) in need that java not provided
import tools.*;
import factoryPack.Factory;
import commandPack.*;

//Import java provided class(es) in need
import java.util.Vector;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class DizzylandLMS{
	//Variable(s)
	private static Vector licenseList = new Vector();
	private static Vector undoList = new Vector();
	private static Vector redoList = new Vector();

	//This is where the program start
	public static void main(String[] args){
		try{
			//Run endless until user request to exit
			while(true){
				//Print header and available function list
				getString.printHeader();

				try{
					//Get user input for calling function
					String line = ((new BufferedReader(new InputStreamReader(System.in)).readLine()).toLowerCase()).trim();


					//Create corresponding class for requested function
					Command c = ((Factory) Class.forName("factoryPack." + line + "FactoryCommand").newInstance()).create();

					//Pass needed varaiable(s) to command class
					c.getPrepare(licenseList, undoList, redoList);

					//Command class execute
					c.execute();

				}catch(Exception ex){
					//Throw exception by external class
					exceptionHandle.factoryClassException(ex);
				}
			}
		}catch (Exception ex){
			//Throw exception by external class
			exceptionHandle.exception(ex);
		}
	}
}