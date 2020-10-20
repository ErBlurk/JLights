package Sources.GUI;

/**
 * Classe rappresentate l'interfaccia grafica del gioco
 * Gestisce tutti i pannelli rappresentatnti la parte grafica del gioco(Tutti eccetto GameTablePanel contengono solo noiose dichiarazioni e posizionamenti di elementi)
 * I pannelli fondamentali sono GameStatsPanel, GameTablePanel e PausePanel; tutti gli altri servono solo ad abbellire il gioco e aggiungere funzionalità di minore importanza
 * 
 */

import javax.swing.JFrame;
import Sources.GameMode;
import Sources.GameState;
import Sources.PlayerController;
import java.awt.GridBagConstraints;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GUIFrameLights extends JFrame {
    // GameMode
    protected GameMode myGameMode;
    // PlayState
    protected GameState PlayState;
    // Gestisce l'input, è quindi la rappresentazione del giocatore
    protected PlayerController Player;
    // Salva le impostazioni della finestra
    protected String[] Settings;
    // Rappresenta il menù principale
    protected MainMenuPanel MainMenu;
    // Rappresenta il pannello dei settaggi, dove possono essere modificati
    protected SettingsPanel SettingsScreen;
    // Rappresenta la schermata di gioco
    public GamePanel GameScreen;
    // Gestisce la tabella grafica di gioco
    public GameTablePanel GraphicGameTable;
    // Mostra le statistiche correnti del gioco
    public GameStatsPanel GraphicStats;
    // Rappresenta il menù di pausa
    public PausePanel PauseScreen;
    // Rappresenta la schermata di fine partita
    public EndScreenPanel EndScreen;

    // Costruttore; se ci sono dei settaggi grafici li applica
    public GUIFrameLights(GameMode Game) {
        super("Lights");

        // Inizializzazione delle variabili
        myGameMode = Game;
        Player = new PlayerController(myGameMode);

        // Settaggi (non fondamentali)
        try {
            BufferedReader br = new BufferedReader(new FileReader("Settings.lights"));
            Settings = br.readLine().split("§");
            br.close();
        } catch (IOException fileException) {
            // Settaggi predefiniti
            Settings = new String[5];
            Settings[0] = "n";
            Settings[1] = "n";
            Settings[2] = "3";
            Settings[3] = "1280";
            Settings[4] = "720";
        }
        if (Settings[0].equals("y"))
        {
            setUndecorated(true);
        }
        if (Settings[1].equals("y"))
        {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        try
        {
            /**
             * 640 x 360 (nHD) 854 x 480 (FWVGA) 960 x 540 (qHD) 1024 x 576 (WSVGA) 1280 x
             * 720 (HD/WXGA) 1366 x 768 (FWXGA) 1600 x 900 (HD+) 1920 x 1080 (FHD)
             */
            setSize(Integer.parseInt(Settings[3]), Integer.parseInt(Settings[4]));
        }
        catch(NumberFormatException numberException)
        {
            setSize(1280, 720);
        }

        // Inizializazzione degli altri pannelli
        InitializeGraphicGameFrame();

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Funzione per aggiornareil riferimento alla partita in corso(chiamato quando per esempio si inizia una nuova partita)
    public void SetGameState(GameState PlayState) {
        this.PlayState = PlayState;
    }

    // Restituisce il gestore degli eventi
    public PlayerController GetPlayerController() {
        return Player;
    }

    // Inizializza tutti i pannelli utilizzati nel gioco
    public void InitializeGraphicGameFrame() {
        GridBagConstraints gridConstraints = new GridBagConstraints();

        GameScreen = new GamePanel();

        gridConstraints.fill = GridBagConstraints.BOTH;
        PauseScreen = new PausePanel(Player);

        SettingsScreen = new SettingsPanel(Player, Settings);

        EndScreen = new EndScreenPanel(Player);

        gridConstraints.weightx = getWidth() - getHeight(); // GUI.getWidth / xRatio * yRatio per ottenere un quadrato
        gridConstraints.weighty = getHeight();
        GameScreen.add(GraphicStats = new GameStatsPanel(Player), gridConstraints);

        gridConstraints.weightx = getHeight();
        gridConstraints.weighty = getHeight();
        GameScreen.add(GraphicGameTable = new GameTablePanel(), gridConstraints);

        GraphicGameTable.removeAll();
        add(MainMenu = new MainMenuPanel(Player));

        validate();
        repaint();
    }

    // Applica e salva su file i nuovi settaggi
    public void ChangeSettings() {
        String newSettings = "";

        // Impostazione per la visibilità dei bordi della finestra
        if (SettingsScreen.IsWindowBordersChecked())
            newSettings += "y§";
        else
            newSettings += "n§";

        // Impostazione per lo schermo intero
        if (SettingsScreen.IsFullScreenChecked())
            newSettings += "y§";
        else
            newSettings += "n§";

        // Setta una nuova dimensione predefinita della tabella di gioco
        try {
            int size = Integer.parseInt(SettingsScreen.getDefaultGameTableSize().getText());
            if (size < 3) size = 3;
            if (size > myGameMode.MAX_TABLE_SIZE) size = myGameMode.MAX_TABLE_SIZE; 
            SettingsScreen.getDefaultGameTableSize().setText("" + size);
            myGameMode.SetTableLength(size);
            newSettings += "" + size + "§";
        } catch (NumberFormatException numberException) {
            newSettings += "3§";
        }

        // Setta una nuova risoluzione della finestra
        try {
            int x = Integer.parseInt(SettingsScreen.getDesiredWidthResolution().getText());
            int y = Integer.parseInt(SettingsScreen.getDesiredHeightResolution().getText());
            if (x > y) {
                if(!SettingsScreen.IsFullScreenChecked()) setSize(x, y);
                newSettings += "" + x + "§" + y;
            } else {
                if (!SettingsScreen.IsFullScreenChecked()) setSize(y, x);
                newSettings += "" + y + "§" + x;
            }
        } catch (NumberFormatException numberException) {
            newSettings += "1280§720";
        }

        // Scrive le nuove impostazioni su file
        try 
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Settings.lights"));
            writer.write(newSettings);
            writer.close();
        }
        catch (IOException e) { }
    }
    
    // Cancella tutti i bottoni dalla tabella di gioco e la rivalida
    public void MakeNewGameTable()
    {
        GraphicGameTable.removeAll();
        validate();
        repaint();
    }

    /** Parte di codice per mostrare/nascondere tutti i vari menù,sottomenù e pannelli, molto noiosa */
    public void ShowEndScreen()
    {
        remove(MainMenu);
        remove(SettingsScreen);
        remove(GameScreen);
        remove(PauseScreen);
        add(EndScreen);
        validate();
        repaint();
    }

    public void LoadSettingsSubMenu()
    {
        remove(MainMenu);
        add(SettingsScreen);
        remove(GameScreen);
        remove(PauseScreen);
        remove(EndScreen);
        validate();
        repaint();
    }

    public void LoadMenu()
    {
        add(MainMenu);
        remove(SettingsScreen);
        remove(GameScreen);
        remove(PauseScreen);
        remove(EndScreen);
        validate();
        repaint();
        myGameMode.EndPlay();
        PlayState = null;
    }

    public void ShowGame()
    {
        remove(MainMenu);
        remove(SettingsScreen);
        add(GameScreen);
        remove(PauseScreen);
        remove(EndScreen);
        validate();
        repaint();
    }

    public void ShowPauseMenu()
    {
        remove(MainMenu);
        remove(SettingsScreen);
        remove(GameScreen);
        add(PauseScreen);
        remove(EndScreen);
        validate();
        repaint();
        PlayState.Pause();
    }

    public void HidePauseMenu()
    {
        remove(MainMenu);
        remove(SettingsScreen);
        add(GameScreen);
        remove(PauseScreen);
        remove(EndScreen);
        validate();
        repaint();
        PlayState.Pause();
    }

    public void StartNewPlay()
    {
        remove(MainMenu);
        remove(SettingsScreen);
        add(GameScreen);
        remove(PauseScreen);
        remove(EndScreen);
        revalidate();
        repaint();
        myGameMode.InitializeGameTable();
        PlayState.BeginPlay();
    }

    public void ShuffleNewPlay()
    {
        myGameMode.SetTableLength(PauseScreen.GetNewTableSize());
        if (myGameMode.GetTableLength() < 3) myGameMode.SetTableLength(3);
        if (myGameMode.GetTableLength() > myGameMode.MAX_TABLE_SIZE) myGameMode.SetTableLength(myGameMode.MAX_TABLE_SIZE);
        HidePauseMenu();
        StartNewPlay();
    }
}