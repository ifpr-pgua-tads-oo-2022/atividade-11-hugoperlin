package br.com.hugoperlin.navegador_javafx.exemplos.fxml;

import br.com.hugoperlin.navegador_javafx.utils.BaseAppNavigator;
import br.com.hugoperlin.navegador_javafx.utils.BaseScreenRegistry;
import br.com.hugoperlin.navegador_javafx.utils.ScreenRegistryFXML;

public class App extends BaseAppNavigator{

    public static final ScreenRegistryFXML PRINCIPAL = new ScreenRegistryFXML(App.class.getResource("telas/principal.fxml"),o->new JanelaPrincipal());
    public static final ScreenRegistryFXML PARTE1 = new ScreenRegistryFXML(App.class.getResource("telas/parte1.fxml"),o->new Parte1());
    public static final ScreenRegistryFXML PARTE2 = new ScreenRegistryFXML(App.class.getResource("telas/parte2.fxml"),o->new Parte2());
    public static final ScreenRegistryFXML TELA1 = new ScreenRegistryFXML(App.class.getResource("telas/tela1.fxml"),o->new Tela1());

    @Override
    public BaseScreenRegistry getHome() {
        return PRINCIPAL;
    }

    @Override
    public String getAppTitle() {
        return "Teste";
    }


    
}
