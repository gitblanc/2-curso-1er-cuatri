package igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;

import logic.Book;
import logic.Bookstore;

public class FiltraLibros implements ActionListener{
	
	private JList<String> listBooks;
	private JCheckBox checkbox1;
	private JCheckBox checkbox2;
	private JCheckBox checkbox3;
	
	private DefaultListModel<String> modeloLibros;
	
	public FiltraLibros(JList<String> books, JCheckBox checkbox1,
			JCheckBox checkbox2, JCheckBox checkbox3,
			DefaultListModel<String> modeloLibros) {
		this.listBooks = books;
		this.checkbox1 = checkbox1;
		this.checkbox2 = checkbox2;
		this.checkbox3 = checkbox3;
		this.modeloLibros = modeloLibros;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		List<Book> books = Bookstore.getAllBooks();
		
		((DefaultListModel<String>) modeloLibros).clear();
		
		for(Book b : books){
			if(checkbox1.isSelected() && (b.getPrice()<15.0) || checkbox2.isSelected() && (b.getPrice()>=15.0) 
					&& (b.getPrice()<=40.0) || checkbox3.isSelected() && (b.getPrice()>40.0)){
				String title = b.getTitle();
				modeloLibros.addElement(title);
			}
		}
	}	
}

