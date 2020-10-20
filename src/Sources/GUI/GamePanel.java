/*
 * Pannello vuoto, potrebbe avere qualche utilità oltre a quella di contenere il pannello con le statistiche e quello con la tabella di gioco
 */
package Sources.GUI;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public GamePanel() {
        setBackground(new java.awt.Color(11, 11, 11));
        setForeground(new java.awt.Color(240, 240, 240));
        setToolTipText("");
        setLayout(new java.awt.GridBagLayout());
    }
}
