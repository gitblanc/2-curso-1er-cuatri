package logic;


public class Boat {
	
	private String boatCode;
	private String name;
	private String description;
	private int dobleExterior;
	private int dobleInterior;
	private int FamiliarExterior;
	private int FamiliarInterior;
	private int precioDobleExterior;
	private int precioDobleInterior;
	private int precioFamiliarInterior;
	private int precioFamiliarExterior;
	
	

	public Boat(String boatCode, String name, String description, int dobleExterior, int dobleInterior,
			int familiarExterior, int familiarInterior, int precioDobleExterior, int precioDobleInterior,
			int precioFamiliarInterior, int precioFamiliarExterior) {
		super();
		this.boatCode = boatCode;
		this.name = name;
		this.description = description;
		this.dobleExterior = dobleExterior;
		this.dobleInterior = dobleInterior;
		FamiliarExterior = familiarExterior;
		FamiliarInterior = familiarInterior;
		this.precioDobleExterior = precioDobleExterior;
		this.precioDobleInterior = precioDobleInterior;
		this.precioFamiliarInterior = precioFamiliarInterior;
		this.precioFamiliarExterior = precioFamiliarExterior;
	}

	public String getBoatCode() {
		return boatCode;
	}

	public void setBoatCode(String boatCode) {
		this.boatCode = boatCode;
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

	public int getDobleExterior() {
		return dobleExterior;
	}

	public void setDobleExterior(int dobleExterior) {
		this.dobleExterior = dobleExterior;
	}

	public int getDobleInterior() {
		return dobleInterior;
	}

	public void setDobleInterior(int dobleInterior) {
		this.dobleInterior = dobleInterior;
	}

	public int getFamiliarExterior() {
		return FamiliarExterior;
	}

	public void setFamiliarExterior(int familiarExterior) {
		FamiliarExterior = familiarExterior;
	}

	public int getFamiliarInterior() {
		return FamiliarInterior;
	}

	public void setFamiliarInterior(int familiarInterior) {
		FamiliarInterior = familiarInterior;
	}

	public int getPrecioDobleExterior() {
		return precioDobleExterior;
	}

	public void setPrecioDobleExterior(int precioDobleExterior) {
		this.precioDobleExterior = precioDobleExterior;
	}

	public int getPrecioDobleInterior() {
		return precioDobleInterior;
	}

	public void setPrecioDobleInterior(int precioDobleInterior) {
		this.precioDobleInterior = precioDobleInterior;
	}

	public int getPrecioFamiliarInterior() {
		return precioFamiliarInterior;
	}

	public void setPrecioFamiliarInterior(int precioFamiliarInterior) {
		this.precioFamiliarInterior = precioFamiliarInterior;
	}

	public int getPrecioFamiliarExterior() {
		return precioFamiliarExterior;
	}

	public void setPrecioFamiliarExterior(int precioFamiliarExterior) {
		this.precioFamiliarExterior = precioFamiliarExterior;
	}
	public int getNumeroCamarotesDiferentes() {
		int counter = 0;
		if(getDobleExterior()!=0)
			counter++;
		if(getDobleInterior()!=0)
			counter++;
		if(getFamiliarExterior()!=0)
			counter++;
		if(getFamiliarInterior()!=0)
			counter++;
		return counter;
	}

	public String [] getAvailableCabins() {
		int index = 0;
		String [] cabins = new String[getNumeroCamarotesDiferentes()];
		if(getDobleExterior()>0){
			cabins[index] = "Doble Exterior " + getPrecioDobleExterior() + "€";
			index++;
		}
		if(getDobleInterior()>0){
			cabins[index] = "Doble Interior " + getPrecioDobleInterior() + "€";
			index++;
		}
		if(getFamiliarExterior()>0){
			cabins[index] = "Familiar Exterior " + getPrecioFamiliarExterior() + "€";
			index++;
		}
		if(getFamiliarInterior()>0){
			cabins[index] = "Familiar Interior " + getPrecioFamiliarInterior() + "€";
			index++;
		}
		return cabins;
	}

	
	
}
	
