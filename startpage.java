package strat;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.event.*;

public class startpage extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox dropdown;

    private int size;


    public startpage() {
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
    }

    private void onOK() {
        //takes input from the dropdown menu
        size = dropdown.getSelectedIndex();
        numbers frame = new numbers();
        System.out.println(size);

        frame.visible();        //pretend this works

        dispose();
    }


    //calls size
    public int getDimensions() {
        System.out.println(size);
        return size;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        startpage dialog = new startpage();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
