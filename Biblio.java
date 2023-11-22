package projet_java.Bibli;

import iut.algo.Decomposeur;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import iut.algo.*               ;


public class Biblio
{

	private List<Livre> lstLivre;

	public Biblio()
	{
		this.lstLivre = new ArrayList<Livre>();
		this.initTabLivres();
	}

	public void initTabLivres()
	{
		Scanner     scFic;
		Decomposeur dec;

		String      liv;
		boolean     bPremium;

		try
		{
			Scanner sc = new Scanner ( new FileInputStream ( "Livres.data" ), "UTF8" );

			while ( sc.hasNextLine() )
			{

				liv =  sc.nextLine() ;

				//                                    nom                prenom         premium     anneeAdh
				this.lstLivre.add ( new Livre ( dec.getString(0), dec.getString(1), dec.getString(2), dec.getString(3), dec.getString(4), dec.getInt(5), dec.getString(6) ) );
				System.out.println( dec.getString(0) + " " + dec.getString(1) + " " + dec.getString(4) + " " + dec.getString(5) + " " + dec.getString(6) );
			}

			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}


	public boolean majSatut ( int ligne, String val )
	{
		return this.lstLivre.get(ligne).setStatut ( val );
	}

	public boolean majNote ( int ligne, int val )
	{
		return this.lstLivre.get(ligne).setNote ( val );
	}

	public boolean majDetNot ( int ligne, String val )
	{
		return this.lstLivre.get(ligne).setDetailNote ( val );
	}

	public void ajouterLivre (String tit, String ecri1, String ecri2, String edit, String stat, int not, String detNote )
	{
		this.lstLivre.add(new Livre (tit, ecri1, ecri2, edit, stat, not, detNote ));

		this.sauvegarder();

		System.out.println("Livre : OK");


	}

	public void sauvegarder()
	{

		try
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Livres.data"), "UTF8" ));

			for (Livre liv:this.lstLivre )
			{
				pw.println ( liv.getTitre ()		+ "\t" +
				             liv.getEcrivain1 ()	+ "\t" +
				             liv.getEcrivain2 ()	+ "\t" +
							 liv.getEditeur ()		+ "\t" +
							 liv.getStatut ()		+ "\t" +
							 liv.getNote ()			+ "\t" +
				             liv.getDetailNote () );
			}
			pw.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}


	public List<Livre> getLivres()
	{
		return new ArrayList<Livre>( this.lstLivre );
	}


	public String toString()
	{
		String sRet = "";

		for ( Livre clt: this.lstLivre )
			sRet += clt.toString() + "\n";

		return sRet;
	}
}


