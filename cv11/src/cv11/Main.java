package cv11;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private static JLabel label = new JLabel(" ");

    public static void main(String[] args) {
        JFrame root = new JFrame();
        JPanel buttonPanel = new JPanel();
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton bplus = new JButton("+");
        JButton bminus = new JButton("-");
        JButton beq = new JButton("=");
        ActionListener pressedBtnEvent = e -> {
            JButton pressedBtn = (JButton) e.getSource();
            label.setText(label.getText() + pressedBtn.getText());
        };
        ActionListener pressedEq = e -> {
            ScriptEngineManager mngr = new ScriptEngineManager();
            ScriptEngine engine = mngr.getEngineByName("JavaScript");
            try {
                label.setText(String.valueOf(engine.eval(label.getText())));
            } catch (ScriptException scriptException) {
                scriptException.printStackTrace();
            }
        };
        beq.addActionListener(pressedEq);
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBorder(new BasicBorders.ButtonBorder(Color.DARK_GRAY, Color.BLACK, Color.DARK_GRAY, Color.BLACK));
        root.setSize(300, 200);
        root.setResizable(false);
        root.setTitle("Kalkulacka");
        root.setLayout(new BorderLayout());
        root.getContentPane().add(label, BorderLayout.NORTH);
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.add(b0);
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(bplus);
        buttonPanel.add(bminus);
        for(Component c : buttonPanel.getComponents()){
            ((JButton) c).addActionListener(pressedBtnEvent);
        }
        root.getContentPane().add(buttonPanel);
        root.add(beq, BorderLayout.SOUTH);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setVisible(true);
    }
}
