import java.util.Objects;
                         
public class domandaAperta {
    private final String numero;
    private final String domanda;
    private final String risposta;
                         
    /**                  
     * metodo costruttore per una domanda aperta
     *                   
     * @param numero numero della domanda
     * @param domanda    
     * @param risposta   
     * @throws IllegalArgumentException se il numero è negativo o se le stringhe sono vuote
     * @throws NullPointerException se le stringhe sono null
     */                  
    public domandaAperta(final String numero, final String domanda, final String risposta) throws IllegalArgumentException, NullPointerException{
        Objects.requireNonNull(domanda, "la domanda non può essere null");
        Objects.requireNonNull(risposta,"la risposta non può essere null");
        Objects.requireNonNull(numero, "il numero non può essere nullo");
        if(numero.equals("") || risposta.equals("") || domanda.equals("")) throw new IllegalArgumentException(risposta, null);
                                                           
        this.domanda = domanda ;                           
        this.risposta = risposta ;                         
        this.numero = numero ;                             
    }                                                      
                                                           
    public String domanda(){                               
        return "[" + this.numero + "] " +this.domanda + "\n";
    }                                                      
                                                           
    public String risposta(){                              
        return this.risposta;                              
    }                                                      
                                                           
}                                                          
                                                           