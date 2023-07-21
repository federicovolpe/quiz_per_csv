import  java.io.BufferedReader;
import java.io.FileReader;      
import java.io.IOException;          
import java.util.ArrayList;          
import java.util.InputMismatchException;
import java.util.Random;             
import java.util.Scanner;            
                                     
public class Main {                  
    public static void main(String[] args) {
        System.out.println("Scegli la modalità:\na -> scelta multipla\nb -> domande a risposta aperta");
        Scanner sc = new Scanner(System.in);
        String modalità = sc.nextLine();
                                     
        if (modalità.equals("a")) {  
            // Lettura del tsv       
            String csvFile = "./domande.csv";
            String line;             
            int conta_corrette = 0;  
            int conta_sbagliate = 0; 
                                     
            ArrayList<Domanda> domande = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(";");
                    System.out.println("Genero la domanda numero: " + data[0]);
                    domande.add(new Domanda(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            int numeroTotaleDomande = domande.size();
            System.out.println(domande.size() + " domande sono state caricate con successo");

            // Selezione di una domanda a caso
            while (!domande.isEmpty()) {
                Random rand = new Random();
                int n = rand.nextInt(domande.size());
                System.out.println("Numero estratto: " + n);

                System.out.println(domande.get(n).toString());

                Scanner in = new Scanner(System.in);
                int selezione;
                
                while (true) {
                    try {
                        selezione = in.nextInt();
                        if (selezione >= 1 && selezione <= 4) {
                            break;
                        }
                        System.out.println(selezione + " non è una opzione disponibile");
                    } catch (InputMismatchException e) {
                        System.out.println("Bravo, hai rotto il gioco!");
                        in.next(); // Clear the invalid input
                    }
                }

                if (domande.get(n).verificaRisposta(selezione)) {
                    clearScreen();
                    System.out.println("--------------------------------------------------------");
                    System.out.println("La risposta è corretta");
                    conta_corrette++;
                    System.out.println("Risposte corrette: " + conta_corrette + "/" + numeroTotaleDomande +
                            " sbagliate: " + conta_sbagliate + "\n");
                    System.out.println("--------------------------------------------------------");

                    domande.remove(n);
                    System.out.println("Domanda " + n + " rimossa");
                } else {
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("La risposta è sbagliata, risposta corretta:\n" + domande.get(n).risposta + "\n");
                    conta_sbagliate++;
                    System.out.println("Risposte corrette: " + conta_corrette + "/" + numeroTotaleDomande +
                            " sbagliate: " + conta_sbagliate + "\n");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                }
            }
        } else if (modalità.equals("b")) {
            final String csvFile = "./domande.csv";
            ArrayList<DomandaAperta> domande = new ArrayList<>();
            String line;
            int conta_corrette = 0;
            int conta_sbagliate = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(";");
                    System.out.println("Generata la domanda: " + data[0]);
                    domande.add(new DomandaAperta(data[0], data[1], data[6]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            int numeroTotaleDomande = domande.size();
            System.out.println(domande.size() + " domande sono state caricate con successo");

            while (!domande.isEmpty()) {
                Random rand = new Random();
                int n = rand.nextInt(domande.size());
                System.out.println("Numero estratto: " + n);

                System.out.println(domande.get(n).domanda());
                System.out.println("Per visualizzare la risposta premi invio");

                Scanner in = new Scanner(System.in);
                in.nextLine();
                System.out.println("Risposta:\n" + domande.get(n).risposta() +
                        "\n\n(premi 'a' per risposta corretta, premi qualsiasi tasto per risposta sbagliata)");

                String selezione = in.nextLine();

                if (selezione.equals("a")) {
                    clearScreen();
                    System.out.println("--------------------------------------------------------");
                    conta_corrette++;
                    System.out.println("Risposte corrette: " + conta_corrette + "/" + numeroTotaleDomande + "\n");
                    System.out.println("--------------------------------------------------------");

                    domande.remove(n);
                    System.out.println("Domanda " + n + " rimossa");
                } else {
                    clearScreen();
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

                    conta_sbagliate++;
                    System.out.println("Risposte corrette: " + conta_corrette + "/" + numeroTotaleDomande + "\n");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                }
            }
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}