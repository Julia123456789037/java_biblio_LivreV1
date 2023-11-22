package projet_java.Bibli.java_biblio_LivreV1;

import java.awt.event.*;
import javax.swing.*;

public class PanelAction extends JPanel implements ActionListener
{
	private  Controleur ctrl;
	private  JButton	btnSauvegarder;
	private  JButton	btnCreer;
	private  JButton	btnSupp;
	private  JButton	btnRequete;

	public PanelAction (Controleur ctrl )
	{
		this.ctrl = ctrl;

		// crÃ©ation des composants
		this.btnSauvegarder	= new JButton ( "Sauvegarder" );
		this.btnCreer		= new JButton ( "Créer Livre" );
		this.btnSupp		= new JButton ( "Supprimer Livre" );
		this.btnRequete		= new JButton ( "Requête" );

		// Positionnement des composants
		this.add ( this.btnSauvegarder );
		this.add ( this.btnCreer );
		this.add ( this.btnSupp  );
		this.add ( this.btnRequete  );


		// Activation des composants
		this.btnSauvegarder	.addActionListener ( this );
		this.btnCreer		.addActionListener ( this );
		this.btnSupp		.addActionListener ( this );
		this.btnRequete		.addActionListener ( this );
	}


	public void actionPerformed ( ActionEvent e)
	{
		if (e.getSource() == this.btnCreer)
		{
			this.ctrl.creer();
		}

		if (e.getSource() == this.btnSauvegarder) 
		{
			this.ctrl.sauvegarder ();
		}

		if (e.getSource() == this.btnSupp)
		{
			//removeRow
			
		}

		if (e.getSource() == this.btnRequete)
		{
			//
		}
	}


}