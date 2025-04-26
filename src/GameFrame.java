import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GameFrame extends JFrame {
    public JLabel storyLabel;
    public JTextArea enemyStats;
    public JTextArea playerStatsField;
    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        //Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new TitledBorder("The Game"));
        mainPanel.setLayout(new BorderLayout());
        this.add(mainPanel);

        //Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridBagLayout());
        titlePanel.setBackground(Color.darkGray);
        JLabel titleLabel = new JLabel("Haunted Mansion with a Haunted Basement");
        titleLabel.setForeground(Color.white);
        titlePanel.add(titleLabel);
        titleLabel.setFont(new Font("Ariel", Font.BOLD, 40));
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        //Player Panel
        JPanel playerStats = new JPanel();
        playerStats.setBackground(Color.darkGray);
        playerStats.setBorder(new TitledBorder("<html> <font color=\"#ffffff\"> Player Stats </font> </html>"));
        playerStats.setLayout(new GridLayout(3, 1));

        JTextArea EmptyField = new JTextArea(1, 50);
        EmptyField.setBackground(Color.darkGray);
        EmptyField.setEditable(false);
        playerStats.add(EmptyField);

        playerStatsField = new JTextArea(1, 50);
        playerStatsField.setBorder(new TitledBorder("<html> <font color=\"#000000\"> player Statistics </font> </html>"));
        playerStatsField.setBackground(Color.LIGHT_GRAY);
        playerStatsField.setEditable(false);
        playerStatsField.setFont(new Font("Ariel", Font.BOLD, 14));
        playerStatsField.setText("Name: Larry the detective \nHealth: " + Player.getHealth() + "\nStrength: " + Player.getStrength() +"\n\nInventory:");
        playerStats.add(playerStatsField);

        mainPanel.add(playerStats, BorderLayout.WEST);


        //Dice Panel
        JPanel dicePanel = new JPanel();
        dicePanel.setBorder(new TitledBorder("<html> <font color=\"#ffffff\"> Other </font> </html>"));
        dicePanel.setBackground(Color.darkGray);
        dicePanel.setLayout(new GridLayout(3, 1));

        enemyStats = new JTextArea(1, 50);
        enemyStats.setBorder(new TitledBorder("<html> <font color=\"#ffffff\"> Enemy Stats </font> </html>"));
        enemyStats.setBackground(Color.LIGHT_GRAY);
        enemyStats.setEditable(false);
        enemyStats.setFont(new Font("Ariel", Font.BOLD, 14));
        enemyStats.setText((""));
        dicePanel.add(enemyStats);

        dicePanel.add(Main.getDiceButton());
        Color color = new Color(150, 0, 0);
        Color pressedColor = new Color(255, 255, 255, 255);
        Main.getDiceButton().setBackground(color);
        Main.getDiceButton().setForeground(pressedColor);
        Main.getDiceButton().setFont(new Font("Ariel", Font.BOLD, 50));

        JTextField emptyDice2 = new JTextField(50);
        emptyDice2.setBackground(Color.darkGray);
        emptyDice2.setEditable(false);
        dicePanel.add(emptyDice2);
                /*
                JLabel diceLabel = new JLabel("Dice");
                JButton diceButton = new JButton("Roll dice");

                dicePanel.add(diceLabel);
                dicePanel.add(diceButton);
                diceButton.setSize(200, 200);*/
        mainPanel.add(dicePanel, BorderLayout.EAST);

        //Story Panel
        JPanel storyPanel = new JPanel();
        storyPanel.setBackground(Color.darkGray);
        storyPanel.setBorder(new TitledBorder("<html> <font color = \"#ffffff\"> Story Text </font> </html>" ));
        Main.getStoryText().setFont(new Font("Arial", Font.BOLD, 20));

        storyPanel.setLayout(new GridBagLayout());

        //GroupLayout layout = new GroupLayout(storyPanel);
        //storyPanel.setLayout(layout);


        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.CENTER;
        storyLabel = new JLabel("<html> <div style='width:500px;'> " + Main.getStoryText().getText() + "</div> </html>");
        storyLabel.setForeground(Color.WHITE);
        storyLabel.setFont(new Font("Ariel", Font.BOLD, 30));
        storyPanel.add(storyLabel, c);

        // This panel is used to collect all buttons into one panel.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Center alignment for each button
        Main.getChoiceOne().setAlignmentX(Component.CENTER_ALIGNMENT);
        Main.getChoiceTwo().setAlignmentX(Component.CENTER_ALIGNMENT);
        Main.getChoiceThree().setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add buttons with spacing
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Main.getChoiceOne());
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Main.getChoiceTwo());
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(Main.getChoiceThree());

        // Add the sub-panel to the storyPanel
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.anchor = GridBagConstraints.CENTER;
        storyPanel.add(buttonPanel, c);

        Main.getChoiceOne().setFont(new Font("Arial", Font.BOLD, 15));
        Main.getChoiceTwo().setFont(new Font("Arial", Font.BOLD, 15));
        Main.getChoiceThree().setFont(new Font("Arial", Font.BOLD, 15));

        ActionListener updateStoryText = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                storyLabel.setText("<html> <div style='width:500px;'> " + Main.getStoryText().getText() + "</div> </html>");
            }
        };

        Main.getChoiceOne().addActionListener(updateStoryText);
        Main.getChoiceTwo().addActionListener(updateStoryText);
        Main.getChoiceThree().addActionListener(updateStoryText);

        mainPanel.add(storyPanel, BorderLayout.CENTER);



                /*layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true);

                layout.setHorizontalGroup(layout.createSequentialGroup()
                        .addComponent(choiceOne)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(storyText)
                                .addComponent(choiceTwo))
                        .addComponent(choiceThree)
                );

                layout.setVerticalGroup(layout.createSequentialGroup()
                        .addComponent(storyText)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(choiceOne)
                                .addComponent(choiceTwo)
                                .addComponent(choiceThree)));*/
        this.pack();

    }
    public void refreshStoryLabel()
    {
        storyLabel.setText("<html> <div style='width:500px;'>" + Main.getStoryText().getText() + "</div> </html>");
    }
}
