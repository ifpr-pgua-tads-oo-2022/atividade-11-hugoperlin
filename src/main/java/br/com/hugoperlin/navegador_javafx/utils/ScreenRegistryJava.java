package br.com.hugoperlin.navegador_javafx.utils;


import javafx.application.Platform;
import javafx.scene.Parent;

public class ScreenRegistryJava extends BaseScreenRegistry {
    
    private final Class<? extends Screen> screen;
    
    public ScreenRegistryJava(Class<? extends Screen> screen) {
        this.screen = screen;
    }

    public Parent getRoot(){
        try{
            Screen temp = screen.getDeclaredConstructor().newInstance();
            return temp.getRoot(); 
        }catch(Exception e){
            e.printStackTrace();
            Platform.exit();
        }
        return null;
            
    }

}
