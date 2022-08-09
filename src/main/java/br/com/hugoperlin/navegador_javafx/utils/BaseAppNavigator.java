package br.com.hugoperlin.navegador_javafx.utils;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Classe responsável por criar uma aplicação que permite a 
 * troca do conteúdo da janela. Deve ser extendida por outra classe.
 * Para cada janela da aplicação deve ser criado um atributo final
 * do tipo Parent ou ScreenRegistry. Exemplo:
 * 
 * public static final ScreenRegistry TELA_PRINCIPAL = new ScreenRegistry("fxml/principal.fxml",o->new Principal());
 * 
 */


public abstract class BaseAppNavigator extends Application{

    private static StackPane root;
    private static Scene cena;
    private Stage palco;

    @Override
    public final void start(Stage primaryStage) throws Exception {

        root = new StackPane();

        pushScreen(getHome());

        cena = new Scene(root,Region.USE_PREF_SIZE,Region.USE_PREF_SIZE);
        this.palco = primaryStage;

        this.palco.setScene(cena);
        this.palco.setTitle(getAppTitle());
        this.palco.show();
    }

    /**
     * Método responsável por trocar todo o conteúdo da janela por uma
     * nova cena. A nova cena será empilhada sobre a cena anterior,
     * e a cena anterior ficará invisível.     * 
     * 
     * @param screen Objeto do tipo BaseScreenRegistry que indica qual é o root da tela.
     */

    public final static void pushScreen(BaseScreenRegistry screen){
        if(root.getChildren().size() > 0){
            root.getChildren().get(root.getChildren().size()-1).setVisible(false);
        }

        Parent tela = screen.getRoot();
        root.getChildren().add(tela);
    }
       
    /***
     * Método responsável por desempilhar a tela que está no topo e mostrar
     * a tela anterior. Deve ser utilizado em conjunto com o pushScreen.
     */

    public final static void popScreen(){
        if(root.getChildren().size() < 2){
            throw new RuntimeException("NO SCREENS TO POP!!");
        }
        root.getChildren().remove(root.getChildren().size()-1);
        root.getChildren().get(root.getChildren().size()-1).setVisible(true);
    }

    /**
     * Método que permite substituir somente uma região da tela. Importante que
     * para o correto funcionamento, a tela que está sendo mostrada deve ter
     * como elemento root um objeto do tipo BorderPane.
     * 
     * @param screenPiece objeto que indica o fxml e seu controlador que será inseridos em 
     * uma parte da janela.
     * @param regiao localização onde a parte será inserida.
     */

    public final static void changeScreenRegion(BaseScreenRegistry screenPiece, BorderPaneRegion regiao){
        try{
            BorderPane borderPane = (BorderPane) root.getChildren().get(root.getChildren().size()-1);
            Parent root = screenPiece.getRoot();
            
            switch(regiao){
                case LEFT: 
                    borderPane.setLeft(root);
                break;
                case RIGHT: 
                    borderPane.setRight(root);
                break;
                case TOP: 
                    borderPane.setTop(root);
                break;
                case BOTTOM: 
                    borderPane.setBottom(root);
                break;
                case CENTER:
                    borderPane.setCenter(root);
                break;
                
            }
        }catch(Exception e){
            System.out.println("PROBLEMA AO CARREGAR O FXML!!! O root da cena é um BorderPane?");
            e.printStackTrace();
            Platform.exit();
        }
    }

    /**
     * Método responsável por indicar quel é a tela inicial da aplicação, 
     * utilizando uma classe
     * 
     * @return o Parent da tela inicial.
     */
    
    public abstract BaseScreenRegistry getHome();

    /**
     * Método que retorna o título da aplicação.
     * 
     * @return
     */
    public abstract String getAppTitle();


}
