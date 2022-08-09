package br.com.hugoperlin.navegador_javafx.exemplos.parent;


import br.com.hugoperlin.navegador_javafx.utils.Screen;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Tela1 extends Screen{
    
    private VBox root;
    private Text txtInfo;
    private Button btVoltar;

    public Tela1(){
        inicializa();
    }

    private void inicializa(){
        root = new VBox();

        txtInfo = new Text("Tela 1");
        btVoltar = new Button("Voltar");
        btVoltar.setOnAction(this::voltar);

        root.getChildren().addAll(txtInfo);
        root.getChildren().add(btVoltar);
    }

    private void voltar(ActionEvent evt){
        App.popScreen();
    }

    public Parent getRoot(){
        return root;
    }

    
}
