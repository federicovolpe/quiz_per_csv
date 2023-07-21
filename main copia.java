import java.io.BufferedReader;
import java.io.FileReader;          
import java.io.IOException;                                                                         
import java.util.ArrayList;                                                                         
import java.util.InputMismatchException;                                                            
import java.util.Random;                                                                            
import java.util.Scanner;                                                                           
                                                                                                    
public class main{                                                                                  
    public static void main(String[] args){                                                         
                                                                                                    
        System.out.println("scegli la modalità: \na -> scelta multipla \nb -> domande a risposta aperta");
        Scanner sc = new Scanner(System.in);                                                        
        String modalità = sc.nextLine();                                                            
                                                                                                    
        if(modalità.equals("a")){                                                                   
                                                                                                    
        //lettura del csv                                                                           
        String csvFile = "./domande.csv";                                                           
        String line;                                                                                
        int conta_corrette = 0;                                                                     
        int conta_sbagliate = 0;                                                                    
                                                                  
        ArrayList<domanda> domande = new ArrayList<domanda>();    
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {              
                //arry di stringhe con i dati                     
                String[] data = line.split(";");
                System.out.println("genero la domanda numero: " + data[0] );
                //riempimento dell'arraylist
                domande.add(new domanda(data[0],data[1],data[2],data[3],data[4],data[5],data[6]));
            }                             
        } catch (IOException e) {         
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
            System.out.println(domande.get(n).toString());
                                                          
            Scanner in = new Scanner(System.in);          
            int selezione = in.nextInt();                 
            //read next int                               
            try{                                          
                while(selezione > 4 || selezione < 1 ){   
                    System.out.println(selezione + "non è una opzione disponibile");
                    selezione = in.nextInt();             
                }                                         
            }catch (InputMismatchException e) {           
                System.out.println("bravo, hai rotto il gioco !");
            }                                
            
            //se la risposta è giusta
            if(domande.get(n).verificaRisposta(selezione)){
                //clear the screeen
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("--------------------------------------------------------------------------");
                System.out.println("la risposta è corretta");

                //incremento il contatore delle risposte corrette
                conta_corrette++;
                System.out.println("risposte corrette " + conta_corrette +"/" + numeroTotaleDomande + " sbagliate " + conta_sbagliate + "\n");
                System.out.println("--------------------------------------------------------------------------");
                
                //rimozione della domanda
                            domande.remove(n);
                            System.out.println("domanda "+n+" rimossa");
                
            }else{
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

                System.out.println("la risposta è sbagliata, risposta corretta: \n" + domande.get(n).risposta + "\n");   
                
                conta_sbagliate++;
                System.out.println("risposte corrette: " + conta_corrette + "/" + numeroTotaleDomande +" sbagliate " + conta_sbagliate + "\n");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            }
            
        }
    }if(modalità.equals("b")){
    //lettura di una domanda dal csv
        final String csvFile = "./domande.csv";
        ArrayList<domandaAperta> domande = new ArrayList<>();
        String line;
        int conta_corrette = 0;
        int conta_sbagliate = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while((line = br.readLine()) != null){
                String[] data = line.split(";");
                System.out.println("generata la domanda: "+ data[0]);
                domande.add(new domandaAperta(data[0], data[1], data[6]));
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
}
