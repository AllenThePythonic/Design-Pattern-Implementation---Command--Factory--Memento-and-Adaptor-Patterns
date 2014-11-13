//udFactoryCommand.java

//Define package
package factoryPack;

//Import class(es) in need but java does not provide
import commandPack.Command;
import commandPack.undoStep;

public class udFactoryCommand extends Factory {
	//Create a command class and return it out
	public Command create(){ return new undoStep(); }
}