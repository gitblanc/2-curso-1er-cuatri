package logic;

public class Extras {
	
	private String extraCode;
	private String extraName;
	private int extraPrice;
	
	public Extras(String extraCode, String extraName, int extraPrice) {
		this.extraCode = extraCode;
		this.extraName = extraName;
		this.extraPrice = extraPrice;
	}

	public String getExtraCode() {
		return extraCode;
	}

	public void setExtraCode(String extraCode) {
		this.extraCode = extraCode;
	}

	public String getExtraName() {
		return extraName;
	}

	public void setExtraName(String extraName) {
		this.extraName = extraName;
	}

	public int getExtraPrice() {
		return extraPrice;
	}

	public void setExtraPrice(int extraPrice) {
		this.extraPrice = extraPrice;
	}


	
}
