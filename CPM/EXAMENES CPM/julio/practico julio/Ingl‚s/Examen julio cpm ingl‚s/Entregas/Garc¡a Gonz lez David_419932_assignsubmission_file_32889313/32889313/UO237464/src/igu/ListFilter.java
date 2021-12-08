package igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;

import logica.Book;

public class ListFilter implements ActionListener {

	private ArrayList<Book> books;
	private JList listBooks;
	private DefaultListModel<Book> modelBooks;
	private JCheckBox lower;
	private JCheckBox between;
	private JCheckBox more;

	public ListFilter(ArrayList<Book> books, JList listBooks,
			DefaultListModel<Book> modelBooks, JCheckBox lower,
			JCheckBox between, JCheckBox more) {
		this.books = books;
		this.listBooks = listBooks;
		this.modelBooks = modelBooks;
		this.lower = lower;
		this.between = between;
		this.more = more;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		modelBooks.clear();
		for (Book b : books) {
			if (lower.isSelected() && b.getPrice() < 15 || between.isSelected()
					&& b.getPrice() >= 15 && b.getPrice() <= 40
					|| more.isSelected() && b.getPrice() > 40) {
				modelBooks.addElement(b);
			}
			listBooks.setModel(modelBooks);
		}

	}

}
