package logic;

public class Excursiones {
	private String cruiseCode;
	private String city;
	private String name;
	private String description;
	public Excursiones(String cruiseCode, String city, String name,
			String description, int price) {
		
		this.cruiseCode = cruiseCode;
		this.city = city;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getCruiseCode() {
		return cruiseCode;
	}
	public void setCruiseCode(String cruiseCode) {
		this.cruiseCode = cruiseCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int price;

}
