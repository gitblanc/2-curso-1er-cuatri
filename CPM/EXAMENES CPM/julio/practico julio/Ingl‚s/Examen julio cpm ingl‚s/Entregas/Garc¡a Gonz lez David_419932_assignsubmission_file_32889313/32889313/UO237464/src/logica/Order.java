package logica;

import java.util.ArrayList;

public class Order {

	private ArrayList<OrderBook> dataBase;

	public Order() {
		dataBase = new ArrayList<OrderBook>();
	}

	public ArrayList<OrderBook> getDataBase() {
		return dataBase;
	}

}
