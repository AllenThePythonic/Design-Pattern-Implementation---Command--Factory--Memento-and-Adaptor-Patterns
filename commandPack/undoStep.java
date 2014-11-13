//undoStep.java

//Define package
package commandPack;

//Import class(es) that need but java does not provide
import tools.exceptionHandle;
import mementoPack.undoMemento;
import undoPack.undoClass;
import licensePack.License;

//Import java provided class(es) that need
import java.util.Vector;

//Implements interface "Command"
public class undoStep implements Command {
	//Variable(s)
	private Vector licenseList = new Vector();
	private Vector undoList = new Vector();
	private Vector redoList = new Vector();

	//Behavior of this Class
	public void execute(){
		//Work only if there is something to undo
		if (this.undoList.size() > 0){

			//Get last changed license and its previous state from undo list
			undoMemento undoMem = ((undoClass)this.undoList.lastElement()).getMemento();

			//Tell redo List that a license is changed, add a undoClass with this step name, license current state and current license list
			this.redoList.add(new undoClass(((undoClass)this.undoList.lastElement()).toString(), ((undoClass)this.undoList.lastElement()).getLicense(), licenseList));

			//Restore license state that saved in memento from undoList
			undoMem.restore();

			//Since this step was ran, it is no longer need in undoList, remove this step
			this.undoList.removeElement(this.undoList.lastElement());

			//Print footer of this function
			System.out.println();
			System.out.println("Last command undone.");
			System.out.println();
		}else{
			//Tell user there is nothing to undo
			System.out.println();
			System.out.println("There is nothing to undo");
			System.out.println();
		}
	}

	public void getPrepare(Vector licenseList, Vector undoList, Vector redoList){
		this.licenseList = licenseList;
		this.undoList = undoList;
		this.redoList = redoList;
	}
}