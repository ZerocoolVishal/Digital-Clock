package clock;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dmo {

	private JFrame frmDemo;

	public static void main(String[] args) {
	
		try {
			Dmo window = new Dmo();
			window.frmDemo.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dmo() {
		
		frmDemo = new JFrame();
		frmDemo.setTitle("Demo");
		frmDemo.setResizable(false);
		frmDemo.setBounds(100, 100, 604, 370);
		frmDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDemo.getContentPane().setLayout(null);
		
		JLabel lblFrame = new JLabel("Frame 1");
		lblFrame.setBounds(142, 110, 46, 14);
		frmDemo.getContentPane().add(lblFrame);
		
		JButton btnGoToFrame = new JButton("go to frame 2");
		btnGoToFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnGoToFrame.setBounds(202, 291, 150, 23);
		frmDemo.getContentPane().add(btnGoToFrame);
	}
}
