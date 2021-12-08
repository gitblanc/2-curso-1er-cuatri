package logic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Booking {

	private ArrayList<Cabin> cabins;
	private Person person;
	private Cruise cruise;
	private Boolean isOferta;
	private String comments;

	private String date;

	private Database database = new Database();

	private int totalCamarotes;
	private int totalExtras;
	private int descuento;
	
	private boolean isTrip;
	private String tripName;

	public String getTripName() {
		return tripName;
	}


	public void setTripName(String tripName) {
		this.tripName = tripName;
	}


	public Booking(Cruise cruise, ArrayList<Cabin> cabins, Person person, String date, Boolean isOferta, Boolean isTrip, String tripName) {
		super();
		this.cabins = cabins;
		this.person = person;
		this.cruise = cruise;
		this.date = date;
		this.isOferta = isOferta;
		this.isTrip = isTrip;
		this.tripName = tripName;

	}
	

	public boolean isTrip() {
		return isTrip;
	}






	public String toString()
	{
		Date fecha = new Date();
		String aux ="\n\t" + "JUSTIFICANTE RESERVA - EII CRUCEROS - " + fecha + "\n";
		aux+="\t" + "------------------------------------------------------------------------------------------"; 
		aux+="\n\tNOMBRE: " + person.getName() + " " + person.getSurname()
				+ "   NIF: " + person.getDNI() + "   PHONE: " + person.getPhone();
		aux+="\n\n\t**DATOS DEL CRUCERO**";
		aux+="\n\tCrucero: " + cruise.getDenominacion() + " / " + cruise.getCruiseCode();
		aux+="\n\tBarco: " + getBoat().getName();
		aux+="\n\tFecha de Salida: " + getDate();
		aux+="\n\tDías: " + getCruise().getDuracion();
		aux+="\n\tSalida: " + getCruise().getStartingPoint();
		aux+="\n\tNúmero de pasajeros: " +getNumeroPasajeros();
		String camarotes = "";
		for (Cabin each : getCabins())
			camarotes += each.toString2();
		aux+="\n\tCamarotes: " + camarotes;
		aux+="\n\n    **PAGADO RESERVA**";
		aux+="\n\tCamarotes: " + calcularPrecioCamarotes() + "€";
		aux+="\n\tExtras: " + calcularPrecioExtras() + "€";
		if (getIsOferta())
			aux+="\n\tDescuento Oferta: " +calcularDescuento();

			aux+="\n\tImporte total: " + calcularPrecioFinal();
		aux+="\n\n\t------------------------------------------------------------------------------------------\n";
		aux+="Comments: "+ getComments();
		return aux;
	}

	public int grabarPedido() {
		String fecha = date.replace("/", "_"); //bug de / que salta el catch
		String pedido = person.getDNI()+"-"+fecha;
		String nombreFichero2 = "files/reservas/"+pedido+".dat";
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(nombreFichero2));
			fichero.write(toString());
			fichero.close();
			return (0);
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
			return (-1);
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
			return (-2);
		}
	}

	public Boat getBoat() {
		return database.getBoat(cruise.getBarcoCodigo());
	}

	public int getNumeroPasajeros() {
		int total = 0;
		for (Cabin each : cabins) {
			total += each.getNumeroPasajeros();
		}
		return total;

	}

	/**
	 * nºDays*typeOfCabin
	 * @return
	 */
	public int calcularPrecioCamarotes() {
		totalCamarotes = 0;
		for (Cabin each : cabins) {
			if (each.getIsOutside() && each.getIsFamiliar())// Familiar Exterior
				totalCamarotes += cruise.getDuracion()*getBoat().getPrecioFamiliarExterior();
			if (!each.getIsOutside() && each.getIsFamiliar())// Familiar Interior
				totalCamarotes += cruise.getDuracion()*getBoat().getPrecioFamiliarInterior();
			if (each.getIsOutside() && !each.getIsFamiliar()) //Doble exterior
				totalCamarotes += cruise.getDuracion()*getBoat().getPrecioDobleExterior();
			if (!each.getIsOutside() && !each.getIsFamiliar())//Doble interior
				totalCamarotes += cruise.getDuracion()*getBoat().getPrecioDobleInterior();
		}

		return totalCamarotes;

	}

	public int calcularPrecioExtras() {
		totalExtras = 0;
		for (Cabin cabin : cabins) {
			for (Extras extra : cabin.getExtras()){
				if(extra.getExtraName().equals("Cama supletoria"))
					totalExtras += extra.getExtraPrice()*cruise.getDuracion();
				else
					totalExtras += extra.getExtraPrice()*cruise.getDuracion()*cabin.getNumeroPasajeros();
			}
		}
		return totalExtras;
	}

	public int calcularDescuento() {
		descuento = ((calcularPrecioExtras() + calcularPrecioCamarotes()) * 15 / 100);
		return descuento;
	}
	public int calculaPrecioTrip()
	{
		int aux = 0;
		if(isTrip)
		{
			aux = getNumeroPasajeros()*database.getTripPriceGivenName(tripName);
		}
		return aux;
	}

	public int calcularPrecioFinal() {
		return totalCamarotes + totalExtras - descuento + calculaPrecioTrip();
	}

	public ArrayList<Cabin> getCabins() {
		return cabins;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setCabins(ArrayList<Cabin> cabins) {
		this.cabins = cabins;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Cruise getCruise() {
		return cruise;
	}

	public void setCruise(Cruise cruise) {
		this.cruise = cruise;
	}

	public Boolean getIsOferta() {
		return isOferta;
	}

	public void setIsOferta(Boolean isOferta) {
		this.isOferta = isOferta;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

}