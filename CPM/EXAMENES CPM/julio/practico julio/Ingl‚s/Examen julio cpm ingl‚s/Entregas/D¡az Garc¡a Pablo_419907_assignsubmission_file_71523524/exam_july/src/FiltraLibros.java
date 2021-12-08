import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class FiltraLibros implements ListModel<String> {

	ArrayList<String[]> catalogo;
	public final static int LESS_15 = 0;
	public final static int FROM_15_TO_40 = 1;
	public final static int MORE_40 = 2;

	public FiltraLibros(int filter) {
		leerCatalogo();
		if (!catalogo.isEmpty())
			for (String[] libro : catalogo)
				if (filter == LESS_15) 
					if (Double.valueOf(libro[6]) >= 15.0)
						catalogo.remove(libro);
					else if (filter == FROM_15_TO_40)
						if (Double.valueOf(libro[6]) < 15.0
								|| Double.valueOf(libro[6]) > 40.0)
							catalogo.remove(libro);
						else if (Double.valueOf(libro[6]) <= 40.0)
							catalogo.remove(libro);

			
	}

	void leerCatalogo() {
		String nombreFichero = "libros.dat";
		String linea = "";
		catalogo = new ArrayList<String[]>();
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					nombreFichero));

			// Mientras quede información
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split(":");
				catalogo.add(trozos);
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found.");
		} catch (IOException ioe) {
			new RuntimeException("I/O error");
		}
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {

	}

	@Override
	public String getElementAt(int arg0) {
		return catalogo.get(arg0)[1];
	}

	@Override
	public int getSize() {
		return catalogo.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub

	}
}
