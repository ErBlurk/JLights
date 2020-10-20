package Sources.GUI;
import Sources.PlayerController;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {
    private JButton PlayButton;
    private JButton SettingsButton;
    private JButton QuitButton;
    private JLabel TitleLabel;
    private JLabel SubTitleLabel;

    // Costruttore
    public MainMenuPanel(PlayerController actionListener) {
        initComponents();
        PlayButton.addActionListener(actionListener);
        SettingsButton.addActionListener(actionListener);
        QuitButton.addActionListener(actionListener);
    }

    // altro copia incolla
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        PlayButton = new JButton();
        SettingsButton = new JButton();
        QuitButton = new JButton();
        TitleLabel = new JLabel();
        SubTitleLabel = new JLabel();

        setBackground(new java.awt.Color(11, 11, 11));
        setLayout(new java.awt.GridBagLayout());

        PlayButton.setBackground(new java.awt.Color(33, 33, 33));
        PlayButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        PlayButton.setForeground(new java.awt.Color(246, 255, 0));
        PlayButton.setText("Play");
        PlayButton.setBorder(null);
        PlayButton.setBorderPainted(false);
        PlayButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PlayButton.setMaximumSize(new java.awt.Dimension(80, 30));
        PlayButton.setMinimumSize(new java.awt.Dimension(80, 30));
        PlayButton.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(41, 0, 3, 0);
        add(PlayButton, gridBagConstraints);

        SettingsButton.setBackground(new java.awt.Color(33, 33, 33));
        SettingsButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        SettingsButton.setForeground(new java.awt.Color(246, 255, 0));
        SettingsButton.setText("Settings");
        SettingsButton.setBorder(null);
        SettingsButton.setBorderPainted(false);
        SettingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SettingsButton.setMaximumSize(new java.awt.Dimension(80, 30));
        SettingsButton.setMinimumSize(new java.awt.Dimension(80, 30));
        SettingsButton.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
        add(SettingsButton, gridBagConstraints);

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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(QuitButton, gridBagConstraints);

        TitleLabel.setFont(new java.awt.Font("ROG Fonts", 2, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(0, 204, 255));
        TitleLabel.setText("LIGHTS");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(TitleLabel, gridBagConstraints);

        SubTitleLabel.setFont(new java.awt.Font("Arial Narrow", 2, 12)); // NOI18N
        SubTitleLabel.setForeground(new java.awt.Color(255, 153, 0));
        SubTitleLabel.setText("JAVA EDITION");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        add(SubTitleLabel, gridBagConstraints);
    }
}
