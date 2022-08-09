package br.com.hugoperlin.navegador_javafx.exemplos.fxml;



import br.com.hugoperlin.navegador_javafx.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaPrincipal {
    

    @FXML
    private void mostraParte1(ActionEvent evt){
        App.changeScreenRegion(App.PARTE1, BorderPaneRegion.CENTER);
    }

    @FXML
    private void mostraParte2(ActionEvent evt){
        App.changeScreenRegion(App.PARTE2, BorderPaneRegion.CENTER);
    }

    @FXML
    private void mostraTela1(ActionEvent evt){
        App.pushScreen(App.TELA1);
    }


}
