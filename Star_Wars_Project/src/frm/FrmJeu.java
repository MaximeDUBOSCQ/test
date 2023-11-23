package frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.FrmMain;
import representation.ChanceNode;
import representation.DecisionNode;
import representation.InnerNode;
import representation.Node;
import representation.TerminalNode;
import representation.Event;
import representation.ImageNode;
import univers.Maitre;
import univers.Padawan;
import univers.Sabre;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *  Cette classe représente la fenêtre utilisée lorsque nous jouons.
 *
 * 	@author Maxime DUBOSCQ, Nicolas LONGHI
 * 	@version 1.0
 */

public class FrmJeu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDescription;
	private JButton btnChoix1;
	private JButton btnChoix2;
	private JButton btnChoix3;
	private JButton btnChoix4;
	private Node nodeActuelle;
	private ArrayList<Node> listeNodes = new ArrayList<Node>();	

	
	/**
	 * Modifie l'interface et réagit en fonction de la node actuelle
	 *
	 * @param unIDNode Identifiant de la prochaine node où nous sommes dirigés
	 */
	public void jouer(int unIDNode) {
		if (unIDNode != 0) {
			nodeActuelle = ((InnerNode) nodeActuelle).chooseNext(unIDNode);
		}
		
		if (nodeActuelle instanceof TerminalNode) {
			lblDescription.setText(nodeActuelle.display());
			JOptionPane.showMessageDialog(this, "Vous avez perdu !", "Perdu", JOptionPane.WARNING_MESSAGE);
    		FrmMain frmMain = new FrmMain();
    		setVisible(false);
    		frmMain.setVisible(true);
		}
		else if (nodeActuelle instanceof ChanceNode) {
			jouer(((ChanceNode) nodeActuelle).chooseNext(unIDNode).getId());
		}
		else if (nodeActuelle instanceof InnerNode) {
			
			//Affiche les petites descriptions dans les boutons (à faire dans une boucle)
			lblDescription.setText(nodeActuelle.display());
			btnChoix1.setText(listeNodes.get(((InnerNode) nodeActuelle).getIDProchaines()[0]-1).getPetiteDescription());
			btnChoix1.putClientProperty("hiddenValue", ((InnerNode) nodeActuelle).getIDProchaines()[0]);
			btnChoix2.setText(listeNodes.get(((InnerNode) nodeActuelle).getIDProchaines()[1]-1).getPetiteDescription());
			btnChoix2.putClientProperty("hiddenValue", ((InnerNode) nodeActuelle).getIDProchaines()[1]);
		}
	}
	
	public void retour() {
		int choix = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter la partie ?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (choix == JOptionPane.YES_OPTION) {
    		FrmMain frmMain = new FrmMain();
    		setVisible(false);
    		frmMain.setVisible(true);
        }
	}
	
	public FrmJeu() {
		setTitle("Star Wars");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				
				
				//Déclaration des nodes
				Node.setCompteur(0);
				Padawan monPadawan = new Padawan("Bupheto", 100, 100, 0.7f, Sabre.ENTRAINEMENT, Maitre.YODA);
				DecisionNode node1 = new DecisionNode("Il y a bien longtemps, dans une galaxie lointaine, très lointaine... <br>" + monPadawan.getPseudo() + " se réveille", "", new int[]{2, 3});
				DecisionNode node2 = new DecisionNode("Le soleil de Tatouine brille dehors.", "Sortir dehors", new int[]{4, 7});
				DecisionNode node3 = new DecisionNode("Le personnage s'habille et quelqu'un toque à la porte.", "Aller s'habiller", new int[] {8, 9});
				DecisionNode node4 = new DecisionNode("Le personnage arrive à l'auberge et demande un plat.", "Prendre le speeder et aller à l'auberge", new int[] {5, 6});
				DecisionNode node5 = new DecisionNode("L'aubergiste  amène le plat et le personnage le mange.<br>Le personnage s'apprète à partir mais l'aubergiste vous accoste et vous met en garde contre quelqu'un qui vous cherche.", "Prendre un hamburger", new int[] {8, 10});
				TerminalNode node6 = new TerminalNode("Le chef amène le poisson au personnage. Celui-ci le mange mais une arête reste coincée dans sa gorge.<br>Il n'arrive plus à respirer et meurt...", "Prendre du poisson");
				DecisionNode node7 = new DecisionNode("Le personnage aperçoit de nombreux chasseurs de primes.", "Prendre le speeder et aller au bar", new int[] {11, 12});
				TerminalNode node8 = new TerminalNode("Le personnage, sans souciance, ouvre la porte et se trouve face à une personne capuchée,<br>il regarde de plus prêt et il s'aperçoit que c'est un Jedi...", "Ouvrir la porte");
				DecisionNode node9 = new DecisionNode("Le personnage aperçoit une personne capuchée. Il décide de sortir de la maison par la porte de derrière.", "Regarder par la fenêtre", new int[]{4, 7});
				TerminalNode node10 = new TerminalNode("Le personnage part se cacher derrière le comptoir et entend la porte s'ouvrir.<br>Les pas se rapprochent de lui et soudain quelqu'un apparaît devant lui.<br>Elle est capuchée et porte un sabre laser à sa ceinture. C'est un Jedi...", "Se cacher");
				DecisionNode node11 = new DecisionNode("Le barman offre à boire au personnage et lui dit qu'il devrait se cacher.", "Aller voir le barman", new int[]{10, 12});
				TerminalNode node12 = new TerminalNode("Le personnage ne ressent aucune crainte et part s'asseoir à une table mais une personne l'accoste.<br>Elle est capuchée et porte un sabre laser à sa ceinture. C'est un Jedi...", "Aller s'asseoir à une table");
							
				Event monNoeud = new ImageNode(node1, "lechemin");
				System.out.println(monNoeud.display());
				
				
				//Configure les listes de prochaines nodes dans les nodes
				listeNodes.addAll(Arrays.asList(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12));
				for (int i = 0 ; i < listeNodes.size() ; i++) {
					if (listeNodes.get(i) instanceof InnerNode && ((InnerNode) listeNodes.get(i)).getIDProchaines() != null) {
						((InnerNode) listeNodes.get(i)).setProchainesNodes(((InnerNode) listeNodes.get(i)).getIDProchaines(), listeNodes);
					}
				}
				
				
				
				//Lancer le jeu à partir de la première node
				nodeActuelle = (DecisionNode) node1;
				jouer(0);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				retour();
			}
			
			
			
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 790, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		lblDescription = new JLabel("<descriptionNodeActuelle>");
		lblDescription.setVerticalAlignment(SwingConstants.TOP);
		//------------> btnChoix1
		btnChoix1 = new JButton("<choix1>");
		btnChoix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jouer((int) btnChoix1.getClientProperty("hiddenValue"));
			}
		});
		
		
		//------------> btnChoix2
		btnChoix2 = new JButton("<choix2>");
		btnChoix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jouer((int) btnChoix2.getClientProperty("hiddenValue"));
			}
		});
		
		
		//------------> btnChoix3
		btnChoix3 = new JButton("<choix3>");
		btnChoix3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//jouer((int) btnChoix3.getClientProperty("hiddenValue"));
			}
		});
		
		
		//------------> btnChoix4
		btnChoix4 = new JButton("<choix4>");
		btnChoix4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//jouer((int) btnChoix4.getClientProperty("hiddenValue"));
			}
		});
		
		//------------> btnQuitter
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retour();
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnChoix1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnChoix2, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnChoix3, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnChoix4, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, Alignment.LEADING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addGap(19)
					.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(111)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnChoix1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChoix2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnChoix3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChoix4, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
