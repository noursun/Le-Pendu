package interfacePackage.authentification;
import interfacePackage.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import sourcePackage.exceptions.ExistingPseudoException;
import sourcePackage.exceptions.JoueurNotFoundException;
import sourcePackage.exceptions.WrongPseudoException;

public class AuthController {
    private AuthModel model;
    private AuthView view;

    public AuthController(AuthModel model, AuthView view){
        this.model = model;
        this.view = view;
    }
    public void control(){
        view.getStartPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String ps = view.getPsudoInput().getText();
                commencer(ps);
            }
        }
        );
        view.getNewPsudo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String ps = view.getPsudoInput().getText();
                creerPsudo(ps);
            }
        }
        );
    }
    private void commencer(String ps){
        try {
            model.getJeux().login(ps);
            Main.showMenuPrincipale(model.getJeux().getSession());
        } catch (JoueurNotFoundException e) {
            Main.showJNFException(e.getMessage());
        }
    }
    private void creerPsudo(String ps){
        try {
            model.getJeux().addJoueur(ps);
            model.getJeux().login(ps);
            Main.showScenePrincipale(model.getJeux().getSession());
        } catch (JoueurNotFoundException e) {
            Main.showJNFException(e.getMessage());
        }
        catch (ExistingPseudoException e){
            Main.showEPException(e.getMessage());
        }
        catch (WrongPseudoException e){
            Main.showWPException(e.getMessage());
        }
    }
}
