package Sources;

/**
 * Bottone rappresentante una singola "Luce" nella tabella di gioco; verrà
 * utilizzato nella versione testuale del gioco; in particolare gestisce:
 * Gestisce il proprio stato di acceso/spento Tiene conto della propria
 * posizione nella tabella di gioco
 */

import javax.swing.JButton;
import java.awt.Color;
 
public class LightButton extends JButton{
    // Rappresenta la posizione del bottone nella tabella
    protected int XPosition;
    protected int YPosition;
    // Rappresenta lo stato del bottono(accesso/spento:true/false)
    protected boolean State;
    // Array di colori per i bottoni accesi, di abbellimento, potrebbe essere sostituito con un singolo colore
    Color[] OnColors;

    // Crea la luce; di default è spenta
    public LightButton(int XPosition, int YPosition) 
    {
        this.XPosition = XPosition;
        this.YPosition = YPosition;
        State = false;

        // Parte per abbellimento della parte grafica
        OnColors = new Color[5];
        OnColors[0] = new Color(246, 255, 230);
        OnColors[1] = new Color(230, 255, 231);
        OnColors[2] = new Color(230, 251, 255);
        OnColors[3] = new Color(236, 230, 255);
        OnColors[4] = new Color(255, 230, 245);
    }

    // Cambia lo stato della luce
    public void SwitchState() 
    {
        State = !State;
        if(State)
        {
            setBackground(OnColors[(int) (Math.random() * OnColors.length)]);
        }
        else
        {
            setBackground(Color.BLACK);
        }
    }

    // restituisce lo stato della luce(true o false corrispondente ad acceso o spento) 
    public boolean GetState()
    {
        return State;
    }

    // restituisce la posizione del bottone relativa alla sua colonna nella tabella di gioco
    public int GetXPosition()
    {
        return XPosition;
    }

    // restituisce la posizione del bottone relativa alla sua riga nella tabella di gioco
    public int GetYPosition()
    {
        return YPosition;
    }
    
    // To string per stampare lo stato del bottone,solo per versione testuale
    public String toString() 
    { 
        if(State)
        {
            return "\u001B[34mAccesa\u001B[0m"; // contiene il codice per scrivere il testo in blu 
        }
        else
        {
            return "\u001B[31mSpenta\u001B[0m"; // contiene il codice per scrivere il testo in rosso
        }
    }
}