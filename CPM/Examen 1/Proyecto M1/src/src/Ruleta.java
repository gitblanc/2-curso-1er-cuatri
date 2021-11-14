/**
 * 
 */
package src;

import java.util.ArrayList;

/**
 * @author blanc
 *
 */
public class Ruleta {

	private static final String FICHERO = "files/premios.dat";
	private static final double DISPARO = 5;
	private float puntosTirada;
	private ArrayList<Articulo> listaArticulos;

	public Ruleta() {
		listaArticulos = new ArrayList<>();
		setPuntosTirada(0);
		FileUtil.loadFile(FICHERO, listaArticulos);
	}

	// Método que convierte una lista en un array
	public Articulo[] getArticulos() {
		Articulo[] articulos = listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		return articulos;
	}

	// Método para girar ruleta
	public int lanzar() {
		int value = (((int) (Math.random() * DISPARO) + 1)*100);
		setPuntosTirada(value);
		return value;
	}

	public void setPuntosTirada(float puntosTirada) {
		this.puntosTirada = puntosTirada;
	}
	
	public float getPuntosTirada() {
		return this.puntosTirada;
	}
	
	public ArrayList<Articulo> getPremiosMismoTipo(String tipo) {
		ArrayList<Articulo> arts = new ArrayList<>();
		for(Articulo art : listaArticulos) {
			if(art.getTipo().equals(tipo)) {
				arts.add(art);
			}
		}
		return arts;
	}

}
