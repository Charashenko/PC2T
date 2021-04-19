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
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(pressedBtnEvent);
            buttonPanel.add(button);
        }
        bplus.addActionListener(pressedBtnEvent);
        buttonPanel.add(bplus);
        bminus.addActionListener(pressedBtnEvent);
        buttonPanel.add(bminus);
        root.getContentPane().add(buttonPanel);
        root.add(beq, BorderLayout.SOUTH);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setVisible(true);
    }
}
