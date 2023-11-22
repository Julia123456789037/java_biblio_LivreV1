package projet_java.Bibli;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.Panel;


public class FrameRequete extends JFrame
{
	private Controleur  ctrl;
	private PanelTable  panel1;
	private PanelRequete panel2;


	public FrameRequete(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setSize ( 600, 250 );

		// CrÃ©ation des composants
		this.panel1 = new PanelTable  (this.ctrl);
		this.panel2 = new PanelRequete (this.ctrl);


		// Positionnement des composants


		this.add ( panel1, BorderLayout.CENTER );
		this.add ( panel2, BorderLayout.SOUTH  );

		this.setVisible ( true );

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void majModele()
	{
		this.panel1.majModele();
	}
}