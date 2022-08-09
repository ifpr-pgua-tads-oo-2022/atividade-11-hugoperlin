package br.com.hugoperlin.navegador_javafx.exemplos.parent;

import br.com.hugoperlin.navegador_javafx.utils.BaseAppNavigator;
import br.com.hugoperlin.navegador_javafx.utils.BaseScreenRegistry;
import br.com.hugoperlin.navegador_javafx.utils.ScreenRegistryJava;

public class App extends BaseAppNavigator{

    public static final ScreenRegistryJava PRINCIPAL = new ScreenRegistryJava(JanelaPrincipal.class);
    public static final ScreenRegistryJava TELA1 = new ScreenRegistryJava(Tela1.class);
    public static final ScreenRegistryJava TELA2 = new ScreenRegistryJava(Tela2.class);


    @Override
    public BaseScreenRegistry getHome() {
        return PRINCIPAL;
    }

    @Override
    public String getAppTitle() {
        return "Teste";
    }
   

    public static void main(String[] args){
        launch(args);
    }



}
