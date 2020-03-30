package interfacePackage.authentification;
import sourcePackage.*;

public class AuthModel {
    private Jeux jeux;
    public AuthModel(){
        this.jeux = new Jeux();
    }

    public Jeux getJeux() {
        return jeux;
    }
}
