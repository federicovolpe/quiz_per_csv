import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main{
    public static void main(String[] args){
        System.out.println("Hello World");
        //lettura del tsv
        String csvFile = "./nuovo.csv";
        String line;
        String csvSeparator = ";"; // Specify the separator used in your CSV file
        int conta_corrette = 0;
        int conta_sbagliate = 0;

        ArrayList<domanda> domande = new ArrayList<domanda>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                //arry di stringhe con i dati
                String[] data = line.split(csvSeparator);
                
                //riempimento dell'arraylist
                domande.add(new domanda(data[0],data[1],data[2],data[3],data[4],data[5],data[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("le domande sono state caricate con successo");
        
        //selezione di una domanda a caso
        //while tthe arraylist is not empty
        while(domande.size() > 0){
            //generazione di un numero casuale
            Random rand = new Random();
            int n = rand.nextInt(domande.size());
            
            //stampa della domanda
            System.out.println(domande.get(n).toString());
            
            //read next int
            Scanner in = new Scanner(System.in);
            int selezione = in.nextInt();
            
            //se la risposta è giusta
            if(domande.get(n).opzioni[selezione].equals(domande.get(n).risposta)){
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("la risposta è corretta");

                //rimuovo la domanda dall'arraylist
                domande.remove(n);

                //incremento il contatore delle risposte corrette
                conta_corrette++;
                System.out.println("risposte corrette " + conta_corrette + " sbagliate " + conta_sbagliate + "\n");
                System.out.println("--------------------------------------------------------------------------");

            }else{
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("la risposta è sbagliata,la tua risposta:"+ domande.get(n).opzioni[selezione] +"\n risposta corretta: " + domande.get(n).risposta + "\n");   
                //non viene tolta la domanda cosi puoi riprovare

                conta_sbagliate++;
                System.out.println("risposte corrette " + conta_corrette + " sbagliate " + conta_sbagliate + "\n");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            }
            
            //rimozione della domanda
            domande.remove(n);
        }
    }
}