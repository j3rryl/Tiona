package com.tione.tiona.HelperClass;

import com.tione.tiona.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.net.URL;

public class ViewLoader {
    private VBox vBox;
    public VBox getPage(String filename){
        try {
            URL fileUrl = HelloApplication.class.getResource("Admin/" + filename + ".fxml");
            if(filename==null){
                System.out.println("FXML file cannot be found");
            }
            vBox=new FXMLLoader().load(fileUrl);
        } catch(Exception e){
            System.out.println("FXML file cannot be found in Exception.");
        }
        return vBox;
    }
}
