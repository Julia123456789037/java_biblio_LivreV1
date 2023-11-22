package projet_java.Bibli;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class GrilleDonneesModel extends AbstractTableModel
{
	private Controleur ctrl;

	private String[]   tabEntetes;
	private Object[][] tabDonnees;

	public GrilleDonneesModel (Controleur ctrl)
	{
		this.ctrl = ctrl;

		Livre liv;
		List<Livre> lstLivres = ctrl.getLivres();

		tabDonnees = new Object[lstLivres.size()][7];

		for ( int lig=0; lig<lstLivres.size(); lig++)
		{
			liv = lstLivres.get(lig);

			tabDonnees[lig][0] = liv.getTitre ();
			tabDonnees[lig][1] = liv.getEcrivain1 ();
			tabDonnees[lig][2] = liv.getEcrivain2 ();
			tabDonnees[lig][3] = liv.getEditeur ();
			tabDonnees[lig][4] = liv.getStatut ();
			tabDonnees[lig][5] = liv.getNote ();
			tabDonnees[lig][6] = liv.getDetailNote ();
		}

		this.tabEntetes = new String[]   {   "Titre" , "Ecrivain1", "Ecrivain2", "Editeur", "Statut", "Note", "Detail de Note"  };

	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabDonnees.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabDonnees[row][col];   }
	public Class  getColumnClass(int c)            { return getValueAt(0, c).getClass(); }

	public boolean isCellEditable(int row, int col)
	{
		return col == 4 || col == 5 || col == 6;
	}

	public void setValueAt(Object value, int row, int col)
	{
		boolean bRet;

		if ( col == 4 )
		{
			bRet = this.ctrl.majSatut ( row, (String) value );

			if ( bRet )
			{
				this.tabDonnees[row][col] = value;
				this.fireTableCellUpdated(row, col);
			}
		}

		if ( col == 5 )
		{
			bRet = this.ctrl.majNote ( row, (Integer) value);

			if ( bRet )
			{
				this.tabDonnees[row][col] = value;
				this.fireTableCellUpdated(row, col);
			}
		}

		if ( col == 6 )
		{
			bRet = this.ctrl.majDetNot ( row, (String) value);

			if ( bRet )
			{
				this.tabDonnees[row][col] = value;
				this.fireTableCellUpdated(row, col);
			}
		}


	}


}