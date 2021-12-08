package igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;

import logica.Libro;

public class FiltraLibros implements ActionListener {
	private JList<Libro> listaLib;
	private JCheckBox menos;
	private JCheckBox mas;
	private JCheckBox entre;
	private ArrayList<Libro> libros;
	private DefaultListModel<Libro> modelo;

	public FiltraLibros(JList<Libro> listaLib, DefaultListModel<Libro> modelo,
			JCheckBox menos, JCheckBox mas, JCheckBox entre,
			ArrayList<Libro> libros) {
		this.listaLib = listaLib;
		this.modelo = modelo;
		this.menos = menos;
		this.mas = mas;
		this.entre = entre;
		this.libros = libros;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		modelo.clear();
		for (Libro libro : libros) {
			if (menos.isSelected() && libro.getPrecio() < 15 || entre.isSelected()
					&& libro.getPrecio() >= 15 && libro.getPrecio() <= 40
					|| mas.isSelected() && libro.getPrecio() > 40) {
				modelo.addElement(libro);
			}
		}
		listaLib.setModel(modelo);
	}

}
