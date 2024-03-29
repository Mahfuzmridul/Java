import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JFrame {

    private Container c;
    private JLabel imglabel, textlabel;
    private JTextArea ta;
    private JTextField tf;
    private JButton clrbtn;
    private ImageIcon img;
    private Font fn = new Font("Tahoma", Font.BOLD + Font.ITALIC, 18), fn2 = new Font("Arial", Font.BOLD, 25),
            fn3 = new Font("Arial", Font.BOLD, 20);
    private Cursor cur = new Cursor(Cursor.HAND_CURSOR);
    private JScrollPane scroll;

    Table() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        img = new ImageIcon(getClass().getResource("img863473.jpg"));

        imglabel = new JLabel(img);
        imglabel.setBounds(3, 10, img.getIconWidth(), img.getIconHeight());
        c.add(imglabel);

        textlabel = new JLabel("Enter any number : ");
        textlabel.setBounds(20, 200, 250, 40);
        textlabel.setForeground(Color.MAGENTA);
        textlabel.setFont(fn);
        c.add(textlabel);

        tf = new JTextField();
        tf.setBounds(220, 195, 100, 50);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setFont(fn2);
        tf.setBackground(Color.GREEN);
        c.add(tf);

        clrbtn = new JButton("Clear");
        clrbtn.setBounds(225, 250, 90, 50);
        clrbtn.setBackground(Color.YELLOW);
        clrbtn.setForeground(Color.BLACK);
        clrbtn.setCursor(cur);
        clrbtn.setFont(fn3);
        c.add(clrbtn);

        ta = new JTextArea();
        ta.setBackground(Color.GREEN);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(fn3);

        scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(23, 320, 300, 320);
        c.add(scroll);

        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String val = tf.getText();
                if (val.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You didn't put any number");
                } else {
                    ta.setText("");
                    int num = Integer.parseInt(tf.getText());

                    for (int i = 1; i <= 10; i++) {
                        int ans = num * i;

                        String r = String.valueOf(ans);
                        String n = String.valueOf(num);
                        String in = String.valueOf(i);

                        ta.append(n + " X " + in + " = " + r + "\n");
                    }
                }
            }
        });

        clrbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
                tf.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Table frame = new Table();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 20, 360, 700);
        frame.setTitle("Multiplication Table");

    }
}
