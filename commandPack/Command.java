//Command.java

//Define package
package commandPack;

//Import needed class(es) that java provided
import java.util.Vector;

//Import needed class(es) that java does not provide
import licensePack.License;

//Implements interface "Command"
public interface Command {
	//Function that class(es) used to doing job
	public void execute();

	//Function that allow class(es) perpare to provide service
	public void getPrepare(Vector licenseList, Vector undoList, Vector redoList);

}