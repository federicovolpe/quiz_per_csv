# app per quiz

l'idea del progetto è di creare una applicazione per quiz

l'obiettivo principale della applicazione è la flessibilità
di fatti a differenza da tutti i siti di quiz(che spesso sono a pagmento) questa punta a implementare dei quiz che siano 
immagazinati in un qualsiasi file CSV facilmente producibile con qualsiasi programma di calcolo come excel o numbers.
l'unico vincolo è che il formato sia: 
<u>numero domanda</u>; 
<u>domanda</u>; 
<u>opzione1</u>; 
<u>opzione2</u>; 
<u>opzione3</u>; 
<u>opzione4</u>; 
<u>opzione corretta</u>

### le modalità
dopo una lettura delle domande e creazione di queste ultime verrà chiesto all'utente di decidere
se proseguire con il quiz classico a risposta multipla o di effettuare un quiz autovalutativo con risposte aperte.
in entrambi i casi vige la possibilità di tornare indietro a vedere le domande precendenti con un semplice scroll di mouse

- risposta multipla: verrà mostrata una domanda e quattro possibili risposte, l'utente ha il semplice compito di inserire uno dei quattro numeri corrispondenti alle risposte per scegliere quella desiderata e poi premere invio
(verrà sempre mostrata in alto una semplice statistica delle domande date sbagliate e quelle date giuste e quante altre ne mancano da rispondere)
                    
- domande aperte: verrà mostrata una domanda, se l'utente preme il tasto invio viene mostrata la risposta, successivamente si può valutare se la risposta data dall'utente è reputata giusta, se giusta basta premere invio se sbagliata basta che si prema il tasto corrispondente
                    
**in entrambi i casi** le domande con esito negative verranno riproposte all'utente mentre quelle giuste non verrano più proposte
                                                                                                    
## funzionamento                                                                                    
****per fare funzionare tuttto c'è la necessità di avere java****                                   
per provare l'applicazione prima di tutto verificare che tutti i files della repository siano posizionati nella stessa directory, 
posizionarsi con il terminale nella directory dove stanno tutti i file                              
lanciare il comando: javac main.java                                                                
lanciare il comando: java main.java                                                                 
                                                                                                    
se tutto andrà come previsto verranno mostrate tutte le domande che sono state caricate con successo
e il quiz partirà.  

## Download section

- [Download executable](https://raw.githubusercontent.com/federicovolpe/quiz_per_csv/main/Artifacts/quiz.jar)