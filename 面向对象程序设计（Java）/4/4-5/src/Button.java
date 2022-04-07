import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Button {

    private JFrame frame;
    private JLabel lblNewLabel;
    private boolean flag = false;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Button window = new Button();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Button() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 288, 234);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        final JButton btnNewButton = new JButton("set red");
        btnNewButton.setBounds(20, 30, 120, 30);
        final JButton btnNewButton1 = new JButton("set green");
        btnNewButton1.setBounds(20, 70, 120, 30);
        final JButton btnNewButton2 = new JButton("set blue");
        btnNewButton2.setBounds(20, 110, 120, 30);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton.setBackground(Color.red);
                btnNewButton1.setBackground(Color.red);
                btnNewButton2.setBackground(Color.red);
            }
        });
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton.setBackground(Color.green);
                btnNewButton1.setBackground(Color.green);
                btnNewButton2.setBackground(Color.green);
            }
        });
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton.setBackground(Color.blue);
                btnNewButton1.setBackground(Color.blue);
                btnNewButton2.setBackground(Color.blue);
            }
        });
        frame.getContentPane().add(btnNewButton);
        frame.getContentPane().add(btnNewButton1);
        frame.getContentPane().add(btnNewButton2);

        lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(35, 107, 214, 36);
        frame.getContentPane().add(lblNewLabel);
    }
}
