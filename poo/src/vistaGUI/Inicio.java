package vistaGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Inicio {

	private JFrame frame;
	
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelPrincipal panelPrincipal = new PanelPrincipal();
		frame.getContentPane().add(panelPrincipal,BorderLayout.CENTER);
	}


	
	/*private JTextField textUsuario;
	private JTextField textClave;

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

	public Inicio() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		//frame.setBackground(new Color(colorR, colorG, colorRGB));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelPrincipal panelSuperior = new PanelPrincipal();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLogin = new JPanel();
		panelSuperior.add(panelLogin, BorderLayout.WEST);
		panelLogin.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel IbIUsuario = new JLabel("Usuario");
		panelLogin.add(IbIUsuario);
		
		textUsuario = new JTextField();
		panelLogin.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		panelLogin.add(lblClave);
		
		textClave = new JTextField();
		panelLogin.add(textClave);
		textClave.setColumns(10);
		
		JLabel lblVacio = new JLabel(" ");
		panelLogin.add(lblVacio);
		
		JButton btnIngresar = new JButton("Ingresar");
		panelLogin.add(btnIngresar);
		
		JLabel lblVacio1 = new JLabel("");
		panelLogin.add(lblVacio1);
		
		JLabel lblNombreUsuario = new JLabel("");
		panelLogin.add(lblNombreUsuario);
		
		JPanel panelTitulo = new JPanel();
		panelSuperior.add(panelTitulo);
		panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblTitulo = new JLabel("Sistema Computador");
		panelTitulo.add(lblTitulo);
		
		JPanel panelCentro = new JPanel();
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelInferior = new JPanel();
		frame.getContentPane().add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	}*/

}
