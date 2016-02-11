/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcmpw6finalproject;

import java.io.File;
import java.io.FileNotFoundException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static mcmpw6finalproject.Switchable.switchTo;

/**
 * FXML Controller class
 *
 * @author markmadden
 */
public class FXMLPianoController extends Switchable implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    private Stage stage;
    
    @FXML
   private TextField noteTextField;
    
   private Piano piano;
   Random rm = new Random();

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        piano = new Piano();
        piano.setInstrument();
        piano.setInstrument();
        piano.setDuration(200);
        piano.setVolume(80);
    }    
    
    @FXML 
    private void handleinstrumentdrums(ActionEvent event){
        piano.setChannel(9);
    }
    
     @FXML 
    private void handleinstrumentpiano(ActionEvent event){
        piano.setChannel(0);
    }
    
    
     @FXML 
    private void handleinstrumentrandom(ActionEvent event){
        
        piano.setChannel(rm.nextInt(9));
        
        System.out.print(rm.nextInt(10));
        
    }
    
    
    
    @FXML
    private void handlePlayMidC(MouseEvent event){
        
        int note = 60;
        piano.playNote(note);
        noteTextField.setText("C4");
        
    }
    
    @FXML
    private void handlePlayD(MouseEvent event){
        
        int note = 62;
        piano.playNote(note);
        noteTextField.setText("D4");    
        
    }   
    
    @FXML
    private void handlePlayE(MouseEvent event){
        
        int note = 64;
        piano.playNote(note);
        noteTextField.setText("E4"); 
    }
    
    @FXML
    private void handlePlayF(MouseEvent event){
        
        int note = 65;
        piano.playNote(note);
        noteTextField.setText("F4");
        
    }
    
    @FXML
    private void handlePlayG(MouseEvent event){
        
        int note = 67;
        piano.playNote(note);
        noteTextField.setText("G4");
        
    }
    
    @FXML
    private void handlePlayA(MouseEvent event){
        
        int note = 69;
        piano.playNote(note);
        noteTextField.setText("A4");
    }
    @FXML
     private void handlePlayB(MouseEvent event){
         
        int note = 71;
        piano.playNote(note);
        noteTextField.setText("A4");
    }
    @FXML
     private void handlePlayC(MouseEvent event){
        
        int note = 72;
        piano.playNote(note);
        noteTextField.setText("A5");
    }
     
     
    @FXML
     private void handlePlayCSharp(MouseEvent event){
        
        int note = 61;
        piano.playNote(note);
        noteTextField.setText("C4#");
        
    }
     
     @FXML
     private void handlePlayDSharp(MouseEvent event){
        
        int note = 63;
        piano.playNote(note);
         noteTextField.setText("D4#");
     }
     
     @FXML
     private void handlePlayFSharp(MouseEvent event){
        
        int note = 66;
        piano.playNote(note);
         noteTextField.setText("F4#");
     }
     
     @FXML
     private void handlePlayGSharp(MouseEvent event){
        
        int note = 68;
        piano.playNote(note);
         noteTextField.setText("G4#");
     }
     
     @FXML
     private void handlePlayASharp(MouseEvent event){
        
        int note = 70;
        piano.playNote(note);
         noteTextField.setText("A4#");
     }
     
     
     
     
     @FXML 
     private void handleSave(ActionEvent event){
         
        CharSequence saveData = noteTextField.getCharacters();
         if(saveData == null){
            
             return;
         }
         
         FileChooser filechooser = new FileChooser();
         File file = filechooser.showSaveDialog(stage);
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
    private void handleAbout(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Final Project");
        alert.setContentText("This application was developed by Mark Madden");
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
    
