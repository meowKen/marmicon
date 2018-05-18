package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Cursor;
import metier.Gateau;
import metier.GateauFenetreMethodes;
import metier.Ingredient;
import metier.Instruction;
import sun.java2d.pipe.DrawImage;

import java.awt.List;
import javax.swing.JLabel;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class GateauFenetre extends JFrame {

	private JPanel contentPane;
	
	GateauFenetreMethodes gfm = new GateauFenetreMethodes();
	
	//img
	ImageIcon newCake = new ImageIcon("images/cupCake.png");
	ImageIcon searchIcon = new ImageIcon("images/search.png");
	ImageIcon addIcon = new ImageIcon("images/add.png");
	ImageIcon addIcon2 = new ImageIcon("images/add2.png");

	//ImageIcon newImg;
	
	// dimension
	final int longueur = 150*7;    // image 300 x 300px
	final int hauteur =300*3;

	//Listes
	List listIngred = new List();
	List listGat = new List();
	List listInstruc = new List();

	ArrayList<Integer> listIdGat = new ArrayList<Integer>();

	String cake = "pomme";

	//composents
	JLabel lblCake = new JLabel();
	private JTextField cakeSearch;
	JButton butSearch = new JButton();    


	/**
	 * Create the frame.
	 */
	public GateauFenetre() {
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrame.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-information@2x.png")));
		setTitle("Cake Paradise");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setBounds(0, 0, longueur, hauteur);
	//----------------------------- initialisation des listes ---------------------------

		// liste gateau
		for(Gateau g: gfm.listeGateaux()) {
			listGat.add(g.getNomGat());
			listIdGat.add(g.getIdGat());
		}
		// liste ingredients
		for(Ingredient i: gfm.listeIngredient(listIdGat.get(0))) {   // 1er id de la liste
			listIngred.add(i.getQteIng() + " | " +i.getNomIng());
		}	
		
		//liste instructions et ordre
		for(Instruction i: gfm.listeInstruction(listIdGat.get(0))) {
			listInstruc.add(i.getIdOrdre() + " | " +i.getInstr());
		}
		
      
//------------------------------------------------------------------------------------------------------
		//   Panneau 1: Liste de gateaux
		JPanel JPListeGateaux = new JPanel();
		JPListeGateaux.setBackground(Color.PINK);
		JPListeGateaux.setBorder(new EmptyBorder(0, 0,0,0));  
		JPListeGateaux.setBounds(0, 0, 2*longueur/7, hauteur);
		JPListeGateaux.setLayout(null);    
		

		getContentPane().add(JPListeGateaux,BorderLayout.CENTER);
		
		listGat.addItemListener(new ItemListener() {             // gateau selectionné
			public void itemStateChanged(ItemEvent item) {
			//	System.out.println(item.getItem());
			//	System.out.println(listGat.getItem(test));
				listIngred.removeAll();
				listInstruc.removeAll();

				//je recupere le gateau
				int indexGat = (int) item.getItem();
				int idGat = listIdGat.get(indexGat);
				// liste ingredients
				for(Ingredient i: gfm.listeIngredient(idGat)) {
					listIngred.add(i.getQteIng() + " | " +i.getNomIng());
				}	
				
				//liste instructions et ordre
				for(Instruction i: gfm.listeInstruction(idGat)) {
					listInstruc.add(i.getIdOrdre() + " | " +i.getInstr());
				}	
				
				
				//image
					 lblCake.setIcon(gfm.newImg(idGat));
				
				//TODO
				//
			}
		});
		listGat.setFont(new Font("SansSerif", Font.BOLD, 14));
		listGat.setMultipleMode(true);
		listGat.setBackground(new Color(135, 206, 250));
		listGat.setMultipleSelections(false);
		listGat.setForeground(Color.GRAY);
		listGat.setBounds(10, 80, 252, 422);
		JPListeGateaux.add(listGat);
		
		JLabel lblGateaux = new JLabel("Gateaux:");
		lblGateaux.setHorizontalAlignment(SwingConstants.CENTER);
		lblGateaux.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 24));
		lblGateaux.setBounds(10, 22, 204, 32);
		JPListeGateaux.add(lblGateaux);
		
		JButton btnNouveauGateau = new JButton();
		btnNouveauGateau.addMouseListener(new MouseAdapter() {                           // nouveau gateau
			@Override
			public void mouseEntered(MouseEvent arg0) { // souris sur le boutton
				btnNouveauGateau.setIcon(addIcon2);
			//	btnNouveauGateau.setCursor();
				}
			@Override
			public void mouseExited(MouseEvent e) {  // souris quitte le boutton
				btnNouveauGateau.setIcon(addIcon);
			} 
			@Override
			public void mouseClicked(MouseEvent e) {  //click
				RecepteurSaisieGateau recepgat = new RecepteurSaisieGateau();
				getContentPane().setVisible(false);                           // not good enought
			}  
		});
		btnNouveauGateau.setBounds(JPListeGateaux.getWidth()/2 - addIcon.getIconWidth()/2, JPListeGateaux.getHeight() - 2*addIcon.getIconHeight(), addIcon.getIconWidth(), addIcon.getIconHeight());
		btnNouveauGateau.setIcon(addIcon);
		btnNouveauGateau.setBackground(JPListeGateaux.getBackground());
		btnNouveauGateau.setBorderPainted(false);
		JPListeGateaux.add(btnNouveauGateau);
		
		
		//input search gateau
		cakeSearch = new JTextField();
		cakeSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				String cake = cakeSearch.getText();
			}
		});
		cakeSearch.setBounds(10, 54, 204, 20);
		JPListeGateaux.add(cakeSearch);
		cakeSearch.setColumns(10);

		
		// label "search"
		butSearch.addMouseListener(new MouseAdapter() {  
			@Override
			public void mouseClicked(MouseEvent arg0) {  //click
				cake = cakeSearch.getText();
				listIngred.removeAll();
				listInstruc.removeAll();
				listGat.removeAll();
				
				for(Gateau g: gfm.listGatByName(cake)) {
					listGat.add(g.getNomGat());
					listIdGat.add(g.getIdGat());
				}
				// liste ingredients
				for(Ingredient i: gfm.listeIngredient(listIdGat.get(0))) {   // 1er id de la liste
					listIngred.add(i.getQteIng() + " | " +i.getNomIng());
				}	
				
				//liste instructions et ordre
				for(Instruction i: gfm.listeInstruction(listIdGat.get(0))) {
					listInstruc.add(i.getIdOrdre() + " | " +i.getInstr());
				}
				//image
				 lblCake.setIcon(gfm.newImg(0));
				
			}
		});
		butSearch.setBounds(224, 54, searchIcon.getIconWidth(), searchIcon.getIconHeight());
		butSearch.setBorder(null);
		butSearch.setIcon(searchIcon);
		JPListeGateaux.add(butSearch);

