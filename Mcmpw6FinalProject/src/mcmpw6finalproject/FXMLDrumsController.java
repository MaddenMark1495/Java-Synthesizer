/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcmpw6finalproject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static mcmpw6finalproject.Switchable.switchTo;

/**
 * FXML Controller class
 *
 * @author markmadden
 */
public class FXMLDrumsController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     * 
     * 
     */
    private Stage stage;
    
    private Drums drums;
    
    @FXML
    private TextField noteTextFieldDrums;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       drums = new Drums();
       drums.setInstrument();
       drums.setChannel(9);
       drums.setDuration(200);
       drums.setVolume(60);
       
    }    
    
    @FXML
    private void handlePlayMidC(MouseEvent event){
       
      int note = 60;
      drums.playNote(note);
        
    }
    @FXML
    private void handlePlayG(MouseEvent event){
        
      int note = 62;
      drums.playNote(note);
             
        
    }    
    @FXML
    private void handlePlayE(MouseEvent event){
      
      int note = 64;
      drums.playNote(note);
        
    }
    @FXML
    private void handlePlayF(MouseEvent event){
         
      int note = 66;
      drums.playNote(note);
        
        
    }
    @FXML
    private void handlePlayA(MouseEvent event){
        
      int note = 70;
      drums.playNote(note);
    }
 
    @FXML
    private void handleSave(ActionEvent event){
        
         CharSequence saveData = (String)noteTextFieldDrums.getCharacters();
         if(saveData == null){
             return;
         }
         
         FileChooser filechooser = new FileChooser();
         File file = filechooser.showOpenDialog(stage);
         if (file != null){
             try{
                 PrintWriter out = new PrintWriter(file.getPath());
                 out.print(saveData);
                 out.close();
             } catch (IOException ioex) {
                System.out.println(ioex);
            }
             
         }
           
        
        
    }
    
    @FXML
    private void handleHome(ActionEvent event){
        
        switchTo("FXMLMainScreen");
        
        
    }

    @FXML
    private void handleClose(ActionEvent event){
        
         Platform.exit();
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
}    