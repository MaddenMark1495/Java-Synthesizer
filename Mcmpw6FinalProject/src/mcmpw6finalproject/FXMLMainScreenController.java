/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcmpw6finalproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author markmadden
 */

public class FXMLMainScreenController extends Switchable implements Initializable {
   
    
     private Stage stage;
    
     @FXML
     private Button Pianobutton;
     
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void handlePianoButtonAction(ActionEvent event){
        //System.out.println("HEre");
        switchTo("FXMLPiano");
       
    }
  
    @FXML
    private void handleDrumsButtonAction(ActionEvent event){
        System.out.println("HEre2");
        switchTo("FXMLDrums");
    }
    
    @FXML
    private void handleMysteryButtonAction(ActionEvent event){
        //System.out.println("HEre3");
        switchTo("FXMLMystery");
    }
    
    @FXML
    private void handleAbout(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Final Project");
        alert.setContentText("This application was developed by Mark Madden for CS3330 at the University of Missouri");
        TextArea textArea = new TextArea("This project has three different instruments. Piano, Drums and a mystery instrument");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);
        alert.getDialogPane().setExpandableContent(expContent);
        
        alert.showAndWait();
    }
    
    @FXML
    private void handleClose(ActionEvent event){
        
         Platform.exit();
         
    }
}

  
    