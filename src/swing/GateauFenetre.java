package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.Cursor;
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
import java.awt.SystemColor;

public class GateauFenetre extends JFrame {

	private JPanel contentPane;
	
	//img
	ImageIcon imgCake = new ImageIcon("images/cake.jpg");
	ImageIcon imgBG = new ImageIcon("images/cakeBG.jpg");
	ImageIcon newCake = new ImageIcon("images/newCake.png");

	ImageIcon newImg;
	
// dimension
	//final int longueur = imgBG.getIconWidth();
	//final int hauteur = imgBG.getIconHeight();
	final int longueur = 150*7;    // image 300 x 300px
	final int hauteur =300*3;

	//Listes
	List listIngred = new List();
	List listGat = new List();
	List listInstruc = new List();

	//composents
	JLabel lblCake = new JLabel();

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
		
      
//------------------------------------------------------------------------------------------------------
		//   Panneau 1: Liste de gateaux
		JPanel JPListeGateaux = new JPanel();
		JPListeGateaux.setBackground(Color.PINK);
		JPListeGateaux.setBorder(new EmptyBorder(0, 0,0,0));  
		JPListeGateaux.setBounds(0, 0, 2*longueur/7, hauteur);
		JPListeGateaux.setLayout(null);    
		

		getContentPane().add(JPListeGateaux,BorderLayout.CENTER);
		
		listGat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent item) {
			//	System.out.println(item.getItem());
				int test = (int) item.getItem();
			//	System.out.println(listGat.getItem(test));
				// liste ingredients
				listIngred.removeAll();
				listIngred.add(listGat.getItem(test));
				
				//liste instruction
				listInstruc.removeAll();
				listInstruc.add(listGat.getItem(test));

				//img
				//lblCake.setIcon(newCake);
				
				//image
				try {
					URL url = new URL("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/cake.png");
					newImg = new ImageIcon(url);
					 lblCake.setIcon(newImg);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//TODO
				//
			}
		});
		listGat.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 41));
		listGat.setMultipleMode(true);
		listGat.add("paris brest");
		listGat.add("paris meuuuh");
		listGat.add("paris brest");
		listGat.add("paris brest");
		listGat.add("paris brest");
		listGat.add("paris caca");
		listGat.add("paris brest");
		

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
		
		//bouttons x2
		JButton btnRechercheParIngredients = new JButton("Recherche par INGREDIENTS");
		
		btnRechercheParIngredients.addMouseListener(new MouseAdapter() {             //  recherche par ingredient
			@Override
			public void mouseEntered(MouseEvent arg0) { // souris sur le boutton
				btnRechercheParIngredients.setBackground(Color.BLUE);
				//btnRechercheParIngredients.setCursor(Cursor.OPEN_HAND);     // not working
				btnRechercheParIngredients.setForeground(Color.WHITE);

				}
			@Override
			public void mouseExited(MouseEvent e) {  // souris quitte le boutton
				btnRechercheParIngredients.setBackground(new Color(240,240,240));
				btnRechercheParIngredients.setForeground(Color.BLACK);

			} 
			@Override
			public void mouseClicked(MouseEvent e) {  //click
			}  
		});
		
		btnRechercheParIngredients.setBounds(51, 583, 173, 58);
		JPListeGateaux.add(btnRechercheParIngredients);
		
		JButton btnNouveauGateau = new JButton("Nouveau Gateau");
		btnNouveauGateau.addMouseListener(new MouseAdapter() {                           // nouveau gateau
			@Override
			public void mouseEntered(MouseEvent arg0) { // souris sur le boutton
				btnNouveauGateau.setBackground(Color.BLUE);
				//btnRechercheParIngredients.setCursor(Cursor.OPEN_HAND);     // not working
				btnNouveauGateau.setForeground(Color.WHITE);

				}
			@Override
			public void mouseExited(MouseEvent e) {  // souris quitte le boutton
				btnNouveauGateau.setBackground(new Color(240,240,240));
				btnNouveauGateau.setForeground(Color.BLACK);

			} 
			@Override
			public void mouseClicked(MouseEvent e) {  //click
			}  
		});
		btnNouveauGateau.setBounds(60, 668, 154, 58);
		JPListeGateaux.add(btnNouveauGateau);

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
		
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");
		listIngred.add("blabl bla bla :   888 kg");


		listIngred.setForeground(new Color(189, 183, 107));
		listIngred.setFont(new Font("Bauhaus 93", Font.BOLD | Font.ITALIC, 23));
		listIngred.setBounds(10, 61, 386, 169);
		JPListeIngredients.add(listIngred);

		//-------------------------------------------------------------------------------------
		//   Panneau 3: liste d'instructions
		JPanel listeInstructions = new JPanel();
		listeInstructions.setBackground(Color.WHITE);
		listeInstructions.setBorder(new EmptyBorder(0, 0,0,0));   
		listeInstructions.setBounds(2*longueur/7, hauteur/3, 5*longueur/7, 2*hauteur/3);
		listeInstructions.setLayout(null);                                   
		getContentPane().add(listeInstructions,BorderLayout.CENTER);
		
		listInstruc.add("faire chauffer ta mere !!!!!");
		listInstruc.add("faire chauffer ta mere !!!!!");
		listInstruc.add("faire chauffer ta mere !!!!!");
		listInstruc.add("faire chauffer ta mere !!!!!");
		listInstruc.add("faire chauffer ta mere !!!!!");
		listInstruc.add("faire chauffer ta mere !!!!!");
		listInstruc.add("faire chauffer ta mere !!!!!");
		listInstruc.add("faire chauffer ta mere !!!!!");
		listInstruc.add("faire chauffer ta mere !!!!!");
		listInstruc.add("faire chauffer ta mere !!!!!");
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setFont(new Font("Playbill", Font.BOLD | Font.ITALIC, 38));
		lblInstructions.setForeground(new Color(255, 255, 0));
		lblInstructions.setBackground(new Color(255, 0, 255));
		lblInstructions.setBounds(107, 34, 355, 79);
		listeInstructions.add(lblInstructions);

		listInstruc.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 33));
		listInstruc.setForeground(new Color(100, 149, 237));
		listInstruc.setBackground(new Color(205, 133, 63));
		listInstruc.setBounds(46, 117, 552, 406);
		listeInstructions.add(listInstruc);

		//------------------------------------------------------------------------------------------
		//   Panneau 4: img
		
		JPanel JPImgCake = new JPanel();
		JPImgCake.setBackground(Color.WHITE);
		JPImgCake.setBorder(new EmptyBorder(0, 0,0,0));  
		JPImgCake.setBounds(5*longueur/7, 0, 2*longueur/7, hauteur/3);
		JPImgCake.setLayout(null);   
		getContentPane().add(JPImgCake,BorderLayout.CENTER);
		
		lblCake.setBounds(5*longueur/7, 0, 2*longueur/7, hauteur/3);
		lblCake.setIcon(imgCake);
		JPImgCake.add(lblCake);
		
		
		
		//------------------------- Compo -----------------------------------
		
		//   Panneau 1: Liste de gateaux
		

		
		
	}
}
