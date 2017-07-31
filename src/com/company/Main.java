package com.company;

import javax.swing.*;

public class Main {
    static int counter = 0;

    public static void main(String[] args) {
        Command c = new Command();
        TextEditor editor = new TextEditor(c);
        editor.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(editor,
                        "Actions performed "+ counter, "Closing",
                        JOptionPane.OK_OPTION
                        ) == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
       // System.out.println(counter);
    }
}
