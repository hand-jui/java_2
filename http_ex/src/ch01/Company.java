package ch01;

public class Company {

	private String companyName;
	private String catchPhrase;
	private String bs;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	@Override
	public String toString() {
		return "{ \"companyName\":\"" + companyName + "\", \"catchPhrase\":\"" + catchPhrase + "\", \"bs\":\"" + bs + "\" }";
	}

}
