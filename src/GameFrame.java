import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GameFrame extends JFrame {

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
        titlePanel.setBackground(Color.white);
        JLabel titleLabel = new JLabel("The coolest game ever");
        titlePanel.add(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        //Player Panel
        JPanel playerStats = new JPanel();
        playerStats.setBorder(new TitledBorder("Player Stats"));
        playerStats.setLayout(new GridLayout(3, 1));
        playerStats.add(new JTextField(50));
        playerStats.add(new JTextField(50));
        mainPanel.add(playerStats, BorderLayout.WEST);


        //Dice Panel
        JPanel dicePanel = new JPanel();
        dicePanel.setBorder(new TitledBorder("Dice"));
        dicePanel.setLayout(new GridLayout(3, 1));
        dicePanel.add(new JTextField(50));
        dicePanel.add(Main.getDiceButton());
        Main.getDiceButton().setBackground(Color.RED);
        dicePanel.add(new JTextField(50));
                /*
                JLabel diceLabel = new JLabel("Dice");
                JButton diceButton = new JButton("Roll dice");

                dicePanel.add(diceLabel);
                dicePanel.add(diceButton);
                diceButton.setSize(200, 200);*/
        mainPanel.add(dicePanel, BorderLayout.EAST);

        //Story Panel
        JPanel storyPanel = new JPanel();
        storyPanel.setBorder(new TitledBorder("Story Text"));
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
        storyPanel.add(Main.getStoryText(), c);

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
}
