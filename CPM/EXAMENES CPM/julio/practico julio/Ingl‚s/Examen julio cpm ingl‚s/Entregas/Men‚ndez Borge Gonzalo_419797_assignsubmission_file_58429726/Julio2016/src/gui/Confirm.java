package gui;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Confirm extends JDialog {

	private static final long serialVersionUID = -3277548348636701922L;
	private JLabel lblYourOrderIs;
	private JLabel lblConfirm;
	private JButton btnNo;
	private JButton btnYes;
	
	private MainWindow mw;

	/**
	 * Create the dialog.
	 * @param mw 
	 */
	public Confirm(MainWindow mw) {
		
		this.mw = mw;
		
		setModal(true);
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Confirm.class.getResource("/img/libreria.jpg")));
		setTitle("Librer\u00EDa EII Oviedo");
		setBounds(100, 100, 450, 220);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(270, Short.MAX_VALUE)
					.addComponent(getBtnYes(), GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(getBtnNo())
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(getLblYourOrderIs())
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(164)
					.addComponent(getLblConfirm())
					.addContainerGap(163, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(getLblYourOrderIs())
					.addGap(19)
					.addComponent(getLblConfirm())
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(getBtnNo())
						.addComponent(getBtnYes()))
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {getBtnNo(), getBtnYes()});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {getBtnNo(), getBtnYes()});
		getContentPane().setLayout(groupLayout);		
	}
	private JLabel getLblYourOrderIs() {
		if (lblYourOrderIs == null) {
			lblYourOrderIs = new JLabel("Your order is about to be recorded");
			lblYourOrderIs.setForeground(SystemColor.textHighlight);
			lblYourOrderIs.setFont(new Font("SansSerif", Font.PLAIN, 24));
		}
		return lblYourOrderIs;
	}
	private JLabel getLblConfirm() {
		if (lblConfirm == null) {
			lblConfirm = new JLabel("Confirm?");
			lblConfirm.setForeground(SystemColor.textHighlight);
			lblConfirm.setFont(new Font("SansSerif", Font.BOLD, 24));
		}
		return lblConfirm;
	}
	private JButton getBtnNo() {
		if (btnNo == null) {
			btnNo = new JButton("No");
			btnNo.setMnemonic('N');
			btnNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnNo;
	}
	private JButton getBtnYes() {
		if (btnYes == null) {
			btnYes = new JButton("Yes");
			btnYes.setMnemonic('Y');
			btnYes.setFont(new Font("SansSerif", Font.PLAIN, 12));
			btnYes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mw.getApp().recordPurchase();
					JOptionPane.showMessageDialog(null, "Your order has been recorded!");
					dispose();
					mw.reset();
				}
			});
		}
		return btnYes;
	}
	
	protected void reset() {
		getRootPane().setDefaultButton(btnNo);
		setVisible(true);
	}
}
