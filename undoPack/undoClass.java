//undoClass.java

//Define package
package undoPack;

//Import needed class(es) that java does not provide
import licensePack.License;
import mementoPack.undoMemento;

//Import needed class(es) that java provided
import java.util.Vector;

public class undoClass{
	//Variable(s)
	private String stepName;
	private undoMemento state;
	private License license;

	//Constructor
	public undoClass(String stepName, License license, Vector licenseList){
		this.stepName = stepName;
		this.license = license;
		this.state = new undoMemento(this.license, licenseList);
	}

	//Used to get it own license
	public License getLicense(){ return this.license; }

	//Used to get it own memnto
	public undoMemento getMemento(){return this.state; }

	//Provide own toString function
	public String toString(){ return this.stepName;}
}