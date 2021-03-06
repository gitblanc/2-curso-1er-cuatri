package logica;

import java.util.*;

public class Carta {

	private static final String FICHERO_ARTICULOS = "files/articulos.dat";
	private List<Articulo> listaArticulos = null;

	public Carta() {
		listaArticulos = new ArrayList<Articulo>();
		cargarArticulos();
	}

	private void cargarArticulos() {
		FileUtil.loadFile(FICHERO_ARTICULOS, listaArticulos);
	}

	public Articulo[] getArticulos() {
		Articulo[] articulos = listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		return articulos;
	}

	public Articulo[] getArticulosMismoTipo(String tipo) {
		Articulo[] articulos = new Articulo[6];
		int i = 0;
		for (Articulo art : listaArticulos) {
			if (art.getTipo().equals(tipo)) {
				articulos[i] = art;
				i++;
			}
		}
		return articulos;
	}

}
