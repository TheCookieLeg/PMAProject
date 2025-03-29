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

    public static ChoiceClass transistion = new ChoiceClass("", "", "", "");
    public static boolean isLastSentence = false;
    private static ChoiceClass currentScene;

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


                pane.add(storyText, BorderLayout.PAGE_START);
                pane.add(choiceOne, BorderLayout.LINE_START);
                pane.add(choiceTwo, BorderLayout.CENTER);
                pane.add(choiceThree, BorderLayout.LINE_END);

                frame.pack();
                frame.setVisible(true);
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

        //storyText.setText("Welcome to the story screen! Please type which room you would like to go to");

        //choiceOne.setText("Room 1");


        isLastSentence = true;
        setChoiceOne(currentScene, 1);
        /*choiceOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                storyText.setText("You did something!");
                System.out.println("Button clicked");
                ChooseRoom(0);
            }
        });*/

        //choiceTwo.setText("Room 2");
        /*choiceTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Button clicked");
                ChooseRoom(1);
            }
        });*/
      //  choiceThree.setText("Room 3");
        /*choiceThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
                ChooseRoom(2);
            }
        });*/


    }


    public static void ChooseRoom(int choice) {
        rooms.get(choice).PlayRoom();
    }



    public static void setChoiceOne(ChoiceClass scene, int roomNumber) {
        choiceOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    currentScene = scene;
                    UpdateText();

                if(isLastSentence && roomNumber != -1){
                    ChooseRoom(roomNumber);
                    isLastSentence = false;
                }

            }
        });

    }

   public static void setRoomChoiceOne(int scene) {
        choiceOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseRoom(scene);
            }
        });
    }

    public static JButton getChoiceOne() {
        return choiceOne;
    }


    public static void setChoiceTwo(ChoiceClass scene, int roomNumber) {
        choiceTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentScene = scene;
                UpdateText();

                if(isLastSentence && roomNumber != -1){
                    ChooseRoom(roomNumber);
                    isLastSentence = false;
                }

            }
        });

    }
    public static JButton getChoiceTwo() {
        return choiceTwo;
    }

    public static void setChoiceThree(ChoiceClass scene, int roomNumber) {
        choiceThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentScene = scene;
                UpdateText();


                if(isLastSentence && roomNumber != -1){
                    ChooseRoom(roomNumber);
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