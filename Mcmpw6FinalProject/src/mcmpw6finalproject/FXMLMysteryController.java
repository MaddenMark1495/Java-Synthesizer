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
import java.util.Random;
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
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import static mcmpw6finalproject.Switchable.switchTo;

/**
 * FXML Controller class
 *
 * @author markmadden
 */
public class FXMLMysteryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    private Mystery mystery;
    
    private TextField noteTextFieldMystery;
    
     private Stage stage;
     
     Random rm = new Random();
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mystery = new Mystery();
        mystery.setInstrument();
        mystery.setInstrument();
        mystery.setChannel(rm.nextInt(9));
        mystery.setDuration(200);
        mystery.setVolume(40);
    }    
    
    @FXML
    private void handlePlayMidC(ActionEvent event){
        
        int note = 60;
        mystery.playNote(note);
        
    }
    @FXML
    private void handlePlayD(ActionEvent event){
        
        int note = 62;
        mystery.playNote(note);
             
        
    }    
    @FXML
    private void handlePlayE(ActionEvent event){
        
        int note = 64;
        mystery.playNote(note);
        
    }
    @FXML
    private void handlePlayF(ActionEvent event){
        
        int note = 65;
        mystery.playNote(note);
        
    }
    @FXML
    private void handlePlayG(ActionEvent event){
        
        int note = 68;
        mystery.playNote(note);
        
    }
    @FXML
    private void handlePlayA(ActionEvent event){
        
        int note = 69;
        mystery.playNote(note);
        
    }
    @FXML
     private void handlePlayB(ActionEvent event){
         
        int note = 71;
        mystery.playNote(note);
    }
    @FXML
     private void handlePlayC(ActionEvent event){
        
        int note = 72;
        mystery.playNote(note);
        
    }
    @FXML
     private void handlePlayCSharp(ActionEvent event){
        
        int note = 61;
        mystery.playNote(note);
        
    }
     
     @FXML
     private void handlePlayDSharp(ActionEvent event){
        
        int note = 63;
        mystery.playNote(note);
     }
     
     @FXML
     private void handlePlayFSharp(ActionEvent event){
        
        int note = 66;
        mystery.playNote(note);
     }
     
     @FXML
     private void handlePlayGSharp(ActionEvent event){
        
        int note = 68;
        mystery.playNote(note);
     }
     
     @FXML
     private void handlePlayASharp(ActionEvent event){
        
        int note = 70;
        mystery.playNote(note);
     }
     
     
     @FXML 
     private void handleSave(ActionEvent event){
         
        CharSequence saveData = noteTextFieldMystery.getCharacters();
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
                Logger.getLogger(FXMLPianoController.class.getName()).log(Level.SEVERE, null, ioex);
            }
             
         }
         
         
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
    private void handleHome(ActionEvent event){
        
        switchTo("FXMLMainScreen");
        
        
    }
    @FXML
    private void handleClose(ActionEvent event){
        
        Platform.exit();
        
        
    }
    
}
