//createNewLicense.java

//Define package
package commandPack;

//Import class(es) that need but java does not provide
import  licensePack.*;
import tools.exceptionHandle;
import undoPack.undoClass;

//Import java provided class(es) that need
import java.util.Vector;
import java.io.InputStreamReader;
import java.io.BufferedReader;

//Implements interface "Command"
public class createNewLicense implements Command {
	//Variable(s)
	private License license;
	private Vector licenseList = new Vector();
	private Vector undoList = new Vector();
	private Vector redoList = new Vector();

	//Behavior of this Class
	public void execute(){
		//Get which license type that user is going to create
		System.out.println("Enter Licensor Code:");

		try{
			//Get user input for creating license
			String line = (new BufferedReader(new InputStreamReader(System.in)).readLine()).toLowerCase();

			//Create corresponding License if requested licensor is available
			license = (License)Class.forName("licensePack." + line + "License").newInstance();

			//Once this step is confirmed, add a new undo step to undoList with a undoCLass,
			//which containing the step name, this license current state and the current licenseList
			this.undoList.add(new undoClass("Created License [" + (this.licenseList.size() + 1) + "]", license, licenseList));

			//Use a license's function letting user to input license information,
			//return while something wrong
			if(!license.setProperties((this.licenseList.size() + 1)+""))
			{
				this.undoList.remove(undoList.lastElement());
				return;
			}

			//Add this new license to licenseList
			try{
				licenseList.add(license);
			}catch(Exception ex){
				//If there is any exception occur, here, that means no actions will take in license,
				//reduce the lastest step of undo list since there is nothing changed and
				//throw an exception then return
				this.undoList.remove(undoList.lastElement());
				exceptionHandle.licenseClassException(ex);
				return;
			}

			//Printing footer of this function
			System.out.println();
			System.out.println("New license created.");
			System.out.println();

		}catch(Exception ex){
			exceptionHandle.licenseClassException(ex);
			return;
		}
	}

	public void getPrepare(Vector licenseList, Vector undoList, Vector redoList){
		this.licenseList = licenseList;
		this.undoList = undoList;
		this.redoList = redoList;
	}
}