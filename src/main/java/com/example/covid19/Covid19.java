/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.covid19;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author James.J
 */
public class Covid19 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Covid.fxml"));
        
        Scene scene = new Scene(root);

        new Thread(() -> {
            OperationPerform.getOperationPerform();

        }).start();
        
       /* root.setOnMousePressed((MouseEvent e)->{
            xpos=e.getSceneX();
            ypos=e.getSceneY();
            
        });
        root.setOnMouseDragged((MouseEvent e)->{
           stage.setX(e.getSceneX()-xpos);
           stage.setY(e.getSceneY()-ypos);
        });*/
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
