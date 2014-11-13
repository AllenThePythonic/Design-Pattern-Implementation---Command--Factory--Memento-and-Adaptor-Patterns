//Factory.java

//Define package
package factoryPack;

//Import needed class(es) that java does not provide
import commandPack.Command;

public abstract class Factory{
	public abstract Command create();
}