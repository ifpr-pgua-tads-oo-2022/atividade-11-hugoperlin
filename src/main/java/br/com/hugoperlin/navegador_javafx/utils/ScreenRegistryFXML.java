package br.com.hugoperlin.navegador_javafx.utils;


import java.net.URL;

import javafx.scene.Parent;
import javafx.util.Callback;

public class ScreenRegistryFXML extends BaseScreenRegistry {
    
    private final URL fxml;
    private final Callback controler;
    
    public ScreenRegistryFXML(URL fxmlResource, Callback controler) {
        this.fxml = fxmlResource;
        this.controler = controler;
    }

    public Parent getRoot(){
        return LoaderFxml.load(fxml, controler);        
    }

}
