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

    private static ChoiceClass currentScene;
    private static int currentRoom = 0;

    private static JLabel storyText = new JLabel("Story Text");
    private static JButton choiceOne = new JButton("Choice 1");
    private static JButton choiceTwo = new JButton("Choice 2");
    private static JButton choiceThree = new JButton("Choice 3");

    private static JButton diceButton = new JButton("Roll dice");
    private static ArrayList<Room> rooms = new ArrayList<Room>();
    private static GameFrame frame;

    public static void main(String[] args)  {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new GameFrame();
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            }
        });

        rooms.add(new Lobby());
        rooms.add(new Room1());
        rooms.add(new Room2());

        rooms.get(0).PlayRoom();


    }


    public static void ChooseRoom(int choice) {
        rooms.get(choice).PlayRoom();
        frame.refreshStoryLabel();
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

    public static JButton getDiceButton(){
        return diceButton;
    }


}