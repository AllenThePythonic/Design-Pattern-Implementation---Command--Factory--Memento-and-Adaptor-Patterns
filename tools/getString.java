//getString.java

//Defing package
package tools;

public class getString{
	//Variable(s)
	private static final String header = "Dizzyland License Management System";
	private static final String availableCommand = "Enter command: e = exit, cl = create license, ch = change license fee, \n dl = display all license, ud = undo, rd = redo, sl = show undo / redo list:";

	//Print header for Dizzland LMS
	public static void printHeader(){
		printInformation();
		printAvailableCommand();
	}

	//Print information for Dizzland LMS
	private static void printInformation(){
		System.out.println(header);
		System.out.println();
	}

	//Print available command for Dizzland LMS
	private static void printAvailableCommand(){
		System.out.println(availableCommand);
	}
}