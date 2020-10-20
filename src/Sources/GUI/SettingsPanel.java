
package Sources.GUI;
import Sources.PlayerController;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;

public class SettingsPanel extends JPanel {
    private JButton ApplySettingsButton;
    private JButton BackButton;
    private JCheckBox FullScreenCheckBox;
    private JCheckBox NoBordersCheckBox;
    private JLabel SizeLabel;
    private JLabel WidthLabel;
    private JLabel HeightLabel;
    private JTextField PredefinedTableSizeTextField;
    private JTextField WidthResolutionTextField;
    private JTextField HeighrResolutionTextField;

    public SettingsPanel(PlayerController actionListener, String[] Settings) {
        initComponents();
        
        try
        {
            if(Settings[0].equals("y")) NoBordersCheckBox.setSelected(true);
            if(Settings[1].equals("y")) FullScreenCheckBox.setSelected(true);

            PredefinedTableSizeTextField.setText(Settings[2]);
            WidthResolutionTextField.setText(Settings[3]);
            HeighrResolutionTextField.setText(Settings[4]);
        }catch(Exception e) { }
        
        ApplySettingsButton.addActionListener(actionListener);
        BackButton.addActionListener(actionListener);
        
    }
    
    public boolean IsFullScreenChecked()
    {
        return FullScreenCheckBox.isSelected();
    }

    public boolean IsWindowBordersChecked()
    {
        return NoBordersCheckBox.isSelected();
    }
    
    public JTextField getDesiredWidthResolution() {
        return WidthResolutionTextField;
    }

    public JTextField getDesiredHeightResolution() {
        return HeighrResolutionTextField;
    }
    
    public JTextField getDefaultGameTableSize() {
        return PredefinedTableSizeTextField;
    }

    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        ApplySettingsButton = new JButton();
        BackButton = new JButton();
        FullScreenCheckBox = new JCheckBox();
        NoBordersCheckBox = new JCheckBox();
        PredefinedTableSizeTextField = new JTextField();
        WidthResolutionTextField = new JTextField();
        HeighrResolutionTextField = new JTextField();
        SizeLabel = new JLabel();
        WidthLabel = new JLabel();
        HeightLabel = new JLabel();

        setBackground(new java.awt.Color(11, 11, 11));
        setLayout(new java.awt.GridBagLayout());

        ApplySettingsButton.setBackground(new java.awt.Color(33, 33, 33));
        ApplySettingsButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ApplySettingsButton.setForeground(new java.awt.Color(246, 255, 0));
        ApplySettingsButton.setText("Apply");
        ApplySettingsButton.setBorder(null);
        ApplySettingsButton.setBorderPainted(false);
        ApplySettingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ApplySettingsButton.setMaximumSize(new java.awt.Dimension(80, 30));
        ApplySettingsButton.setMinimumSize(new java.awt.Dimension(80, 30));
        ApplySettingsButton.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(ApplySettingsButton, gridBagConstraints);

        BackButton.setBackground(new java.awt.Color(33, 33, 33));
        BackButton.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        BackButton.setForeground(new java.awt.Color(246, 255, 0));
        BackButton.setText("Back");
        BackButton.setBorder(null);
        BackButton.setBorderPainted(false);
        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BackButton.setMaximumSize(new java.awt.Dimension(80, 30));
        BackButton.setMinimumSize(new java.awt.Dimension(80, 30));
        BackButton.setPreferredSize(new java.awt.Dimension(80, 30));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(BackButton, gridBagConstraints);

        FullScreenCheckBox.setBackground(new java.awt.Color(33, 33, 33));
        FullScreenCheckBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        FullScreenCheckBox.setForeground(new java.awt.Color(246, 255, 0));
        FullScreenCheckBox.setText("FullScreen");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        add(FullScreenCheckBox, gridBagConstraints);

        NoBordersCheckBox.setBackground(new java.awt.Color(33, 33, 33));
        NoBordersCheckBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        NoBordersCheckBox.setForeground(new java.awt.Color(246, 255, 0));
        NoBordersCheckBox.setText("No borders");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        add(NoBordersCheckBox, gridBagConstraints);

        PredefinedTableSizeTextField.setBackground(new java.awt.Color(0, 153, 204));
        PredefinedTableSizeTextField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        PredefinedTableSizeTextField.setForeground(new java.awt.Color(255, 255, 0));
        PredefinedTableSizeTextField.setText("3");
        PredefinedTableSizeTextField.setActionCommand("<Not Set>");
        PredefinedTableSizeTextField.setMinimumSize(new java.awt.Dimension(10, 50));
        PredefinedTableSizeTextField.setPreferredSize(new java.awt.Dimension(50, 25));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(PredefinedTableSizeTextField, gridBagConstraints);

        WidthResolutionTextField.setBackground(new java.awt.Color(0, 153, 204));
        WidthResolutionTextField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        WidthResolutionTextField.setForeground(new java.awt.Color(255, 255, 0));
        WidthResolutionTextField.setText("1280");
        WidthResolutionTextField.setActionCommand("<Not Set>");
        WidthResolutionTextField.setMinimumSize(new java.awt.Dimension(10, 50));
        WidthResolutionTextField.setPreferredSize(new java.awt.Dimension(50, 25));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(WidthResolutionTextField, gridBagConstraints);

        HeighrResolutionTextField.setBackground(new java.awt.Color(0, 153, 204));
        HeighrResolutionTextField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        HeighrResolutionTextField.setForeground(new java.awt.Color(255, 255, 0));
        HeighrResolutionTextField.setText("720");
        HeighrResolutionTextField.setActionCommand("<Not Set>");
        HeighrResolutionTextField.setMinimumSize(new java.awt.Dimension(10, 50));
        HeighrResolutionTextField.setPreferredSize(new java.awt.Dimension(50, 25));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(HeighrResolutionTextField, gridBagConstraints);

        SizeLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        SizeLabel.setForeground(new java.awt.Color(246, 255, 0));
        SizeLabel.setText("Default game table size");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(SizeLabel, gridBagConstraints);

        WidthLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        WidthLabel.setForeground(new java.awt.Color(246, 255, 0));
        WidthLabel.setText("Game resolution x");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        add(WidthLabel, gridBagConstraints);

        HeightLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        HeightLabel.setForeground(new java.awt.Color(246, 255, 0));
        HeightLabel.setText("Game resolution y");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(HeightLabel, gridBagConstraints);
    }
}
