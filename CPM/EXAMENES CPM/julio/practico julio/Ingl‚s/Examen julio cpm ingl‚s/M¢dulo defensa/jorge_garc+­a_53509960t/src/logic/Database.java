package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

	private static final String FICHERO_BOAT = "files/barcos.dat";
	private static final String FICHERO_CRUISE = "files/cruceros.dat";
	private static final String FICHERO_EXTRAS = "files/extras.dat";
	private static final String FICHERO_EXCURSIONES = "files/excursiones.dat";


	private List<Cruise> cruiseList = null;
	private List<Boat> boatList = null;
	private List<Extras> extrasList = null;
	private List<Excursiones> excursionesList = null;


	// GETTERS

	// CONSTRUCTOR
	public Database() {
		cruiseList = new ArrayList<Cruise>();
		boatList = new ArrayList<Boat>();
		extrasList = new ArrayList<Extras>();
		excursionesList = new ArrayList<Excursiones>();
		
		cargarExcursiones();
		cargarCruises();
		cargarBoats();
		cargarExtras();
	}
	
	public Boolean isTripGivenCruiseCode(String code)
	{
		for(Excursiones each : excursionesList)
		{
			if(each.getCruiseCode().equals(code))
				return true;
		}
		return false;
	}
	public int getTripPriceGivenName(String tripName)
	{
		for(Excursiones each: excursionesList)
		{
			if(each.getName().equals(tripName))
				return each.getPrice();
		}
		return -1;
		
	}
	public ArrayList<Excursiones> getTripGivenCruiseCode(String code)
	{
		ArrayList<Excursiones> excursiones = new ArrayList<Excursiones>();
		for(Excursiones each : excursionesList)
		{
			if(each.getCruiseCode().equals(code))
				excursiones.add(each);
		}
		return excursiones;
	}
	private void cargarExcursiones() {
		String linea = "";
		String tokens[] = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(FICHERO_EXCURSIONES));
			while (fichero.ready()) {
				linea = fichero.readLine();
				tokens = linea.split("@");
				excursionesList.add(parseExcursiones(tokens));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	private Excursiones parseExcursiones(String[] tokens) {

		String cruiseCode = tokens[0];
		String city = tokens[1];
		String name = tokens[2];
		String description = tokens[3];
		int price = Integer.parseInt(tokens[4]);
		
		
		

		return new Excursiones(cruiseCode, city, name, description,price);
	}

	private void cargarCruises() {
		String linea = "";
		String tokens[] = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(FICHERO_CRUISE));
			while (fichero.ready()) {
				linea = fichero.readLine();
				tokens = linea.split(";");
				cruiseList.add(parseCruises(tokens));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	private Cruise parseCruises(String[] tokens) {

		String cruiseCode = tokens[0];
		String area = tokens[1];
		String denominacion = tokens[2];
		String startingPoint = tokens[3];
		String itinerary = tokens[4];
		String description = tokens[5];
		boolean aptoMenores = false;
		if (tokens[6].equals("S"))
			aptoMenores = true;
		int duracion = Integer.parseInt(tokens[7]);
		ArrayList<String> dates = parseDates(tokens[8]);
		String barco = tokens[9];
		
		

		return new Cruise(cruiseCode, area, denominacion, startingPoint, itinerary, description, aptoMenores, duracion,
				dates, barco);
	}

	private ArrayList<String> parseDates(String line) {
		String tokens[] = line.split("%");
		ArrayList<String> dates = new ArrayList<String>();
		for (int i = 0; i < tokens.length; i++) {
				String date = tokens[i];
				dates.add(date);
		}
		return dates;

	}

	private void cargarBoats() {
		String linea = "";
		String tokens[] = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(FICHERO_BOAT));
			while (fichero.ready()) {
				linea = fichero.readLine();
				tokens = linea.split(";");
				boatList.add(parseBoats(tokens));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	private Boat parseBoats(String[] tokens) {
		String boatCode = tokens[0];
		String name = tokens[1];
		String description = tokens[2];
		int dobleInterior = Integer.parseInt(tokens[3]);
		int dobleExterior = Integer.parseInt(tokens[4]);
		int familiarInterior = Integer.parseInt(tokens[5]);
		int familiarExterior = Integer.parseInt(tokens[6]);
		int precioDobleInterior = Integer.parseInt(tokens[7]);
		int precioDobleExterior = Integer.parseInt(tokens[8]);
		int precioFamiliarInterior = Integer.parseInt(tokens[9]);
		int precioFamiliarExterior = Integer.parseInt(tokens[10]);

		return new Boat(boatCode, name, description, dobleExterior, dobleInterior, familiarExterior, familiarInterior,
				precioDobleExterior, precioDobleInterior, precioFamiliarInterior, precioFamiliarExterior);

	}

	private void cargarExtras() {
		String linea = "";
		String tokens[] = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(FICHERO_EXTRAS));
			while (fichero.ready()) {
				linea = fichero.readLine();
				tokens = linea.split(";");
				extrasList.add(parseExtras(tokens));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	private Extras parseExtras(String[] tokens) {

		String extraCode = tokens[0];
		String extraName = tokens[1];
		int extraPrice = Integer.parseInt(tokens[2]);

		return new Extras(extraCode, extraName, extraPrice);
	}

	public Cruise[] getCruises() {
		Cruise[] cruises = cruiseList.toArray(new Cruise[cruiseList.size()]);
		return cruises;
	}

	public Boat[] getBoats() {
		Boat[] boats = boatList.toArray(new Boat[boatList.size()]);
		return boats;
	}

	public Extras[] getExtras() {
		Extras[] extras = extrasList.toArray(new Extras[extrasList.size()]);
		return extras;
	}
	
	public String getCruiseDescription(int indice) {
		  return cruiseList.get(indice).getDescription();
	  }
	public String getCruiseCode(String startPoint) {
		for(Cruise each: cruiseList){
			if(each.getStartingPoint().equals(startPoint))
					return each.getCruiseCode();
		}
			
		  return null;
	  }
	public String getCruiseItinerary(int indice) {
		  return cruiseList.get(indice).getItinerary();
	  }
	public String getBoatName(String code)
	{
		for (Boat each : boatList)
			
			if(each.getBoatCode().equals(code))
				return each.getName();
		return "Invalid code";
	}
	public Boat getBoat(String code)
	{
		for (Boat each : boatList)
			if (each.getBoatCode().equals(code))
				return each;
		return null;
	}
	public Cruise getCruise(String code)
	{
		for (Cruise each : cruiseList)
			if(each.getCruiseCode().equals(code))
				return each;
		return null;
	}
	
	public Extras getExtraGivenName(String name)
	{
		String aux = name.split("\\(")[0].trim();
		for(Extras each : extrasList)
			if(each.getExtraName().equals(aux))
				return each;
		return null;
	}
	
//	public Extras getJacuzzi()
//	{
//		for(Extras each : extrasList)
//			if(each.getExtraCode().equals("E01"))
//				return each;
//		return null;
//	}
//	public Extras getCamaSupletoria()
//	{
//		for(Extras each : extrasList)
//			if(each.getExtraCode().equals("E02"))
//				return each;
//		return null;
//	}
//	public Extras getDesayuno()
//	{
//		for(Extras each : extrasList)
//			if(each.getExtraCode().equals("E03"))
//				return each;
//		return null;
//	}
//	public Extras getCamaExtragrande()
//	{
//		for(Extras each : extrasList)
//			if(each.getExtraCode().equals("E04"))
//				return each;
//		return null;
//	}
		

	public List<Cruise> getCruiseList() {
		return cruiseList;
	}

	public List<Boat> getBoatList() {
		return boatList;
	}

	public List<Extras> getExtrasList() {
		return extrasList;
	}

	public Boat getBoatGivenName(String boatName) {
		for (Boat each : boatList)
			if (each.getName().equals(boatName))
				return each;
		return null;
	}

}
