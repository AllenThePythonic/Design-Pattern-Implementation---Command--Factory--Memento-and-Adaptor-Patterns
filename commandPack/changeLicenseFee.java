//changeLicenseFee.java

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
public class changeLicenseFee implements Command {
	//Variable(s)
	private Vector licenseList = new Vector();
	private Vector undoList = new Vector();
	private Vector redoList = new Vector();

	//Behavior of this Class
	public void execute(){
		try{
			//Work only if there is any license is existing
			if (this.licenseList.size() > 0){

				System.out.println("Enter License No., new fee:");
				//Get license number and new fee from user, return as a String array with spliting by ", "
				String[] newFee = (new BufferedReader(new InputStreamReader(System.in)).readLine()).split(", ");

				//Throw an exception and return, if user input nothing or invalid information
				if (newFee == null || newFee.length != 2) {
					exceptionHandle.changeFeeException();
					return;
				}

				//Check if the provided new fee is a valid integer
				//If not, throw an exeption and return
				try{
					newFee[1] = Integer.parseInt(newFee[1]) + "";
				}catch (Exception ex){
					exceptionHandle.mcLicenseException(ex);
					return;
				}

				//Once this step is confirmed, add a new undo step to undoList with a undoCLass,
				//which containing the step name, this license current state and the current licenseList
				undoList.add(new undoClass("Changed License [" + newFee[0] + "]", (License)this.licenseList.elementAt(Integer.parseInt(newFee[0]) - 1), licenseList));

				//Change the requested license's fee
				try{
					((License)this.licenseList.elementAt((Integer.parseInt(newFee[0]) - 1))).setFee(newFee[1]);
				}catch(Exception ex){
					//If there is any exception occur, here, that means no actions will take in license,
					//reduce the lastest step of undo list since there is nothing changed and
					//throw an exception then return
					undoList.remove(undoList.lastElement());
					exceptionHandle.changeFeeException();
					return;
				}

				//Printing footer of this function
				System.out.println();
				System.out.println("License fee updated.");

				System.out.println();
			}else{
				//Telling user there is no license for fee changing
				System.out.println();
				System.out.println("There is NO any license existing!");
				System.out.println();
				return;
			}

		}catch(Exception ex){
			exceptionHandle.changeFeeException();
			return;
		}
	}

	public void getPrepare(Vector licenseList, Vector undoList, Vector redoList){
		this.licenseList = licenseList;
		this.undoList = undoList;
		this.redoList = redoList;
	}
}