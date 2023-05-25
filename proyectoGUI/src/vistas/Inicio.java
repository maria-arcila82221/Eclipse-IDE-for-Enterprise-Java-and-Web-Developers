package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTree;
import javax.swing.JTextField;

public class Inicio {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Menú principal");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel_1.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		JTree tree = new JTree();
		panel_2.add(tree);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 128, 255));
		frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_3.add(lblNewLabel_4);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
	}

}
