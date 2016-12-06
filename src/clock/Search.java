package clock;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Search {

	private JFrame frmSearch;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
					window.frmSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearch = new JFrame();
		frmSearch.setAlwaysOnTop(true);
		frmSearch.setResizable(false);
		frmSearch.setType(Type.UTILITY);
		frmSearch.setTitle("Search");
		frmSearch.setBounds(100, 100, 567, 114);
		frmSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearch.getContentPane().setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("");
		txtSearch.setForeground(Color.BLACK);
		txtSearch.setBackground(SystemColor.window);
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 60));
		txtSearch.setBounds(0, 0, 561, 85);
		frmSearch.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
	}

}
