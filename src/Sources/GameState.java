package Sources;

/**
 * Classe rappresentante la partita corrente: 
 * Conta il tempo trascorso dall'inizio della partita 
 * Conta il numero di mosse effettuate Eventualmente
 * gestisce la pausa
 * Cambia lo stato di una luce indicata dal GameMode,che decide quali cambiare di stato
 * 
 */

import Sources.GUI.GUIFrameLights;


public class GameState {
    // E' la tabella di gioco
    protected LightButton GameTable[][];
    // Conta quante mosse sono state effettuate
    protected int NMoves;
    //Tiene conto del tempo all'inizio della partita
    protected long TimeAtBegin;
    // Tiene il conto del numero di luci ancora accese
    protected int NLightsOn;
    // Interfaccia grafica del gioco
    protected GUIFrameLights GameGUI;
    // Dice se il gioco è in pausa
    protected boolean isPaused;
    // Tiene conto del tempo della partita che è stato traascorso in pausa
    protected long TimeAtPauseStart;

    // Inizializzazione o preparazione della nuova partita
    public GameState(LightButton[][] NewGameTable) 
    {
        isPaused = true;
        NLightsOn = 0; // è un errore inizializzare questa variabile all'inizio della partita(BeginPlay), sarebbe già vinta
        GameTable = NewGameTable;
    }

    // Rappresenta l'avvio della partita
    public void BeginPlay()
    {
        NMoves = 0;
        TimeAtBegin = System.currentTimeMillis();
        isPaused = false;
    }

    // in base allo stato della partita, quando questo metodo viene chiamato, la mette in pausa oppure termina la pausa
    public void Pause()
    {
        if(isPaused)
        {
            StopPause();
        }
        else
        {
            StartPause();
        }
    }

    // inizia il periodo di pausa
    protected void StartPause()
    {
        TimeAtPauseStart = System.currentTimeMillis();
        isPaused = true;
    }

    // finisce il periodo di pausa
    protected void StopPause()
    {
        TimeAtBegin += System.currentTimeMillis() - TimeAtPauseStart;
        TimeAtPauseStart = 0;
        isPaused = false;
    }

    // dice se la partita è in pausa
    public boolean GameIsPaused()
    {
        return isPaused;
    }

    // Cambia lo stato di una luce a una data posizione, modifica NLightsOn
    public void ChangeLightStateAt(int Row, int Column) 
    { 
        LightButton currentButton =  GameTable[Row][Column];
        currentButton.SwitchState();

        if (currentButton.GetState())
        {
            ++NLightsOn;
        }
        else
        {
            --NLightsOn;
        }
    }

    // Restituisce il tempo trascorso dall'inizio della partita
    public long GetTimeFromBegin() 
    {
        // Il tempo essendo in millisecondi va diviso per 1000 per ottenerlo in secondi
        if(!isPaused) return (System.currentTimeMillis() - TimeAtBegin) / 1000;
        else return (TimeAtPauseStart - TimeAtBegin) / 1000;
    }


    // Restituisce il numero di mosse effettuate durante la partita
    public int GetNMoves() 
    { 
        return NMoves;
    }

    // Tiene conto che il giocatore ha "mosso", (può generare un qualche evento?)
    public void HasMoved() 
    { 
        ++NMoves;
    }

    // Restituisce l'attuale tabella di gioco
    public LightButton[][] GetGameTable() 
    { 
        return GameTable;
    }

    // Restituisce il numero di luci che si devono ancora spegnere
    public int GetNLightsOn() 
    { 
        return NLightsOn;
    }

    // per la versione testuale; crea una stringa rappresentate la tabella attuale di gioco
    public String GetTextTable()
    {
        String textTable;
        textTable = "";

        for (int i = 0; i < GameTable.length; i++)
        {
            for (int  j = 0; j < GameTable.length; j++)
            {
                textTable += (GameTable[i][j].toString() + "\t");
            }
            textTable += "\n";
        }

        textTable += "\u001B[0m\n";
        return textTable;
    }
}