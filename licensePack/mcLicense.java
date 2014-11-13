//mcLicense.java

//Define package
package licensePack;

//Import classes in need but java does not provided
import tools.exceptionHandle;

//Import needed classes that java provided
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class mcLicense implements License{
	private String licenseNo;
	private String licensor = "Marcel";
	private String type = "Comic";
	private String title;
	private String fee;

	//Constructor
	public mcLicense(){}

	//Constructor
	public mcLicense(String licenseNo, String licensor, String type, String title, String fee){
		this.licenseNo = licenseNo;
		this.licensor = licensor;
		this.type = type;
		this.title = title;
		this.fee = fee;
	}

	public String getNo(){ return this.licenseNo; }

	public String getLicensor() { return this.licensor; }

	public String getType() { return this.type; }

	public String getTitle() { return this.title; }

	public String getFee() { return this.fee; }

	public void setFee(String fee) { this.fee = fee; }

	public void restoreProperties(String licenseNo, String licensor, String type, String title, String fee){
		this.licenseNo = licenseNo;
		this.licensor = licensor;
		this.type = type;
		this.title = title;
		this.fee = fee;
	}

	public boolean setProperties(String licenseCode) {
		String[] properties;

		try{
			System.out.println("Enter comic book, license fee for Marcel Entertainment:");

			//Get license title and fee from user, return as a String array with spliting by ", "
			properties = (new BufferedReader(new InputStreamReader(System.in)).readLine()).split(", ");

			//Check if the provided fee is a valid integer
			//If not, throw an exeption and return
			try{
				properties[1] = Integer.parseInt(properties[1]) + "";
			}catch (Exception ex){
				exceptionHandle.mcLicenseException(ex);
				return false;
			}

			//Apply provided title and fee to this license
			this.title = properties[0];
			this.fee = properties[1];

			//Code of this license will provided by the class who calling this function
			this.licenseNo = "[" + licenseCode + "]";
		}catch(Exception ex){
			exceptionHandle.mcLicenseException(ex);
			return false;
		}

		return true;
	}

	public String toString(){
		String text = "";

		//If this license is just initialized, no information can return
		if (this.licenseNo == null ||
			this.licensor == null ||
			this.type == null ||
			this.title == null ||
			this.fee == null) return text;

		text += this.licenseNo + "\t\t: " +
			this.licensor + "\t\t: ";

		if (this.type.length() < 6) text += this.type + "\t\t: ";
		else text += this.type + "\t: ";

		if (this.title.length() < 6) text += this.title + "\t\t\t: ";
		else if (this.title.length() < 14) text += this.title + "\t\t: ";
		else text += this.title + "\t: ";

		text += this.fee;

		return text + "\n";
	}
}