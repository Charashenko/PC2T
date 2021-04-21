package cv11;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Main extends JFrame {

    private static JLabel label = new JLabel(" ");

    public static void main(String[] args) {
        JFrame root = new JFrame();
        JPanel buttonPanel = new JPanel();
        JButton bplus = new JButton("+");
        JButton bminus = new JButton("-");
        JButton bmult = new JButton("*");
        JButton bdiv = new JButton("/");
        JButton bmod = new JButton("%");
        JButton beq = new JButton("=");
        List<JButton> opBtns = List.of(bplus, bminus, bmult, bdiv, bmod);
        ActionListener pressedBtnEvent = e -> label.setText(label.getText() + ((JButton) e.getSource()).getText());
        beq.addActionListener(e -> {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            try {
                label.setText(String.valueOf(engine.eval(label.getText())));
            } catch (ScriptException scriptException) {
                scriptException.printStackTrace();
                label.setText(" ");
            }
        });
        label.setHorizontalAlignment(JLabel.CENTER);
        label.getInsets().set(10,0,10,0);
        label.setFont(new Font("", Font.BOLD, 25));
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
        for (JButton btn : opBtns){
            btn.addActionListener(pressedBtnEvent);
            buttonPanel.add(btn);
        }
        root.getContentPane().add(buttonPanel);
        root.add(beq, BorderLayout.SOUTH);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setVisible(true);
    }
}
