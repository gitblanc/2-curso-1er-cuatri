/**
 * 
 */
package src;

/**
 * @author blanc
 *
 */
public class Articulo {

	private String codigo;
	private String tipo;
	private String denominacion;
	private float precio;
	private int unidades;

	public Articulo(String string, String string2, String string3, float parseFloat, int i) {
		setCodigo(string);
		setTipo(string2);
		setDenominacion(string3);
		setPrecio(parseFloat);
		setUnidades(i);
	}

	public Articulo(Articulo articuloDelCatalogo) {
		setCodigo(articuloDelCatalogo.getCodigo());
		setTipo(articuloDelCatalogo.getTipo());
		setDenominacion(articuloDelCatalogo.getDenominacion());
		setPrecio(articuloDelCatalogo.getPrecio());
		setUnidades(articuloDelCatalogo.getUnidades());
	}

	// Método que redefine toString
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.tipo);
		buffer.append(" - ");
		buffer.append(this.denominacion);
		buffer.append(" - ");
		buffer.append(this.precio);
		buffer.append(" €");
		if (this.unidades != 0) {
			buffer.append(" (");
			buffer.append(this.unidades);
			buffer.append(" uds)");
		}
		return buffer.toString();
	}

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDenominacion() {
		return denominacion;
	}

	private void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public float getPrecio() {
		return precio;
	}

	private void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
}
