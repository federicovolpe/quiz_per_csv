import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main{
    public static void main(String[] args){
        System.out.println("Hello World");
        //lettura del tsv
        String csvFile = "./nuovo.csv";
        String line;
        String csvSeparator = ";"; // Specify the separator used in your CSV file

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                //arry di stringhe con i dati
                String[] data = line.split(csvSeparator);
                
                //creazione array di domande
                ArrayList<domanda> domande = new ArrayList<domanda>();
                domande.add(new domanda(data[0],data[1],data[2],data[3],data[4],data[5],data[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("le domande sono state caricate con successo")
    }
}