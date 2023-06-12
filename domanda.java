public class domanda {
    public String numero;
    public String domanda;
    public String[] opzioni = new String[5];
    public String risposta;
    
    //costruttore
    public domanda(String numero,String domanda, String opzione1, String opzione2, String opzione3, String opzione4, String risposta){
        this.numero = numero;
        this.domanda = domanda;
        this.opzioni[1] = opzione1;
        this.opzioni[2] = opzione2;
        this.opzioni[3] = opzione3;
        this.opzioni[4] = opzione4;
        this.risposta = risposta;
    }

    @Override
    public String toString() {
        String s = "Domanda numero: " + numero + "\nDomanda: " + domanda + "\nOpzione 1: " + opzioni[1] + "\nOpzione 2: " + opzioni[2] + "\nOpzione 3: " + opzioni[3] + "\nOpzione 4: " + opzioni[4] + "\n";
        return s;
    }
}
