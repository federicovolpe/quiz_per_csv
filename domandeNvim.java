import java.io.BufferedReader;           
import java.io.FileReader;               
import java.io.IOException;              
import java.util.ArrayList;              
import java.util.InputMismatchException; 
import java.util.Random;                          
import java.util.Scanner;                                              
                                                                       
public class domandeNvim{                                              
  public static void main(String[] args){                              
    //lettura del csv                                                  
    String csvFile = "./domandeVsVim.csv";                             
    String line;                                                       
    int conta_corrette = 0;                                            
    int conta_sbagliate = 0;                                           
    ArrayList<domandaAperta> domande = new ArrayList<domandaAperta>();                  
                                                                       
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      while((line = br.readLine()) != null){                           
        String[] data = line.split(";");                               
        System.out.println("generata la domanda: "+ data[0]);          
        domande.add(new domandaAperta(data[0], data[1], data[2]));     
      }                                                                
    }catch(IOException e){                                             
      e.printStackTrace();                                             
    }                                                                  
    int numeroTotaleDomande = domande.size();      
    System.out.println(domande.size() +" domande sono state caricate con successo");
                                                   
    //selezione di una domanda a caso              
    //while tthe arraylist is not empty            
    while(domande.size() > 0){                     
      //generazione di un numero casuale
      Random rand = new Random();
      int n = rand.nextInt(domande.size());
      System.out.println("numero estratto: " + n);

      //stampa della domanda
      System.out.println(domande.get(n).domanda());
      System.out.println("per visualizzare la risposta premi invio");

      Scanner in = new Scanner(System.in);
      in.nextLine();
      System.out.println("risposta:\n"+ domande.get(n).risposta()+"\n\n\n(premi a per risposta corretta, premi qualsiasi per risposta sbagliata)");

      String selezione = in.nextLine();

      /*raccolta dell'input la sai (a) o no (d)
            try{
                while(!(selezione.equals("a") || selezione.equals("d"))){
                    System.out.println(selezione + "non è una opzione disponibile");
                    selezione = in.nextLine();
                }                      
            }catch (InputMismatchException e) {
                System.out.println("bravo, hai rotto il gioco !");
            }*/                        
                                       
      //se la risposta è giusta        
      if(selezione.equals("a")){       
        //clear the screeen            
        System.out.print("\033[H\033[2J");
        System.out.flush();            
                                       
        System.out.println("--------------------------------------------------------------------------");
                                       
        //incremento il contatore delle risposte corrette
        conta_corrette++;              
        System.out.println("risposte corrette " + conta_corrette +"/" + numeroTotaleDomande + "\n");
        System.out.println("--------------------------------------------------------------------------");
                                       
        //rimozione della domanda      
        domande.remove(n);
        System.out.println("domanda "+n+" rimossa");

      }else{
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        conta_sbagliate++;
        System.out.println("risposte corrette: " + conta_corrette + "/" + numeroTotaleDomande +"\n");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
      }            
    }
  }
}
