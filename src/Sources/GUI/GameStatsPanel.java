/*
 * Contiene le statistiche della partita e il pulsante per la pausa
 */
package Sources.GUI;
import Sources.PlayerController;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;

public class GameStatsPanel extends JPanel {
    private JButton PauseButton;
    private JLabel TimeLabel;
    private JLabel NMovesLabel;

    public GameStatsPanel(PlayerController actionListener) {
        initComponents();
        PauseButton.addActionListener(actionListener);
        setVisible(true);
    }
    
    public void UpdateNumberOfMoves(int n)
    {
        NMovesLabel.setText("Number of moves: " + n);
    }

    public void UpdateTime(long time)
    {
        long s = time % 60;
        long m = time / 60;
        TimeLabel.setText("" + m + ":" + s);
    }

    // Tanto copia incolla
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        TimeLabel = new JLabel();
        NMovesLabel = new JLabel();
        PauseButton = new JButton();

        setBackground(new java.awt.Color(11, 11, 11));
        setLayout(new java.awt.GridBagLayout());

        TimeLabel.setBackground(new java.awt.Color(33, 33, 33));
        TimeLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(255, 255, 0));
        TimeLabel.setText("00:00");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        add(TimeLabel, gridBagConstraints);

        NMovesLabel.setBackground(new java.awt.Color(33, 33, 33));
        NMovesLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        NMovesLabel.setForeground(new java.awt.Color(255, 255, 0));
        NMovesLabel.setText("Number of moves: 0");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        add(NMovesLabel, gridBagConstraints);

        PauseButton.setBackground(new java.awt.Color(33, 33, 33));
        PauseButton.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        PauseButton.setForeground(new java.awt.Color(0, 204, 255));
        PauseButton.setText("II");
        PauseButton.setBorder(null);
        PauseButton.setBorderPainted(false);
        PauseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PauseButton.setMaximumSize(new java.awt.Dimension(30, 30));
        PauseButton.setMinimumSize(new java.awt.Dimension(140, 140));
        PauseButton.setPreferredSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new GridBagConstraints();
        //gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 0);
        add(PauseButton, gridBagConstraints);
    }
}
