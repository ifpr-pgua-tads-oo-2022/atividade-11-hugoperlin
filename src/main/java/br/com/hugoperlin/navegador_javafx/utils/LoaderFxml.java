package br.com.hugoperlin.navegador_javafx.utils;

import java.io.IOException;
import java.net.URL;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Callback;

public class LoaderFxml {
    

    public static Parent load(URL fxml, Callback controlerMaker){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(fxml);
            loader.setControllerFactory(controlerMaker);

            Parent root = loader.load();

            return root;
        }catch(IOException e){
            System.out.println("PROBLEMA AO CARREGAR O FXML!!! O arquivo "+fxml+" existe?");
            e.printStackTrace();
            Platform.exit();
        }
        return null;
        
    }
}
