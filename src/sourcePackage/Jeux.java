package sourcePackage;

import sourcePackage.exceptions.ExistingPseudoException;
import sourcePackage.exceptions.JoueurNotFoundException;
import sourcePackage.exceptions.WrongPseudoException;

import java.io.*;
import java.util.Scanner;

public class Jeux {

	/**************** les atributs *****************/

	private static final String fichMots = "mots.txt";
	private static final String fichJoueurs = "joueurs.txt";
	private Joueur joueur;
	private Session session;
	private final static int nbLigs = 30;

	/**************** le constructeur *****************/

	public Jeux() {
		joueur = null;
		session = null;
	}

	/**************** Les methodes *****************/

	// Role: recherche un joueur dans le fichier des joueurs, renvoit un objet
	// joueur si il existe null si non

	public Joueur recherJoueur(String pseudo) {

		String line = "", bestScore = "", nonPsudo="";
		try {
			BufferedReader in = new BufferedReader(new FileReader(fichJoueurs));
			// tanque le fichier n'a pas encore fini
			while ((line = in.readLine()) != null) {
				// le test
				if (line.substring(0,line.indexOf(';')).equals(pseudo)) {
					in.close();
					nonPsudo = line.substring(line.indexOf(";")+1,line.length());
					bestScore = nonPsudo.substring(0,nonPsudo.indexOf(";"));
					return new Joueur(pseudo, Integer.parseInt(bestScore));
				}
			}
			in.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// Role: ajoute un joueur au fichier des joueurs renvoit une excepion si il existe
	// deja
	public Joueur addJoueur(String pseudo) throws WrongPseudoException, ExistingPseudoException {

		if (recherJoueur(pseudo) == null) {

			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(fichJoueurs, true));
				// on teste le syntaxe du pseudo
				if (Joueur.testPseudo(pseudo)) {
					out.write(pseudo + ";0;");
					out.newLine();
					out.close();
					return new Joueur(pseudo, 0);
				}
				// si le pseudo n'est pas bon
				else {
					out.close();
					throw new WrongPseudoException();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		throw new ExistingPseudoException();// joueur existant
	}

	// Role: login un joueur
	public void login(String pseudo) throws JoueurNotFoundException {
		
		joueur = recherJoueur(pseudo);
		if (joueur == null)
			throw new JoueurNotFoundException();
		this.session = new Session(joueur, aleaLignes(fichMots));
		
	}

	public Session getSession() {
		return session;
	}

	// Role: renvoit un tableau qui contients 10 lignes aleatoires du fichier des mots
	public static String[] aleaLignes(String fileName) {

		BufferedReader fr;
		String[] ligs = null;
		int[] numLignes = new int[Session.nbMot];
		int i, j;
		double lig;
		boolean existe = false;
		try {
			fr = new BufferedReader(new FileReader(fileName));
			ligs = new String[Session.nbMot];
			// on choisit les num�ros des lignes
			for (i = 0; i < Session.nbMot; i++) {
				existe = false;
				do {
					lig = (179 / Math.random()) % nbLigs;
					j = 0;
					while ((j < i) && !existe) {
						if (numLignes[j] == lig)
							existe = true;
						else j++;
					}
				} while (existe);
				numLignes[i] = (int) lig;
			}
			fr.close();
			// on remplit le tableau des lignes
			for (i = 0; i < Session.nbMot; i++) {
				fr = new BufferedReader(new FileReader(fileName));
				for (j = 0; j < numLignes[i]; j++)
					fr.readLine();
				ligs[i] = fr.readLine();
				fr.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ligs;
	}

	public static void suvgarderMeilleurScore(Joueur joueur){
		String ps = joueur.getPseudonyme();
		int score = joueur.getMielleurScore();
		try {
			boolean trouv = false;
			String line,scores;
			RandomAccessFile raf = new RandomAccessFile(fichJoueurs,"rw");
			line = raf.readLine();
			// tanque le fichier n'a pas encore fini
			while (line != null && !trouv) {
				if (line.substring(0,line.indexOf(';')).equals(ps)) {
					scores = line.substring(line.indexOf(";"), line.length());
					line = ps + ";" + Integer.toString(score) + scores;
					raf.writeBytes(line);
					trouv = true;
				}
				line = raf.readLine();
			}
			raf.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void suvgarderScore(Session session){
		String ps = session.getJoueur().getPseudonyme();
		int score = session.getScore();
		try {
			boolean trouv = false;
			String line,scores;
			RandomAccessFile raf = new RandomAccessFile(fichJoueurs,"rw");
			line = raf.readLine();
			// tanque le fichier n'a pas encore fini
			while (line != null && !trouv) {
				if (line.substring(0,line.indexOf(';')).equals(ps)) {
					line = line + score + ";";
					raf.writeBytes(line);
					trouv = true;
				}
				line = raf.readLine();
			}
			raf.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
