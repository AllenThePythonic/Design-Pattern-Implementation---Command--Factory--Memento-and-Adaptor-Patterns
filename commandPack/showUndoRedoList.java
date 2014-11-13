//showUndoRedoList.java

//Define package
package commandPack;

//Import class(es) that need but java does not provide
import tools.exceptionHandle;

//Import java provided class(es) that need
import java.util.Vector;

//Implements interface "Command"
public class showUndoRedoList implements Command {
	//Varaiable(s)
	private Vector licenseList = new Vector();
	private Vector undoList = new Vector();
	private Vector redoList = new Vector();

	//Behavior of this Class\
	public void execute(){
		//Printing header of undo list showing
		System.out.println();
		System.out.println("Undo List:");
		//Get each element from undoList one at a time and print it out
		for(Object obj : undoList){
			System.out.println(obj);
		}
		//Printing header of redo list showing
		System.out.println();
		System.out.println("Redo List:");
		//Get each element from redoList one at a time and print it out
		for(Object obj : redoList){
			System.out.println(obj);
		}

		//Footer printing of this function
		System.out.println();
		System.out.println();
	}

	public void getPrepare(Vector licenseList, Vector undoList, Vector redoList){
		this.licenseList = licenseList;
		this.undoList = undoList;
		this.redoList = redoList;
	}
}