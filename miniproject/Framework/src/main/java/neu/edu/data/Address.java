package neu.edu.data;

public class Address {

	private String line1;
	private String city;
	private String state;
	private String country;
	private String zip;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		// TODO Auto-generated method stub
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [line1=" + line1 + ", city=" + city + ", state=" + state + ", country=" + country + ", zip="
				+ zip + "]";
	}
}
