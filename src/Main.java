import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
                JFrame frame = new JFrame("MainScreen");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1920, 1080);



                Container pane = frame.getContentPane();

                GroupLayout layout = new GroupLayout(pane);

                pane.setLayout(layout);



                layout.setAutoCreateGaps(true);
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
                                .addComponent(choiceThree)));






                frame.pack();
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        rooms.add(new Lobby());
        rooms.add(new Room1());
        rooms.add(new Room2());

        rooms.get(0).PlayRoom();

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
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