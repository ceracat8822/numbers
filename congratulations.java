package strat;

import javax.swing.*;
import java.awt.event.*;

public class congratulations extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel congrats;

    public congratulations() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        //setting text
        numbers frame = new numbers();
        congrats.setText("Congratulations! You got " + frame.getScore() + " out of 64 in " + frame.getTime() + ".");
    }

    private void onOK() {   //retry
        // add your code here
        //go back to numbers here
        numbers frame = new numbers();
        frame.visible();

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        // go to starting page

        dispose();
    }

    public static void main(String[] args) {
        congratulations dialog = new congratulations();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
