package sourcePackage;
import java.util.Arrays;

public class Proposition extends ZeroChance implements Malus {

    /**************** les atributs *****************/

    private final int coeff = 2;
    private final int maxPropo = 4;
    private char[] propo; // utile au niveau de l'interface graphique//
    private final String color = "#ff4500";

    /****************    le constructeur *****************/

    public Proposition(char let,Mot mot){
        super(let,mot);
        propo = aleaPropo();
    }

    /**************** Les methodes *****************/

    public String getColor(){
        return color;
    }

    public int getCoeff() {
        return coeff;
    }

    // Role: calcule le score d'une case
    public boolean calculScore(char let) {

        setTraite(true);
        mot.decNbLetNonTraites();
        if (getLettre() == let)
            setScore(coeff);
        else {
            setPerdu(true);
            System.out.println("oui");
            mot.setPerdu(true);
            setMalus(-1);
        }
        return isTraite();
    }

    // Role: retourne le malus
    public int malus() {
        if (mot.getNbCaseMultiPropo() > 5)
            return -2;
        return 0;// si le nombre des cases multiChances et propositions est infèrieur a 6 pas de malus
    }

    // Role : genere un tableau de lettres 	aleatoire
    public char[] aleaPropo(){

        String alphabet = "AZERTYUIOPQSDFGHJKLMWXCVBN"; // unr str qui contient toutes les lettres de l'alphabet desordonnees
        int i = alphabet.indexOf(super.getLettre()); // on trouve la position de notre lettre dedans

        int pos =(int)((197/Math.random()) % maxPropo);// on choisit une potition aleatoire dans le tableau

        alphabet = "MWXCVBNAZERTYUIOPQSDFGHJKLMWXCVBNAZERTYU";
        String str = alphabet.substring(7 + i - (int)pos, 7+ i + maxPropo - (int)pos );

        char[]	propo = str.toCharArray();
        Arrays.sort(propo);
        return propo;
    }
}
