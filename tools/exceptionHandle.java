//exceptionHandle.java

//Define package
package tools;

public class exceptionHandle{
	public static void exception(Exception ex){
		ex.printStackTrace();
		System.exit(1);
	}

	public static void factoryClassException(Exception ex){
//		ex.printStackTrace();
		System.out.println();
		System.out.println("There may be no such Function. \n\n");
	}

	public static void licenseClassException(Exception ex){
//		ex.printStackTrace();
		System.out.println();
		System.out.println("There may be no such Licensor. \n\n");
	}

	public static void mcLicenseException(Exception ex){
//		ex.printStackTrace();
		System.out.println();
		System.out.println("Cannot create MC License.");
		System.out.println("Create format should be 'comic book, license fee' \n\n");
	}

	public static void dzLicenseException(Exception ex){
//		ex.printStackTrace();
		System.out.println();
		System.out.println("Cannot create DZ License.");
		System.out.println("Create format should be 'Movie/Cartoon, Title, and license fee' \n\n");
	}

	public static void dzLicenseException(){
		System.out.println();
		System.out.println("Cannot create DZ License.");
		System.out.println("There may be no such Type \n\n");
	}

	public static void changeFeeException(){
		System.out.println();
		System.out.println("Fee does not changed.");
		System.out.println("Requested license may not existing.");
		System.out.println("Please check your input, only number is allowed.");
		System.out.println("And the format MUST be 'License No., new fee'");
		System.out.println();
	}
}