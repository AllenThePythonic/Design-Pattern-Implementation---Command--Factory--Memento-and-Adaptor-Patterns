//displayLicenseList.java

//Define package
package commandPack;

//Import class(es) that need but java does not provided
import tools.exceptionHandle;

//Import java provided class(es) that need
import java.util.Vector;

//Implements interface "Command"
public class displayLicenseList implements Command {
	//Variable(s)
	private Vector licenseList = new Vector();
	private Vector undoList = new Vector();
	private Vector redoList = new Vector();

	//Behavior of this Class
	public void execute(){

		//Print header for showing license information
		System.out.println();
		System.out.println("License No \t| Licensor \t\t| Type \t\t| Title \t\t| Fee");
		System.out.println("===========================================================================================");

		//Get each license one at a time from licenseList then print it out
		for (int i = 0; i < this.licenseList.size(); i++){
			System.out.print(this.licenseList.get(i));
		}

		//Footer of this function
		System.out.println();
	}

	public void getPrepare(Vector licenseList, Vector undoList, Vector redoList){
		this.licenseList = licenseList;
		this.undoList = undoList;
		this.redoList = redoList;
	}
}