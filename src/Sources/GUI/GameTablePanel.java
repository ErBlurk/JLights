package Sources.GUI;

/**
 * Tabella grafica di gioco
 * 
 */

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GameTablePanel extends JPanel{
    protected GridBagConstraints gridCostraints;

    // Costruttore
    public GameTablePanel()
    {
        super(new GridBagLayout());

        gridCostraints = new GridBagConstraints();
        gridCostraints.fill = GridBagConstraints.BOTH;
        gridCostraints.weightx = 1;
        gridCostraints.weighty = 1;

        setVisible(true);
    }

    // Aggiunge un bottone ad una data posizione
    public void AddButtonToGridAt(JButton Button,int Row, int Column)
    {
        gridCostraints.gridx = Row;
        gridCostraints.gridy = Column;
        add(Button, gridCostraints);
    }
}