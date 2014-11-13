//Memento.java

//Define package
package mementoPack;

//Import needed class(es) that java does not provide
import licensePack.License;

public interface Memento {
	//function used to restore license state
	public void restore();
}