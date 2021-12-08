package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Boat;
import logic.Booking;
import logic.Cabin;
import logic.Cruise;
import logic.Database;
import logic.Excursiones;
import logic.Extras;
import logic.Person;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.FlowLayout;

import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
//Ayuda
import javax.help.*;

import java.net.*;
import java.io.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Insets;
import java.awt.event.KeyAdapter;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel pnCenter;
	private JPanel pnNorte;
	private JLabel lblPaso1;
	private JLabel lblPaso2;
	private JLabel lblPaso3;
	private JLabel lblPaso4;
	private JLabel lblPaso5;
	private JLabel lblPaso6;
	private JPanel pn1;
	private JPanel pnSouth1;
	private JPanel pnBotones1;
	private JButton btnSubmit;
	private JLabel lblDestiny;
	private JComboBox<?> cbZonas;
	private JLabel lblWelcome;
	private JPanel pn2;
	private JPanel pnDiscounts;
	private JLabel lblOferta;
	private JButton btnDiscount2;
	private JButton btnDiscount1;
	private JLabel lblCruiseList;
	private JPanel pnBotones2;
	private JButton btnBook2;
	private JButton btnBack2;
	private JPanel pnBase2;
	private JTextArea taDescription;
	private JPanel pnTabla;
	private JScrollPane scCruises;
	private JPanel pnFiltro;
	private JTable tCruises;
	private JPanel pn3;
	private JPanel pnFotoFondo;
	private JCheckBox chckbxKids;
	private JCheckBox chckbxShort;
	private JCheckBox chckbxLong;
	private JPanel pnReserva2;
	private JLabel lblFotoRelleno2;
	private JLabel lblCustomizeYourTrip;
	private JPanel pnSouth3;
	private JButton btBack3;
	private JPanel pnBotones3;
	private JButton btnBook3;
	private JPanel pn4;
	private JLabel lblPersonalData;
	private JPanel pnSouth4;
	private JPanel pnData;
	private JPanel pnLabels;
	private JPanel pnTextFields;
	private JLabel lblName;
	private JTextField txName;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txPassport;
	private JTextField txPhone;
	private JButton btnBook4;
	private JButton btnBack4;
	private JPanel pn5;
	private JLabel lblDate;

	private JTextField txSurname;
	private JLabel lblNewLabel_2;
	private JLabel lblResume;
	private JPanel pnResumeData;
	private JPanel pnBotones5;
	private JButton btnBook5;
	private JButton btnBack5;
	private JPanel pnLabelsResumeDataLeft;
	private JPanel pnExtraFotos;
	private JPanel pnCenter5;
	private JPanel pnNorth5;
	private JLabel lblResumeTitle;
	private JLabel lblDatosCliente;
	private JLabel lblDataEspacio1;
	private JLabel lblDataDatosCrucero;
	private JLabel lblDataCrucero;
	private JLabel lblDataBarco;
	private JLabel lblDataFechaDeSalida;
	private JLabel lblDataDias;
	private JLabel lblDataSalida;
	private JLabel lblDataNumeroPasajeros;
	private JLabel lblDataEspacio2;
	private JLabel lblDataPagadoReserva;
	private JLabel lblDataPrecioCamarotes;
	private JLabel lblDataPrecioExtras;
	private JLabel lblDataDescuento;
	private JLabel lblDataEspacio3;
	private JLabel lblDataImporteTotal;
	private JPanel pnFotos;
	private JTextArea taDescripcionBarco;
	private JLabel lblFotoBarco;
	private JLabel lblAditionalData;
	private JTextField tfComments;

	private JPanel pnBase3;
	private JPanel pnDatos;
	private JPanel pnResumen;
	private JPanel pnResumenAux;
	private JPanel pnResumenButtons;
	private JPanel pnResumenButton1;
	private JPanel pnResumenButton2;
	private JButton btnAddCabin;
	private JButton btnRemoveCabin;
	private JPanel pnCabinType;
	private JPanel pnPassengers;
	private JPanel pnDates;
	private JPanel pnPassengersAux;
	private JPanel pnExtras;
	private JLabel lblTypeOfCabin;
	private JComboBox<?> cbCabins;
	private JPanel pnPassengerExtra;
	private JLabel lblDates;
	private JComboBox<?> cbSelectDate;
	private JCheckBox chckbxPassenger_extra;
	private JLabel label_extra;
	private JTextField textField_extra;
	private JPanel pnPassenger1;
	private JCheckBox chckbxPassenger_1;
	private JLabel label_1;
	private JTextField textField_1;
	private JPanel pnPassenger2;
	private JCheckBox chckbxPassenger_2;
	private JLabel label_2;
	private JTextField textField_2;
	private JPanel pnPassenger3;
	private JCheckBox chckbxPassenger_3;
	private JLabel label_3;
	private JTextField textField_3;
	private JPanel pnPassenger4;
	private JCheckBox chckbxPassenger_4;
	private JLabel label_4;
	private JTextField textField_4;
	private JPanel pnExtraButtons;
	private JButton btnAddExtra;
	private JButton btnRemoveExtra;
	private JPanel pnExtraList;
	private JScrollPane spAddedExtras;
	private JScrollPane scrollAllPane;
	private JList listExtras;
	private JList listExtrasSeleccionados;
	private JLabel lblResumen;
	private JScrollPane spResumen;
	private JList listResumen;
	
	
	// ***************************************************
	private ArrayList<Boolean> mayorDeEdad;
	private String discount1;
	private String discount2;
	private String selectedCruiseCode;
	private Cruise selectedCruise;
	private Database database = null;
	private Booking booking;
	private Cruise cruiseOferta1;
	private Cruise cruiseOferta2;
	private int cabinCode = 0;


	private ArrayList<Cabin> bookedCabins = new ArrayList<Cabin>();
	private Hashtable<String,String> dictionary;

	private DefaultListModel modeloListaResumen;

	private ModeloNoEditable modeloTablaExtrasFamiliar;
	private ModeloNoEditable modeloTablaExtrasDouble;
	private DefaultTableModel modeloTabla;
	private DefaultListModel modeloListaExtras;
	private DefaultListModel modeloListaExtrasSeleccionados;
	DefaultComboBoxModel modelDatesCb;

	String timeStamp;

	// Booking fields
	private JScrollPane spDiscount1;
	private JPanel pnAuxWelcome;
	private JScrollPane scrollPane_1;
	private JTextArea taDiscount1;
	private JTextArea taDiscount2;
	private JTextArea taDiscountDescription;
	private JPanel pnTabla2;
	private JLabel lblFotoCruise;
	private JScrollPane spDescipcionBarco;
	private JScrollPane spDescripcion;
	private JButton btnEditCabin;
	private JButton btnSaveChanges;
	private JButton btnCancel;
	private JLabel lblAvailableCabins;
	private JTextField txDate;
	private JMenuBar menuBar;
	private JMenu mnCrucero;
	private JMenu mnAyuda;
	private JMenuItem mntmReiniciar;
	private JSeparator separator;
	private JMenuItem mntmCrucero;
	private JMenuItem mntmNewMenuItem;
	private JSeparator separator_1;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblAailableCabinsText;
	private JScrollPane spDataCamarotes;
	private JTextArea taDataCamarotes;
	private JLabel lblDenominacion;
	private JLabel lblNewLabel_3;
	private JCheckBox chckbxTrip;
	private JLabel lblNewLabel_4;
	private JComboBox<?> comboBox;
	private JLabel lblExcursion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Sea Holidays!");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/Fondo.jpg")));
		database = new Database();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 720);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnCenter(), BorderLayout.CENTER);

		addRowsCruises(false, false, false,false);
		mostrarCruisesZona();
		cargaAyuda();
		

	}
	private void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		   try {
			    File fichero = new File("help/Ayuda.hs");
			    hsURL = fichero.toURI().toURL();
			    hs = new HelpSet(null, hsURL);
		   }

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		     return;
		   }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.initPresentation();

		   hb.enableHelpKey(getRootPane(),"intro", hs);
		   hb.enableHelpOnButton(mntmNewMenuItem, "intro", hs); //para asociarlo a un boton
		   hb.enableHelp(pn1, "intro", hs); //para key sensitive
		   hb.enableHelp(pn2, "cruceros", hs);
		   hb.enableHelp(pn3, "personalizacion", hs);
		   hb.enableHelp(pn4, "registro", hs);
		   hb.enableHelp(pn5, "resumen", hs);

		   
		 }

	

	private void reiniciaApp() {
		timeStamp = "";
		bookedCabins.clear();
		modeloListaExtras.clear();
		cargarExtras();
		modeloListaExtrasSeleccionados.clear();
		
		cleanResumeData();

		txName.setText("");
		txSurname.setText("");
		txPassport.setText("");
		txPhone.setText("");
		lblDenominacion.setText("");



		taDescripcionBarco.setText("");
		taDescription.setText("");
		tfComments.setText("");

		btnBook2.setEnabled(false);
		chckbxLong.setSelected(false);
		chckbxShort.setSelected(false);
		chckbxKids.setSelected(false);
		
		resetPn2();
		btnBook3.setEnabled(false);
		btnRemoveCabin.setEnabled(false);
		btnEditCabin.setEnabled(false);
		cbZonas.setSelectedIndex(-1);
		resetBooking();
		
		btnSubmit.setEnabled(false);
		database = new Database();

		
		

	}
	

	private void setResumeData() {
		// SETS THE RESUME DATA
		lblDatosCliente.setText("NOMBRE: " + booking.getPerson().getName() + " " + booking.getPerson().getSurname()
				+ " NIF: " + booking.getPerson().getDNI() + " PHONE: " + booking.getPerson().getPhone());
		lblDataCrucero.setText(
				"Crucero: " + booking.getCruise().getDenominacion() + " / " + booking.getCruise().getCruiseCode());
		lblDataBarco.setText("Barco: " + booking.getBoat().getName());
		lblDataFechaDeSalida.setText("Fecha de Salida: " + booking.getDate());
		lblDataDias.setText("Días: " + booking.getCruise().getDuracion());
		lblDataSalida.setText("Salida: " + booking.getCruise().getStartingPoint());
		lblDataNumeroPasajeros.setText("Número de pasajeros: " + booking.getNumeroPasajeros());
		String camarotes = "";
		for (Cabin each : booking.getCabins())
			camarotes += each.toString2();
		taDataCamarotes.setText("Camarotes: " + camarotes);
		taDataCamarotes.setCaretPosition(0);
		lblDataPrecioCamarotes.setText("Camarotes: " + booking.calcularPrecioCamarotes() + "€");
		lblDataPrecioExtras.setText("Extras: " + booking.calcularPrecioExtras() + "€");
		if (booking.getIsOferta())
			lblDataDescuento.setText("Descuento Oferta: " + booking.calcularDescuento());
		if (booking.isTrip())
			lblExcursion.setText("Excursion "+booking.getTripName()+":"+ booking.calculaPrecioTrip()+ "€");

		lblDataImporteTotal.setText("Importe total: " + booking.calcularPrecioFinal());

	}

	private void cleanResumeData() {
		// SETS THE RESUME DATA
		lblDatosCliente.setText("");
		lblDataBarco.setText("");
		lblDataFechaDeSalida.setText("");
		lblDataDias.setText("");
		lblDataSalida.setText("");
		lblDataNumeroPasajeros.setText("");
		taDataCamarotes.setText("");
		lblDataPrecioCamarotes.setText("");
		lblDataPrecioExtras.setText("");
		lblDataDescuento.setText("");
		lblDataImporteTotal.setText("");
		lblExcursion.setText("");

	}

	private void adaptarImagenLabel(JLabel label, String rutaImagen) {
		Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance((int) (label.getWidth()), (int) (label.getHeight()),
				Image.SCALE_FAST);
		label.setIcon(new ImageIcon(imgEscalada));
	}

	private void adaptarImagenButton(JButton button, String rutaImagen) {
		Image imgOriginal = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance((int) (button.getWidth()), (int) (button.getHeight()),
				Image.SCALE_FAST);
		button.setIcon(new ImageIcon(imgEscalada));
	}

	// **************************************************CARD LAYOUT
	// MANAGEMENT***************************************//

	private void mostrarPaso(boolean paso1, boolean paso2, boolean paso3, boolean paso4, boolean paso5, boolean paso6) {
		lblPaso1.setEnabled(paso1);
		lblPaso2.setEnabled(paso2);
		lblPaso3.setEnabled(paso3);
		lblPaso4.setEnabled(paso4);
		lblPaso5.setEnabled(paso5);
		lblPaso6.setEnabled(paso6);

	}

	private JPanel getPnCenter() {
		if (pnCenter == null) {
			pnCenter = new JPanel();
			pnCenter.setBackground(Color.WHITE);
			pnCenter.setLayout(new CardLayout(0, 0));
			pnCenter.add(getPn1(), "panel1");
			pnCenter.add(getPn2(), "panel2");
			pnCenter.add(getPn3(), "panel3");
			pnCenter.add(getPn4(), "panel4");
			pnCenter.add(getPn5(), "panel5");
		}
		return pnCenter;
	}

	private JButton getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new JButton("Submit");
			btnSubmit.setEnabled(false);
			btnSubmit.setToolTipText("Selecciona un destino");
			btnSubmit.setMnemonic('s');
			btnSubmit.setFont(new Font("Garamond", Font.PLAIN, 16));
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPaso(false, true, false, false, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel2");

					modeloTabla.getDataVector().clear();
					modeloTabla.fireTableDataChanged();
					String selectedArea = (String) cbZonas.getSelectedItem();
					for (Cruise each : database.getCruiseList()){
						if(each.getArea().equals(selectedArea))
						{
							setNuevaFila(each);

						}
							
					}
				}
			});
		}
		return btnSubmit;
	}

	private JButton getBtnBook2() {
		if (btnBook2 == null) {
			btnBook2 = new JButton("Submit");
			btnBook2.setToolTipText("Confirma el crucero seleccionado");
			btnBook2.setMnemonic('s');
			btnBook2.setFont(new Font("Garamond", Font.PLAIN, 16));
			btnBook2.setEnabled(false);
			btnBook2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPaso(false, false, true, false, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel3");
				
					List<String> date = new ArrayList<String>();
					for (String each : selectedCruise.getDates())
						date.add(each);
					modelDatesCb = new DefaultComboBoxModel(date.toArray());
					cbSelectDate.setModel(modelDatesCb);

				}
			});
		}
		return btnBook2;
	}
	private JComboBox<?> getCbCabins() {
		if (cbCabins == null) {
			cbCabins = new JComboBox();
			
			cbCabins.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					Boat currentBoat = database.getBoat(selectedCruise.getBarcoCodigo());
					cbCabins.setModel(new DefaultComboBoxModel (currentBoat.getAvailableCabins()));
					setTagsProperly();

				}
			});
			cbCabins.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setTagsProperly();
					modeloListaExtrasSeleccionados.clear();
					modeloListaExtras.clear();
					cargarExtras();
					
					
				}
			});
		}
		return cbCabins;
	}
	private void setTagsProperly(){
		if(cbCabins.getSelectedItem() != null  ){
			String selected = (String) cbCabins.getSelectedItem().toString().toLowerCase();
			if(selected.contains("doble")){  
				deshabilitarDosPasajeros();
				chckbxPassenger_1.setEnabled(true);
				chckbxPassenger_1.setSelected(false);
				textField_1.setText("");
				label_1.setEnabled(true);
				
				chckbxPassenger_2.setEnabled(true);
				chckbxPassenger_2.setSelected(false);
				textField_2.setText("");
				label_2.setEnabled(true);
				
				chckbxPassenger_extra.setEnabled(false);
				chckbxPassenger_extra.setSelected(false);
				textField_extra.setText("");
				label_extra.setEnabled(false);

				
			}
			else 	habilitarPasajeros();	
			
			actualizarLabelCamarotesDisponibles();
		}	
	}

	private void actualizarLabelCamarotesDisponibles()
	{
		Boat selectedBoat = database.getBoat(selectedCruise.getBarcoCodigo());
		if(getIsFamiliar() && getIsOutside())
			lblAvailableCabins.setText(String.valueOf(selectedBoat.getFamiliarExterior()));
		else if(!getIsFamiliar() && getIsOutside())
			lblAvailableCabins.setText(String.valueOf(selectedBoat.getDobleExterior()));
		else if(getIsFamiliar() && !getIsOutside())
			lblAvailableCabins.setText(String.valueOf(selectedBoat.getFamiliarInterior()));
		else if(!getIsFamiliar() && !getIsOutside())
			lblAvailableCabins.setText(String.valueOf(selectedBoat.getDobleInterior()));
		
	}
	
	private void deshabilitarDosPasajeros()
	{
		
		chckbxPassenger_3.setEnabled(false);
		chckbxPassenger_4.setEnabled(false);
		chckbxPassenger_3.setSelected(false);
		chckbxPassenger_4.setSelected(false);

		label_3.setEnabled(false);
		label_4.setEnabled(false);
		textField_3.setText("");
		textField_4.setText("");
		
		chckbxPassenger_extra.setEnabled(false);
		chckbxPassenger_extra.setSelected(false);
		textField_extra.setText("");
		label_extra.setEnabled(false);
		
	}
	private void habilitarPasajeros()
	{
		label_1.setEnabled(true);
		label_2.setEnabled(true);
		label_3.setEnabled(true);
		label_4.setEnabled(true);
		chckbxPassenger_1.setEnabled(true);
		chckbxPassenger_2.setEnabled(true);
		chckbxPassenger_3.setEnabled(true);
		chckbxPassenger_4.setEnabled(true);
		chckbxPassenger_1.setSelected(false);
		chckbxPassenger_2.setSelected(false);
		chckbxPassenger_3.setSelected(false);
		chckbxPassenger_4.setSelected(false);

		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");


		
	}

	private JButton getBtnBack2() {
		if (btnBack2 == null) {
			btnBack2 = new JButton("Back");
			btnBack2.setToolTipText("Return to the previous page");
			btnBack2.setMnemonic('b');
			btnBack2.setFont(new Font("Garamond", Font.PLAIN, 16));
			btnBack2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPaso(true, false, false, false, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel1");
					resetPn2();
					disableComponentesPn2();
					lblFotoBarco.setIcon(null);
					lblFotoCruise.setIcon(null);
				}
			});
		}
		return btnBack2;
	}
	
	private void resetPn2()
	{
		
		lblFotoBarco.setIcon(null);
		lblFotoCruise.setIcon(null);
		taDescripcionBarco.setText("");
		taDescription.setText("");
		lblDenominacion.setText("");
		chckbxKids.setSelected(false);
		chckbxLong.setSelected(false);
		chckbxShort.setSelected(false);
		chckbxTrip.setSelected(false);


		addRowsCruises(false,false,false, false);
		
	}
	// ***************************************CARD LAYOUT
	// MANAGEMENT***************************************//

	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.setBackground(Color.WHITE);
			pnNorte.setLayout(new GridLayout(0, 6, 0, 0));
			pnNorte.add(getLblPaso1());
			pnNorte.add(getLblPaso2());
			pnNorte.add(getLblPaso3());
			pnNorte.add(getLblPaso4());
			pnNorte.add(getLblPaso5());
			pnNorte.add(getLblPaso6());
		}
		return pnNorte;
	}

	private JLabel getLblPaso1() {
		if (lblPaso1 == null) {
			lblPaso1 = new JLabel("1");
			lblPaso1.setForeground(Color.RED);
			lblPaso1.setFont(new Font("Britannic Bold", Font.BOLD, 22));
			lblPaso1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPaso1;
	}

	private JLabel getLblPaso2() {
		if (lblPaso2 == null) {
			lblPaso2 = new JLabel("2");
			lblPaso2.setForeground(Color.RED);
			lblPaso2.setFont(new Font("Britannic Bold", Font.BOLD, 22));
			lblPaso2.setEnabled(false);
			lblPaso2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPaso2;
	}

	private JLabel getLblPaso3() {
		if (lblPaso3 == null) {
			lblPaso3 = new JLabel("3");
			lblPaso3.setForeground(Color.RED);
			lblPaso3.setFont(new Font("Britannic Bold", Font.BOLD, 22));
			lblPaso3.setEnabled(false);
			lblPaso3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPaso3;
	}

	private JLabel getLblPaso4() {
		if (lblPaso4 == null) {
			lblPaso4 = new JLabel("4");
			lblPaso4.setForeground(Color.RED);
			lblPaso4.setFont(new Font("Britannic Bold", Font.BOLD, 22));
			lblPaso4.setEnabled(false);
			lblPaso4.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPaso4;
	}

	private JLabel getLblPaso5() {
		if (lblPaso5 == null) {
			lblPaso5 = new JLabel("5");
			lblPaso5.setForeground(Color.RED);
			lblPaso5.setFont(new Font("Britannic Bold", Font.BOLD, 22));
			lblPaso5.setEnabled(false);
			lblPaso5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPaso5;
	}

	private JLabel getLblPaso6() {
		if (lblPaso6 == null) {
			lblPaso6 = new JLabel("6");
			lblPaso6.setForeground(Color.RED);
			lblPaso6.setFont(new Font("Britannic Bold", Font.BOLD, 22));
			lblPaso6.setEnabled(false);
			lblPaso6.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPaso6;
	}

	// **************************************************PANEL_1***************************************//

	private JPanel getPn1() {
		if (pn1 == null) {
			pn1 = new JPanel();
			pn1.setBackground(Color.WHITE);
			pn1.setLayout(new BorderLayout(0, 0));
			pn1.add(getLblWelcome(), BorderLayout.NORTH);
			pn1.add(getPnSouth1(), BorderLayout.SOUTH);
			pn1.add(getPnDiscounts(), BorderLayout.CENTER);
		}
		return pn1;
	}

	private JPanel getPnSouth1() {
		if (pnSouth1 == null) {
			pnSouth1 = new JPanel();
			pnSouth1.setBackground(Color.WHITE);
			pnSouth1.setLayout(new BorderLayout(0, 0));
			pnSouth1.add(getLblDestiny(), BorderLayout.NORTH);
			pnSouth1.add(getPnBotones1(), BorderLayout.SOUTH);
		}
		return pnSouth1;
	}

	private JPanel getPnBotones1() {
		if (pnBotones1 == null) {
			pnBotones1 = new JPanel();
			pnBotones1.setBackground(Color.WHITE);
			pnBotones1.add(getCbZonas());
			pnBotones1.add(getBtnSubmit());
		}
		return pnBotones1;
	}

	private JLabel getLblDestiny() {
		if (lblDestiny == null) {
			lblDestiny = new JLabel("Destiny:");
			lblDestiny.setLabelFor(getCbZonas());
			lblDestiny.setDisplayedMnemonic('d');
			lblDestiny.setBackground(Color.WHITE);
			lblDestiny.setFont(new Font("Britannic Bold", Font.PLAIN, 19));
			lblDestiny.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblDestiny;
	}

	private JComboBox<?> getCbZonas() {
		if (cbZonas == null) {
			cbZonas = new JComboBox<Object>();
			cbZonas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(cbZonas.getSelectedIndex()!= -1)
						btnSubmit.setEnabled(true);
				}
			});
			cbZonas.setFont(new Font("Garamond", Font.BOLD, 16));
			cbZonas.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					Cruise cruises[] = database.getCruises();
					ArrayList<String> area = new ArrayList<String>();
					for (Cruise each : cruises){
						if(!area.contains(each.getArea()))
							area.add(each.getArea());
					}

					cbZonas.setModel(new DefaultComboBoxModel(area.toArray(new String[area.size()])));
					btnSubmit.setEnabled(true);
				}
			});
			
		}
		return cbZonas;
	}

	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("Welcome");
			lblWelcome.setBackground(Color.WHITE);
			lblWelcome.setFont(new Font("Britannic Bold", Font.PLAIN, 46));
			lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblWelcome;
	}

	private JLabel getLblOferta() {
		if (lblOferta == null) {
			lblOferta = new JLabel("");
			lblOferta.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					adaptarImagenLabel(lblOferta, "/img/Discount.jpg");
				}
			});
		}
		return lblOferta;
	}

	private JPanel getPnDiscounts() {
		if (pnDiscounts == null) {
			pnDiscounts = new JPanel();
			pnDiscounts.setLayout(new GridLayout(0, 3, 0, 0));
			calculateDiscountIndexes();
			pnDiscounts.add(getBtnDiscount1());
			pnDiscounts.add(getLblOferta());
			pnDiscounts.add(getBtnDiscount2());
			pnDiscounts.add(getSpDiscount1());
			pnDiscounts.add(getPnAuxWelcome());
			pnDiscounts.add(getScrollPane_1());
		}
		return pnDiscounts;
	}
	private void resetDiscounts()
	{
		
	}

	/**
	 * Calculates the random number that will be used as index to get the Code
	 * and area of the cruises that will be offered with 15%.
	 *
	 * Upgrades the discount1 and discount2 fields.
	 */
	private void calculateDiscountIndexes() {

		ArrayList<Cruise> cruises = (ArrayList<Cruise>) database.getCruiseList();
		int index1 = (int) (Math.random() * cruises.size());
		int index2 = (int) (Math.random() * cruises.size());
		while (index1 == index2) {
			index1 = (int) (Math.random() * cruises.size());
		}
		discount1 = cruises.get(index1).getCruiseCode();
		discount2 = cruises.get(index2).getCruiseCode();
		cruiseOferta1 = cruises.get(index1);
		cruiseOferta2 = cruises.get(index2);

	}

	private JButton getBtnDiscount1() {
		if (btnDiscount1 == null) {
			btnDiscount1 = new JButton("");
			btnDiscount1.setToolTipText("Choose this discount cruise!");
			btnDiscount1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPaso(false, true, false, false, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel2");

					modeloTabla.getDataVector().clear();
					modeloTabla.fireTableDataChanged();
					setNuevaFila(cruiseOferta1);
					
					tCruises.setRowSelectionInterval(0, 0);
					setInformationAboutCruise();
					fixBugResizing();
					
					
					enableBtnBook2();
					tCruises.setSelectionBackground(Color.YELLOW);

				}
			});
			btnDiscount1.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					adaptarImagenButton(btnDiscount1, "/img/" + getDiscount1() + ".jpg");
				}
			});
		}
		return btnDiscount1;
	}

	
	private JButton getBtnDiscount2() {
		if (btnDiscount2 == null) {
			btnDiscount2 = new JButton("");
			btnDiscount2.setToolTipText("Choose this discount cruise!");
			btnDiscount2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPaso(false, true, false, false, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel2");

					modeloTabla.getDataVector().clear();
					modeloTabla.fireTableDataChanged();
					setNuevaFila(cruiseOferta2);
					
					tCruises.setRowSelectionInterval(0, 0);
					setInformationAboutCruise();
					fixBugResizing();

					enableBtnBook2();
					tCruises.setSelectionBackground(Color.YELLOW);

				}
			});
			btnDiscount2.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					adaptarImagenButton(btnDiscount2, "/img/" + getDiscount2() + ".jpg");
				}
			});
		}
		return btnDiscount2;
	}
	private void fixBugResizing()
	{
		lblFotoBarco.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				
				int fila = tCruises.getSelectedRow();
				if(tCruises.getSelectedRow() != -1){
					String startPoint = (String) tCruises.getValueAt(fila, 2);
					
					String ccode = database.getCruiseCode(startPoint);
					String bcode = database.getCruise(ccode).getBarcoCodigo();
					adaptarImagenLabel(lblFotoBarco, "/img/" + bcode + ".jpg");
					adaptarImagenLabel(lblFotoCruise, "/img/" + ccode + ".jpg");
				}
				

			}
		});
	}

	private String getDiscount1() {
		return discount1;
	}

	private String getDiscount2() {
		return discount2;
	}
	private JScrollPane getSpDiscount1() {
		if (spDiscount1 == null) {
			spDiscount1 = new JScrollPane();
			spDiscount1.setViewportView(getTaDiscount1());
		}
		return spDiscount1;
	}
	private JPanel getPnAuxWelcome() {
		if (pnAuxWelcome == null) {
			pnAuxWelcome = new JPanel();
			pnAuxWelcome.setBackground(Color.WHITE);
			pnAuxWelcome.add(getTaDiscountDescription());
		}
		return pnAuxWelcome;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTaDiscount2());
		}
		return scrollPane_1;
	}
	private JTextArea getTaDiscount1() {
		if (taDiscount1 == null) {
			taDiscount1 = new JTextArea();
			taDiscount1.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
			taDiscount1.setWrapStyleWord(true);
			taDiscount1.setLineWrap(true);
			taDiscount1.setText(cruiseOferta1.getDenominacion() + "\n\n" + cruiseOferta1.getDescription() + "\n\nThe Itinerary is: " + cruiseOferta1.getItinerary());
			taDiscount1.setCaretPosition(0);
		}
		return taDiscount1;
	}
	private JTextArea getTaDiscount2() {
		if (taDiscount2 == null) {
			taDiscount2 = new JTextArea();
			taDiscount2.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
			taDiscount2.setLineWrap(true);
			taDiscount2.setWrapStyleWord(true);
			taDiscount2.setText(cruiseOferta2.getDenominacion() + "\n\n" +cruiseOferta2.getDescription() + "\n\nThe Itinerary is: " + cruiseOferta2.getItinerary());
			taDiscount2.setCaretPosition(0);

		}
		return taDiscount2;
	}

	// **************************************************PANEL_2***************************************//

	private JPanel getPn2() {
		if (pn2 == null) {
			pn2 = new JPanel();
			pn2.setBackground(Color.WHITE);
			pn2.setLayout(new BorderLayout(0, 0));
			pn2.add(getLblCruiseList(), BorderLayout.NORTH);
			pn2.add(getPnBotones2(), BorderLayout.SOUTH);
			pn2.add(getPnBase2(), BorderLayout.CENTER);
		}
		return pn2;
	}

	private JLabel getLblCruiseList() {
		if (lblCruiseList == null) {
			lblCruiseList = new JLabel("CruiseList");
			lblCruiseList.setToolTipText("");
			lblCruiseList.setFont(new Font("Britannic Bold", Font.BOLD, 46));
			lblCruiseList.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCruiseList;
	}

	private JPanel getPnBotones2() {
		if (pnBotones2 == null) {
			pnBotones2 = new JPanel();
			pnBotones2.setBackground(Color.WHITE);
			FlowLayout fl_pnBotones2 = (FlowLayout) pnBotones2.getLayout();
			fl_pnBotones2.setAlignment(FlowLayout.RIGHT);
			pnBotones2.add(getBtnBack2());
			pnBotones2.add(getBtnBook2());
		}
		return pnBotones2;
	}

	private JPanel getPnBase2() {
		if (pnBase2 == null) {
			pnBase2 = new JPanel();
			pnBase2.setBackground(Color.WHITE);
			pnBase2.setLayout(new BorderLayout(0, 0));
			pnBase2.add(getPnTabla(), BorderLayout.CENTER);
			pnBase2.add(getSpDescripcion(), BorderLayout.SOUTH);
		}
		return pnBase2;
	}

	private JTextArea getTaDescription() {
		if (taDescription == null) {
			taDescription = new JTextArea();
			taDescription.setWrapStyleWord(true);
			taDescription.setLineWrap(true);
			taDescription.setFont(new Font("Calibri Light", Font.BOLD, 20));
			taDescription.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			taDescription.setToolTipText("Description of the cruise");
			taDescription.setEditable(false);
			taDescription.setRows(5);
			taDescription.setCaretPosition(0);
		}
		return taDescription;
	}

	private JPanel getPnTabla() {
		if (pnTabla == null) {
			pnTabla = new JPanel();
			pnTabla.setBackground(Color.WHITE);
			pnTabla.setLayout(new BorderLayout(0, 0));
			pnTabla.add(getPnFiltro(), BorderLayout.NORTH);
			pnTabla.add(getPnFotoFondo(), BorderLayout.EAST);
			pnTabla.add(getPnFotos(), BorderLayout.CENTER);
			pnTabla.add(getPnTabla2(), BorderLayout.WEST);
		}
		return pnTabla;
	}

	private JScrollPane getScCruises() {
		if (scCruises == null) {
			scCruises = new JScrollPane();
			scCruises.setFont(new Font("Calibri Light", Font.BOLD, 14));
			scCruises.setBackground(Color.WHITE);
			scCruises.setViewportView(getTCruises());
		}
		return scCruises;
	}

	private JPanel getPnFiltro() {
		if (pnFiltro == null) {
			pnFiltro = new JPanel();
			pnFiltro.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnFiltro.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnFiltro.add(getChckbxKids());
			pnFiltro.add(getChckbxShort());
			pnFiltro.add(getChckbxLong());
			pnFiltro.add(getChckbxTrip());
		}
		return pnFiltro;
	}

	// *************************************CREATES THE
	// TABLE*************************************//
	private JTable getTCruises() {
		if (tCruises == null) {
			String[] nombreColumnas = { "Area", "Kids", "Start", "Duration","Discount","Trip" };
			modeloTabla = new ModeloNoEditable(nombreColumnas, 0);
			tCruises = new JTable(modeloTabla);
			tCruises.setGridColor(Color.WHITE);
			tCruises.setFont(new Font("Calibri Light", Font.BOLD, 16));
			tCruises.setBackground(Color.WHITE);
			tCruises.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					lblFotoBarco.addComponentListener(new ComponentAdapter() {
						@Override
						public void componentResized(ComponentEvent e) {
							int fila = tCruises.getSelectedRow();
							if(fila != -1){
								String startPoint = (String) tCruises.getValueAt(fila, 2);
								String ccode = database.getCruiseCode(startPoint);
								String bcode = database.getCruise(ccode).getBarcoCodigo();
								adaptarImagenLabel(lblFotoBarco, "/img/" + bcode + ".jpg");
								adaptarImagenLabel(lblFotoCruise, "/img/" + ccode + ".jpg");
							}

						}
					});
					
					//nuevo
					setInformationAboutCruise();
					enableBtnBook2();
					tCruises.setSelectionBackground(Color.YELLOW);
//					if (arg0.getClickCount() == 2) {
//						JOptionPane.showMessageDialog(null, tCruises.getValueAt(tCruises.getSelectedRow(), 3));}		
				}
			});
		}
		return tCruises;
	}
	private void setInformationAboutCruise() {
		//Set image of the boat
		int fila = tCruises.getSelectedRow();
		String startPoint = (String) tCruises.getValueAt(fila, 2);
		String ccode = database.getCruiseCode(startPoint);
		String bcode = database.getCruise(ccode).getBarcoCodigo();
		adaptarImagenLabel(lblFotoBarco, "/img/" + bcode + ".jpg");
		adaptarImagenLabel(lblFotoCruise, "/img/" + ccode + ".jpg");

		//Set text information
		Boat boat = database.getBoat(bcode);
		taDescripcionBarco.setText(boat.getName() + ": " + boat.getDescription());		
		taDescription.setText(database.getCruise(ccode).getDescription()
				+ "\nThe Itinerary is: " + database.getCruise(ccode).getItinerary()
				+ setTripInfo(ccode));
		taDescripcionBarco.setCaretPosition(0);
		taDescription.setCaretPosition(0);
		
		lblDenominacion.setText(database.getCruise(ccode).getDenominacion());


	}
	
	private String setTripInfo(String ccode)
	{
		String aux = "";
		if (database.isTripGivenCruiseCode(ccode))
		{
			for(Excursiones each : database.getTripGivenCruiseCode(ccode) ){
				aux+="\nThis cruise offer the trip: "+ each.getDescription();
				aux+=" over the city of "+each.getCity();
				aux+=" with a price of "+ each.getPrice() + "€ per person.";
			}
		}
		return aux;
	}
	private void enableBtnBook2() {
		int fila = tCruises.getSelectedRow();
		String startPoint = (String) tCruises.getValueAt(fila, 2);
		selectedCruiseCode = database.getCruiseCode(startPoint);
	    selectedCruise = database.getCruise(selectedCruiseCode);

	    lblDenominacion.setText(selectedCruise.getDenominacion());
		btnBook2.setEnabled(true);		
	}

	/**
	 * 
	 * */
	private void addRowsCruises(boolean kids, boolean Short, boolean Long, boolean Trip) {
		if(!kids && !Short && !Long && !Trip)
		{//Si todas desmarcadas ponemos todos los cruceros
			for (Cruise each : database.getCruises()) 
				setNuevaFila(each);
		}
		else
		{
			for (Cruise each : database.getCruises()) {
				if ((kids && each.isAptoMenores())
						|| (Short && each.getDuracion()<7)
						|| (Long && each.getDuracion()>=7)
						|| (Trip && database.isTripGivenCruiseCode(each.getCruiseCode()))) {
					setNuevaFila(each);

				}
			}
		}
		
	}


	private void setNuevaFila(Cruise barco) {
		Object[] nuevaFila = new Object[6];

		nuevaFila[0] = barco.getArea();
		//nuevaFila[1] = database.getBoatName(barco.getBarcoCodigo());
		String isAptoMenores = "no";
		if(barco.isAptoMenores())isAptoMenores = "si";
		nuevaFila[1] = isAptoMenores;
		nuevaFila[2] = barco.getStartingPoint();
		nuevaFila[3] = barco.getDuracion();
		if(barco.getCruiseCode().equals(cruiseOferta1.getCruiseCode()) || barco.getCruiseCode().equals(cruiseOferta2.getCruiseCode()))
			nuevaFila[4] = "si";
		else
			nuevaFila[4] = "no";
		
		if(database.isTripGivenCruiseCode(barco.getCruiseCode()))
			nuevaFila[5] = "si";
		else
			nuevaFila[5] = "no";

				

		modeloTabla.addRow(nuevaFila);		
	}

	private void mostrarCruisesZona() {
		modeloTabla.getDataVector().clear();
		modeloTabla.fireTableDataChanged();

		addRowsCruises(chckbxKids.isSelected(), chckbxShort.isSelected(), chckbxLong.isSelected(), chckbxTrip.isSelected());
	}

	private JCheckBox getChckbxTrip() {
		if (chckbxTrip == null) {
			chckbxTrip = new JCheckBox("Trip");
			chckbxTrip.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
			chckbxTrip.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarCruisesZona();
					disableComponentesPn2();
				}
			});
		}
		return chckbxTrip;
	}
	private JCheckBox getChckbxKids() {
		if (chckbxKids == null) {
			chckbxKids = new JCheckBox("Kids");
			chckbxKids.setToolTipText("Filter the cruises that allows kids");
			chckbxKids.setMnemonic('k');
			chckbxKids.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
			chckbxKids.setBackground(Color.WHITE);
			chckbxKids.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarCruisesZona();
					disableComponentesPn2();
				}
			});

		}
		return chckbxKids;
	}

	private JCheckBox getChckbxShort() {
		if (chckbxShort == null) {
			chckbxShort = new JCheckBox("Short");
			
			chckbxShort.setToolTipText("Filter the cruises of less than 7 days");
			chckbxShort.setMnemonic('r');
			chckbxShort.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
			chckbxShort.setBackground(Color.WHITE);
			chckbxShort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarCruisesZona();
					disableComponentesPn2();
				}
			});


		}
		return chckbxShort;
	}

	private JCheckBox getChckbxLong() {
		if (chckbxLong == null) {
			chckbxLong = new JCheckBox("Long");
			chckbxLong.setToolTipText("Filter the cruises of more than 7 days");
			chckbxLong.setMnemonic('l');
			chckbxLong.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
			chckbxLong.setBackground(Color.WHITE);
			chckbxLong.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarCruisesZona();
					disableComponentesPn2();
				}
			});

		}

		return chckbxLong;
	}
	private void disableComponentesPn2()
	{
		lblFotoBarco.setIcon(null);
		lblFotoCruise.setIcon(null);
		taDescripcionBarco.setText("");
		taDescription.setText("");
		lblDenominacion.setText("");
		btnBook2.setEnabled(false);
	}

	private JPanel getPnFotoFondo() {
		if (pnFotoFondo == null) {
			pnFotoFondo = new JPanel();
			pnFotoFondo.setBackground(Color.WHITE);
			pnFotoFondo.setLayout(new BorderLayout(0, 0));
			pnFotoFondo.add(getPnReserva2());
		}
		return pnFotoFondo;
	}

	private JPanel getPnReserva2() {
		if (pnReserva2 == null) {
			pnReserva2 = new JPanel();
			pnReserva2.setBackground(Color.WHITE);
			pnReserva2.setLayout(new BorderLayout(0, 0));
			pnReserva2.add(getLblFotoRelleno2(), BorderLayout.CENTER);
			pnReserva2.add(getLblNewLabel_3(), BorderLayout.NORTH);
		}
		return pnReserva2;
	}

	private JLabel getLblFotoRelleno2() {
		if (lblFotoRelleno2 == null) {
			lblFotoRelleno2 = new JLabel("");

			lblFotoRelleno2.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					adaptarImagenLabel(lblFotoRelleno2, "/img/Fondo.jpg");
				}
			});

		}
		return lblFotoRelleno2;
	}

	// **************************************************PANEL_3***************************************//
	private JButton getBtnBook3() {
		if (btnBook3 == null) {
			btnBook3 = new JButton("Submit");
			btnBook3.setEnabled(false);
			btnBook3.setToolTipText("Confirm the selected cabins");
			btnBook3.setMnemonic('s');
			btnBook3.setFont(new Font("Garamond", Font.PLAIN, 16));
			btnBook3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPaso(false, false, false, true, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel4");

					// booooooooooooooooooookkkkkkkiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiinggggggggggggggggggggggggggggggggggggggggggggg
					
					Boolean isOferta = false;
					if (selectedCruise.getCruiseCode().equals(cruiseOferta1.getCruiseCode())
							|| selectedCruise.getCruiseCode().equals(cruiseOferta2.getCruiseCode()))
						isOferta = true;
					
					Boolean isTrip = false;
					String tripName = "";
					if(comboBox.getSelectedIndex() !=-1){
						isTrip = true;
						tripName = comboBox.getSelectedItem().toString();
					}
					

					booking = new Booking(selectedCruise, bookedCabins, null, null, isOferta,isTrip,tripName);

					// Initializing the dates combobox
					List<String> date = new ArrayList<String>();
					for (String each : booking.getCruise().getDates())
						date.add(each);
					//model = new DefaultComboBoxModel(date.toArray());

					txDate.setText(cbSelectDate.getSelectedItem().toString());

				}
			});
		}
		return btnBook3;
	}

	private JPanel getPn3() {
		if (pn3 == null) {
			pn3 = new JPanel();
			pn3.setBackground(Color.WHITE);
			pn3.setLayout(new BorderLayout(0, 0));
			pn3.add(getLblCustomizeYourTrip(), BorderLayout.NORTH);
			pn3.add(getPnSouth3(), BorderLayout.SOUTH);
			pn3.add(getPnBase3(), BorderLayout.CENTER);
		}
		return pn3;
	}

	private JLabel getLblCustomizeYourTrip() {
		if (lblCustomizeYourTrip == null) {
			lblCustomizeYourTrip = new JLabel("Customize your trip");
			lblCustomizeYourTrip.setFont(new Font("Britannic Bold", Font.BOLD, 46));
			lblCustomizeYourTrip.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblCustomizeYourTrip;
	}

	private JPanel getPnSouth3() {
		if (pnSouth3 == null) {
			pnSouth3 = new JPanel();
			pnSouth3.setBackground(Color.WHITE);
			pnSouth3.setLayout(new BorderLayout(0, 0));
			pnSouth3.add(getPnBotones3(), BorderLayout.SOUTH);
		}
		return pnSouth3;
	}

	private JButton getBtBack3() {
		if (btBack3 == null) {
			btBack3 = new JButton("Back");
			btBack3.setToolTipText("Back to previous window");
			btBack3.setMnemonic('b');
			btBack3.setFont(new Font("Garamond", Font.PLAIN, 16));
			btBack3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPaso(false, true, false, false, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel2");
					resetBooking();
					
				}
			});
			btBack3.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return btBack3;
	}
	private void resetBooking()
	{
		bookedCabins.clear();
		clearScreenPn3();
		modeloListaResumen.clear();
		database = new Database();
		btnBook3.setEnabled(false);

	}
	

	private JPanel getPnBotones3() {
		if (pnBotones3 == null) {
			pnBotones3 = new JPanel();
			pnBotones3.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnBotones3.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones3.add(getBtBack3());
			pnBotones3.add(getBtnBook3());
		}
		return pnBotones3;
	}
	private JPanel getPnBase3() {
		if (pnBase3 == null) {
			pnBase3 = new JPanel();
			pnBase3.setLayout(new BorderLayout(0, 0));
			pnBase3.add(getPnDatos(), BorderLayout.CENTER);
			pnBase3.add(getPnResumen(), BorderLayout.EAST);
		}
		return pnBase3;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setLayout(new BorderLayout(0, 0));
			pnDatos.add(getPnCabinType(), BorderLayout.NORTH);
			pnDatos.add(getPnPassengers(), BorderLayout.CENTER);
			pnDatos.add(getPnDates(), BorderLayout.SOUTH);
		}
		return pnDatos;
	}
	private JPanel getPnResumen() {
		if (pnResumen == null) {
			pnResumen = new JPanel();
			pnResumen.setBorder(null);
			pnResumen.setBackground(Color.WHITE);
			pnResumen.setLayout(new BorderLayout(0, 0));
			pnResumen.add(getPnResumenAux());
			pnResumen.add(getPnResumenButtons(), BorderLayout.SOUTH);
			pnResumen.add(getLblResumen(), BorderLayout.NORTH);
		}
		return pnResumen;
	}
	private JPanel getPnResumenAux() {
		if (pnResumenAux == null) {
			pnResumenAux = new JPanel();
			pnResumenAux.setBackground(Color.WHITE);
			pnResumenAux.setForeground(Color.WHITE);
			pnResumenAux.setLayout(new GridLayout(0, 1, 0, 0));
			pnResumenAux.add(getSpResumen());
		}
		return pnResumenAux;
	}
	private JPanel getPnResumenButtons() {
		if (pnResumenButtons == null) {
			pnResumenButtons = new JPanel();
			pnResumenButtons.setLayout(new GridLayout(2, 0, 0, 0));
			pnResumenButtons.add(getPnResumenButton2());
			pnResumenButtons.add(getPnResumenButton1());
		}
		return pnResumenButtons;
	}
	private JPanel getPnResumenButton1() {
		if (pnResumenButton1 == null) {
			pnResumenButton1 = new JPanel();
			pnResumenButton1.setBackground(Color.WHITE);
			pnResumenButton1.add(getBtnEditCabin());
			pnResumenButton1.add(getBtnSaveChanges());
			pnResumenButton1.add(getBtnCancel());
		}
		return pnResumenButton1;
	}
	private JPanel getPnResumenButton2() {
		if (pnResumenButton2 == null) {
			pnResumenButton2 = new JPanel();
			pnResumenButton2.setBackground(Color.WHITE);
			pnResumenButton2.add(getBtnAddCabin());
			pnResumenButton2.add(getBtnRemoveCabin());
		}
		return pnResumenButton2;
	}
	private JButton getBtnAddCabin() {
		if (btnAddCabin == null) {
			btnAddCabin = new JButton("Add Cabin");
			btnAddCabin.setMnemonic('a');
			btnAddCabin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(checkConstraints()){
						createNewCabin();
						if(!bookedCabins.isEmpty()){
							btnBook3.setEnabled(true);
							
						}
						clearScreenPn3();
						lblAvailableCabins.setText("");

					}
					else
						JOptionPane.showMessageDialog(null, "Revisa los datos introducidos","Warning",JOptionPane.WARNING_MESSAGE);
						
					
				}
			});
			btnAddCabin.setEnabled(false);
		}
		return btnAddCabin;
	}
	
	public Boolean checkConstraints()
	{
		mayorDeEdad = new ArrayList<Boolean>();
		if(textField_1.isEnabled() && !correctAge(textField_1.getText()))
			return false;
		if(textField_2.isEnabled() && !correctAge(textField_2.getText()))
			return false;
		if(textField_3.isEnabled() && !correctAge(textField_3.getText()))
			return false;
		if(textField_4.isEnabled() && !correctAge(textField_4.getText()))
			return false;
		if(!mayorDeEdad.contains(true)){
			JOptionPane.showMessageDialog(null, "Debe haber un mayor de edad para poder reservar","Warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(textField_extra.isEnabled() && !correctAge(textField_extra.getText()))
			return false;
		if(textField_extra.isEnabled() && Integer.parseInt(textField_extra.getText()) >=16)
		{
			JOptionPane.showMessageDialog(null, "La cama extra solo la pueden usar niños de menos de 16 años","Warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
//		if(Integer.parseInt(lblAvailableCabins.getText())<=0){
//			JOptionPane.showMessageDialog(null, "Lo sentimos no nos quedan más cabinas de este tipo","Warning",JOptionPane.WARNING_MESSAGE);
//			clearScreenPn3();
//			return false;
//		}
	
		return true;
	}
	public Boolean correctAge(String age)
	{
		
		if(age.equals("")){
			JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos de edad habilitados","Warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(!age.matches("[0-9]*$")){
			JOptionPane.showMessageDialog(null, "No me trollees, escribe una edad adecuada","Warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(Integer.parseInt(age)<0 || Integer.parseInt(age) >120){
			JOptionPane.showMessageDialog(null, "La edad indicada es incorrecta","Warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if(Integer.parseInt(age) >=18)
			mayorDeEdad.add(true);
		
		return true;
				
	}
	private void createNewCabin()
	{
		cabinCode ++;
		ArrayList<Extras> extras = getSelectedExtras();
		int age1 = -1;
		int age2 = -1;
		int age3 = -1;
		int age4 = -1;
		int ageExtra = -1;

		Boolean isOutside = false;
		Boolean isFamiliar = false;
		
		if(chckbxPassenger_1.isSelected())
			age1 = Integer.parseInt(textField_1.getText());
		if(chckbxPassenger_2.isSelected())
			age2 = Integer.parseInt(textField_2.getText());
		if(chckbxPassenger_3.isSelected())
			age3 = Integer.parseInt(textField_3.getText());
		if(chckbxPassenger_4.isSelected())
			age4 = Integer.parseInt(textField_4.getText());
		
		isOutside = getIsOutside();
		isFamiliar = getIsFamiliar();
		
		if(chckbxPassenger_extra.isSelected()){
			ageExtra = Integer.parseInt(textField_extra.getText());
			extras.add(database.getExtraGivenName("Cama supletoria"));
		}
		
		substractNumberOfCabins();
		Cabin currentCabin = new Cabin( extras,  age1,  age2,  age3,  age4, ageExtra,  isOutside, isFamiliar,cabinCode);
		bookedCabins.add(currentCabin);
		modeloListaResumen.addElement(currentCabin);//currentCabin.toString();
	}
	private void substractNumberOfCabins(){
		Boat selectedBoat = database.getBoat(selectedCruise.getBarcoCodigo());
		if(getIsFamiliar() && getIsOutside())
			selectedBoat.setFamiliarExterior(selectedBoat.getFamiliarExterior()-1);
		else if(!getIsFamiliar() && getIsOutside())
			selectedBoat.setDobleExterior(selectedBoat.getDobleExterior()-1);
		else if(getIsFamiliar() && !getIsOutside())
			selectedBoat.setFamiliarInterior(selectedBoat.getFamiliarInterior()-1);
		else if(!getIsFamiliar() && !getIsOutside())
			selectedBoat.setDobleInterior(selectedBoat.getDobleInterior()-1);
	}
	
	private Boolean getIsFamiliar() {
		if(cbCabins.getSelectedItem().toString().toLowerCase().contains("familiar")) 
			return true;
		return false;
	}

	private Boolean getIsOutside() {
		if(cbCabins.getSelectedItem().toString().toLowerCase().contains("exterior")) 
			return true;
		return false;
	}

	private ArrayList<Extras> getSelectedExtras()
	{
		ArrayList<Extras> rextras = new ArrayList<Extras>();
		for(int i = 0; i<modeloListaExtrasSeleccionados.size(); i++)
		{
			String selected = (String) modeloListaExtrasSeleccionados.getElementAt(i);
			 selected = selected.split("\\(")[0].trim();//albornoz
			rextras.add(database.getExtraGivenName(selected));
		}
		return rextras;
	}
	
	private JButton getBtnRemoveCabin() {
		if (btnRemoveCabin == null) {
			btnRemoveCabin = new JButton("Remove Cabin");
			btnRemoveCabin.setMnemonic('r');
			btnRemoveCabin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Cabin camaroteABorrar = (Cabin)listResumen.getSelectedValue();
					bookedCabins.remove(camaroteABorrar);
					
					for(int i = 0; i< modeloListaResumen.size(); i++)
						if(modeloListaResumen.getElementAt(i).equals(camaroteABorrar))
							modeloListaResumen.removeElementAt(i);
					
					if(bookedCabins.isEmpty()){
						btnBook3.setEnabled(false);
						btnRemoveCabin.setEnabled(false);
						
					}
					increaseNumberOfCabins(camaroteABorrar);
					//actualizarLabelCamarotesDisponibles();
					clearScreenPn3();
					btnEditCabin.setEnabled(false);

				}
			});
			btnRemoveCabin.setEnabled(false);
		}
		return btnRemoveCabin;
	}
	private void increaseNumberOfCabins(Cabin camaroteABorrar){
		Boat selectedBoat = database.getBoat(selectedCruise.getBarcoCodigo());
		if(camaroteABorrar.getIsFamiliar() && camaroteABorrar.getIsOutside())
			selectedBoat.setFamiliarExterior(selectedBoat.getFamiliarExterior()+1);
		else if(!camaroteABorrar.getIsFamiliar() && camaroteABorrar.getIsOutside())
			selectedBoat.setDobleExterior(selectedBoat.getDobleExterior()+1);
		else if(camaroteABorrar.getIsFamiliar() && !camaroteABorrar.getIsOutside())
			selectedBoat.setFamiliarInterior(selectedBoat.getFamiliarInterior()+1);
		else if(!camaroteABorrar.getIsFamiliar() && !camaroteABorrar.getIsOutside())
			selectedBoat.setDobleInterior(selectedBoat.getDobleInterior()+1);
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("Cancel");
			btnCancel.setMnemonic('c');
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					clearScreenPn3();
					//btnAddCabin.setEnabled(true);
					//btnRemoveCabin.setEnabled(true);
					btnEditCabin.setEnabled(false);
					btnSaveChanges.setEnabled(false);

					
					listResumen.clearSelection();
					cbCabins.setEnabled(true);
					
					btnBook3.setEnabled(true);
					btBack3.setEnabled(true);
					btnCancel.setEnabled(false);

					


				}
			});
			btnCancel.setEnabled(false);
		}
		return btnCancel;
	}
	private JButton getBtnEditCabin() {
		if (btnEditCabin == null) {
			btnEditCabin = new JButton("Edit Cabin");
			btnEditCabin.setMnemonic('e');
			btnEditCabin.setEnabled(false);
			btnEditCabin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					clearScreenPn3();
					restoreCabinContext(true);
					btnSaveChanges.setEnabled(true);
					btnCancel.setEnabled(true);
					btnAddCabin.setEnabled(false);
					btnRemoveCabin.setEnabled(false);
					cbCabins.setEnabled(false);
					
					btnBook3.setEnabled(false);
					btBack3.setEnabled(false);
			
				}
			});
		}
		return btnEditCabin;
	}
	private JList getListResumen() {
		if (listResumen == null) {
			modeloListaResumen = new DefaultListModel();
			listResumen = new JList(modeloListaResumen);
			listResumen.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(listResumen.getSelectedValue()!=null)
					{
						clearScreenPn3();
						restoreCabinContext(false);
						btnRemoveCabin.setEnabled(true);
						btnEditCabin.setEnabled(true);

					}
					if(!modeloListaResumen.isEmpty())
						btnRemoveCabin.setEnabled(true);
					if(modeloListaResumen.isEmpty())
						btnRemoveCabin.setEnabled(false);
				}
			});
			listResumen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listResumen;
	}
	
	/**
	 * Restore the context, if enabled == true, then set the labels enabled, set disabled otherwise
	 * @param enabled
	 */
	private void restoreCabinContext(Boolean enabled) {
		
		Cabin camaroteAEditar = (Cabin)listResumen.getSelectedValue();
		boolean isFamiliar = camaroteAEditar.getIsFamiliar();
		boolean isOutside = camaroteAEditar.getIsOutside();
		setKindCabin(isFamiliar,isOutside);

		//bug
		if(isFamiliar){
		chckbxPassenger_1.setEnabled(enabled);
		chckbxPassenger_2.setEnabled(enabled);
		chckbxPassenger_3.setEnabled(enabled);
		chckbxPassenger_4.setEnabled(enabled);
		label_1.setEnabled(enabled);
		label_2.setEnabled(enabled);
		label_3.setEnabled(enabled);
		label_4.setEnabled(enabled);
		}
		if(!isFamiliar)
		{
			chckbxPassenger_1.setEnabled(enabled);
			chckbxPassenger_2.setEnabled(enabled);
			label_1.setEnabled(enabled);
			label_2.setEnabled(enabled);
		}


		if(camaroteAEditar.getAge1() != -1){
			chckbxPassenger_1.setSelected(true);
			chckbxPassenger_1.setEnabled(enabled);
			textField_1.setEnabled(enabled);
			textField_1.setText(Integer.toString(camaroteAEditar.getAge1()));
			label_1.setEnabled(enabled);
		}
		if(camaroteAEditar.getAge2() != -1){
			chckbxPassenger_2.setSelected(true);
			chckbxPassenger_2.setEnabled(enabled);
			textField_2.setEnabled(enabled);
			textField_2.setText(Integer.toString(camaroteAEditar.getAge2()));
			label_2.setEnabled(enabled);
			
			if(!isFamiliar && selectedCruise.isAptoMenores()){
				chckbxPassenger_extra.setEnabled(enabled);
				label_extra.setEnabled(enabled);
			}
		}
		if(camaroteAEditar.getAge3() != -1){
			chckbxPassenger_3.setSelected(true);
			chckbxPassenger_3.setEnabled(enabled);
			textField_3.setEnabled(enabled);
			textField_3.setText(Integer.toString(camaroteAEditar.getAge3()));
			label_3.setEnabled(enabled);

		}
		if(camaroteAEditar.getAge4() != -1){
			chckbxPassenger_4.setSelected(true);
			chckbxPassenger_4.setEnabled(enabled);
			textField_4.setEnabled(enabled);
			textField_4.setText(Integer.toString(camaroteAEditar.getAge4()));
			label_4.setEnabled(enabled);
			if(isFamiliar && selectedCruise.isAptoMenores() ){
				chckbxPassenger_extra.setEnabled(enabled);
				label_extra.setEnabled(enabled);
			}

		}
		if(camaroteAEditar.getExtras().contains(database.getExtraGivenName("Cama supletoria"))){
			chckbxPassenger_extra.setSelected(true);
			chckbxPassenger_extra.setEnabled(enabled);
			textField_extra.setEnabled(enabled);
			textField_extra.setText(Integer.toString(camaroteAEditar.getAgeExtra()));
			label_extra.setEnabled(enabled);

		}
		for(Extras each : camaroteAEditar.getExtras())	{
			if(!each.getExtraName().equals("Cama supletoria")){
				modeloListaExtrasSeleccionados.addElement(each.getExtraName());
				modeloListaExtras.removeElement(each.getExtraName()+" ("+each.getExtraPrice()+"€)");
			}
		}
		

		
	}
	private void setKindCabin(boolean isFamiliar, boolean isOutside)
	{
		Boat currentBoat = database.getBoat(selectedCruise.getBarcoCodigo());	
		if(!isFamiliar && isOutside)
			cbCabins.setSelectedItem("Doble Exterior " + currentBoat.getPrecioDobleExterior() + "€");
			
		if(!isFamiliar && !isOutside)
			cbCabins.setSelectedItem("Doble Interior " + currentBoat.getPrecioDobleInterior() + "€");
		if(isFamiliar && isOutside)
			cbCabins.setSelectedItem("Familiar Exterior " + currentBoat.getPrecioFamiliarExterior() + "€");
		if(isFamiliar && !isOutside)
			cbCabins.setSelectedItem("Familiar Interior " + currentBoat.getPrecioFamiliarInterior() + "€");
		
	}
	
	private void clearScreenPn3()
	{
		
		chckbxPassenger_1.setSelected(false);
		chckbxPassenger_2.setSelected(false);
		chckbxPassenger_3.setSelected(false);
		chckbxPassenger_4.setSelected(false);
		chckbxPassenger_extra.setSelected(false);
		
		chckbxPassenger_extra.setEnabled(false);
		label_extra.setEnabled(false);

		
		textField_1.setText("");
		textField_1.setEnabled(false);
		textField_2.setText("");
		textField_2.setEnabled(false);
		textField_3.setText("");
		textField_3.setEnabled(false);
		textField_4.setText("");
		textField_4.setEnabled(false);
		textField_extra.setText("");
		textField_extra.setEnabled(false);
		
		modeloListaExtrasSeleccionados.clear();
		modeloListaExtras.clear();
		cargarExtras();
		
		cbCabins.setSelectedIndex(-1);
		fixBugDisableWhenChbx();
		lblAvailableCabins.setText("");
		
		
	}
	public void fixBugDisableWhenChbx()
	{
		chckbxPassenger_1.setEnabled(false);
		chckbxPassenger_2.setEnabled(false);
		chckbxPassenger_3.setEnabled(false);
		chckbxPassenger_4.setEnabled(false);
		chckbxPassenger_extra.setEnabled(false);
		
		label_1.setEnabled(false);
		label_2.setEnabled(false);
		label_3.setEnabled(false);
		label_4.setEnabled(false);
		label_extra.setEnabled(false);

	}
	
	private JButton getBtnSaveChanges() {
		if (btnSaveChanges == null) {
			btnSaveChanges = new JButton("Save Changes");
			btnSaveChanges.setMnemonic('v');
			btnSaveChanges.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(checkConstraints()){
						saveModifiedCabin();
						
						clearScreenPn3();
						btnSaveChanges.setEnabled(false);
						btnAddCabin.setEnabled(false);
						btnRemoveCabin.setEnabled(false);
						btnCancel.setEnabled(false);
						
						listResumen.clearSelection();
						cbCabins.setEnabled(true);
						
						btnBook3.setEnabled(true);
						btBack3.setEnabled(true);
						btnEditCabin.setEnabled(false);
						
					}
					else
						JOptionPane.showMessageDialog(null, "Revisa los datos introducidos","Warning",JOptionPane.WARNING_MESSAGE);
				}
			});
			btnSaveChanges.setEnabled(false);
		}
		return btnSaveChanges;
	}
	
	private void saveModifiedCabin()
	{
		Cabin camaroteAEditar = (Cabin)listResumen.getSelectedValue();

		if(chckbxPassenger_1.isSelected())
			camaroteAEditar.setAge1(Integer.parseInt(textField_1.getText()));
		if(chckbxPassenger_2.isSelected())
			camaroteAEditar.setAge2(Integer.parseInt(textField_2.getText()));
		if(chckbxPassenger_3.isSelected())
			camaroteAEditar.setAge3(Integer.parseInt(textField_3.getText()));
		if(chckbxPassenger_4.isSelected())
			camaroteAEditar.setAge4(Integer.parseInt(textField_4.getText()));
		if(chckbxPassenger_extra.isSelected())
			camaroteAEditar.setAgeExtra(Integer.parseInt(textField_extra.getText()));

//		camaroteAEditar.setIsOutside(getIsOutside());
//		camaroteAEditar.setIsOutside(getIsFamiliar());
		
		//Extras
		ArrayList<Extras> extras = getSelectedExtras();
		if(chckbxPassenger_extra.isSelected())
			extras.add(database.getExtraGivenName("Cama supletoria"));
		camaroteAEditar.setExtras(extras);
		

	}
	
	private JPanel getPnCabinType() {
		if (pnCabinType == null) {
			pnCabinType = new JPanel();
			pnCabinType.setForeground(Color.WHITE);
			pnCabinType.setFont(new Font("French Script MT", Font.BOLD, 24));
			pnCabinType.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "1. Select type of cabin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnCabinType.setBackground(Color.WHITE);
			pnCabinType.add(getLblTypeOfCabin());
			pnCabinType.add(getCbCabins());
			pnCabinType.add(getLblAailableCabinsText());
			pnCabinType.add(getLblAvailableCabins());
		}
		return pnCabinType;
	}
	private JPanel getPnPassengers() {
		if (pnPassengers == null) {
			pnPassengers = new JPanel();
			pnPassengers.setBackground(Color.WHITE);
			pnPassengers.setForeground(Color.WHITE);
			pnPassengers.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "2. Customize your cabin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPassengers.setLayout(new GridLayout(0, 2, 0, 0));
			pnPassengers.add(getPnPassengersAux());
			pnPassengers.add(getPnExtras());
		}
		return pnPassengers;
	}
	private JPanel getPnDates() {
		if (pnDates == null) {
			pnDates = new JPanel();
			pnDates.setBackground(Color.WHITE);
			pnDates.add(getLblDates());
			pnDates.add(getCbSelectDate());
			pnDates.add(getLblNewLabel_4());
			pnDates.add(getComboBox());
		}
		return pnDates;
	}
	private JPanel getPnPassengersAux() {
		if (pnPassengersAux == null) {
			pnPassengersAux = new JPanel();
			pnPassengersAux.setLayout(new GridLayout(5, 0, 0, 0));
			pnPassengersAux.add(getPnPassenger1());
			pnPassengersAux.add(getPnPassenger2());
			pnPassengersAux.add(getPnPassenger3());
			pnPassengersAux.add(getPnPassenger4());
			pnPassengersAux.add(getPnPassengerExtra());
		}
		return pnPassengersAux;
	}
	private JPanel getPnExtras() {
		if (pnExtras == null) {
			pnExtras = new JPanel();
			pnExtras.setLayout(new BorderLayout(0, 0));
			pnExtras.add(getPnExtraButtons(), BorderLayout.EAST);
			pnExtras.add(getPnExtraList(), BorderLayout.CENTER);
		}
		return pnExtras;
	}
	private JLabel getLblTypeOfCabin() {
		if (lblTypeOfCabin == null) {
			lblTypeOfCabin = new JLabel("Select a type of cabin: ");
			lblTypeOfCabin.setLabelFor(getCbCabins());
			lblTypeOfCabin.setDisplayedMnemonic('s');
			lblTypeOfCabin.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return lblTypeOfCabin;
	}

	
	private JLabel getLblDates() {
		if (lblDates == null) {
			lblDates = new JLabel("Select a date:");
			lblDates.setLabelFor(getCbSelectDate());
			lblDates.setDisplayedMnemonic('l');
			lblDates.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		}
		return lblDates;
	}
	private JComboBox<?> getCbSelectDate() {
		if (cbSelectDate == null) {
			cbSelectDate = new JComboBox();
			cbSelectDate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resetBooking();
					JOptionPane.showMessageDialog(null, "You can only book cabins for one specific date");
					
				}
			});
		}
		return cbSelectDate;
	}
	
	
	private JPanel getPnPassenger1() {
		if (pnPassenger1 == null) {
			pnPassenger1 = new JPanel();
			pnPassenger1.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnPassenger1.getLayout();
			flowLayout.setVgap(20);
			pnPassenger1.add(getChckbxPassenger_1());
			pnPassenger1.add(getLabel_1());
			pnPassenger1.add(getTextField_1());
		}
		return pnPassenger1;
	}
	private JCheckBox getChckbxPassenger_1() {
		if (chckbxPassenger_1 == null) {
			chckbxPassenger_1 = new JCheckBox("Passenger1 ");
			chckbxPassenger_1.setMnemonic('1');
			chckbxPassenger_1.setEnabled(false);
			chckbxPassenger_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxPassenger_1.isSelected()){
						textField_1.setEnabled(true);
						label_1.setEnabled(true);
						btnAddCabin.setEnabled(true);
						
					}
					else{
						btnAddCabin.setEnabled(false);
						textField_1.setEnabled(false);
						label_1.setEnabled(false);
						textField_1.setText("");
						
					}	
				}
			});
			chckbxPassenger_1.setBackground(Color.WHITE);
			chckbxPassenger_1.setVerticalAlignment(SwingConstants.BOTTOM);
			chckbxPassenger_1.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return chckbxPassenger_1;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Age:");
			label_1.setEnabled(false);
			label_1.setBackground(Color.WHITE);
			label_1.setVerticalAlignment(SwingConstants.BOTTOM);
			label_1.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return label_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setEnabled(false);
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setFont(new Font("Freestyle Script", Font.BOLD, 30));
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JPanel getPnPassenger2() {
		if (pnPassenger2 == null) {
			pnPassenger2 = new JPanel();
			pnPassenger2.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnPassenger2.getLayout();
			flowLayout.setVgap(20);
			pnPassenger2.add(getChckbxPassenger_2());
			pnPassenger2.add(getLabel_2());
			pnPassenger2.add(getTextField_2());
		}
		return pnPassenger2;
	}
	private JCheckBox getChckbxPassenger_2() {
		if (chckbxPassenger_2 == null) {
			chckbxPassenger_2 = new JCheckBox("Passenger2");
			chckbxPassenger_2.setMnemonic('2');
			chckbxPassenger_2.setEnabled(false);
			chckbxPassenger_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(	chckbxPassenger_2.isSelected()){
						textField_2.setEnabled(true);
						label_2.setEnabled(true);
						if(!getIsFamiliar() && selectedCruise.isAptoMenores())
							chckbxPassenger_extra.setEnabled(true);
						
						

					}
					else{
						textField_2.setEnabled(false);
						textField_2.setText("");
						label_2.setEnabled(false);
						chckbxPassenger_extra.setEnabled(false);


					}	
				}
			});
			chckbxPassenger_2.setBackground(Color.WHITE);
			chckbxPassenger_2.setVerticalAlignment(SwingConstants.BOTTOM);
			chckbxPassenger_2.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return chckbxPassenger_2;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Age:");
			label_2.setEnabled(false);
			label_2.setBackground(Color.WHITE);
			label_2.setVerticalAlignment(SwingConstants.BOTTOM);
			label_2.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return label_2;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setEnabled(false);
			textField_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_2.setFont(new Font("Freestyle Script", Font.BOLD, 30));
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JPanel getPnPassenger3() {
		if (pnPassenger3 == null) {
			pnPassenger3 = new JPanel();
			pnPassenger3.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnPassenger3.getLayout();
			flowLayout.setVgap(20);
			pnPassenger3.add(getChckbxPassenger_3());
			pnPassenger3.add(getLabel_3());
			pnPassenger3.add(getTextField_3());
		}
		return pnPassenger3;
	}
	private JCheckBox getChckbxPassenger_3() {
		if (chckbxPassenger_3 == null) {
			chckbxPassenger_3 = new JCheckBox("Passenger3");
			chckbxPassenger_3.setMnemonic('3');
			chckbxPassenger_3.setEnabled(false);
			chckbxPassenger_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(	chckbxPassenger_3.isSelected()){
						textField_3.setEnabled(true);
					label_3.setEnabled(true);
					}

					else{
						textField_3.setEnabled(false);
						textField_3.setText("");
						label_3.setEnabled(false);


					}	
				}
			});
			chckbxPassenger_3.setBackground(Color.WHITE);
			chckbxPassenger_3.setVerticalAlignment(SwingConstants.BOTTOM);
			chckbxPassenger_3.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return chckbxPassenger_3;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Age:");
			label_3.setEnabled(false);
			label_3.setVerticalAlignment(SwingConstants.BOTTOM);
			label_3.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return label_3;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setEnabled(false);
			textField_3.setHorizontalAlignment(SwingConstants.CENTER);
			textField_3.setFont(new Font("Freestyle Script", Font.BOLD, 30));
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JPanel getPnPassenger4() {
		if (pnPassenger4 == null) {
			pnPassenger4 = new JPanel();
			pnPassenger4.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnPassenger4.getLayout();
			flowLayout.setVgap(20);
			pnPassenger4.add(getChckbxPassenger_4());
			pnPassenger4.add(getLabel_4());
			pnPassenger4.add(getTextField_4());
		}
		return pnPassenger4;
	}
	private JCheckBox getChckbxPassenger_4() {
		if (chckbxPassenger_4 == null) {
			chckbxPassenger_4 = new JCheckBox("Passenger4");
			chckbxPassenger_4.setMnemonic('4');
			chckbxPassenger_4.setEnabled(false);
			chckbxPassenger_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(	chckbxPassenger_4.isSelected()){
						textField_4.setEnabled(true);
						label_4.setEnabled(true);
						if(getIsFamiliar() && selectedCruise.isAptoMenores())
							chckbxPassenger_extra.setEnabled(true);
						
					}

					else{
						textField_4.setEnabled(false);
						textField_4.setText("");
						label_4.setEnabled(false);
						chckbxPassenger_extra.setEnabled(false);
						chckbxPassenger_extra.setEnabled(false);

					}	
				}
			});
			chckbxPassenger_4.setBackground(Color.WHITE);
			chckbxPassenger_4.setVerticalAlignment(SwingConstants.BOTTOM);
			chckbxPassenger_4.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return chckbxPassenger_4;
	}

	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Age:");
			label_4.setEnabled(false);
			label_4.setVerticalAlignment(SwingConstants.BOTTOM);
			label_4.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return label_4;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setEnabled(false);
			textField_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_4.setFont(new Font("Freestyle Script", Font.BOLD, 30));
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JCheckBox getChckbxPassenger_extra() {
		if (chckbxPassenger_extra == null) {
			chckbxPassenger_extra = new JCheckBox("Extra bed");
			chckbxPassenger_extra.setMnemonic('x');
			chckbxPassenger_extra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(	chckbxPassenger_extra.isSelected()){
						textField_extra.setEnabled(true);
						label_extra.setEnabled(true);						
					}

					else{
						textField_extra.setEnabled(false);
						textField_extra.setText("");
						label_extra.setEnabled(false);
					}	
				}
			});
			chckbxPassenger_extra.setEnabled(false);
			chckbxPassenger_extra.setBackground(Color.WHITE);
			chckbxPassenger_extra.setVerticalAlignment(SwingConstants.BOTTOM);
			chckbxPassenger_extra.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return chckbxPassenger_extra;
	}
	private JLabel getLabel_extra() {
		if (label_extra == null) {
			label_extra = new JLabel("Age:");
			label_extra.setEnabled(false);
			label_extra.setVerticalAlignment(SwingConstants.BOTTOM);
			label_extra.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return label_extra;
	}
	private JTextField getTextField_extra() {
		if (textField_extra == null) {
			textField_extra = new JTextField();
			textField_extra.setEnabled(false);
			textField_extra.setHorizontalAlignment(SwingConstants.CENTER);
			textField_extra.setFont(new Font("Freestyle Script", Font.BOLD, 30));
			textField_extra.setColumns(10);
		}
		return textField_extra;
	}
	
	private JPanel getPnPassengerExtra() {
		if (pnPassengerExtra == null) {
			pnPassengerExtra = new JPanel();
			pnPassengerExtra.setBackground(Color.WHITE);
			FlowLayout fl_pnPassengerExtra = (FlowLayout) pnPassengerExtra.getLayout();
			fl_pnPassengerExtra.setVgap(20);
			pnPassengerExtra.add(getChckbxPassenger_extra());
			pnPassengerExtra.add(getLabel_extra());
			pnPassengerExtra.add(getTextField_extra());
		}
		return pnPassengerExtra;
	}
	private JPanel getPnExtraButtons() {
		if (pnExtraButtons == null) {
			pnExtraButtons = new JPanel();
			pnExtraButtons.setLayout(new GridLayout(2, 0, 0, 0));
			pnExtraButtons.add(getBtnAddExtra());
			pnExtraButtons.add(getBtnRemoveExtra());
		}
		return pnExtraButtons;
	}
	private JButton getBtnAddExtra() {
		if (btnAddExtra == null) {
			btnAddExtra = new JButton("AddExtra");
			btnAddExtra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selected = (String) listExtras.getSelectedValue();
					modeloListaExtrasSeleccionados.addElement(selected);
					modeloListaExtras.removeElement(selected);
			
					btnAddExtra.setEnabled(false);
					
				}
			});
			btnAddExtra.setEnabled(false);
		}
		return btnAddExtra;
	}
	private JButton getBtnRemoveExtra() {
		if (btnRemoveExtra == null) {
			btnRemoveExtra = new JButton("RemoveExtra");
			btnRemoveExtra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String selected = (String) listExtrasSeleccionados.getSelectedValue();
					modeloListaExtras.addElement(selected);//+" ("+database.getExtraGivenName(selected).getExtraPrice()+"€");
					modeloListaExtrasSeleccionados.removeElement(selected);
				    btnRemoveExtra.setEnabled(false);
				}
			});
			btnRemoveExtra.setEnabled(false);
		}
		return btnRemoveExtra;
	}
	private JPanel getPnExtraList() {
		if (pnExtraList == null) {
			pnExtraList = new JPanel();
			pnExtraList.setBackground(Color.WHITE);
			pnExtraList.setBorder(new TitledBorder(null, "3. Select the Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnExtraList.setLayout(new GridLayout(2, 0, 0, 0));
			pnExtraList.add(getScrollAllPane());
			pnExtraList.add(getSpAddedExtras());
		}
		return pnExtraList;
	}
	private JScrollPane getSpAddedExtras() {
		if (spAddedExtras == null) {
			spAddedExtras = new JScrollPane();
			spAddedExtras.setViewportView(getListExtrasAdded());
		}
		return spAddedExtras;
	}
	private JScrollPane getScrollAllPane() {
		if (scrollAllPane == null) {
			scrollAllPane = new JScrollPane();
			scrollAllPane.setViewportView(getListExtras());
		}
		return scrollAllPane;
	}
	private JList getListExtras() {
		if (listExtras == null) {
		    modeloListaExtras = new DefaultListModel<String>();
		    cargarExtras();
			listExtras = new JList(modeloListaExtras);
			listExtras.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (!listExtras.isSelectionEmpty())
							btnAddExtra.setEnabled(true);
					else
						btnAddExtra.setEnabled(false);

				}
			});
			listExtras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listExtras;
	}
	private void cargarExtras()
	{
		 dictionary = new Hashtable<String,String>();
		for(Extras each : database.getExtrasList())
			if(!each.getExtraCode().equals("E02") || !each.getExtraName().equals("Cama supletoria")){
				dictionary.put(each.getExtraName(),each.getExtraCode() );
				modeloListaExtras.addElement(each.getExtraName()+" ("+each.getExtraPrice()+"€)");
			}
	}
	private JList getListExtrasAdded() {
		if (listExtrasSeleccionados == null) {
			modeloListaExtrasSeleccionados = new DefaultListModel<String>();
			listExtrasSeleccionados = new JList(modeloListaExtrasSeleccionados);
			listExtrasSeleccionados.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(!listExtrasSeleccionados.isSelectionEmpty())
						btnRemoveExtra.setEnabled(true);
					else
						btnRemoveExtra.setEnabled(false);

				}
			});
			listExtrasSeleccionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listExtrasSeleccionados;
	}
	private JLabel getLblResumen() {
		if (lblResumen == null) {
			lblResumen = new JLabel("Your book:");
			lblResumen.setBackground(Color.WHITE);
			lblResumen.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return lblResumen;
	}


	// *************************************PANEL
	// 4*************************************

	private JPanel getPn4() {
		if (pn4 == null) {
			pn4 = new JPanel();
			pn4.setBackground(Color.WHITE);
			pn4.setLayout(new BorderLayout(0, 0));
			pn4.add(getLblPersonalData(), BorderLayout.NORTH);
			pn4.add(getPnSouth4(), BorderLayout.SOUTH);
			pn4.add(getPnData(), BorderLayout.CENTER);
		}
		return pn4;
	}

	private JLabel getLblPersonalData() {
		if (lblPersonalData == null) {
			lblPersonalData = new JLabel("Personal Data");
			lblPersonalData.setBackground(Color.WHITE);
			lblPersonalData.setHorizontalAlignment(SwingConstants.CENTER);
			lblPersonalData.setFont(new Font("Britannic Bold", Font.BOLD, 46));
		}
		return lblPersonalData;
	}

	private JPanel getPnSouth4() {
		if (pnSouth4 == null) {
			pnSouth4 = new JPanel();
			pnSouth4.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnSouth4.getLayout();
			flowLayout.setAlignment(FlowLayout.TRAILING);
			pnSouth4.add(getBtnBack4());
			pnSouth4.add(getBtnBook4());
		}
		return pnSouth4;
	}

	private JPanel getPnData() {
		if (pnData == null) {
			pnData = new JPanel();
			pnData.setBackground(Color.WHITE);
			pnData.setLayout(new GridLayout(0, 2, 0, 0));
			pnData.add(getPnLabels());
			pnData.add(getPnTextFields());
		}
		return pnData;
	}

	private JPanel getPnLabels() {
		if (pnLabels == null) {
			pnLabels = new JPanel();
			pnLabels.setBackground(Color.WHITE);
			pnLabels.setLayout(new GridLayout(13, 1, 0, 0));
			pnLabels.add(getLblName());
			pnLabels.add(getLblNewLabel_2());
			pnLabels.add(getLblNewLabel());
			pnLabels.add(getLblNewLabel_1());
			pnLabels.add(getLblDate());
			pnLabels.add(getLblAditionalData());
		}
		return pnLabels;
	}

	private JPanel getPnTextFields() {
		if (pnTextFields == null) {
			pnTextFields = new JPanel();
			pnTextFields.setBackground(Color.WHITE);
			pnTextFields.setLayout(new GridLayout(13, 1, 0, 0));
			pnTextFields.add(getTxName());
			pnTextFields.add(getTxSurname());
			pnTextFields.add(getTxPassport());
			pnTextFields.add(getTxPhone());
			pnTextFields.add(getTxDate());
			pnTextFields.add(getTfComments());
		}
		return pnTextFields;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("NAME:");
			lblName.setDisplayedMnemonic('n');
			lblName.setFont(new Font("Calibri Light", Font.BOLD, 19));
			lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblName;
	}

	private JTextField getTxName() {
		if (txName == null) {
			txName = new JTextField();
			txName.setFont(new Font("Calibri Light", Font.PLAIN, 19));
			txName.setColumns(5);
			// Listen for changes in the text
			txName.getDocument().addDocumentListener(new DocumentListener() {
				public void changedUpdate(DocumentEvent e) {
					warn();
				}

				public void removeUpdate(DocumentEvent e) {
					warn();
				}

				public void insertUpdate(DocumentEvent e) {
					warn();
				}

				public void warn() {
					if (!txName.getText().equals(""))
						txSurname.setEnabled(true);
					if (txName.getText().equals(""))
						txSurname.setEnabled(false);
				}
			});
		}
		return txName;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("PASSPORT:");
			lblNewLabel.setDisplayedMnemonic('p');
			lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 19));
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PHONE:");
			lblNewLabel_1.setDisplayedMnemonic('h');
			lblNewLabel_1.setFont(new Font("Calibri Light", Font.BOLD, 19));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblNewLabel_1;
	}

	private JTextField getTxPassport() {
		if (txPassport == null) {
			txPassport = new JTextField();
			txPassport.setBackground(Color.WHITE);
			txPassport.setFont(new Font("Calibri Light", Font.PLAIN, 19));
			txPassport.setEnabled(false);
			txPassport.setColumns(10);
			// Listen for changes in the text
			txPassport.getDocument().addDocumentListener(new DocumentListener() {
				public void changedUpdate(DocumentEvent e) {
					warn();
				}

				public void removeUpdate(DocumentEvent e) {
					warn();
				}

				public void insertUpdate(DocumentEvent e) {
					warn();
				}

				public void warn() {
					if (!txPassport.getText().equals(""))
						txPhone.setEnabled(true);
					if (txPassport.getText().equals(""))
						txPhone.setEnabled(false);
				}
			});

		}
		return txPassport;
	}

	private JTextField getTxPhone() {
		if (txPhone == null) {
			txPhone = new JTextField();
			txPhone.setBackground(Color.WHITE);
			txPhone.setFont(new Font("Calibri Light", Font.PLAIN, 19));
			txPhone.setEnabled(false);
			txPhone.setColumns(10);
			txPhone.getDocument().addDocumentListener(new DocumentListener() {
				public void changedUpdate(DocumentEvent e) {
					warn();
				}

				public void removeUpdate(DocumentEvent e) {
					warn();
				}

				public void insertUpdate(DocumentEvent e) {
					warn();
				}

				public void warn() {
					if (!txPhone.getText().equals(""))
						btnBook4.setEnabled(true);
					if (txPhone.getText().equals(""))
						btnBook4.setEnabled(false);
				}
			});
		}
		return txPhone;
	}

	// *****************************************SETS THE RESUME DATA / PERSON
	// /DATE ***********************************
	private JButton getBtnBook4() {
		if (btnBook4 == null) {
			btnBook4 = new JButton("Submit");
			btnBook4.setMnemonic('s');
			btnBook4.setToolTipText("Confirm the given data");
			btnBook4.setFont(new Font("Garamond", Font.PLAIN, 16));
			btnBook4.setEnabled(false);
			btnBook4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPaso(false, false, false, false, true, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel5");

					booking.setPerson(new Person(txName.getText(), txSurname.getText(), txPhone.getText(), txPassport.getText()));
					booking.setDate((String) txDate.getText());
					setResumeData();
					booking.setComments(tfComments.getText());

				}
			});
		}
		return btnBook4;
	}

	private JButton getBtnBack4() {
		if (btnBack4 == null) {
			btnBack4 = new JButton("Back");
			btnBack4.setToolTipText("Back to previous window");
			btnBack4.setMnemonic('b');
			btnBack4.setFont(new Font("Garamond", Font.PLAIN, 16));
			btnBack4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPaso(false, false, true, false, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel3");
				}
			});
		}
		return btnBack4;
	}

	// *********************************PANEL 5******************************
	private JPanel getPn5() {
		if (pn5 == null) {
			pn5 = new JPanel();
			pn5.setBackground(Color.WHITE);
			pn5.setLayout(new BorderLayout(0, 0));
			pn5.add(getLblResume(), BorderLayout.NORTH);
			pn5.add(getPnCenter5(), BorderLayout.CENTER);
			pn5.add(getPnBotones5(), BorderLayout.SOUTH);
		}
		return pn5;
	}

	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("DATE:");
			lblDate.setDisplayedMnemonic('d');
			lblDate.setFont(new Font("Calibri Light", Font.BOLD, 19));
			lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblDate;
	}
	
	private JTextField getTxSurname() {
		if (txSurname == null) {
			txSurname = new JTextField();
			txSurname.setBackground(Color.WHITE);
			txSurname.setFont(new Font("Calibri Light", Font.PLAIN, 19));
			txSurname.setEnabled(false);
			txSurname.setColumns(10);
			// Listen for changes in the text
			txSurname.getDocument().addDocumentListener(new DocumentListener() {
				public void changedUpdate(DocumentEvent e) {
					warn();
				}

				public void removeUpdate(DocumentEvent e) {
					warn();
				}

				public void insertUpdate(DocumentEvent e) {
					warn();
				}

				public void warn() {
					if (!txSurname.getText().equals(""))
						txPassport.setEnabled(true);
					if (txSurname.getText().equals(""))
						txPassport.setEnabled(false);
				}
			});
		}
		return txSurname;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("SURNAME: ");
			lblNewLabel_2.setDisplayedMnemonic('s');
			lblNewLabel_2.setFont(new Font("Calibri Light", Font.BOLD, 19));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblResume() {
		if (lblResume == null) {
			lblResume = new JLabel("Resume");
			lblResume.setBackground(Color.WHITE);
			lblResume.setFont(new Font("Britannic Bold", Font.BOLD, 46));
			lblResume.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblResume;
	}

	private JPanel getPnResumeData() {
		if (pnResumeData == null) {
			pnResumeData = new JPanel();
			pnResumeData.setBackground(Color.WHITE);
			pnResumeData.setLayout(new BorderLayout(0, 0));
			pnResumeData.add(getPnLabelsResumeDataLeft(), BorderLayout.CENTER);
			pnResumeData.add(getPnExtraFotos(), BorderLayout.EAST);
		}
		return pnResumeData;
	}

	private JPanel getPnBotones5() {
		if (pnBotones5 == null) {
			pnBotones5 = new JPanel();
			pnBotones5.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) pnBotones5.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnBotones5.add(getBtnBack5());
			pnBotones5.add(getBtnBook5());
		}
		return pnBotones5;
	}

	private JButton getBtnBack5() {
		if (btnBack5 == null) {
			btnBack5 = new JButton("Back");
			btnBack5.setMnemonic('b');
			btnBack5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarPaso(false, false, false, true, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel4");
					cleanResumeData();
				}
			});
		}
		return btnBack5;
	}

	private JPanel getPnLabelsResumeDataLeft() {
		if (pnLabelsResumeDataLeft == null) {
			pnLabelsResumeDataLeft = new JPanel();
			pnLabelsResumeDataLeft.setBackground(Color.WHITE);
			pnLabelsResumeDataLeft.setLayout(new GridLayout(19, 0, 0, 0));
			pnLabelsResumeDataLeft.add(getLblDataEspacio1());
			pnLabelsResumeDataLeft.add(getLblDataDatosCrucero());
			pnLabelsResumeDataLeft.add(getLblDataCrucero());
			pnLabelsResumeDataLeft.add(getLblDataBarco());
			pnLabelsResumeDataLeft.add(getLblDataFechaDeSalida());
			pnLabelsResumeDataLeft.add(getLblDataDias());
			pnLabelsResumeDataLeft.add(getLblDataSalida());
			pnLabelsResumeDataLeft.add(getLblDataNumeroPasajeros());
			pnLabelsResumeDataLeft.add(getSpDataCamarotes());
			pnLabelsResumeDataLeft.add(getLblDataEspacio2());
			pnLabelsResumeDataLeft.add(getLblDataPagadoReserva());
			pnLabelsResumeDataLeft.add(getLblDataPrecioCamarotes());
			pnLabelsResumeDataLeft.add(getLblDataPrecioExtras());
			pnLabelsResumeDataLeft.add(getLblExcursion());
			pnLabelsResumeDataLeft.add(getLblDataDescuento());
			pnLabelsResumeDataLeft.add(getLblDataEspacio3());
			pnLabelsResumeDataLeft.add(getLblDataImporteTotal());
		}
		return pnLabelsResumeDataLeft;
	}

	private JPanel getPnExtraFotos() {
		if (pnExtraFotos == null) {
			pnExtraFotos = new JPanel();
			pnExtraFotos.setLayout(new GridLayout(19, 0, 0, 0));
		}
		return pnExtraFotos;
	}

	private JPanel getPnCenter5() {
		if (pnCenter5 == null) {
			pnCenter5 = new JPanel();
			pnCenter5.setBackground(Color.WHITE);
			pnCenter5.setLayout(new BorderLayout(0, 0));
			pnCenter5.add(getPnResumeData());
			pnCenter5.add(getPnNorth5(), BorderLayout.NORTH);
		}
		return pnCenter5;
	}

	private JPanel getPnNorth5() {
		if (pnNorth5 == null) {
			pnNorth5 = new JPanel();
			pnNorth5.setBackground(Color.WHITE);
			pnNorth5.setLayout(new GridLayout(2, 1, 0, 0));
			pnNorth5.add(getLblResumeTitle());
			pnNorth5.add(getLblDatosCliente());
		}
		return pnNorth5;
	}

	private JLabel getLblResumeTitle() {
		if (lblResumeTitle == null) {
			lblResumeTitle = new JLabel("JUSTIFICANTE RESERVA \u2013 EII CRUCEROS");
			lblResumeTitle.setFont(new Font("Calibri Light", Font.BOLD, 20));
			lblResumeTitle.setBackground(Color.WHITE);
			lblResumeTitle.setHorizontalAlignment(SwingConstants.CENTER);
			timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
			lblResumeTitle.setText(lblResumeTitle.getText() + " \u2013 " + timeStamp);
		}
		return lblResumeTitle;
	}

	private JLabel getLblDatosCliente() {
		if (lblDatosCliente == null) {
			lblDatosCliente = new JLabel("");
			lblDatosCliente.setFont(new Font("Calibri Light", Font.BOLD, 20));
			lblDatosCliente.setHorizontalAlignment(SwingConstants.CENTER);

		}
		return lblDatosCliente;
	}

	private JLabel getLblDataEspacio1() {
		if (lblDataEspacio1 == null) {
			lblDataEspacio1 = new JLabel("");
		}
		return lblDataEspacio1;
	}

	private JLabel getLblDataDatosCrucero() {
		if (lblDataDatosCrucero == null) {
			lblDataDatosCrucero = new JLabel("***DATOS DEL CRUCERO***");
			lblDataDatosCrucero.setForeground(Color.BLACK);
			lblDataDatosCrucero.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		}
		return lblDataDatosCrucero;
	}

	private JLabel getLblDataCrucero() {
		if (lblDataCrucero == null) {
			lblDataCrucero = new JLabel("Crucero: ");
			lblDataCrucero.setForeground(Color.GRAY);
			lblDataCrucero.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataCrucero;
	}

	private JLabel getLblDataBarco() {
		if (lblDataBarco == null) {
			lblDataBarco = new JLabel("Barco: ");
			lblDataBarco.setForeground(Color.GRAY);
			lblDataBarco.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataBarco;
	}

	private JLabel getLblDataFechaDeSalida() {
		if (lblDataFechaDeSalida == null) {
			lblDataFechaDeSalida = new JLabel("Fecha de salida : ");
			lblDataFechaDeSalida.setForeground(Color.GRAY);
			lblDataFechaDeSalida.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataFechaDeSalida;
	}

	private JLabel getLblDataDias() {
		if (lblDataDias == null) {
			lblDataDias = new JLabel("D\u00EDas: ");
			lblDataDias.setForeground(Color.GRAY);
			lblDataDias.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataDias;
	}

	private JLabel getLblDataSalida() {
		if (lblDataSalida == null) {
			lblDataSalida = new JLabel("Salida: ");
			lblDataSalida.setForeground(Color.GRAY);
			lblDataSalida.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataSalida;
	}

	private JLabel getLblDataNumeroPasajeros() {
		if (lblDataNumeroPasajeros == null) {
			lblDataNumeroPasajeros = new JLabel("N\u00FAmero Pasajeros: ");
			lblDataNumeroPasajeros.setForeground(Color.GRAY);
			lblDataNumeroPasajeros.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataNumeroPasajeros;
	}

	private JLabel getLblDataEspacio2() {
		if (lblDataEspacio2 == null) {
			lblDataEspacio2 = new JLabel("");
		}
		return lblDataEspacio2;
	}

	private JLabel getLblDataPagadoReserva() {
		if (lblDataPagadoReserva == null) {
			lblDataPagadoReserva = new JLabel("**PAGADO RESERVA**");
			lblDataPagadoReserva.setForeground(Color.BLACK);
			lblDataPagadoReserva.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		}
		return lblDataPagadoReserva;
	}

	private JLabel getLblDataPrecioCamarotes() {
		if (lblDataPrecioCamarotes == null) {
			lblDataPrecioCamarotes = new JLabel("Camarotes:");
			lblDataPrecioCamarotes.setForeground(Color.GRAY);
			lblDataPrecioCamarotes.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataPrecioCamarotes;
	}

	private JLabel getLblDataPrecioExtras() {
		if (lblDataPrecioExtras == null) {
			lblDataPrecioExtras = new JLabel("Extras:");
			lblDataPrecioExtras.setForeground(Color.GRAY);
			lblDataPrecioExtras.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataPrecioExtras;
	}

	private JLabel getLblDataDescuento() {
		if (lblDataDescuento == null) {
			lblDataDescuento = new JLabel("Descuento Oferta: ");
			lblDataDescuento.setForeground(Color.GRAY);
			lblDataDescuento.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataDescuento;
	}

	private JLabel getLblDataEspacio3() {
		if (lblDataEspacio3 == null) {
			lblDataEspacio3 = new JLabel("");
		}
		return lblDataEspacio3;
	}

	private JLabel getLblDataImporteTotal() {
		if (lblDataImporteTotal == null) {
			lblDataImporteTotal = new JLabel("Importe Total: ");
			lblDataImporteTotal.setForeground(Color.GRAY);
			lblDataImporteTotal.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblDataImporteTotal;
	}

	private JPanel getPnFotos() {
		if (pnFotos == null) {
			pnFotos = new JPanel();
			pnFotos.setBackground(Color.WHITE);
			pnFotos.setLayout(new BorderLayout(0, 0));
			pnFotos.add(getLblFotoBarco(), BorderLayout.CENTER);
			pnFotos.add(getSpDescipcionBarco(), BorderLayout.SOUTH);
			pnFotos.add(getLblDenominacion(), BorderLayout.NORTH);
		}
		return pnFotos;
	}

	private JTextArea getTaDescripcionBarco() {
		if (taDescripcionBarco == null) {
			taDescripcionBarco = new JTextArea();
			taDescripcionBarco.setLineWrap(true);
			taDescripcionBarco.setWrapStyleWord(true);
			taDescripcionBarco.setFont(new Font("Calibri Light", Font.BOLD, 20));
			taDescripcionBarco.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			taDescripcionBarco.setEditable(false);
			taDescripcionBarco.setRows(3);

		}
		return taDescripcionBarco;
	}

	private JLabel getLblFotoBarco() {
		if (lblFotoBarco == null) {
			lblFotoBarco = new JLabel("");
			lblFotoBarco.setBackground(Color.WHITE);
//			lblOferta.addComponentListener(new ComponentAdapter() {
//				@Override
//				public void componentResized(ComponentEvent e) {
//					adaptarImagenLabel(lblFotoBarco, "/img/Fondo.jpg");
//				}
//			});
			

		}
		return lblFotoBarco;
	}

	private JLabel getLblAditionalData() {
		if (lblAditionalData == null) {
			lblAditionalData = new JLabel("COMMENTS: ");
			lblAditionalData.setDisplayedMnemonic('c');
			lblAditionalData.setFont(new Font("Calibri Light", Font.BOLD, 19));
			lblAditionalData.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblAditionalData;
	}

	private JTextField getTfComments() {
		if (tfComments == null) {
			tfComments = new JTextField();
			tfComments.setFont(new Font("Calibri Light", Font.PLAIN, 19));
			tfComments.setColumns(10);
		}
		return tfComments;
	}

	private JButton getBtnBook5() {
		if (btnBook5 == null) {
			btnBook5 = new JButton("Book");
			btnBook5.setForeground(Color.GREEN);
			btnBook5.setToolTipText("Book the cruise");
			btnBook5.setMnemonic('b');
			btnBook5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					booking.grabarPedido();
					JOptionPane.showMessageDialog(null, "¡Tu pedido ha sido guardado correctamente!");

					mostrarPaso(true, false, false, false, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel1");
					reiniciaApp();

				}
			});
			btnBook5.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return btnBook5;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private JScrollPane getSpResumen() {
		if (spResumen == null) {
			spResumen = new JScrollPane();
			spResumen.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			spResumen.setViewportView(getListResumen());
		}
		return spResumen;
	}
	

	private JTextArea getTaDiscountDescription() {
		if (taDiscountDescription == null) {
			taDiscountDescription = new JTextArea();
			taDiscountDescription.setMargin(new Insets(4, 4, 4, 4));
			taDiscountDescription.setBorder(null);
			taDiscountDescription.setEditable(false);
			taDiscountDescription.setTabSize(10);
			taDiscountDescription.setForeground(Color.RED);
			taDiscountDescription.setBackground(Color.WHITE);
			taDiscountDescription.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
			taDiscountDescription.setLineWrap(true);
			taDiscountDescription.setWrapStyleWord(true);
			taDiscountDescription.setText("Select one of this two cruises and get an amazing discount!");
		}
		return taDiscountDescription;
	}
	private JPanel getPnTabla2() {
		if (pnTabla2 == null) {
			pnTabla2 = new JPanel();
			pnTabla2.setBackground(Color.WHITE);
			pnTabla2.setLayout(new GridLayout(2, 0, 0, 0));
			pnTabla2.add(getScCruises());
			pnTabla2.add(getLblFotoCruise());
		}
		return pnTabla2;
	}
	private JLabel getLblFotoCruise() {
		if (lblFotoCruise == null) {
			lblFotoCruise = new JLabel("");
			lblFotoCruise.setHorizontalAlignment(SwingConstants.CENTER);
			lblFotoCruise.setBackground(Color.WHITE);
//			lblOferta.addComponentListener(new ComponentAdapter() {
//				@Override
//				public void componentResized(ComponentEvent e) {
//					adaptarImagenLabel(lblFotoCruise, "/img/Fondo.jpg");
//				}
//			});

		}
		return lblFotoCruise;
	}
	private JScrollPane getSpDescipcionBarco() {
		if (spDescipcionBarco == null) {
			spDescipcionBarco = new JScrollPane();
			spDescipcionBarco.setViewportView(getTaDescripcionBarco());
		}
		return spDescipcionBarco;
	}
	private JScrollPane getSpDescripcion() {
		if (spDescripcion == null) {
			spDescripcion = new JScrollPane();
			spDescripcion.setViewportView(getTaDescription());
		}
		return spDescripcion;
	}
	

	
	private JLabel getLblAvailableCabins() {
		if (lblAvailableCabins == null) {
			lblAvailableCabins = new JLabel("");
			lblAvailableCabins.setFont(new Font("French Script MT", Font.BOLD, 29));
			lblAvailableCabins.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAvailableCabins;
	}
	private JTextField getTxDate() {
		if (txDate == null) {
			txDate = new JTextField();
			txDate.setFont(new Font("Calibri Light", Font.PLAIN, 19));
			txDate.setBackground(Color.WHITE);
			txDate.setEditable(false);
			txDate.setColumns(10);
		}
		return txDate;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnCrucero());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnCrucero() {
		if (mnCrucero == null) {
			mnCrucero = new JMenu("Cruise");
			mnCrucero.setMnemonic('c');
			mnCrucero.add(getMntmReiniciar());
			mnCrucero.add(getSeparator());
			mnCrucero.add(getMntmCrucero());
		}
		return mnCrucero;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Help");
			mnAyuda.setMnemonic('h');
			mnAyuda.add(getMntmNewMenuItem());
			mnAyuda.add(getSeparator_1());
			mnAyuda.add(getMntmNewMenuItem_1());
		}
		return mnAyuda;
	}
	private JMenuItem getMntmReiniciar() {
		if (mntmReiniciar == null) {
			mntmReiniciar = new JMenuItem("Reset");
			mntmReiniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reiniciaApp();
					mostrarPaso(true, false, false, false, false, false);
					((CardLayout) pnCenter.getLayout()).show(pnCenter, "panel1");
				}
			});
			mntmReiniciar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		}
		return mntmReiniciar;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmCrucero() {
		if (mntmCrucero == null) {
			mntmCrucero = new JMenuItem("Exit");
			mntmCrucero.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mntmCrucero.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		}
		return mntmCrucero;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Contents");
			mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmNewMenuItem;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("About");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Icon icon = new ImageIcon(VentanaPrincipal.class.getResource("/img/Fondo.jpg"));
					String mensaje = "Módulo CPM curso 2015/2016\nVersion 2.0\nJorge García Marín \nUO245241";
					JOptionPane.showMessageDialog(null, mensaje, "Módulo CPM curso 2015/2016", 
							JOptionPane.PLAIN_MESSAGE, icon);
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	private JLabel getLblAailableCabinsText() {
		if (lblAailableCabinsText == null) {
			lblAailableCabinsText = new JLabel("  Available: ");
			lblAailableCabinsText.setFont(new Font("Britannic Bold", Font.BOLD, 20));
		}
		return lblAailableCabinsText;
	}
	private JScrollPane getSpDataCamarotes() {
		if (spDataCamarotes == null) {
			spDataCamarotes = new JScrollPane();
			spDataCamarotes.setViewportView(getTaDataCamarotes());
		}
		return spDataCamarotes;
	}
	private JTextArea getTaDataCamarotes() {
		if (taDataCamarotes == null) {
			taDataCamarotes = new JTextArea();
			taDataCamarotes.setEditable(false);
			taDataCamarotes.setForeground(Color.GRAY);
			taDataCamarotes.setFont(new Font("Calibri Light", Font.BOLD, 21));
			taDataCamarotes.setText("Camarotes:");
			taDataCamarotes.setWrapStyleWord(true);
			taDataCamarotes.setLineWrap(true);
			taDataCamarotes.setCaretPosition(0);

		}
		return taDataCamarotes;
	}
	private JLabel getLblDenominacion() {
		if (lblDenominacion == null) {
			lblDenominacion = new JLabel("");
			lblDenominacion.setHorizontalAlignment(SwingConstants.CENTER);
			lblDenominacion.setFont(new Font("Britannic Bold", Font.BOLD, 16));
		}
		return lblDenominacion;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("SEA HOLIDAYS!");
			lblNewLabel_3.setFont(new Font("Britannic Bold", Font.PLAIN, 11));
		}
		return lblNewLabel_3;
	}
	
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Select a Trip");
			lblNewLabel_4.setDisplayedMnemonic('t');
			lblNewLabel_4.setLabelFor(getComboBox());
			lblNewLabel_4.setFont(new Font("Britannic Bold", Font.PLAIN, 25));
		}
		return lblNewLabel_4;
	}
	private JComboBox<?> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					ArrayList<Excursiones> excursiones = database.getTripGivenCruiseCode((selectedCruise.getCruiseCode()));
					String exc[] = new String[excursiones.size()];

					for(int i =0; i<excursiones.size(); i++)
					{
						exc[i] = excursiones.get(i).getName();
					}
					comboBox.setModel(new DefaultComboBoxModel (exc));


				}
			});
		}
			
		return comboBox;
	}
	private JLabel getLblExcursion() {
		if (lblExcursion == null) {
			lblExcursion = new JLabel("Excursion");
			lblExcursion.setForeground(Color.GRAY);
			lblExcursion.setFont(new Font("Calibri Light", Font.BOLD, 21));
		}
		return lblExcursion;
	}
}
