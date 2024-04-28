import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class Circle {
    private JFrame frame;
    private JPanel panel;
    private JTextField display;

    private double num1, num2, result;
    private char operator;

    public Circle() {
        frame = new JFrame("Calculator");
        panel = new JPanel();
        display = new JTextField(30); // Adjust the number of columns here

        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        panel.setLayout(new GridLayout(5, 4));
        frame.getContentPane().add(BorderLayout.NORTH, display);
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        addButton("7");
        addButton("8");
        addButton("9");
        addButton("/");
        addButton("4");
        addButton("5");
        addButton("6");
        addButton("*");
        addButton("1");
        addButton("2");
        addButton("3");
        addButton("-");
        addButton("0");
        addButton(".");
        addButton("=");
        addButton("+");
        addButton("C");

        frame.setSize(400, 300); // Adjust frame size accordingly
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addButton(String label) {
        CircleButton button = new CircleButton(label);
        button.addActionListener(new ButtonListener());
        panel.add(button);
    }

    class CircleButton extends JButton {
        public CircleButton(String label) {
            super(label);
            Dimension size = getPreferredSize();
            size.width = size.height = Math.max(size.width, size.height);
            setPreferredSize(size);
            setContentAreaFilled(false);
        }

        protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(Color.lightGray);
            } else {
                g.setColor(getBackground());
            }
            g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
            super.paintComponent(g);
        }

        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
        }

        Shape shape;

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
            }
            return shape.contains(x, y);
        }
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = ((JButton) e.getSource()).getText();
            if ("0123456789.".indexOf(text) != -1) {
                display.setText(display.getText() + text);
            } else if ("/*-+".indexOf(text) != -1) {
                operator = text.charAt(0);
                num1 = Double.parseDouble(display.getText());
                display.setText(display.getText() + " " + operator + " ");
            } else if (text.equals("=")) {
                String expression = display.getText();
                num2 = Double.parseDouble(expression.substring(expression.lastIndexOf(" ") + 1));
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            display.setText("Error");
                            return;
                        } else {
                            result = num1 / num2;
                        }
                        break;
                }
                display.setText("" + result);
            } else if (text.equals("C")) {
                display.setText("");
                num1 = 0;
                num2 = 0;
                result = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Circle();
    }
}
