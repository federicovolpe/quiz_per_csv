/**
 * programma alternativo per la esercitazione con domande aperte
 */
public clas laSaiONo{
    public static void main(String[] args){
        //lettura di una domanda dal csv
        String csvFile = "./domandeAperte.csv";
        ArrayList<domandaAperta> domande = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile)){
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
            System.out.println(domande.get(n).toString());

            Scanner in = new Scanner(System.in);
            String selezione = in.nextchar();
            //read next int
            try{
                while(selezione > 4 || selezione < 1 ){
                    System.out.println(selezione + "non è una opzione disponibile");
                    selezione = in.nextchar();
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
    }
}
