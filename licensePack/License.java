//License.java

//Define package
package licensePack;

public interface License{

	//Function that allow license to change it own fee
	public void setFee(String fee);

	//Setting license properties
	public boolean setProperties(String licenseNo);

	//Used to restore license own properties
	public void restoreProperties(String licenseNo, String licensor, String type, String title, String fee);

	//Get license own license no
	public String getNo();

	//Get license own licensor
	public String getLicensor();

	//Get license own type
	public String getType();

	//Get license own title
	public String getTitle();

	//Get license own fee
	public String getFee();

	//Provide own toString function
	public String toString();
}