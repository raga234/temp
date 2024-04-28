import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Java_2_CalculatorImage extends Frame implements ActionListener 
{
    private Image backgroundImage;

    private Label label1 = new Label("Enter 1st number:");
    private Label label2 = new Label("Enter 2nd number:");
    private Label label3 = new Label("Result:");

    private TextField textField1 = new TextField();
    private TextField textField2 = new TextField();
    private TextField textField3 = new TextField();

    private Button button1 = new Button("+");
    private Button button2 = new Button("-");
    private Button button3 = new Button("*");
    private Button button4 = new Button("/");
    private Button button5 = new Button("%");

    public Java_2_CalculatorImage()
    {
        super("Calculator Application");
        backgroundImage = Toolkit.getDefaultToolkit().getImage("imagebg.jpg");

        setLayout(null);

        label1.setBounds(20, 40, 110, 20);
        label2.setBounds(20, 70, 110, 20);
        label3.setBounds(20, 100, 110, 20);

        textField1.setBounds(140, 40, 100, 20);
        textField2.setBounds(140, 70, 100, 20);
        textField3.setBounds(140, 100, 100, 20);

        button1.setBounds(260, 40, 80, 20);
        button2.setBounds(260, 70, 80, 20);
        button3.setBounds(260, 100, 80, 20);
        button4.setBounds(260, 130, 80, 20);
        button5.setBounds(260, 160, 80, 20);

        add(label1);
        add(label2);
        add(label3);

        add(textField1);
        add(textField2);
        add(textField3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);

        setSize(400, 220);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int num1 = Integer.parseInt(textField1.getText());
        int num2 = Integer.parseInt(textField2.getText());

        String string = e.getActionCommand();

        if (string.equals("+")) 
        {
            int result = num1 + num2;
            textField3.setText(Integer.toString(result));
        } else if (string.equals("-")) 
        {
            int result = num1 - num2;
            textField3.setText(Integer.toString(result));
        } else if (string.equals("*")) 
        {
            int result = num1 * num2;
            textField3.setText(Integer.toString(result));
        } else if (string.equals("/")) 
        {
            int result = num1 / num2;
            textField3.setText(Integer.toString(result));
        } else if (string.equals("%")) 
        {
            int result = num1 % num2;
            textField3.setText(Integer.toString(result));
        }
    }

    public static void main(String[] args) 
    {
        new Java_2_CalculatorImage();
    }
}
