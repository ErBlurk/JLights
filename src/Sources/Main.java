package Sources;

/**
 * @authors: Leonardo Mariut & Giulio Rucco
 *
 */

import java.util.Scanner;

public class Main {
    // Nella parte grafica serve solamente all'avvio del gioco; nella parte testuale riceve e input testuali e stampa sul terminale il gioco
    // Se la parte tesuale viene decommentata, inserendo gli input corretti si può giocare per via testuale con la versione grafica(per esempio si può selezionare una luce da riga di comando)
    public static void main(final String[] args) {
        final GameMode Lights = new GameMode();

        /** Da qua in poi parte testuale */
        /*
        final Scanner jinput = new Scanner(System.in);
        System.out.println("\nLIGHTS [RIGA DI COMANDO]\nPer giocare: \n\t-riga:colonna per selezionare una luce (esempio: \"1:3\" oppure \"3:3\") \n\t-\"pausa\" per mettere in pausa il gioco e riprenderlo\n\t-\"setdim n\" per cambiare la dimensione della tabella di gioco(esempio:\"setdim 5\"); inizia una nuova partita se eseguito\n\t-\"restart\" per iniziare una nuova partita\n\n\n ");
        String s;
        GameState LightsState = Lights.GetGameState();
        System.out.println("\nLIGHTS\nPer giocare: \n\t-riga:colonna per selezionare una luce (esempio: \"1:3\" oppure \"3:3\") \n\t-\"pausa\" per mettere in pausa il gioco e riprenderlo\n\t-\"setdim n\" per cambiare la dimensione della tabella di gioco(esempio:\"setdim 5\"); inizia una nuova partita se eseguito\n\t-\"restart\" per iniziare una nuova partita\n\n\n ");
        
        do{
            System.out.println("Tempo trascorso: " + LightsState.GetTimeFromBegin() + " s");
            System.out.println("Numero tentativi:" + LightsState.GetNMoves() + "\n");
            System.out.println(LightsState.GetTextTable());
            System.out.println("Seleziona una luce");
            s = jinput.nextLine();
            if(s.toLowerCase().equals("restart"))
            {
                System.out.println("\n\u001b[32m!!!Inizio di una nuova partita!!!\u001B[0m");
            }
            Lights.TellGame(s);
            System.out.println();
            LightsState = Lights.GetGameState(); //La partita viene aggiornata ad ogni mossa, nel caso se ne inizi una nuova
        }while(LightsState.GetNLightsOn() != 0);

        System.out.println("Hai vinto!\nMosse totali: " + LightsState.GetNMoves() + "\nTempo totale: " + LightsState.GetTimeFromBegin());
        */
    }
}