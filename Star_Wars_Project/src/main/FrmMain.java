package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import frm.FrmJeu;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

/**
 * 	Cette classe représente la fenêtre de démarrage du programme.
 * 	Elle contient la méthode main.
 *
 * 	@author Maxime DUBOSCQ, Nicolas LONGHI
 * 	@version 1.0
 */

public class FrmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNomUtilisateur;
	private JLabel lblDerniereConnexion;
	private JButton btnReprendre;
	private JButton btnNouvellePartie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
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
	public FrmMain() {
		setTitle("Star Wars");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblNomUtilisateur.setText("Bonjour " + System.getProperty("user.name"));
				lblDerniereConnexion.setText("Dernière connexion : Aucune date");
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblNomUtilisateur = new JLabel("<nomUtilisateur>");
		lblNomUtilisateur.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		btnReprendre = new JButton("Reprendre");
		btnReprendre.setEnabled(false);
		btnReprendre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*FrmJeu frmJeu = new FrmJeu();
				setVisible(false);
				frmJeu.setVisible(true);*/
			}
		});
		
		lblDerniereConnexion = new JLabel("Dernière connexion :<date>");
		
		//------------> btnNouvellePartie
		btnNouvellePartie = new JButton("Nouvelle partie");
		btnNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmJeu frmJeu = new FrmJeu();
				setVisible(false);
				frmJeu.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNomUtilisateur)
					.addContainerGap(279, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDerniereConnexion)
					.addContainerGap(310, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addComponent(btnNouvellePartie, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnReprendre, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(92))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNomUtilisateur)
					.addGap(43)
					.addComponent(lblDerniereConnexion)
					.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReprendre)
						.addComponent(btnNouvellePartie))
					.addGap(16))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
