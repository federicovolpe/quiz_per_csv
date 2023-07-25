package com;
import java.util.Arrays;
import java.util.Collections;                        
                                                     
public class Domanda {                               
    public String numero;                            
    public String domanda;                           
    public String[] opzioni = new String[4];         
    public String risposta;                          
    public String[] opzioniMescolate = new String[4];
                                                                     
    //costruttore                                                    
    public Domanda(String numero,String domanda, String opzione1, String opzione2, String opzione3, String opzione4, String risposta){
        this.numero = numero;                                        
        this.domanda = domanda;                                      
        this.opzioni[0] = opzione1;                                  
        this.opzioni[1] = opzione2;                                  
        this.opzioni[2] = opzione3;                                  
        this.opzioni[3] = opzione4;                                  
        this.risposta = risposta;                                    
        this.opzioniMescolate = Arrays.copyOf(opzioni, opzioni.length);
        Collections.shuffle(Arrays.asList(opzioniMescolate));        
    }                                                                
                                                                     
    @Override                                                        
    public String toString() {                                       
        String s = "Domanda numero: " + numero + "\nDomanda: " + domanda + 
            "\n\n[1] " + opzioniMescolate[0] +                       
            "\n\n[2] " + opzioniMescolate[1] +                       
            "\n\n[3] " + opzioniMescolate[2] +                       
            "\n\n[4] " + opzioniMescolate[3] + "\n";                 
        return s;                         
    }                                     
                                          
    public boolean verificaRisposta(int risposta){
        if(opzioniMescolate[risposta-1].equals(this.risposta)){
            return true;                  
        }                                 
        return false;                     
    }                                     
}                                         