package swing;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import metier.InputControler;
import metier.Ingredient;

public class RecepteurSaisieIngredients extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JButton btnAjout;
	private JButton btnSupprime;
	private JButton btnToutSupprime;
	private JButton btnValide;
	private List liste;
	private List liste2;
	private JComboBox comboBox;
	private boolean sendIngredient = false;
	private java.util.List<Ingredient> ingredients;
	

	
	/**
	 * Create the frame.
	 */
	public RecepteurSaisieIngredients() {
		ingredients = new ArrayList<Ingredient>();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{46, 86, 46, 0};
		gbl_panel_1.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Ingredient \u00E0 ajouter");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Nom de l'ingr\u00E9dient");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("quantit\u00E9");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		this.comboBox = new JComboBox();
		this.comboBox.setModel(new DefaultComboBoxModel(new String[] {"Litre", "Gramme", "Unit\u00E9"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		panel_1.add(comboBox, gbc_comboBox);
		
		this.btnAjout = new JButton("Ajouter l'ingredient");
		this.btnAjout.addActionListener(this);
		GridBagConstraints xbtnAjout = new GridBagConstraints();
		xbtnAjout.fill = GridBagConstraints.HORIZONTAL;
		xbtnAjout.insets = new Insets(0, 0, 5, 5);
		xbtnAjout.gridx = 0;
		xbtnAjout.gridy = 4;
		panel_1.add(this.btnAjout, xbtnAjout);
		
		btnSupprime = new JButton("Supprimer selection");
		btnSupprime.addActionListener(this);
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.gridx = 0;
		gbc_btnSupprimer.gridy = 5;
		panel_1.add(btnSupprime, gbc_btnSupprimer);
		
		btnToutSupprime = new JButton("Tout supprimer");
		btnToutSupprime.addActionListener(this);
		GridBagConstraints gbc_btnToutSupprimer = new GridBagConstraints();
		gbc_btnToutSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnToutSupprimer.gridx = 0;
		gbc_btnToutSupprimer.gridy = 6;
		panel_1.add(btnToutSupprime, gbc_btnToutSupprimer);
		
		btnValide = new JButton("Valider ingredients");
		btnValide.addActionListener(this);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 12;
		panel_1.add(btnValide, gbc_btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout());
		
		liste = new List();
		panel_2.add(liste);
		
		liste2 = new List();
		panel_2.add(liste2);
		
		//this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed");
		if(e.getSource() == btnAjout) {
			if( 	! InputControler.isUniform(textField.getText(), ' ')
					&& ! textField.getText().isEmpty()
					&& ! textField_2.getText().isEmpty()
					&& InputControler.isNumeric(textField_2.getText())) {
				liste.add(textField.getText());
				liste2.add(textField_2.getText()+" "+comboBox.getItemAt(comboBox.getSelectedIndex()));
				textField.setText("");
				textField_2.setText("");
			}
		}
		if(e.getSource() == btnSupprime) {
			System.out.println("supprime");
			if(liste.getSelectedIndex() != -1) {
				liste2.remove(liste.getSelectedIndex());
				liste.remove(liste.getSelectedIndex());
			}
		}
		
		if(e.getSource() == btnToutSupprime) {
			liste.removeAll();
			liste2.removeAll();
		}
		
		if(e.getSource() == btnValide) {
			System.out.println("valide");
			ingredients = new ArrayList<Ingredient>();
			for(int i=0; i<liste.getItemCount(); i++) {
				ingredients.add(new Ingredient(liste.getItem(i), liste2.getItem(i)));
			}
			//System.out.println(ingredients);
			this.dispose();
		}
		
	}
	
	java.util.List<Ingredient> getListIngredient(){
		return ingredients;
	}
	
}
