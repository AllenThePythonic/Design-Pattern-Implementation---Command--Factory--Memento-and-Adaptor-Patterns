//redoStep.java

//Define package
package commandPack;

//Import class(es) that need but java does not provide
import tools.getString;
import tools.exceptionHandle;
import mementoPack.undoMemento;
import undoPack.undoClass;

//Import java provided class(es) that needed
import java.util.Vector;

//Implements interface "Command"
public class redoStep implements Command {
	//Varaible(s)
	private Vector licenseList = new Vector();
	private Vector undoList = new Vector();
	private Vector redoList = new Vector();

	//Behavior of this Class
	public void execute(){
		//Work only if there is something to redo
		if (this.redoList.size() > 0){

			//Get last changed license and its previous state from redo list
			undoMemento redoMem = ((undoClass)this.redoList.lastElement()).getMemento();

			//Tell undo List that a license is changed, add a undoClass with this step name, license current state and current license list
			this.undoList.add(new undoClass(((undoClass)this.redoList.lastElement()).toString(), ((undoClass)this.redoList.lastElement()).getLicense(), licenseList));

			//Restore license state that saved in memento from redoList
			redoMem.restore();

			//Since this step was ran, it is no longer need in redoList, remove this step
			this.redoList.removeElement(this.redoList.lastElement());

			//Print footer of this function
			System.out.println();
			System.out.println("Last command redone.");
			System.out.println();

		}else{
			//Tell user there is nothing to redo
			System.out.println();
			System.out.println("There is nothing to redo");
			System.out.println();
		}
	}

	public void getPrepare(Vector licenseList, Vector undoList, Vector redoList){
		this.licenseList = licenseList;
		this.undoList = undoList;
		this.redoList = redoList;
	}
}