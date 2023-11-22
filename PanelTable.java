package projet_java.Bibli;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;


public class PanelTable extends JPanel
{
	private Controleur ctrl;
	private JTable     tblGrilleDonnees;

	public PanelTable (Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setLayout ( new BorderLayout() );

		JScrollPane spGrilleDonnees;
		JPanel panelTmp = new JPanel ( new BorderLayout() );

		// CrÃ©ation des composants
		this.tblGrilleDonnees = new JTable ( new GrilleDonneesModel(ctrl) );
		this.tblGrilleDonnees.setFillsViewportHeight(true);

 		spGrilleDonnees   = new JScrollPane( this.tblGrilleDonnees );

		// positionnement des composants
		this.add ( spGrilleDonnees, BorderLayout.CENTER );
	}

	public void majModele ()
	{
		this.tblGrilleDonnees.setModel( new GrilleDonneesModel(ctrl) );
	}

}