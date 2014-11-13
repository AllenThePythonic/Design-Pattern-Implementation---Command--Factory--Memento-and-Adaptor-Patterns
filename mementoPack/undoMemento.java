//undoMemento.java

//Define package
package mementoPack;

//Import needed class(es) that java does not provide
import licensePack.License;

//Import needed class(es) that java provided
import java.util.Vector;

//Implements interface "Memento"
public class undoMemento implements Memento {
	//Variable(s)
	private Vector licenseList = new Vector();
	private License license;
	private String licenseNo;
	private String licensor;
	private String type;
	private String title;
	private String fee;

	//Constructor
	public undoMemento(License license, Vector licenseList){
		this.license = license;

		this.licenseList = licenseList;

		if (license != null){
			this.licenseNo = license.getNo();
			this.licensor = license.getLicensor();
			this.type = license.getType();
			this.title = license.getTitle();
			this.fee = license.getFee();
		}
	}

	public void restore(){
		//Null means the license is just created and no changed to this license was done
		//So just remove it from licenseList
		if (this.license == null){
			this.licenseList.remove(this.licenseList.lastElement());
			return;
		}

		//If there is any change was done to this license, restore it state by restoreProperties
		this.license.restoreProperties(this.licenseNo, this.licensor, this.type, this.title, this.fee);
	}
}
