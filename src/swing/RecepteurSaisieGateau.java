package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.Ingredient;

public class RecepteurSaisieGateau extends JFrame implements ActionListener, WindowListener{

	private JLabel jl1 = new JLabel("liste des ingredients");
	private JLabel jl2 = new JLabel("liste des instructions");
	
	private JButton jb1 = new JButton("Ajouter des ingredients");
	private JButton jb2 = new JButton("Ajouter des instructions");
	
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	
	private List liste1 = new List();
	private List liste2 = new List();
	
	private RecepteurSaisieInstruction rsins;
	private RecepteurSaisieIngredients rsing;
	
	java.util.List<Ingredient> ingredients;
	
	public RecepteurSaisieGateau() {
		super("Saisie d'une nouvelle recette");
	
		//PANEL
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		//listener assignment
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		

		//panel top
		jp1.setLayout(new GridLayout());
		jp1.add(jb1);
		jp1.add(jb2);
		this.add(jp1, BorderLayout.NORTH);

		//panel center
		jp2.setLayout(new GridLayout());
		jp2.add(jl1);
		jp2.add(jl2);
		this.add(jp2, BorderLayout.CENTER);

		//panel bottom
		jp3.setLayout(new GridLayout());
		jp3.add(liste1);
		jp3.add(liste2);
		this.add(jp3, BorderLayout.SOUTH);
		
		this.setBounds(10,  10,  1000,  500);
		this.setVisible(true);
		
		rsins = new RecepteurSaisieInstruction();
		rsing = new RecepteurSaisieIngredients();
		ingredients = new ArrayList<Ingredient>();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("icicicicicic");
		if(e.getSource() == jb1 && ! rsing.isVisible()) {
			rsing.setVisible(true);
		} else if(e.getSource() == jb1 && rsing.isVisible() && rsing.getListIngredient() != null) {
			ingredients = rsing.getListIngredient();
			for(Ingredient i : ingredients) {
				liste1.add(i.getQteIng()+" "+i.getNomIng());
			}
			rsing.dispose();
		}
		
		if(e.getSource() == jb2) {
			rsins.setVisible(true);
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
