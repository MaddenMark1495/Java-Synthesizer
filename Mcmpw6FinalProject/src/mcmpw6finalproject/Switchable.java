/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcmpw6finalproject;

import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author markmadden
 */

public abstract class Switchable {
    private static Scene scene;
    private static final HashMap<String, Switchable> controllers = new HashMap<>();
    
    private Parent root;
    
    public static void setScene(Scene scene){
        Switchable.scene = scene;
    }
    public static  Scene getScene(){
        return scene;
    }
    public static Switchable add(String name){
        Switchable controller;
        controller = controllers.get(name);
       
        if(controller == null){
            try{
                FXMLLoader loader = new FXMLLoader(Switchable.class.getResource(name + ".fxml"));
                Parent root = (Parent)loader.load();
                controller = (Switchable)loader.getController();
                controller.setRoot(root);
                controllers.put(name, controller);   
            }catch(Exception ex){
                controller = null;
                System.out.println(ex);
            }
            
        }
        return controller;
    }
    
    public static void switchTo(String name){
        
        Switchable controller = controllers.get(name);
       
        if(controller == null){
            controller = add(name);
        }
        if(controller != null){
            if(scene != null){
                scene.setRoot(controller.getRoot());
            }
        }
    }
    public void setRoot(Parent root){
        this.root = root;
    }
    public Parent getRoot(){
        return root;
    }
}