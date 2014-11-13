//clFactoryCommand.java

//Define package
package factoryPack;

//Import class(es) in need but java does not provide
import commandPack.Command;
import commandPack.createNewLicense;

public class clFactoryCommand extends Factory {
	//Create a command class and return it out
	public Command create(){ return new createNewLicense(); }
}