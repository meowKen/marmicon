package swing;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
//import java.awt.Insets;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Ingredient;

public class RecepteurSaisieGateau extends JFrame implements ActionListener, WindowListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9093107012304926848L;
	private JLabel jl1 = new JLabel("liste des ingredients");
	private JLabel jl2 = new JLabel("liste des instructions");
	private JLabel jl3 = new JLabel("nom du gateau");
	
	private JButton jb1 = new JButton("Ajouter des ingredients");
	private JButton jb2 = new JButton("Ajouter des instructions");
	private JButton jb3 = new JButton("supprimer selection");
	private JButton jb4 = new JButton("supprimer selection");
	private JButton jb5 = new JButton("ajouter");
	
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	private JPanel jp4 = new JPanel();
	
	private JTextField jtf3 = new JTextField();
	
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
		

		//panel bottom
		jp1.setLayout(new GridLayout());
		jp1.add(jb1);
		jp1.add(jb3);
		jp1.add(jb2);
		jp1.add(jb4);
		this.add(jp1, BorderLayout.SOUTH);
		
		//panel top
		jp2.setLayout(new GridLayout());
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		jp2.add(jl1);
		jl2.setHorizontalAlignment(SwingConstants.CENTER);
		jp2.add(jl2);
		this.add(jp2, BorderLayout.NORTH);

		//panel center
		jp3.setLayout(new GridLayout());
		jp3.add(liste1);
		jp3.add(liste2);
		this.add(jp3, BorderLayout.CENTER);
		
		//panel west (Grid) configuration
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{0, 0};
		gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		GridBagConstraints gbcjl3 = new GridBagConstraints();
		//gbcjl3.insets = new Insets(0, 0, 5, 0);
		//gbcjl3.fill = GridBagConstraints.HORIZONTAL;
		gbcjl3.gridx = 0;
		gbcjl3.gridy = 0;
		
		GridBagConstraints gbcjtf3 = new GridBagConstraints();
		//gbcjtf3.insets = new Insets(0, 0, 5, 0);
		gbcjtf3.fill = GridBagConstraints.HORIZONTAL;
		gbcjtf3.gridx = 0;
		gbcjtf3.gridy = 1;
		
		GridBagConstraints gbcjb5 = new GridBagConstraints();
		//gbcjb5.insets = new Insets(0, 0, 5, 0);
		//gbcjb5.fill = GridBagConstraints.HORIZONTAL;
		gbcjb5.gridx = 0;
		gbcjb5.gridy = 2;
		
		//panel west
		jp4.setLayout(gbl);
		jp4.add(jl3, gbcjl3);
		jp4.add(jtf3, gbcjtf3);
		jp4.add(jb5, gbcjb5);
		this.add(jp4, BorderLayout.WEST);
		
		this.setBounds(10,  10,  1000,  500);
		this.setVisible(true);
		
		rsins = new RecepteurSaisieInstruction();
		rsing = new RecepteurSaisieIngredients();
		
		rsing.addWindowListener(this);
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
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		if(arg0.getSource() == rsing) {
			System.out.println("rsing fermée vu depuis rsg");
			ingredients = rsing.getListIngredient();
			System.out.println(ingredients);
			liste1.removeAll();
			for(Ingredient i : ingredients) {
				liste1.add(i.getNomIng()+" "+i.getQteIng());
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		
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
