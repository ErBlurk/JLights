package Sources.GUI;

import Sources.PlayerController;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class PausePanel extends JPanel {
    private JButton ResumeButton;
    private JButton ShuffleButton;
    private JButton MenuButton;
    private JButton QuitButton;
    private JLabel TableSizeLabel;
    private JTextField TableSizeTextField;

    public PausePanel(PlayerController actionListener) {
        initComponents();
        ResumeButton.addActionListener(actionListener);
        ShuffleButton.addActionListener(actionListener);
        MenuButton.addActionListener(actionListener);
        QuitButton.addActionListener(actionListener);
    }
    
    public int GetNewTableSize()
    {
        try
        {
            return Integer.parseInt(TableSizeTextField.getText());
        }
        catch(NumberFormatException numberException) { }
        return -1;
    }


    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        ResumeButton = new JButton();
        ShuffleButton = new JButton();
        MenuButton = new JButton();
        QuitButton = new JButton();
        TableSizeTextField = new JTextField();
        TableSizeLabel = new JLabel();

        setBackground(new java.awt.Color(11, 11, 11));
        setLayout(new java.awt.GridBagLayout());

        ResumeButton.setBackground(new java.awt.Color(33, 33, 33));
        ResumeButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ResumeButton.setForeground(new java.awt.Color(246, 255, 0));
        ResumeButton.setText("Resume");
        ResumeButton.setBorder(null);
        ResumeButton.setBorderPainted(false);
        ResumeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ResumeButton.setMaximumSize(new java.awt.Dimension(80, 30));
        ResumeButton.setMinimumSize(new java.awt.Dimension(80, 30));
        ResumeButton.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        add(ResumeButton, gridBagConstraints);

        ShuffleButton.setBackground(new java.awt.Color(33, 33, 33));
        ShuffleButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ShuffleButton.setForeground(new java.awt.Color(246, 255, 0));
        ShuffleButton.setText("Shuffle");
        ShuffleButton.setBorder(null);
        ShuffleButton.setBorderPainted(false);
        ShuffleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ShuffleButton.setMaximumSize(new java.awt.Dimension(80, 30));
        ShuffleButton.setMinimumSize(new java.awt.Dimension(80, 30));
        ShuffleButton.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
        add(ShuffleButton, gridBagConstraints);

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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        add(QuitButton, gridBagConstraints);

        TableSizeTextField.setBackground(new java.awt.Color(0, 153, 204));
        TableSizeTextField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TableSizeTextField.setForeground(new java.awt.Color(255, 255, 0));
        TableSizeTextField.setText("3");
        TableSizeTextField.setActionCommand("<Not Set>");
        TableSizeTextField.setMinimumSize(new java.awt.Dimension(10, 50));
        TableSizeTextField.setPreferredSize(new java.awt.Dimension(50, 25));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        add(TableSizeTextField, gridBagConstraints);

        TableSizeLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        TableSizeLabel.setForeground(new java.awt.Color(246, 255, 0));
        TableSizeLabel.setText("Table size");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(TableSizeLabel, gridBagConstraints);
    }
}
