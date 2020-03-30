package interfacePackage;

import interfacePackage.aideDeJeux.AideController;
import interfacePackage.authentification.*;
import interfacePackage.finDeJeux.ResultatController;
import interfacePackage.menuPrincipale.MenuController;
import interfacePackage.scenePrincipale.JeuView;
import javafx.application.Application;
import javafx.stage.Stage;
import sourcePackage.Session;

public class Main extends Application {
    public static Stage primaryStage;
    public static Stage exceptionStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        showAuthentification();
    }

    public static void showAuthentification(){
        AuthView view = new AuthView(primaryStage);
        AuthModel model = new AuthModel();
        AuthController controller=new AuthController(model,view);
        controller.control();
    }

    public static void showJNFException(String message){
        exceptionStage = new Stage();
        WarnController controller = new WarnController(exceptionStage,message);
        controller.control();
    }

    public static void showEPException(String message){
        exceptionStage = new Stage();
        WarnController controller = new WarnController(exceptionStage,message);
        controller.control();
    }

    public static void showWPException(String message){
        exceptionStage = new Stage();
        WarnController controller = new WarnController(exceptionStage,message);
        controller.control();
    }

    public static void showMenuPrincipale(Session session){
        MenuController controller = new MenuController(primaryStage,session);
        controller.control();
    }

    public static void showScenePrincipale(Session session){
        JeuView controller = new JeuView(primaryStage,session);
    }

    public static void showAide(){
        exceptionStage = new Stage();
        AideController controller = new AideController(exceptionStage);
        controller.control();
    }

    public static void showResultat(Session session){
        ResultatController controller = new ResultatController(primaryStage,session);
        controller.control();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
