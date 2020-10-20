/*
 * E' la schermata che si mostra quando viene completato il gioco
 * Permette di tornare al menù, avviare una nuova partita o uscire dal gioco
 */

package Sources.GUI;
import Sources.PlayerController;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;

public class EndScreenPanel extends JPanel {
    private JButton RestartButton;
    private JButton MenuButton;
    private JButton QuitButton;
    private JLabel WonTextLabel;
    private JLabel EndTimeLabel;
    private JLabel EndMovesLabel;

    public EndScreenPanel(PlayerController actionListener) {
        initComponents();
        RestartButton.addActionListener(actionListener);
        MenuButton.addActionListener(actionListener);
        QuitButton.addActionListener(actionListener);
    }

    // Vengono aggiornate le statistiche finali
    public void UpdateStats(long Time, int NMoves)
    {
        long s =  (Time % 60);
        long m =  (Time / 60);

        EndTimeLabel.setText("" + m + ":" + s + " total time!");
        EndMovesLabel.setText("" + NMoves + " total moves!");
    }

    /**
     * Codice descrittore per bottoni,jlabel etc. molto copia incolla
     */
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        WonTextLabel = new JLabel();
        RestartButton = new JButton();
        MenuButton = new JButton();
        QuitButton = new JButton();
        EndMovesLabel = new JLabel();
        EndTimeLabel = new JLabel();

        setBackground(new java.awt.Color(11, 11, 11));
        setLayout(new java.awt.GridBagLayout());

        WonTextLabel.setBackground(new java.awt.Color(33, 33, 33));
        WonTextLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        WonTextLabel.setForeground(new java.awt.Color(255, 255, 0));
        WonTextLabel.setText("You won!");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(WonTextLabel, gridBagConstraints);

        EndTimeLabel.setBackground(new java.awt.Color(33, 33, 33));
        EndTimeLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        EndTimeLabel.setForeground(new java.awt.Color(255, 255, 0));
        EndTimeLabel.setText("Time");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(EndTimeLabel, gridBagConstraints);

        EndMovesLabel.setBackground(new java.awt.Color(33, 33, 33));
        EndMovesLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        EndMovesLabel.setForeground(new java.awt.Color(255, 255, 0));
        EndMovesLabel.setText("Moves");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(EndMovesLabel, gridBagConstraints);

        RestartButton.setBackground(new java.awt.Color(33, 33, 33));
        RestartButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        RestartButton.setForeground(new java.awt.Color(246, 255, 0));
        RestartButton.setText("Restart");
        RestartButton.setBorder(null);
        RestartButton.setBorderPainted(false);
        RestartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RestartButton.setMaximumSize(new java.awt.Dimension(80, 30));
        RestartButton.setMinimumSize(new java.awt.Dimension(80, 30));
        RestartButton.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        add(RestartButton, gridBagConstraints);

        MenuButton.setBackground(new java.awt.Color(33, 33, 33));
        MenuButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        MenuButton.setForeground(new java.awt.Color(246, 255, 0));
        MenuButton.setText("Menu");
        MenuButton.setBorder(null);
        MenuButton.setBorderPainted(false);
        MenuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuButton.setMaximumSize(new java.awt.Dimension(80, 30));
        MenuButton.setMinimumSize(new java.awt.Dimension(80, 30));
        MenuButton.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        add(MenuButton, gridBagConstraints);

        QuitButton.setBackground(new java.awt.Color(33, 33, 33));
        QuitButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        QuitButton.setForeground(new java.awt.Color(246, 255, 0));
        QuitButton.setText("Quit");
        QuitButton.setBorder(null);
        QuitButton.setBorderPainted(false);
        QuitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        QuitButton.setMaximumSize(new java.awt.Dimension(80, 30));
        QuitButton.setMinimumSize(new java.awt.Dimension(80, 30));
        QuitButton.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(QuitButton, gridBagConstraints);
    }
}
