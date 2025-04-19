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

    public static ArrayList<String> items = new ArrayList<String>();

    private static ChoiceClass currentScene;
    private static int currentRoom = 0;

    private static int choiceOneRoom, choiceTwoRoom, choiceThreeRoom;
    private static ChoiceClass choiceOneScene, choiceTwoScene, choiceThreeScene;
    private static boolean choiceOneRoomSwitch = false, choiceTwoRoomSwitch = false, choiceThreeRoomSwitch = false;

    private static JLabel storyText = new JLabel("Story Text");
    private static JButton choiceOne = new JButton("Choice 1");
    private static JButton choiceTwo = new JButton("Choice 2");
    private static JButton choiceThree = new JButton("Choice 3");

    private static JButton diceButton = new JButton("Roll dice");
    private static ArrayList<Room> rooms = new ArrayList<Room>();
    public static GameFrame frame;

    private static boolean closeSystem = false;

    public static void main(String[] args)  {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame = new GameFrame();
                frame.setVisible(true);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            }
        });

        rooms.add(new FrontOfTheHouse());
        rooms.add(new Lobby());
        rooms.add(new DinningRoom());
        rooms.add(new Kitchen());
        rooms.add(new UpstairsHallway());
        rooms.add(new Bathroom());
        rooms.add(new Bedroom());
        rooms.add(new SecretBasement());
        rooms.add(new PrisonCell());
        rooms.add(new EndScene());

        rooms.get(0).PlayRoom();


        choiceOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(closeSystem){System.exit(0);}

                if(choiceOneRoomSwitch) {
                    currentRoom = choiceOneRoom;
                    ChooseRoom(currentRoom);
                    choiceOneRoomSwitch = false;
                }
                else
                {
                    currentScene = choiceOneScene;
                }
                rooms.get(currentRoom).StartRoom();
                UpdateText();
                frame.refreshStoryLabel();

            }
        });

        choiceTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(closeSystem){System.exit(0);}
                if(choiceTwoRoomSwitch) {
                    currentRoom = choiceTwoRoom;
                    ChooseRoom(currentRoom);
                    choiceTwoRoomSwitch = false;
                }
                else
                {
                    currentScene = choiceTwoScene;
                }
                rooms.get(currentRoom).StartRoom();
                UpdateText();
                frame.refreshStoryLabel();

            }
        });

        choiceThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(closeSystem){System.exit(0);}
                if(choiceThreeRoomSwitch) {
                    currentRoom = choiceThreeRoom;
                    ChooseRoom(currentRoom);
                    choiceThreeRoomSwitch = false;
                }
                else
                {
                    currentScene = choiceThreeScene;
                }
                rooms.get(currentRoom).StartRoom();
                UpdateText();
                frame.refreshStoryLabel();

            }
        });

        diceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCurrentScene().Attack();
            }

        });

    }

    public static void setChoiceOne(ChoiceClass scene) {
        choiceOneScene = scene;
        choiceOneRoomSwitch = false;
    }

    public static void setChoiceOne(int scene) {
        if(scene == -1){closeSystem = true;}
        choiceOneRoom = scene;
        choiceOneRoomSwitch = true;
    }

    public static void setChoiceTwo(ChoiceClass scene) {
        choiceTwoScene = scene;
        choiceTwoRoomSwitch = false;
    }

    public static void setChoiceTwo(int scene) {
        if(scene == -1){closeSystem = true;}
        choiceTwoRoom = scene;
        choiceTwoRoomSwitch = true;
    }

    public static void setChoiceThree(ChoiceClass scene) {
        choiceThreeScene = scene;
        choiceThreeRoomSwitch = false;
    }

    public static void setChoiceThree(int scene) {
        if(scene == -1){closeSystem = true;}
        choiceThreeRoom = scene;
        choiceThreeRoomSwitch = true;
    }


    public static void ChooseRoom(int choice) {
        rooms.get(choice).PlayRoom();
        frame.refreshStoryLabel();
    }



    public static JButton getChoiceOne() {
        return choiceOne;
    }



    public static JButton getChoiceTwo() {
        return choiceTwo;
    }


    public static JButton getChoiceThree() {
        return choiceThree;
    }

    public static JLabel getStoryText() {
        return storyText;
    }

    public static void setStoryText(String text) {
        storyText.setText(text);
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

    public static void FinishCombatScene(){
        rooms.get(currentRoom).StartRoom();
        UpdateText();
        frame.refreshStoryLabel();
        choiceOne.setEnabled(true);
        choiceTwo.setEnabled(true);
        choiceThree.setEnabled(true);
    }


}