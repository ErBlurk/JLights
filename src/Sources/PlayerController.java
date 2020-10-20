package Sources;

/**
 * Gestisce l'input dell'utente, esclusivamente parte grafica
 * Ad ogni pulsante associa un evento
 */

import java.awt.event.*;
import javax.swing.JButton;

public class PlayerController implements ActionListener{
    // riferimento al GameMode, contenente i metodi chiamati all'avvenimento di determinati eventi(un determinato pulsante viene premuto)
    protected GameMode myGameMode;

    // costruttore
    public PlayerController(GameMode NewGameMode)
    {
        myGameMode = NewGameMode;
    }

    // metodo che viene eseguito quando un bottone viene premuto
    public void actionPerformed(ActionEvent Action) 
    { 
        // estrae l'oggetto dal riferimento
        Object obj = Action.getSource();

        // se è stata premuta una luce, cambia il suo stato e quello delle altre luci adiacenti
        if (obj instanceof LightButton)
        {
            LightButton selectedLight = (LightButton) obj;
            myGameMode.LightSelectedAt(selectedLight.GetXPosition(), selectedLight.GetYPosition());  // Seleziona la luce desiderata
        }

        // se è stato premuto un bottone qualsiasi
        if(obj instanceof JButton)
        {
            JButton button = (JButton) obj;
            if(button.getText().equals("II"))                       // mette in pausa
            {
                myGameMode.GetGUI().ShowPauseMenu();
            }
            if(button.getText().equals("Resume"))
            {
                myGameMode.GetGUI().HidePauseMenu();                // torna alla schermata di gioco da quella di pausa
            }
            if(button.getText().equals("Restart"))
            {
                myGameMode.GetGUI().StartNewPlay();                 // inizia una nuova partita
            }
            if(button.getText().equals("Shuffle"))
            {
                myGameMode.GetGUI().ShuffleNewPlay();               // rimescola la tabella di gioco e inizia una nuova partita
            }
            if(button.getText().equals("Quit"))
            {
                myGameMode.GetGUI().dispose();                      // termina il gioco
            }
            if(button.getText().equals("Play"))
            {
                myGameMode.StartPlaying();                          // passa dal menù principale alla schermata di gioco e avvia la partita  
            }
            if(button.getText().equals("Menu"))
            {
                myGameMode.GetGUI().LoadMenu();                     // carica il menù principale
            }
            if(button.getText().equals("Settings"))
            {
                myGameMode.GetGUI().LoadSettingsSubMenu();          // carica il sottomenù del menù principale riguardante i settaggi grafici e di gioco
            }
            if(button.getText().equals("Back"))
            {
                myGameMode.GetGUI().LoadMenu();                     // dalla schermata dei settaggi torna al menù
            }
            if(button.getText().equals("Apply"))
            {
                myGameMode.GetGUI().ChangeSettings();               // aggiorna i settaggi e torna al menù principale
                myGameMode.GetGUI().LoadMenu();
            }
        }
    }
}