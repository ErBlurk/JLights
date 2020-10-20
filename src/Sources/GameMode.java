package Sources;

/**
 * Classe dedicata esclusivamente a:
 * Definizione delle regole del gioco (meccaniche e funzionamento)
 * * Decide quali luci cambiano di stato
 * * Gestisce gli input testuali
 * * Decide quando avviare e terminare una partita
 * * Decide il modo con il quale la partita inizia(tabella con luci a stato random)
 * * Contiene il riferimento al gestore della grafica(GUIFrameLights) e della partita(GameState)
 * Eventuali impostazioni (per esempio dimensione griglia di gioco)
 * 
 */
import Sources.GUI.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

 public class GameMode {
    // Dimensione della griglia di gioco(essendo un quadrato, viene preso in considerazione un suo lato per determinare la dimensione)
    protected int TableLength;
    // Definisce la dimensione limite che non può essere superata nella dimensione della tabella
    public final int MAX_TABLE_SIZE = 26;
    // Contiene lo stato della partita attuale del gioco
    protected GameState PlayState;
    // Gestisce l'interfaccia grafica
    GUIFrameLights GUI;
    
    // Costruttore, necessario all'inizializzazione di determinati parametri; non necessita di parametri
    public GameMode() { 
        // Avvia la parte grafica
        GUI = new GUIFrameLights(this);

        // Dimensione predefinita
        TableLength = 3;

        // Dimensione letta dal file dei settaggi
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Settings.lights"));
            int newLength = Integer.parseInt(br.readLine().split("§")[2]);
            if (newLength < 3) newLength = 3;
            if (newLength > MAX_TABLE_SIZE) newLength = MAX_TABLE_SIZE;
            TableLength = newLength;
            br.close();
        }
        catch(NumberFormatException | IOException e) { }
    }

    // Avvia la partita(anche graficamente)
    public void StartPlaying()
    {
        InitializeGameTable();
        GUI.ShowGame();
        PlayState.BeginPlay();
    }

    // Definisce il comportamento che il gioco deve assumere quando viene premuta una certa "luce" del gioco, 
    // andando a modificare gli stati delle luci presenti nella tabella contenuata all'interno dello stato della partita(GameState), 
    // inoltre verifica se la partita si è eventualmente conclusa
    public void LightSelectedAt(int Row, int Column) 
    { 
        // Il primo controllo è utile solamente nella versione testuale
        if (IsValidIndex(Row,Column))
        {
            PlayState.ChangeLightStateAt(Row, Column);
            PlayState.HasMoved();
            GUI.GraphicStats.UpdateNumberOfMoves(PlayState.GetNMoves());
            GUI.GraphicStats.UpdateTime(PlayState.GetTimeFromBegin());

            // In base alla selezione di una luce si comporta in modi diversi(per esempio se è su un bordo o al centro della tabella)
            if (IsValidIndex(Row + 1,Column))
            {
                PlayState.ChangeLightStateAt(Row + 1, Column);
            }
            if (IsValidIndex(Row - 1,Column))
            {
                PlayState.ChangeLightStateAt(Row - 1, Column);
            }
            if (IsValidIndex(Row ,Column + 1))
            {
                PlayState.ChangeLightStateAt(Row , Column + 1);
            }
            if (IsValidIndex(Row ,Column - 1))
            {
                PlayState.ChangeLightStateAt(Row, Column - 1);
            }

            //Verifica se la partita si è conclusa
            if (PlayState.GetNLightsOn() == 0)
            {
                GUI.EndScreen.UpdateStats(PlayState.GetTimeFromBegin(), PlayState.GetNMoves());
                GUI.ShowEndScreen();
            }
        }
    } 

    // molto simile a LightSelectedAt, ma essendo eseguito prima dell'inizio della partita non deve aggiornare il tempo, il contatore di mosse, la grafica etc.
    public void InitializeLightsAt (int Row, int Column) 
    { 
        if (IsValidIndex(Row,Column))
        {
            // In base alla selezione di una luce si comporta in modi diversi(per esempio se è su un bordo o al centro della tabella)
            if (IsValidIndex(Row + 1,Column))
            {
                PlayState.ChangeLightStateAt(Row + 1, Column);
            }
            if (IsValidIndex(Row - 1,Column))
            {
                PlayState.ChangeLightStateAt(Row - 1, Column);
            }
            if (IsValidIndex(Row ,Column + 1))
            {
                PlayState.ChangeLightStateAt(Row , Column + 1);
            }
            if (IsValidIndex(Row ,Column - 1))
            {
                PlayState.ChangeLightStateAt(Row, Column - 1);
            }
        }
    } 

    // Dice se un dato indice nella tabella di gioco è valido, particolarmente utile nella versione testuale dato l'input imprevedibile, 
    // utile anche nella versione grafica per determinare se una luce sarebbe "oltre il bordo", e quindi non esiste
    public boolean IsValidIndex(int Row, int Column)
    { 
        if (Row < TableLength && Column < TableLength && Row >= 0 && Column >= 0)
        {
            return true;
        }
        return false;
    } 

    // Accetta e gestisce delle istruzioni, oltre alla gestione della selezione delle luci,metodo solo per la versione testuale
    public void TellGame(String Index)
    { 
        // Se richiesto dal giocatore, il gioco viene messo in pausa, nella versione grafica potrebbe far apparire un menù di pausa
        if( Index.toLowerCase().equals("pause") || Index.toLowerCase().equals("pausa"))
        {
            if(PlayState.GameIsPaused())
            {
                GUI.HidePauseMenu();
            }
            else
            {
                GUI.ShowPauseMenu();
            }
        }
        // Se richiesto, la tabella di gioco viene riinizializzata
        if( Index.toLowerCase().equals("restart"))
        {
            InitializeGameTable();
        }
        // Se richiesto dal giocatore, la tabella di gioco viene ridimensionata alla dimensione voluta
        if(Index.length() >= 7 && Index.toLowerCase().substring(0, 6).equals("setdim"))
        {
            try
            {
                String[] words = Index.split("\\s+");
                TableLength = Integer.parseInt(words[1]);
                if( TableLength > MAX_TABLE_SIZE)
                {
                    TableLength = MAX_TABLE_SIZE;
                }
                if( TableLength < 3)
                {
                    TableLength = 3;
                }
                InitializeGameTable();
            }
            catch(NumberFormatException | ArrayIndexOutOfBoundsException e){ }
        }
        // se il gioco non è in pausa prova a fare qualcosa con l'input, e nel caso sia un indice per una luce, seleziona la luce a quell'indice(se è valido)
        if(!PlayState.GameIsPaused())
        {
            int x = -1, y = -1;
            String[] coords = Index.split(":");
            try
            {
                x = Integer.parseInt(coords[0]);
                --x; // ci si aspetta un input del tipo: 1 per rappresentare la colonna o la riga a indice 0, dunque gli indici vanno decrementati di 1
            }
            catch(NumberFormatException formatException){ }
            catch(ArrayIndexOutOfBoundsException indexException){ }
            try
            {
                y = Integer.parseInt(coords[1]);
                --y;
            }
            catch(NumberFormatException formatException){ }
            catch(ArrayIndexOutOfBoundsException indexException){ }


            //è sufficente verificare che siano cambiati i valori, ulteriori verifiche vengono effettuate successivamente
            if ( x != -1 && y != -1)
            {
                LightSelectedAt(x, y);
            }
        }
    }

    // Inizializza la tabella di gioco, creandone una nuova con luci aventi uno stato assegnato casualmente, e successivamente la passa allo stato di gioco(GameState)
    public void InitializeGameTable() 
    {   
        // resetta la tabella di gioco
        GUI.MakeNewGameTable();

        // crea una tabella di gioco con tutti i bottoni spenti
        LightButton[][] NewTable = new LightButton[TableLength][TableLength];
        for (int x = 0; x < TableLength; x++)
        {
            for (int y =  0; y < TableLength; y++)
            {
                NewTable[x][y] = new LightButton(x, y);
                NewTable[x][y].addActionListener(GUI.GetPlayerController());
                GUI.GraphicGameTable.AddButtonToGridAt(NewTable[x][y], x, y);
            }
        }

        // crea una nuova partita
        PlayState = new GameState(NewTable);
        GUI.SetGameState(PlayState);

        // finchè tutte le luci sulla tabella sono spente
        while(PlayState.GetNLightsOn() == 0)
        {
            // Mescolama randomicamente la tabella di gioco (n mosse casuali)
            // N.B. più è grande la tabella, più mosse sono necessarie per avere un gioco ben mescolato
            for (int n = 0; n < 50 * TableLength; n++)
            {
                Random random = new Random();
                InitializeLightsAt( random.nextInt(TableLength), random.nextInt(TableLength));
            }
        }

        // essendo stata creata una nuova tabella di gioco grafica, è necessaria la chiamata di questa funzione affinchè venga disegnata
        GUI.GraphicGameTable.validate();
    }

    // Permette di modificare la dimensione della tabella di gioco
    public void SetTableLength(int NewLength) 
    { 
        this.TableLength = NewLength;
        InitializeGameTable();
    }

    // Permette di ottenere il valore della dimensione della tabella di gioco
    public int GetTableLength() 
    {
        return TableLength;
    }

    // Permette di ottenere lo stato attuale del gioco
    public GameState GetGameState() 
    {
        return PlayState;
    }

    // Restituisce il riferimento al gestore grafico del gioco
    public GUIFrameLights GetGUI()
    {
        return GUI;
    }

    // da chiamare quando viene terminata una partita, elimina il riferimento a quella vecchia
    public void EndPlay()
    {
        PlayState = null;
    }
}