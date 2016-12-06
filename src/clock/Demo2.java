package clock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Demo2 extends JFrame {

	private JPanel contentPane;
	
	public Demo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoToDemo = new JButton("go to demo 1");
		btnGoToDemo.setBounds(125, 128, 189, 23);
		contentPane.add(btnGoToDemo);
	}

}