//----------------------------------------------------------------------------------------------------
		//   Panneau 2: Liste d'ingredients
		JPanel JPListeIngredients = new JPanel();
		JPListeIngredients.setBackground(Color.RED);
		JPListeIngredients.setBorder(new EmptyBorder(0, 0,0,0));  
		JPListeIngredients.setBounds(2*longueur/7, 0, 3*longueur/7, hauteur/3);
		JPListeIngredients.setLayout(null);                                       
		getContentPane().add(JPListeIngredients,BorderLayout.CENTER);
		
		JLabel lblListeDingrdients = new JLabel("Liste d'Ingr\u00E9dients");
		lblListeDingrdients.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDingrdients.setForeground(new Color(0, 0, 255));
		lblListeDingrdients.setFont(new Font("Playbill", Font.BOLD | Font.ITALIC, 30));
		lblListeDingrdients.setBackground(new Color(255, 222, 173));
		lblListeDingrdients.setBounds(0, 0, 428, 32);
		JPListeIngredients.add(lblListeDingrdients);


		listIngred.setForeground(new Color(189, 183, 107));
		listIngred.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 25));
		listIngred.setBounds(27, 50, 369, 222);
		JPListeIngredients.add(listIngred);

		//-------------------------------------------------------------------------------------
		//   Panneau 3: liste d'instructions
		JPanel JPlisteInstructions = new JPanel();
		JPlisteInstructions.setBackground(Color.WHITE);
		JPlisteInstructions.setBorder(new EmptyBorder(0, 0,0,0));   
		JPlisteInstructions.setBounds(2*longueur/7, hauteur/3, 5*longueur/7, 2*hauteur/3);
		JPlisteInstructions.setLayout(null);                                   
		getContentPane().add(JPlisteInstructions,BorderLayout.CENTER);

		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(new Font("Playbill", Font.BOLD | Font.ITALIC, 38));
		lblInstructions.setForeground(new Color(255, 255, 0));
		lblInstructions.setBackground(new Color(255, 0, 255));
		lblInstructions.setBounds(107, 34, 355, 79);
		JPlisteInstructions.add(lblInstructions);

		listInstruc.setFont(new Font("Century Gothic", Font.BOLD, 22));
		listInstruc.setForeground(new Color(100, 149, 237));
		listInstruc.setBackground(new Color(205, 133, 63));
		listInstruc.setBounds(46, 117, 552, 406);
		JPlisteInstructions.add(listInstruc);

		//------------------------------------------------------------------------------------------
		//   Panneau 4: img
		
		JPanel JPImgCake = new JPanel();
		JPImgCake.setBackground(Color.WHITE);
		JPImgCake.setBorder(new EmptyBorder(0, 0,0,0));  
		JPImgCake.setBounds(5*longueur/7, 0, 2*longueur/7, hauteur/3);
		JPImgCake.setLayout(null);   
		getContentPane().add(JPImgCake,BorderLayout.CENTER);
		
		lblCake.setBounds(5*longueur/7, 0, 2*longueur/7, hauteur/3);
		lblCake.setIcon(newCake);
		JPImgCake.add(lblCake);
		
		
		
		//------------------------- Compo -----------------------------------
		
		//   Panneau 1: Liste de gateaux
		

		//-------------------------------- recuperation de la liste des gateau !!!!
		
	}
}
