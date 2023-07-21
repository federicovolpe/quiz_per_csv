package domande;
import java.io.BufferedReader;                                                    
import java.io.IOException;       
import java.io.InputStream;       
import java.io.InputStreamReader;
import java.util.ArrayList;                                                       
                                                                                                 
public class Main {                                                                             
                                                                                                 
    public static void main(String[] args) {                                                     
                                                                                   
        /*try {                                                                      
            PrintStream out = new PrintStream(new FileOutputStream("output.log")); 
            System.setOut(out);                                                                                                                          
        } catch (FileNotFoundException e) {                                                                                                              
            e.printStackTrace();                                                                                                                         
        } */                                                                                                                                             
                                                                                                                                                         
        String currentDirectory = System.getProperty("user.dir");                                                                                        
        System.out.println("Current working directory: " + currentDirectory);                                                                            
                                                                                                                                                         
        //estrazione delle domande                                                                                                                       
        //String csvFile = "./src/main/java/resources/domande.csv";                                                  
        String line;                                                                                                                                     
        String csvSeparator = ";";                                                                                                                       
                                                                                                                                                         
        ArrayList<Domanda> domande = new ArrayList<Domanda>();                                                                                           
        try (InputStream inputStream = Main.class.getResourceAsStream("/domande.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {             
                                                                                                       
            while ((line = br.readLine()) != null) {                                                   
                String[] data = line.split(csvSeparator);                                              
                domande.add(new Domanda(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
            }                                                                                          
                                                                                                       
            LaunchPage l = new LaunchPage(domande);                                                    
                                                                                                       
        } catch (IOException e) {                                                                      
            e.printStackTrace();                                    
        }                                                                                                                                                 
        /*try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {                                                                          
            while ((line = br.readLine()) != null) {                                                                                                     
                String[] data = line.split(csvSeparator);                                                                                                
                domande.add(new Domanda(data[0],data[1],data[2],data[3],data[4],data[5],data[6]));                                                       
            }                                                                                                                                            
                                                                                                                                                 
        } catch (IOException e) {                                                                                   
            e.printStackTrace();                                                                                    
        } */                                                                                                          
                                                                                                                    
        LaunchPage l = new LaunchPage(domande);                                                                                                          
    }                                                                                                               
}                                                                                                                   