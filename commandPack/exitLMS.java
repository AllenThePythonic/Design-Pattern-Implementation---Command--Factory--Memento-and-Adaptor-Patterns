//exitLMS.java

//Define package
package commandPack;

//Import needed class(es) that java provided
import java.util.Vector;

//Implements interface "Command"
public class exitLMS implements Command {

	//Behavior of this Class
	public void execute(){
		System.out.println();
		System.out.println("System Terminated.");

		//Exit system with exit code 0
		System.exit(0);
	}

	public void getPrepare(Vector licenseList, Vector undoList, Vector redoList){}

}