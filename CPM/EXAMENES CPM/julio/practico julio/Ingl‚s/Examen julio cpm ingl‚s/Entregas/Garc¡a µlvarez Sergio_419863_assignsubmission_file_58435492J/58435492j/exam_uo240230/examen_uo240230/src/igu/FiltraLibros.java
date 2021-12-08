package igu;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;

import logica.Book;

public class FiltraLibros implements ActionListener {

		private JList list;
		private DefaultListModel<Book> booksModel;
		private JCheckBox lessThan;
		private JCheckBox between;
		private JCheckBox moreThan;
		private ArrayList<Book> books;
		
		
		public FiltraLibros (JList<Book> booksList, JCheckBox lessThan, JCheckBox moreThan, JCheckBox between,
				ArrayList<Book> books, DefaultListModel<Book> booksModel) {
			super();
			this.list = booksList;
			this.lessThan = lessThan;
			this.moreThan = moreThan;
			this.between = between;
			this.books = books;
			this.booksModel = booksModel;
		}


		@Override
		public void actionPerformed(ActionEvent arg0) {
			booksModel.clear();
			for(Book l : books){
				if(lessThan.isSelected() && l.getPrice()<15
						|| between.isSelected() && l.getPrice() >= 15 && l.getPrice() <= 40
						|| moreThan.isSelected() && l.getPrice() > 40){
					booksModel.addElement(l);
				}
			}
			list.setModel(booksModel);
		}
		
		
		
}
