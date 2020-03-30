package sourcePackage;

import java.util.*;

public class Mot {

    /**************** les atributs *****************/

    private String mot;
    private Case[] lettres;
    private int nbLetNonTraites;
    private Indication indication;
    private final int maxZeroPropo = 3;
    private int nbCaseMultiPropo;
    private int score;
    private boolean perdu = false;
    private boolean traite = false;

    /****************    le constructeur *****************/

    public Mot(String mot, Indication indic){
        this.mot = mot.toUpperCase();
        this.indication = indic;
        score = 0;
        nbLetNonTraites = mot.length();
        perdu = false;
        traite = false;
        lettres = aleaCaseTab();
    }

    /*************** Les setters/gtters *************/


    public int getNbCaseMultiPropo() {
        return nbCaseMultiPropo;
    }

    public boolean isTraite() {
        return traite;
    }

    public int getScore() {
        return score;
    }

    public boolean isPerdu() {
        return perdu;
    }

    public void setPerdu(boolean perdu) {
        this.perdu = perdu;
        this.traite = true;
    }

    public void setTraite(boolean traite) {
        this.traite = traite;
    }

    public Case getCaseAt(int indice){
        return lettres[indice];
    }

    public String getMot() {
        return mot;
    }

    public String getIndication() {
        return indication.toString();
    }


    /**************** Les methodes *****************/

    // Role: génère une case de type aléatoire
    public void calculScore(){
        for(Case lettre : lettres)
            score += lettre.getScore();
        score *= indication.getCoeff();

        if(nbCaseMultiPropo > 5){
            for(Case lettre : lettres)
                score += lettre.getMalus();
        }
    }

    // Role: décrémonte le nombre des mots non traités
    public void decNbLetNonTraites(){
        nbLetNonTraites --;
        if(nbLetNonTraites == 0)
            traite = true;
    }

    // Role: convèrte une ligne du fichier à un objet Mot
    public static Mot toMot(String ligne){

        String typeIndic, indic ,mot ;
        int index1,index2;
        index1 = ligne.indexOf(';');
        index2 = ligne.lastIndexOf(';');
        typeIndic = ligne.substring(0, index1);
        indic = ligne.substring(index1 + 1, index2);
        mot = ligne.substring(index2 + 1, ligne.length());
        return new Mot(mot, new Indication(typeIndic,indic));
    }

    // Role: crée un tableau de cases aléatoire à partir du mot
    private Case[] aleaCaseTab(){

        int i,zeroPropo = 0;

        Case[] cases = new Case[mot.length()];
        for(i = 0; i < mot.length(); i++){
            cases[i] = Case.aleaCase(mot.charAt(i), this);
            if (cases[i].getCoeff() > 1)
                zeroPropo ++;

            while((cases[i].getCoeff() > 1) && (zeroPropo >  maxZeroPropo)) // on teste que le nombre de case 0 chance n' a pas dépassé le max
                cases[i] = Case.aleaCase(mot.charAt(i), this);

            if (cases[i].getCoeff() < 3)
                nbCaseMultiPropo++;
        }

        return cases;
    }

    public String toString(){
        return indication.toString() + "   "+ mot;
    }
}