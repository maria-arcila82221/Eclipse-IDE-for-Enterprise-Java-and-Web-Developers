package vistaGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*permite que esta clase escuche todo lo que pasa dentro de ella: lo que pasa con los objetos dentro de la clase*/
public class PanelPrincipal extends JPanel implements ActionListener {

	public PanelPrincipal() {

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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
