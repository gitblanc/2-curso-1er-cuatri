package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import logic.Book;
import logic.Library;

public class FiltraLibros implements ActionListener {
	MainWindow window;
	public FiltraLibros(MainWindow window) {
		this.window = window;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		DefaultListModel<String> model = new DefaultListModel<String>();
		window.getLstBooks().clearSelection();
		for(Book b : Library.getBooks()) {
			if((b.getPrice() < 15) && window.getChck15().isSelected() || b.getPrice() < 40 && window.getChck40().isSelected() || window.getChckM().isSelected())
				model.addElement(b.getTitle());
			window.getLstBooks().setModel(model);
		}
	}

}
