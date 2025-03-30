import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main {
    public static Map<String, ChoiceClass> storyScenes = new HashMap<String, ChoiceClass>();

    public static boolean isLastSentence = false;
    private static ChoiceClass currentScene;
    private static int currentRoom = 0;

    private static JLabel storyText = new JLabel("Story Text");
    private static JButton choiceOne = new JButton("Choice 1");
    private static JButton choiceTwo = new JButton("Choice 2");
    private static JButton choiceThree = new JButton("Choice 3");

    private static ArrayList<Room> rooms = new ArrayList<Room>();

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameFrame frame = new GameFrame();
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                //JFrame frame = new JFrame("MainScreen");
                /*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);

                //Main panel
                JPanel mainPanel = new JPanel();
                mainPanel.setBorder(new TitledBorder("The Game"));
                mainPanel.setLayout(new BorderLayout());
                frame.add(mainPanel);

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
                JButton diceButton = new JButton("Roll dice");
                dicePanel.add(diceButton);
                diceButton.setBackground(Color.RED);
                dicePanel.add(new JTextField(50));
                /*
                JLabel diceLabel = new JLabel("Dice");
                JButton diceButton = new JButton("Roll dice");

                dicePanel.add(diceLabel);
                dicePanel.add(diceButton);
                diceButton.setSize(200, 200);*/
               // mainPanel.add(dicePanel, BorderLayout.EAST);

                //Story Panel
                /*JPanel storyPanel = new JPanel();
                storyPanel.setBorder(new TitledBorder("Story Text"));
                storyText.setFont(new Font("Arial", Font.BOLD, 20));
                storyPanel.setLayout(new GridBagLayout());*/

                //GroupLayout layout = new GroupLayout(storyPanel);
                //storyPanel.setLayout(layout);


               /* GridBagConstraints c = new GridBagConstraints();

                c.gridx = 0;
                c.gridy = 0;
                c.gridwidth = 3;
                c.insets = new Insets(10, 10, 10, 10);
                c.anchor = GridBagConstraints.CENTER;
                storyPanel.add(storyText, c);

                c.gridy = 1;
                c.gridwidth = 1;
                c.anchor = GridBagConstraints.CENTER;
                storyPanel.add(choiceOne, c);

                c.gridx = 1;
                c.anchor = GridBagConstraints.CENTER;
                storyPanel.add(choiceTwo, c);

                c.gridx = 2;
                c.anchor = GridBagConstraints.CENTER;
                storyPanel.add(choiceThree, c);

                choiceOne.setFont(new Font("Arial", Font.BOLD, 20));
                choiceTwo.setFont(new Font("Arial", Font.BOLD, 20));
                choiceThree.setFont(new Font("Arial", Font.BOLD, 20));

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





/*
                frame.pack();
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);*/
            }
        });

        rooms.add(new Lobby());
        rooms.add(new Room1());
        rooms.add(new Room2());

        rooms.get(0).PlayRoom();


        System.out.println("Hello and welcome!");
        System.out.println("Please type which room you would like to go to");

    }


    public static void ChooseRoom(int choice) {
        rooms.get(choice).PlayRoom();
    }

    public static boolean bool = true;

    public static void setChoiceOne(ChoiceClass scene) {

       bool = true;
       choiceOne.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(bool) {
                   currentScene = scene;
                   UpdateText();
                   System.out.println("Dialogue change");
                   rooms.get(currentRoom).StartRoom();
               }
           }
       });
    }

    public static void setChoiceOne(int scene) {

        bool = false;
        choiceOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!bool) {
                    System.out.println("Room change");
                    currentRoom = scene;
                    ChooseRoom(scene);
                    rooms.get(currentRoom).StartRoom();
                    isLastSentence = false;
                }

            }
        });
    }

    public static JButton getChoiceOne() {
        return choiceOne;
    }


    public static void setChoiceTwo(ChoiceClass scene) {

        bool = true;
        choiceTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bool) {
                    currentScene = scene;
                    UpdateText();
                    rooms.get(currentRoom).StartRoom();
                    System.out.println("Dialogue change");
                }
            }
        });
    }

    public static void setChoiceTwo(int scene) {

        bool = false;
        choiceTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!bool) {
                    System.out.println("Room change");
                    ChooseRoom(scene);
                    currentRoom = scene;
                    rooms.get(currentRoom).StartRoom();
                    isLastSentence = false;
                }

            }
        });
    }
    public static JButton getChoiceTwo() {
        return choiceTwo;
    }

    public static void setChoiceThree(ChoiceClass scene) {

        bool = true;
        choiceThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bool) {
                    currentScene = scene;
                    UpdateText();
                    rooms.get(currentRoom).StartRoom();
                    System.out.println("Dialogue change");
                }
            }
        });
    }

    public static void setChoiceThree(int scene) {

        bool = false;
        choiceThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!bool) {
                    System.out.println("Room change");
                    ChooseRoom(scene);
                    currentRoom = scene;
                    rooms.get(currentRoom).StartRoom();
                    isLastSentence = false;
                }

            }
        });
    }
    public static JButton getChoiceThree() {
        return choiceThree;
    }

    public static JLabel getStoryText() {
        return storyText;
    }

    public static void UpdateText() {
        if(currentScene != null) {
            storyText.setText(currentScene.getStoryText());
            choiceOne.setText(currentScene.getChoice1text());
            choiceTwo.setText(currentScene.getChoice2text());
            choiceThree.setText(currentScene.getChoice3text());
        }
    }

    public static void setCurrentScene(ChoiceClass choice) {
        currentScene = choice;
    }

    public static ChoiceClass getCurrentScene() {
        return currentScene;
    }


}