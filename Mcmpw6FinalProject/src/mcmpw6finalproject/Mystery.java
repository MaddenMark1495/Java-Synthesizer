/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcmpw6finalproject;

import static java.lang.Math.random;
import java.util.Random;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

/**
 *
 * @author markmadden
 */
class Mystery implements Instrument {

    
     int channel = 0;
     int volume = 0; // between 0 and 127
     int duration = 0;
     MidiChannel[] channels;
     
 

     public Mystery(){
    
}
     public void setChannel(int channel){
         
         this.channel = channel;
         
     }
     
     public void setVolume(int volume){
         this.volume = volume;
     }
     
     public void setDuration(int duration){
         this.duration = duration;
     } 
    
    
    
    
    
   
   @Override
   public void setInstrument() {
           
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            channels = synth.getChannels();
            
        } catch (Exception e) {
             System.out.println(e);
        }
         
     
    }

    @Override
    public void playNote(int note) {
            channels[channel].noteOn(note,volume);
         try {
             Thread.sleep(duration);
         } catch (Exception e) {
             System.out.println(e);
         }
         channels[channel].noteOff( note );
     
    }

    
}
