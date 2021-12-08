package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Database;

public class testDatabase {
	
	private Database data;
	

	@Test
	public void test() {
		data = new Database();
		assertEquals(true, data.getCruises()[1].isAptoMenores());
		assertEquals(40, data.getBoats()[1].getPrecioFamiliarExterior());
		assertEquals(20, data.getExtras()[1].getExtraPrice());
		assertEquals("Cama extragrande", data.getExtras()[3].getExtraName());


		

		
	}

}
