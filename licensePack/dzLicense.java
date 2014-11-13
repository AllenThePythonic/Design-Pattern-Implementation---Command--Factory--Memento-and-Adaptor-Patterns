//dzLicense.java

//Define package
package licensePack;

//Import class(es) that need but java does not provide
import tools.exceptionHandle;
import tools.dzLicenseAvailableType;

//Import needed class(es) that java provided
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class dzLicense implements License {
	//Varilable(s)
	private String licenseNo;
	private String licensor = "Dizzyland";
	private String type;
	private String title;
	private String fee;

	//Constructor
	public dzLicense(){}

	//Constructor
	public dzLicense(String licenseNo, String licensor, String type, String title, String fee){
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

	public void restoreProperties(String licenseNo, String licensor, String type, String title, String fee){
		this.licenseNo = licenseNo;
		this.licensor = licensor;
		this.type = type;
		this.title = title;
		this.fee = fee;
	}

	public void setFee(String fee) { this.fee = fee; }

	public boolean setProperties(String licenseCode) {
		String[] properties;

		try{
			System.out.println("Enter Movie/Cartoon, Title, and license fee for Dizzyland:");
			//Get license type, title and fee from user, return as a String array with spliting by ", "
			properties = (new BufferedReader(new InputStreamReader(System.in)).readLine()).split(", ");

			//Using tool to check is the provided type is available of dizzyland license
			if (properties[0] != null && dzLicenseAvailableType.check(properties[0])) this.type = properties[0];
			else{
				exceptionHandle.dzLicenseException();
				return false;
			}

			//Check if the provided fee is a valid integer
			//If not, throw an exeption and return
			try{
				properties[2] = Integer.parseInt(properties[2]) + "";
			}catch (Exception ex){
				exceptionHandle.dzLicenseException(ex);
				return false;
			}

			//Apply provided title and fee to this license
			this.title = properties[1];
			this.fee = properties[2];

			//Code of this license will provided by the class who calling this function
			this.licenseNo = "[" + licenseCode + "]";
		}catch(Exception ex){
			exceptionHandle.dzLicenseException(ex);
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