package logic;

import java.util.ArrayList;

public  class Cabin {
	
	private ArrayList<Extras> extras;
	private int age1;
	private int age2;
	private int age3;
	private int age4;
	private int ageExtra;

	private Boolean isOutside;
	private Boolean isFamiliar;
	private int cabinCode;

	public Cabin(ArrayList<Extras> extras, int age1, int age2, int age3, int age4,int ageExtra, Boolean isOutside,
			Boolean isFamiliar, int cabinCode) {
		this.extras = extras;
		this.age1 = age1;
		this.age2 = age2;
		this.age3 = age3;
		this.age4 = age4;
		this.ageExtra = ageExtra;
		this.isOutside = isOutside;
		this.isFamiliar = isFamiliar;
		this.cabinCode = cabinCode;
	}
	
	public int getNumeroPasajeros(){
		int total = 0;
		if (age1 != -1)
			total++;
		if (age2 != -1)
			total++;
		if (age3 != -1)
			total++;
		if (age4 != -1)
			total++;
		
		return total;
		
	}
	
	public int getAgeExtra() {
		return ageExtra;
	}

	public void setAgeExtra(int ageExtra) {
		this.ageExtra = ageExtra;
	}

	public String toString2()
	{
		String aux = " 1 ";
		if (isFamiliar)
			aux+= "familiar ";
		if(!isFamiliar)
			aux+= "doble ";
		if(isOutside)
			aux+= "exterior / ";
		if(!isOutside)
			aux+= "interior / ";
		for (Extras each : extras)
			aux+= each.getExtraName()+", ";
		aux+= ";";
		
		return aux;
	}
	
	public String toString()
	{
		String aux = " 1 ";
		if (isFamiliar)
			aux+= "familiar ";
		if(!isFamiliar)
			aux+= "doble ";
		if(isOutside)
			aux+= "exterior / ";
		if(!isOutside)
			aux+= "interior / ";
		
		
		return aux;
	}
	public int getCabinCode() {
		return cabinCode;
	}
	public void setCabinCode(int cabinCode) {
		this.cabinCode = cabinCode;
	}
	public ArrayList<Extras> getExtras() {
		return extras;
	}
	public void setExtras(ArrayList<Extras> extras) {
		this.extras = extras;
	}
	
	public Boolean getIsOutside() {
		return isOutside;
	}
	public void setIsOutside(Boolean isInside) {
		this.isOutside = isInside;
	}
	public Boolean getIsFamiliar() {
		return isFamiliar;
	}
	public void setIsFamiliar(Boolean isFamiliar) {
		this.isFamiliar = isFamiliar;
	}

	public int getAge1() {
		return age1;
	}

	public void setAge1(int age1) {
		this.age1 = age1;
	}

	public int getAge2() {
		return age2;
	}

	public void setAge2(int age2) {
		this.age2 = age2;
	}

	public int getAge3() {
		return age3;
	}

	public void setAge3(int age3) {
		this.age3 = age3;
	}

	public int getAge4() {
		return age4;
	}

	public void setAge4(int age4) {
		this.age4 = age4;
	}




	
}
