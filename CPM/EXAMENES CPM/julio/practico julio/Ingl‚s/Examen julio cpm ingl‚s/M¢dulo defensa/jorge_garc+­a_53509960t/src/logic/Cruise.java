package logic;

import java.util.ArrayList;
import java.util.Date;

public class Cruise {
	
	private String cruiseCode;
	private String area;
	private String denominacion;
	private String startingPoint;
	private String Itinerary;
	private String description;
	private boolean aptoMenores;
	private int duracion;
	private ArrayList<String> dates;
	private String boatCode;
	
	public Cruise(String cruiseCode, String area, String denominacion, String startingPoint, String itinerary,
			String description, boolean aptoMenores, int duracion,  ArrayList<String> dates, String barco) {
		super();
		this.cruiseCode = cruiseCode;
		this.area = area;
		this.denominacion = denominacion;
		this.startingPoint = startingPoint;
		Itinerary = itinerary;
		this.description = description;
		this.aptoMenores = aptoMenores;
		this.duracion = duracion;
		this.dates = dates;
		this.boatCode = barco;
	}
	
	

	public String getCruiseCode() {
		return cruiseCode;
	}

	public void setCruiseCode(String cruiseCode) {
		this.cruiseCode = cruiseCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getItinerary() {
		return Itinerary;
	}

	public void setItinerary(String itinerary) {
		Itinerary = itinerary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAptoMenores() {
		return aptoMenores;
	}

	public void setAptoMenores(boolean aptoMenores) {
		this.aptoMenores = aptoMenores;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	

	public String getBarcoCodigo() {
		return boatCode;
	}

	public void setBarco(String barco) {
		this.boatCode = barco;
	}

	public ArrayList<String> getDates() {
		return dates;
	}

	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
	}


	

	


}
