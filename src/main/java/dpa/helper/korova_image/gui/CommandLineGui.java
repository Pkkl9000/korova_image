package dpa.helper.korova_image.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandLineGui {

    static String newInputLine;

    public static void createAndShowJFrame() {
        JFrame frame = new JFrame("Cmd-like GUI");

        JTextArea textArea = new JTextArea();
        textArea.setEditable(true); // Allow text to be entered
        textArea.setLineWrap(true); // Enable line wrapping

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(scrollPane);
        frame.setAlwaysOnTop(true);

        frame.setSize(400, 300);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int rightSide = (int) screenSize.getWidth() - frame.getWidth();
        int bottom = screenSize.height - frame.getHeight();

        frame.setLocation(rightSide, bottom);
        frame.setVisible(true);

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Command accepted");
                    String text = textArea.getText();
                    String[] lines = text.split("\\n");
                    String previousLine = lines[lines.length - 1];

                    System.out.println("command: " + previousLine);

                    setNewInputLine(previousLine);
//                    CommandManager.setNewCommand(previousLine);
//                    CommandManager.sjej();
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void setNewInputLine(String newInputLine) {
        CommandLineGui.newInputLine = newInputLine;
    }

    public String getNewInputLine() {
        return newInputLine;
    }



}

