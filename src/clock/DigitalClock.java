package clock;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Clock extends Thread {
	
	JLabel display;
	Date date = new Date();
	
	Clock (JLabel display) {
		
		this.display = display;
	}

	public void run () {
		
		while (true) {
			
			date = new Date();
			display.setText(date.getHours() + " : " + date.getMinutes() + " : " + date.getSeconds());
		}
	}
}

class ReverseClock extends Thread {
	
	JLabel display;
	Date date = new Date();
	
	ReverseClock (JLabel display) {
		
		this.display = display;
	}

	public void run () {
		
		while (true) {
			
			date = new Date();
			display.setText((24 - date.getHours()) + " : " + (60 - date.getMinutes()) + " : " + (60 - date.getSeconds()));
		}
	}
}

class ClockDate extends Thread {
	
	JLabel display;
	Date date = new Date();
	
	ClockDate (JLabel display) {
		
		this.display = display;
	}

	public void run () {
		
		while (true) {
			
			date = new Date();
			display.setText(date.getDate() + " : " + (date.getMonth() + 1) + " : " + (date.getYear() + 1900) );
		}
	}
}

class SpeacialEvents extends Thread {
	
	JLabel display;
	Date date = new Date();
	
	SpeacialEvents (JLabel display) {
		
		this.display = display;
	}

	public void run () {
		
		while (true) {
			
			date = new Date();
			//jan
			if (date.getDate() == 1 && (date.getMonth() + 1) == 1) {
				
				display.setText("Happy New Year");
			} else if (date.getDate() == 9 && (date.getMonth() + 1) == 1) {
				
				display.setText("Pravasi Bharatiya Divas");
			} else if (date.getDate() == 12 && (date.getMonth() + 1) == 1) {
				
				display.setText("National Youth Day");
			} 
			
			else {
				
				if (date.getSeconds() < 50) {
					
					display.setText("Digital Clock");
				} else {
					
					display.setText("Vishal Bhosle");
				}
			}
		}
	}
}

public class DigitalClock {

	Clock clock;
	ClockDate clockDate;
	SpeacialEvents speacialEvents;
	ReverseClock reverseClock;
	boolean rev = true;
	private JFrame frmDigitalClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClock window = new DigitalClock();
					window.frmDigitalClock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DigitalClock() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDigitalClock = new JFrame();
		frmDigitalClock.setResizable(false);
		frmDigitalClock.getContentPane().setBackground(new Color(51, 51, 51));
		frmDigitalClock.getContentPane().setLayout(null);
		frmDigitalClock.setBackground(Color.BLACK);
		frmDigitalClock.setTitle("Digital Clock");
		frmDigitalClock.setBounds(100, 100, 766, 343);
		frmDigitalClock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Made by Vishal Bhosle");
			}
		});
		lblNewLabel.setForeground(new Color(0, 204, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 72, 679, 169);
		lblNewLabel.setFont(new Font("ChessType",Font.PLAIN,100));
		frmDigitalClock.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 204, 0));
		clock = new Clock(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(0, 204, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(147, 11, 466, 78);
		lblNewLabel_1.setFont(new Font("ChessType",Font.PLAIN,40));
		frmDigitalClock.getContentPane().add(lblNewLabel_1);
		clockDate = new ClockDate(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel();
		reverseClock = new ReverseClock(lblNewLabel);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				if (rev == true) {
					clock.stop();
					reverseClock.start();
					rev = false;
				}
			}
		});
		lblNewLabel_2.setBounds(10, 252, 740, 51);
		lblNewLabel_2.setForeground(new Color(138, 43, 226));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("ChessType",Font.PLAIN,30));
		frmDigitalClock.getContentPane().add(lblNewLabel_2);
		
		
		
		speacialEvents = new SpeacialEvents(lblNewLabel_2);
		
		clock.start();
		clockDate.start();
		speacialEvents.start();
	}
}
