import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GameFrame extends JFrame {
    JLabel storyLabel;
    GameFrame gameFrame;
    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        gameFrame = this;

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
        JTextField playerStatsField1 = new JTextField(50);
        playerStatsField1.setBackground(Color.darkGray);
        playerStatsField1.setEditable(false);
        playerStats.add(playerStatsField1);

        JTextField playerStatsField2 = new JTextField(50);
        playerStatsField2.setBackground(Color.LIGHT_GRAY);
        playerStats.add(playerStatsField2);

        mainPanel.add(playerStats, BorderLayout.WEST);


        //Dice Panel
        JPanel dicePanel = new JPanel();
        dicePanel.setBorder(new TitledBorder("<html> <font color=\"#ffffff\"> Dice </font> </html>"));
        dicePanel.setBackground(Color.darkGray);
        dicePanel.setLayout(new GridLayout(3, 1));

        JTextField emptyDice = new JTextField(50);
        emptyDice.setBackground(Color.darkGray);
        emptyDice.setEditable(false);
        dicePanel.add(emptyDice);

        dicePanel.add(Main.getDiceButton());
        Color color = new Color(150, 0, 0);
        Main.getDiceButton().setBackground(color);

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

        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.CENTER;
        storyPanel.add(Main.getChoiceOne(), c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.CENTER;
        storyPanel.add(Main.getChoiceTwo(), c);

        c.gridx = 2;
        c.anchor = GridBagConstraints.CENTER;
        storyPanel.add(Main.getChoiceThree(), c);

        Main.getChoiceOne().setFont(new Font("Arial", Font.BOLD, 20));
        Main.getChoiceTwo().setFont(new Font("Arial", Font.BOLD, 20));
        Main.getChoiceThree().setFont(new Font("Arial", Font.BOLD, 20));

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
        storyLabel.setText("<html> <div style='width:500px;'> " + Main.getStoryText().getText() + "</div> </html>");
    }
}
