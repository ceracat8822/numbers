package strat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class numbers {
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton a4;
    private JButton a5;
    private JButton a6;
    private JButton a7;
    private JButton a8;
    private JButton startButton;
    private JLabel Time;
    private JButton stopButton;
    private JPanel window;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton c1;
    private JButton c2;
    private JButton c3;
    private JButton c4;
    private JButton c5;
    private JButton c6;
    private JButton c8;
    private JButton c7;
    private JButton d2;
    private JButton d3;
    private JButton d4;
    private JButton d5;
    private JButton d6;
    private JButton d7;
    private JButton d8;
    private JButton d1;
    private JButton e2;
    private JButton e3;
    private JButton e4;
    private JButton e5;
    private JButton e6;
    private JButton e7;
    private JButton e8;
    private JButton e1;
    private JButton f2;
    private JButton f3;
    private JButton f4;
    private JButton f5;
    private JButton f6;
    private JButton f7;
    private JButton f8;
    private JButton f1;
    private JButton g2;
    private JButton g3;
    private JButton g4;
    private JButton g5;
    private JButton g6;
    private JButton g7;
    private JButton g8;
    private JButton g1;
    private JButton h2;
    private JButton h3;
    private JButton h4;
    private JButton h5;
    private JButton h6;
    private JButton h7;
    private JButton h8;
    private JButton h1;
    private JLabel pressed;
    private JLabel text;
    private JLabel counter;


    // initialization at some point do this like hide buttons and stuff
    public static void main(String[] args) {
        JFrame frame = new JFrame("numbers");
        frame.setContentPane(new numbers().window);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }

    private int score;

    public numbers() {

        //storing stuff for use on the second press
        final boolean[] press = {false};        //whether or not a button has been pressed
        final int[] temp = new int[1];       // the number of the button pressed
        final JButton[] but = new JButton[1];  //the actual JButton that was pressed

        startpage page = new startpage();
        int size = page.getDimensions();
        System.out.println(size);

        startButton.addActionListener(new ActionListener() {
            Instant start;      //i think i copy pasted this
            @Override
            public void actionPerformed(ActionEvent e) {

                // timer shenanigans
                start = Instant.now();  //same with this
                Timer timer = new Timer(1, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int min = 0;

                        //increase to minutes
                        if (Duration.between(start, Instant.now()).getSeconds() == 60) {
                            min += 1;
                        }
                        else {
                            Time.setText("Time: " + Duration.between(start, Instant.now()).getSeconds() + " sec");
                        }
                        if (min >= 1) {
                            Time.setText(min + ":" + (Duration.between(start, Instant.now()).getSeconds())%60); //this doesnt work come back to it
                        }
                    }
                });
                timer.start();

                //matrix time
                JButton[][] buttons = {{a1, a2, a3, a4, a5, a6, a7, a8},
                        {b1, b2, b3, b4, b5, b6, b7, b8},
                        {c1, c2, c3, c4, c5, c6, c7, c8},
                        {d1, d2, d3, d4, d5, d6, d7, d8},
                        {e1, e2, e3, e4, e5, e6, e7, e8},
                        {f1, f2, f3, f4, f5, f6, f7, f8},
                        {g1, g2, g3, g4, g5, g6, g7, g8},
                        {h1, h2, h3, h4, h5, h6, h7, h8}
                };

                //resetting things for a reset
                //making all the buttons visible on a reset
                for (int row = 0; row < buttons.length; row ++) {
                    for (int col = 0; col < buttons[row].length; col++) {
                        buttons[row][col].setVisible(true);
                    }
                }
                but[0] = null;
                press[0] = false;
                pressed.setText("unpressed");
                temp[0] = 0;
                score = 0;
                counter.setText("Score: " + score);

                //instead of a random number generator we will choose the numbers


                Random random = new Random();  //random number generator

                // assigning numbers matrix style
                for (int row = 0; row < buttons.length; row++) {
                    for (int col = 0; col < buttons[row].length; col++){
                        int rand = random.nextInt((103 - 2) + 1) + 2;
                        buttons[row][col].setText(rand + "");
                    }
                }
                // attempting to compare the buttons
                for (int row = 0; row < buttons.length; row++) {
                    for (int col = 0; col < buttons[row].length; col++){
                        int finalRow = row; // idk why i need this but java was yelling
                        int finalCol = col; // same with this


                        buttons[row][col].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Object source = e.getSource(); //idk what these 2 lines mean but it works
                                JButton button = (JButton) source;
                                int newtemp = Integer.parseInt(e.getActionCommand());

                                if (but[0] == e.getSource()) {      //unpressing
                                    //resseting stuff
                                    but[0] = null;
                                    press[0] = false;
                                    temp[0] = 0;
                                    pressed.setText("unpressed");

                                }
                                else if (press[0]) {        // when pressed but not itself
                                    if (newtemp % temp[0] == 0) {       //if it divides fully
                                        if (newtemp/temp[0] == 1) {     //if they are the same number

                                            button.setVisible(false);
                                            but[0].setVisible(false);
                                            press[0] = false;
                                            score += 2;
                                            pressed.setText("unpressed");
                                            counter.setText("Score: " + score);
                                        }
                                        else {                          //if not the same number but still divides
                                            button.setText(newtemp / temp[0] + "");
                                            but[0].setVisible(false);
                                            press[0] = false;
                                            pressed.setText("unpressed");
                                            score += 1;
                                            counter.setText("Score: " + score);
                                        }

                                    }
                                    else if (temp[0] % newtemp ==0) {       //same as above but for the reverse of the numbers
                                        if (temp[0]/newtemp == 1) {
                                            button.setVisible(false);
                                            but[0].setVisible(false);
                                            press[0] = false;
                                            score += 2;
                                            pressed.setText("unpressed");
                                            counter.setText("Score: " + score);
                                        }
                                        else {
                                            but[0].setText(temp[0]/newtemp + "");
                                            button.setVisible(false);
                                            press[0] = false;
                                            pressed.setText("unpressed");
                                            score += 1;
                                            counter.setText("Score: " + score);
                                        }
                                    }
                                    else {
                                        // from tryingsmth      basically finds the factor
                                        while (true)  {             //looping the mod of the numbers to get to the end cause thats how math works
                                            int modst, modnd;
                                            modst = newtemp % temp[0];
                                            modnd = temp[0] % newtemp;
                                            newtemp = modst;
                                            temp[0] = modnd;

                                            if (modst == 1 || modnd == 1) {  //when actually indivisible
                                                text.setText("actually indivisible");
                                                break;
                                            }
                                            else if (modst == 0 || modnd == 0) {  //when has common factor
                                                if (modnd == 0) {
                                                    button.setText(Integer.parseInt(e.getActionCommand()) / modst + "");
                                                    but[0].setText(Integer.parseInt(but[0].getText()) / modst + "");
                                                    text.setText("has common factor: " + modst);
                                                }
                                                else {
                                                    button.setText(Integer.parseInt(e.getActionCommand()) / modnd + "");
                                                    but[0].setText(Integer.parseInt(but[0].getText()) / modnd + "");
                                                    text.setText("has common factor: " + modnd);
                                                }
                                                break;
                                            }
                                        }
                                        //resseting stuff
                                        but[0] = null;
                                        press[0] = false;
                                        pressed.setText("unpressed");
                                        temp[0] = 0;
                                    }


                                }
                                else {
                                    //the first button being pressed and storing all that info
                                    temp[0] = Integer.parseInt(button.getText());
                                    press[0] = true;
                                    but[0] = button;
                                    //changing the rows to letters
                                    String letter = null;
                                    switch (finalRow){
                                        case 0:
                                            letter = "A";
                                            break;
                                        case 1:
                                            letter = "B";
                                            break;
                                        case 2:
                                            letter = "C";
                                            break;
                                        case 3:
                                            letter = "D";
                                            break;
                                        case 4:
                                            letter = "E";
                                            break;
                                        case 5:
                                            letter = "F";
                                            break;
                                        case 6:
                                            letter = "G";
                                            break;
                                        case 7:
                                            letter = "H";
                                            break;
                                        default:
                                            
                                    }
                                    pressed.setText("pressed: " + letter + (finalCol+1));
                                }
                            }
                        });
                    }
                }
            }
        });


        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                storetime = Time.getText(); //working around the timer because i dont know how to stop it
                Time.setVisible(false);
                congratulations congrats = new congratulations();
                congrats.setVisible(true);
                congrats.pack();


            }
        });
    }

    //making a thing so i can get score in the congratulations section
    public int getScore() {
        return score;
    }

    //same here but with store time
    private String storetime;
    public String getTime() {
        return storetime;
    }

    //making it visible
    public void visible() {
        window.setVisible(true);
    }
}

